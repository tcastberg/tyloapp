package tech.gusavila92.websocketclient.common;

import kotlin.UByte;

/* loaded from: classes2.dex */
public class Utils {
    public static byte[] to2ByteArray(int i) {
        return new byte[]{(byte) (i >>> 8), (byte) i};
    }

    public static byte[] to8ByteArray(int i) {
        return new byte[]{0, 0, 0, 0, (byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    public static int fromByteArray(byte[] bArr) {
        return (bArr[3] & UByte.MAX_VALUE) | (bArr[0] << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8);
    }
}
