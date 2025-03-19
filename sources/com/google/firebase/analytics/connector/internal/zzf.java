package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.1.1 */
/* loaded from: classes2.dex */
final class zzf implements AppMeasurementSdk.OnEventListener {
    final /* synthetic */ zzg zza;

    public zzf(zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzgz
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (str == null || str.equals(AppMeasurement.CRASH_ORIGIN) || !zzc.zzk(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle("params", bundle);
        analyticsConnectorListener = this.zza.zza;
        analyticsConnectorListener.onMessageTriggered(3, bundle2);
    }
}
