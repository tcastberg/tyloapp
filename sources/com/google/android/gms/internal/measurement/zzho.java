package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes.dex */
public final class zzho {
    static volatile zzif zza = zzif.zzc();
    private static final Object zzb = new Object();

    /* JADX WARN: Can't wrap try/catch for region: R(11:18|(6:33|(2:35|(1:37))|27|28|29|30)(1:20)|21|22|23|24|(1:26)|27|28|29|30) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(android.content.Context r4, android.net.Uri r5) {
        /*
            java.lang.String r5 = r5.getAuthority()
            java.lang.String r0 = "com.google.android.gms.phenotype"
            boolean r0 = r0.equals(r5)
            r1 = 0
            if (r0 != 0) goto L1d
            java.lang.String r4 = "PhenotypeClientHelper"
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r0 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            java.lang.String r5 = r5.concat(r0)
            android.util.Log.e(r4, r5)
            return r1
        L1d:
            com.google.android.gms.internal.measurement.zzif r5 = com.google.android.gms.internal.measurement.zzho.zza
            boolean r5 = r5.zzb()
            if (r5 == 0) goto L32
            com.google.android.gms.internal.measurement.zzif r4 = com.google.android.gms.internal.measurement.zzho.zza
            java.lang.Object r4 = r4.zza()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            return r4
        L32:
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzho.zzb
            monitor-enter(r5)
            com.google.android.gms.internal.measurement.zzif r0 = com.google.android.gms.internal.measurement.zzho.zza     // Catch: java.lang.Throwable -> L9a
            boolean r0 = r0.zzb()     // Catch: java.lang.Throwable -> L9a
            if (r0 == 0) goto L4b
            com.google.android.gms.internal.measurement.zzif r4 = com.google.android.gms.internal.measurement.zzho.zza     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r4 = r4.zza()     // Catch: java.lang.Throwable -> L9a
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L9a
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L9a
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L9a
            return r4
        L4b:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r4.getPackageName()     // Catch: java.lang.Throwable -> L9a
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L9a
            if (r0 == 0) goto L58
            goto L71
        L58:
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r2 = "com.google.android.gms.phenotype"
            r3 = 268435456(0x10000000, float:2.524355E-29)
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r3)     // Catch: java.lang.Throwable -> L9a
            if (r0 == 0) goto L82
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Throwable -> L9a
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L9a
            if (r0 != 0) goto L71
            goto L82
        L71:
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L82 java.lang.Throwable -> L9a
            int r4 = r4.flags     // Catch: java.lang.Throwable -> L9a
            r4 = r4 & 129(0x81, float:1.81E-43)
            if (r4 == 0) goto L82
            r1 = 1
        L82:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L9a
            com.google.android.gms.internal.measurement.zzif r4 = com.google.android.gms.internal.measurement.zzif.zzd(r4)     // Catch: java.lang.Throwable -> L9a
            com.google.android.gms.internal.measurement.zzho.zza = r4     // Catch: java.lang.Throwable -> L9a
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L9a
            com.google.android.gms.internal.measurement.zzif r4 = com.google.android.gms.internal.measurement.zzho.zza
            java.lang.Object r4 = r4.zza()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            return r4
        L9a:
            r4 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L9a
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzho.zza(android.content.Context, android.net.Uri):boolean");
    }
}
