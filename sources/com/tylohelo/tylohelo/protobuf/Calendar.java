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
public final class Calendar {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000ecalendar.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"Ú\u0002\n\rCalendar_post\u0012\r\n\u0005index\u0018\u0001 \u0001(\r\u0012\r\n\u0005valid\u0018\u0002 \u0001(\b\u0012\u0017\n\u000factivation_time\u0018\u0003 \u0001(\u0004\u0012\u0011\n\tbath_time\u0018\u0004 \u0001(\r\u0012\u001a\n\u0012humidity_set_point\u0018\u0005 \u0001(\r\u0012\u001d\n\u0015temperature_set_point\u0018\u0006 \u0001(\r\u0012\u000f\n\u0007weekday\u0018\u0007 \u0001(\b\u0012N\n\nstart_mode\u0018\b \u0001(\u000e2:.com.tylohelo.tylohelo.protobuf.Calendar_post.start_mode_t\u0012\u000f\n\u0007standby\u0018\t \u0001(\b\u0012\u0010\n\bfavorite\u0018\n \u0001(\r\"@\n\fstart_mode_t\u0012\u0017\n\u0013START_MODE_START_AT\u0010\u0001\u0012\u0017\n\u0013START_MODE_READY_AT\u0010\u0002B\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_fieldAccessorTable;

    public interface Calendar_postOrBuilder extends MessageOrBuilder {
        long getActivationTime();

        int getBathTime();

        int getFavorite();

        int getHumiditySetPoint();

        int getIndex();

        boolean getStandby();

        Calendar_post.start_mode_t getStartMode();

        int getTemperatureSetPoint();

        boolean getValid();

        boolean getWeekday();

        boolean hasActivationTime();

        boolean hasBathTime();

        boolean hasFavorite();

        boolean hasHumiditySetPoint();

        boolean hasIndex();

        boolean hasStandby();

        boolean hasStartMode();

        boolean hasTemperatureSetPoint();

        boolean hasValid();

