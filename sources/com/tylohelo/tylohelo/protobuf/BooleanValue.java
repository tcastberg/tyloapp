package com.tylohelo.tylohelo.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class BooleanValue {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013boolean_value.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"Õ\u0001\n\u0015Boolean_value_changed\u0012Q\n\nvalue_type\u0018\u0001 \u0001(\u000e2=.com.tylohelo.tylohelo.protobuf.Boolean_value_changed.value_t\u0012\r\n\u0005value\u0018\u0002 \u0001(\r\"Z\n\u0007value_t\u0012\f\n\bLIGHTING\u0010\n\u0012\u0012\n\u000eSTANDBY_ENABLE\u0010\u000b\u0012\u001d\n\u0019HUMIDITY_SENSOR_AVAILABLE\u0010\f\u0012\u000e\n\nIR_ENABLED\u0010\u0017\"Ä\u0001\n\u001cBoolean_value_change_request\u0012X\n\nvalue_type\u0018\u0001 \u0001(\u000e2D.com.tylohelo.tylohelo.protobuf.Boolean_value_change_request.value_t\u0012\r\n\u0005value\u0018\u0002 \u0001(\r\";\n\u0007value_t\u0012\f\n\bLIGHTING\u0010\n\u0012\u0012\n\u000eSTANDBY_ENABLE\u0010\u000b\u0012\u000e\n\nIR_ENABLED\u0010\u0013B\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_fieldAccessorTable;

    public interface Boolean_value_change_requestOrBuilder extends MessageOrBuilder {
        int getValue();

        Boolean_value_change_request.value_t getValueType();

        boolean hasValue();

        boolean hasValueType();
    }

    public interface Boolean_value_changedOrBuilder extends MessageOrBuilder {
        int getValue();

        Boolean_value_changed.value_t getValueType();

        boolean hasValue();

        boolean hasValueType();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private BooleanValue() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Boolean_value_changed extends GeneratedMessageV3 implements Boolean_value_changedOrBuilder {
        private static final Boolean_value_changed DEFAULT_INSTANCE = new Boolean_value_changed();

        @Deprecated
        public static final Parser<Boolean_value_changed> PARSER = new AbstractParser<Boolean_value_changed>() { // from class: com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changed.1
            @Override // com.google.protobuf.Parser
            public Boolean_value_changed parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Boolean_value_changed.newBuilder();
                try {
                    newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
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
        public static final int VALUE_FIELD_NUMBER = 2;
        public static final int VALUE_TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int valueType_;
        private int value_;

        static /* synthetic */ int access$776(Boolean_value_changed boolean_value_changed, int i) {
            int i2 = i | boolean_value_changed.bitField0_;
            boolean_value_changed.bitField0_ = i2;
            return i2;
        }

        private Boolean_value_changed(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.valueType_ = 10;
            this.value_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Boolean_value_changed() {
            this.value_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.valueType_ = 10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Boolean_value_changed();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_fieldAccessorTable.ensureFieldAccessorsInitialized(Boolean_value_changed.class, Builder.class);
        }

        public enum value_t implements ProtocolMessageEnum {
            LIGHTING(10),
            STANDBY_ENABLE(11),
            HUMIDITY_SENSOR_AVAILABLE(12),
            IR_ENABLED(23);

            public static final int HUMIDITY_SENSOR_AVAILABLE_VALUE = 12;
            public static final int IR_ENABLED_VALUE = 23;
            public static final int LIGHTING_VALUE = 10;
            public static final int STANDBY_ENABLE_VALUE = 11;
            private final int value;
            private static final Internal.EnumLiteMap<value_t> internalValueMap = new Internal.EnumLiteMap<value_t>() { // from class: com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changed.value_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public value_t findValueByNumber(int i) {
                    return value_t.forNumber(i);
                }
            };
            private static final value_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static value_t valueOf(int i) {
                return forNumber(i);
            }

            public static value_t forNumber(int i) {
                if (i != 23) {
                    switch (i) {
                        case 10:
                            return LIGHTING;
                        case 11:
                            return STANDBY_ENABLE;
                        case 12:
                            return HUMIDITY_SENSOR_AVAILABLE;
                        default:
                            return null;
                    }
                }
                return IR_ENABLED;
            }

            public static Internal.EnumLiteMap<value_t> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return Boolean_value_changed.getDescriptor().getEnumTypes().get(0);
            }

            public static value_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            value_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changedOrBuilder
        public boolean hasValueType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changedOrBuilder
        public value_t getValueType() {
            value_t forNumber = value_t.forNumber(this.valueType_);
            return forNumber == null ? value_t.LIGHTING : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changedOrBuilder
        public boolean hasValue() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changedOrBuilder
        public int getValue() {
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
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.writeEnum(1, this.valueType_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeUInt32(2, this.value_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(1, this.valueType_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += CodedOutputStream.computeUInt32Size(2, this.value_);
            }
            int serializedSize = computeEnumSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Boolean_value_changed)) {
                return super.equals(obj);
            }
            Boolean_value_changed boolean_value_changed = (Boolean_value_changed) obj;
            if (hasValueType() != boolean_value_changed.hasValueType()) {
                return false;
            }
            if ((!hasValueType() || this.valueType_ == boolean_value_changed.valueType_) && hasValue() == boolean_value_changed.hasValue()) {
                return (!hasValue() || getValue() == boolean_value_changed.getValue()) && getUnknownFields().equals(boolean_value_changed.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasValueType()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.valueType_;
            }
            if (hasValue()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getValue();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Boolean_value_changed parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Boolean_value_changed parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Boolean_value_changed parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Boolean_value_changed parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Boolean_value_changed parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Boolean_value_changed parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Boolean_value_changed parseFrom(InputStream inputStream) throws IOException {
            return (Boolean_value_changed) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Boolean_value_changed parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Boolean_value_changed) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Boolean_value_changed parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Boolean_value_changed) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Boolean_value_changed parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Boolean_value_changed) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Boolean_value_changed parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Boolean_value_changed) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Boolean_value_changed parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Boolean_value_changed) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Boolean_value_changed boolean_value_changed) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(boolean_value_changed);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Boolean_value_changedOrBuilder {
            private int bitField0_;
            private int valueType_;
            private int value_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_fieldAccessorTable.ensureFieldAccessorsInitialized(Boolean_value_changed.class, Builder.class);
            }

            private Builder() {
                this.valueType_ = 10;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.valueType_ = 10;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.valueType_ = 10;
                this.value_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Boolean_value_changed getDefaultInstanceForType() {
                return Boolean_value_changed.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Boolean_value_changed build() {
                Boolean_value_changed buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Boolean_value_changed buildPartial() {
                Boolean_value_changed boolean_value_changed = new Boolean_value_changed(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(boolean_value_changed);
                }
                onBuilt();
                return boolean_value_changed;
            }

            private void buildPartial0(Boolean_value_changed boolean_value_changed) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    boolean_value_changed.valueType_ = this.valueType_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    boolean_value_changed.value_ = this.value_;
                    i |= 2;
                }
                Boolean_value_changed.access$776(boolean_value_changed, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Boolean_value_changed) {
                    return mergeFrom((Boolean_value_changed) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Boolean_value_changed boolean_value_changed) {
                if (boolean_value_changed == Boolean_value_changed.getDefaultInstance()) {
                    return this;
                }
                if (boolean_value_changed.hasValueType()) {
                    setValueType(boolean_value_changed.getValueType());
                }
                if (boolean_value_changed.hasValue()) {
                    setValue(boolean_value_changed.getValue());
                }
                mergeUnknownFields(boolean_value_changed.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                extensionRegistryLite.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (value_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(1, readEnum);
                                    } else {
                                        this.valueType_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                } else if (readTag == 16) {
                                    this.value_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 2;
                                } else if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
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

            @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changedOrBuilder
            public boolean hasValueType() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changedOrBuilder
            public value_t getValueType() {
                value_t forNumber = value_t.forNumber(this.valueType_);
                return forNumber == null ? value_t.LIGHTING : forNumber;
            }

            public Builder setValueType(value_t value_tVar) {
                value_tVar.getClass();
                this.bitField0_ |= 1;
                this.valueType_ = value_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearValueType() {
                this.bitField0_ &= -2;
                this.valueType_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changedOrBuilder
            public boolean hasValue() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_changedOrBuilder
            public int getValue() {
                return this.value_;
            }

            public Builder setValue(int i) {
                this.value_ = i;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= -3;
                this.value_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static Boolean_value_changed getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Boolean_value_changed> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Boolean_value_changed> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Boolean_value_changed getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Boolean_value_change_request extends GeneratedMessageV3 implements Boolean_value_change_requestOrBuilder {
        private static final Boolean_value_change_request DEFAULT_INSTANCE = new Boolean_value_change_request();

        @Deprecated
        public static final Parser<Boolean_value_change_request> PARSER = new AbstractParser<Boolean_value_change_request>() { // from class: com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_request.1
            @Override // com.google.protobuf.Parser
            public Boolean_value_change_request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Boolean_value_change_request.newBuilder();
                try {
                    newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
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
        public static final int VALUE_FIELD_NUMBER = 2;
        public static final int VALUE_TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int valueType_;
        private int value_;

        static /* synthetic */ int access$1576(Boolean_value_change_request boolean_value_change_request, int i) {
            int i2 = i | boolean_value_change_request.bitField0_;
            boolean_value_change_request.bitField0_ = i2;
            return i2;
        }

        private Boolean_value_change_request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.valueType_ = 10;
            this.value_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Boolean_value_change_request() {
            this.value_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.valueType_ = 10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Boolean_value_change_request();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Boolean_value_change_request.class, Builder.class);
        }

        public enum value_t implements ProtocolMessageEnum {
            LIGHTING(10),
            STANDBY_ENABLE(11),
            IR_ENABLED(19);

            public static final int IR_ENABLED_VALUE = 19;
            public static final int LIGHTING_VALUE = 10;
            public static final int STANDBY_ENABLE_VALUE = 11;
            private final int value;
            private static final Internal.EnumLiteMap<value_t> internalValueMap = new Internal.EnumLiteMap<value_t>() { // from class: com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_request.value_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public value_t findValueByNumber(int i) {
                    return value_t.forNumber(i);
                }
            };
            private static final value_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static value_t valueOf(int i) {
                return forNumber(i);
            }

            public static value_t forNumber(int i) {
                if (i == 10) {
                    return LIGHTING;
                }
                if (i == 11) {
                    return STANDBY_ENABLE;
                }
                if (i != 19) {
                    return null;
                }
                return IR_ENABLED;
            }

            public static Internal.EnumLiteMap<value_t> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return Boolean_value_change_request.getDescriptor().getEnumTypes().get(0);
            }

            public static value_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            value_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_requestOrBuilder
        public boolean hasValueType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_requestOrBuilder
        public value_t getValueType() {
            value_t forNumber = value_t.forNumber(this.valueType_);
            return forNumber == null ? value_t.LIGHTING : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_requestOrBuilder
        public boolean hasValue() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_requestOrBuilder
        public int getValue() {
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
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.writeEnum(1, this.valueType_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeUInt32(2, this.value_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(1, this.valueType_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += CodedOutputStream.computeUInt32Size(2, this.value_);
            }
            int serializedSize = computeEnumSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Boolean_value_change_request)) {
                return super.equals(obj);
            }
            Boolean_value_change_request boolean_value_change_request = (Boolean_value_change_request) obj;
            if (hasValueType() != boolean_value_change_request.hasValueType()) {
                return false;
            }
            if ((!hasValueType() || this.valueType_ == boolean_value_change_request.valueType_) && hasValue() == boolean_value_change_request.hasValue()) {
                return (!hasValue() || getValue() == boolean_value_change_request.getValue()) && getUnknownFields().equals(boolean_value_change_request.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasValueType()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.valueType_;
            }
            if (hasValue()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getValue();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Boolean_value_change_request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Boolean_value_change_request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Boolean_value_change_request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Boolean_value_change_request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Boolean_value_change_request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Boolean_value_change_request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Boolean_value_change_request parseFrom(InputStream inputStream) throws IOException {
            return (Boolean_value_change_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Boolean_value_change_request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Boolean_value_change_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Boolean_value_change_request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Boolean_value_change_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Boolean_value_change_request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Boolean_value_change_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Boolean_value_change_request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Boolean_value_change_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Boolean_value_change_request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Boolean_value_change_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Boolean_value_change_request boolean_value_change_request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(boolean_value_change_request);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Boolean_value_change_requestOrBuilder {
            private int bitField0_;
            private int valueType_;
            private int value_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Boolean_value_change_request.class, Builder.class);
            }

            private Builder() {
                this.valueType_ = 10;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.valueType_ = 10;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.valueType_ = 10;
                this.value_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BooleanValue.internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Boolean_value_change_request getDefaultInstanceForType() {
                return Boolean_value_change_request.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Boolean_value_change_request build() {
                Boolean_value_change_request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Boolean_value_change_request buildPartial() {
                Boolean_value_change_request boolean_value_change_request = new Boolean_value_change_request(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(boolean_value_change_request);
                }
                onBuilt();
                return boolean_value_change_request;
            }

            private void buildPartial0(Boolean_value_change_request boolean_value_change_request) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    boolean_value_change_request.valueType_ = this.valueType_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    boolean_value_change_request.value_ = this.value_;
                    i |= 2;
                }
                Boolean_value_change_request.access$1576(boolean_value_change_request, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Boolean_value_change_request) {
                    return mergeFrom((Boolean_value_change_request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Boolean_value_change_request boolean_value_change_request) {
                if (boolean_value_change_request == Boolean_value_change_request.getDefaultInstance()) {
                    return this;
                }
                if (boolean_value_change_request.hasValueType()) {
                    setValueType(boolean_value_change_request.getValueType());
                }
                if (boolean_value_change_request.hasValue()) {
                    setValue(boolean_value_change_request.getValue());
                }
                mergeUnknownFields(boolean_value_change_request.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                extensionRegistryLite.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (value_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(1, readEnum);
                                    } else {
                                        this.valueType_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                } else if (readTag == 16) {
                                    this.value_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 2;
                                } else if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
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

            @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_requestOrBuilder
            public boolean hasValueType() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_requestOrBuilder
            public value_t getValueType() {
                value_t forNumber = value_t.forNumber(this.valueType_);
                return forNumber == null ? value_t.LIGHTING : forNumber;
            }

            public Builder setValueType(value_t value_tVar) {
                value_tVar.getClass();
                this.bitField0_ |= 1;
                this.valueType_ = value_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearValueType() {
                this.bitField0_ &= -2;
                this.valueType_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_requestOrBuilder
            public boolean hasValue() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.BooleanValue.Boolean_value_change_requestOrBuilder
            public int getValue() {
                return this.value_;
            }

            public Builder setValue(int i) {
                this.value_ = i;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= -3;
                this.value_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static Boolean_value_change_request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Boolean_value_change_request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Boolean_value_change_request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Boolean_value_change_request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_changed_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"ValueType", "Value"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_descriptor = descriptor3;
        internal_static_com_tylohelo_tylohelo_protobuf_Boolean_value_change_request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"ValueType", "Value"});
    }
}
