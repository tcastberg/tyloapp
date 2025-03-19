package com.microsoft.windowsazure.messaging.notificationhubs;

import com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter;

/* loaded from: classes2.dex */
public class PushChannelValidationAdapter implements InstallationAdapter {
    public static final int DEFAULT_MAX_RETRIES = 20;
    private final InstallationAdapter mDecoratedAdapter;
    private final int mMaxRetries;
    private int mRetryCount;

    public PushChannelValidationAdapter(InstallationAdapter installationAdapter) {
        this(installationAdapter, 20);
    }

    public PushChannelValidationAdapter(InstallationAdapter installationAdapter, int i) {
        this.mMaxRetries = i;
        this.mRetryCount = 0;
        this.mDecoratedAdapter = installationAdapter;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter
    public void saveInstallation(Installation installation, InstallationAdapter.Listener listener, InstallationAdapter.ErrorListener errorListener) {
        String pushChannel = installation.getPushChannel();
        if (pushChannel == null || pushChannel.isEmpty()) {
            int i = this.mRetryCount;
            this.mRetryCount = i + 1;
            if (i >= this.mMaxRetries) {
                this.mRetryCount = 0;
                errorListener.onInstallationSaveError(new IllegalArgumentException("After " + this.mRetryCount + " retry attempts, Installation does not have a PushChannel."));
                return;
            }
            return;
        }
        this.mRetryCount = 0;
        this.mDecoratedAdapter.saveInstallation(installation, listener, errorListener);
    }
}