        boolean hasWeekday();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Calendar() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Calendar_post extends GeneratedMessageV3 implements Calendar_postOrBuilder {
        public static final int ACTIVATION_TIME_FIELD_NUMBER = 3;
        public static final int BATH_TIME_FIELD_NUMBER = 4;
        public static final int FAVORITE_FIELD_NUMBER = 10;
        public static final int HUMIDITY_SET_POINT_FIELD_NUMBER = 5;
        public static final int INDEX_FIELD_NUMBER = 1;
        public static final int STANDBY_FIELD_NUMBER = 9;
        public static final int START_MODE_FIELD_NUMBER = 8;
        public static final int TEMPERATURE_SET_POINT_FIELD_NUMBER = 6;
        public static final int VALID_FIELD_NUMBER = 2;
        public static final int WEEKDAY_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private long activationTime_;
        private int bathTime_;
        private int bitField0_;
        private int favorite_;
        private int humiditySetPoint_;
        private int index_;
        private byte memoizedIsInitialized;
        private boolean standby_;
        private int startMode_;
        private int temperatureSetPoint_;
        private boolean valid_;
        private boolean weekday_;
        private static final Calendar_post DEFAULT_INSTANCE = new Calendar_post();

        @Deprecated
        public static final Parser<Calendar_post> PARSER = new AbstractParser<Calendar_post>() { // from class: com.tylohelo.tylohelo.protobuf.Calendar.Calendar_post.1
            @Override // com.google.protobuf.Parser
            public Calendar_post parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Calendar_post.newBuilder();
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

        static /* synthetic */ int access$1576(Calendar_post calendar_post, int i) {
            int i2 = i | calendar_post.bitField0_;
            calendar_post.bitField0_ = i2;
            return i2;
        }

        private Calendar_post(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.index_ = 0;
            this.valid_ = false;
            this.activationTime_ = 0L;
            this.bathTime_ = 0;
            this.humiditySetPoint_ = 0;
            this.temperatureSetPoint_ = 0;
            this.weekday_ = false;
            this.startMode_ = 1;
            this.standby_ = false;
            this.favorite_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Calendar_post() {
            this.index_ = 0;
            this.valid_ = false;
            this.activationTime_ = 0L;
            this.bathTime_ = 0;
            this.humiditySetPoint_ = 0;
            this.temperatureSetPoint_ = 0;
            this.weekday_ = false;
            this.standby_ = false;
            this.favorite_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.startMode_ = 1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Calendar_post();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Calendar.internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Calendar.internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_fieldAccessorTable.ensureFieldAccessorsInitialized(Calendar_post.class, Builder.class);
        }

        public enum start_mode_t implements ProtocolMessageEnum {
            START_MODE_START_AT(1),
            START_MODE_READY_AT(2);

            public static final int START_MODE_READY_AT_VALUE = 2;
            public static final int START_MODE_START_AT_VALUE = 1;
            private final int value;
            private static final Internal.EnumLiteMap<start_mode_t> internalValueMap = new Internal.EnumLiteMap<start_mode_t>() { // from class: com.tylohelo.tylohelo.protobuf.Calendar.Calendar_post.start_mode_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public start_mode_t findValueByNumber(int i) {
                    return start_mode_t.forNumber(i);
                }
            };
            private static final start_mode_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static start_mode_t valueOf(int i) {
                return forNumber(i);
            }

            public static start_mode_t forNumber(int i) {
                if (i == 1) {
                    return START_MODE_START_AT;
                }
                if (i != 2) {
                    return null;
                }
                return START_MODE_READY_AT;
            }

            public static Internal.EnumLiteMap<start_mode_t> internalGetValueMap() {
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
                return Calendar_post.getDescriptor().getEnumTypes().get(0);
            }

            public static start_mode_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            start_mode_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasIndex() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasValid() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean getValid() {
            return this.valid_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasActivationTime() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public long getActivationTime() {
            return this.activationTime_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasBathTime() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public int getBathTime() {
            return this.bathTime_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasHumiditySetPoint() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public int getHumiditySetPoint() {
            return this.humiditySetPoint_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasTemperatureSetPoint() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public int getTemperatureSetPoint() {
            return this.temperatureSetPoint_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasWeekday() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean getWeekday() {
            return this.weekday_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasStartMode() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public start_mode_t getStartMode() {
            start_mode_t forNumber = start_mode_t.forNumber(this.startMode_);
            return forNumber == null ? start_mode_t.START_MODE_START_AT : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasStandby() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean getStandby() {
            return this.standby_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public boolean hasFavorite() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
        public int getFavorite() {
            return this.favorite_;
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
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeUInt64(3, this.activationTime_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeUInt32(4, this.bathTime_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeUInt32(5, this.humiditySetPoint_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.writeUInt32(6, this.temperatureSetPoint_);
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputStream.writeBool(7, this.weekday_);
            }
            if ((this.bitField0_ & 128) != 0) {
                codedOutputStream.writeEnum(8, this.startMode_);
            }
            if ((this.bitField0_ & 256) != 0) {
                codedOutputStream.writeBool(9, this.standby_);
            }
            if ((this.bitField0_ & 512) != 0) {
                codedOutputStream.writeUInt32(10, this.favorite_);
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
            if ((this.bitField0_ & 4) != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt64Size(3, this.activationTime_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(4, this.bathTime_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(5, this.humiditySetPoint_);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(6, this.temperatureSetPoint_);
            }
            if ((this.bitField0_ & 64) != 0) {
                computeUInt32Size += CodedOutputStream.computeBoolSize(7, this.weekday_);
            }
            if ((this.bitField0_ & 128) != 0) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(8, this.startMode_);
            }
            if ((this.bitField0_ & 256) != 0) {
                computeUInt32Size += CodedOutputStream.computeBoolSize(9, this.standby_);
            }
            if ((this.bitField0_ & 512) != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(10, this.favorite_);
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
            if (!(obj instanceof Calendar_post)) {
                return super.equals(obj);
            }
            Calendar_post calendar_post = (Calendar_post) obj;
            if (hasIndex() != calendar_post.hasIndex()) {
                return false;
            }
            if ((hasIndex() && getIndex() != calendar_post.getIndex()) || hasValid() != calendar_post.hasValid()) {
                return false;
            }
            if ((hasValid() && getValid() != calendar_post.getValid()) || hasActivationTime() != calendar_post.hasActivationTime()) {
                return false;
            }
            if ((hasActivationTime() && getActivationTime() != calendar_post.getActivationTime()) || hasBathTime() != calendar_post.hasBathTime()) {
                return false;
            }
            if ((hasBathTime() && getBathTime() != calendar_post.getBathTime()) || hasHumiditySetPoint() != calendar_post.hasHumiditySetPoint()) {
                return false;
            }
            if ((hasHumiditySetPoint() && getHumiditySetPoint() != calendar_post.getHumiditySetPoint()) || hasTemperatureSetPoint() != calendar_post.hasTemperatureSetPoint()) {
                return false;
            }
            if ((hasTemperatureSetPoint() && getTemperatureSetPoint() != calendar_post.getTemperatureSetPoint()) || hasWeekday() != calendar_post.hasWeekday()) {
                return false;
            }
            if ((hasWeekday() && getWeekday() != calendar_post.getWeekday()) || hasStartMode() != calendar_post.hasStartMode()) {
                return false;
            }
            if ((hasStartMode() && this.startMode_ != calendar_post.startMode_) || hasStandby() != calendar_post.hasStandby()) {
                return false;
            }
            if ((!hasStandby() || getStandby() == calendar_post.getStandby()) && hasFavorite() == calendar_post.hasFavorite()) {
                return (!hasFavorite() || getFavorite() == calendar_post.getFavorite()) && getUnknownFields().equals(calendar_post.getUnknownFields());
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
            if (hasActivationTime()) {
                hashCode = (((hashCode * 37) + 3) * 53) + Internal.hashLong(getActivationTime());
            }
            if (hasBathTime()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getBathTime();
            }
            if (hasHumiditySetPoint()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getHumiditySetPoint();
            }
            if (hasTemperatureSetPoint()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getTemperatureSetPoint();
            }
            if (hasWeekday()) {
                hashCode = (((hashCode * 37) + 7) * 53) + Internal.hashBoolean(getWeekday());
            }
            if (hasStartMode()) {
                hashCode = (((hashCode * 37) + 8) * 53) + this.startMode_;
            }
            if (hasStandby()) {
                hashCode = (((hashCode * 37) + 9) * 53) + Internal.hashBoolean(getStandby());
            }
            if (hasFavorite()) {
                hashCode = (((hashCode * 37) + 10) * 53) + getFavorite();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Calendar_post parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Calendar_post parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Calendar_post parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Calendar_post parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Calendar_post parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Calendar_post parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Calendar_post parseFrom(InputStream inputStream) throws IOException {
            return (Calendar_post) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Calendar_post parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Calendar_post) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Calendar_post parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Calendar_post) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Calendar_post parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Calendar_post) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Calendar_post parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Calendar_post) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Calendar_post parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Calendar_post) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Calendar_post calendar_post) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(calendar_post);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Calendar_postOrBuilder {
            private long activationTime_;
            private int bathTime_;
            private int bitField0_;
            private int favorite_;
            private int humiditySetPoint_;
            private int index_;
            private boolean standby_;
            private int startMode_;
            private int temperatureSetPoint_;
            private boolean valid_;
            private boolean weekday_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Calendar.internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Calendar.internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_fieldAccessorTable.ensureFieldAccessorsInitialized(Calendar_post.class, Builder.class);
            }

            private Builder() {
                this.startMode_ = 1;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.startMode_ = 1;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.index_ = 0;
                this.valid_ = false;
                this.activationTime_ = 0L;
                this.bathTime_ = 0;
                this.humiditySetPoint_ = 0;
                this.temperatureSetPoint_ = 0;
                this.weekday_ = false;
                this.startMode_ = 1;
                this.standby_ = false;
                this.favorite_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Calendar.internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Calendar_post getDefaultInstanceForType() {
                return Calendar_post.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Calendar_post build() {
                Calendar_post buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Calendar_post buildPartial() {
                Calendar_post calendar_post = new Calendar_post(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(calendar_post);
                }
                onBuilt();
                return calendar_post;
            }

            private void buildPartial0(Calendar_post calendar_post) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    calendar_post.index_ = this.index_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    calendar_post.valid_ = this.valid_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    calendar_post.activationTime_ = this.activationTime_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    calendar_post.bathTime_ = this.bathTime_;
                    i |= 8;
                }
                if ((i2 & 16) != 0) {
                    calendar_post.humiditySetPoint_ = this.humiditySetPoint_;
                    i |= 16;
                }
                if ((i2 & 32) != 0) {
                    calendar_post.temperatureSetPoint_ = this.temperatureSetPoint_;
                    i |= 32;
                }
                if ((i2 & 64) != 0) {
                    calendar_post.weekday_ = this.weekday_;
                    i |= 64;
                }
                if ((i2 & 128) != 0) {
                    calendar_post.startMode_ = this.startMode_;
                    i |= 128;
                }
                if ((i2 & 256) != 0) {
                    calendar_post.standby_ = this.standby_;
                    i |= 256;
                }
                if ((i2 & 512) != 0) {
                    calendar_post.favorite_ = this.favorite_;
                    i |= 512;
                }
                Calendar_post.access$1576(calendar_post, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Calendar_post) {
                    return mergeFrom((Calendar_post) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Calendar_post calendar_post) {
                if (calendar_post == Calendar_post.getDefaultInstance()) {
                    return this;
                }
                if (calendar_post.hasIndex()) {
                    setIndex(calendar_post.getIndex());
                }
                if (calendar_post.hasValid()) {
                    setValid(calendar_post.getValid());
                }
                if (calendar_post.hasActivationTime()) {
                    setActivationTime(calendar_post.getActivationTime());
                }
                if (calendar_post.hasBathTime()) {
                    setBathTime(calendar_post.getBathTime());
                }
                if (calendar_post.hasHumiditySetPoint()) {
                    setHumiditySetPoint(calendar_post.getHumiditySetPoint());
                }
                if (calendar_post.hasTemperatureSetPoint()) {
                    setTemperatureSetPoint(calendar_post.getTemperatureSetPoint());
                }
                if (calendar_post.hasWeekday()) {
                    setWeekday(calendar_post.getWeekday());
                }
                if (calendar_post.hasStartMode()) {
                    setStartMode(calendar_post.getStartMode());
                }
                if (calendar_post.hasStandby()) {
                    setStandby(calendar_post.getStandby());
                }
                if (calendar_post.hasFavorite()) {
                    setFavorite(calendar_post.getFavorite());
                }
                mergeUnknownFields(calendar_post.getUnknownFields());
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
                                    this.activationTime_ = codedInputStream.readUInt64();
                                    this.bitField0_ |= 4;
                                case 32:
                                    this.bathTime_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 8;
                                case 40:
                                    this.humiditySetPoint_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 16;
                                case 48:
                                    this.temperatureSetPoint_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 32;
                                case 56:
                                    this.weekday_ = codedInputStream.readBool();
                                    this.bitField0_ |= 64;
                                case 64:
                                    int readEnum = codedInputStream.readEnum();
                                    if (start_mode_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(8, readEnum);
                                    } else {
                                        this.startMode_ = readEnum;
                                        this.bitField0_ |= 128;
                                    }
                                case 72:
                                    this.standby_ = codedInputStream.readBool();
                                    this.bitField0_ |= 256;
                                case 80:
                                    this.favorite_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 512;
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

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasIndex() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
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

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasValid() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
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

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasActivationTime() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public long getActivationTime() {
                return this.activationTime_;
            }

            public Builder setActivationTime(long j) {
                this.activationTime_ = j;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearActivationTime() {
                this.bitField0_ &= -5;
                this.activationTime_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasBathTime() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public int getBathTime() {
                return this.bathTime_;
            }

            public Builder setBathTime(int i) {
                this.bathTime_ = i;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearBathTime() {
                this.bitField0_ &= -9;
                this.bathTime_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasHumiditySetPoint() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public int getHumiditySetPoint() {
                return this.humiditySetPoint_;
            }

            public Builder setHumiditySetPoint(int i) {
                this.humiditySetPoint_ = i;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder clearHumiditySetPoint() {
                this.bitField0_ &= -17;
                this.humiditySetPoint_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasTemperatureSetPoint() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public int getTemperatureSetPoint() {
                return this.temperatureSetPoint_;
            }

            public Builder setTemperatureSetPoint(int i) {
                this.temperatureSetPoint_ = i;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder clearTemperatureSetPoint() {
                this.bitField0_ &= -33;
                this.temperatureSetPoint_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasWeekday() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean getWeekday() {
                return this.weekday_;
            }

            public Builder setWeekday(boolean z) {
                this.weekday_ = z;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder clearWeekday() {
                this.bitField0_ &= -65;
                this.weekday_ = false;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasStartMode() {
                return (this.bitField0_ & 128) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public start_mode_t getStartMode() {
                start_mode_t forNumber = start_mode_t.forNumber(this.startMode_);
                return forNumber == null ? start_mode_t.START_MODE_START_AT : forNumber;
            }

            public Builder setStartMode(start_mode_t start_mode_tVar) {
                start_mode_tVar.getClass();
                this.bitField0_ |= 128;
                this.startMode_ = start_mode_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStartMode() {
                this.bitField0_ &= -129;
                this.startMode_ = 1;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasStandby() {
                return (this.bitField0_ & 256) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean getStandby() {
                return this.standby_;
            }

            public Builder setStandby(boolean z) {
                this.standby_ = z;
                this.bitField0_ |= 256;
                onChanged();
                return this;
            }

            public Builder clearStandby() {
                this.bitField0_ &= -257;
                this.standby_ = false;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public boolean hasFavorite() {
                return (this.bitField0_ & 512) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Calendar.Calendar_postOrBuilder
            public int getFavorite() {
                return this.favorite_;
            }

            public Builder setFavorite(int i) {
                this.favorite_ = i;
                this.bitField0_ |= 512;
                onChanged();
                return this;
            }

            public Builder clearFavorite() {
                this.bitField0_ &= -513;
                this.favorite_ = 0;
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

        public static Calendar_post getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Calendar_post> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Calendar_post> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Calendar_post getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_Calendar_post_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Index", "Valid", "ActivationTime", "BathTime", "HumiditySetPoint", "TemperatureSetPoint", "Weekday", "StartMode", "Standby", "Favorite"});
    }
}
