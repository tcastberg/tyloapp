package com.google.android.gms.common.internal;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public final class zab {
    public final Set zaa;

    public zab(Set set) {
        Preconditions.checkNotNull(set);
        this.zaa = Collections.unmodifiableSet(set);
    }
}
