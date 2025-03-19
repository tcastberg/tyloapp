package tech.gusavila92.apache.http;

import java.io.IOException;
import tech.gusavila92.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface HttpResponseInterceptor {
    void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;
}
