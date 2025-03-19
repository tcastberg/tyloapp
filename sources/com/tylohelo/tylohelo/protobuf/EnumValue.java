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
public final class EnumValue {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010enum_value.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"Þ\u0003\n\u0010Enum_value_types\"L\n\rwater_level_t\u0012\f\n\bWLVL_LOW\u0010\n\u0012\f\n\bWLVL_MID\u0010\u000b\u0012\r\n\tWLVL_HIGH\u0010\f\u0012\u0010\n\fWLVL_UNKNOWN\u0010\r\"\u0094\u0001\n\u000ffacility_type_t\u0012\u0017\n\u0013FAC_TYPE_SUPERVISED\u0010\u0014\u0012\u001c\n\u0018FAC_TYPE_TIME_CONTROLLED\u0010\u0015\u0012\u001f\n\u001bFAC_TYPE_PRIVATE_CONTROLLED\u0010\u0016\u0012\u0013\n\u000fFAC_TYPE_PUBLIC\u0010\u0017\u0012\u0014\n\u0010FAC_TYPE_UNKNOWN\u0010\u0018\"E\n\bregion_t\u0012\r\n\tREGION_EU\u0010\u001e\u0012\u0018\n\u0014REGION_NORTH_AMERICA\u0010\u001f\u0012\u0010\n\fREGION_OTHER\u0010 \"?\n\u001aexternal_switch_function_t\u0012\u0010\n\fEXTSW_ON_OFF\u0010(\u0012\u000f\n\u000bEXTSW_RENEW\u0010)\"]\n\u000fbath_priority_t\u0012\u0017\n\u0013BATH_PRIO_AUTOMATIC\u00102\u0012\u0019\n\u0015BATH_PRIO_TEMPERATURE\u00103\u0012\u0016\n\u0012BATH_PRIO_HUMIDITY\u00104\"\u008f\u0005\n\u0012Enum_value_changed\u0012W\n\rfacility_type\u0018\n \u0001(\u000e2@.com.tylohelo.tylohelo.protobuf.Enum_value_types.facility_type_t\u0012I\n\u0006region\u0018\u000b \u0001(\u000e29.com.tylohelo.tylohelo.protobuf.Enum_value_types.region_t\u0012S\n\u000bwater_level\u0018\f \u0001(\u000e2>.com.tylohelo.tylohelo.protobuf.Enum_value_types.water_level_t\u0012m\n\u0018external_switch_function\u0018\r \u0001(\u000e2K.com.tylohelo.tylohelo.protobuf.Enum_value_types.external_switch_function_t\u0012W\n\rbath_priority\u0018\u000e \u0001(\u000e2@.com.tylohelo.tylohelo.protobuf.Enum_value_types.bath_priority_t\u0012[\n\u0013water_level_slave_1\u0018\u000f \u0001(\u000e2>.com.tylohelo.tylohelo.protobuf.Enum_value_types.water_level_t\u0012[\n\u0013water_level_slave_2\u0018\u0010 \u0001(\u000e2>.com.tylohelo.tylohelo.protobuf.Enum_value_types.water_level_t\"\u0087\u0003\n\u0019Enum_value_change_request\u0012W\n\rfacility_type\u0018\u000b \u0001(\u000e2@.com.tylohelo.tylohelo.protobuf.Enum_value_types.facility_type_t\u0012I\n\u0006region\u0018\f \u0001(\u000e29.com.tylohelo.tylohelo.protobuf.Enum_value_types.region_t\u0012m\n\u0018external_switch_function\u0018\r \u0001(\u000e2K.com.tylohelo.tylohelo.protobuf.Enum_value_types.external_switch_function_t\u0012W\n\rbath_priority\u0018\u000e \u0001(\u000e2@.com.tylohelo.tylohelo.protobuf.Enum_value_types.bath_priority_tB\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_fieldAccessorTable;

    public interface Enum_value_change_requestOrBuilder extends MessageOrBuilder {
        Enum_value_types.bath_priority_t getBathPriority();

        Enum_value_types.external_switch_function_t getExternalSwitchFunction();

        Enum_value_types.facility_type_t getFacilityType();

        Enum_value_types.region_t getRegion();

        boolean hasBathPriority();

        boolean hasExternalSwitchFunction();

        boolean hasFacilityType();

        boolean hasRegion();
    }

    public interface Enum_value_changedOrBuilder extends MessageOrBuilder {
        Enum_value_types.bath_priority_t getBathPriority();

        Enum_value_types.external_switch_function_t getExternalSwitchFunction();

        Enum_value_types.facility_type_t getFacilityType();

        Enum_value_types.region_t getRegion();

        Enum_value_types.water_level_t getWaterLevel();

        Enum_value_types.water_level_t getWaterLevelSlave1();

        Enum_value_types.water_level_t getWaterLevelSlave2();

        boolean hasBathPriority();

        boolean hasExternalSwitchFunction();

        boolean hasFacilityType();

        boolean hasRegion();

        boolean hasWaterLevel();

        boolean hasWaterLevelSlave1();

        boolean hasWaterLevelSlave2();
    }

    public interface Enum_value_typesOrBuilder extends MessageOrBuilder {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private EnumValue() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Enum_value_types extends GeneratedMessageV3 implements Enum_value_typesOrBuilder {
        private static final Enum_value_types DEFAULT_INSTANCE = new Enum_value_types();

        @Deprecated
        public static final Parser<Enum_value_types> PARSER = new AbstractParser<Enum_value_types>() { // from class: com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_types.1
            @Override // com.google.protobuf.Parser
            public Enum_value_types parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Enum_value_types.newBuilder();
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
        private byte memoizedIsInitialized;

        private Enum_value_types(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Enum_value_types() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Enum_value_types();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum_value_types.class, Builder.class);
        }

