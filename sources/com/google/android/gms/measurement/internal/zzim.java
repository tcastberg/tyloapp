package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes.dex */
final class zzim implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzik zzb;
    final /* synthetic */ zzik zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzis zze;

    zzim(zzis zzisVar, Bundle bundle, zzik zzikVar, zzik zzikVar2, long j) {
        this.zze = zzisVar;
        this.zza = bundle;
        this.zzb = zzikVar;
        this.zzc = zzikVar2;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzis.zzp(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
