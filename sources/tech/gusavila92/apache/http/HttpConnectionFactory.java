package tech.gusavila92.apache.http;

import java.io.IOException;
import java.net.Socket;
import tech.gusavila92.apache.http.HttpConnection;

/* loaded from: classes2.dex */
public interface HttpConnectionFactory<T extends HttpConnection> {
    T createConnection(Socket socket) throws IOException;
}
