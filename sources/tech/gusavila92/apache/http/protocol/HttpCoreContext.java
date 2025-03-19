package tech.gusavila92.apache.http.protocol;

import tech.gusavila92.apache.http.HttpConnection;
import tech.gusavila92.apache.http.HttpHost;
import tech.gusavila92.apache.http.HttpRequest;
import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class HttpCoreContext implements HttpContext {
    public static final String HTTP_CONNECTION = "http.connection";
    public static final String HTTP_REQUEST = "http.request";
    public static final String HTTP_REQ_SENT = "http.request_sent";
    public static final String HTTP_RESPONSE = "http.response";
    public static final String HTTP_TARGET_HOST = "http.target_host";
    private final HttpContext context;

    public static HttpCoreContext create() {
        return new HttpCoreContext(new BasicHttpContext());
    }

    public static HttpCoreContext adapt(HttpContext httpContext) {
        Args.notNull(httpContext, "HTTP context");
        if (httpContext instanceof HttpCoreContext) {
            return (HttpCoreContext) httpContext;
        }
        return new HttpCoreContext(httpContext);
    }

    public HttpCoreContext(HttpContext httpContext) {
        this.context = httpContext;
    }

    public HttpCoreContext() {
        this.context = new BasicHttpContext();
    }

    @Override // tech.gusavila92.apache.http.protocol.HttpContext
    public Object getAttribute(String str) {
        return this.context.getAttribute(str);
    }

    @Override // tech.gusavila92.apache.http.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        this.context.setAttribute(str, obj);
    }

    @Override // tech.gusavila92.apache.http.protocol.HttpContext
    public Object removeAttribute(String str) {
        return this.context.removeAttribute(str);
    }

    public <T> T getAttribute(String str, Class<T> cls) {
        Args.notNull(cls, "Attribute class");
        Object attribute = getAttribute(str);
        if (attribute == null) {
            return null;
        }
        return cls.cast(attribute);
    }

    public <T extends HttpConnection> T getConnection(Class<T> cls) {
        return (T) getAttribute(HTTP_CONNECTION, cls);
    }

    public HttpConnection getConnection() {
        return (HttpConnection) getAttribute(HTTP_CONNECTION, HttpConnection.class);
    }

    public HttpRequest getRequest() {
        return (HttpRequest) getAttribute(HTTP_REQUEST, HttpRequest.class);
    }

    public boolean isRequestSent() {
        Boolean bool = (Boolean) getAttribute(HTTP_REQ_SENT, Boolean.class);
        return bool != null && bool.booleanValue();
    }

    public HttpResponse getResponse() {
        return (HttpResponse) getAttribute(HTTP_RESPONSE, HttpResponse.class);
    }

    public void setTargetHost(HttpHost httpHost) {
        setAttribute(HTTP_TARGET_HOST, httpHost);
    }

    public HttpHost getTargetHost() {
        return (HttpHost) getAttribute(HTTP_TARGET_HOST, HttpHost.class);
    }
}
