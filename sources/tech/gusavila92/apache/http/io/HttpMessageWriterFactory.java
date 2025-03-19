package tech.gusavila92.apache.http.io;

import tech.gusavila92.apache.http.HttpMessage;

/* loaded from: classes2.dex */
public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}
