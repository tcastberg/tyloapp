package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzoz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes.dex */
final class zzhx implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzai zzf;
    final /* synthetic */ zzid zzg;

    zzhx(zzid zzidVar, zzai zzaiVar, long j, int i, long j2, boolean z, zzai zzaiVar2) {
        this.zzg = zzidVar;
        this.zza = zzaiVar;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
        this.zzf = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzg.zzV(this.zza);
        this.zzg.zzL(this.zzb, false);
        zzid.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzoz.zzc();
        if (this.zzg.zzs.zzf().zzs(null, zzeb.zzas)) {
            zzid.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
