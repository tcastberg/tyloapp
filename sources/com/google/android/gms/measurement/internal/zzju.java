package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzju extends zzkn {
    public final zzez zza;
    public final zzez zzb;
    public final zzez zzc;
    public final zzez zzd;
    public final zzez zze;
    private final Map zzg;

    zzju(zzkz zzkzVar) {
        super(zzkzVar);
        this.zzg = new HashMap();
        zzfd zzm = this.zzs.zzm();
        zzm.getClass();
        this.zza = new zzez(zzm, "last_delete_stale", 0L);
        zzfd zzm2 = this.zzs.zzm();
        zzm2.getClass();
        this.zzb = new zzez(zzm2, "backoff", 0L);
        zzfd zzm3 = this.zzs.zzm();
        zzm3.getClass();
        this.zzc = new zzez(zzm3, "last_upload", 0L);
        zzfd zzm4 = this.zzs.zzm();
        zzm4.getClass();
        this.zzd = new zzez(zzm4, "last_upload_attempt", 0L);
        zzfd zzm5 = this.zzs.zzm();
        zzm5.getClass();
        this.zze = new zzez(zzm5, "midnight_offset", 0L);
    }

    @Deprecated
    final Pair zza(String str) {
        zzjt zzjtVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        zzg();
        long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
        zzjt zzjtVar2 = (zzjt) this.zzg.get(str);
        if (zzjtVar2 != null && elapsedRealtime < zzjtVar2.zzc) {
            return new Pair(zzjtVar2.zza, Boolean.valueOf(zzjtVar2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzi = elapsedRealtime + this.zzs.zzf().zzi(str, zzeb.zza);
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzau());
        } catch (Exception e) {
            this.zzs.zzay().zzc().zzb("Unable to get advertising id", e);
            zzjtVar = new zzjt("", false, zzi);
        }
        if (advertisingIdInfo == null) {
            return new Pair("", false);
        }
        String id = advertisingIdInfo.getId();
        zzjtVar = id != null ? new zzjt(id, advertisingIdInfo.isLimitAdTrackingEnabled(), zzi) : new zzjt("", advertisingIdInfo.isLimitAdTrackingEnabled(), zzi);
        this.zzg.put(str, zzjtVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(zzjtVar.zza, Boolean.valueOf(zzjtVar.zzb));
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    protected final boolean zzb() {
        return false;
    }

    final Pair zzd(String str, zzai zzaiVar) {
        return zzaiVar.zzi(zzah.AD_STORAGE) ? zza(str) : new Pair("", false);
    }

    @Deprecated
    final String zzf(String str, boolean z) {
        zzg();
        String str2 = z ? (String) zza(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest zzF = zzlh.zzF();
        if (zzF == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzF.digest(str2.getBytes())));
    }
}
