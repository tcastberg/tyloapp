package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.windowsazure.messaging.R;
import com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DebounceInstallationAdapter implements InstallationAdapter {
    private static final long DEFAULT_DEBOUNCE_INTERVAL = 2000;
    private static final long DEFAULT_INSTALLATION_STALE_MILLIS = 86400000;
    static final String LAST_ACCEPTED_HASH_KEY = "lastAcceptedHash";
    static final String LAST_ACCEPTED_TIMESTAMP_KEY = "lastAcceptedTimestamp";
    private InstallationAdapter mInstallationAdapter;
    private long mInstallationStaleMillis;
    private long mInterval;
    private SharedPreferences mPreferences;
    private ScheduledFuture<?> mSchedFuture;
    private final ScheduledExecutorService mScheduler;

    public DebounceInstallationAdapter(Context context, InstallationAdapter installationAdapter) {
        this(context, installationAdapter, DEFAULT_DEBOUNCE_INTERVAL);
    }

    public DebounceInstallationAdapter(Context context, InstallationAdapter installationAdapter, long j) {
        this(installationAdapter, j, context.getSharedPreferences(context.getString(R.string.installation_enrichment_file_key), 4));
    }

    DebounceInstallationAdapter(InstallationAdapter installationAdapter, long j, SharedPreferences sharedPreferences) {
        this.mScheduler = Executors.newScheduledThreadPool(1);
        this.mInstallationAdapter = installationAdapter;
        this.mInterval = j;
        this.mInstallationStaleMillis = DEFAULT_INSTALLATION_STALE_MILLIS;
        this.mPreferences = sharedPreferences;
    }

    void setInstallationStaleWindow(long j) {
        this.mInstallationStaleMillis = j;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter
    public synchronized void saveInstallation(final Installation installation, final InstallationAdapter.Listener listener, final InstallationAdapter.ErrorListener errorListener) {
        ScheduledFuture<?> scheduledFuture = this.mSchedFuture;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.mSchedFuture.cancel(true);
        }
        final int hashCode = installation.hashCode();
        int lastAcceptedHash = getLastAcceptedHash();
        boolean z = lastAcceptedHash != 0 && lastAcceptedHash == hashCode;
        final long time = new Date().getTime();
        boolean z2 = time < getLastAcceptedTimestamp() + this.mInstallationStaleMillis;
        if (z && z2) {
            return;
        }
        this.mSchedFuture = this.mScheduler.schedule(new Runnable() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.DebounceInstallationAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DebounceInstallationAdapter.this.mInstallationAdapter.saveInstallation(installation, new InstallationAdapter.Listener() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.DebounceInstallationAdapter.1.1
                        @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter.Listener
                        public void onInstallationSaved(Installation installation2) {
                            DebounceInstallationAdapter.this.mPreferences.edit().putInt(DebounceInstallationAdapter.LAST_ACCEPTED_HASH_KEY, hashCode).apply();
                            DebounceInstallationAdapter.this.mPreferences.edit().putLong(DebounceInstallationAdapter.LAST_ACCEPTED_TIMESTAMP_KEY, time).apply();
                            listener.onInstallationSaved(installation2);
                        }
                    }, errorListener);
                } catch (Exception e) {
                    errorListener.onInstallationSaveError(e);
                }
            }
        }, this.mInterval, TimeUnit.MILLISECONDS);
    }

    private long getLastAcceptedTimestamp() {
        return this.mPreferences.getLong(LAST_ACCEPTED_TIMESTAMP_KEY, Long.MIN_VALUE);
    }

    private int getLastAcceptedHash() {
        return this.mPreferences.getInt(LAST_ACCEPTED_HASH_KEY, 0);
    }
}
