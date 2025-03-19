package tech.gusavila92.apache.http;

/* loaded from: classes2.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
