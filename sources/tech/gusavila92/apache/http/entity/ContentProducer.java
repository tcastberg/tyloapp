package tech.gusavila92.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
