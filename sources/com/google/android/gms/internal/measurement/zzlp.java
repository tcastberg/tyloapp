package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes.dex */
final class zzlp implements zzlw {
    private final zzll zza;
    private final zzmn zzb;
    private final boolean zzc;
    private final zzjr zzd;

    private zzlp(zzmn zzmnVar, zzjr zzjrVar, zzll zzllVar) {
        this.zzb = zzmnVar;
        this.zzc = zzjrVar.zzc(zzllVar);
        this.zzd = zzjrVar;
        this.zza = zzllVar;
    }

    static zzlp zzc(zzmn zzmnVar, zzjr zzjrVar, zzll zzllVar) {
        return new zzlp(zzmnVar, zzjrVar, zzllVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zza(Object obj) {
        zzmn zzmnVar = this.zzb;
        int zzb = zzmnVar.zzb(zzmnVar.zzc(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzc(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final Object zze() {
        return this.zza.zzbF().zzaG();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzg(Object obj, Object obj2) {
        zzly.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzly.zzE(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zziq zziqVar) throws IOException {
        zzke zzkeVar = (zzke) obj;
        if (zzkeVar.zzc == zzmo.zzc()) {
            zzkeVar.zzc = zzmo.zze();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzi(Object obj, zznf zznfVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
