package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzgj extends zzke implements zzlm {
    private static final zzgj zza;
    private int zze;
    private int zzf;
    private zzkk zzg = zzbB();

    static {
        zzgj zzgjVar = new zzgj();
        zza = zzgjVar;
        zzke.zzbJ(zzgj.class, zzgjVar);
    }

    private zzgj() {
    }

    public static zzgi zzd() {
        return (zzgi) zza.zzbx();
    }

    static /* synthetic */ void zzg(zzgj zzgjVar, int i) {
        zzgjVar.zze |= 1;
        zzgjVar.zzf = i;
    }

    static /* synthetic */ void zzh(zzgj zzgjVar, Iterable iterable) {
        zzkk zzkkVar = zzgjVar.zzg;
        if (!zzkkVar.zzc()) {
            zzgjVar.zzg = zzke.zzbC(zzkkVar);
        }
        zzin.zzbt(iterable, zzgjVar.zzg);
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf;
    }

    public final long zzc(int i) {
        return this.zzg.zza(i);
    }

    public final List zzf() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zze & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgj();
        }
        zzfj zzfjVar = null;
        if (i2 == 4) {
            return new zzgi(zzfjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
