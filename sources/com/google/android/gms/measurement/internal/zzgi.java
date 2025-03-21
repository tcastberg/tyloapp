package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
final class zzgi implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgq zzb;

    zzgi(zzgq zzgqVar, zzq zzqVar) {
        this.zzb = zzgqVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkzVar = this.zzb.zza;
        zzkzVar.zzA();
        zzkzVar2 = this.zzb.zza;
        zzq zzqVar = this.zza;
        zzkzVar2.zzaz().zzg();
        zzkzVar2.zzB();
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzai zzb = zzai.zzb(zzqVar.zzv);
        zzai zzh = zzkzVar2.zzh(zzqVar.zza);
        zzkzVar2.zzay().zzj().zzc("Setting consent, package, consent", zzqVar.zza, zzb);
        zzkzVar2.zzV(zzqVar.zza, zzb);
        if (zzb.zzk(zzh)) {
            zzkzVar2.zzQ(zzqVar);
        }
    }
}
