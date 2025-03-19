package tech.gusavila92.apache.http.protocol;

import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpRequest;
import tech.gusavila92.apache.http.HttpResponse;

/* loaded from: classes2.dex */
public interface HttpExpectationVerifier {
    void verify(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException;
}
