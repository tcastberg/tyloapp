package tech.gusavila92.apache.http.impl.pool;

import java.io.IOException;
import tech.gusavila92.apache.http.HttpClientConnection;
import tech.gusavila92.apache.http.HttpHost;
import tech.gusavila92.apache.http.pool.PoolEntry;

/* loaded from: classes2.dex */
public class BasicPoolEntry extends PoolEntry<HttpHost, HttpClientConnection> {
    public BasicPoolEntry(String str, HttpHost httpHost, HttpClientConnection httpClientConnection) {
        super(str, httpHost, httpClientConnection);
    }

    @Override // tech.gusavila92.apache.http.pool.PoolEntry
    public void close() {
        try {
            getConnection().close();
        } catch (IOException unused) {
        }
    }

    @Override // tech.gusavila92.apache.http.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }
}
