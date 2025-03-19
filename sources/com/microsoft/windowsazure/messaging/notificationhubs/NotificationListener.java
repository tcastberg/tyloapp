package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.Context;

/* loaded from: classes2.dex */
public interface NotificationListener {
    void onPushNotificationReceived(Context context, NotificationMessage notificationMessage);
}
