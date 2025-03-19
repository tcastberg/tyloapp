package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzfi extends zzke implements zzlm {
    private static final zzfi zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzfi zzfiVar = new zzfi();
        zza = zzfiVar;
        zzke.zzbJ(zzfi.class, zzfiVar);
    }

    private zzfi() {
    }

    public final String zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzfi();
        }
        zzey zzeyVar = null;
        if (i2 == 4) {
            return new zzfh(zzeyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
