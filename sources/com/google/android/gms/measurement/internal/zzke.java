package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes.dex */
final class zzke {
    final /* synthetic */ zzki zza;
    private zzkd zzb;

    zzke(zzki zzkiVar) {
        this.zza = zzkiVar;
    }

    final void zza(long j) {
        Handler handler;
        this.zzb = new zzkd(this, this.zza.zzs.zzav().currentTimeMillis(), j);
        handler = this.zza.zzd;
        handler.postDelayed(this.zzb, 2000L);
    }

    final void zzb() {
        Handler handler;
        this.zza.zzg();
        zzkd zzkdVar = this.zzb;
        if (zzkdVar != null) {
            handler = this.zza.zzd;
            handler.removeCallbacks(zzkdVar);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
