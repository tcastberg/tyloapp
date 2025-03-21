package tech.gusavila92.apache.http.message;

import tech.gusavila92.apache.http.HttpRequest;
import tech.gusavila92.apache.http.HttpVersion;
import tech.gusavila92.apache.http.ProtocolVersion;
import tech.gusavila92.apache.http.RequestLine;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    private final String method;
    private RequestLine requestline;
    private final String uri;

    public BasicHttpRequest(String str, String str2) {
        this.method = (String) Args.notNull(str, "Method name");
        this.uri = (String) Args.notNull(str2, "Request URI");
        this.requestline = null;
    }

    public BasicHttpRequest(String str, String str2, ProtocolVersion protocolVersion) {
        this(new BasicRequestLine(str, str2, protocolVersion));
    }

    public BasicHttpRequest(RequestLine requestLine) {
        this.requestline = (RequestLine) Args.notNull(requestLine, "Request line");
        this.method = requestLine.getMethod();
        this.uri = requestLine.getUri();
    }

    @Override // tech.gusavila92.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return getRequestLine().getProtocolVersion();
    }

    @Override // tech.gusavila92.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        if (this.requestline == null) {
            this.requestline = new BasicRequestLine(this.method, this.uri, HttpVersion.HTTP_1_1);
        }
        return this.requestline;
    }

    public String toString() {
        return this.method + TokenParser.SP + this.uri + TokenParser.SP + this.headergroup;
    }
}
