package tech.gusavila92.apache.http.protocol;

import java.io.IOException;
import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.HttpResponseInterceptor;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class ResponseServer implements HttpResponseInterceptor {
    private final String originServer;

    public ResponseServer(String str) {
        this.originServer = str;
    }

    public ResponseServer() {
        this(null);
    }

    @Override // tech.gusavila92.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        String str;
        Args.notNull(httpResponse, "HTTP response");
        if (httpResponse.containsHeader("Server") || (str = this.originServer) == null) {
            return;
        }
        httpResponse.addHeader("Server", str);
    }
}
