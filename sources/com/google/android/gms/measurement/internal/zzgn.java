package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
final class zzgn implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgq zzb;

    zzgn(zzgq zzgqVar, String str) {
        this.zzb = zzgqVar;
        this.zza = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkzVar = this.zzb.zza;
        zzkzVar.zzA();
        zzkzVar2 = this.zzb.zza;
        return zzkzVar2.zzi().zzu(this.zza);
    }
}
