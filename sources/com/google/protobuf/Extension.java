package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageLite;

/* loaded from: classes2.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    protected enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    public enum MessageType {
        PROTO1,
        PROTO2
    }

    protected abstract Object fromReflectionType(Object value);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    protected abstract ExtensionType getExtensionType();

    @Override // com.google.protobuf.ExtensionLite
    public abstract Message getMessageDefaultInstance();

    @Override // com.google.protobuf.ExtensionLite
    final boolean isLite() {
        return false;
    }

    protected abstract Object singularFromReflectionType(Object value);

    protected abstract Object singularToReflectionType(Object value);

    protected abstract Object toReflectionType(Object value);

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }
}
