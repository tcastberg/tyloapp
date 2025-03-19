package tech.gusavila92.apache.http.message;

import java.io.Serializable;
import tech.gusavila92.apache.http.ProtocolVersion;
import tech.gusavila92.apache.http.RequestLine;
import tech.gusavila92.apache.http.util.Args;
import tech.gusavila92.apache.http.util.CharArrayBuffer;

/* loaded from: classes2.dex */
public class BasicRequestLine implements RequestLine, Cloneable, Serializable {
    private static final long serialVersionUID = 2810581718468737193L;
    private final String method;
    private final ProtocolVersion protoversion;
    private final String uri;

    public BasicRequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        this.method = (String) Args.notNull(str, "Method");
        this.uri = (String) Args.notNull(str2, "URI");
        this.protoversion = (ProtocolVersion) Args.notNull(protocolVersion, "Version");
    }

    @Override // tech.gusavila92.apache.http.RequestLine
    public String getMethod() {
        return this.method;
    }

    @Override // tech.gusavila92.apache.http.RequestLine
    public ProtocolVersion getProtocolVersion() {
        return this.protoversion;
    }

    @Override // tech.gusavila92.apache.http.RequestLine
    public String getUri() {
        return this.uri;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatRequestLine((CharArrayBuffer) null, this).toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
