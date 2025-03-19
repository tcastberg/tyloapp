package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes2.dex */
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    abstract int extensionNumber(Map.Entry<?, ?> extension);

    abstract Object findExtensionByNumber(ExtensionRegistryLite extensionRegistry, MessageLite defaultInstance, int number);

    abstract FieldSet<T> getExtensions(Object message);

    abstract FieldSet<T> getMutableExtensions(Object message);

    abstract boolean hasExtensions(MessageLite prototype);

    abstract void makeImmutable(Object message);

    abstract <UT, UB> UB parseExtension(Object containerMessage, Reader reader, Object extension, ExtensionRegistryLite extensionRegistry, FieldSet<T> extensions, UB unknownFields, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException;

    abstract void parseLengthPrefixedMessageSetItem(Reader reader, Object extension, ExtensionRegistryLite extensionRegistry, FieldSet<T> extensions) throws IOException;

    abstract void parseMessageSetItem(ByteString data, Object extension, ExtensionRegistryLite extensionRegistry, FieldSet<T> extensions) throws IOException;

    abstract void serializeExtension(Writer writer, Map.Entry<?, ?> extension) throws IOException;

    abstract void setExtensions(Object message, FieldSet<T> extensions);

    ExtensionSchema() {
    }
}
