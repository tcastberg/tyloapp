package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.windowsazure.messaging.R;
import java.util.UUID;

/* loaded from: classes2.dex */
class IdAssignmentVisitor implements InstallationVisitor {
    private static final String PREFERENCE_KEY = "installationId";
    private final SharedPreferences mPreferences;

    public IdAssignmentVisitor(Context context) {
        this.mPreferences = context.getSharedPreferences(context.getString(R.string.installation_enrichment_file_key), 0);
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationVisitor
    public void visitInstallation(Installation installation) {
        if (installation.getInstallationId() == null) {
            String installationId = getInstallationId();
            if (installationId == null) {
                installationId = UUID.randomUUID().toString();
                setInstallationId(installationId);
            }
            installation.setInstallationId(installationId);
        }
    }

    public String getInstallationId() {
        return this.mPreferences.getString(PREFERENCE_KEY, null);
    }

    public void setInstallationId(String str) {
        this.mPreferences.edit().putString(PREFERENCE_KEY, str).apply();
    }
}
