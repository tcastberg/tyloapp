package com.microsoft.windowsazure.messaging.notificationhubs;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: classes2.dex */
class NotificationHubExtension {
    NotificationHubExtension() {
    }

    public static void fetchPushChannel(final NotificationHub notificationHub) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.NotificationHubExtension.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.e("ANH", "unable to fetch FirebaseInstanceId");
                } else {
                    NotificationHub.this.setInstancePushChannel(task.getResult());
                }
            }
        });
    }
}
