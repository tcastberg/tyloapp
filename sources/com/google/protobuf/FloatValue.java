package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class FloatValue extends GeneratedMessageV3 implements FloatValueOrBuilder {
    private static final FloatValue DEFAULT_INSTANCE = new FloatValue();
    private static final Parser<FloatValue> PARSER = new AbstractParser<FloatValue>() { // from class: com.google.protobuf.FloatValue.1
        @Override // com.google.protobuf.Parser
        public FloatValue parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder newBuilder = FloatValue.newBuilder();
            try {
                newBuilder.mergeFrom(input, extensionRegistry);
                return newBuilder.buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(newBuilder.buildPartial());
            } catch (UninitializedMessageException e2) {
                throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(newBuilder.buildPartial());
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(newBuilder.buildPartial());
            }
        }
    };
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private float value_;

    private FloatValue(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.value_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    private FloatValue() {
        this.value_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new FloatValue();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, Builder.class);
    }

    @Override // com.google.protobuf.FloatValueOrBuilder
    public float getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        if (Float.floatToRawIntBits(this.value_) != 0) {
            output.writeFloat(1, this.value_);
        }
        getUnknownFields().writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeFloatSize = (Float.floatToRawIntBits(this.value_) != 0 ? CodedOutputStream.computeFloatSize(1, this.value_) : 0) + getUnknownFields().getSerializedSize();
        this.memoizedSize = computeFloatSize;
        return computeFloatSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FloatValue)) {
            return super.equals(obj);
        }
        FloatValue floatValue = (FloatValue) obj;
        return Float.floatToIntBits(getValue()) == Float.floatToIntBits(floatValue.getValue()) && getUnknownFields().equals(floatValue.getUnknownFields());
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getValue())) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public static FloatValue parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FloatValue parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FloatValue parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FloatValue parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FloatValue parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FloatValue parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FloatValue parseFrom(InputStream input) throws IOException {
        return (FloatValue) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static FloatValue parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FloatValue) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static FloatValue parseDelimitedFrom(InputStream input) throws IOException {
        return (FloatValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static FloatValue parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FloatValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static FloatValue parseFrom(CodedInputStream input) throws IOException {
        return (FloatValue) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static FloatValue parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FloatValue) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FloatValue prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
        return new Builder(parent);
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FloatValueOrBuilder {
        private int bitField0_;
        private float value_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, Builder.class);
        }

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.value_ = 0.0f;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FloatValue getDefaultInstanceForType() {
            return FloatValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FloatValue build() {
            FloatValue buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FloatValue buildPartial() {
            FloatValue floatValue = new FloatValue(this);
            if (this.bitField0_ != 0) {
                buildPartial0(floatValue);
            }
            onBuilt();
            return floatValue;
        }

        private void buildPartial0(FloatValue result) {
            if ((this.bitField0_ & 1) != 0) {
                result.value_ = this.value_;
            }
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (other instanceof FloatValue) {
                return mergeFrom((FloatValue) other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(FloatValue other) {
            if (other == FloatValue.getDefaultInstance()) {
                return this;
            }
            if (other.getValue() != 0.0f) {
                setValue(other.getValue());
            }
            mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            extensionRegistry.getClass();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = input.readTag();
                        if (readTag != 0) {
                            if (readTag == 13) {
                                this.value_ = input.readFloat();
                                this.bitField0_ |= 1;
                            } else if (!super.parseUnknownField(input, extensionRegistry, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    }
                } finally {
                    onChanged();
                }
            }
            return this;
        }

        @Override // com.google.protobuf.FloatValueOrBuilder
        public float getValue() {
            return this.value_;
        }

        public Builder setValue(float value) {
            this.value_ = value;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.bitField0_ &= -2;
            this.value_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(final UnknownFieldSet unknownFields) {
            return (Builder) super.setUnknownFields(unknownFields);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(final UnknownFieldSet unknownFields) {
            return (Builder) super.mergeUnknownFields(unknownFields);
        }
    }

    public static FloatValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static FloatValue of(float value) {
        return newBuilder().setValue(value).build();
    }

    public static Parser<FloatValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<FloatValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public FloatValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
