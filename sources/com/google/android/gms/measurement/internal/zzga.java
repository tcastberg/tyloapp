package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
final class zzga implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgq zzc;

    zzga(zzgq zzgqVar, zzac zzacVar, zzq zzqVar) {
        this.zzc = zzgqVar;
        this.zza = zzacVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkz zzkzVar3;
        zzkzVar = this.zzc.zza;
        zzkzVar.zzA();
        if (this.zza.zzc.zza() == null) {
            zzkzVar3 = this.zzc.zza;
            zzkzVar3.zzO(this.zza, this.zzb);
        } else {
            zzkzVar2 = this.zzc.zza;
            zzkzVar2.zzU(this.zza, this.zzb);
        }
    }
}
