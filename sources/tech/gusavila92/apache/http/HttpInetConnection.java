package tech.gusavila92.apache.http;

import java.net.InetAddress;

/* loaded from: classes2.dex */
public interface HttpInetConnection extends HttpConnection {
    InetAddress getLocalAddress();

    int getLocalPort();

    InetAddress getRemoteAddress();

    int getRemotePort();
}
