package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes.dex */
final class zzld implements zzlx {
    private static final zzlj zza = new zzlb();
    private final zzlj zzb;

    public zzld() {
        zzlj zzljVar;
        zzlj[] zzljVarArr = new zzlj[2];
        zzljVarArr[0] = zzjz.zza();
        try {
            zzljVar = (zzlj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzljVar = zza;
        }
        zzljVarArr[1] = zzljVar;
        zzlc zzlcVar = new zzlc(zzljVarArr);
        zzkm.zzf(zzlcVar, "messageInfoFactory");
        this.zzb = zzlcVar;
    }

    private static boolean zzb(zzli zzliVar) {
        return zzliVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final zzlw zza(Class cls) {
        zzly.zzG(cls);
        zzli zzb = this.zzb.zzb(cls);
        return zzb.zzb() ? zzke.class.isAssignableFrom(cls) ? zzlp.zzc(zzly.zzB(), zzjt.zzb(), zzb.zza()) : zzlp.zzc(zzly.zzz(), zzjt.zza(), zzb.zza()) : zzke.class.isAssignableFrom(cls) ? zzb(zzb) ? zzlo.zzl(cls, zzb, zzlr.zzb(), zzkz.zzd(), zzly.zzB(), zzjt.zzb(), zzlh.zzb()) : zzlo.zzl(cls, zzb, zzlr.zzb(), zzkz.zzd(), zzly.zzB(), null, zzlh.zzb()) : zzb(zzb) ? zzlo.zzl(cls, zzb, zzlr.zza(), zzkz.zzc(), zzly.zzz(), zzjt.zza(), zzlh.zza()) : zzlo.zzl(cls, zzb, zzlr.zza(), zzkz.zzc(), zzly.zzA(), null, zzlh.zza());
    }
}
