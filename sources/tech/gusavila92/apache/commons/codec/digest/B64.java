package tech.gusavila92.apache.commons.codec.digest;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.Random;
import kotlin.UByte;

/* loaded from: classes2.dex */
class B64 {
    static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    B64() {
    }

    static void b64from24bit(byte b, byte b2, byte b3, int i, StringBuilder sb) {
        int i2 = ((b << 16) & ViewCompat.MEASURED_SIZE_MASK) | ((b2 << 8) & SupportMenu.USER_MASK) | (b3 & UByte.MAX_VALUE);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            sb.append(B64T.charAt(i2 & 63));
            i2 >>= 6;
            i = i3;
        }
    }

    static String getRandomSalt(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append(B64T.charAt(new Random().nextInt(64)));
        }
        return sb.toString();
    }
}
