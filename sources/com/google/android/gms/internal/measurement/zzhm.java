package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes.dex */
final class zzhm implements zzhj {
    private static zzhm zza;

    @Nullable
    private final Context zzb;

    @Nullable
    private final ContentObserver zzc;

    private zzhm() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzhm(Context context) {
        this.zzb = context;
        zzhl zzhlVar = new zzhl(this, null);
        this.zzc = zzhlVar;
        context.getContentResolver().registerContentObserver(zzgz.zza, true, zzhlVar);
    }

    static zzhm zza(Context context) {
        zzhm zzhmVar;
        synchronized (zzhm.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhm(context) : new zzhm();
            }
            zzhmVar = zza;
        }
        return zzhmVar;
    }

    static synchronized void zze() {
        Context context;
        synchronized (zzhm.class) {
            zzhm zzhmVar = zza;
            if (zzhmVar != null && (context = zzhmVar.zzb) != null && zzhmVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhj
    @Nullable
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zzb(final String str) {
        Context context = this.zzb;
        if (context != null && !zzha.zza(context)) {
            try {
                return (String) zzhh.zza(new zzhi() { // from class: com.google.android.gms.internal.measurement.zzhk
                    @Override // com.google.android.gms.internal.measurement.zzhi
                    public final Object zza() {
                        return zzhm.this.zzd(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            }
        }
        return null;
    }

    final /* synthetic */ String zzd(String str) {
        return zzgz.zza(this.zzb.getContentResolver(), str, null);
    }
}
