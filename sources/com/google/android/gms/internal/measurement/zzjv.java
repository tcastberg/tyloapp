package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes.dex */
final class zzjv {
    private static final zzjv zzb = new zzjv(true);
    final zzmj zza = new zzlz(16);
    private boolean zzc;
    private boolean zzd;

    private zzjv() {
    }

    public static zzjv zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.measurement.zzju r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zznd r0 = r2.zzb()
            com.google.android.gms.internal.measurement.zzkm.zze(r3)
            com.google.android.gms.internal.measurement.zznd r1 = com.google.android.gms.internal.measurement.zznd.DOUBLE
            com.google.android.gms.internal.measurement.zzne r1 = com.google.android.gms.internal.measurement.zzne.INT
            com.google.android.gms.internal.measurement.zzne r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzll
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzkq
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzkg
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.measurement.zznd r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzne r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjv.zzd(com.google.android.gms.internal.measurement.zzju, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjv zzjvVar = new zzjv();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzjvVar.zzc((zzju) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzjvVar.zzc((zzju) entry.getKey(), entry.getValue());
        }
        zzjvVar.zzd = this.zzd;
        return zzjvVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjv) {
            return this.zza.equals(((zzjv) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzju zzjuVar, Object obj) {
        if (!zzjuVar.zzc()) {
            zzd(zzjuVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzjuVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzkq) {
            this.zzd = true;
        }
        this.zza.put(zzjuVar, obj);
    }

    private zzjv(boolean z) {
        zzb();
        zzb();
    }
}
