package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Header;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tech.gusavila92.apache.http.HttpHeaders;
import tech.gusavila92.apache.http.HttpStatus;

/* loaded from: classes2.dex */
public class NotificationHubInstallationAdapter implements InstallationAdapter {
    private static final long DEFAULT_INSTALLATION_EXPIRATION_MILLIS = 7776000000L;
    private static final String INSTALLATION_PUT_TAG = "installationPutRequest";
    private static final RetryPolicy sDoNotRetry = new DefaultRetryPolicy(1000, 0, 1.0f);
    private static final Set<Integer> sRetriableStatusCodes;
    private final ConnectionString mConnectionString;
    private final String mHubName;
    private final long mInstallationExpirationWindow;
    private ScheduledFuture<?> mOutstandingRetry;
    private final RequestQueue mRequestQueue;
    private final ScheduledExecutorService mScheduler;

    public NotificationHubInstallationAdapter(Context context, String str, String str2) {
        this(context, str, str2, DEFAULT_INSTALLATION_EXPIRATION_MILLIS);
    }

    NotificationHubInstallationAdapter(Context context, String str, String str2, long j) {
        this.mScheduler = Executors.newSingleThreadScheduledExecutor();
        this.mHubName = str;
        this.mConnectionString = ConnectionString.parse(str2);
        this.mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        this.mInstallationExpirationWindow = j;
    }

    static {
        HashSet hashSet = new HashSet();
        sRetriableStatusCodes = hashSet;
        hashSet.add(500);
        hashSet.add(503);
        hashSet.add(504);
        hashSet.add(403);
        hashSet.add(Integer.valueOf(HttpStatus.SC_REQUEST_TIMEOUT));
        hashSet.add(429);
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter
    public void saveInstallation(Installation installation, InstallationAdapter.Listener listener, InstallationAdapter.ErrorListener errorListener) {
        addExpiration(installation);
        cancelOutstandingUpdates();
        new RetrySession(installation, 3, listener, errorListener).submit();
    }

    void addExpiration(Installation installation) {
        if (installation.getExpiration() != null) {
            return;
        }
        installation.setExpiration(new Date(new Date().getTime() + this.mInstallationExpirationWindow));
    }

    void cancelOutstandingUpdates() {
        synchronized (this) {
            ScheduledFuture<?> scheduledFuture = this.mOutstandingRetry;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.mRequestQueue.cancelAll(INSTALLATION_PUT_TAG);
        }
    }

    static boolean isRetriable(VolleyError volleyError) {
        if ((volleyError instanceof NetworkError) || (volleyError instanceof TimeoutError)) {
            return true;
        }
        return volleyError.networkResponse != null && sRetriableStatusCodes.contains(Integer.valueOf(volleyError.networkResponse.statusCode));
    }

    private class RetrySession implements Response.ErrorListener, Response.Listener<JSONObject> {
        private final Installation mInstallation;
        private final int mMaxRetries;
        private final InstallationAdapter.ErrorListener mOnFailure;
        private final InstallationAdapter.Listener mOnSuccess;
        private int mRetry = 0;
        private final long mDefaultWaitTime = 1000;

        public RetrySession(Installation installation, int i, InstallationAdapter.Listener listener, InstallationAdapter.ErrorListener errorListener) {
            this.mMaxRetries = i;
            this.mInstallation = installation;
            this.mOnSuccess = listener;
            this.mOnFailure = errorListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void submit() {
            InstallationPutRequest installationPutRequest = new InstallationPutRequest(NotificationHubInstallationAdapter.this.mConnectionString, NotificationHubInstallationAdapter.this.mHubName, this.mInstallation, this, this);
            installationPutRequest.addMarker(NotificationHubInstallationAdapter.INSTALLATION_PUT_TAG);
            installationPutRequest.setRetryPolicy(NotificationHubInstallationAdapter.sDoNotRetry);
            synchronized (NotificationHubInstallationAdapter.this) {
                NotificationHubInstallationAdapter.this.mOutstandingRetry = null;
                NotificationHubInstallationAdapter.this.mRequestQueue.add(installationPutRequest);
            }
        }

        @Override // com.android.volley.Response.Listener
        public void onResponse(JSONObject jSONObject) {
            this.mOnSuccess.onInstallationSaved(this.mInstallation);
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            long j;
            this.mRetry++;
            if (!NotificationHubInstallationAdapter.isRetriable(volleyError) || this.mRetry > this.mMaxRetries) {
                this.mOnFailure.onInstallationSaveError(NotificationHubInstallationAdapter.convertVolleyException(volleyError));
                return;
            }
            NetworkResponse networkResponse = volleyError.networkResponse;
            String retryAfter = networkResponse != null ? NotificationHubInstallationAdapter.getRetryAfter(networkResponse) : null;
            if (networkResponse == null) {
                j = this.mDefaultWaitTime;
            } else if (retryAfter != null) {
                j = NotificationHubInstallationAdapter.parseRetryAfterValue(retryAfter);
            } else {
                j = (networkResponse.statusCode == 429 || networkResponse.statusCode == 403) ? 10000L : this.mDefaultWaitTime;
            }
            synchronized (NotificationHubInstallationAdapter.this) {
                NotificationHubInstallationAdapter notificationHubInstallationAdapter = NotificationHubInstallationAdapter.this;
                notificationHubInstallationAdapter.mOutstandingRetry = notificationHubInstallationAdapter.mScheduler.schedule(new Runnable() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.NotificationHubInstallationAdapter.RetrySession.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RetrySession.this.submit();
                    }
                }, j, TimeUnit.MILLISECONDS);
            }
        }
    }

    static Exception convertVolleyException(VolleyError volleyError) {
        if (volleyError instanceof AuthFailureError) {
            return new AuthorizationException((AuthFailureError) volleyError);
        }
        if (volleyError instanceof ClientError) {
            return new ClientException((ClientError) volleyError);
        }
        if (volleyError instanceof ServerError) {
            return new ServerException((ServerError) volleyError);
        }
        if (volleyError instanceof NetworkError) {
            return new IOException(volleyError.getMessage(), volleyError.getCause());
        }
        if (volleyError instanceof ParseError) {
            return new IOException(volleyError.getMessage(), volleyError.getCause());
        }
        if (volleyError instanceof TimeoutError) {
            return new IOException(volleyError.getMessage(), volleyError.getCause());
        }
        return new Exception(volleyError);
    }

    static String getRetryAfter(NetworkResponse networkResponse) {
        for (Header header : networkResponse.allHeaders) {
            if (header.getName().equalsIgnoreCase(HttpHeaders.RETRY_AFTER)) {
                return header.getValue();
            }
        }
        return null;
    }

    static long parseRetryAfterValue(String str) {
        try {
            return Long.parseLong(str) * 1000;
        } catch (NumberFormatException e) {
            throw new UnsupportedOperationException("Retry-After must be communicated as a number of seconds", e);
        }
    }
}
