package tech.gusavila92.apache.http.impl.bootstrap;

import java.io.IOException;
import tech.gusavila92.apache.http.ExceptionLogger;
import tech.gusavila92.apache.http.HttpServerConnection;
import tech.gusavila92.apache.http.protocol.BasicHttpContext;
import tech.gusavila92.apache.http.protocol.HttpCoreContext;
import tech.gusavila92.apache.http.protocol.HttpService;

/* loaded from: classes2.dex */
class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpservice;

    Worker(HttpService httpService, HttpServerConnection httpServerConnection, ExceptionLogger exceptionLogger) {
        this.httpservice = httpService;
        this.conn = httpServerConnection;
        this.exceptionLogger = exceptionLogger;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    BasicHttpContext basicHttpContext = new BasicHttpContext();
                    HttpCoreContext adapt = HttpCoreContext.adapt(basicHttpContext);
                    while (!Thread.interrupted() && this.conn.isOpen()) {
                        this.httpservice.handleRequest(this.conn, adapt);
                        basicHttpContext.clear();
                    }
                    this.conn.close();
                    this.conn.shutdown();
                } catch (Throwable th) {
                    try {
                        this.conn.shutdown();
                    } catch (IOException e) {
                        this.exceptionLogger.log(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.exceptionLogger.log(e2);
                this.conn.shutdown();
            }
        } catch (IOException e3) {
            this.exceptionLogger.log(e3);
        }
    }
}