        public enum water_level_t implements ProtocolMessageEnum {
            WLVL_LOW(10),
            WLVL_MID(11),
            WLVL_HIGH(12),
            WLVL_UNKNOWN(13);

            public static final int WLVL_HIGH_VALUE = 12;
            public static final int WLVL_LOW_VALUE = 10;
            public static final int WLVL_MID_VALUE = 11;
            public static final int WLVL_UNKNOWN_VALUE = 13;
            private final int value;
            private static final Internal.EnumLiteMap<water_level_t> internalValueMap = new Internal.EnumLiteMap<water_level_t>() { // from class: com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_types.water_level_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public water_level_t findValueByNumber(int i) {
                    return water_level_t.forNumber(i);
                }
            };
            private static final water_level_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static water_level_t valueOf(int i) {
                return forNumber(i);
            }

            public static water_level_t forNumber(int i) {
                switch (i) {
                    case 10:
                        return WLVL_LOW;
                    case 11:
                        return WLVL_MID;
                    case 12:
                        return WLVL_HIGH;
                    case 13:
                        return WLVL_UNKNOWN;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<water_level_t> internalGetValueMap() {
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
                return Enum_value_types.getDescriptor().getEnumTypes().get(0);
            }

            public static water_level_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            water_level_t(int i) {
                this.value = i;
            }
        }

        public enum facility_type_t implements ProtocolMessageEnum {
            FAC_TYPE_SUPERVISED(20),
            FAC_TYPE_TIME_CONTROLLED(21),
            FAC_TYPE_PRIVATE_CONTROLLED(22),
            FAC_TYPE_PUBLIC(23),
            FAC_TYPE_UNKNOWN(24);

            public static final int FAC_TYPE_PRIVATE_CONTROLLED_VALUE = 22;
            public static final int FAC_TYPE_PUBLIC_VALUE = 23;
            public static final int FAC_TYPE_SUPERVISED_VALUE = 20;
            public static final int FAC_TYPE_TIME_CONTROLLED_VALUE = 21;
            public static final int FAC_TYPE_UNKNOWN_VALUE = 24;
            private final int value;
            private static final Internal.EnumLiteMap<facility_type_t> internalValueMap = new Internal.EnumLiteMap<facility_type_t>() { // from class: com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_types.facility_type_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public facility_type_t findValueByNumber(int i) {
                    return facility_type_t.forNumber(i);
                }
            };
            private static final facility_type_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static facility_type_t valueOf(int i) {
                return forNumber(i);
            }

            public static facility_type_t forNumber(int i) {
                switch (i) {
                    case 20:
                        return FAC_TYPE_SUPERVISED;
                    case 21:
                        return FAC_TYPE_TIME_CONTROLLED;
                    case 22:
                        return FAC_TYPE_PRIVATE_CONTROLLED;
                    case 23:
                        return FAC_TYPE_PUBLIC;
                    case 24:
                        return FAC_TYPE_UNKNOWN;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<facility_type_t> internalGetValueMap() {
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
                return Enum_value_types.getDescriptor().getEnumTypes().get(1);
            }

            public static facility_type_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            facility_type_t(int i) {
                this.value = i;
            }
        }

        public enum region_t implements ProtocolMessageEnum {
            REGION_EU(30),
            REGION_NORTH_AMERICA(31),
            REGION_OTHER(32);

            public static final int REGION_EU_VALUE = 30;
            public static final int REGION_NORTH_AMERICA_VALUE = 31;
            public static final int REGION_OTHER_VALUE = 32;
            private final int value;
            private static final Internal.EnumLiteMap<region_t> internalValueMap = new Internal.EnumLiteMap<region_t>() { // from class: com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_types.region_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public region_t findValueByNumber(int i) {
                    return region_t.forNumber(i);
                }
            };
            private static final region_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static region_t valueOf(int i) {
                return forNumber(i);
            }

            public static region_t forNumber(int i) {
                switch (i) {
                    case 30:
                        return REGION_EU;
                    case 31:
                        return REGION_NORTH_AMERICA;
                    case 32:
                        return REGION_OTHER;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<region_t> internalGetValueMap() {
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
                return Enum_value_types.getDescriptor().getEnumTypes().get(2);
            }

            public static region_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            region_t(int i) {
                this.value = i;
            }
        }

        public enum external_switch_function_t implements ProtocolMessageEnum {
            EXTSW_ON_OFF(40),
            EXTSW_RENEW(41);

            public static final int EXTSW_ON_OFF_VALUE = 40;
            public static final int EXTSW_RENEW_VALUE = 41;
            private final int value;
            private static final Internal.EnumLiteMap<external_switch_function_t> internalValueMap = new Internal.EnumLiteMap<external_switch_function_t>() { // from class: com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_types.external_switch_function_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public external_switch_function_t findValueByNumber(int i) {
                    return external_switch_function_t.forNumber(i);
                }
            };
            private static final external_switch_function_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static external_switch_function_t valueOf(int i) {
                return forNumber(i);
            }

            public static external_switch_function_t forNumber(int i) {
                if (i == 40) {
                    return EXTSW_ON_OFF;
                }
                if (i != 41) {
                    return null;
                }
                return EXTSW_RENEW;
            }

            public static Internal.EnumLiteMap<external_switch_function_t> internalGetValueMap() {
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
                return Enum_value_types.getDescriptor().getEnumTypes().get(3);
            }

            public static external_switch_function_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            external_switch_function_t(int i) {
                this.value = i;
            }
        }

        public enum bath_priority_t implements ProtocolMessageEnum {
            BATH_PRIO_AUTOMATIC(50),
            BATH_PRIO_TEMPERATURE(51),
            BATH_PRIO_HUMIDITY(52);

            public static final int BATH_PRIO_AUTOMATIC_VALUE = 50;
            public static final int BATH_PRIO_HUMIDITY_VALUE = 52;
            public static final int BATH_PRIO_TEMPERATURE_VALUE = 51;
            private final int value;
            private static final Internal.EnumLiteMap<bath_priority_t> internalValueMap = new Internal.EnumLiteMap<bath_priority_t>() { // from class: com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_types.bath_priority_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public bath_priority_t findValueByNumber(int i) {
                    return bath_priority_t.forNumber(i);
                }
            };
            private static final bath_priority_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static bath_priority_t valueOf(int i) {
                return forNumber(i);
            }

            public static bath_priority_t forNumber(int i) {
                switch (i) {
                    case 50:
                        return BATH_PRIO_AUTOMATIC;
                    case 51:
                        return BATH_PRIO_TEMPERATURE;
                    case 52:
                        return BATH_PRIO_HUMIDITY;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<bath_priority_t> internalGetValueMap() {
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
                return Enum_value_types.getDescriptor().getEnumTypes().get(4);
            }

            public static bath_priority_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            bath_priority_t(int i) {
                this.value = i;
            }
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
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int serializedSize = getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Enum_value_types) {
                return getUnknownFields().equals(((Enum_value_types) obj).getUnknownFields());
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((779 + getDescriptor().hashCode()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Enum_value_types parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Enum_value_types parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Enum_value_types parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Enum_value_types parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Enum_value_types parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Enum_value_types parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Enum_value_types parseFrom(InputStream inputStream) throws IOException {
            return (Enum_value_types) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Enum_value_types parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_types) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Enum_value_types parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Enum_value_types) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Enum_value_types parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_types) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Enum_value_types parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Enum_value_types) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Enum_value_types parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_types) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Enum_value_types enum_value_types) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(enum_value_types);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Enum_value_typesOrBuilder {
            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum_value_types.class, Builder.class);
            }

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Enum_value_types getDefaultInstanceForType() {
                return Enum_value_types.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Enum_value_types build() {
                Enum_value_types buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Enum_value_types buildPartial() {
                Enum_value_types enum_value_types = new Enum_value_types(this);
                onBuilt();
                return enum_value_types;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Enum_value_types) {
                    return mergeFrom((Enum_value_types) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Enum_value_types enum_value_types) {
                if (enum_value_types == Enum_value_types.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(enum_value_types.getUnknownFields());
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
                            if (readTag == 0 || !super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                z = true;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static Enum_value_types getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Enum_value_types> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Enum_value_types> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Enum_value_types getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Enum_value_changed extends GeneratedMessageV3 implements Enum_value_changedOrBuilder {
        public static final int BATH_PRIORITY_FIELD_NUMBER = 14;
        public static final int EXTERNAL_SWITCH_FUNCTION_FIELD_NUMBER = 13;
        public static final int FACILITY_TYPE_FIELD_NUMBER = 10;
        public static final int REGION_FIELD_NUMBER = 11;
        public static final int WATER_LEVEL_FIELD_NUMBER = 12;
        public static final int WATER_LEVEL_SLAVE_1_FIELD_NUMBER = 15;
        public static final int WATER_LEVEL_SLAVE_2_FIELD_NUMBER = 16;
        private static final long serialVersionUID = 0;
        private int bathPriority_;
        private int bitField0_;
        private int externalSwitchFunction_;
        private int facilityType_;
        private byte memoizedIsInitialized;
        private int region_;
        private int waterLevelSlave1_;
        private int waterLevelSlave2_;
        private int waterLevel_;
        private static final Enum_value_changed DEFAULT_INSTANCE = new Enum_value_changed();

        @Deprecated
        public static final Parser<Enum_value_changed> PARSER = new AbstractParser<Enum_value_changed>() { // from class: com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changed.1
            @Override // com.google.protobuf.Parser
            public Enum_value_changed parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Enum_value_changed.newBuilder();
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

        static /* synthetic */ int access$1776(Enum_value_changed enum_value_changed, int i) {
            int i2 = i | enum_value_changed.bitField0_;
            enum_value_changed.bitField0_ = i2;
            return i2;
        }

        private Enum_value_changed(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.facilityType_ = 20;
            this.region_ = 30;
            this.waterLevel_ = 10;
            this.externalSwitchFunction_ = 40;
            this.bathPriority_ = 50;
            this.waterLevelSlave1_ = 10;
            this.waterLevelSlave2_ = 10;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Enum_value_changed() {
            this.memoizedIsInitialized = (byte) -1;
            this.facilityType_ = 20;
            this.region_ = 30;
            this.waterLevel_ = 10;
            this.externalSwitchFunction_ = 40;
            this.bathPriority_ = 50;
            this.waterLevelSlave1_ = 10;
            this.waterLevelSlave2_ = 10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Enum_value_changed();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum_value_changed.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public boolean hasFacilityType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public Enum_value_types.facility_type_t getFacilityType() {
            Enum_value_types.facility_type_t forNumber = Enum_value_types.facility_type_t.forNumber(this.facilityType_);
            return forNumber == null ? Enum_value_types.facility_type_t.FAC_TYPE_SUPERVISED : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public boolean hasRegion() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public Enum_value_types.region_t getRegion() {
            Enum_value_types.region_t forNumber = Enum_value_types.region_t.forNumber(this.region_);
            return forNumber == null ? Enum_value_types.region_t.REGION_EU : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public boolean hasWaterLevel() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public Enum_value_types.water_level_t getWaterLevel() {
            Enum_value_types.water_level_t forNumber = Enum_value_types.water_level_t.forNumber(this.waterLevel_);
            return forNumber == null ? Enum_value_types.water_level_t.WLVL_LOW : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public boolean hasExternalSwitchFunction() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public Enum_value_types.external_switch_function_t getExternalSwitchFunction() {
            Enum_value_types.external_switch_function_t forNumber = Enum_value_types.external_switch_function_t.forNumber(this.externalSwitchFunction_);
            return forNumber == null ? Enum_value_types.external_switch_function_t.EXTSW_ON_OFF : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public boolean hasBathPriority() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public Enum_value_types.bath_priority_t getBathPriority() {
            Enum_value_types.bath_priority_t forNumber = Enum_value_types.bath_priority_t.forNumber(this.bathPriority_);
            return forNumber == null ? Enum_value_types.bath_priority_t.BATH_PRIO_AUTOMATIC : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public boolean hasWaterLevelSlave1() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public Enum_value_types.water_level_t getWaterLevelSlave1() {
            Enum_value_types.water_level_t forNumber = Enum_value_types.water_level_t.forNumber(this.waterLevelSlave1_);
            return forNumber == null ? Enum_value_types.water_level_t.WLVL_LOW : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public boolean hasWaterLevelSlave2() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
        public Enum_value_types.water_level_t getWaterLevelSlave2() {
            Enum_value_types.water_level_t forNumber = Enum_value_types.water_level_t.forNumber(this.waterLevelSlave2_);
            return forNumber == null ? Enum_value_types.water_level_t.WLVL_LOW : forNumber;
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
                codedOutputStream.writeEnum(10, this.facilityType_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeEnum(11, this.region_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeEnum(12, this.waterLevel_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeEnum(13, this.externalSwitchFunction_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeEnum(14, this.bathPriority_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.writeEnum(15, this.waterLevelSlave1_);
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputStream.writeEnum(16, this.waterLevelSlave2_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(10, this.facilityType_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(11, this.region_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(12, this.waterLevel_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(13, this.externalSwitchFunction_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(14, this.bathPriority_);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(15, this.waterLevelSlave1_);
            }
            if ((this.bitField0_ & 64) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(16, this.waterLevelSlave2_);
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
            if (!(obj instanceof Enum_value_changed)) {
                return super.equals(obj);
            }
            Enum_value_changed enum_value_changed = (Enum_value_changed) obj;
            if (hasFacilityType() != enum_value_changed.hasFacilityType()) {
                return false;
            }
            if ((hasFacilityType() && this.facilityType_ != enum_value_changed.facilityType_) || hasRegion() != enum_value_changed.hasRegion()) {
                return false;
            }
            if ((hasRegion() && this.region_ != enum_value_changed.region_) || hasWaterLevel() != enum_value_changed.hasWaterLevel()) {
                return false;
            }
            if ((hasWaterLevel() && this.waterLevel_ != enum_value_changed.waterLevel_) || hasExternalSwitchFunction() != enum_value_changed.hasExternalSwitchFunction()) {
                return false;
            }
            if ((hasExternalSwitchFunction() && this.externalSwitchFunction_ != enum_value_changed.externalSwitchFunction_) || hasBathPriority() != enum_value_changed.hasBathPriority()) {
                return false;
            }
            if ((hasBathPriority() && this.bathPriority_ != enum_value_changed.bathPriority_) || hasWaterLevelSlave1() != enum_value_changed.hasWaterLevelSlave1()) {
                return false;
            }
            if ((!hasWaterLevelSlave1() || this.waterLevelSlave1_ == enum_value_changed.waterLevelSlave1_) && hasWaterLevelSlave2() == enum_value_changed.hasWaterLevelSlave2()) {
                return (!hasWaterLevelSlave2() || this.waterLevelSlave2_ == enum_value_changed.waterLevelSlave2_) && getUnknownFields().equals(enum_value_changed.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasFacilityType()) {
                hashCode = (((hashCode * 37) + 10) * 53) + this.facilityType_;
            }
            if (hasRegion()) {
                hashCode = (((hashCode * 37) + 11) * 53) + this.region_;
            }
            if (hasWaterLevel()) {
                hashCode = (((hashCode * 37) + 12) * 53) + this.waterLevel_;
            }
            if (hasExternalSwitchFunction()) {
                hashCode = (((hashCode * 37) + 13) * 53) + this.externalSwitchFunction_;
            }
            if (hasBathPriority()) {
                hashCode = (((hashCode * 37) + 14) * 53) + this.bathPriority_;
            }
            if (hasWaterLevelSlave1()) {
                hashCode = (((hashCode * 37) + 15) * 53) + this.waterLevelSlave1_;
            }
            if (hasWaterLevelSlave2()) {
                hashCode = (((hashCode * 37) + 16) * 53) + this.waterLevelSlave2_;
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Enum_value_changed parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Enum_value_changed parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Enum_value_changed parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Enum_value_changed parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Enum_value_changed parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Enum_value_changed parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Enum_value_changed parseFrom(InputStream inputStream) throws IOException {
            return (Enum_value_changed) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Enum_value_changed parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_changed) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Enum_value_changed parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Enum_value_changed) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Enum_value_changed parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_changed) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Enum_value_changed parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Enum_value_changed) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Enum_value_changed parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_changed) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Enum_value_changed enum_value_changed) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(enum_value_changed);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Enum_value_changedOrBuilder {
            private int bathPriority_;
            private int bitField0_;
            private int externalSwitchFunction_;
            private int facilityType_;
            private int region_;
            private int waterLevelSlave1_;
            private int waterLevelSlave2_;
            private int waterLevel_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum_value_changed.class, Builder.class);
            }

            private Builder() {
                this.facilityType_ = 20;
                this.region_ = 30;
                this.waterLevel_ = 10;
                this.externalSwitchFunction_ = 40;
                this.bathPriority_ = 50;
                this.waterLevelSlave1_ = 10;
                this.waterLevelSlave2_ = 10;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.facilityType_ = 20;
                this.region_ = 30;
                this.waterLevel_ = 10;
                this.externalSwitchFunction_ = 40;
                this.bathPriority_ = 50;
                this.waterLevelSlave1_ = 10;
                this.waterLevelSlave2_ = 10;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.facilityType_ = 20;
                this.region_ = 30;
                this.waterLevel_ = 10;
                this.externalSwitchFunction_ = 40;
                this.bathPriority_ = 50;
                this.waterLevelSlave1_ = 10;
                this.waterLevelSlave2_ = 10;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Enum_value_changed getDefaultInstanceForType() {
                return Enum_value_changed.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Enum_value_changed build() {
                Enum_value_changed buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Enum_value_changed buildPartial() {
                Enum_value_changed enum_value_changed = new Enum_value_changed(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(enum_value_changed);
                }
                onBuilt();
                return enum_value_changed;
            }

            private void buildPartial0(Enum_value_changed enum_value_changed) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    enum_value_changed.facilityType_ = this.facilityType_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    enum_value_changed.region_ = this.region_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    enum_value_changed.waterLevel_ = this.waterLevel_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    enum_value_changed.externalSwitchFunction_ = this.externalSwitchFunction_;
                    i |= 8;
                }
                if ((i2 & 16) != 0) {
                    enum_value_changed.bathPriority_ = this.bathPriority_;
                    i |= 16;
                }
                if ((i2 & 32) != 0) {
                    enum_value_changed.waterLevelSlave1_ = this.waterLevelSlave1_;
                    i |= 32;
                }
                if ((i2 & 64) != 0) {
                    enum_value_changed.waterLevelSlave2_ = this.waterLevelSlave2_;
                    i |= 64;
                }
                Enum_value_changed.access$1776(enum_value_changed, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Enum_value_changed) {
                    return mergeFrom((Enum_value_changed) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Enum_value_changed enum_value_changed) {
                if (enum_value_changed == Enum_value_changed.getDefaultInstance()) {
                    return this;
                }
                if (enum_value_changed.hasFacilityType()) {
                    setFacilityType(enum_value_changed.getFacilityType());
                }
                if (enum_value_changed.hasRegion()) {
                    setRegion(enum_value_changed.getRegion());
                }
                if (enum_value_changed.hasWaterLevel()) {
                    setWaterLevel(enum_value_changed.getWaterLevel());
                }
                if (enum_value_changed.hasExternalSwitchFunction()) {
                    setExternalSwitchFunction(enum_value_changed.getExternalSwitchFunction());
                }
                if (enum_value_changed.hasBathPriority()) {
                    setBathPriority(enum_value_changed.getBathPriority());
                }
                if (enum_value_changed.hasWaterLevelSlave1()) {
                    setWaterLevelSlave1(enum_value_changed.getWaterLevelSlave1());
                }
                if (enum_value_changed.hasWaterLevelSlave2()) {
                    setWaterLevelSlave2(enum_value_changed.getWaterLevelSlave2());
                }
                mergeUnknownFields(enum_value_changed.getUnknownFields());
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
                                if (readTag == 80) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (Enum_value_types.facility_type_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(10, readEnum);
                                    } else {
                                        this.facilityType_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                } else if (readTag == 88) {
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (Enum_value_types.region_t.forNumber(readEnum2) == null) {
                                        mergeUnknownVarintField(11, readEnum2);
                                    } else {
                                        this.region_ = readEnum2;
                                        this.bitField0_ |= 2;
                                    }
                                } else if (readTag == 96) {
                                    int readEnum3 = codedInputStream.readEnum();
                                    if (Enum_value_types.water_level_t.forNumber(readEnum3) == null) {
                                        mergeUnknownVarintField(12, readEnum3);
                                    } else {
                                        this.waterLevel_ = readEnum3;
                                        this.bitField0_ |= 4;
                                    }
                                } else if (readTag == 104) {
                                    int readEnum4 = codedInputStream.readEnum();
                                    if (Enum_value_types.external_switch_function_t.forNumber(readEnum4) == null) {
                                        mergeUnknownVarintField(13, readEnum4);
                                    } else {
                                        this.externalSwitchFunction_ = readEnum4;
                                        this.bitField0_ |= 8;
                                    }
                                } else if (readTag == 112) {
                                    int readEnum5 = codedInputStream.readEnum();
                                    if (Enum_value_types.bath_priority_t.forNumber(readEnum5) == null) {
                                        mergeUnknownVarintField(14, readEnum5);
                                    } else {
                                        this.bathPriority_ = readEnum5;
                                        this.bitField0_ |= 16;
                                    }
                                } else if (readTag == 120) {
                                    int readEnum6 = codedInputStream.readEnum();
                                    if (Enum_value_types.water_level_t.forNumber(readEnum6) == null) {
                                        mergeUnknownVarintField(15, readEnum6);
                                    } else {
                                        this.waterLevelSlave1_ = readEnum6;
                                        this.bitField0_ |= 32;
                                    }
                                } else if (readTag == 128) {
                                    int readEnum7 = codedInputStream.readEnum();
                                    if (Enum_value_types.water_level_t.forNumber(readEnum7) == null) {
                                        mergeUnknownVarintField(16, readEnum7);
                                    } else {
                                        this.waterLevelSlave2_ = readEnum7;
                                        this.bitField0_ |= 64;
                                    }
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

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public boolean hasFacilityType() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public Enum_value_types.facility_type_t getFacilityType() {
                Enum_value_types.facility_type_t forNumber = Enum_value_types.facility_type_t.forNumber(this.facilityType_);
                return forNumber == null ? Enum_value_types.facility_type_t.FAC_TYPE_SUPERVISED : forNumber;
            }

            public Builder setFacilityType(Enum_value_types.facility_type_t facility_type_tVar) {
                facility_type_tVar.getClass();
                this.bitField0_ |= 1;
                this.facilityType_ = facility_type_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFacilityType() {
                this.bitField0_ &= -2;
                this.facilityType_ = 20;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public boolean hasRegion() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public Enum_value_types.region_t getRegion() {
                Enum_value_types.region_t forNumber = Enum_value_types.region_t.forNumber(this.region_);
                return forNumber == null ? Enum_value_types.region_t.REGION_EU : forNumber;
            }

            public Builder setRegion(Enum_value_types.region_t region_tVar) {
                region_tVar.getClass();
                this.bitField0_ |= 2;
                this.region_ = region_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearRegion() {
                this.bitField0_ &= -3;
                this.region_ = 30;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public boolean hasWaterLevel() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public Enum_value_types.water_level_t getWaterLevel() {
                Enum_value_types.water_level_t forNumber = Enum_value_types.water_level_t.forNumber(this.waterLevel_);
                return forNumber == null ? Enum_value_types.water_level_t.WLVL_LOW : forNumber;
            }

            public Builder setWaterLevel(Enum_value_types.water_level_t water_level_tVar) {
                water_level_tVar.getClass();
                this.bitField0_ |= 4;
                this.waterLevel_ = water_level_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearWaterLevel() {
                this.bitField0_ &= -5;
                this.waterLevel_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public boolean hasExternalSwitchFunction() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public Enum_value_types.external_switch_function_t getExternalSwitchFunction() {
                Enum_value_types.external_switch_function_t forNumber = Enum_value_types.external_switch_function_t.forNumber(this.externalSwitchFunction_);
                return forNumber == null ? Enum_value_types.external_switch_function_t.EXTSW_ON_OFF : forNumber;
            }

            public Builder setExternalSwitchFunction(Enum_value_types.external_switch_function_t external_switch_function_tVar) {
                external_switch_function_tVar.getClass();
                this.bitField0_ |= 8;
                this.externalSwitchFunction_ = external_switch_function_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearExternalSwitchFunction() {
                this.bitField0_ &= -9;
                this.externalSwitchFunction_ = 40;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public boolean hasBathPriority() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public Enum_value_types.bath_priority_t getBathPriority() {
                Enum_value_types.bath_priority_t forNumber = Enum_value_types.bath_priority_t.forNumber(this.bathPriority_);
                return forNumber == null ? Enum_value_types.bath_priority_t.BATH_PRIO_AUTOMATIC : forNumber;
            }

            public Builder setBathPriority(Enum_value_types.bath_priority_t bath_priority_tVar) {
                bath_priority_tVar.getClass();
                this.bitField0_ |= 16;
                this.bathPriority_ = bath_priority_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearBathPriority() {
                this.bitField0_ &= -17;
                this.bathPriority_ = 50;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public boolean hasWaterLevelSlave1() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public Enum_value_types.water_level_t getWaterLevelSlave1() {
                Enum_value_types.water_level_t forNumber = Enum_value_types.water_level_t.forNumber(this.waterLevelSlave1_);
                return forNumber == null ? Enum_value_types.water_level_t.WLVL_LOW : forNumber;
            }

            public Builder setWaterLevelSlave1(Enum_value_types.water_level_t water_level_tVar) {
                water_level_tVar.getClass();
                this.bitField0_ |= 32;
                this.waterLevelSlave1_ = water_level_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearWaterLevelSlave1() {
                this.bitField0_ &= -33;
                this.waterLevelSlave1_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public boolean hasWaterLevelSlave2() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_changedOrBuilder
            public Enum_value_types.water_level_t getWaterLevelSlave2() {
                Enum_value_types.water_level_t forNumber = Enum_value_types.water_level_t.forNumber(this.waterLevelSlave2_);
                return forNumber == null ? Enum_value_types.water_level_t.WLVL_LOW : forNumber;
            }

            public Builder setWaterLevelSlave2(Enum_value_types.water_level_t water_level_tVar) {
                water_level_tVar.getClass();
                this.bitField0_ |= 64;
                this.waterLevelSlave2_ = water_level_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearWaterLevelSlave2() {
                this.bitField0_ &= -65;
                this.waterLevelSlave2_ = 10;
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

        public static Enum_value_changed getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Enum_value_changed> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Enum_value_changed> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Enum_value_changed getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Enum_value_change_request extends GeneratedMessageV3 implements Enum_value_change_requestOrBuilder {
        public static final int BATH_PRIORITY_FIELD_NUMBER = 14;
        public static final int EXTERNAL_SWITCH_FUNCTION_FIELD_NUMBER = 13;
        public static final int FACILITY_TYPE_FIELD_NUMBER = 11;
        public static final int REGION_FIELD_NUMBER = 12;
        private static final long serialVersionUID = 0;
        private int bathPriority_;
        private int bitField0_;
        private int externalSwitchFunction_;
        private int facilityType_;
        private byte memoizedIsInitialized;
        private int region_;
        private static final Enum_value_change_request DEFAULT_INSTANCE = new Enum_value_change_request();

        @Deprecated
        public static final Parser<Enum_value_change_request> PARSER = new AbstractParser<Enum_value_change_request>() { // from class: com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_request.1
            @Override // com.google.protobuf.Parser
            public Enum_value_change_request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Enum_value_change_request.newBuilder();
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

        static /* synthetic */ int access$2776(Enum_value_change_request enum_value_change_request, int i) {
            int i2 = i | enum_value_change_request.bitField0_;
            enum_value_change_request.bitField0_ = i2;
            return i2;
        }

        private Enum_value_change_request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.facilityType_ = 20;
            this.region_ = 30;
            this.externalSwitchFunction_ = 40;
            this.bathPriority_ = 50;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Enum_value_change_request() {
            this.memoizedIsInitialized = (byte) -1;
            this.facilityType_ = 20;
            this.region_ = 30;
            this.externalSwitchFunction_ = 40;
            this.bathPriority_ = 50;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Enum_value_change_request();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum_value_change_request.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
        public boolean hasFacilityType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
        public Enum_value_types.facility_type_t getFacilityType() {
            Enum_value_types.facility_type_t forNumber = Enum_value_types.facility_type_t.forNumber(this.facilityType_);
            return forNumber == null ? Enum_value_types.facility_type_t.FAC_TYPE_SUPERVISED : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
        public boolean hasRegion() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
        public Enum_value_types.region_t getRegion() {
            Enum_value_types.region_t forNumber = Enum_value_types.region_t.forNumber(this.region_);
            return forNumber == null ? Enum_value_types.region_t.REGION_EU : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
        public boolean hasExternalSwitchFunction() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
        public Enum_value_types.external_switch_function_t getExternalSwitchFunction() {
            Enum_value_types.external_switch_function_t forNumber = Enum_value_types.external_switch_function_t.forNumber(this.externalSwitchFunction_);
            return forNumber == null ? Enum_value_types.external_switch_function_t.EXTSW_ON_OFF : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
        public boolean hasBathPriority() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
        public Enum_value_types.bath_priority_t getBathPriority() {
            Enum_value_types.bath_priority_t forNumber = Enum_value_types.bath_priority_t.forNumber(this.bathPriority_);
            return forNumber == null ? Enum_value_types.bath_priority_t.BATH_PRIO_AUTOMATIC : forNumber;
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
                codedOutputStream.writeEnum(11, this.facilityType_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeEnum(12, this.region_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeEnum(13, this.externalSwitchFunction_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeEnum(14, this.bathPriority_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(11, this.facilityType_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(12, this.region_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(13, this.externalSwitchFunction_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(14, this.bathPriority_);
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
            if (!(obj instanceof Enum_value_change_request)) {
                return super.equals(obj);
            }
            Enum_value_change_request enum_value_change_request = (Enum_value_change_request) obj;
            if (hasFacilityType() != enum_value_change_request.hasFacilityType()) {
                return false;
            }
            if ((hasFacilityType() && this.facilityType_ != enum_value_change_request.facilityType_) || hasRegion() != enum_value_change_request.hasRegion()) {
                return false;
            }
            if ((hasRegion() && this.region_ != enum_value_change_request.region_) || hasExternalSwitchFunction() != enum_value_change_request.hasExternalSwitchFunction()) {
                return false;
            }
            if ((!hasExternalSwitchFunction() || this.externalSwitchFunction_ == enum_value_change_request.externalSwitchFunction_) && hasBathPriority() == enum_value_change_request.hasBathPriority()) {
                return (!hasBathPriority() || this.bathPriority_ == enum_value_change_request.bathPriority_) && getUnknownFields().equals(enum_value_change_request.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasFacilityType()) {
                hashCode = (((hashCode * 37) + 11) * 53) + this.facilityType_;
            }
            if (hasRegion()) {
                hashCode = (((hashCode * 37) + 12) * 53) + this.region_;
            }
            if (hasExternalSwitchFunction()) {
                hashCode = (((hashCode * 37) + 13) * 53) + this.externalSwitchFunction_;
            }
            if (hasBathPriority()) {
                hashCode = (((hashCode * 37) + 14) * 53) + this.bathPriority_;
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Enum_value_change_request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Enum_value_change_request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Enum_value_change_request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Enum_value_change_request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Enum_value_change_request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Enum_value_change_request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Enum_value_change_request parseFrom(InputStream inputStream) throws IOException {
            return (Enum_value_change_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Enum_value_change_request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_change_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Enum_value_change_request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Enum_value_change_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Enum_value_change_request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_change_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Enum_value_change_request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Enum_value_change_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Enum_value_change_request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Enum_value_change_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Enum_value_change_request enum_value_change_request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(enum_value_change_request);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Enum_value_change_requestOrBuilder {
            private int bathPriority_;
            private int bitField0_;
            private int externalSwitchFunction_;
            private int facilityType_;
            private int region_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum_value_change_request.class, Builder.class);
            }

            private Builder() {
                this.facilityType_ = 20;
                this.region_ = 30;
                this.externalSwitchFunction_ = 40;
                this.bathPriority_ = 50;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.facilityType_ = 20;
                this.region_ = 30;
                this.externalSwitchFunction_ = 40;
                this.bathPriority_ = 50;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.facilityType_ = 20;
                this.region_ = 30;
                this.externalSwitchFunction_ = 40;
                this.bathPriority_ = 50;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnumValue.internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Enum_value_change_request getDefaultInstanceForType() {
                return Enum_value_change_request.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Enum_value_change_request build() {
                Enum_value_change_request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Enum_value_change_request buildPartial() {
                Enum_value_change_request enum_value_change_request = new Enum_value_change_request(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(enum_value_change_request);
                }
                onBuilt();
                return enum_value_change_request;
            }

            private void buildPartial0(Enum_value_change_request enum_value_change_request) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    enum_value_change_request.facilityType_ = this.facilityType_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    enum_value_change_request.region_ = this.region_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    enum_value_change_request.externalSwitchFunction_ = this.externalSwitchFunction_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    enum_value_change_request.bathPriority_ = this.bathPriority_;
                    i |= 8;
                }
                Enum_value_change_request.access$2776(enum_value_change_request, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Enum_value_change_request) {
                    return mergeFrom((Enum_value_change_request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Enum_value_change_request enum_value_change_request) {
                if (enum_value_change_request == Enum_value_change_request.getDefaultInstance()) {
                    return this;
                }
                if (enum_value_change_request.hasFacilityType()) {
                    setFacilityType(enum_value_change_request.getFacilityType());
                }
                if (enum_value_change_request.hasRegion()) {
                    setRegion(enum_value_change_request.getRegion());
                }
                if (enum_value_change_request.hasExternalSwitchFunction()) {
                    setExternalSwitchFunction(enum_value_change_request.getExternalSwitchFunction());
                }
                if (enum_value_change_request.hasBathPriority()) {
                    setBathPriority(enum_value_change_request.getBathPriority());
                }
                mergeUnknownFields(enum_value_change_request.getUnknownFields());
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
                                if (readTag == 88) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (Enum_value_types.facility_type_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(11, readEnum);
                                    } else {
                                        this.facilityType_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                } else if (readTag == 96) {
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (Enum_value_types.region_t.forNumber(readEnum2) == null) {
                                        mergeUnknownVarintField(12, readEnum2);
                                    } else {
                                        this.region_ = readEnum2;
                                        this.bitField0_ |= 2;
                                    }
                                } else if (readTag == 104) {
                                    int readEnum3 = codedInputStream.readEnum();
                                    if (Enum_value_types.external_switch_function_t.forNumber(readEnum3) == null) {
                                        mergeUnknownVarintField(13, readEnum3);
                                    } else {
                                        this.externalSwitchFunction_ = readEnum3;
                                        this.bitField0_ |= 4;
                                    }
                                } else if (readTag == 112) {
                                    int readEnum4 = codedInputStream.readEnum();
                                    if (Enum_value_types.bath_priority_t.forNumber(readEnum4) == null) {
                                        mergeUnknownVarintField(14, readEnum4);
                                    } else {
                                        this.bathPriority_ = readEnum4;
                                        this.bitField0_ |= 8;
                                    }
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

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
            public boolean hasFacilityType() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
            public Enum_value_types.facility_type_t getFacilityType() {
                Enum_value_types.facility_type_t forNumber = Enum_value_types.facility_type_t.forNumber(this.facilityType_);
                return forNumber == null ? Enum_value_types.facility_type_t.FAC_TYPE_SUPERVISED : forNumber;
            }

            public Builder setFacilityType(Enum_value_types.facility_type_t facility_type_tVar) {
                facility_type_tVar.getClass();
                this.bitField0_ |= 1;
                this.facilityType_ = facility_type_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFacilityType() {
                this.bitField0_ &= -2;
                this.facilityType_ = 20;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
            public boolean hasRegion() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
            public Enum_value_types.region_t getRegion() {
                Enum_value_types.region_t forNumber = Enum_value_types.region_t.forNumber(this.region_);
                return forNumber == null ? Enum_value_types.region_t.REGION_EU : forNumber;
            }

            public Builder setRegion(Enum_value_types.region_t region_tVar) {
                region_tVar.getClass();
                this.bitField0_ |= 2;
                this.region_ = region_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearRegion() {
                this.bitField0_ &= -3;
                this.region_ = 30;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
            public boolean hasExternalSwitchFunction() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
            public Enum_value_types.external_switch_function_t getExternalSwitchFunction() {
                Enum_value_types.external_switch_function_t forNumber = Enum_value_types.external_switch_function_t.forNumber(this.externalSwitchFunction_);
                return forNumber == null ? Enum_value_types.external_switch_function_t.EXTSW_ON_OFF : forNumber;
            }

            public Builder setExternalSwitchFunction(Enum_value_types.external_switch_function_t external_switch_function_tVar) {
                external_switch_function_tVar.getClass();
                this.bitField0_ |= 4;
                this.externalSwitchFunction_ = external_switch_function_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearExternalSwitchFunction() {
                this.bitField0_ &= -5;
                this.externalSwitchFunction_ = 40;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
            public boolean hasBathPriority() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.EnumValue.Enum_value_change_requestOrBuilder
            public Enum_value_types.bath_priority_t getBathPriority() {
                Enum_value_types.bath_priority_t forNumber = Enum_value_types.bath_priority_t.forNumber(this.bathPriority_);
                return forNumber == null ? Enum_value_types.bath_priority_t.BATH_PRIO_AUTOMATIC : forNumber;
            }

            public Builder setBathPriority(Enum_value_types.bath_priority_t bath_priority_tVar) {
                bath_priority_tVar.getClass();
                this.bitField0_ |= 8;
                this.bathPriority_ = bath_priority_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearBathPriority() {
                this.bitField0_ &= -9;
                this.bathPriority_ = 50;
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

        public static Enum_value_change_request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Enum_value_change_request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Enum_value_change_request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Enum_value_change_request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_types_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[0]);
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_descriptor = descriptor3;
        internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_changed_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"FacilityType", "Region", "WaterLevel", "ExternalSwitchFunction", "BathPriority", "WaterLevelSlave1", "WaterLevelSlave2"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_descriptor = descriptor4;
        internal_static_com_tylohelo_tylohelo_protobuf_Enum_value_change_request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"FacilityType", "Region", "ExternalSwitchFunction", "BathPriority"});
    }
}
