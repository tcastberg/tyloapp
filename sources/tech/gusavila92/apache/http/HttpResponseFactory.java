package tech.gusavila92.apache.http;

import tech.gusavila92.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface HttpResponseFactory {
    HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i, HttpContext httpContext);

    HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext);
}
