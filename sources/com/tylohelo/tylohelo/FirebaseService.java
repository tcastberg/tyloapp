package com.tylohelo.tylohelo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.microsoft.windowsazure.messaging.NotificationHub;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class FirebaseService extends FirebaseMessagingService {
    public static final String NOTIFICATION_CHANNEL_DESCRIPTION = "Notification Hubs Tylo Channel";
    public static final String NOTIFICATION_CHANNEL_ID = "nh-tylo-channel-id";
    public static final String NOTIFICATION_CHANNEL_NAME = "Notification Hubs Tylo Channel";
    private static String fcmToken = null;
    public static int notificationId = 1;

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        Log.d("FirebaseService", "From: " + remoteMessage.getFrom());
        if (remoteMessage.getNotification() != null) {
            str = remoteMessage.getNotification().getBody();
        } else {
            String str2 = remoteMessage.getData().get("body");
            if (str2 == null) {
                Iterator<String> it = remoteMessage.getData().values().iterator();
                if (!it.hasNext()) {
                    str = "No message";
                } else {
                    str = it.next();
                }
            } else {
                str = str2;
            }
        }
        if (tyloApplication.getIsVisible().booleanValue()) {
            return;
        }
        sendNotification(str);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(new OnSuccessListener() { // from class: com.tylohelo.tylohelo.FirebaseService$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseService.this.m291lambda$onNewToken$1$comtylohelotyloheloFirebaseService((String) obj);
            }
        });
    }

    /* renamed from: lambda$onNewToken$1$com-tylohelo-tylohelo-FirebaseService, reason: not valid java name */
    /* synthetic */ void m291lambda$onNewToken$1$comtylohelotyloheloFirebaseService(final String str) {
        new Thread(new Runnable() { // from class: com.tylohelo.tylohelo.FirebaseService$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseService.this.m290lambda$onNewToken$0$comtylohelotyloheloFirebaseService(str);
            }
        }).start();
    }

    /* renamed from: lambda$onNewToken$0$com-tylohelo-tylohelo-FirebaseService, reason: not valid java name */
    /* synthetic */ void m290lambda$onNewToken$0$comtylohelotyloheloFirebaseService(String str) {
        NotificationHub notificationHub;
        try {
            NotificationHub notificationHub2 = tyloApplication.getNotificationHub();
            fcmToken = str;
            if (notificationHub2 == null) {
                if (CloudService.isDebug()) {
                    notificationHub = new NotificationHub(NotificationSettings.HubNameDev, NotificationSettings.HubListenConnectionStringDev, getApplicationContext());
                } else {
                    notificationHub = new NotificationHub(BuildConfig.HUB_NAME, BuildConfig.HUB_URL, getApplicationContext());
                }
                notificationHub2 = notificationHub;
                tyloApplication.setNotificationHub(notificationHub2);
            }
            registerForAll(notificationHub2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendNotification(String str) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) MainActivity.class);
        intent.addFlags(67108864);
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        PendingIntent activity = PendingIntent.getActivity(getApplicationContext(), 0, intent, 33554432);
        NotificationCompat.Builder badgeIconType = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID).setContentText(str).setPriority(1).setBadgeIconType(1);
        String packageName = getPackageName();
        if (packageName.equals(BuildConfig.APPLICATION_ID)) {
            badgeIconType.setSmallIcon(R.drawable.ic_notification_foreground);
        } else if (packageName.equals("com.tylohelo.helo")) {
            badgeIconType.setSmallIcon(R.drawable.ic_notification_helo);
        }
        badgeIconType.setContentIntent(activity);
        notificationManager.notify(notificationId, badgeIconType.build());
        notificationId++;
    }

    public static void createChannelAndHandleNotifications(final Context context) {
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notification Hubs Tylo Channel", 4);
        notificationChannel.setDescription("Notification Hubs Tylo Channel");
        notificationChannel.setShowBadge(true);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.tylohelo.tylohelo.FirebaseService$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseService.lambda$createChannelAndHandleNotifications$3(context, task);
            }
        });
    }

    static /* synthetic */ void lambda$createChannelAndHandleNotifications$3(final Context context, Task task) {
        if (task.isSuccessful()) {
            fcmToken = (String) task.getResult();
            new Thread(new Runnable() { // from class: com.tylohelo.tylohelo.FirebaseService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseService.lambda$createChannelAndHandleNotifications$2(context);
                }
            }).start();
        }
    }

    static /* synthetic */ void lambda$createChannelAndHandleNotifications$2(Context context) {
        try {
            NotificationHub notificationHub = tyloApplication.getNotificationHub();
            if (notificationHub == null) {
                if (CloudService.isDebug()) {
                    notificationHub = new NotificationHub(NotificationSettings.HubNameDev, NotificationSettings.HubListenConnectionStringDev, context);
                } else {
                    notificationHub = new NotificationHub(BuildConfig.HUB_NAME, BuildConfig.HUB_URL, context);
                }
                tyloApplication.setNotificationHub(notificationHub);
            }
            registerForAll(notificationHub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerSaunas() {
        new Thread(new Runnable() { // from class: com.tylohelo.tylohelo.FirebaseService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseService.lambda$registerSaunas$4();
            }
        }).start();
    }

    static /* synthetic */ void lambda$registerSaunas$4() {
        try {
            NotificationHub notificationHub = tyloApplication.getNotificationHub();
            if (notificationHub == null || fcmToken == null) {
                return;
            }
            registerForAll(notificationHub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void registerForAll(NotificationHub notificationHub) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(new FragmentActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        HashMap<String, SaunaModel> saunaListStored = saunaService.getSaunaListStored();
        if (saunaListStored != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, SaunaModel> entry : saunaListStored.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue().getAPIKey() != null) {
                    arrayList.add(key);
                }
            }
            if (arrayList.size() > 0) {
                try {
                    notificationHub.register(fcmToken, (String[]) arrayList.toArray(new String[0])).getRegistrationId();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void unregisterSaunas() {
        new Thread(new Runnable() { // from class: com.tylohelo.tylohelo.FirebaseService$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseService.lambda$unregisterSaunas$5();
            }
        }).start();
    }

    static /* synthetic */ void lambda$unregisterSaunas$5() {
        String str;
        try {
            NotificationHub notificationHub = tyloApplication.getNotificationHub();
            if (notificationHub == null || (str = fcmToken) == null) {
                return;
            }
            notificationHub.unregisterAll(str);
            registerForAll(notificationHub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
