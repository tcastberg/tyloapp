package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UArraySorting.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m826partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m446getw2LRezQ = UByteArray.m446getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m446getw2LRezQ2 = UByteArray.m446getw2LRezQ(bArr, i) & UByte.MAX_VALUE;
                i3 = m446getw2LRezQ & UByte.MAX_VALUE;
                if (Intrinsics.compare(m446getw2LRezQ2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m446getw2LRezQ(bArr, i2) & UByte.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m446getw2LRezQ3 = UByteArray.m446getw2LRezQ(bArr, i);
                UByteArray.m451setVurrAj0(bArr, i, UByteArray.m446getw2LRezQ(bArr, i2));
                UByteArray.m451setVurrAj0(bArr, i2, m446getw2LRezQ3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m830quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m826partition4UcCI2c = m826partition4UcCI2c(bArr, i, i2);
        int i3 = m826partition4UcCI2c - 1;
        if (i < i3) {
            m830quickSort4UcCI2c(bArr, i, i3);
        }
        if (m826partition4UcCI2c < i2) {
            m830quickSort4UcCI2c(bArr, m826partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m827partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m709getMh2AYeg = UShortArray.m709getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m709getMh2AYeg2 = UShortArray.m709getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m709getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m709getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m709getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m709getMh2AYeg3 = UShortArray.m709getMh2AYeg(sArr, i);
                UShortArray.m714set01HTLdE(sArr, i, UShortArray.m709getMh2AYeg(sArr, i2));
                UShortArray.m714set01HTLdE(sArr, i2, m709getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m831quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m827partitionAa5vz7o = m827partitionAa5vz7o(sArr, i, i2);
        int i3 = m827partitionAa5vz7o - 1;
        if (i < i3) {
            m831quickSortAa5vz7o(sArr, i, i3);
        }
        if (m827partitionAa5vz7o < i2) {
            m831quickSortAa5vz7o(sArr, m827partitionAa5vz7o, i2);
        }
    }

    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m828partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m525getpVg5ArA = UIntArray.m525getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m525getpVg5ArA(iArr, i), m525getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m525getpVg5ArA(iArr, i2), m525getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m525getpVg5ArA2 = UIntArray.m525getpVg5ArA(iArr, i);
                UIntArray.m530setVXSXFK8(iArr, i, UIntArray.m525getpVg5ArA(iArr, i2));
                UIntArray.m530setVXSXFK8(iArr, i2, m525getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m832quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m828partitionoBK06Vg = m828partitionoBK06Vg(iArr, i, i2);
        int i3 = m828partitionoBK06Vg - 1;
        if (i < i3) {
            m832quickSortoBK06Vg(iArr, i, i3);
        }
        if (m828partitionoBK06Vg < i2) {
            m832quickSortoBK06Vg(iArr, m828partitionoBK06Vg, i2);
        }
    }

    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m825partitionnroSd4(long[] jArr, int i, int i2) {
        long m604getsVKNKU = ULongArray.m604getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m604getsVKNKU(jArr, i), m604getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m604getsVKNKU(jArr, i2), m604getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m604getsVKNKU2 = ULongArray.m604getsVKNKU(jArr, i);
                ULongArray.m609setk8EXiF4(jArr, i, ULongArray.m604getsVKNKU(jArr, i2));
                ULongArray.m609setk8EXiF4(jArr, i2, m604getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m829quickSortnroSd4(long[] jArr, int i, int i2) {
        int m825partitionnroSd4 = m825partitionnroSd4(jArr, i, i2);
        int i3 = m825partitionnroSd4 - 1;
        if (i < i3) {
            m829quickSortnroSd4(jArr, i, i3);
        }
        if (m825partitionnroSd4 < i2) {
            m829quickSortnroSd4(jArr, m825partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m834sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m830quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m835sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m831quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m836sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m832quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m833sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m829quickSortnroSd4(array, i, i2 - 1);
    }
}
