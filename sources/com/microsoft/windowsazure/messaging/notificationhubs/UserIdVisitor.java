package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.windowsazure.messaging.R;

/* loaded from: classes2.dex */
class UserIdVisitor implements InstallationVisitor {
    private static final String PREFERENCE_KEY = "userId";
    private final SharedPreferences mPreferences;

    public UserIdVisitor(Context context) {
        this.mPreferences = context.getSharedPreferences(context.getString(R.string.installation_enrichment_file_key), 0);
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationVisitor
    public void visitInstallation(Installation installation) {
        installation.setUserId(getUserId());
    }

    public String getUserId() {
        return this.mPreferences.getString(PREFERENCE_KEY, null);
    }

    public boolean setUserId(String str) {
        if ((str == null || str.equals(getUserId())) && (str != null || getUserId() == null)) {
            return false;
        }
        this.mPreferences.edit().putString(PREFERENCE_KEY, str).apply();
        return true;
    }
}
