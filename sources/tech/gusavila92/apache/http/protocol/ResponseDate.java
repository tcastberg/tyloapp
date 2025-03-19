package tech.gusavila92.apache.http.protocol;

import java.io.IOException;
import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.HttpResponseInterceptor;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class ResponseDate implements HttpResponseInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator();

    @Override // tech.gusavila92.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        if (httpResponse.getStatusLine().getStatusCode() < 200 || httpResponse.containsHeader("Date")) {
            return;
        }
        httpResponse.setHeader("Date", DATE_GENERATOR.getCurrentDate());
    }
}
