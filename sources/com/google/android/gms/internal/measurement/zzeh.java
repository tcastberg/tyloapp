package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzeh extends zzke implements zzlm {
    private static final zzeh zza;
    private int zze;
    private int zzf;
    private zzkl zzg = zzbD();
    private zzkl zzh = zzbD();
    private boolean zzi;
    private boolean zzj;

    static {
        zzeh zzehVar = new zzeh();
        zza = zzehVar;
        zzke.zzbJ(zzeh.class, zzehVar);
    }

    private zzeh() {
    }

    static /* synthetic */ void zzi(zzeh zzehVar, int i, zzes zzesVar) {
        zzesVar.getClass();
        zzkl zzklVar = zzehVar.zzg;
        if (!zzklVar.zzc()) {
            zzehVar.zzg = zzke.zzbE(zzklVar);
        }
        zzehVar.zzg.set(i, zzesVar);
    }

    static /* synthetic */ void zzj(zzeh zzehVar, int i, zzej zzejVar) {
        zzejVar.getClass();
        zzkl zzklVar = zzehVar.zzh;
        if (!zzklVar.zzc()) {
            zzehVar.zzh = zzke.zzbE(zzklVar);
        }
        zzehVar.zzh.set(i, zzejVar);
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zzh.size();
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final zzej zze(int i) {
        return (zzej) this.zzh.get(i);
    }

    public final zzes zzf(int i) {
        return (zzes) this.zzg.get(i);
    }

    public final List zzg() {
        return this.zzh;
    }

    public final List zzh() {
        return this.zzg;
    }

    public final boolean zzk() {
        return (this.zze & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", zzes.class, "zzh", zzej.class, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzeh();
        }
        zzef zzefVar = null;
        if (i2 == 4) {
            return new zzeg(zzefVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
