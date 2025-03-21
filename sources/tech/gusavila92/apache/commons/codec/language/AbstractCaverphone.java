package tech.gusavila92.apache.commons.codec.language;

import tech.gusavila92.apache.commons.codec.EncoderException;
import tech.gusavila92.apache.commons.codec.StringEncoder;

/* loaded from: classes2.dex */
public abstract class AbstractCaverphone implements StringEncoder {
    @Override // tech.gusavila92.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
        }
        return encode((String) obj);
    }

    public boolean isEncodeEqual(String str, String str2) throws EncoderException {
        return encode(str).equals(encode(str2));
    }
}
