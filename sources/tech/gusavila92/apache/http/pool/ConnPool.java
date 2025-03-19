package tech.gusavila92.apache.http.pool;

import java.util.concurrent.Future;
import tech.gusavila92.apache.http.concurrent.FutureCallback;

/* loaded from: classes2.dex */
public interface ConnPool<T, E> {
    Future<E> lease(T t, Object obj, FutureCallback<E> futureCallback);

    void release(E e, boolean z);
}
