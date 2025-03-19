package tech.gusavila92.apache.http;

import tech.gusavila92.apache.http.util.CharArrayBuffer;

/* loaded from: classes2.dex */
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
