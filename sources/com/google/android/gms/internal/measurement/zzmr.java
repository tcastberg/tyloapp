package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes.dex */
final class zzmr implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzms zzb;

    zzmr(zzms zzmsVar) {
        zzkt zzktVar;
        this.zzb = zzmsVar;
        zzktVar = zzmsVar.zza;
        this.zza = zzktVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
