package tech.gusavila92.apache.http.impl;

import java.util.Locale;
import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.HttpResponseFactory;
import tech.gusavila92.apache.http.ProtocolVersion;
import tech.gusavila92.apache.http.ReasonPhraseCatalog;
import tech.gusavila92.apache.http.StatusLine;
import tech.gusavila92.apache.http.message.BasicHttpResponse;
import tech.gusavila92.apache.http.message.BasicStatusLine;
import tech.gusavila92.apache.http.protocol.HttpContext;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class DefaultHttpResponseFactory implements HttpResponseFactory {
    public static final DefaultHttpResponseFactory INSTANCE = new DefaultHttpResponseFactory();
    protected final ReasonPhraseCatalog reasonCatalog;

    public DefaultHttpResponseFactory(ReasonPhraseCatalog reasonPhraseCatalog) {
        this.reasonCatalog = (ReasonPhraseCatalog) Args.notNull(reasonPhraseCatalog, "Reason phrase catalog");
    }

    public DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    @Override // tech.gusavila92.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i, HttpContext httpContext) {
        Args.notNull(protocolVersion, "HTTP version");
        Locale determineLocale = determineLocale(httpContext);
        return new BasicHttpResponse(new BasicStatusLine(protocolVersion, i, this.reasonCatalog.getReason(i, determineLocale)), this.reasonCatalog, determineLocale);
    }

    @Override // tech.gusavila92.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext) {
        Args.notNull(statusLine, "Status line");
        return new BasicHttpResponse(statusLine, this.reasonCatalog, determineLocale(httpContext));
    }

    protected Locale determineLocale(HttpContext httpContext) {
        return Locale.getDefault();
    }
}
