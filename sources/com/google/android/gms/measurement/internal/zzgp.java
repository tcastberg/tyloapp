package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
final class zzgp implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzgq zze;

    zzgp(zzgq zzgqVar, String str, String str2, String str3, long j) {
        this.zze = zzgqVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        String str = this.zza;
        if (str == null) {
            zzkzVar2 = this.zze.zza;
            zzkzVar2.zzR(this.zzb, null);
        } else {
            zzik zzikVar = new zzik(this.zzc, str, this.zzd);
            zzkzVar = this.zze.zza;
            zzkzVar.zzR(this.zzb, zzikVar);
        }
    }
}
