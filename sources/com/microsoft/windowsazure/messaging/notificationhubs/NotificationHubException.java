package com.microsoft.windowsazure.messaging.notificationhubs;

import com.android.volley.NetworkResponse;
import java.util.Map;

/* loaded from: classes2.dex */
public class NotificationHubException extends Exception {
    private final byte[] mResponseBody;
    private final Map<String, String> mResponseHeaders;
    private final int mResponseStatusCode;

    NotificationHubException(NetworkResponse networkResponse) {
        super("Azure Notification Hub request failed with status " + networkResponse.statusCode + ": " + new String(networkResponse.data));
        this.mResponseBody = networkResponse.data;
        this.mResponseStatusCode = networkResponse.statusCode;
        this.mResponseHeaders = networkResponse.headers;
    }

    public int getStatusCode() {
        return this.mResponseStatusCode;
    }

    public String getResponseBody() {
        return new String(this.mResponseBody);
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }
}
