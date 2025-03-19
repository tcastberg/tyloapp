package tech.gusavila92.apache.http.protocol;

import java.io.IOException;
import java.net.InetAddress;
import tech.gusavila92.apache.http.HttpConnection;
import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpHost;
import tech.gusavila92.apache.http.HttpInetConnection;
import tech.gusavila92.apache.http.HttpRequest;
import tech.gusavila92.apache.http.HttpRequestInterceptor;
import tech.gusavila92.apache.http.HttpVersion;
import tech.gusavila92.apache.http.ProtocolException;
import tech.gusavila92.apache.http.ProtocolVersion;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class RequestTargetHost implements HttpRequestInterceptor {
    @Override // tech.gusavila92.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
        if ((httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") && protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) || httpRequest.containsHeader("Host")) {
            return;
        }
        HttpHost targetHost = adapt.getTargetHost();
        if (targetHost == null) {
            HttpConnection connection = adapt.getConnection();
            if (connection instanceof HttpInetConnection) {
                HttpInetConnection httpInetConnection = (HttpInetConnection) connection;
                InetAddress remoteAddress = httpInetConnection.getRemoteAddress();
                int remotePort = httpInetConnection.getRemotePort();
                if (remoteAddress != null) {
                    targetHost = new HttpHost(remoteAddress.getHostName(), remotePort);
                }
            }
            if (targetHost == null) {
                if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                    throw new ProtocolException("Target host missing");
                }
                return;
            }
        }
        httpRequest.addHeader("Host", targetHost.toHostString());
    }
}
