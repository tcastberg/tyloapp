package com.google.android.gms.measurement.internal;

import java.util.BitSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes.dex */
final class zzaa extends zzkn {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzaa(zzkz zzkzVar) {
        super(zzkzVar);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza, null);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    private final boolean zzf(int i, int i2) {
        BitSet bitSet;
        zzu zzuVar = (zzu) this.zzc.get(Integer.valueOf(i));
        if (zzuVar == null) {
            return false;
        }
        bitSet = zzuVar.zze;
        return bitSet.get(i2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:(6:19|20|21|22|23|(20:(7:25|26|27|28|(1:30)(3:516|(1:518)(1:520)|519)|31|(1:34)(1:33))|(1:36)|37|38|39|40|41|42|(3:44|(1:46)|47)(4:480|(6:481|482|483|484|485|(1:488)(1:487))|(1:490)|491)|48|(1:50)(6:288|(6:290|291|292|293|294|(1:(3:296|(1:298)|299))(1:465))(1:479)|308|(10:311|(3:315|(4:318|(5:320|321|(1:323)(1:327)|324|325)(1:328)|326|316)|329)|330|(3:334|(4:337|(3:342|343|344)|345|335)|348)|349|(3:351|(6:354|(2:356|(3:358|359|360))(1:363)|361|362|360|352)|364)|365|(3:374|(8:377|(1:379)|380|(1:382)|383|(3:385|386|387)(1:389)|388|375)|390)|391|309)|397|398)|51|(3:184|(4:187|(10:189|190|(1:192)(1:285)|193|(13:195|196|197|198|199|200|201|202|203|205|206|(3:(9:208|209|210|211|212|(3:214|215|216)(1:259)|217|218|(1:221)(1:220))|(1:223)|224)(2:263|264)|225)(1:284)|226|(4:229|(3:247|248|249)(4:231|232|(2:233|(2:235|(1:237)(2:238|239))(1:246))|(3:241|242|243)(1:245))|244|227)|250|251|252)(1:286)|253|185)|287)|53|54|(3:56|(6:59|(11:61|62|63|64|65|66|67|68|69|(3:(9:71|72|73|74|75|76|(1:78)|79|80)|(1:84)|85)(2:138|139)|86)(1:159)|87|(2:88|(2:90|(3:124|125|126)(8:92|(2:93|(4:95|(3:97|(1:99)(1:101)|100)|102|(1:1)(2:106|(1:108)(2:109|110)))(1:123))|117|(1:119)(1:121)|120|112|113|114))(0))|127|57)|160)|161|(9:164|165|166|167|168|169|(2:171|172)(1:174)|173|162)|182|183)(1:524))|39|40|41|42|(0)(0)|48|(0)(0)|51|(0)|53|54|(0)|161|(1:162)|182|183) */
    /* JADX WARN: Can't wrap try/catch for region: R(26:0|1|(2:2|(2:4|(2:6|7)(1:540))(2:541|542))|8|(3:10|11|12)|16|(6:19|20|21|22|23|(20:(7:25|26|27|28|(1:30)(3:516|(1:518)(1:520)|519)|31|(1:34)(1:33))|(1:36)|37|38|39|40|41|42|(3:44|(1:46)|47)(4:480|(6:481|482|483|484|485|(1:488)(1:487))|(1:490)|491)|48|(1:50)(6:288|(6:290|291|292|293|294|(1:(3:296|(1:298)|299))(1:465))(1:479)|308|(10:311|(3:315|(4:318|(5:320|321|(1:323)(1:327)|324|325)(1:328)|326|316)|329)|330|(3:334|(4:337|(3:342|343|344)|345|335)|348)|349|(3:351|(6:354|(2:356|(3:358|359|360))(1:363)|361|362|360|352)|364)|365|(3:374|(8:377|(1:379)|380|(1:382)|383|(3:385|386|387)(1:389)|388|375)|390)|391|309)|397|398)|51|(3:184|(4:187|(10:189|190|(1:192)(1:285)|193|(13:195|196|197|198|199|200|201|202|203|205|206|(3:(9:208|209|210|211|212|(3:214|215|216)(1:259)|217|218|(1:221)(1:220))|(1:223)|224)(2:263|264)|225)(1:284)|226|(4:229|(3:247|248|249)(4:231|232|(2:233|(2:235|(1:237)(2:238|239))(1:246))|(3:241|242|243)(1:245))|244|227)|250|251|252)(1:286)|253|185)|287)|53|54|(3:56|(6:59|(11:61|62|63|64|65|66|67|68|69|(3:(9:71|72|73|74|75|76|(1:78)|79|80)|(1:84)|85)(2:138|139)|86)(1:159)|87|(2:88|(2:90|(3:124|125|126)(8:92|(2:93|(4:95|(3:97|(1:99)(1:101)|100)|102|(1:1)(2:106|(1:108)(2:109|110)))(1:123))|117|(1:119)(1:121)|120|112|113|114))(0))|127|57)|160)|161|(9:164|165|166|167|168|169|(2:171|172)(1:174)|173|162)|182|183)(1:524))|539|38|39|40|41|42|(0)(0)|48|(0)(0)|51|(0)|53|54|(0)|161|(1:162)|182|183|(5:(0)|(0)|(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0a76, code lost:
    
        if (r8 != false) goto L489;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0957, code lost:
    
        if (r9 != null) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0930, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x092e, code lost:
    
        if (r9 != null) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x07b9, code lost:
    
        if (r5 == null) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0787, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0785, code lost:
    
        if (r5 != null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x02c6, code lost:
    
        if (r5 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x02c8, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x02f8, code lost:
    
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
        r1 = new androidx.collection.ArrayMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0307, code lost:
    
        if (r13.isEmpty() == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0309, code lost:
    
        r21 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0456, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x030d, code lost:
    
        r3 = r13.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0319, code lost:
    
        if (r3.hasNext() == false) goto L543;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x031b, code lost:
    
        r4 = ((java.lang.Integer) r3.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzgh) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0335, code lost:
    
        if (r7 == null) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x033b, code lost:
    
        if (r7.isEmpty() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x033f, code lost:
    
        r17 = r0;
        r0 = r63.zzf.zzu().zzq(r6.zzk(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0353, code lost:
    
        if (r0.isEmpty() != false) goto L542;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0441, code lost:
    
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0355, code lost:
    
        r5 = (com.google.android.gms.internal.measurement.zzgg) r6.zzby();
        r5.zzf();
        r5.zzb(r0);
        r19 = r3;
        r0 = r63.zzf.zzu().zzq(r6.zzn(), r7);
        r5.zzh();
        r5.zzd(r0);
        com.google.android.gms.internal.measurement.zzob.zzc();
        r21 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x0389, code lost:
    
        if (r63.zzs.zzf().zzs(null, com.google.android.gms.measurement.internal.zzeb.zzaA) == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x038b, code lost:
    
        r0 = new java.util.ArrayList();
        r3 = r6.zzj().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x039c, code lost:
    
        if (r3.hasNext() == false) goto L550;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x039e, code lost:
    
        r8 = (com.google.android.gms.internal.measurement.zzfq) r3.next();
        r23 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x03b4, code lost:
    
        if (r7.contains(java.lang.Integer.valueOf(r8.zza())) != false) goto L552;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x03b6, code lost:
    
        r0.add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x03b9, code lost:
    
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x03bd, code lost:
    
        r5.zze();
        r5.zza(r0);
        r0 = new java.util.ArrayList();
        r3 = r6.zzm().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x03d4, code lost:
    
        if (r3.hasNext() == false) goto L553;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x03d6, code lost:
    
        r6 = (com.google.android.gms.internal.measurement.zzgj) r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x03e8, code lost:
    
        if (r7.contains(java.lang.Integer.valueOf(r6.zzb())) != false) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x03ea, code lost:
    
        r0.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x03ee, code lost:
    
        r5.zzg();
        r5.zzc(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x0433, code lost:
    
        r1.put(java.lang.Integer.valueOf(r4), (com.google.android.gms.internal.measurement.zzgh) r5.zzaE());
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x044e, code lost:
    
        r0 = r17;
        r3 = r19;
        r8 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x03f5, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x03fa, code lost:
    
        if (r0 >= r6.zza()) goto L558;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x040c, code lost:
    
        if (r7.contains(java.lang.Integer.valueOf(r6.zze(r0).zza())) == false) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x040e, code lost:
    
        r5.zzi(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x0411, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x0414, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x0419, code lost:
    
        if (r0 >= r6.zzc()) goto L561;
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x042b, code lost:
    
        if (r7.contains(java.lang.Integer.valueOf(r6.zzi(r0).zzb())) == false) goto L563;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x042d, code lost:
    
        r5.zzj(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:457:0x0430, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x0445, code lost:
    
        r17 = r0;
        r19 = r3;
        r21 = r8;
        r1.put(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x02d0, code lost:
    
        if (r5 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x02f5, code lost:
    
        if (r5 == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:504:0x0228, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x0229, code lost:
    
        r20 = "audience_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x0230, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x0231, code lost:
    
        r20 = "audience_id";
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x022c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x022d, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:525:0x0156, code lost:
    
        if (r5 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x0158, code lost:
    
        r5.close();
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x017a, code lost:
    
        if (r5 == null) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0a9e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01bd A[Catch: SQLiteException -> 0x0228, all -> 0x0b32, TRY_LEAVE, TryCatch #13 {SQLiteException -> 0x0228, blocks: (B:42:0x01b7, B:44:0x01bd, B:480:0x01cb, B:481:0x01d0, B:483:0x01da, B:484:0x01ea, B:500:0x01f7), top: B:41:0x01b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:473:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x01cb A[Catch: SQLiteException -> 0x0228, all -> 0x0b32, TRY_ENTER, TryCatch #13 {SQLiteException -> 0x0228, blocks: (B:42:0x01b7, B:44:0x01bd, B:480:0x01cb, B:481:0x01d0, B:483:0x01da, B:484:0x01ea, B:500:0x01f7), top: B:41:0x01b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0b36  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x086f  */
    /* JADX WARN: Type inference failed for: r0v196, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r4v31, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v59, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v61, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List zza(java.lang.String r64, java.util.List r65, java.util.List r66, java.lang.Long r67, java.lang.Long r68) {
        /*
            Method dump skipped, instructions count: 2874
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    protected final boolean zzb() {
        return false;
    }
}
