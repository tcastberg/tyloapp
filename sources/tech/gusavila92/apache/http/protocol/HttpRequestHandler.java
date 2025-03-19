package tech.gusavila92.apache.http.protocol;

import java.io.IOException;
import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpRequest;
import tech.gusavila92.apache.http.HttpResponse;

/* loaded from: classes2.dex */
public interface HttpRequestHandler {
    void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;
}
