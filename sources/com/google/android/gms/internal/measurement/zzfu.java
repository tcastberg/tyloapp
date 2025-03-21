package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzfu extends zzke implements zzlm {
    private static final zzfu zza;
    private int zze;
    private String zzf = "";
    private long zzg;

    static {
        zzfu zzfuVar = new zzfu();
        zza = zzfuVar;
        zzke.zzbJ(zzfu.class, zzfuVar);
    }

    private zzfu() {
    }

    public static zzft zza() {
        return (zzft) zza.zzbx();
    }

    static /* synthetic */ void zzc(zzfu zzfuVar, String str) {
        str.getClass();
        zzfuVar.zze |= 1;
        zzfuVar.zzf = str;
    }

    static /* synthetic */ void zzd(zzfu zzfuVar, long j) {
        zzfuVar.zze |= 2;
        zzfuVar.zzg = j;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzfu();
        }
        zzfj zzfjVar = null;
        if (i2 == 4) {
            return new zzft(zzfjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
