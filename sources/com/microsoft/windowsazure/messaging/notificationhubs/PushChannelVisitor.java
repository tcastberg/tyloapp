package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.windowsazure.messaging.R;

/* loaded from: classes2.dex */
public class PushChannelVisitor implements InstallationVisitor {
    private static final String PREFERENCE_KEY = "pushChannel";
    private final SharedPreferences mPreferences;

    public PushChannelVisitor(Context context) {
        this.mPreferences = context.getSharedPreferences(context.getString(R.string.installation_enrichment_file_key), 0);
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationVisitor
    public void visitInstallation(Installation installation) {
        installation.setPushChannel(getPushChannel());
    }

    public void setPushChannel(String str) {
        this.mPreferences.edit().putString(PREFERENCE_KEY, str).apply();
    }

    public String getPushChannel() {
        return this.mPreferences.getString(PREFERENCE_KEY, null);
    }
}
