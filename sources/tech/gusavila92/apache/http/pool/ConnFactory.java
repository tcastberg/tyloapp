package tech.gusavila92.apache.http.pool;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface ConnFactory<T, C> {
    C create(T t) throws IOException;
}
