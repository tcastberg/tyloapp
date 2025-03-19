package com.tylohelo.tylohelo.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class PresentedValue {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015presented_value.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"8\n\u000fPresented_value\u0012\u0013\n\u000btemperature\u0018\u0001 \u0001(\r\u0012\u0010\n\bhumidity\u0018\u0002 \u0001(\rB\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_fieldAccessorTable;

    public interface Presented_valueOrBuilder extends MessageOrBuilder {
        int getHumidity();

        int getTemperature();

        boolean hasHumidity();

        boolean hasTemperature();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private PresentedValue() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Presented_value extends GeneratedMessageV3 implements Presented_valueOrBuilder {
        public static final int HUMIDITY_FIELD_NUMBER = 2;
        public static final int TEMPERATURE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int humidity_;
        private byte memoizedIsInitialized;
        private int temperature_;
        private static final Presented_value DEFAULT_INSTANCE = new Presented_value();

        @Deprecated
        public static final Parser<Presented_value> PARSER = new AbstractParser<Presented_value>() { // from class: com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_value.1
            @Override // com.google.protobuf.Parser
            public Presented_value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Presented_value.newBuilder();
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

        static /* synthetic */ int access$776(Presented_value presented_value, int i) {
            int i2 = i | presented_value.bitField0_;
            presented_value.bitField0_ = i2;
            return i2;
        }

        private Presented_value(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.temperature_ = 0;
            this.humidity_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Presented_value() {
            this.temperature_ = 0;
            this.humidity_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Presented_value();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PresentedValue.internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PresentedValue.internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_fieldAccessorTable.ensureFieldAccessorsInitialized(Presented_value.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_valueOrBuilder
        public boolean hasTemperature() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_valueOrBuilder
        public int getTemperature() {
            return this.temperature_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_valueOrBuilder
        public boolean hasHumidity() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_valueOrBuilder
        public int getHumidity() {
            return this.humidity_;
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
                codedOutputStream.writeUInt32(1, this.temperature_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeUInt32(2, this.humidity_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeUInt32Size = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeUInt32Size(1, this.temperature_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(2, this.humidity_);
            }
            int serializedSize = computeUInt32Size + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Presented_value)) {
                return super.equals(obj);
            }
            Presented_value presented_value = (Presented_value) obj;
            if (hasTemperature() != presented_value.hasTemperature()) {
                return false;
            }
            if ((!hasTemperature() || getTemperature() == presented_value.getTemperature()) && hasHumidity() == presented_value.hasHumidity()) {
                return (!hasHumidity() || getHumidity() == presented_value.getHumidity()) && getUnknownFields().equals(presented_value.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasTemperature()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getTemperature();
            }
            if (hasHumidity()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getHumidity();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Presented_value parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Presented_value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Presented_value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Presented_value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Presented_value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Presented_value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Presented_value parseFrom(InputStream inputStream) throws IOException {
            return (Presented_value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Presented_value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Presented_value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Presented_value parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Presented_value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Presented_value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Presented_value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Presented_value parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Presented_value) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Presented_value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Presented_value) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Presented_value presented_value) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(presented_value);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Presented_valueOrBuilder {
            private int bitField0_;
            private int humidity_;
            private int temperature_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PresentedValue.internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PresentedValue.internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_fieldAccessorTable.ensureFieldAccessorsInitialized(Presented_value.class, Builder.class);
            }

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.temperature_ = 0;
                this.humidity_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PresentedValue.internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Presented_value getDefaultInstanceForType() {
                return Presented_value.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Presented_value build() {
                Presented_value buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Presented_value buildPartial() {
                Presented_value presented_value = new Presented_value(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(presented_value);
                }
                onBuilt();
                return presented_value;
            }

            private void buildPartial0(Presented_value presented_value) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    presented_value.temperature_ = this.temperature_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    presented_value.humidity_ = this.humidity_;
                    i |= 2;
                }
                Presented_value.access$776(presented_value, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Presented_value) {
                    return mergeFrom((Presented_value) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Presented_value presented_value) {
                if (presented_value == Presented_value.getDefaultInstance()) {
                    return this;
                }
                if (presented_value.hasTemperature()) {
                    setTemperature(presented_value.getTemperature());
                }
                if (presented_value.hasHumidity()) {
                    setHumidity(presented_value.getHumidity());
                }
                mergeUnknownFields(presented_value.getUnknownFields());
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
                                    this.temperature_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 1;
                                } else if (readTag == 16) {
                                    this.humidity_ = codedInputStream.readUInt32();
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

            @Override // com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_valueOrBuilder
            public boolean hasTemperature() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_valueOrBuilder
            public int getTemperature() {
                return this.temperature_;
            }

            public Builder setTemperature(int i) {
                this.temperature_ = i;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearTemperature() {
                this.bitField0_ &= -2;
                this.temperature_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_valueOrBuilder
            public boolean hasHumidity() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.PresentedValue.Presented_valueOrBuilder
            public int getHumidity() {
                return this.humidity_;
            }

            public Builder setHumidity(int i) {
                this.humidity_ = i;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearHumidity() {
                this.bitField0_ &= -3;
                this.humidity_ = 0;
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

        public static Presented_value getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Presented_value> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Presented_value> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Presented_value getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_Presented_value_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Temperature", "Humidity"});
    }
}
