package tech.gusavila92.apache.commons.codec.net;

import tech.gusavila92.apache.commons.codec.DecoderException;

/* loaded from: classes2.dex */
class Utils {
    Utils() {
    }

    static int digit16(byte b) throws DecoderException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + ((int) b));
    }
}
