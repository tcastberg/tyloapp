package com.microsoft.windowsazure.messaging.notificationhubs;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/* loaded from: classes2.dex */
public final class FirebaseReceiver extends FirebaseMessagingService {
    private final NotificationHub mHub;

    public FirebaseReceiver() {
        this(NotificationHub.getInstance());
    }

    public FirebaseReceiver(NotificationHub notificationHub) {
        this.mHub = notificationHub;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mHub.registerApplication(getApplication());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        this.mHub.getInstanceListener().onPushNotificationReceived(getApplicationContext(), getNotificationMessage(remoteMessage));
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        this.mHub.setInstancePushChannel(str);
    }

    static BasicNotificationMessage getNotificationMessage(RemoteMessage remoteMessage) {
        String str;
        String str2;
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification != null) {
            str = notification.getTitle();
            str2 = notification.getBody();
        } else {
            str = null;
            str2 = null;
        }
        return new BasicNotificationMessage(str, str2, remoteMessage.getData());
    }
}
