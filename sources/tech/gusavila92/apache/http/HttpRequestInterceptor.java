package tech.gusavila92.apache.http;

import java.io.IOException;
import tech.gusavila92.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface HttpRequestInterceptor {
    void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException;
}
