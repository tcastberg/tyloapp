package com.tylohelo.tylohelo.protobuf;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class AuxRelay {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000faux_relay.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"Ð\u0001\n\u000eAux_relay_post\u0012\r\n\u0005index\u0018\u0001 \u0001(\r\u0012K\n\bfunction\u0018\u0002 \u0001(\u000e29.com.tylohelo.tylohelo.protobuf.Aux_relay_post.function_t\u0012\f\n\u0004name\u0018\u0003 \u0003(\r\u0012\u000e\n\u0006active\u0018\u0004 \u0001(\b\"D\n\nfunction_t\u0012\u0011\n\rFUNC_NOT_USED\u0010\n\u0012\u000f\n\u000bFUNC_ON_OFF\u0010\u000b\u0012\u0012\n\u000eFUNC_FREQUENCY\u0010\f\"q\n\u0014Aux_relay_post_sauna\u0012\u0011\n\tconnected\u0018\u0001 \u0001(\b\u0012F\n\u000eaux_relay_post\u0018\u0002 \u0001(\u000b2..com.tylohelo.tylohelo.protobuf.Aux_relay_postB\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_fieldAccessorTable;

    public interface Aux_relay_postOrBuilder extends MessageOrBuilder {
        boolean getActive();

        Aux_relay_post.function_t getFunction();

        int getIndex();

        int getName(int i);

        int getNameCount();

        List<Integer> getNameList();

        boolean hasActive();

        boolean hasFunction();

        boolean hasIndex();
    }

    public interface Aux_relay_post_saunaOrBuilder extends MessageOrBuilder {
        Aux_relay_post getAuxRelayPost();

        Aux_relay_postOrBuilder getAuxRelayPostOrBuilder();

        boolean getConnected();

        boolean hasAuxRelayPost();

        boolean hasConnected();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private AuxRelay() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Aux_relay_post extends GeneratedMessageV3 implements Aux_relay_postOrBuilder {
        public static final int ACTIVE_FIELD_NUMBER = 4;
        public static final int FUNCTION_FIELD_NUMBER = 2;
        public static final int INDEX_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private boolean active_;
        private int bitField0_;
        private int function_;
        private int index_;
        private byte memoizedIsInitialized;
        private Internal.IntList name_;
        private static final Aux_relay_post DEFAULT_INSTANCE = new Aux_relay_post();

        @Deprecated
        public static final Parser<Aux_relay_post> PARSER = new AbstractParser<Aux_relay_post>() { // from class: com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post.1
            @Override // com.google.protobuf.Parser
            public Aux_relay_post parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Aux_relay_post.newBuilder();
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

        static /* synthetic */ int access$1076(Aux_relay_post aux_relay_post, int i) {
            int i2 = i | aux_relay_post.bitField0_;
            aux_relay_post.bitField0_ = i2;
            return i2;
        }

        private Aux_relay_post(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.index_ = 0;
            this.function_ = 10;
            this.active_ = false;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Aux_relay_post() {
            this.index_ = 0;
            this.active_ = false;
            this.memoizedIsInitialized = (byte) -1;
            this.function_ = 10;
            this.name_ = emptyIntList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Aux_relay_post();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_fieldAccessorTable.ensureFieldAccessorsInitialized(Aux_relay_post.class, Builder.class);
        }

        public enum function_t implements ProtocolMessageEnum {
            FUNC_NOT_USED(10),
            FUNC_ON_OFF(11),
            FUNC_FREQUENCY(12);

            public static final int FUNC_FREQUENCY_VALUE = 12;
            public static final int FUNC_NOT_USED_VALUE = 10;
            public static final int FUNC_ON_OFF_VALUE = 11;
            private final int value;
            private static final Internal.EnumLiteMap<function_t> internalValueMap = new Internal.EnumLiteMap<function_t>() { // from class: com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post.function_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public function_t findValueByNumber(int i) {
                    return function_t.forNumber(i);
                }
            };
            private static final function_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static function_t valueOf(int i) {
                return forNumber(i);
            }

            public static function_t forNumber(int i) {
                switch (i) {
                    case 10:
                        return FUNC_NOT_USED;
                    case 11:
                        return FUNC_ON_OFF;
                    case 12:
                        return FUNC_FREQUENCY;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<function_t> internalGetValueMap() {
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
                return Aux_relay_post.getDescriptor().getEnumTypes().get(0);
            }

            public static function_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            function_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public boolean hasIndex() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public boolean hasFunction() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public function_t getFunction() {
            function_t forNumber = function_t.forNumber(this.function_);
            return forNumber == null ? function_t.FUNC_NOT_USED : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public List<Integer> getNameList() {
            return this.name_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public int getNameCount() {
            return this.name_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public int getName(int i) {
            return this.name_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public boolean hasActive() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
        public boolean getActive() {
            return this.active_;
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
                codedOutputStream.writeUInt32(1, this.index_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeEnum(2, this.function_);
            }
            for (int i = 0; i < this.name_.size(); i++) {
                codedOutputStream.writeUInt32(3, this.name_.getInt(i));
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeBool(4, this.active_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeUInt32Size = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeUInt32Size(1, this.index_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(2, this.function_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.name_.size(); i3++) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(this.name_.getInt(i3));
            }
            int size = computeUInt32Size + i2 + getNameList().size();
            if ((this.bitField0_ & 4) != 0) {
                size += CodedOutputStream.computeBoolSize(4, this.active_);
            }
            int serializedSize = size + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Aux_relay_post)) {
                return super.equals(obj);
            }
            Aux_relay_post aux_relay_post = (Aux_relay_post) obj;
            if (hasIndex() != aux_relay_post.hasIndex()) {
                return false;
            }
            if ((hasIndex() && getIndex() != aux_relay_post.getIndex()) || hasFunction() != aux_relay_post.hasFunction()) {
                return false;
            }
            if ((!hasFunction() || this.function_ == aux_relay_post.function_) && getNameList().equals(aux_relay_post.getNameList()) && hasActive() == aux_relay_post.hasActive()) {
                return (!hasActive() || getActive() == aux_relay_post.getActive()) && getUnknownFields().equals(aux_relay_post.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasIndex()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getIndex();
            }
            if (hasFunction()) {
                hashCode = (((hashCode * 37) + 2) * 53) + this.function_;
            }
            if (getNameCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getNameList().hashCode();
            }
            if (hasActive()) {
                hashCode = (((hashCode * 37) + 4) * 53) + Internal.hashBoolean(getActive());
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Aux_relay_post parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Aux_relay_post parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Aux_relay_post parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Aux_relay_post parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Aux_relay_post parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Aux_relay_post parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Aux_relay_post parseFrom(InputStream inputStream) throws IOException {
            return (Aux_relay_post) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Aux_relay_post parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aux_relay_post) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Aux_relay_post parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Aux_relay_post) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Aux_relay_post parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aux_relay_post) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Aux_relay_post parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Aux_relay_post) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Aux_relay_post parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aux_relay_post) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Aux_relay_post aux_relay_post) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(aux_relay_post);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Aux_relay_postOrBuilder {
            private boolean active_;
            private int bitField0_;
            private int function_;
            private int index_;
            private Internal.IntList name_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_fieldAccessorTable.ensureFieldAccessorsInitialized(Aux_relay_post.class, Builder.class);
            }

            private Builder() {
                this.function_ = 10;
                this.name_ = Aux_relay_post.emptyIntList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.function_ = 10;
                this.name_ = Aux_relay_post.emptyIntList();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.index_ = 0;
                this.function_ = 10;
                this.name_ = Aux_relay_post.emptyIntList();
                this.active_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Aux_relay_post getDefaultInstanceForType() {
                return Aux_relay_post.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Aux_relay_post build() {
                Aux_relay_post buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Aux_relay_post buildPartial() {
                Aux_relay_post aux_relay_post = new Aux_relay_post(this);
                buildPartialRepeatedFields(aux_relay_post);
                if (this.bitField0_ != 0) {
                    buildPartial0(aux_relay_post);
                }
                onBuilt();
                return aux_relay_post;
            }

            private void buildPartialRepeatedFields(Aux_relay_post aux_relay_post) {
                if ((this.bitField0_ & 4) != 0) {
                    this.name_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                aux_relay_post.name_ = this.name_;
            }

            private void buildPartial0(Aux_relay_post aux_relay_post) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    aux_relay_post.index_ = this.index_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    aux_relay_post.function_ = this.function_;
                    i |= 2;
                }
                if ((i2 & 8) != 0) {
                    aux_relay_post.active_ = this.active_;
                    i |= 4;
                }
                Aux_relay_post.access$1076(aux_relay_post, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Aux_relay_post) {
                    return mergeFrom((Aux_relay_post) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Aux_relay_post aux_relay_post) {
                if (aux_relay_post == Aux_relay_post.getDefaultInstance()) {
                    return this;
                }
                if (aux_relay_post.hasIndex()) {
                    setIndex(aux_relay_post.getIndex());
                }
                if (aux_relay_post.hasFunction()) {
                    setFunction(aux_relay_post.getFunction());
                }
                if (!aux_relay_post.name_.isEmpty()) {
                    if (this.name_.isEmpty()) {
                        this.name_ = aux_relay_post.name_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureNameIsMutable();
                        this.name_.addAll(aux_relay_post.name_);
                    }
                    onChanged();
                }
                if (aux_relay_post.hasActive()) {
                    setActive(aux_relay_post.getActive());
                }
                mergeUnknownFields(aux_relay_post.getUnknownFields());
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
                                    this.index_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 1;
                                } else if (readTag == 16) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (function_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(2, readEnum);
                                    } else {
                                        this.function_ = readEnum;
                                        this.bitField0_ |= 2;
                                    }
                                } else if (readTag == 24) {
                                    int readUInt32 = codedInputStream.readUInt32();
                                    ensureNameIsMutable();
                                    this.name_.addInt(readUInt32);
                                } else if (readTag == 26) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureNameIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.name_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag == 32) {
                                    this.active_ = codedInputStream.readBool();
                                    this.bitField0_ |= 8;
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

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public boolean hasIndex() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public int getIndex() {
                return this.index_;
            }

            public Builder setIndex(int i) {
                this.index_ = i;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.bitField0_ &= -2;
                this.index_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public boolean hasFunction() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public function_t getFunction() {
                function_t forNumber = function_t.forNumber(this.function_);
                return forNumber == null ? function_t.FUNC_NOT_USED : forNumber;
            }

            public Builder setFunction(function_t function_tVar) {
                function_tVar.getClass();
                this.bitField0_ |= 2;
                this.function_ = function_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFunction() {
                this.bitField0_ &= -3;
                this.function_ = 10;
                onChanged();
                return this;
            }

            private void ensureNameIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.name_ = Aux_relay_post.mutableCopy(this.name_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public List<Integer> getNameList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.name_) : this.name_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public int getNameCount() {
                return this.name_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public int getName(int i) {
                return this.name_.getInt(i);
            }

            public Builder setName(int i, int i2) {
                ensureNameIsMutable();
                this.name_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addName(int i) {
                ensureNameIsMutable();
                this.name_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllName(Iterable<? extends Integer> iterable) {
                ensureNameIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.name_);
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = Aux_relay_post.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public boolean hasActive() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_postOrBuilder
            public boolean getActive() {
                return this.active_;
            }

            public Builder setActive(boolean z) {
                this.active_ = z;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearActive() {
                this.bitField0_ &= -9;
                this.active_ = false;
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

        public static Aux_relay_post getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Aux_relay_post> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Aux_relay_post> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Aux_relay_post getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Aux_relay_post_sauna extends GeneratedMessageV3 implements Aux_relay_post_saunaOrBuilder {
        public static final int AUX_RELAY_POST_FIELD_NUMBER = 2;
        public static final int CONNECTED_FIELD_NUMBER = 1;
        private static final Aux_relay_post_sauna DEFAULT_INSTANCE = new Aux_relay_post_sauna();

        @Deprecated
        public static final Parser<Aux_relay_post_sauna> PARSER = new AbstractParser<Aux_relay_post_sauna>() { // from class: com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_sauna.1
            @Override // com.google.protobuf.Parser
            public Aux_relay_post_sauna parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Aux_relay_post_sauna.newBuilder();
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
        private static final long serialVersionUID = 0;
        private Aux_relay_post auxRelayPost_;
        private int bitField0_;
        private boolean connected_;
        private byte memoizedIsInitialized;

        static /* synthetic */ int access$2276(Aux_relay_post_sauna aux_relay_post_sauna, int i) {
            int i2 = i | aux_relay_post_sauna.bitField0_;
            aux_relay_post_sauna.bitField0_ = i2;
            return i2;
        }

        private Aux_relay_post_sauna(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.connected_ = false;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Aux_relay_post_sauna() {
            this.connected_ = false;
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Aux_relay_post_sauna();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_fieldAccessorTable.ensureFieldAccessorsInitialized(Aux_relay_post_sauna.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
        public boolean hasConnected() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
        public boolean getConnected() {
            return this.connected_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
        public boolean hasAuxRelayPost() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
        public Aux_relay_post getAuxRelayPost() {
            Aux_relay_post aux_relay_post = this.auxRelayPost_;
            return aux_relay_post == null ? Aux_relay_post.getDefaultInstance() : aux_relay_post;
        }

        @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
        public Aux_relay_postOrBuilder getAuxRelayPostOrBuilder() {
            Aux_relay_post aux_relay_post = this.auxRelayPost_;
            return aux_relay_post == null ? Aux_relay_post.getDefaultInstance() : aux_relay_post;
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
                codedOutputStream.writeBool(1, this.connected_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeMessage(2, getAuxRelayPost());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeBoolSize(1, this.connected_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeBoolSize += CodedOutputStream.computeMessageSize(2, getAuxRelayPost());
            }
            int serializedSize = computeBoolSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Aux_relay_post_sauna)) {
                return super.equals(obj);
            }
            Aux_relay_post_sauna aux_relay_post_sauna = (Aux_relay_post_sauna) obj;
            if (hasConnected() != aux_relay_post_sauna.hasConnected()) {
                return false;
            }
            if ((!hasConnected() || getConnected() == aux_relay_post_sauna.getConnected()) && hasAuxRelayPost() == aux_relay_post_sauna.hasAuxRelayPost()) {
                return (!hasAuxRelayPost() || getAuxRelayPost().equals(aux_relay_post_sauna.getAuxRelayPost())) && getUnknownFields().equals(aux_relay_post_sauna.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasConnected()) {
                hashCode = (((hashCode * 37) + 1) * 53) + Internal.hashBoolean(getConnected());
            }
            if (hasAuxRelayPost()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getAuxRelayPost().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Aux_relay_post_sauna parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Aux_relay_post_sauna parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Aux_relay_post_sauna parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Aux_relay_post_sauna parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Aux_relay_post_sauna parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Aux_relay_post_sauna parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Aux_relay_post_sauna parseFrom(InputStream inputStream) throws IOException {
            return (Aux_relay_post_sauna) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Aux_relay_post_sauna parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aux_relay_post_sauna) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Aux_relay_post_sauna parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Aux_relay_post_sauna) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Aux_relay_post_sauna parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aux_relay_post_sauna) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Aux_relay_post_sauna parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Aux_relay_post_sauna) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Aux_relay_post_sauna parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aux_relay_post_sauna) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Aux_relay_post_sauna aux_relay_post_sauna) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(aux_relay_post_sauna);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Aux_relay_post_saunaOrBuilder {
            private SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> auxRelayPostBuilder_;
            private Aux_relay_post auxRelayPost_;
            private int bitField0_;
            private boolean connected_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_fieldAccessorTable.ensureFieldAccessorsInitialized(Aux_relay_post_sauna.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Aux_relay_post_sauna.alwaysUseFieldBuilders) {
                    getAuxRelayPostFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.connected_ = false;
                this.auxRelayPost_ = null;
                SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> singleFieldBuilderV3 = this.auxRelayPostBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.auxRelayPostBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AuxRelay.internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Aux_relay_post_sauna getDefaultInstanceForType() {
                return Aux_relay_post_sauna.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Aux_relay_post_sauna build() {
                Aux_relay_post_sauna buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Aux_relay_post_sauna buildPartial() {
                Aux_relay_post_sauna aux_relay_post_sauna = new Aux_relay_post_sauna(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(aux_relay_post_sauna);
                }
                onBuilt();
                return aux_relay_post_sauna;
            }

            private void buildPartial0(Aux_relay_post_sauna aux_relay_post_sauna) {
                int i;
                Aux_relay_post build;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    aux_relay_post_sauna.connected_ = this.connected_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> singleFieldBuilderV3 = this.auxRelayPostBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        build = this.auxRelayPost_;
                    } else {
                        build = singleFieldBuilderV3.build();
                    }
                    aux_relay_post_sauna.auxRelayPost_ = build;
                    i |= 2;
                }
                Aux_relay_post_sauna.access$2276(aux_relay_post_sauna, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Aux_relay_post_sauna) {
                    return mergeFrom((Aux_relay_post_sauna) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Aux_relay_post_sauna aux_relay_post_sauna) {
                if (aux_relay_post_sauna == Aux_relay_post_sauna.getDefaultInstance()) {
                    return this;
                }
                if (aux_relay_post_sauna.hasConnected()) {
                    setConnected(aux_relay_post_sauna.getConnected());
                }
                if (aux_relay_post_sauna.hasAuxRelayPost()) {
                    mergeAuxRelayPost(aux_relay_post_sauna.getAuxRelayPost());
                }
                mergeUnknownFields(aux_relay_post_sauna.getUnknownFields());
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
                                    this.connected_ = codedInputStream.readBool();
                                    this.bitField0_ |= 1;
                                } else if (readTag == 18) {
                                    codedInputStream.readMessage(getAuxRelayPostFieldBuilder().getBuilder(), extensionRegistryLite);
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

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
            public boolean hasConnected() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
            public boolean getConnected() {
                return this.connected_;
            }

            public Builder setConnected(boolean z) {
                this.connected_ = z;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearConnected() {
                this.bitField0_ &= -2;
                this.connected_ = false;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
            public boolean hasAuxRelayPost() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
            public Aux_relay_post getAuxRelayPost() {
                SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> singleFieldBuilderV3 = this.auxRelayPostBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Aux_relay_post aux_relay_post = this.auxRelayPost_;
                    return aux_relay_post == null ? Aux_relay_post.getDefaultInstance() : aux_relay_post;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setAuxRelayPost(Aux_relay_post aux_relay_post) {
                SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> singleFieldBuilderV3 = this.auxRelayPostBuilder_;
                if (singleFieldBuilderV3 == null) {
                    aux_relay_post.getClass();
                    this.auxRelayPost_ = aux_relay_post;
                } else {
                    singleFieldBuilderV3.setMessage(aux_relay_post);
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setAuxRelayPost(Aux_relay_post.Builder builder) {
                SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> singleFieldBuilderV3 = this.auxRelayPostBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.auxRelayPost_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder mergeAuxRelayPost(Aux_relay_post aux_relay_post) {
                Aux_relay_post aux_relay_post2;
                SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> singleFieldBuilderV3 = this.auxRelayPostBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) != 0 && (aux_relay_post2 = this.auxRelayPost_) != null && aux_relay_post2 != Aux_relay_post.getDefaultInstance()) {
                        getAuxRelayPostBuilder().mergeFrom(aux_relay_post);
                    } else {
                        this.auxRelayPost_ = aux_relay_post;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(aux_relay_post);
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearAuxRelayPost() {
                this.bitField0_ &= -3;
                this.auxRelayPost_ = null;
                SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> singleFieldBuilderV3 = this.auxRelayPostBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.auxRelayPostBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Aux_relay_post.Builder getAuxRelayPostBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return getAuxRelayPostFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.AuxRelay.Aux_relay_post_saunaOrBuilder
            public Aux_relay_postOrBuilder getAuxRelayPostOrBuilder() {
                SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> singleFieldBuilderV3 = this.auxRelayPostBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Aux_relay_post aux_relay_post = this.auxRelayPost_;
                return aux_relay_post == null ? Aux_relay_post.getDefaultInstance() : aux_relay_post;
            }

            private SingleFieldBuilderV3<Aux_relay_post, Aux_relay_post.Builder, Aux_relay_postOrBuilder> getAuxRelayPostFieldBuilder() {
                if (this.auxRelayPostBuilder_ == null) {
                    this.auxRelayPostBuilder_ = new SingleFieldBuilderV3<>(getAuxRelayPost(), getParentForChildren(), isClean());
                    this.auxRelayPost_ = null;
                }
                return this.auxRelayPostBuilder_;
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

        public static Aux_relay_post_sauna getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Aux_relay_post_sauna> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Aux_relay_post_sauna> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Aux_relay_post_sauna getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Index", "Function", "Name", "Active"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_descriptor = descriptor3;
        internal_static_com_tylohelo_tylohelo_protobuf_Aux_relay_post_sauna_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Connected", "AuxRelayPost"});
    }
}
