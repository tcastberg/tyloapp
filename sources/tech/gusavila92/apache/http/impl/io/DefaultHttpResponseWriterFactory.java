package tech.gusavila92.apache.http.impl.io;

import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.io.HttpMessageWriter;
import tech.gusavila92.apache.http.io.HttpMessageWriterFactory;
import tech.gusavila92.apache.http.io.SessionOutputBuffer;
import tech.gusavila92.apache.http.message.BasicLineFormatter;
import tech.gusavila92.apache.http.message.LineFormatter;

/* loaded from: classes2.dex */
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory<HttpResponse> {
    public static final DefaultHttpResponseWriterFactory INSTANCE = new DefaultHttpResponseWriterFactory();
    private final LineFormatter lineFormatter;

    public DefaultHttpResponseWriterFactory(LineFormatter lineFormatter) {
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
    }

    public DefaultHttpResponseWriterFactory() {
        this(null);
    }

    @Override // tech.gusavila92.apache.http.io.HttpMessageWriterFactory
    public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer sessionOutputBuffer) {
        return new DefaultHttpResponseWriter(sessionOutputBuffer, this.lineFormatter);
    }
}
