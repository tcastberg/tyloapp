package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
public final class zzbk extends zzaw {
    protected zzbk() {
        this.zza.add(zzbl.ASSIGN);
        this.zza.add(zzbl.CONST);
        this.zza.add(zzbl.CREATE_ARRAY);
        this.zza.add(zzbl.CREATE_OBJECT);
        this.zza.add(zzbl.EXPRESSION_LIST);
        this.zza.add(zzbl.GET);
        this.zza.add(zzbl.GET_INDEX);
        this.zza.add(zzbl.GET_PROPERTY);
        this.zza.add(zzbl.NULL);
        this.zza.add(zzbl.SET_PROPERTY);
        this.zza.add(zzbl.TYPEOF);
        this.zza.add(zzbl.UNDEFINED);
        this.zza.add(zzbl.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        String str2;
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        int i = 0;
        if (ordinal == 3) {
            zzh.zzh(zzbl.ASSIGN.name(), 2, list);
            zzap zzb = zzgVar.zzb((zzap) list.get(0));
            if (!(zzb instanceof zzat)) {
                throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", zzb.getClass().getCanonicalName()));
            }
            if (!zzgVar.zzh(zzb.zzi())) {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", zzb.zzi()));
            }
            zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
            zzgVar.zzg(zzb.zzi(), zzb2);
            return zzb2;
        }
        if (ordinal == 14) {
            zzh.zzi(zzbl.CONST.name(), 2, list);
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", Integer.valueOf(list.size())));
            }
            while (i < list.size() - 1) {
                zzap zzb3 = zzgVar.zzb((zzap) list.get(i));
                if (!(zzb3 instanceof zzat)) {
                    throw new IllegalArgumentException(String.format("Expected string for const name. got %s", zzb3.getClass().getCanonicalName()));
                }
                zzgVar.zzf(zzb3.zzi(), zzgVar.zzb((zzap) list.get(i + 1)));
                i += 2;
            }
            return zzap.zzf;
        }
        if (ordinal == 24) {
            zzh.zzi(zzbl.EXPRESSION_LIST.name(), 1, list);
            zzap zzapVar = zzap.zzf;
            while (i < list.size()) {
                zzapVar = zzgVar.zzb((zzap) list.get(i));
                if (zzapVar instanceof zzag) {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
                i++;
            }
            return zzapVar;
        }
        if (ordinal == 33) {
            zzh.zzh(zzbl.GET.name(), 1, list);
            zzap zzb4 = zzgVar.zzb((zzap) list.get(0));
            if (zzb4 instanceof zzat) {
                return zzgVar.zzd(zzb4.zzi());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", zzb4.getClass().getCanonicalName()));
        }
        if (ordinal == 49) {
            zzh.zzh(zzbl.NULL.name(), 0, list);
            return zzap.zzg;
        }
        if (ordinal == 58) {
            zzh.zzh(zzbl.SET_PROPERTY.name(), 3, list);
            zzap zzb5 = zzgVar.zzb((zzap) list.get(0));
            zzap zzb6 = zzgVar.zzb((zzap) list.get(1));
            zzap zzb7 = zzgVar.zzb((zzap) list.get(2));
            if (zzb5 == zzap.zzf || zzb5 == zzap.zzg) {
                throw new IllegalStateException(String.format("Can't set property %s of %s", zzb6.zzi(), zzb5.zzi()));
            }
            if ((zzb5 instanceof zzae) && (zzb6 instanceof zzah)) {
                ((zzae) zzb5).zzq(zzb6.zzh().intValue(), zzb7);
            } else if (zzb5 instanceof zzal) {
                ((zzal) zzb5).zzr(zzb6.zzi(), zzb7);
            }
            return zzb7;
        }
        if (ordinal == 17) {
            if (list.isEmpty()) {
                return new zzae();
            }
            zzae zzaeVar = new zzae();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzap zzb8 = zzgVar.zzb((zzap) it.next());
                if (zzb8 instanceof zzag) {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
                zzaeVar.zzq(i, zzb8);
                i++;
            }
            return zzaeVar;
        }
        if (ordinal == 18) {
            if (list.isEmpty()) {
                return new zzam();
            }
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", Integer.valueOf(list.size())));
            }
            zzam zzamVar = new zzam();
            while (i < list.size() - 1) {
                zzap zzb9 = zzgVar.zzb((zzap) list.get(i));
                zzap zzb10 = zzgVar.zzb((zzap) list.get(i + 1));
                if ((zzb9 instanceof zzag) || (zzb10 instanceof zzag)) {
                    throw new IllegalStateException("Failed to evaluate map entry");
                }
                zzamVar.zzr(zzb9.zzi(), zzb10);
                i += 2;
            }
            return zzamVar;
        }
        if (ordinal == 35 || ordinal == 36) {
            zzh.zzh(zzbl.GET_PROPERTY.name(), 2, list);
            zzap zzb11 = zzgVar.zzb((zzap) list.get(0));
            zzap zzb12 = zzgVar.zzb((zzap) list.get(1));
            if ((zzb11 instanceof zzae) && zzh.zzk(zzb12)) {
                return ((zzae) zzb11).zze(zzb12.zzh().intValue());
            }
            if (zzb11 instanceof zzal) {
                return ((zzal) zzb11).zzf(zzb12.zzi());
            }
            if (zzb11 instanceof zzat) {
                if ("length".equals(zzb12.zzi())) {
                    return new zzah(Double.valueOf(zzb11.zzi().length()));
                }
                if (zzh.zzk(zzb12) && zzb12.zzh().doubleValue() < zzb11.zzi().length()) {
                    return new zzat(String.valueOf(zzb11.zzi().charAt(zzb12.zzh().intValue())));
                }
            }
            return zzap.zzf;
        }
        switch (ordinal) {
            case 62:
                zzh.zzh(zzbl.TYPEOF.name(), 1, list);
                zzap zzb13 = zzgVar.zzb((zzap) list.get(0));
                if (zzb13 instanceof zzau) {
                    str2 = "undefined";
                } else if (zzb13 instanceof zzaf) {
                    str2 = TypedValues.Custom.S_BOOLEAN;
                } else if (zzb13 instanceof zzah) {
                    str2 = "number";
                } else if (zzb13 instanceof zzat) {
                    str2 = TypedValues.Custom.S_STRING;
                } else if (zzb13 instanceof zzao) {
                    str2 = "function";
                } else {
                    if ((zzb13 instanceof zzaq) || (zzb13 instanceof zzag)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zzb13));
                    }
                    str2 = "object";
                }
                return new zzat(str2);
            case 63:
                zzh.zzh(zzbl.UNDEFINED.name(), 0, list);
                return zzap.zzf;
            case 64:
                zzh.zzi(zzbl.VAR.name(), 1, list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    zzap zzb14 = zzgVar.zzb((zzap) it2.next());
                    if (!(zzb14 instanceof zzat)) {
                        throw new IllegalArgumentException(String.format("Expected string for var name. got %s", zzb14.getClass().getCanonicalName()));
                    }
                    zzgVar.zze(zzb14.zzi(), zzap.zzf);
                }
                return zzap.zzf;
            default:
                return super.zzb(str);
        }
    }
}
