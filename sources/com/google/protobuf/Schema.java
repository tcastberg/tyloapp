package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import java.io.IOException;

@CheckReturnValue
/* loaded from: classes2.dex */
interface Schema<T> {
    boolean equals(T message, T other);

    int getSerializedSize(T message);

    int hashCode(T message);

    boolean isInitialized(T message);

    void makeImmutable(T message);

    void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException;

    void mergeFrom(T message, T other);

    void mergeFrom(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T message, Writer writer) throws IOException;
}
