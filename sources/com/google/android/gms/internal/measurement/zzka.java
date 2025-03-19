package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzke;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes.dex */
public class zzka<MessageType extends zzke<MessageType, BuilderType>, BuilderType extends zzka<MessageType, BuilderType>> extends zzim<MessageType, BuilderType> {
    protected zzke zza;
    protected boolean zzb = false;
    private final zzke zzc;

    protected zzka(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzke) messagetype.zzl(4, null, null);
    }

    private static final void zza(zzke zzkeVar, zzke zzkeVar2) {
        zzlt.zza().zzb(zzkeVar.getClass()).zzg(zzkeVar, zzkeVar2);
    }

    @Override // com.google.android.gms.internal.measurement.zzim
    /* renamed from: zzaB, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzka zzau() {
        zzka zzkaVar = (zzka) this.zzc.zzl(5, null, null);
        zzkaVar.zzaC(zzaG());
        return zzkaVar;
    }

    public final zzka zzaC(zzke zzkeVar) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zza(this.zza, zzkeVar);
        return this;
    }

    public final zzka zzaD(byte[] bArr, int i, int i2, zzjq zzjqVar) throws zzko {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        try {
            zzlt.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i2, new zziq(zzjqVar));
            return this;
        } catch (zzko e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzko.zzf();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
    
        if (r3 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final MessageType zzaE() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.zzke r5 = r5.zzaG()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r5.zzl(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L19
            goto L38
        L19:
            if (r3 == 0) goto L39
            com.google.android.gms.internal.measurement.zzlt r3 = com.google.android.gms.internal.measurement.zzlt.zza()
            java.lang.Class r4 = r5.getClass()
            com.google.android.gms.internal.measurement.zzlw r3 = r3.zzb(r4)
            boolean r3 = r3.zzk(r5)
            if (r0 == 0) goto L36
            if (r1 == r3) goto L31
            r0 = r2
            goto L32
        L31:
            r0 = r5
        L32:
            r1 = 2
            r5.zzl(r1, r0, r2)
        L36:
            if (r3 == 0) goto L39
        L38:
            return r5
        L39:
            com.google.android.gms.internal.measurement.zzmm r0 = new com.google.android.gms.internal.measurement.zzmm
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.zzaE():com.google.android.gms.internal.measurement.zzke");
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    /* renamed from: zzaF, reason: merged with bridge method [inline-methods] */
    public MessageType zzaG() {
        if (this.zzb) {
            return (MessageType) this.zza;
        }
        zzke zzkeVar = this.zza;
        zzlt.zza().zzb(zzkeVar.getClass()).zzf(zzkeVar);
        this.zzb = true;
        return (MessageType) this.zza;
    }

    protected void zzaI() {
        zzke zzkeVar = (zzke) this.zza.zzl(4, null, null);
        zza(zzkeVar, this.zza);
        this.zza = zzkeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzim
    protected final /* synthetic */ zzim zzav(zzin zzinVar) {
        zzaC((zzke) zzinVar);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzim
    public final /* bridge */ /* synthetic */ zzim zzaw(byte[] bArr, int i, int i2) throws zzko {
        zzaD(bArr, 0, i2, zzjq.zza);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzim
    public final /* bridge */ /* synthetic */ zzim zzax(byte[] bArr, int i, int i2, zzjq zzjqVar) throws zzko {
        zzaD(bArr, 0, i2, zzjqVar);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzll zzbO() {
        return this.zzc;
    }
}
