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
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Favorite {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000efavorite.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"»\u0001\n\rFavorite_post\u0012\r\n\u0005index\u0018\u0001 \u0001(\r\u0012\r\n\u0005valid\u0018\u0002 \u0001(\b\u0012\f\n\u0004name\u0018\u0003 \u0003(\r\u0012\u001a\n\u0012humidity_set_point\u0018\u0004 \u0001(\r\u0012\u001d\n\u0015temperature_set_point\u0018\u0005 \u0001(\r\u0012\u0011\n\tbath_time\u0018\u0006 \u0001(\r\u0012\u0010\n\blight_on\u0018\u0007 \u0001(\b\u0012\u001e\n\u0016auxiliary_relay_active\u0018\b \u0003(\bB\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_fieldAccessorTable;

    public interface Favorite_postOrBuilder extends MessageOrBuilder {
        boolean getAuxiliaryRelayActive(int i);

        int getAuxiliaryRelayActiveCount();

        List<Boolean> getAuxiliaryRelayActiveList();

        int getBathTime();

        int getHumiditySetPoint();

        int getIndex();

        boolean getLightOn();

        int getName(int i);

        int getNameCount();

        List<Integer> getNameList();

        int getTemperatureSetPoint();

        boolean getValid();

        boolean hasBathTime();

        boolean hasHumiditySetPoint();

        boolean hasIndex();

        boolean hasLightOn();

        boolean hasTemperatureSetPoint();

        boolean hasValid();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Favorite() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Favorite_post extends GeneratedMessageV3 implements Favorite_postOrBuilder {
        public static final int AUXILIARY_RELAY_ACTIVE_FIELD_NUMBER = 8;
        public static final int BATH_TIME_FIELD_NUMBER = 6;
        public static final int HUMIDITY_SET_POINT_FIELD_NUMBER = 4;
        public static final int INDEX_FIELD_NUMBER = 1;
        public static final int LIGHT_ON_FIELD_NUMBER = 7;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int TEMPERATURE_SET_POINT_FIELD_NUMBER = 5;
        public static final int VALID_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private Internal.BooleanList auxiliaryRelayActive_;
        private int bathTime_;
        private int bitField0_;
        private int humiditySetPoint_;
        private int index_;
        private boolean lightOn_;
        private byte memoizedIsInitialized;
        private Internal.IntList name_;
        private int temperatureSetPoint_;
        private boolean valid_;
        private static final Favorite_post DEFAULT_INSTANCE = new Favorite_post();

        @Deprecated
        public static final Parser<Favorite_post> PARSER = new AbstractParser<Favorite_post>() { // from class: com.tylohelo.tylohelo.protobuf.Favorite.Favorite_post.1
            @Override // com.google.protobuf.Parser
            public Favorite_post parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Favorite_post.newBuilder();
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

        static /* synthetic */ int access$1576(Favorite_post favorite_post, int i) {
            int i2 = i | favorite_post.bitField0_;
            favorite_post.bitField0_ = i2;
            return i2;
        }

        private Favorite_post(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.index_ = 0;
            this.valid_ = false;
            this.humiditySetPoint_ = 0;
            this.temperatureSetPoint_ = 0;
            this.bathTime_ = 0;
            this.lightOn_ = false;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Favorite_post() {
            this.index_ = 0;
            this.valid_ = false;
            this.humiditySetPoint_ = 0;
            this.temperatureSetPoint_ = 0;
            this.bathTime_ = 0;
            this.lightOn_ = false;
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = emptyIntList();
            this.auxiliaryRelayActive_ = emptyBooleanList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Favorite_post();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Favorite.internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Favorite.internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_fieldAccessorTable.ensureFieldAccessorsInitialized(Favorite_post.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean hasIndex() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean hasValid() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean getValid() {
            return this.valid_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public List<Integer> getNameList() {
            return this.name_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public int getNameCount() {
            return this.name_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public int getName(int i) {
            return this.name_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean hasHumiditySetPoint() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public int getHumiditySetPoint() {
            return this.humiditySetPoint_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean hasTemperatureSetPoint() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public int getTemperatureSetPoint() {
            return this.temperatureSetPoint_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean hasBathTime() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public int getBathTime() {
            return this.bathTime_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean hasLightOn() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean getLightOn() {
            return this.lightOn_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public List<Boolean> getAuxiliaryRelayActiveList() {
            return this.auxiliaryRelayActive_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public int getAuxiliaryRelayActiveCount() {
            return this.auxiliaryRelayActive_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
        public boolean getAuxiliaryRelayActive(int i) {
            return this.auxiliaryRelayActive_.getBoolean(i);
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
                codedOutputStream.writeBool(2, this.valid_);
            }
            for (int i = 0; i < this.name_.size(); i++) {
                codedOutputStream.writeUInt32(3, this.name_.getInt(i));
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeUInt32(4, this.humiditySetPoint_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeUInt32(5, this.temperatureSetPoint_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeUInt32(6, this.bathTime_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.writeBool(7, this.lightOn_);
            }
            for (int i2 = 0; i2 < this.auxiliaryRelayActive_.size(); i2++) {
                codedOutputStream.writeBool(8, this.auxiliaryRelayActive_.getBoolean(i2));
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
                computeUInt32Size += CodedOutputStream.computeBoolSize(2, this.valid_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.name_.size(); i3++) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(this.name_.getInt(i3));
            }
            int size = computeUInt32Size + i2 + getNameList().size();
            if ((this.bitField0_ & 4) != 0) {
                size += CodedOutputStream.computeUInt32Size(4, this.humiditySetPoint_);
            }
            if ((this.bitField0_ & 8) != 0) {
                size += CodedOutputStream.computeUInt32Size(5, this.temperatureSetPoint_);
            }
            if ((this.bitField0_ & 16) != 0) {
                size += CodedOutputStream.computeUInt32Size(6, this.bathTime_);
            }
            if ((this.bitField0_ & 32) != 0) {
                size += CodedOutputStream.computeBoolSize(7, this.lightOn_);
            }
            int size2 = size + getAuxiliaryRelayActiveList().size() + getAuxiliaryRelayActiveList().size() + getUnknownFields().getSerializedSize();
            this.memoizedSize = size2;
            return size2;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Favorite_post)) {
                return super.equals(obj);
            }
            Favorite_post favorite_post = (Favorite_post) obj;
            if (hasIndex() != favorite_post.hasIndex()) {
                return false;
            }
            if ((hasIndex() && getIndex() != favorite_post.getIndex()) || hasValid() != favorite_post.hasValid()) {
                return false;
            }
            if ((hasValid() && getValid() != favorite_post.getValid()) || !getNameList().equals(favorite_post.getNameList()) || hasHumiditySetPoint() != favorite_post.hasHumiditySetPoint()) {
                return false;
            }
            if ((hasHumiditySetPoint() && getHumiditySetPoint() != favorite_post.getHumiditySetPoint()) || hasTemperatureSetPoint() != favorite_post.hasTemperatureSetPoint()) {
                return false;
            }
            if ((hasTemperatureSetPoint() && getTemperatureSetPoint() != favorite_post.getTemperatureSetPoint()) || hasBathTime() != favorite_post.hasBathTime()) {
                return false;
            }
            if ((!hasBathTime() || getBathTime() == favorite_post.getBathTime()) && hasLightOn() == favorite_post.hasLightOn()) {
                return (!hasLightOn() || getLightOn() == favorite_post.getLightOn()) && getAuxiliaryRelayActiveList().equals(favorite_post.getAuxiliaryRelayActiveList()) && getUnknownFields().equals(favorite_post.getUnknownFields());
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
            if (hasValid()) {
                hashCode = (((hashCode * 37) + 2) * 53) + Internal.hashBoolean(getValid());
            }
            if (getNameCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getNameList().hashCode();
            }
            if (hasHumiditySetPoint()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getHumiditySetPoint();
            }
            if (hasTemperatureSetPoint()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getTemperatureSetPoint();
            }
            if (hasBathTime()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getBathTime();
            }
            if (hasLightOn()) {
                hashCode = (((hashCode * 37) + 7) * 53) + Internal.hashBoolean(getLightOn());
            }
            if (getAuxiliaryRelayActiveCount() > 0) {
                hashCode = (((hashCode * 37) + 8) * 53) + getAuxiliaryRelayActiveList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Favorite_post parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Favorite_post parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Favorite_post parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Favorite_post parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Favorite_post parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Favorite_post parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Favorite_post parseFrom(InputStream inputStream) throws IOException {
            return (Favorite_post) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Favorite_post parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Favorite_post) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Favorite_post parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Favorite_post) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Favorite_post parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Favorite_post) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Favorite_post parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Favorite_post) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Favorite_post parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Favorite_post) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Favorite_post favorite_post) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(favorite_post);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Favorite_postOrBuilder {
            private Internal.BooleanList auxiliaryRelayActive_;
            private int bathTime_;
            private int bitField0_;
            private int humiditySetPoint_;
            private int index_;
            private boolean lightOn_;
            private Internal.IntList name_;
            private int temperatureSetPoint_;
            private boolean valid_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Favorite.internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Favorite.internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_fieldAccessorTable.ensureFieldAccessorsInitialized(Favorite_post.class, Builder.class);
            }

            private Builder() {
                this.name_ = Favorite_post.emptyIntList();
                this.auxiliaryRelayActive_ = Favorite_post.emptyBooleanList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = Favorite_post.emptyIntList();
                this.auxiliaryRelayActive_ = Favorite_post.emptyBooleanList();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.index_ = 0;
                this.valid_ = false;
                this.name_ = Favorite_post.emptyIntList();
                this.humiditySetPoint_ = 0;
                this.temperatureSetPoint_ = 0;
                this.bathTime_ = 0;
                this.lightOn_ = false;
                this.auxiliaryRelayActive_ = Favorite_post.emptyBooleanList();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Favorite.internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Favorite_post getDefaultInstanceForType() {
                return Favorite_post.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Favorite_post build() {
                Favorite_post buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Favorite_post buildPartial() {
                Favorite_post favorite_post = new Favorite_post(this);
                buildPartialRepeatedFields(favorite_post);
                if (this.bitField0_ != 0) {
                    buildPartial0(favorite_post);
                }
                onBuilt();
                return favorite_post;
            }

            private void buildPartialRepeatedFields(Favorite_post favorite_post) {
                if ((this.bitField0_ & 4) != 0) {
                    this.name_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                favorite_post.name_ = this.name_;
                if ((this.bitField0_ & 128) != 0) {
                    this.auxiliaryRelayActive_.makeImmutable();
                    this.bitField0_ &= -129;
                }
                favorite_post.auxiliaryRelayActive_ = this.auxiliaryRelayActive_;
            }

            private void buildPartial0(Favorite_post favorite_post) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    favorite_post.index_ = this.index_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    favorite_post.valid_ = this.valid_;
                    i |= 2;
                }
                if ((i2 & 8) != 0) {
                    favorite_post.humiditySetPoint_ = this.humiditySetPoint_;
                    i |= 4;
                }
                if ((i2 & 16) != 0) {
                    favorite_post.temperatureSetPoint_ = this.temperatureSetPoint_;
                    i |= 8;
                }
                if ((i2 & 32) != 0) {
                    favorite_post.bathTime_ = this.bathTime_;
                    i |= 16;
                }
                if ((i2 & 64) != 0) {
                    favorite_post.lightOn_ = this.lightOn_;
                    i |= 32;
                }
                Favorite_post.access$1576(favorite_post, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Favorite_post) {
                    return mergeFrom((Favorite_post) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Favorite_post favorite_post) {
                if (favorite_post == Favorite_post.getDefaultInstance()) {
                    return this;
                }
                if (favorite_post.hasIndex()) {
                    setIndex(favorite_post.getIndex());
                }
                if (favorite_post.hasValid()) {
                    setValid(favorite_post.getValid());
                }
                if (!favorite_post.name_.isEmpty()) {
                    if (this.name_.isEmpty()) {
                        this.name_ = favorite_post.name_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureNameIsMutable();
                        this.name_.addAll(favorite_post.name_);
                    }
                    onChanged();
                }
                if (favorite_post.hasHumiditySetPoint()) {
                    setHumiditySetPoint(favorite_post.getHumiditySetPoint());
                }
                if (favorite_post.hasTemperatureSetPoint()) {
                    setTemperatureSetPoint(favorite_post.getTemperatureSetPoint());
                }
                if (favorite_post.hasBathTime()) {
                    setBathTime(favorite_post.getBathTime());
                }
                if (favorite_post.hasLightOn()) {
                    setLightOn(favorite_post.getLightOn());
                }
                if (!favorite_post.auxiliaryRelayActive_.isEmpty()) {
                    if (this.auxiliaryRelayActive_.isEmpty()) {
                        this.auxiliaryRelayActive_ = favorite_post.auxiliaryRelayActive_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureAuxiliaryRelayActiveIsMutable();
                        this.auxiliaryRelayActive_.addAll(favorite_post.auxiliaryRelayActive_);
                    }
                    onChanged();
                }
                mergeUnknownFields(favorite_post.getUnknownFields());
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
                            switch (readTag) {
                                case 0:
                                    z = true;
                                case 8:
                                    this.index_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 1;
                                case 16:
                                    this.valid_ = codedInputStream.readBool();
                                    this.bitField0_ |= 2;
                                case 24:
                                    int readUInt32 = codedInputStream.readUInt32();
                                    ensureNameIsMutable();
                                    this.name_.addInt(readUInt32);
                                case 26:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureNameIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.name_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                case 32:
                                    this.humiditySetPoint_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 8;
                                case 40:
                                    this.temperatureSetPoint_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 16;
                                case 48:
                                    this.bathTime_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 32;
                                case 56:
                                    this.lightOn_ = codedInputStream.readBool();
                                    this.bitField0_ |= 64;
                                case 64:
                                    boolean readBool = codedInputStream.readBool();
                                    ensureAuxiliaryRelayActiveIsMutable();
                                    this.auxiliaryRelayActive_.addBoolean(readBool);
                                case 66:
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureAuxiliaryRelayActiveIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.auxiliaryRelayActive_.addBoolean(codedInputStream.readBool());
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                default:
                                    if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.unwrapIOException();
                        }
                    } finally {
                        onChanged();
                    }
                }
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean hasIndex() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
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

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean hasValid() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean getValid() {
                return this.valid_;
            }

            public Builder setValid(boolean z) {
                this.valid_ = z;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearValid() {
                this.bitField0_ &= -3;
                this.valid_ = false;
                onChanged();
                return this;
            }

            private void ensureNameIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.name_ = Favorite_post.mutableCopy(this.name_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public List<Integer> getNameList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.name_) : this.name_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public int getNameCount() {
                return this.name_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
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
                this.name_ = Favorite_post.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean hasHumiditySetPoint() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public int getHumiditySetPoint() {
                return this.humiditySetPoint_;
            }

            public Builder setHumiditySetPoint(int i) {
                this.humiditySetPoint_ = i;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearHumiditySetPoint() {
                this.bitField0_ &= -9;
                this.humiditySetPoint_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean hasTemperatureSetPoint() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public int getTemperatureSetPoint() {
                return this.temperatureSetPoint_;
            }

            public Builder setTemperatureSetPoint(int i) {
                this.temperatureSetPoint_ = i;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder clearTemperatureSetPoint() {
                this.bitField0_ &= -17;
                this.temperatureSetPoint_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean hasBathTime() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public int getBathTime() {
                return this.bathTime_;
            }

            public Builder setBathTime(int i) {
                this.bathTime_ = i;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder clearBathTime() {
                this.bitField0_ &= -33;
                this.bathTime_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean hasLightOn() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean getLightOn() {
                return this.lightOn_;
            }

            public Builder setLightOn(boolean z) {
                this.lightOn_ = z;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder clearLightOn() {
                this.bitField0_ &= -65;
                this.lightOn_ = false;
                onChanged();
                return this;
            }

            private void ensureAuxiliaryRelayActiveIsMutable() {
                if ((this.bitField0_ & 128) == 0) {
                    this.auxiliaryRelayActive_ = Favorite_post.mutableCopy(this.auxiliaryRelayActive_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public List<Boolean> getAuxiliaryRelayActiveList() {
                return (this.bitField0_ & 128) != 0 ? Collections.unmodifiableList(this.auxiliaryRelayActive_) : this.auxiliaryRelayActive_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public int getAuxiliaryRelayActiveCount() {
                return this.auxiliaryRelayActive_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Favorite.Favorite_postOrBuilder
            public boolean getAuxiliaryRelayActive(int i) {
                return this.auxiliaryRelayActive_.getBoolean(i);
            }

            public Builder setAuxiliaryRelayActive(int i, boolean z) {
                ensureAuxiliaryRelayActiveIsMutable();
                this.auxiliaryRelayActive_.setBoolean(i, z);
                onChanged();
                return this;
            }

            public Builder addAuxiliaryRelayActive(boolean z) {
                ensureAuxiliaryRelayActiveIsMutable();
                this.auxiliaryRelayActive_.addBoolean(z);
                onChanged();
                return this;
            }

            public Builder addAllAuxiliaryRelayActive(Iterable<? extends Boolean> iterable) {
                ensureAuxiliaryRelayActiveIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.auxiliaryRelayActive_);
                onChanged();
                return this;
            }

            public Builder clearAuxiliaryRelayActive() {
                this.auxiliaryRelayActive_ = Favorite_post.emptyBooleanList();
                this.bitField0_ &= -129;
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

        public static Favorite_post getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Favorite_post> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Favorite_post> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Favorite_post getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_Favorite_post_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Index", "Valid", "Name", "HumiditySetPoint", "TemperatureSetPoint", "BathTime", "LightOn", "AuxiliaryRelayActive"});
    }
}
