package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzfg {
    final zzfy zza;

    zzfg(zzkz zzkzVar) {
        this.zza = zzkzVar.zzq();
    }

    final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zzau());
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.zza.zzay().zzj().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.zza.zzay().zzj().zzb("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
