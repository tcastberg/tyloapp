package tech.gusavila92.apache.http.impl.pool;

import java.util.concurrent.atomic.AtomicLong;
import tech.gusavila92.apache.http.HttpClientConnection;
import tech.gusavila92.apache.http.HttpHost;
import tech.gusavila92.apache.http.config.ConnectionConfig;
import tech.gusavila92.apache.http.config.SocketConfig;
import tech.gusavila92.apache.http.params.HttpParams;
import tech.gusavila92.apache.http.pool.AbstractConnPool;
import tech.gusavila92.apache.http.pool.ConnFactory;

/* loaded from: classes2.dex */
public class BasicConnPool extends AbstractConnPool<HttpHost, HttpClientConnection, BasicPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();

    public BasicConnPool(ConnFactory<HttpHost, HttpClientConnection> connFactory) {
        super(connFactory, 2, 20);
    }

    @Deprecated
    public BasicConnPool(HttpParams httpParams) {
        super(new BasicConnFactory(httpParams), 2, 20);
    }

    public BasicConnPool(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        super(new BasicConnFactory(socketConfig, connectionConfig), 2, 20);
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tech.gusavila92.apache.http.pool.AbstractConnPool
    public BasicPoolEntry createEntry(HttpHost httpHost, HttpClientConnection httpClientConnection) {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), httpHost, httpClientConnection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tech.gusavila92.apache.http.pool.AbstractConnPool
    public boolean validate(BasicPoolEntry basicPoolEntry) {
        return !basicPoolEntry.getConnection().isStale();
    }
}
