package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzat implements Iterable, zzap {
    private final String zza;

    public zzat(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0334  */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55, types: [int] */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r21v0, types: [java.lang.Object, java.lang.String] */
    @Override // com.google.android.gms.internal.measurement.zzap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzap zzbN(java.lang.String r21, com.google.android.gms.internal.measurement.zzg r22, java.util.List r23) {
        /*
            Method dump skipped, instructions count: 1764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzat.zzbN(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzar(this);
    }
}
