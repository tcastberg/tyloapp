package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
final class zzjx implements Runnable {
    final /* synthetic */ zzkz zza;
    final /* synthetic */ Runnable zzb;

    zzjx(zzjz zzjzVar, zzkz zzkzVar, Runnable runnable) {
        this.zza = zzkzVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzX();
    }
}
