package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzgo extends zzke implements zzlm {
    private static final zzgo zza;
    private zzkl zze = zzbD();

    static {
        zzgo zzgoVar = new zzgo();
        zza = zzgoVar;
        zzke.zzbJ(zzgo.class, zzgoVar);
    }

    private zzgo() {
    }

    public static zzgo zzc() {
        return zza;
    }

    public final int zza() {
        return this.zze.size();
    }

    public final List zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzgq.class});
        }
        if (i2 == 3) {
            return new zzgo();
        }
        zzgm zzgmVar = null;
        if (i2 == 4) {
            return new zzgn(zzgmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
