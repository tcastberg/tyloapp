package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes.dex */
public final class zzhe implements zzhj {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private final Object zzg;
    private volatile Map zzh;
    private final List zzi;
    private static final Map zzb = new ArrayMap();
    public static final String[] zza = {"key", "value"};

    private zzhe(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhd zzhdVar = new zzhd(this, null);
        this.zzf = zzhdVar;
        this.zzg = new Object();
        this.zzi = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        contentResolver.registerContentObserver(uri, false, zzhdVar);
    }

    public static zzhe zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhe zzheVar;
        synchronized (zzhe.class) {
            Map map = zzb;
            zzheVar = (zzhe) map.get(uri);
            if (zzheVar == null) {
                try {
                    zzhe zzheVar2 = new zzhe(contentResolver, uri, runnable);
                    try {
                        map.put(uri, zzheVar2);
                    } catch (SecurityException unused) {
                    }
                    zzheVar = zzheVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzheVar;
    }

    static synchronized void zze() {
        synchronized (zzhe.class) {
            for (zzhe zzheVar : zzb.values()) {
                zzheVar.zzc.unregisterContentObserver(zzheVar.zzf);
            }
            zzb.clear();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhj
    public final /* bridge */ /* synthetic */ Object zzb(String str) {
        return (String) zzc().get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map zzc() {
        Map map;
        Map map2;
        Map map3 = this.zzh;
        Map map4 = map3;
        if (map3 == null) {
            synchronized (this.zzg) {
                Map map5 = this.zzh;
                map = map5;
                if (map5 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map2 = (Map) zzhh.zza(new zzhi() { // from class: com.google.android.gms.internal.measurement.zzhc
                                @Override // com.google.android.gms.internal.measurement.zzhi
                                public final Object zza() {
                                    return zzhe.this.zzd();
                                }
                            });
                        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                            Log.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            map2 = null;
                        }
                        this.zzh = map2;
                        allowThreadDiskReads = map2;
                        map = allowThreadDiskReads;
                    } finally {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    }
                }
            }
            map4 = map;
        }
        return map4 != null ? map4 : Collections.emptyMap();
    }

    final /* synthetic */ Map zzd() {
        Cursor query = this.zzc.query(this.zzd, zza, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (query.moveToNext()) {
                arrayMap.put(query.getString(0), query.getString(1));
            }
            return arrayMap;
        } finally {
            query.close();
        }
    }

    public final void zzf() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            Iterator it = this.zzi.iterator();
            while (it.hasNext()) {
                ((zzhf) it.next()).zza();
            }
        }
    }
}
