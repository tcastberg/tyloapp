package tech.gusavila92.apache.http;

/* loaded from: classes2.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
