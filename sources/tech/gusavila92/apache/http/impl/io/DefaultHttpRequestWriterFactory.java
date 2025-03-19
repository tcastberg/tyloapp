package tech.gusavila92.apache.http.impl.io;

import tech.gusavila92.apache.http.HttpRequest;
import tech.gusavila92.apache.http.io.HttpMessageWriter;
import tech.gusavila92.apache.http.io.HttpMessageWriterFactory;
import tech.gusavila92.apache.http.io.SessionOutputBuffer;
import tech.gusavila92.apache.http.message.BasicLineFormatter;
import tech.gusavila92.apache.http.message.LineFormatter;

/* loaded from: classes2.dex */
public class DefaultHttpRequestWriterFactory implements HttpMessageWriterFactory<HttpRequest> {
    public static final DefaultHttpRequestWriterFactory INSTANCE = new DefaultHttpRequestWriterFactory();
    private final LineFormatter lineFormatter;

    public DefaultHttpRequestWriterFactory(LineFormatter lineFormatter) {
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
    }

    public DefaultHttpRequestWriterFactory() {
        this(null);
    }

    @Override // tech.gusavila92.apache.http.io.HttpMessageWriterFactory
    public HttpMessageWriter<HttpRequest> create(SessionOutputBuffer sessionOutputBuffer) {
        return new DefaultHttpRequestWriter(sessionOutputBuffer, this.lineFormatter);
    }
}
