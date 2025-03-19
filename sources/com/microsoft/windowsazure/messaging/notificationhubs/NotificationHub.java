package com.microsoft.windowsazure.messaging.notificationhubs;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Log;
import com.microsoft.windowsazure.messaging.R;
import com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter;
import com.microsoft.windowsazure.messaging.notificationhubs.NetworkStateHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class NotificationHub {
    private static final String IS_ENABLED_PREFERENCE_KEY = "isEnabled";
    private static NotificationHub sInstance;
    private InstallationAdapter mAdapter;
    private Application mApplication;
    private IdAssignmentVisitor mIdAssignmentVisitor;
    private NotificationListener mListener;
    private PlatformVisitor mPlatformVisitor;
    private SharedPreferences mPreferences;
    private PushChannelVisitor mPushChannelVisitor;
    private TagVisitor mTagVisitor;
    private TemplateVisitor mTemplateVisitor;
    private UserIdVisitor mUserIdVisitor;
    private final List<InstallationVisitor> mVisitors = new ArrayList();
    private InstallationAdapter.ErrorListener mOnInstallationFailure = new InstallationAdapter.ErrorListener() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.NotificationHub.1
        @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter.ErrorListener
        public void onInstallationSaveError(Exception exc) {
            Log.e("ANH", "unable to save installation: " + exc.toString());
        }
    };
    private InstallationAdapter.Listener mOnSavedInstallation = new InstallationAdapter.Listener() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.NotificationHub.2
        @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter.Listener
        public void onInstallationSaved(Installation installation) {
            Log.i("ANH", "updated installation");
        }
    };

    static void checkLaunchedFromNotification(Activity activity, Intent intent) {
    }

    NotificationHub() {
    }

    public static synchronized NotificationHub getInstance() {
        NotificationHub notificationHub;
        synchronized (NotificationHub.class) {
            if (sInstance == null) {
                sInstance = new NotificationHub();
            }
            notificationHub = sInstance;
        }
        return notificationHub;
    }

    synchronized void registerApplication(Application application) {
        if (this.mApplication == application) {
            return;
        }
        this.mApplication = application;
        this.mPreferences = application.getSharedPreferences(application.getString(R.string.installation_enrichment_file_key), 0);
        IdAssignmentVisitor idAssignmentVisitor = new IdAssignmentVisitor(this.mApplication);
        this.mIdAssignmentVisitor = idAssignmentVisitor;
        useInstanceVisitor(idAssignmentVisitor);
        TagVisitor tagVisitor = new TagVisitor(this.mApplication);
        this.mTagVisitor = tagVisitor;
        useInstanceVisitor(tagVisitor);
        TemplateVisitor templateVisitor = new TemplateVisitor(this.mApplication);
        this.mTemplateVisitor = templateVisitor;
        useInstanceVisitor(templateVisitor);
        PushChannelVisitor pushChannelVisitor = new PushChannelVisitor(this.mApplication);
        this.mPushChannelVisitor = pushChannelVisitor;
        useInstanceVisitor(pushChannelVisitor);
        PlatformVisitor platformVisitor = new PlatformVisitor(this.mApplication);
        this.mPlatformVisitor = platformVisitor;
        useInstanceVisitor(platformVisitor);
        UserIdVisitor userIdVisitor = new UserIdVisitor(this.mApplication);
        this.mUserIdVisitor = userIdVisitor;
        useInstanceVisitor(userIdVisitor);
        NotificationHubExtension.fetchPushChannel(this);
    }

    public static void start(Application application, String str, String str2) {
        start(application, new PushChannelValidationAdapter(new DebounceInstallationAdapter(application, new NotificationHubInstallationAdapter(application, str, str2))));
    }

    public static void start(Application application, InstallationAdapter installationAdapter) {
        NotificationHub notificationHub = getInstance();
        notificationHub.mAdapter = installationAdapter;
        notificationHub.registerApplication(application);
        new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE").addAction("android.intent.action.AIRPLANE_MODE");
        NetworkStateHelper.getSharedInstance(application).addListener(new NetworkStateHelper.Listener() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.NotificationHub.3
            @Override // com.microsoft.windowsazure.messaging.notificationhubs.NetworkStateHelper.Listener
            public void onNetworkStateUpdated(boolean z) {
                if (z) {
                    NotificationHub.this.beginInstanceInstallationUpdate();
                }
            }
        });
    }

    public static void setListener(NotificationListener notificationListener) {
        getInstance().setInstanceListener(notificationListener);
    }

    public void setInstanceListener(NotificationListener notificationListener) {
        this.mListener = notificationListener;
    }

    NotificationListener getInstanceListener() {
        return this.mListener;
    }

    public static void setInstallationSavedListener(InstallationAdapter.Listener listener) {
        getInstance().setInstanceInstallationSavedListener(listener);
    }

    public void setInstanceInstallationSavedListener(InstallationAdapter.Listener listener) {
        this.mOnSavedInstallation = listener;
    }

    public static void setInstallationSaveFailureListener(InstallationAdapter.ErrorListener errorListener) {
        getInstance().setInstanceInstallationSaveFailureListener(errorListener);
    }

    public void setInstanceInstallationSaveFailureListener(InstallationAdapter.ErrorListener errorListener) {
        this.mOnInstallationFailure = errorListener;
    }

    public static void useVisitor(InstallationVisitor installationVisitor) {
        getInstance().useInstanceVisitor(installationVisitor);
    }

    public void useInstanceVisitor(InstallationVisitor installationVisitor) {
        this.mVisitors.add(installationVisitor);
    }

    public static void beginInstallationUpdate() {
        getInstance().beginInstanceInstallationUpdate();
    }

    public void beginInstanceInstallationUpdate() {
        if (isInstanceEnabled()) {
            Installation installation = new Installation();
            Iterator<InstallationVisitor> it = this.mVisitors.iterator();
            while (it.hasNext()) {
                it.next().visitInstallation(installation);
            }
            InstallationAdapter installationAdapter = this.mAdapter;
            if (installationAdapter != null) {
                installationAdapter.saveInstallation(installation, this.mOnSavedInstallation, this.mOnInstallationFailure);
            }
        }
    }

    static void setPushChannel(String str) {
        getInstance().setInstancePushChannel(str);
    }

    public static String getPushChannel() {
        return getInstance().getInstancePushChannel();
    }

    void setInstancePushChannel(String str) {
        if (str.equals(this.mPushChannelVisitor.getPushChannel())) {
            return;
        }
        this.mPushChannelVisitor.setPushChannel(str);
        beginInstanceInstallationUpdate();
    }

    public String getInstancePushChannel() {
        return this.mPushChannelVisitor.getPushChannel();
    }

    public static void setPlatform(String str) {
        getInstance().setInstancePlatform(str);
    }

    public static String getPlatform() {
        return getInstance().getInstancePlatform();
    }

    void setInstancePlatform(String str) {
        if (str.equals(this.mPlatformVisitor.getPlatform())) {
            return;
        }
        this.mPlatformVisitor.setPlatform(str);
        beginInstanceInstallationUpdate();
    }

    public String getInstancePlatform() {
        return this.mPlatformVisitor.getPlatform();
    }

    public static String getInstallationId() {
        return getInstance().getInstanceInstallationId();
    }

    public String getInstanceInstallationId() {
        return this.mIdAssignmentVisitor.getInstallationId();
    }

    public static void setInstallationId(String str) {
        getInstance().setInstanceInstallationId(str);
    }

    public void setInstanceInstallationId(String str) {
        if (str.equals(this.mIdAssignmentVisitor.getInstallationId())) {
            return;
        }
        this.mIdAssignmentVisitor.setInstallationId(str);
        beginInstanceInstallationUpdate();
    }

    public static boolean addTag(String str) {
        return getInstance().addInstanceTag(str);
    }

    public boolean addInstanceTag(String str) {
        if (!this.mTagVisitor.addTag(str)) {
            return false;
        }
        beginInstanceInstallationUpdate();
        return true;
    }

    public static boolean addTags(Collection<? extends String> collection) {
        return getInstance().addInstanceTags(collection);
    }

    public boolean addInstanceTags(Collection<? extends String> collection) {
        if (!this.mTagVisitor.addTags(collection)) {
            return false;
        }
        beginInstanceInstallationUpdate();
        return true;
    }

    public static boolean removeTag(String str) {
        return getInstance().removeInstanceTag(str);
    }

    public boolean removeInstanceTag(String str) {
        if (!this.mTagVisitor.removeTag(str)) {
            return false;
        }
        beginInstanceInstallationUpdate();
        return true;
    }

    public static boolean removeTags(Collection<? extends String> collection) {
        return getInstance().removeInstanceTags(collection);
    }

    public boolean removeInstanceTags(Collection<? extends String> collection) {
        if (!this.mTagVisitor.removeTags(collection)) {
            return false;
        }
        beginInstanceInstallationUpdate();
        return true;
    }

    public static Iterable<String> getTags() {
        return getInstance().getInstanceTags();
    }

    public Iterable<String> getInstanceTags() {
        return this.mTagVisitor.getTags();
    }

    public static void clearTags() {
        getInstance().clearInstanceTags();
    }

    public void clearInstanceTags() {
        if (this.mTagVisitor.getTags().iterator().hasNext()) {
            this.mTagVisitor.clearTags();
            beginInstanceInstallationUpdate();
        }
    }

    public static void setEnabled(boolean z) {
        getInstance().setInstanceEnabled(z);
    }

    public void setInstanceEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(IS_ENABLED_PREFERENCE_KEY, z).apply();
        if (z) {
            beginInstanceInstallationUpdate();
        }
    }

    public static boolean isEnabled() {
        return getInstance().isInstanceEnabled();
    }

    public boolean isInstanceEnabled() {
        return this.mPreferences.getBoolean(IS_ENABLED_PREFERENCE_KEY, true);
    }

    public static void setTemplate(String str, InstallationTemplate installationTemplate) {
        getInstance().setInstanceTemplate(str, installationTemplate);
    }

    public void setInstanceTemplate(String str, InstallationTemplate installationTemplate) {
        this.mTemplateVisitor.setTemplate(str, installationTemplate);
        beginInstanceInstallationUpdate();
    }

    public static boolean removeTemplate(String str) {
        return getInstance().removeInstanceTemplate(str);
    }

    public boolean removeInstanceTemplate(String str) {
        if (!this.mTemplateVisitor.removeTemplate(str)) {
            return false;
        }
        beginInstanceInstallationUpdate();
        return true;
    }

    public static InstallationTemplate getTemplate(String str) {
        return getInstance().getInstanceTemplate(str);
    }

    public InstallationTemplate getInstanceTemplate(String str) {
        return this.mTemplateVisitor.getTemplate(str);
    }

    public static boolean setUserId(String str) {
        return getInstance().setInstanceUserId(str);
    }

    public boolean setInstanceUserId(String str) {
        if (!this.mUserIdVisitor.setUserId(str)) {
            return false;
        }
        beginInstanceInstallationUpdate();
        return true;
    }

    public static String getUserId() {
        return getInstance().getInstanceUserId();
    }

    public String getInstanceUserId() {
        return this.mUserIdVisitor.getUserId();
    }
}
