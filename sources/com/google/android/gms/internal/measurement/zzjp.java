package com.google.android.gms.internal.measurement;

import androidx.core.internal.view.SupportMenu;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes.dex */
final class zzjp {
    private final Object zza;
    private final int zzb;

    zzjp(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjp)) {
            return false;
        }
        zzjp zzjpVar = (zzjp) obj;
        return this.zza == zzjpVar.zza && this.zzb == zzjpVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
    }
}
