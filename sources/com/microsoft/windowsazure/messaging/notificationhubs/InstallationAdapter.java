package com.microsoft.windowsazure.messaging.notificationhubs;

/* loaded from: classes2.dex */
public interface InstallationAdapter {

    public interface ErrorListener {
        void onInstallationSaveError(Exception exc);
    }

    public interface Listener {
        void onInstallationSaved(Installation installation);
    }

    void saveInstallation(Installation installation, Listener listener, ErrorListener errorListener);
}
