package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes.dex */
public final class zzki extends zzf {
    protected final zzkh zza;
    protected final zzkg zzb;
    protected final zzke zzc;
    private Handler zzd;

    zzki(zzfy zzfyVar) {
        super(zzfyVar);
        this.zza = new zzkh(this);
        this.zzb = new zzkg(this);
        this.zzc = new zzke(this);
    }

    static /* bridge */ /* synthetic */ void zzj(zzki zzkiVar, long j) {
        zzkiVar.zzg();
        zzkiVar.zzm();
        zzkiVar.zzs.zzay().zzj().zzb("Activity paused, time", Long.valueOf(j));
        zzkiVar.zzc.zza(j);
        if (zzkiVar.zzs.zzf().zzu()) {
            zzkiVar.zzb.zzb(j);
        }
    }

    static /* bridge */ /* synthetic */ void zzl(zzki zzkiVar, long j) {
        zzkiVar.zzg();
        zzkiVar.zzm();
        zzkiVar.zzs.zzay().zzj().zzb("Activity resumed, time", Long.valueOf(j));
        if (zzkiVar.zzs.zzf().zzu() || zzkiVar.zzs.zzm().zzl.zzb()) {
            zzkiVar.zzb.zzc(j);
        }
        zzkiVar.zzc.zzb();
        zzkh zzkhVar = zzkiVar.zza;
        zzkhVar.zza.zzg();
        if (zzkhVar.zza.zzs.zzJ()) {
            zzkhVar.zzb(zzkhVar.zza.zzs.zzav().currentTimeMillis(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new com.google.android.gms.internal.measurement.zzby(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }
}
