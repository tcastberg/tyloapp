package tech.gusavila92.apache.http;

import java.util.Iterator;

/* loaded from: classes2.dex */
public interface HeaderIterator extends Iterator<Object> {
    @Override // java.util.Iterator
    boolean hasNext();

    Header nextHeader();
}
