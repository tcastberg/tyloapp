package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzke;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes.dex */
public abstract class zzke<MessageType extends zzke<MessageType, BuilderType>, BuilderType extends zzka<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzmo zzc = zzmo.zzc();
    protected int zzd = -1;

    protected static zzkj zzbA() {
        return zzkf.zzf();
    }

    protected static zzkk zzbB() {
        return zzla.zzf();
    }

    protected static zzkk zzbC(zzkk zzkkVar) {
        int size = zzkkVar.size();
        return zzkkVar.zzd(size == 0 ? 10 : size + size);
    }

    protected static zzkl zzbD() {
        return zzlu.zze();
    }

    protected static zzkl zzbE(zzkl zzklVar) {
        int size = zzklVar.size();
        return zzklVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzbH(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzbI(zzll zzllVar, String str, Object[] objArr) {
        return new zzlv(zzllVar, str, objArr);
    }

    protected static void zzbJ(Class cls, zzke zzkeVar) {
        zza.put(cls, zzkeVar);
    }

    static zzke zzbz(Class cls) {
        Map map = zza;
        zzke zzkeVar = (zzke) map.get(cls);
        if (zzkeVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkeVar = (zzke) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzkeVar == null) {
            zzkeVar = (zzke) ((zzke) zzmx.zze(cls)).zzl(6, null, null);
            if (zzkeVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzkeVar);
        }
        return zzkeVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlt.zza().zzb(getClass()).zzj(this, (zzke) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzb = zzlt.zza().zzb(getClass()).zzb(this);
        this.zzb = zzb;
        return zzb;
    }

    public final String toString() {
        return zzln.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final /* synthetic */ zzlk zzbF() {
        return (zzka) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final /* synthetic */ zzlk zzbG() {
        zzka zzkaVar = (zzka) zzl(5, null, null);
        zzkaVar.zzaC(this);
        return zzkaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzbK(zzjl zzjlVar) throws IOException {
        zzlt.zza().zzb(getClass()).zzi(this, zzjm.zza(zzjlVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzll zzbO() {
        return (zzke) zzl(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzin
    final int zzbr() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzin
    final void zzbu(int i) {
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zzbw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zza2 = zzlt.zza().zzb(getClass()).zza(this);
        this.zzd = zza2;
        return zza2;
    }

    protected final zzka zzbx() {
        return (zzka) zzl(5, null, null);
    }

    public final zzka zzby() {
        zzka zzkaVar = (zzka) zzl(5, null, null);
        zzkaVar.zzaC(this);
        return zzkaVar;
    }

    protected abstract Object zzl(int i, Object obj, Object obj2);
}
