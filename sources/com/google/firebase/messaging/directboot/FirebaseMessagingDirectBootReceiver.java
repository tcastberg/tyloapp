package com.google.firebase.messaging.directboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging-directboot@@20.2.0 */
/* loaded from: classes2.dex */
public final class FirebaseMessagingDirectBootReceiver extends WakefulBroadcastReceiver {
    private final ExecutorService zza = com.google.android.gms.internal.firebase_messaging.zza.zza().zza(new NamedThreadFactory("fcm-db-intent-handle"), zzf.zza);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if (!FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction())) {
            String valueOf = String.valueOf(intent.getAction());
            Log.d(FirebaseMessaging.INSTANCE_ID_SCOPE, valueOf.length() != 0 ? "Unexpected intent: ".concat(valueOf) : new String("Unexpected intent: "));
            return;
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        final boolean isOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        new com.google.firebase.iid.zza(context, this.zza).zza(intent).addOnCompleteListener(this.zza, new OnCompleteListener(isOrderedBroadcast, goAsync) { // from class: com.google.firebase.messaging.directboot.zza
            private final boolean zza;
            private final BroadcastReceiver.PendingResult zzb;

            {
                this.zza = isOrderedBroadcast;
                this.zzb = goAsync;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseMessagingDirectBootReceiver.zza(this.zza, this.zzb, task);
            }
        });
    }

    static final /* synthetic */ void zza(boolean z, BroadcastReceiver.PendingResult pendingResult, Task task) {
        if (z) {
            pendingResult.setResultCode(task.isSuccessful() ? ((Integer) task.getResult()).intValue() : 500);
        }
        pendingResult.finish();
    }
}
