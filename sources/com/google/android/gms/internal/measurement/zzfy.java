package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzfy extends zzke implements zzlm {
    private static final zzfy zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzfm zzh;

    static {
        zzfy zzfyVar = new zzfy();
        zza = zzfyVar;
        zzke.zzbJ(zzfy.class, zzfyVar);
    }

    private zzfy() {
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzfy();
        }
        zzfj zzfjVar = null;
        if (i2 == 4) {
            return new zzfx(zzfjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
