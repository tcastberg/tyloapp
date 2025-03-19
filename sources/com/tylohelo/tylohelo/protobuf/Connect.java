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
public final class Connect {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rconnect.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"²\u0004\n\u0010Connection_types\"N\n\u0007brand_t\u0012\u000e\n\nBRAND_TYLO\u0010(\u0012\u000e\n\nBRAND_HELO\u0010)\u0012\u0011\n\rBRAND_FINNLEO\u0010*\u0012\u0010\n\fBRAND_AMEREC\u0010+\"P\n\rsystem_type_t\u0012\u0013\n\u000fSYSTYP_STANDARD\u0010\u0014\u0012\u0015\n\u0011SYSTYP_MULTISTEAM\u0010\u0015\u0012\u0013\n\u000fSYSTYP_TYLARIUM\u0010\u0016\"ë\u0001\n\rrcb_product_t\u0012\u0014\n\u0010RCB_COMBI_MANUAL\u0010\u001e\u0012\u0012\n\u000eRCB_COMBI_AUTO\u0010\u001f\u0012\u0015\n\u0011RCB_STEAM_PRIVATE\u0010 \u0012\u001a\n\u0016RCB_STEAM_PRIVATE_AUTO\u0010!\u0012\u0014\n\u0010RCB_STEAM_PUBLIC\u0010\"\u0012\u0011\n\rRCB_STEAM_USA\u0010#\u0012\u0011\n\rRCB_BOX_ADDON\u0010$\u0012\r\n\tRCB_SAUNA\u0010%\u0012\u0011\n\rRCB_SAUNA_LOW\u0010&\u0012\u0010\n\fRCB_SAUNA_IR\u0010'\u0012\r\n\tRCB_OTHER\u0010(\"\u008d\u0001\n\tprofile_t\u0012\u0014\n\u0010PROFILE_PC_PANEL\u0010\n\u0012\u001b\n\u0017PROFILE_SMART_PHONE_APP\u0010\u0014\u0012\u0016\n\u0012PROFILE_TABLET_APP\u0010\u0019\u0012\"\n\u001ePROFILE_HOME_AUTOMATION_SYSTEM\u0010\u001e\u0012\u0011\n\rPROFILE_OTHER\u0010c\"¨\u0001\n\u000eSauna_features\u0012\u0018\n\u0010clear_text_login\u0018\u0001 \u0001(\b\u0012\u001c\n\u0014encrypted_login_xtea\u0018\u0002 \u0001(\b\u0012\u001f\n\u0017nb_supported_characters\u0018\u0014 \u0001(\r\u0012\u001c\n\u0014max_humidity_version\u0018\u0015 \u0001(\r\u0012\u001f\n\u0017max_temperature_version\u0018\u0016 \u0001(\r\"ÿ\u0002\n\fAnnouncement\u0012\u0011\n\tsystem_id\u0018\u0001 \u0001(\t\u0012\f\n\u0004port\u0018\u0002 \u0001(\r\u0012G\n\u0005brand\u0018\u0003 \u0001(\u000e28.com.tylohelo.tylohelo.protobuf.Connection_types.brand_t\u0012S\n\u000brcb_product\u0018\u0004 \u0001(\u000e2>.com.tylohelo.tylohelo.protobuf.Connection_types.rcb_product_t\u0012\u0013\n\u000bsystem_name\u0018\u0005 \u0003(\r\u0012F\n\u000esauna_features\u0018\u0006 \u0001(\u000b2..com.tylohelo.tylohelo.protobuf.Sauna_features\u0012S\n\u000bsystem_type\u0018\u0007 \u0001(\u000e2>.com.tylohelo.tylohelo.protobuf.Connection_types.system_type_t\"<\n\u0016External_unit_features\u0012\"\n\u001aconnect_reject_door_switch\u0018\n \u0001(\b\"µ\u0002\n\u000fConnect_request\u0012K\n\u0007profile\u0018\u0001 \u0001(\u000e2:.com.tylohelo.tylohelo.protobuf.Connection_types.profile_t\u0012\u000b\n\u0003pin\u0018\u0002 \u0001(\t\u0012\u001a\n\u0012device_description\u0018\u0003 \u0003(\r\u0012\u0016\n\u000edevice_version\u0018\u0004 \u0003(\r\u0012\u001f\n\u0017application_description\u0018\u0005 \u0003(\r\u0012\u001b\n\u0013application_version\u0018\u0006 \u0003(\r\u0012V\n\u0016external_unit_features\u0018\u0007 \u0001(\u000b26.com.tylohelo.tylohelo.protobuf.External_unit_features\"å\u0005\n\rConnect_reply\u0012N\n\u0006status\u0018\u0001 \u0001(\u000e2>.com.tylohelo.tylohelo.protobuf.Connect_reply.connect_status_t\u0012\u0011\n\tsystem_id\u0018\u0002 \u0001(\t\u0012G\n\u0005brand\u0018\u0003 \u0001(\u000e28.com.tylohelo.tylohelo.protobuf.Connection_types.brand_t\u0012\u001e\n\u0016communication_time_out\u0018\u0004 \u0001(\r\u0012#\n\u001bcommunication_lost_time_out\u0018\u0005 \u0001(\r\u0012S\n\u000brcb_product\u0018\u0006 \u0001(\u000e2>.com.tylohelo.tylohelo.protobuf.Connection_types.rcb_product_t\u0012\u0013\n\u000bsystem_name\u0018\u0007 \u0003(\r\u0012F\n\u000esauna_features\u0018\b \u0001(\u000b2..com.tylohelo.tylohelo.protobuf.Sauna_features\u0012\u001f\n\u0017application_description\u0018\t \u0003(\r\u0012\u001b\n\u0013application_version\u0018\n \u0003(\r\u0012S\n\u000bsystem_type\u0018\u000b \u0001(\u000e2>.com.tylohelo.tylohelo.protobuf.Connection_types.system_type_t\"\u009d\u0001\n\u0010connect_status_t\u0012\u0014\n\u0010CONNECT_ACCEPTED\u0010\n\u0012\u0018\n\u0014CONNECT_REJECTED_PIN\u0010\u0014\u0012\"\n\u001eCONNECT_REJECTED_COMPATIBILITY\u0010\u0015\u0012\u0014\n\u0010CONNECT_REJECTED\u0010\u0016\u0012\u001f\n\u001bCONNECT_REJECTED_DOORSWITCH\u0010\u0017\"\u000f\n\rNo_connection\"%\n\nKeep_alive\u0012\u0017\n\u000fsequence_number\u0018\u0001 \u0001(\r\"c\n\u0014Announcement_request\u0012K\n\u0007profile\u0018\u0001 \u0001(\u000e2:.com.tylohelo.tylohelo.protobuf.Connection_types.profile_t\"\u0014\n\u0012Disconnect_requestB\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Announcement_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Announcement_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_No_connection_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_No_connection_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_fieldAccessorTable;

    public interface AnnouncementOrBuilder extends MessageOrBuilder {
        Connection_types.brand_t getBrand();

        int getPort();

        Connection_types.rcb_product_t getRcbProduct();

        Sauna_features getSaunaFeatures();

        Sauna_featuresOrBuilder getSaunaFeaturesOrBuilder();

        String getSystemId();

        ByteString getSystemIdBytes();

        int getSystemName(int i);

        int getSystemNameCount();

        List<Integer> getSystemNameList();

        Connection_types.system_type_t getSystemType();

        boolean hasBrand();

        boolean hasPort();

        boolean hasRcbProduct();

        boolean hasSaunaFeatures();

        boolean hasSystemId();

        boolean hasSystemType();
    }

    public interface Announcement_requestOrBuilder extends MessageOrBuilder {
        Connection_types.profile_t getProfile();

        boolean hasProfile();
    }

    public interface Connect_replyOrBuilder extends MessageOrBuilder {
        int getApplicationDescription(int i);

        int getApplicationDescriptionCount();

        List<Integer> getApplicationDescriptionList();

        int getApplicationVersion(int i);

        int getApplicationVersionCount();

        List<Integer> getApplicationVersionList();

        Connection_types.brand_t getBrand();

        int getCommunicationLostTimeOut();

        int getCommunicationTimeOut();

        Connection_types.rcb_product_t getRcbProduct();

        Sauna_features getSaunaFeatures();

        Sauna_featuresOrBuilder getSaunaFeaturesOrBuilder();

        Connect_reply.connect_status_t getStatus();

        String getSystemId();

        ByteString getSystemIdBytes();

        int getSystemName(int i);

        int getSystemNameCount();

        List<Integer> getSystemNameList();

        Connection_types.system_type_t getSystemType();

        boolean hasBrand();

        boolean hasCommunicationLostTimeOut();

        boolean hasCommunicationTimeOut();

        boolean hasRcbProduct();

        boolean hasSaunaFeatures();

        boolean hasStatus();

        boolean hasSystemId();

        boolean hasSystemType();
    }

    public interface Connect_requestOrBuilder extends MessageOrBuilder {
        int getApplicationDescription(int i);

        int getApplicationDescriptionCount();

        List<Integer> getApplicationDescriptionList();

        int getApplicationVersion(int i);

        int getApplicationVersionCount();

        List<Integer> getApplicationVersionList();

        int getDeviceDescription(int i);

        int getDeviceDescriptionCount();

        List<Integer> getDeviceDescriptionList();

        int getDeviceVersion(int i);

        int getDeviceVersionCount();

        List<Integer> getDeviceVersionList();

        External_unit_features getExternalUnitFeatures();

        External_unit_featuresOrBuilder getExternalUnitFeaturesOrBuilder();

        String getPin();

        ByteString getPinBytes();

        Connection_types.profile_t getProfile();

        boolean hasExternalUnitFeatures();

        boolean hasPin();

        boolean hasProfile();
    }

    public interface Connection_typesOrBuilder extends MessageOrBuilder {
    }

    public interface Disconnect_requestOrBuilder extends MessageOrBuilder {
    }

    public interface External_unit_featuresOrBuilder extends MessageOrBuilder {
        boolean getConnectRejectDoorSwitch();

        boolean hasConnectRejectDoorSwitch();
    }

    public interface Keep_aliveOrBuilder extends MessageOrBuilder {
        int getSequenceNumber();

        boolean hasSequenceNumber();
    }

    public interface No_connectionOrBuilder extends MessageOrBuilder {
    }

    public interface Sauna_featuresOrBuilder extends MessageOrBuilder {
        boolean getClearTextLogin();

        boolean getEncryptedLoginXtea();

        int getMaxHumidityVersion();

        int getMaxTemperatureVersion();

        int getNbSupportedCharacters();

        boolean hasClearTextLogin();

        boolean hasEncryptedLoginXtea();

        boolean hasMaxHumidityVersion();

        boolean hasMaxTemperatureVersion();

        boolean hasNbSupportedCharacters();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Connect() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Connection_types extends GeneratedMessageV3 implements Connection_typesOrBuilder {
        private static final Connection_types DEFAULT_INSTANCE = new Connection_types();

        @Deprecated
        public static final Parser<Connection_types> PARSER = new AbstractParser<Connection_types>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Connection_types.1
            @Override // com.google.protobuf.Parser
            public Connection_types parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Connection_types.newBuilder();
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

        private Connection_types(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Connection_types() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Connection_types();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_fieldAccessorTable.ensureFieldAccessorsInitialized(Connection_types.class, Builder.class);
        }

        public enum brand_t implements ProtocolMessageEnum {
            BRAND_TYLO(40),
            BRAND_HELO(41),
            BRAND_FINNLEO(42),
            BRAND_AMEREC(43);

            public static final int BRAND_AMEREC_VALUE = 43;
            public static final int BRAND_FINNLEO_VALUE = 42;
            public static final int BRAND_HELO_VALUE = 41;
            public static final int BRAND_TYLO_VALUE = 40;
            private final int value;
            private static final Internal.EnumLiteMap<brand_t> internalValueMap = new Internal.EnumLiteMap<brand_t>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Connection_types.brand_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public brand_t findValueByNumber(int i) {
                    return brand_t.forNumber(i);
                }
            };
            private static final brand_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static brand_t valueOf(int i) {
                return forNumber(i);
            }

            public static brand_t forNumber(int i) {
                switch (i) {
                    case 40:
                        return BRAND_TYLO;
                    case 41:
                        return BRAND_HELO;
                    case 42:
                        return BRAND_FINNLEO;
                    case 43:
                        return BRAND_AMEREC;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<brand_t> internalGetValueMap() {
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
                return Connection_types.getDescriptor().getEnumTypes().get(0);
            }

            public static brand_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            brand_t(int i) {
                this.value = i;
            }
        }

        public enum system_type_t implements ProtocolMessageEnum {
            SYSTYP_STANDARD(20),
            SYSTYP_MULTISTEAM(21),
            SYSTYP_TYLARIUM(22);

            public static final int SYSTYP_MULTISTEAM_VALUE = 21;
            public static final int SYSTYP_STANDARD_VALUE = 20;
            public static final int SYSTYP_TYLARIUM_VALUE = 22;
            private final int value;
            private static final Internal.EnumLiteMap<system_type_t> internalValueMap = new Internal.EnumLiteMap<system_type_t>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Connection_types.system_type_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public system_type_t findValueByNumber(int i) {
                    return system_type_t.forNumber(i);
                }
            };
            private static final system_type_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static system_type_t valueOf(int i) {
                return forNumber(i);
            }

            public static system_type_t forNumber(int i) {
                switch (i) {
                    case 20:
                        return SYSTYP_STANDARD;
                    case 21:
                        return SYSTYP_MULTISTEAM;
                    case 22:
                        return SYSTYP_TYLARIUM;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<system_type_t> internalGetValueMap() {
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
                return Connection_types.getDescriptor().getEnumTypes().get(1);
            }

            public static system_type_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            system_type_t(int i) {
                this.value = i;
            }
        }

        public enum rcb_product_t implements ProtocolMessageEnum {
            RCB_COMBI_MANUAL(30),
            RCB_COMBI_AUTO(31),
            RCB_STEAM_PRIVATE(32),
            RCB_STEAM_PRIVATE_AUTO(33),
            RCB_STEAM_PUBLIC(34),
            RCB_STEAM_USA(35),
            RCB_BOX_ADDON(36),
            RCB_SAUNA(37),
            RCB_SAUNA_LOW(38),
            RCB_SAUNA_IR(39),
            RCB_OTHER(40);

            public static final int RCB_BOX_ADDON_VALUE = 36;
            public static final int RCB_COMBI_AUTO_VALUE = 31;
            public static final int RCB_COMBI_MANUAL_VALUE = 30;
            public static final int RCB_OTHER_VALUE = 40;
            public static final int RCB_SAUNA_IR_VALUE = 39;
            public static final int RCB_SAUNA_LOW_VALUE = 38;
            public static final int RCB_SAUNA_VALUE = 37;
            public static final int RCB_STEAM_PRIVATE_AUTO_VALUE = 33;
            public static final int RCB_STEAM_PRIVATE_VALUE = 32;
            public static final int RCB_STEAM_PUBLIC_VALUE = 34;
            public static final int RCB_STEAM_USA_VALUE = 35;
            private final int value;
            private static final Internal.EnumLiteMap<rcb_product_t> internalValueMap = new Internal.EnumLiteMap<rcb_product_t>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Connection_types.rcb_product_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public rcb_product_t findValueByNumber(int i) {
                    return rcb_product_t.forNumber(i);
                }
            };
            private static final rcb_product_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static rcb_product_t valueOf(int i) {
                return forNumber(i);
            }

            public static rcb_product_t forNumber(int i) {
                switch (i) {
                    case 30:
                        return RCB_COMBI_MANUAL;
                    case 31:
                        return RCB_COMBI_AUTO;
                    case 32:
                        return RCB_STEAM_PRIVATE;
                    case 33:
                        return RCB_STEAM_PRIVATE_AUTO;
                    case 34:
                        return RCB_STEAM_PUBLIC;
                    case 35:
                        return RCB_STEAM_USA;
                    case 36:
                        return RCB_BOX_ADDON;
                    case 37:
                        return RCB_SAUNA;
                    case 38:
                        return RCB_SAUNA_LOW;
                    case 39:
                        return RCB_SAUNA_IR;
                    case 40:
                        return RCB_OTHER;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<rcb_product_t> internalGetValueMap() {
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
                return Connection_types.getDescriptor().getEnumTypes().get(2);
            }

            public static rcb_product_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            rcb_product_t(int i) {
                this.value = i;
            }
        }

        public enum profile_t implements ProtocolMessageEnum {
            PROFILE_PC_PANEL(10),
            PROFILE_SMART_PHONE_APP(20),
            PROFILE_TABLET_APP(25),
            PROFILE_HOME_AUTOMATION_SYSTEM(30),
            PROFILE_OTHER(99);

            public static final int PROFILE_HOME_AUTOMATION_SYSTEM_VALUE = 30;
            public static final int PROFILE_OTHER_VALUE = 99;
            public static final int PROFILE_PC_PANEL_VALUE = 10;
            public static final int PROFILE_SMART_PHONE_APP_VALUE = 20;
            public static final int PROFILE_TABLET_APP_VALUE = 25;
            private final int value;
            private static final Internal.EnumLiteMap<profile_t> internalValueMap = new Internal.EnumLiteMap<profile_t>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Connection_types.profile_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public profile_t findValueByNumber(int i) {
                    return profile_t.forNumber(i);
                }
            };
            private static final profile_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static profile_t valueOf(int i) {
                return forNumber(i);
            }

            public static profile_t forNumber(int i) {
                if (i == 10) {
                    return PROFILE_PC_PANEL;
                }
                if (i == 20) {
                    return PROFILE_SMART_PHONE_APP;
                }
                if (i == 25) {
                    return PROFILE_TABLET_APP;
                }
                if (i == 30) {
                    return PROFILE_HOME_AUTOMATION_SYSTEM;
                }
                if (i != 99) {
                    return null;
                }
                return PROFILE_OTHER;
            }

            public static Internal.EnumLiteMap<profile_t> internalGetValueMap() {
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
                return Connection_types.getDescriptor().getEnumTypes().get(3);
            }

            public static profile_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            profile_t(int i) {
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
            if (obj instanceof Connection_types) {
                return getUnknownFields().equals(((Connection_types) obj).getUnknownFields());
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

        public static Connection_types parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Connection_types parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Connection_types parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Connection_types parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Connection_types parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Connection_types parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Connection_types parseFrom(InputStream inputStream) throws IOException {
            return (Connection_types) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Connection_types parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connection_types) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Connection_types parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Connection_types) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Connection_types parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connection_types) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Connection_types parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Connection_types) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Connection_types parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connection_types) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Connection_types connection_types) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(connection_types);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Connection_typesOrBuilder {
            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_fieldAccessorTable.ensureFieldAccessorsInitialized(Connection_types.class, Builder.class);
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
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Connection_types getDefaultInstanceForType() {
                return Connection_types.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Connection_types build() {
                Connection_types buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Connection_types buildPartial() {
                Connection_types connection_types = new Connection_types(this);
                onBuilt();
                return connection_types;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Connection_types) {
                    return mergeFrom((Connection_types) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Connection_types connection_types) {
                if (connection_types == Connection_types.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(connection_types.getUnknownFields());
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

        public static Connection_types getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Connection_types> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Connection_types> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Connection_types getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Sauna_features extends GeneratedMessageV3 implements Sauna_featuresOrBuilder {
        public static final int CLEAR_TEXT_LOGIN_FIELD_NUMBER = 1;
        public static final int ENCRYPTED_LOGIN_XTEA_FIELD_NUMBER = 2;
        public static final int MAX_HUMIDITY_VERSION_FIELD_NUMBER = 21;
        public static final int MAX_TEMPERATURE_VERSION_FIELD_NUMBER = 22;
        public static final int NB_SUPPORTED_CHARACTERS_FIELD_NUMBER = 20;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean clearTextLogin_;
        private boolean encryptedLoginXtea_;
        private int maxHumidityVersion_;
        private int maxTemperatureVersion_;
        private byte memoizedIsInitialized;
        private int nbSupportedCharacters_;
        private static final Sauna_features DEFAULT_INSTANCE = new Sauna_features();

        @Deprecated
        public static final Parser<Sauna_features> PARSER = new AbstractParser<Sauna_features>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Sauna_features.1
            @Override // com.google.protobuf.Parser
            public Sauna_features parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Sauna_features.newBuilder();
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

        static /* synthetic */ int access$1576(Sauna_features sauna_features, int i) {
            int i2 = i | sauna_features.bitField0_;
            sauna_features.bitField0_ = i2;
            return i2;
        }

        private Sauna_features(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.clearTextLogin_ = false;
            this.encryptedLoginXtea_ = false;
            this.nbSupportedCharacters_ = 0;
            this.maxHumidityVersion_ = 0;
            this.maxTemperatureVersion_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Sauna_features() {
            this.clearTextLogin_ = false;
            this.encryptedLoginXtea_ = false;
            this.nbSupportedCharacters_ = 0;
            this.maxHumidityVersion_ = 0;
            this.maxTemperatureVersion_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Sauna_features();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_fieldAccessorTable.ensureFieldAccessorsInitialized(Sauna_features.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public boolean hasClearTextLogin() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public boolean getClearTextLogin() {
            return this.clearTextLogin_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public boolean hasEncryptedLoginXtea() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public boolean getEncryptedLoginXtea() {
            return this.encryptedLoginXtea_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public boolean hasNbSupportedCharacters() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public int getNbSupportedCharacters() {
            return this.nbSupportedCharacters_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public boolean hasMaxHumidityVersion() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public int getMaxHumidityVersion() {
            return this.maxHumidityVersion_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public boolean hasMaxTemperatureVersion() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
        public int getMaxTemperatureVersion() {
            return this.maxTemperatureVersion_;
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
                codedOutputStream.writeBool(1, this.clearTextLogin_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeBool(2, this.encryptedLoginXtea_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeUInt32(20, this.nbSupportedCharacters_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeUInt32(21, this.maxHumidityVersion_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeUInt32(22, this.maxTemperatureVersion_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeBoolSize(1, this.clearTextLogin_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeBoolSize += CodedOutputStream.computeBoolSize(2, this.encryptedLoginXtea_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeBoolSize += CodedOutputStream.computeUInt32Size(20, this.nbSupportedCharacters_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeBoolSize += CodedOutputStream.computeUInt32Size(21, this.maxHumidityVersion_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeBoolSize += CodedOutputStream.computeUInt32Size(22, this.maxTemperatureVersion_);
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
            if (!(obj instanceof Sauna_features)) {
                return super.equals(obj);
            }
            Sauna_features sauna_features = (Sauna_features) obj;
            if (hasClearTextLogin() != sauna_features.hasClearTextLogin()) {
                return false;
            }
            if ((hasClearTextLogin() && getClearTextLogin() != sauna_features.getClearTextLogin()) || hasEncryptedLoginXtea() != sauna_features.hasEncryptedLoginXtea()) {
                return false;
            }
            if ((hasEncryptedLoginXtea() && getEncryptedLoginXtea() != sauna_features.getEncryptedLoginXtea()) || hasNbSupportedCharacters() != sauna_features.hasNbSupportedCharacters()) {
                return false;
            }
            if ((hasNbSupportedCharacters() && getNbSupportedCharacters() != sauna_features.getNbSupportedCharacters()) || hasMaxHumidityVersion() != sauna_features.hasMaxHumidityVersion()) {
                return false;
            }
            if ((!hasMaxHumidityVersion() || getMaxHumidityVersion() == sauna_features.getMaxHumidityVersion()) && hasMaxTemperatureVersion() == sauna_features.hasMaxTemperatureVersion()) {
                return (!hasMaxTemperatureVersion() || getMaxTemperatureVersion() == sauna_features.getMaxTemperatureVersion()) && getUnknownFields().equals(sauna_features.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasClearTextLogin()) {
                hashCode = (((hashCode * 37) + 1) * 53) + Internal.hashBoolean(getClearTextLogin());
            }
            if (hasEncryptedLoginXtea()) {
                hashCode = (((hashCode * 37) + 2) * 53) + Internal.hashBoolean(getEncryptedLoginXtea());
            }
            if (hasNbSupportedCharacters()) {
                hashCode = (((hashCode * 37) + 20) * 53) + getNbSupportedCharacters();
            }
            if (hasMaxHumidityVersion()) {
                hashCode = (((hashCode * 37) + 21) * 53) + getMaxHumidityVersion();
            }
            if (hasMaxTemperatureVersion()) {
                hashCode = (((hashCode * 37) + 22) * 53) + getMaxTemperatureVersion();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Sauna_features parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Sauna_features parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Sauna_features parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Sauna_features parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Sauna_features parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Sauna_features parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Sauna_features parseFrom(InputStream inputStream) throws IOException {
            return (Sauna_features) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Sauna_features parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_features) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Sauna_features parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Sauna_features) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Sauna_features parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_features) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Sauna_features parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Sauna_features) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Sauna_features parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_features) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Sauna_features sauna_features) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sauna_features);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Sauna_featuresOrBuilder {
            private int bitField0_;
            private boolean clearTextLogin_;
            private boolean encryptedLoginXtea_;
            private int maxHumidityVersion_;
            private int maxTemperatureVersion_;
            private int nbSupportedCharacters_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_fieldAccessorTable.ensureFieldAccessorsInitialized(Sauna_features.class, Builder.class);
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
                this.clearTextLogin_ = false;
                this.encryptedLoginXtea_ = false;
                this.nbSupportedCharacters_ = 0;
                this.maxHumidityVersion_ = 0;
                this.maxTemperatureVersion_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Sauna_features getDefaultInstanceForType() {
                return Sauna_features.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Sauna_features build() {
                Sauna_features buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Sauna_features buildPartial() {
                Sauna_features sauna_features = new Sauna_features(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(sauna_features);
                }
                onBuilt();
                return sauna_features;
            }

            private void buildPartial0(Sauna_features sauna_features) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    sauna_features.clearTextLogin_ = this.clearTextLogin_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    sauna_features.encryptedLoginXtea_ = this.encryptedLoginXtea_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    sauna_features.nbSupportedCharacters_ = this.nbSupportedCharacters_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    sauna_features.maxHumidityVersion_ = this.maxHumidityVersion_;
                    i |= 8;
                }
                if ((i2 & 16) != 0) {
                    sauna_features.maxTemperatureVersion_ = this.maxTemperatureVersion_;
                    i |= 16;
                }
                Sauna_features.access$1576(sauna_features, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Sauna_features) {
                    return mergeFrom((Sauna_features) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Sauna_features sauna_features) {
                if (sauna_features == Sauna_features.getDefaultInstance()) {
                    return this;
                }
                if (sauna_features.hasClearTextLogin()) {
                    setClearTextLogin(sauna_features.getClearTextLogin());
                }
                if (sauna_features.hasEncryptedLoginXtea()) {
                    setEncryptedLoginXtea(sauna_features.getEncryptedLoginXtea());
                }
                if (sauna_features.hasNbSupportedCharacters()) {
                    setNbSupportedCharacters(sauna_features.getNbSupportedCharacters());
                }
                if (sauna_features.hasMaxHumidityVersion()) {
                    setMaxHumidityVersion(sauna_features.getMaxHumidityVersion());
                }
                if (sauna_features.hasMaxTemperatureVersion()) {
                    setMaxTemperatureVersion(sauna_features.getMaxTemperatureVersion());
                }
                mergeUnknownFields(sauna_features.getUnknownFields());
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
                                    this.clearTextLogin_ = codedInputStream.readBool();
                                    this.bitField0_ |= 1;
                                } else if (readTag == 16) {
                                    this.encryptedLoginXtea_ = codedInputStream.readBool();
                                    this.bitField0_ |= 2;
                                } else if (readTag == 160) {
                                    this.nbSupportedCharacters_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 4;
                                } else if (readTag == 168) {
                                    this.maxHumidityVersion_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 8;
                                } else if (readTag == 176) {
                                    this.maxTemperatureVersion_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 16;
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

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public boolean hasClearTextLogin() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public boolean getClearTextLogin() {
                return this.clearTextLogin_;
            }

            public Builder setClearTextLogin(boolean z) {
                this.clearTextLogin_ = z;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearClearTextLogin() {
                this.bitField0_ &= -2;
                this.clearTextLogin_ = false;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public boolean hasEncryptedLoginXtea() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public boolean getEncryptedLoginXtea() {
                return this.encryptedLoginXtea_;
            }

            public Builder setEncryptedLoginXtea(boolean z) {
                this.encryptedLoginXtea_ = z;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearEncryptedLoginXtea() {
                this.bitField0_ &= -3;
                this.encryptedLoginXtea_ = false;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public boolean hasNbSupportedCharacters() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public int getNbSupportedCharacters() {
                return this.nbSupportedCharacters_;
            }

            public Builder setNbSupportedCharacters(int i) {
                this.nbSupportedCharacters_ = i;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearNbSupportedCharacters() {
                this.bitField0_ &= -5;
                this.nbSupportedCharacters_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public boolean hasMaxHumidityVersion() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public int getMaxHumidityVersion() {
                return this.maxHumidityVersion_;
            }

            public Builder setMaxHumidityVersion(int i) {
                this.maxHumidityVersion_ = i;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearMaxHumidityVersion() {
                this.bitField0_ &= -9;
                this.maxHumidityVersion_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public boolean hasMaxTemperatureVersion() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Sauna_featuresOrBuilder
            public int getMaxTemperatureVersion() {
                return this.maxTemperatureVersion_;
            }

            public Builder setMaxTemperatureVersion(int i) {
                this.maxTemperatureVersion_ = i;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder clearMaxTemperatureVersion() {
                this.bitField0_ &= -17;
                this.maxTemperatureVersion_ = 0;
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

        public static Sauna_features getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Sauna_features> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Sauna_features> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Sauna_features getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Announcement extends GeneratedMessageV3 implements AnnouncementOrBuilder {
        public static final int BRAND_FIELD_NUMBER = 3;
        private static final Announcement DEFAULT_INSTANCE = new Announcement();

        @Deprecated
        public static final Parser<Announcement> PARSER = new AbstractParser<Announcement>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Announcement.1
            @Override // com.google.protobuf.Parser
            public Announcement parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Announcement.newBuilder();
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
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int RCB_PRODUCT_FIELD_NUMBER = 4;
        public static final int SAUNA_FEATURES_FIELD_NUMBER = 6;
        public static final int SYSTEM_ID_FIELD_NUMBER = 1;
        public static final int SYSTEM_NAME_FIELD_NUMBER = 5;
        public static final int SYSTEM_TYPE_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int brand_;
        private byte memoizedIsInitialized;
        private int port_;
        private int rcbProduct_;
        private Sauna_features saunaFeatures_;
        private volatile Object systemId_;
        private Internal.IntList systemName_;
        private int systemType_;

        static /* synthetic */ int access$3076(Announcement announcement, int i) {
            int i2 = i | announcement.bitField0_;
            announcement.bitField0_ = i2;
            return i2;
        }

        private Announcement(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.systemId_ = "";
            this.port_ = 0;
            this.brand_ = 40;
            this.rcbProduct_ = 30;
            this.systemType_ = 20;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Announcement() {
            this.systemId_ = "";
            this.port_ = 0;
            this.brand_ = 40;
            this.rcbProduct_ = 30;
            this.systemType_ = 20;
            this.memoizedIsInitialized = (byte) -1;
            this.systemId_ = "";
            this.brand_ = 40;
            this.rcbProduct_ = 30;
            this.systemName_ = emptyIntList();
            this.systemType_ = 20;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Announcement();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_fieldAccessorTable.ensureFieldAccessorsInitialized(Announcement.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public boolean hasSystemId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public String getSystemId() {
            Object obj = this.systemId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.systemId_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public ByteString getSystemIdBytes() {
            Object obj = this.systemId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.systemId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public boolean hasPort() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public int getPort() {
            return this.port_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public boolean hasBrand() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public Connection_types.brand_t getBrand() {
            Connection_types.brand_t forNumber = Connection_types.brand_t.forNumber(this.brand_);
            return forNumber == null ? Connection_types.brand_t.BRAND_TYLO : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public boolean hasRcbProduct() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public Connection_types.rcb_product_t getRcbProduct() {
            Connection_types.rcb_product_t forNumber = Connection_types.rcb_product_t.forNumber(this.rcbProduct_);
            return forNumber == null ? Connection_types.rcb_product_t.RCB_COMBI_MANUAL : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public List<Integer> getSystemNameList() {
            return this.systemName_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public int getSystemNameCount() {
            return this.systemName_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public int getSystemName(int i) {
            return this.systemName_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public boolean hasSaunaFeatures() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public Sauna_features getSaunaFeatures() {
            Sauna_features sauna_features = this.saunaFeatures_;
            return sauna_features == null ? Sauna_features.getDefaultInstance() : sauna_features;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public Sauna_featuresOrBuilder getSaunaFeaturesOrBuilder() {
            Sauna_features sauna_features = this.saunaFeatures_;
            return sauna_features == null ? Sauna_features.getDefaultInstance() : sauna_features;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public boolean hasSystemType() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
        public Connection_types.system_type_t getSystemType() {
            Connection_types.system_type_t forNumber = Connection_types.system_type_t.forNumber(this.systemType_);
            return forNumber == null ? Connection_types.system_type_t.SYSTYP_STANDARD : forNumber;
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
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.systemId_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeUInt32(2, this.port_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeEnum(3, this.brand_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeEnum(4, this.rcbProduct_);
            }
            for (int i = 0; i < this.systemName_.size(); i++) {
                codedOutputStream.writeUInt32(5, this.systemName_.getInt(i));
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeMessage(6, getSaunaFeatures());
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.writeEnum(7, this.systemType_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) != 0 ? GeneratedMessageV3.computeStringSize(1, this.systemId_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeStringSize += CodedOutputStream.computeUInt32Size(2, this.port_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeStringSize += CodedOutputStream.computeEnumSize(3, this.brand_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeStringSize += CodedOutputStream.computeEnumSize(4, this.rcbProduct_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.systemName_.size(); i3++) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(this.systemName_.getInt(i3));
            }
            int size = computeStringSize + i2 + getSystemNameList().size();
            if ((this.bitField0_ & 16) != 0) {
                size += CodedOutputStream.computeMessageSize(6, getSaunaFeatures());
            }
            if ((this.bitField0_ & 32) != 0) {
                size += CodedOutputStream.computeEnumSize(7, this.systemType_);
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
            if (!(obj instanceof Announcement)) {
                return super.equals(obj);
            }
            Announcement announcement = (Announcement) obj;
            if (hasSystemId() != announcement.hasSystemId()) {
                return false;
            }
            if ((hasSystemId() && !getSystemId().equals(announcement.getSystemId())) || hasPort() != announcement.hasPort()) {
                return false;
            }
            if ((hasPort() && getPort() != announcement.getPort()) || hasBrand() != announcement.hasBrand()) {
                return false;
            }
            if ((hasBrand() && this.brand_ != announcement.brand_) || hasRcbProduct() != announcement.hasRcbProduct()) {
                return false;
            }
            if ((hasRcbProduct() && this.rcbProduct_ != announcement.rcbProduct_) || !getSystemNameList().equals(announcement.getSystemNameList()) || hasSaunaFeatures() != announcement.hasSaunaFeatures()) {
                return false;
            }
            if ((!hasSaunaFeatures() || getSaunaFeatures().equals(announcement.getSaunaFeatures())) && hasSystemType() == announcement.hasSystemType()) {
                return (!hasSystemType() || this.systemType_ == announcement.systemType_) && getUnknownFields().equals(announcement.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasSystemId()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getSystemId().hashCode();
            }
            if (hasPort()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getPort();
            }
            if (hasBrand()) {
                hashCode = (((hashCode * 37) + 3) * 53) + this.brand_;
            }
            if (hasRcbProduct()) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.rcbProduct_;
            }
            if (getSystemNameCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getSystemNameList().hashCode();
            }
            if (hasSaunaFeatures()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getSaunaFeatures().hashCode();
            }
            if (hasSystemType()) {
                hashCode = (((hashCode * 37) + 7) * 53) + this.systemType_;
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Announcement parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Announcement parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Announcement parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Announcement parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Announcement parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Announcement parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Announcement parseFrom(InputStream inputStream) throws IOException {
            return (Announcement) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Announcement parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Announcement) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Announcement parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Announcement) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Announcement parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Announcement) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Announcement parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Announcement) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Announcement parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Announcement) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Announcement announcement) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(announcement);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnnouncementOrBuilder {
            private int bitField0_;
            private int brand_;
            private int port_;
            private int rcbProduct_;
            private SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> saunaFeaturesBuilder_;
            private Sauna_features saunaFeatures_;
            private Object systemId_;
            private Internal.IntList systemName_;
            private int systemType_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_fieldAccessorTable.ensureFieldAccessorsInitialized(Announcement.class, Builder.class);
            }

            private Builder() {
                this.systemId_ = "";
                this.brand_ = 40;
                this.rcbProduct_ = 30;
                this.systemName_ = Announcement.emptyIntList();
                this.systemType_ = 20;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.systemId_ = "";
                this.brand_ = 40;
                this.rcbProduct_ = 30;
                this.systemName_ = Announcement.emptyIntList();
                this.systemType_ = 20;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Announcement.alwaysUseFieldBuilders) {
                    getSaunaFeaturesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.systemId_ = "";
                this.port_ = 0;
                this.brand_ = 40;
                this.rcbProduct_ = 30;
                this.systemName_ = Announcement.emptyIntList();
                this.saunaFeatures_ = null;
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.saunaFeaturesBuilder_ = null;
                }
                this.systemType_ = 20;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Announcement getDefaultInstanceForType() {
                return Announcement.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Announcement build() {
                Announcement buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Announcement buildPartial() {
                Announcement announcement = new Announcement(this);
                buildPartialRepeatedFields(announcement);
                if (this.bitField0_ != 0) {
                    buildPartial0(announcement);
                }
                onBuilt();
                return announcement;
            }

            private void buildPartialRepeatedFields(Announcement announcement) {
                if ((this.bitField0_ & 16) != 0) {
                    this.systemName_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                announcement.systemName_ = this.systemName_;
            }

            private void buildPartial0(Announcement announcement) {
                int i;
                Sauna_features build;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    announcement.systemId_ = this.systemId_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    announcement.port_ = this.port_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    announcement.brand_ = this.brand_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    announcement.rcbProduct_ = this.rcbProduct_;
                    i |= 8;
                }
                if ((i2 & 32) != 0) {
                    SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        build = this.saunaFeatures_;
                    } else {
                        build = singleFieldBuilderV3.build();
                    }
                    announcement.saunaFeatures_ = build;
                    i |= 16;
                }
                if ((i2 & 64) != 0) {
                    announcement.systemType_ = this.systemType_;
                    i |= 32;
                }
                Announcement.access$3076(announcement, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Announcement) {
                    return mergeFrom((Announcement) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Announcement announcement) {
                if (announcement == Announcement.getDefaultInstance()) {
                    return this;
                }
                if (announcement.hasSystemId()) {
                    this.systemId_ = announcement.systemId_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (announcement.hasPort()) {
                    setPort(announcement.getPort());
                }
                if (announcement.hasBrand()) {
                    setBrand(announcement.getBrand());
                }
                if (announcement.hasRcbProduct()) {
                    setRcbProduct(announcement.getRcbProduct());
                }
                if (!announcement.systemName_.isEmpty()) {
                    if (this.systemName_.isEmpty()) {
                        this.systemName_ = announcement.systemName_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureSystemNameIsMutable();
                        this.systemName_.addAll(announcement.systemName_);
                    }
                    onChanged();
                }
                if (announcement.hasSaunaFeatures()) {
                    mergeSaunaFeatures(announcement.getSaunaFeatures());
                }
                if (announcement.hasSystemType()) {
                    setSystemType(announcement.getSystemType());
                }
                mergeUnknownFields(announcement.getUnknownFields());
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
                                if (readTag == 10) {
                                    this.systemId_ = codedInputStream.readBytes();
                                    this.bitField0_ |= 1;
                                } else if (readTag == 16) {
                                    this.port_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 2;
                                } else if (readTag == 24) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (Connection_types.brand_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(3, readEnum);
                                    } else {
                                        this.brand_ = readEnum;
                                        this.bitField0_ |= 4;
                                    }
                                } else if (readTag == 32) {
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (Connection_types.rcb_product_t.forNumber(readEnum2) == null) {
                                        mergeUnknownVarintField(4, readEnum2);
                                    } else {
                                        this.rcbProduct_ = readEnum2;
                                        this.bitField0_ |= 8;
                                    }
                                } else if (readTag == 40) {
                                    int readUInt32 = codedInputStream.readUInt32();
                                    ensureSystemNameIsMutable();
                                    this.systemName_.addInt(readUInt32);
                                } else if (readTag == 42) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureSystemNameIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.systemName_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag == 50) {
                                    codedInputStream.readMessage(getSaunaFeaturesFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 32;
                                } else if (readTag == 56) {
                                    int readEnum3 = codedInputStream.readEnum();
                                    if (Connection_types.system_type_t.forNumber(readEnum3) == null) {
                                        mergeUnknownVarintField(7, readEnum3);
                                    } else {
                                        this.systemType_ = readEnum3;
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

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public boolean hasSystemId() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public String getSystemId() {
                Object obj = this.systemId_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.systemId_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public ByteString getSystemIdBytes() {
                Object obj = this.systemId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.systemId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setSystemId(String str) {
                str.getClass();
                this.systemId_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearSystemId() {
                this.systemId_ = Announcement.getDefaultInstance().getSystemId();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder setSystemIdBytes(ByteString byteString) {
                byteString.getClass();
                this.systemId_ = byteString;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public boolean hasPort() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public int getPort() {
                return this.port_;
            }

            public Builder setPort(int i) {
                this.port_ = i;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearPort() {
                this.bitField0_ &= -3;
                this.port_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public boolean hasBrand() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public Connection_types.brand_t getBrand() {
                Connection_types.brand_t forNumber = Connection_types.brand_t.forNumber(this.brand_);
                return forNumber == null ? Connection_types.brand_t.BRAND_TYLO : forNumber;
            }

            public Builder setBrand(Connection_types.brand_t brand_tVar) {
                brand_tVar.getClass();
                this.bitField0_ |= 4;
                this.brand_ = brand_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearBrand() {
                this.bitField0_ &= -5;
                this.brand_ = 40;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public boolean hasRcbProduct() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public Connection_types.rcb_product_t getRcbProduct() {
                Connection_types.rcb_product_t forNumber = Connection_types.rcb_product_t.forNumber(this.rcbProduct_);
                return forNumber == null ? Connection_types.rcb_product_t.RCB_COMBI_MANUAL : forNumber;
            }

            public Builder setRcbProduct(Connection_types.rcb_product_t rcb_product_tVar) {
                rcb_product_tVar.getClass();
                this.bitField0_ |= 8;
                this.rcbProduct_ = rcb_product_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearRcbProduct() {
                this.bitField0_ &= -9;
                this.rcbProduct_ = 30;
                onChanged();
                return this;
            }

            private void ensureSystemNameIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.systemName_ = Announcement.mutableCopy(this.systemName_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public List<Integer> getSystemNameList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.systemName_) : this.systemName_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public int getSystemNameCount() {
                return this.systemName_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public int getSystemName(int i) {
                return this.systemName_.getInt(i);
            }

            public Builder setSystemName(int i, int i2) {
                ensureSystemNameIsMutable();
                this.systemName_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addSystemName(int i) {
                ensureSystemNameIsMutable();
                this.systemName_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllSystemName(Iterable<? extends Integer> iterable) {
                ensureSystemNameIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.systemName_);
                onChanged();
                return this;
            }

            public Builder clearSystemName() {
                this.systemName_ = Announcement.emptyIntList();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public boolean hasSaunaFeatures() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public Sauna_features getSaunaFeatures() {
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Sauna_features sauna_features = this.saunaFeatures_;
                    return sauna_features == null ? Sauna_features.getDefaultInstance() : sauna_features;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSaunaFeatures(Sauna_features sauna_features) {
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sauna_features.getClass();
                    this.saunaFeatures_ = sauna_features;
                } else {
                    singleFieldBuilderV3.setMessage(sauna_features);
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setSaunaFeatures(Sauna_features.Builder builder) {
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.saunaFeatures_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder mergeSaunaFeatures(Sauna_features sauna_features) {
                Sauna_features sauna_features2;
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 32) != 0 && (sauna_features2 = this.saunaFeatures_) != null && sauna_features2 != Sauna_features.getDefaultInstance()) {
                        getSaunaFeaturesBuilder().mergeFrom(sauna_features);
                    } else {
                        this.saunaFeatures_ = sauna_features;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(sauna_features);
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder clearSaunaFeatures() {
                this.bitField0_ &= -33;
                this.saunaFeatures_ = null;
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.saunaFeaturesBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Sauna_features.Builder getSaunaFeaturesBuilder() {
                this.bitField0_ |= 32;
                onChanged();
                return getSaunaFeaturesFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public Sauna_featuresOrBuilder getSaunaFeaturesOrBuilder() {
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Sauna_features sauna_features = this.saunaFeatures_;
                return sauna_features == null ? Sauna_features.getDefaultInstance() : sauna_features;
            }

            private SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> getSaunaFeaturesFieldBuilder() {
                if (this.saunaFeaturesBuilder_ == null) {
                    this.saunaFeaturesBuilder_ = new SingleFieldBuilderV3<>(getSaunaFeatures(), getParentForChildren(), isClean());
                    this.saunaFeatures_ = null;
                }
                return this.saunaFeaturesBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public boolean hasSystemType() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.AnnouncementOrBuilder
            public Connection_types.system_type_t getSystemType() {
                Connection_types.system_type_t forNumber = Connection_types.system_type_t.forNumber(this.systemType_);
                return forNumber == null ? Connection_types.system_type_t.SYSTYP_STANDARD : forNumber;
            }

            public Builder setSystemType(Connection_types.system_type_t system_type_tVar) {
                system_type_tVar.getClass();
                this.bitField0_ |= 64;
                this.systemType_ = system_type_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearSystemType() {
                this.bitField0_ &= -65;
                this.systemType_ = 20;
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

        public static Announcement getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Announcement> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Announcement> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Announcement getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class External_unit_features extends GeneratedMessageV3 implements External_unit_featuresOrBuilder {
        public static final int CONNECT_REJECT_DOOR_SWITCH_FIELD_NUMBER = 10;
        private static final External_unit_features DEFAULT_INSTANCE = new External_unit_features();

        @Deprecated
        public static final Parser<External_unit_features> PARSER = new AbstractParser<External_unit_features>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.External_unit_features.1
            @Override // com.google.protobuf.Parser
            public External_unit_features parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = External_unit_features.newBuilder();
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
        private int bitField0_;
        private boolean connectRejectDoorSwitch_;
        private byte memoizedIsInitialized;

        static /* synthetic */ int access$4076(External_unit_features external_unit_features, int i) {
            int i2 = i | external_unit_features.bitField0_;
            external_unit_features.bitField0_ = i2;
            return i2;
        }

        private External_unit_features(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.connectRejectDoorSwitch_ = false;
            this.memoizedIsInitialized = (byte) -1;
        }

        private External_unit_features() {
            this.connectRejectDoorSwitch_ = false;
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new External_unit_features();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_fieldAccessorTable.ensureFieldAccessorsInitialized(External_unit_features.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.External_unit_featuresOrBuilder
        public boolean hasConnectRejectDoorSwitch() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.External_unit_featuresOrBuilder
        public boolean getConnectRejectDoorSwitch() {
            return this.connectRejectDoorSwitch_;
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
                codedOutputStream.writeBool(10, this.connectRejectDoorSwitch_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = ((this.bitField0_ & 1) != 0 ? CodedOutputStream.computeBoolSize(10, this.connectRejectDoorSwitch_) : 0) + getUnknownFields().getSerializedSize();
            this.memoizedSize = computeBoolSize;
            return computeBoolSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof External_unit_features)) {
                return super.equals(obj);
            }
            External_unit_features external_unit_features = (External_unit_features) obj;
            if (hasConnectRejectDoorSwitch() != external_unit_features.hasConnectRejectDoorSwitch()) {
                return false;
            }
            return (!hasConnectRejectDoorSwitch() || getConnectRejectDoorSwitch() == external_unit_features.getConnectRejectDoorSwitch()) && getUnknownFields().equals(external_unit_features.getUnknownFields());
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasConnectRejectDoorSwitch()) {
                hashCode = (((hashCode * 37) + 10) * 53) + Internal.hashBoolean(getConnectRejectDoorSwitch());
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static External_unit_features parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static External_unit_features parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static External_unit_features parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static External_unit_features parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static External_unit_features parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static External_unit_features parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static External_unit_features parseFrom(InputStream inputStream) throws IOException {
            return (External_unit_features) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static External_unit_features parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (External_unit_features) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static External_unit_features parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (External_unit_features) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static External_unit_features parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (External_unit_features) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static External_unit_features parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (External_unit_features) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static External_unit_features parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (External_unit_features) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(External_unit_features external_unit_features) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(external_unit_features);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements External_unit_featuresOrBuilder {
            private int bitField0_;
            private boolean connectRejectDoorSwitch_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_fieldAccessorTable.ensureFieldAccessorsInitialized(External_unit_features.class, Builder.class);
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
                this.connectRejectDoorSwitch_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public External_unit_features getDefaultInstanceForType() {
                return External_unit_features.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public External_unit_features build() {
                External_unit_features buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public External_unit_features buildPartial() {
                External_unit_features external_unit_features = new External_unit_features(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(external_unit_features);
                }
                onBuilt();
                return external_unit_features;
            }

            private void buildPartial0(External_unit_features external_unit_features) {
                int i = 1;
                if ((this.bitField0_ & 1) != 0) {
                    external_unit_features.connectRejectDoorSwitch_ = this.connectRejectDoorSwitch_;
                } else {
                    i = 0;
                }
                External_unit_features.access$4076(external_unit_features, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof External_unit_features) {
                    return mergeFrom((External_unit_features) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(External_unit_features external_unit_features) {
                if (external_unit_features == External_unit_features.getDefaultInstance()) {
                    return this;
                }
                if (external_unit_features.hasConnectRejectDoorSwitch()) {
                    setConnectRejectDoorSwitch(external_unit_features.getConnectRejectDoorSwitch());
                }
                mergeUnknownFields(external_unit_features.getUnknownFields());
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
                                    this.connectRejectDoorSwitch_ = codedInputStream.readBool();
                                    this.bitField0_ |= 1;
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

            @Override // com.tylohelo.tylohelo.protobuf.Connect.External_unit_featuresOrBuilder
            public boolean hasConnectRejectDoorSwitch() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.External_unit_featuresOrBuilder
            public boolean getConnectRejectDoorSwitch() {
                return this.connectRejectDoorSwitch_;
            }

            public Builder setConnectRejectDoorSwitch(boolean z) {
                this.connectRejectDoorSwitch_ = z;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearConnectRejectDoorSwitch() {
                this.bitField0_ &= -2;
                this.connectRejectDoorSwitch_ = false;
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

        public static External_unit_features getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<External_unit_features> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<External_unit_features> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public External_unit_features getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Connect_request extends GeneratedMessageV3 implements Connect_requestOrBuilder {
        public static final int APPLICATION_DESCRIPTION_FIELD_NUMBER = 5;
        public static final int APPLICATION_VERSION_FIELD_NUMBER = 6;
        public static final int DEVICE_DESCRIPTION_FIELD_NUMBER = 3;
        public static final int DEVICE_VERSION_FIELD_NUMBER = 4;
        public static final int EXTERNAL_UNIT_FEATURES_FIELD_NUMBER = 7;
        public static final int PIN_FIELD_NUMBER = 2;
        public static final int PROFILE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private Internal.IntList applicationDescription_;
        private Internal.IntList applicationVersion_;
        private int bitField0_;
        private Internal.IntList deviceDescription_;
        private Internal.IntList deviceVersion_;
        private External_unit_features externalUnitFeatures_;
        private byte memoizedIsInitialized;
        private volatile Object pin_;
        private int profile_;
        private static final Connect_request DEFAULT_INSTANCE = new Connect_request();

        @Deprecated
        public static final Parser<Connect_request> PARSER = new AbstractParser<Connect_request>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Connect_request.1
            @Override // com.google.protobuf.Parser
            public Connect_request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Connect_request.newBuilder();
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

        static /* synthetic */ int access$5876(Connect_request connect_request, int i) {
            int i2 = i | connect_request.bitField0_;
            connect_request.bitField0_ = i2;
            return i2;
        }

        private Connect_request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.profile_ = 10;
            this.pin_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        private Connect_request() {
            this.profile_ = 10;
            this.pin_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.profile_ = 10;
            this.pin_ = "";
            this.deviceDescription_ = emptyIntList();
            this.deviceVersion_ = emptyIntList();
            this.applicationDescription_ = emptyIntList();
            this.applicationVersion_ = emptyIntList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Connect_request();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Connect_request.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public boolean hasProfile() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public Connection_types.profile_t getProfile() {
            Connection_types.profile_t forNumber = Connection_types.profile_t.forNumber(this.profile_);
            return forNumber == null ? Connection_types.profile_t.PROFILE_PC_PANEL : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public boolean hasPin() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public String getPin() {
            Object obj = this.pin_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.pin_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public ByteString getPinBytes() {
            Object obj = this.pin_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pin_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public List<Integer> getDeviceDescriptionList() {
            return this.deviceDescription_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public int getDeviceDescriptionCount() {
            return this.deviceDescription_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public int getDeviceDescription(int i) {
            return this.deviceDescription_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public List<Integer> getDeviceVersionList() {
            return this.deviceVersion_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public int getDeviceVersionCount() {
            return this.deviceVersion_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public int getDeviceVersion(int i) {
            return this.deviceVersion_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public List<Integer> getApplicationDescriptionList() {
            return this.applicationDescription_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public int getApplicationDescriptionCount() {
            return this.applicationDescription_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public int getApplicationDescription(int i) {
            return this.applicationDescription_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public List<Integer> getApplicationVersionList() {
            return this.applicationVersion_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public int getApplicationVersionCount() {
            return this.applicationVersion_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public int getApplicationVersion(int i) {
            return this.applicationVersion_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public boolean hasExternalUnitFeatures() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public External_unit_features getExternalUnitFeatures() {
            External_unit_features external_unit_features = this.externalUnitFeatures_;
            return external_unit_features == null ? External_unit_features.getDefaultInstance() : external_unit_features;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
        public External_unit_featuresOrBuilder getExternalUnitFeaturesOrBuilder() {
            External_unit_features external_unit_features = this.externalUnitFeatures_;
            return external_unit_features == null ? External_unit_features.getDefaultInstance() : external_unit_features;
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
                codedOutputStream.writeEnum(1, this.profile_);
            }
            if ((this.bitField0_ & 2) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.pin_);
            }
            for (int i = 0; i < this.deviceDescription_.size(); i++) {
                codedOutputStream.writeUInt32(3, this.deviceDescription_.getInt(i));
            }
            for (int i2 = 0; i2 < this.deviceVersion_.size(); i2++) {
                codedOutputStream.writeUInt32(4, this.deviceVersion_.getInt(i2));
            }
            for (int i3 = 0; i3 < this.applicationDescription_.size(); i3++) {
                codedOutputStream.writeUInt32(5, this.applicationDescription_.getInt(i3));
            }
            for (int i4 = 0; i4 < this.applicationVersion_.size(); i4++) {
                codedOutputStream.writeUInt32(6, this.applicationVersion_.getInt(i4));
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeMessage(7, getExternalUnitFeatures());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(1, this.profile_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.pin_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.deviceDescription_.size(); i3++) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(this.deviceDescription_.getInt(i3));
            }
            int size = computeEnumSize + i2 + getDeviceDescriptionList().size();
            int i4 = 0;
            for (int i5 = 0; i5 < this.deviceVersion_.size(); i5++) {
                i4 += CodedOutputStream.computeUInt32SizeNoTag(this.deviceVersion_.getInt(i5));
            }
            int size2 = size + i4 + getDeviceVersionList().size();
            int i6 = 0;
            for (int i7 = 0; i7 < this.applicationDescription_.size(); i7++) {
                i6 += CodedOutputStream.computeUInt32SizeNoTag(this.applicationDescription_.getInt(i7));
            }
            int size3 = size2 + i6 + getApplicationDescriptionList().size();
            int i8 = 0;
            for (int i9 = 0; i9 < this.applicationVersion_.size(); i9++) {
                i8 += CodedOutputStream.computeUInt32SizeNoTag(this.applicationVersion_.getInt(i9));
            }
            int size4 = size3 + i8 + getApplicationVersionList().size();
            if ((this.bitField0_ & 4) != 0) {
                size4 += CodedOutputStream.computeMessageSize(7, getExternalUnitFeatures());
            }
            int serializedSize = size4 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Connect_request)) {
                return super.equals(obj);
            }
            Connect_request connect_request = (Connect_request) obj;
            if (hasProfile() != connect_request.hasProfile()) {
                return false;
            }
            if ((hasProfile() && this.profile_ != connect_request.profile_) || hasPin() != connect_request.hasPin()) {
                return false;
            }
            if ((!hasPin() || getPin().equals(connect_request.getPin())) && getDeviceDescriptionList().equals(connect_request.getDeviceDescriptionList()) && getDeviceVersionList().equals(connect_request.getDeviceVersionList()) && getApplicationDescriptionList().equals(connect_request.getApplicationDescriptionList()) && getApplicationVersionList().equals(connect_request.getApplicationVersionList()) && hasExternalUnitFeatures() == connect_request.hasExternalUnitFeatures()) {
                return (!hasExternalUnitFeatures() || getExternalUnitFeatures().equals(connect_request.getExternalUnitFeatures())) && getUnknownFields().equals(connect_request.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasProfile()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.profile_;
            }
            if (hasPin()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getPin().hashCode();
            }
            if (getDeviceDescriptionCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getDeviceDescriptionList().hashCode();
            }
            if (getDeviceVersionCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getDeviceVersionList().hashCode();
            }
            if (getApplicationDescriptionCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getApplicationDescriptionList().hashCode();
            }
            if (getApplicationVersionCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getApplicationVersionList().hashCode();
            }
            if (hasExternalUnitFeatures()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getExternalUnitFeatures().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Connect_request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Connect_request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Connect_request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Connect_request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Connect_request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Connect_request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Connect_request parseFrom(InputStream inputStream) throws IOException {
            return (Connect_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Connect_request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Connect_request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Connect_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Connect_request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Connect_request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Connect_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Connect_request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Connect_request connect_request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(connect_request);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Connect_requestOrBuilder {
            private Internal.IntList applicationDescription_;
            private Internal.IntList applicationVersion_;
            private int bitField0_;
            private Internal.IntList deviceDescription_;
            private Internal.IntList deviceVersion_;
            private SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> externalUnitFeaturesBuilder_;
            private External_unit_features externalUnitFeatures_;
            private Object pin_;
            private int profile_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Connect_request.class, Builder.class);
            }

            private Builder() {
                this.profile_ = 10;
                this.pin_ = "";
                this.deviceDescription_ = Connect_request.emptyIntList();
                this.deviceVersion_ = Connect_request.emptyIntList();
                this.applicationDescription_ = Connect_request.emptyIntList();
                this.applicationVersion_ = Connect_request.emptyIntList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.profile_ = 10;
                this.pin_ = "";
                this.deviceDescription_ = Connect_request.emptyIntList();
                this.deviceVersion_ = Connect_request.emptyIntList();
                this.applicationDescription_ = Connect_request.emptyIntList();
                this.applicationVersion_ = Connect_request.emptyIntList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Connect_request.alwaysUseFieldBuilders) {
                    getExternalUnitFeaturesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.profile_ = 10;
                this.pin_ = "";
                this.deviceDescription_ = Connect_request.emptyIntList();
                this.deviceVersion_ = Connect_request.emptyIntList();
                this.applicationDescription_ = Connect_request.emptyIntList();
                this.applicationVersion_ = Connect_request.emptyIntList();
                this.externalUnitFeatures_ = null;
                SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> singleFieldBuilderV3 = this.externalUnitFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.externalUnitFeaturesBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Connect_request getDefaultInstanceForType() {
                return Connect_request.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Connect_request build() {
                Connect_request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Connect_request buildPartial() {
                Connect_request connect_request = new Connect_request(this);
                buildPartialRepeatedFields(connect_request);
                if (this.bitField0_ != 0) {
                    buildPartial0(connect_request);
                }
                onBuilt();
                return connect_request;
            }

            private void buildPartialRepeatedFields(Connect_request connect_request) {
                if ((this.bitField0_ & 4) != 0) {
                    this.deviceDescription_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                connect_request.deviceDescription_ = this.deviceDescription_;
                if ((this.bitField0_ & 8) != 0) {
                    this.deviceVersion_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                connect_request.deviceVersion_ = this.deviceVersion_;
                if ((this.bitField0_ & 16) != 0) {
                    this.applicationDescription_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                connect_request.applicationDescription_ = this.applicationDescription_;
                if ((this.bitField0_ & 32) != 0) {
                    this.applicationVersion_.makeImmutable();
                    this.bitField0_ &= -33;
                }
                connect_request.applicationVersion_ = this.applicationVersion_;
            }

            private void buildPartial0(Connect_request connect_request) {
                int i;
                External_unit_features build;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    connect_request.profile_ = this.profile_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    connect_request.pin_ = this.pin_;
                    i |= 2;
                }
                if ((i2 & 64) != 0) {
                    SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> singleFieldBuilderV3 = this.externalUnitFeaturesBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        build = this.externalUnitFeatures_;
                    } else {
                        build = singleFieldBuilderV3.build();
                    }
                    connect_request.externalUnitFeatures_ = build;
                    i |= 4;
                }
                Connect_request.access$5876(connect_request, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Connect_request) {
                    return mergeFrom((Connect_request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Connect_request connect_request) {
                if (connect_request == Connect_request.getDefaultInstance()) {
                    return this;
                }
                if (connect_request.hasProfile()) {
                    setProfile(connect_request.getProfile());
                }
                if (connect_request.hasPin()) {
                    this.pin_ = connect_request.pin_;
                    this.bitField0_ |= 2;
                    onChanged();
                }
                if (!connect_request.deviceDescription_.isEmpty()) {
                    if (this.deviceDescription_.isEmpty()) {
                        this.deviceDescription_ = connect_request.deviceDescription_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureDeviceDescriptionIsMutable();
                        this.deviceDescription_.addAll(connect_request.deviceDescription_);
                    }
                    onChanged();
                }
                if (!connect_request.deviceVersion_.isEmpty()) {
                    if (this.deviceVersion_.isEmpty()) {
                        this.deviceVersion_ = connect_request.deviceVersion_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureDeviceVersionIsMutable();
                        this.deviceVersion_.addAll(connect_request.deviceVersion_);
                    }
                    onChanged();
                }
                if (!connect_request.applicationDescription_.isEmpty()) {
                    if (this.applicationDescription_.isEmpty()) {
                        this.applicationDescription_ = connect_request.applicationDescription_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureApplicationDescriptionIsMutable();
                        this.applicationDescription_.addAll(connect_request.applicationDescription_);
                    }
                    onChanged();
                }
                if (!connect_request.applicationVersion_.isEmpty()) {
                    if (this.applicationVersion_.isEmpty()) {
                        this.applicationVersion_ = connect_request.applicationVersion_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureApplicationVersionIsMutable();
                        this.applicationVersion_.addAll(connect_request.applicationVersion_);
                    }
                    onChanged();
                }
                if (connect_request.hasExternalUnitFeatures()) {
                    mergeExternalUnitFeatures(connect_request.getExternalUnitFeatures());
                }
                mergeUnknownFields(connect_request.getUnknownFields());
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
                                    int readEnum = codedInputStream.readEnum();
                                    if (Connection_types.profile_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(1, readEnum);
                                    } else {
                                        this.profile_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                case 18:
                                    this.pin_ = codedInputStream.readBytes();
                                    this.bitField0_ |= 2;
                                case 24:
                                    int readUInt32 = codedInputStream.readUInt32();
                                    ensureDeviceDescriptionIsMutable();
                                    this.deviceDescription_.addInt(readUInt32);
                                case 26:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureDeviceDescriptionIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.deviceDescription_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                case 32:
                                    int readUInt322 = codedInputStream.readUInt32();
                                    ensureDeviceVersionIsMutable();
                                    this.deviceVersion_.addInt(readUInt322);
                                case 34:
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureDeviceVersionIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.deviceVersion_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                case 40:
                                    int readUInt323 = codedInputStream.readUInt32();
                                    ensureApplicationDescriptionIsMutable();
                                    this.applicationDescription_.addInt(readUInt323);
                                case 42:
                                    int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureApplicationDescriptionIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.applicationDescription_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit3);
                                case 48:
                                    int readUInt324 = codedInputStream.readUInt32();
                                    ensureApplicationVersionIsMutable();
                                    this.applicationVersion_.addInt(readUInt324);
                                case 50:
                                    int pushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureApplicationVersionIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.applicationVersion_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit4);
                                case 58:
                                    codedInputStream.readMessage(getExternalUnitFeaturesFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 64;
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

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public boolean hasProfile() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public Connection_types.profile_t getProfile() {
                Connection_types.profile_t forNumber = Connection_types.profile_t.forNumber(this.profile_);
                return forNumber == null ? Connection_types.profile_t.PROFILE_PC_PANEL : forNumber;
            }

            public Builder setProfile(Connection_types.profile_t profile_tVar) {
                profile_tVar.getClass();
                this.bitField0_ |= 1;
                this.profile_ = profile_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearProfile() {
                this.bitField0_ &= -2;
                this.profile_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public boolean hasPin() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public String getPin() {
                Object obj = this.pin_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.pin_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public ByteString getPinBytes() {
                Object obj = this.pin_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.pin_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setPin(String str) {
                str.getClass();
                this.pin_ = str;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearPin() {
                this.pin_ = Connect_request.getDefaultInstance().getPin();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder setPinBytes(ByteString byteString) {
                byteString.getClass();
                this.pin_ = byteString;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            private void ensureDeviceDescriptionIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.deviceDescription_ = Connect_request.mutableCopy(this.deviceDescription_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public List<Integer> getDeviceDescriptionList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.deviceDescription_) : this.deviceDescription_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public int getDeviceDescriptionCount() {
                return this.deviceDescription_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public int getDeviceDescription(int i) {
                return this.deviceDescription_.getInt(i);
            }

            public Builder setDeviceDescription(int i, int i2) {
                ensureDeviceDescriptionIsMutable();
                this.deviceDescription_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addDeviceDescription(int i) {
                ensureDeviceDescriptionIsMutable();
                this.deviceDescription_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllDeviceDescription(Iterable<? extends Integer> iterable) {
                ensureDeviceDescriptionIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.deviceDescription_);
                onChanged();
                return this;
            }

            public Builder clearDeviceDescription() {
                this.deviceDescription_ = Connect_request.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureDeviceVersionIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.deviceVersion_ = Connect_request.mutableCopy(this.deviceVersion_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public List<Integer> getDeviceVersionList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.deviceVersion_) : this.deviceVersion_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public int getDeviceVersionCount() {
                return this.deviceVersion_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public int getDeviceVersion(int i) {
                return this.deviceVersion_.getInt(i);
            }

            public Builder setDeviceVersion(int i, int i2) {
                ensureDeviceVersionIsMutable();
                this.deviceVersion_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addDeviceVersion(int i) {
                ensureDeviceVersionIsMutable();
                this.deviceVersion_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllDeviceVersion(Iterable<? extends Integer> iterable) {
                ensureDeviceVersionIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.deviceVersion_);
                onChanged();
                return this;
            }

            public Builder clearDeviceVersion() {
                this.deviceVersion_ = Connect_request.emptyIntList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            private void ensureApplicationDescriptionIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.applicationDescription_ = Connect_request.mutableCopy(this.applicationDescription_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public List<Integer> getApplicationDescriptionList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.applicationDescription_) : this.applicationDescription_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public int getApplicationDescriptionCount() {
                return this.applicationDescription_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public int getApplicationDescription(int i) {
                return this.applicationDescription_.getInt(i);
            }

            public Builder setApplicationDescription(int i, int i2) {
                ensureApplicationDescriptionIsMutable();
                this.applicationDescription_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addApplicationDescription(int i) {
                ensureApplicationDescriptionIsMutable();
                this.applicationDescription_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllApplicationDescription(Iterable<? extends Integer> iterable) {
                ensureApplicationDescriptionIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.applicationDescription_);
                onChanged();
                return this;
            }

            public Builder clearApplicationDescription() {
                this.applicationDescription_ = Connect_request.emptyIntList();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            private void ensureApplicationVersionIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.applicationVersion_ = Connect_request.mutableCopy(this.applicationVersion_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public List<Integer> getApplicationVersionList() {
                return (this.bitField0_ & 32) != 0 ? Collections.unmodifiableList(this.applicationVersion_) : this.applicationVersion_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public int getApplicationVersionCount() {
                return this.applicationVersion_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public int getApplicationVersion(int i) {
                return this.applicationVersion_.getInt(i);
            }

            public Builder setApplicationVersion(int i, int i2) {
                ensureApplicationVersionIsMutable();
                this.applicationVersion_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addApplicationVersion(int i) {
                ensureApplicationVersionIsMutable();
                this.applicationVersion_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllApplicationVersion(Iterable<? extends Integer> iterable) {
                ensureApplicationVersionIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.applicationVersion_);
                onChanged();
                return this;
            }

            public Builder clearApplicationVersion() {
                this.applicationVersion_ = Connect_request.emptyIntList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public boolean hasExternalUnitFeatures() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public External_unit_features getExternalUnitFeatures() {
                SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> singleFieldBuilderV3 = this.externalUnitFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    External_unit_features external_unit_features = this.externalUnitFeatures_;
                    return external_unit_features == null ? External_unit_features.getDefaultInstance() : external_unit_features;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setExternalUnitFeatures(External_unit_features external_unit_features) {
                SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> singleFieldBuilderV3 = this.externalUnitFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    external_unit_features.getClass();
                    this.externalUnitFeatures_ = external_unit_features;
                } else {
                    singleFieldBuilderV3.setMessage(external_unit_features);
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setExternalUnitFeatures(External_unit_features.Builder builder) {
                SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> singleFieldBuilderV3 = this.externalUnitFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.externalUnitFeatures_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder mergeExternalUnitFeatures(External_unit_features external_unit_features) {
                External_unit_features external_unit_features2;
                SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> singleFieldBuilderV3 = this.externalUnitFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 64) != 0 && (external_unit_features2 = this.externalUnitFeatures_) != null && external_unit_features2 != External_unit_features.getDefaultInstance()) {
                        getExternalUnitFeaturesBuilder().mergeFrom(external_unit_features);
                    } else {
                        this.externalUnitFeatures_ = external_unit_features;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(external_unit_features);
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder clearExternalUnitFeatures() {
                this.bitField0_ &= -65;
                this.externalUnitFeatures_ = null;
                SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> singleFieldBuilderV3 = this.externalUnitFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.externalUnitFeaturesBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public External_unit_features.Builder getExternalUnitFeaturesBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return getExternalUnitFeaturesFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_requestOrBuilder
            public External_unit_featuresOrBuilder getExternalUnitFeaturesOrBuilder() {
                SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> singleFieldBuilderV3 = this.externalUnitFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                External_unit_features external_unit_features = this.externalUnitFeatures_;
                return external_unit_features == null ? External_unit_features.getDefaultInstance() : external_unit_features;
            }

            private SingleFieldBuilderV3<External_unit_features, External_unit_features.Builder, External_unit_featuresOrBuilder> getExternalUnitFeaturesFieldBuilder() {
                if (this.externalUnitFeaturesBuilder_ == null) {
                    this.externalUnitFeaturesBuilder_ = new SingleFieldBuilderV3<>(getExternalUnitFeatures(), getParentForChildren(), isClean());
                    this.externalUnitFeatures_ = null;
                }
                return this.externalUnitFeaturesBuilder_;
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

        public static Connect_request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Connect_request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Connect_request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Connect_request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Connect_reply extends GeneratedMessageV3 implements Connect_replyOrBuilder {
        public static final int APPLICATION_DESCRIPTION_FIELD_NUMBER = 9;
        public static final int APPLICATION_VERSION_FIELD_NUMBER = 10;
        public static final int BRAND_FIELD_NUMBER = 3;
        public static final int COMMUNICATION_LOST_TIME_OUT_FIELD_NUMBER = 5;
        public static final int COMMUNICATION_TIME_OUT_FIELD_NUMBER = 4;
        private static final Connect_reply DEFAULT_INSTANCE = new Connect_reply();

        @Deprecated
        public static final Parser<Connect_reply> PARSER = new AbstractParser<Connect_reply>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Connect_reply.1
            @Override // com.google.protobuf.Parser
            public Connect_reply parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Connect_reply.newBuilder();
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
        public static final int RCB_PRODUCT_FIELD_NUMBER = 6;
        public static final int SAUNA_FEATURES_FIELD_NUMBER = 8;
        public static final int STATUS_FIELD_NUMBER = 1;
        public static final int SYSTEM_ID_FIELD_NUMBER = 2;
        public static final int SYSTEM_NAME_FIELD_NUMBER = 7;
        public static final int SYSTEM_TYPE_FIELD_NUMBER = 11;
        private static final long serialVersionUID = 0;
        private Internal.IntList applicationDescription_;
        private Internal.IntList applicationVersion_;
        private int bitField0_;
        private int brand_;
        private int communicationLostTimeOut_;
        private int communicationTimeOut_;
        private byte memoizedIsInitialized;
        private int rcbProduct_;
        private Sauna_features saunaFeatures_;
        private int status_;
        private volatile Object systemId_;
        private Internal.IntList systemName_;
        private int systemType_;

        static /* synthetic */ int access$9176(Connect_reply connect_reply, int i) {
            int i2 = i | connect_reply.bitField0_;
            connect_reply.bitField0_ = i2;
            return i2;
        }

        private Connect_reply(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.status_ = 10;
            this.systemId_ = "";
            this.brand_ = 40;
            this.communicationTimeOut_ = 0;
            this.communicationLostTimeOut_ = 0;
            this.rcbProduct_ = 30;
            this.systemType_ = 20;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Connect_reply() {
            this.status_ = 10;
            this.systemId_ = "";
            this.brand_ = 40;
            this.communicationTimeOut_ = 0;
            this.communicationLostTimeOut_ = 0;
            this.rcbProduct_ = 30;
            this.systemType_ = 20;
            this.memoizedIsInitialized = (byte) -1;
            this.status_ = 10;
            this.systemId_ = "";
            this.brand_ = 40;
            this.rcbProduct_ = 30;
            this.systemName_ = emptyIntList();
            this.applicationDescription_ = emptyIntList();
            this.applicationVersion_ = emptyIntList();
            this.systemType_ = 20;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Connect_reply();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_fieldAccessorTable.ensureFieldAccessorsInitialized(Connect_reply.class, Builder.class);
        }

        public enum connect_status_t implements ProtocolMessageEnum {
            CONNECT_ACCEPTED(10),
            CONNECT_REJECTED_PIN(20),
            CONNECT_REJECTED_COMPATIBILITY(21),
            CONNECT_REJECTED(22),
            CONNECT_REJECTED_DOORSWITCH(23);

            public static final int CONNECT_ACCEPTED_VALUE = 10;
            public static final int CONNECT_REJECTED_COMPATIBILITY_VALUE = 21;
            public static final int CONNECT_REJECTED_DOORSWITCH_VALUE = 23;
            public static final int CONNECT_REJECTED_PIN_VALUE = 20;
            public static final int CONNECT_REJECTED_VALUE = 22;
            private final int value;
            private static final Internal.EnumLiteMap<connect_status_t> internalValueMap = new Internal.EnumLiteMap<connect_status_t>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Connect_reply.connect_status_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public connect_status_t findValueByNumber(int i) {
                    return connect_status_t.forNumber(i);
                }
            };
            private static final connect_status_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static connect_status_t valueOf(int i) {
                return forNumber(i);
            }

            public static connect_status_t forNumber(int i) {
                if (i == 10) {
                    return CONNECT_ACCEPTED;
                }
                switch (i) {
                    case 20:
                        return CONNECT_REJECTED_PIN;
                    case 21:
                        return CONNECT_REJECTED_COMPATIBILITY;
                    case 22:
                        return CONNECT_REJECTED;
                    case 23:
                        return CONNECT_REJECTED_DOORSWITCH;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<connect_status_t> internalGetValueMap() {
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
                return Connect_reply.getDescriptor().getEnumTypes().get(0);
            }

            public static connect_status_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            connect_status_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public boolean hasStatus() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public connect_status_t getStatus() {
            connect_status_t forNumber = connect_status_t.forNumber(this.status_);
            return forNumber == null ? connect_status_t.CONNECT_ACCEPTED : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public boolean hasSystemId() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public String getSystemId() {
            Object obj = this.systemId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.systemId_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public ByteString getSystemIdBytes() {
            Object obj = this.systemId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.systemId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public boolean hasBrand() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public Connection_types.brand_t getBrand() {
            Connection_types.brand_t forNumber = Connection_types.brand_t.forNumber(this.brand_);
            return forNumber == null ? Connection_types.brand_t.BRAND_TYLO : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public boolean hasCommunicationTimeOut() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public int getCommunicationTimeOut() {
            return this.communicationTimeOut_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public boolean hasCommunicationLostTimeOut() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public int getCommunicationLostTimeOut() {
            return this.communicationLostTimeOut_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public boolean hasRcbProduct() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public Connection_types.rcb_product_t getRcbProduct() {
            Connection_types.rcb_product_t forNumber = Connection_types.rcb_product_t.forNumber(this.rcbProduct_);
            return forNumber == null ? Connection_types.rcb_product_t.RCB_COMBI_MANUAL : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public List<Integer> getSystemNameList() {
            return this.systemName_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public int getSystemNameCount() {
            return this.systemName_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public int getSystemName(int i) {
            return this.systemName_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public boolean hasSaunaFeatures() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public Sauna_features getSaunaFeatures() {
            Sauna_features sauna_features = this.saunaFeatures_;
            return sauna_features == null ? Sauna_features.getDefaultInstance() : sauna_features;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public Sauna_featuresOrBuilder getSaunaFeaturesOrBuilder() {
            Sauna_features sauna_features = this.saunaFeatures_;
            return sauna_features == null ? Sauna_features.getDefaultInstance() : sauna_features;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public List<Integer> getApplicationDescriptionList() {
            return this.applicationDescription_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public int getApplicationDescriptionCount() {
            return this.applicationDescription_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public int getApplicationDescription(int i) {
            return this.applicationDescription_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public List<Integer> getApplicationVersionList() {
            return this.applicationVersion_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public int getApplicationVersionCount() {
            return this.applicationVersion_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public int getApplicationVersion(int i) {
            return this.applicationVersion_.getInt(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public boolean hasSystemType() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
        public Connection_types.system_type_t getSystemType() {
            Connection_types.system_type_t forNumber = Connection_types.system_type_t.forNumber(this.systemType_);
            return forNumber == null ? Connection_types.system_type_t.SYSTYP_STANDARD : forNumber;
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
                codedOutputStream.writeEnum(1, this.status_);
            }
            if ((this.bitField0_ & 2) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.systemId_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeEnum(3, this.brand_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeUInt32(4, this.communicationTimeOut_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeUInt32(5, this.communicationLostTimeOut_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.writeEnum(6, this.rcbProduct_);
            }
            for (int i = 0; i < this.systemName_.size(); i++) {
                codedOutputStream.writeUInt32(7, this.systemName_.getInt(i));
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputStream.writeMessage(8, getSaunaFeatures());
            }
            for (int i2 = 0; i2 < this.applicationDescription_.size(); i2++) {
                codedOutputStream.writeUInt32(9, this.applicationDescription_.getInt(i2));
            }
            for (int i3 = 0; i3 < this.applicationVersion_.size(); i3++) {
                codedOutputStream.writeUInt32(10, this.applicationVersion_.getInt(i3));
            }
            if ((this.bitField0_ & 128) != 0) {
                codedOutputStream.writeEnum(11, this.systemType_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(1, this.status_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.systemId_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(3, this.brand_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeEnumSize += CodedOutputStream.computeUInt32Size(4, this.communicationTimeOut_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeEnumSize += CodedOutputStream.computeUInt32Size(5, this.communicationLostTimeOut_);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(6, this.rcbProduct_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.systemName_.size(); i3++) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(this.systemName_.getInt(i3));
            }
            int size = computeEnumSize + i2 + getSystemNameList().size();
            if ((this.bitField0_ & 64) != 0) {
                size += CodedOutputStream.computeMessageSize(8, getSaunaFeatures());
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.applicationDescription_.size(); i5++) {
                i4 += CodedOutputStream.computeUInt32SizeNoTag(this.applicationDescription_.getInt(i5));
            }
            int size2 = size + i4 + getApplicationDescriptionList().size();
            int i6 = 0;
            for (int i7 = 0; i7 < this.applicationVersion_.size(); i7++) {
                i6 += CodedOutputStream.computeUInt32SizeNoTag(this.applicationVersion_.getInt(i7));
            }
            int size3 = size2 + i6 + getApplicationVersionList().size();
            if ((this.bitField0_ & 128) != 0) {
                size3 += CodedOutputStream.computeEnumSize(11, this.systemType_);
            }
            int serializedSize = size3 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Connect_reply)) {
                return super.equals(obj);
            }
            Connect_reply connect_reply = (Connect_reply) obj;
            if (hasStatus() != connect_reply.hasStatus()) {
                return false;
            }
            if ((hasStatus() && this.status_ != connect_reply.status_) || hasSystemId() != connect_reply.hasSystemId()) {
                return false;
            }
            if ((hasSystemId() && !getSystemId().equals(connect_reply.getSystemId())) || hasBrand() != connect_reply.hasBrand()) {
                return false;
            }
            if ((hasBrand() && this.brand_ != connect_reply.brand_) || hasCommunicationTimeOut() != connect_reply.hasCommunicationTimeOut()) {
                return false;
            }
            if ((hasCommunicationTimeOut() && getCommunicationTimeOut() != connect_reply.getCommunicationTimeOut()) || hasCommunicationLostTimeOut() != connect_reply.hasCommunicationLostTimeOut()) {
                return false;
            }
            if ((hasCommunicationLostTimeOut() && getCommunicationLostTimeOut() != connect_reply.getCommunicationLostTimeOut()) || hasRcbProduct() != connect_reply.hasRcbProduct()) {
                return false;
            }
            if ((hasRcbProduct() && this.rcbProduct_ != connect_reply.rcbProduct_) || !getSystemNameList().equals(connect_reply.getSystemNameList()) || hasSaunaFeatures() != connect_reply.hasSaunaFeatures()) {
                return false;
            }
            if ((!hasSaunaFeatures() || getSaunaFeatures().equals(connect_reply.getSaunaFeatures())) && getApplicationDescriptionList().equals(connect_reply.getApplicationDescriptionList()) && getApplicationVersionList().equals(connect_reply.getApplicationVersionList()) && hasSystemType() == connect_reply.hasSystemType()) {
                return (!hasSystemType() || this.systemType_ == connect_reply.systemType_) && getUnknownFields().equals(connect_reply.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasStatus()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.status_;
            }
            if (hasSystemId()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getSystemId().hashCode();
            }
            if (hasBrand()) {
                hashCode = (((hashCode * 37) + 3) * 53) + this.brand_;
            }
            if (hasCommunicationTimeOut()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getCommunicationTimeOut();
            }
            if (hasCommunicationLostTimeOut()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getCommunicationLostTimeOut();
            }
            if (hasRcbProduct()) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.rcbProduct_;
            }
            if (getSystemNameCount() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + getSystemNameList().hashCode();
            }
            if (hasSaunaFeatures()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getSaunaFeatures().hashCode();
            }
            if (getApplicationDescriptionCount() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + getApplicationDescriptionList().hashCode();
            }
            if (getApplicationVersionCount() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + getApplicationVersionList().hashCode();
            }
            if (hasSystemType()) {
                hashCode = (((hashCode * 37) + 11) * 53) + this.systemType_;
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Connect_reply parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Connect_reply parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Connect_reply parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Connect_reply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Connect_reply parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Connect_reply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Connect_reply parseFrom(InputStream inputStream) throws IOException {
            return (Connect_reply) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Connect_reply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect_reply) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Connect_reply parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Connect_reply) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Connect_reply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect_reply) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Connect_reply parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Connect_reply) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Connect_reply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect_reply) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Connect_reply connect_reply) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(connect_reply);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Connect_replyOrBuilder {
            private Internal.IntList applicationDescription_;
            private Internal.IntList applicationVersion_;
            private int bitField0_;
            private int brand_;
            private int communicationLostTimeOut_;
            private int communicationTimeOut_;
            private int rcbProduct_;
            private SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> saunaFeaturesBuilder_;
            private Sauna_features saunaFeatures_;
            private int status_;
            private Object systemId_;
            private Internal.IntList systemName_;
            private int systemType_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_fieldAccessorTable.ensureFieldAccessorsInitialized(Connect_reply.class, Builder.class);
            }

            private Builder() {
                this.status_ = 10;
                this.systemId_ = "";
                this.brand_ = 40;
                this.rcbProduct_ = 30;
                this.systemName_ = Connect_reply.emptyIntList();
                this.applicationDescription_ = Connect_reply.emptyIntList();
                this.applicationVersion_ = Connect_reply.emptyIntList();
                this.systemType_ = 20;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.status_ = 10;
                this.systemId_ = "";
                this.brand_ = 40;
                this.rcbProduct_ = 30;
                this.systemName_ = Connect_reply.emptyIntList();
                this.applicationDescription_ = Connect_reply.emptyIntList();
                this.applicationVersion_ = Connect_reply.emptyIntList();
                this.systemType_ = 20;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Connect_reply.alwaysUseFieldBuilders) {
                    getSaunaFeaturesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.status_ = 10;
                this.systemId_ = "";
                this.brand_ = 40;
                this.communicationTimeOut_ = 0;
                this.communicationLostTimeOut_ = 0;
                this.rcbProduct_ = 30;
                this.systemName_ = Connect_reply.emptyIntList();
                this.saunaFeatures_ = null;
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.saunaFeaturesBuilder_ = null;
                }
                this.applicationDescription_ = Connect_reply.emptyIntList();
                this.applicationVersion_ = Connect_reply.emptyIntList();
                this.systemType_ = 20;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Connect_reply getDefaultInstanceForType() {
                return Connect_reply.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Connect_reply build() {
                Connect_reply buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Connect_reply buildPartial() {
                Connect_reply connect_reply = new Connect_reply(this);
                buildPartialRepeatedFields(connect_reply);
                if (this.bitField0_ != 0) {
                    buildPartial0(connect_reply);
                }
                onBuilt();
                return connect_reply;
            }

            private void buildPartialRepeatedFields(Connect_reply connect_reply) {
                if ((this.bitField0_ & 64) != 0) {
                    this.systemName_.makeImmutable();
                    this.bitField0_ &= -65;
                }
                connect_reply.systemName_ = this.systemName_;
                if ((this.bitField0_ & 256) != 0) {
                    this.applicationDescription_.makeImmutable();
                    this.bitField0_ &= -257;
                }
                connect_reply.applicationDescription_ = this.applicationDescription_;
                if ((this.bitField0_ & 512) != 0) {
                    this.applicationVersion_.makeImmutable();
                    this.bitField0_ &= -513;
                }
                connect_reply.applicationVersion_ = this.applicationVersion_;
            }

            private void buildPartial0(Connect_reply connect_reply) {
                int i;
                Sauna_features build;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    connect_reply.status_ = this.status_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    connect_reply.systemId_ = this.systemId_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    connect_reply.brand_ = this.brand_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    connect_reply.communicationTimeOut_ = this.communicationTimeOut_;
                    i |= 8;
                }
                if ((i2 & 16) != 0) {
                    connect_reply.communicationLostTimeOut_ = this.communicationLostTimeOut_;
                    i |= 16;
                }
                if ((i2 & 32) != 0) {
                    connect_reply.rcbProduct_ = this.rcbProduct_;
                    i |= 32;
                }
                if ((i2 & 128) != 0) {
                    SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        build = this.saunaFeatures_;
                    } else {
                        build = singleFieldBuilderV3.build();
                    }
                    connect_reply.saunaFeatures_ = build;
                    i |= 64;
                }
                if ((i2 & 1024) != 0) {
                    connect_reply.systemType_ = this.systemType_;
                    i |= 128;
                }
                Connect_reply.access$9176(connect_reply, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Connect_reply) {
                    return mergeFrom((Connect_reply) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Connect_reply connect_reply) {
                if (connect_reply == Connect_reply.getDefaultInstance()) {
                    return this;
                }
                if (connect_reply.hasStatus()) {
                    setStatus(connect_reply.getStatus());
                }
                if (connect_reply.hasSystemId()) {
                    this.systemId_ = connect_reply.systemId_;
                    this.bitField0_ |= 2;
                    onChanged();
                }
                if (connect_reply.hasBrand()) {
                    setBrand(connect_reply.getBrand());
                }
                if (connect_reply.hasCommunicationTimeOut()) {
                    setCommunicationTimeOut(connect_reply.getCommunicationTimeOut());
                }
                if (connect_reply.hasCommunicationLostTimeOut()) {
                    setCommunicationLostTimeOut(connect_reply.getCommunicationLostTimeOut());
                }
                if (connect_reply.hasRcbProduct()) {
                    setRcbProduct(connect_reply.getRcbProduct());
                }
                if (!connect_reply.systemName_.isEmpty()) {
                    if (this.systemName_.isEmpty()) {
                        this.systemName_ = connect_reply.systemName_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureSystemNameIsMutable();
                        this.systemName_.addAll(connect_reply.systemName_);
                    }
                    onChanged();
                }
                if (connect_reply.hasSaunaFeatures()) {
                    mergeSaunaFeatures(connect_reply.getSaunaFeatures());
                }
                if (!connect_reply.applicationDescription_.isEmpty()) {
                    if (this.applicationDescription_.isEmpty()) {
                        this.applicationDescription_ = connect_reply.applicationDescription_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureApplicationDescriptionIsMutable();
                        this.applicationDescription_.addAll(connect_reply.applicationDescription_);
                    }
                    onChanged();
                }
                if (!connect_reply.applicationVersion_.isEmpty()) {
                    if (this.applicationVersion_.isEmpty()) {
                        this.applicationVersion_ = connect_reply.applicationVersion_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureApplicationVersionIsMutable();
                        this.applicationVersion_.addAll(connect_reply.applicationVersion_);
                    }
                    onChanged();
                }
                if (connect_reply.hasSystemType()) {
                    setSystemType(connect_reply.getSystemType());
                }
                mergeUnknownFields(connect_reply.getUnknownFields());
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
                                    int readEnum = codedInputStream.readEnum();
                                    if (connect_status_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(1, readEnum);
                                    } else {
                                        this.status_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                case 18:
                                    this.systemId_ = codedInputStream.readBytes();
                                    this.bitField0_ |= 2;
                                case 24:
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (Connection_types.brand_t.forNumber(readEnum2) == null) {
                                        mergeUnknownVarintField(3, readEnum2);
                                    } else {
                                        this.brand_ = readEnum2;
                                        this.bitField0_ |= 4;
                                    }
                                case 32:
                                    this.communicationTimeOut_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 8;
                                case 40:
                                    this.communicationLostTimeOut_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 16;
                                case 48:
                                    int readEnum3 = codedInputStream.readEnum();
                                    if (Connection_types.rcb_product_t.forNumber(readEnum3) == null) {
                                        mergeUnknownVarintField(6, readEnum3);
                                    } else {
                                        this.rcbProduct_ = readEnum3;
                                        this.bitField0_ |= 32;
                                    }
                                case 56:
                                    int readUInt32 = codedInputStream.readUInt32();
                                    ensureSystemNameIsMutable();
                                    this.systemName_.addInt(readUInt32);
                                case 58:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureSystemNameIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.systemName_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                case 66:
                                    codedInputStream.readMessage(getSaunaFeaturesFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 128;
                                case 72:
                                    int readUInt322 = codedInputStream.readUInt32();
                                    ensureApplicationDescriptionIsMutable();
                                    this.applicationDescription_.addInt(readUInt322);
                                case 74:
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureApplicationDescriptionIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.applicationDescription_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                case 80:
                                    int readUInt323 = codedInputStream.readUInt32();
                                    ensureApplicationVersionIsMutable();
                                    this.applicationVersion_.addInt(readUInt323);
                                case 82:
                                    int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureApplicationVersionIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.applicationVersion_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit3);
                                case 88:
                                    int readEnum4 = codedInputStream.readEnum();
                                    if (Connection_types.system_type_t.forNumber(readEnum4) == null) {
                                        mergeUnknownVarintField(11, readEnum4);
                                    } else {
                                        this.systemType_ = readEnum4;
                                        this.bitField0_ |= 1024;
                                    }
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

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public boolean hasStatus() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public connect_status_t getStatus() {
                connect_status_t forNumber = connect_status_t.forNumber(this.status_);
                return forNumber == null ? connect_status_t.CONNECT_ACCEPTED : forNumber;
            }

            public Builder setStatus(connect_status_t connect_status_tVar) {
                connect_status_tVar.getClass();
                this.bitField0_ |= 1;
                this.status_ = connect_status_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.bitField0_ &= -2;
                this.status_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public boolean hasSystemId() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public String getSystemId() {
                Object obj = this.systemId_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.systemId_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public ByteString getSystemIdBytes() {
                Object obj = this.systemId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.systemId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setSystemId(String str) {
                str.getClass();
                this.systemId_ = str;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearSystemId() {
                this.systemId_ = Connect_reply.getDefaultInstance().getSystemId();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder setSystemIdBytes(ByteString byteString) {
                byteString.getClass();
                this.systemId_ = byteString;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public boolean hasBrand() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public Connection_types.brand_t getBrand() {
                Connection_types.brand_t forNumber = Connection_types.brand_t.forNumber(this.brand_);
                return forNumber == null ? Connection_types.brand_t.BRAND_TYLO : forNumber;
            }

            public Builder setBrand(Connection_types.brand_t brand_tVar) {
                brand_tVar.getClass();
                this.bitField0_ |= 4;
                this.brand_ = brand_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearBrand() {
                this.bitField0_ &= -5;
                this.brand_ = 40;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public boolean hasCommunicationTimeOut() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public int getCommunicationTimeOut() {
                return this.communicationTimeOut_;
            }

            public Builder setCommunicationTimeOut(int i) {
                this.communicationTimeOut_ = i;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearCommunicationTimeOut() {
                this.bitField0_ &= -9;
                this.communicationTimeOut_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public boolean hasCommunicationLostTimeOut() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public int getCommunicationLostTimeOut() {
                return this.communicationLostTimeOut_;
            }

            public Builder setCommunicationLostTimeOut(int i) {
                this.communicationLostTimeOut_ = i;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder clearCommunicationLostTimeOut() {
                this.bitField0_ &= -17;
                this.communicationLostTimeOut_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public boolean hasRcbProduct() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public Connection_types.rcb_product_t getRcbProduct() {
                Connection_types.rcb_product_t forNumber = Connection_types.rcb_product_t.forNumber(this.rcbProduct_);
                return forNumber == null ? Connection_types.rcb_product_t.RCB_COMBI_MANUAL : forNumber;
            }

            public Builder setRcbProduct(Connection_types.rcb_product_t rcb_product_tVar) {
                rcb_product_tVar.getClass();
                this.bitField0_ |= 32;
                this.rcbProduct_ = rcb_product_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearRcbProduct() {
                this.bitField0_ &= -33;
                this.rcbProduct_ = 30;
                onChanged();
                return this;
            }

            private void ensureSystemNameIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.systemName_ = Connect_reply.mutableCopy(this.systemName_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public List<Integer> getSystemNameList() {
                return (this.bitField0_ & 64) != 0 ? Collections.unmodifiableList(this.systemName_) : this.systemName_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public int getSystemNameCount() {
                return this.systemName_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public int getSystemName(int i) {
                return this.systemName_.getInt(i);
            }

            public Builder setSystemName(int i, int i2) {
                ensureSystemNameIsMutable();
                this.systemName_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addSystemName(int i) {
                ensureSystemNameIsMutable();
                this.systemName_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllSystemName(Iterable<? extends Integer> iterable) {
                ensureSystemNameIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.systemName_);
                onChanged();
                return this;
            }

            public Builder clearSystemName() {
                this.systemName_ = Connect_reply.emptyIntList();
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public boolean hasSaunaFeatures() {
                return (this.bitField0_ & 128) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public Sauna_features getSaunaFeatures() {
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Sauna_features sauna_features = this.saunaFeatures_;
                    return sauna_features == null ? Sauna_features.getDefaultInstance() : sauna_features;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSaunaFeatures(Sauna_features sauna_features) {
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sauna_features.getClass();
                    this.saunaFeatures_ = sauna_features;
                } else {
                    singleFieldBuilderV3.setMessage(sauna_features);
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setSaunaFeatures(Sauna_features.Builder builder) {
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.saunaFeatures_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder mergeSaunaFeatures(Sauna_features sauna_features) {
                Sauna_features sauna_features2;
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 128) != 0 && (sauna_features2 = this.saunaFeatures_) != null && sauna_features2 != Sauna_features.getDefaultInstance()) {
                        getSaunaFeaturesBuilder().mergeFrom(sauna_features);
                    } else {
                        this.saunaFeatures_ = sauna_features;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(sauna_features);
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder clearSaunaFeatures() {
                this.bitField0_ &= -129;
                this.saunaFeatures_ = null;
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.saunaFeaturesBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Sauna_features.Builder getSaunaFeaturesBuilder() {
                this.bitField0_ |= 128;
                onChanged();
                return getSaunaFeaturesFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public Sauna_featuresOrBuilder getSaunaFeaturesOrBuilder() {
                SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> singleFieldBuilderV3 = this.saunaFeaturesBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Sauna_features sauna_features = this.saunaFeatures_;
                return sauna_features == null ? Sauna_features.getDefaultInstance() : sauna_features;
            }

            private SingleFieldBuilderV3<Sauna_features, Sauna_features.Builder, Sauna_featuresOrBuilder> getSaunaFeaturesFieldBuilder() {
                if (this.saunaFeaturesBuilder_ == null) {
                    this.saunaFeaturesBuilder_ = new SingleFieldBuilderV3<>(getSaunaFeatures(), getParentForChildren(), isClean());
                    this.saunaFeatures_ = null;
                }
                return this.saunaFeaturesBuilder_;
            }

            private void ensureApplicationDescriptionIsMutable() {
                if ((this.bitField0_ & 256) == 0) {
                    this.applicationDescription_ = Connect_reply.mutableCopy(this.applicationDescription_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public List<Integer> getApplicationDescriptionList() {
                return (this.bitField0_ & 256) != 0 ? Collections.unmodifiableList(this.applicationDescription_) : this.applicationDescription_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public int getApplicationDescriptionCount() {
                return this.applicationDescription_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public int getApplicationDescription(int i) {
                return this.applicationDescription_.getInt(i);
            }

            public Builder setApplicationDescription(int i, int i2) {
                ensureApplicationDescriptionIsMutable();
                this.applicationDescription_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addApplicationDescription(int i) {
                ensureApplicationDescriptionIsMutable();
                this.applicationDescription_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllApplicationDescription(Iterable<? extends Integer> iterable) {
                ensureApplicationDescriptionIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.applicationDescription_);
                onChanged();
                return this;
            }

            public Builder clearApplicationDescription() {
                this.applicationDescription_ = Connect_reply.emptyIntList();
                this.bitField0_ &= -257;
                onChanged();
                return this;
            }

            private void ensureApplicationVersionIsMutable() {
                if ((this.bitField0_ & 512) == 0) {
                    this.applicationVersion_ = Connect_reply.mutableCopy(this.applicationVersion_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public List<Integer> getApplicationVersionList() {
                return (this.bitField0_ & 512) != 0 ? Collections.unmodifiableList(this.applicationVersion_) : this.applicationVersion_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public int getApplicationVersionCount() {
                return this.applicationVersion_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public int getApplicationVersion(int i) {
                return this.applicationVersion_.getInt(i);
            }

            public Builder setApplicationVersion(int i, int i2) {
                ensureApplicationVersionIsMutable();
                this.applicationVersion_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addApplicationVersion(int i) {
                ensureApplicationVersionIsMutable();
                this.applicationVersion_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllApplicationVersion(Iterable<? extends Integer> iterable) {
                ensureApplicationVersionIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.applicationVersion_);
                onChanged();
                return this;
            }

            public Builder clearApplicationVersion() {
                this.applicationVersion_ = Connect_reply.emptyIntList();
                this.bitField0_ &= -513;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public boolean hasSystemType() {
                return (this.bitField0_ & 1024) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Connect_replyOrBuilder
            public Connection_types.system_type_t getSystemType() {
                Connection_types.system_type_t forNumber = Connection_types.system_type_t.forNumber(this.systemType_);
                return forNumber == null ? Connection_types.system_type_t.SYSTYP_STANDARD : forNumber;
            }

            public Builder setSystemType(Connection_types.system_type_t system_type_tVar) {
                system_type_tVar.getClass();
                this.bitField0_ |= 1024;
                this.systemType_ = system_type_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearSystemType() {
                this.bitField0_ &= -1025;
                this.systemType_ = 20;
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

        public static Connect_reply getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Connect_reply> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Connect_reply> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Connect_reply getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class No_connection extends GeneratedMessageV3 implements No_connectionOrBuilder {
        private static final No_connection DEFAULT_INSTANCE = new No_connection();

        @Deprecated
        public static final Parser<No_connection> PARSER = new AbstractParser<No_connection>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.No_connection.1
            @Override // com.google.protobuf.Parser
            public No_connection parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = No_connection.newBuilder();
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

        private No_connection(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private No_connection() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new No_connection();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_No_connection_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_No_connection_fieldAccessorTable.ensureFieldAccessorsInitialized(No_connection.class, Builder.class);
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
            if (obj instanceof No_connection) {
                return getUnknownFields().equals(((No_connection) obj).getUnknownFields());
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

        public static No_connection parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static No_connection parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static No_connection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static No_connection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static No_connection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static No_connection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static No_connection parseFrom(InputStream inputStream) throws IOException {
            return (No_connection) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static No_connection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (No_connection) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static No_connection parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (No_connection) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static No_connection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (No_connection) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static No_connection parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (No_connection) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static No_connection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (No_connection) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(No_connection no_connection) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(no_connection);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements No_connectionOrBuilder {
            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_No_connection_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_No_connection_fieldAccessorTable.ensureFieldAccessorsInitialized(No_connection.class, Builder.class);
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
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_No_connection_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public No_connection getDefaultInstanceForType() {
                return No_connection.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public No_connection build() {
                No_connection buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public No_connection buildPartial() {
                No_connection no_connection = new No_connection(this);
                onBuilt();
                return no_connection;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof No_connection) {
                    return mergeFrom((No_connection) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(No_connection no_connection) {
                if (no_connection == No_connection.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(no_connection.getUnknownFields());
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

        public static No_connection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<No_connection> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<No_connection> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public No_connection getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Keep_alive extends GeneratedMessageV3 implements Keep_aliveOrBuilder {
        private static final Keep_alive DEFAULT_INSTANCE = new Keep_alive();

        @Deprecated
        public static final Parser<Keep_alive> PARSER = new AbstractParser<Keep_alive>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Keep_alive.1
            @Override // com.google.protobuf.Parser
            public Keep_alive parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Keep_alive.newBuilder();
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
        public static final int SEQUENCE_NUMBER_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int sequenceNumber_;

        static /* synthetic */ int access$11276(Keep_alive keep_alive, int i) {
            int i2 = i | keep_alive.bitField0_;
            keep_alive.bitField0_ = i2;
            return i2;
        }

        private Keep_alive(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.sequenceNumber_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Keep_alive() {
            this.sequenceNumber_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Keep_alive();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_fieldAccessorTable.ensureFieldAccessorsInitialized(Keep_alive.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Keep_aliveOrBuilder
        public boolean hasSequenceNumber() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Keep_aliveOrBuilder
        public int getSequenceNumber() {
            return this.sequenceNumber_;
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
                codedOutputStream.writeUInt32(1, this.sequenceNumber_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeUInt32Size = ((this.bitField0_ & 1) != 0 ? CodedOutputStream.computeUInt32Size(1, this.sequenceNumber_) : 0) + getUnknownFields().getSerializedSize();
            this.memoizedSize = computeUInt32Size;
            return computeUInt32Size;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Keep_alive)) {
                return super.equals(obj);
            }
            Keep_alive keep_alive = (Keep_alive) obj;
            if (hasSequenceNumber() != keep_alive.hasSequenceNumber()) {
                return false;
            }
            return (!hasSequenceNumber() || getSequenceNumber() == keep_alive.getSequenceNumber()) && getUnknownFields().equals(keep_alive.getUnknownFields());
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasSequenceNumber()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getSequenceNumber();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Keep_alive parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Keep_alive parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Keep_alive parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Keep_alive parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Keep_alive parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Keep_alive parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Keep_alive parseFrom(InputStream inputStream) throws IOException {
            return (Keep_alive) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Keep_alive parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Keep_alive) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Keep_alive parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Keep_alive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Keep_alive parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Keep_alive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Keep_alive parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Keep_alive) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Keep_alive parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Keep_alive) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Keep_alive keep_alive) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(keep_alive);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Keep_aliveOrBuilder {
            private int bitField0_;
            private int sequenceNumber_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_fieldAccessorTable.ensureFieldAccessorsInitialized(Keep_alive.class, Builder.class);
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
                this.sequenceNumber_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Keep_alive getDefaultInstanceForType() {
                return Keep_alive.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Keep_alive build() {
                Keep_alive buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Keep_alive buildPartial() {
                Keep_alive keep_alive = new Keep_alive(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(keep_alive);
                }
                onBuilt();
                return keep_alive;
            }

            private void buildPartial0(Keep_alive keep_alive) {
                int i = 1;
                if ((this.bitField0_ & 1) != 0) {
                    keep_alive.sequenceNumber_ = this.sequenceNumber_;
                } else {
                    i = 0;
                }
                Keep_alive.access$11276(keep_alive, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Keep_alive) {
                    return mergeFrom((Keep_alive) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Keep_alive keep_alive) {
                if (keep_alive == Keep_alive.getDefaultInstance()) {
                    return this;
                }
                if (keep_alive.hasSequenceNumber()) {
                    setSequenceNumber(keep_alive.getSequenceNumber());
                }
                mergeUnknownFields(keep_alive.getUnknownFields());
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
                                    this.sequenceNumber_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 1;
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

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Keep_aliveOrBuilder
            public boolean hasSequenceNumber() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Keep_aliveOrBuilder
            public int getSequenceNumber() {
                return this.sequenceNumber_;
            }

            public Builder setSequenceNumber(int i) {
                this.sequenceNumber_ = i;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearSequenceNumber() {
                this.bitField0_ &= -2;
                this.sequenceNumber_ = 0;
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

        public static Keep_alive getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Keep_alive> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Keep_alive> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Keep_alive getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Announcement_request extends GeneratedMessageV3 implements Announcement_requestOrBuilder {
        private static final Announcement_request DEFAULT_INSTANCE = new Announcement_request();

        @Deprecated
        public static final Parser<Announcement_request> PARSER = new AbstractParser<Announcement_request>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Announcement_request.1
            @Override // com.google.protobuf.Parser
            public Announcement_request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Announcement_request.newBuilder();
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
        public static final int PROFILE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int profile_;

        static /* synthetic */ int access$11976(Announcement_request announcement_request, int i) {
            int i2 = i | announcement_request.bitField0_;
            announcement_request.bitField0_ = i2;
            return i2;
        }

        private Announcement_request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.profile_ = 10;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Announcement_request() {
            this.memoizedIsInitialized = (byte) -1;
            this.profile_ = 10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Announcement_request();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Announcement_request.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Announcement_requestOrBuilder
        public boolean hasProfile() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Connect.Announcement_requestOrBuilder
        public Connection_types.profile_t getProfile() {
            Connection_types.profile_t forNumber = Connection_types.profile_t.forNumber(this.profile_);
            return forNumber == null ? Connection_types.profile_t.PROFILE_PC_PANEL : forNumber;
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
                codedOutputStream.writeEnum(1, this.profile_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = ((this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(1, this.profile_) : 0) + getUnknownFields().getSerializedSize();
            this.memoizedSize = computeEnumSize;
            return computeEnumSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Announcement_request)) {
                return super.equals(obj);
            }
            Announcement_request announcement_request = (Announcement_request) obj;
            if (hasProfile() != announcement_request.hasProfile()) {
                return false;
            }
            return (!hasProfile() || this.profile_ == announcement_request.profile_) && getUnknownFields().equals(announcement_request.getUnknownFields());
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasProfile()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.profile_;
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Announcement_request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Announcement_request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Announcement_request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Announcement_request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Announcement_request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Announcement_request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Announcement_request parseFrom(InputStream inputStream) throws IOException {
            return (Announcement_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Announcement_request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Announcement_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Announcement_request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Announcement_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Announcement_request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Announcement_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Announcement_request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Announcement_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Announcement_request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Announcement_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Announcement_request announcement_request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(announcement_request);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Announcement_requestOrBuilder {
            private int bitField0_;
            private int profile_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Announcement_request.class, Builder.class);
            }

            private Builder() {
                this.profile_ = 10;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.profile_ = 10;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.profile_ = 10;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Announcement_request getDefaultInstanceForType() {
                return Announcement_request.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Announcement_request build() {
                Announcement_request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Announcement_request buildPartial() {
                Announcement_request announcement_request = new Announcement_request(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(announcement_request);
                }
                onBuilt();
                return announcement_request;
            }

            private void buildPartial0(Announcement_request announcement_request) {
                int i = 1;
                if ((this.bitField0_ & 1) != 0) {
                    announcement_request.profile_ = this.profile_;
                } else {
                    i = 0;
                }
                Announcement_request.access$11976(announcement_request, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Announcement_request) {
                    return mergeFrom((Announcement_request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Announcement_request announcement_request) {
                if (announcement_request == Announcement_request.getDefaultInstance()) {
                    return this;
                }
                if (announcement_request.hasProfile()) {
                    setProfile(announcement_request.getProfile());
                }
                mergeUnknownFields(announcement_request.getUnknownFields());
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
                                    if (Connection_types.profile_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(1, readEnum);
                                    } else {
                                        this.profile_ = readEnum;
                                        this.bitField0_ |= 1;
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

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Announcement_requestOrBuilder
            public boolean hasProfile() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Connect.Announcement_requestOrBuilder
            public Connection_types.profile_t getProfile() {
                Connection_types.profile_t forNumber = Connection_types.profile_t.forNumber(this.profile_);
                return forNumber == null ? Connection_types.profile_t.PROFILE_PC_PANEL : forNumber;
            }

            public Builder setProfile(Connection_types.profile_t profile_tVar) {
                profile_tVar.getClass();
                this.bitField0_ |= 1;
                this.profile_ = profile_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearProfile() {
                this.bitField0_ &= -2;
                this.profile_ = 10;
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

        public static Announcement_request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Announcement_request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Announcement_request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Announcement_request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Disconnect_request extends GeneratedMessageV3 implements Disconnect_requestOrBuilder {
        private static final Disconnect_request DEFAULT_INSTANCE = new Disconnect_request();

        @Deprecated
        public static final Parser<Disconnect_request> PARSER = new AbstractParser<Disconnect_request>() { // from class: com.tylohelo.tylohelo.protobuf.Connect.Disconnect_request.1
            @Override // com.google.protobuf.Parser
            public Disconnect_request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Disconnect_request.newBuilder();
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

        private Disconnect_request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Disconnect_request() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Disconnect_request();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Disconnect_request.class, Builder.class);
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
            if (obj instanceof Disconnect_request) {
                return getUnknownFields().equals(((Disconnect_request) obj).getUnknownFields());
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

        public static Disconnect_request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Disconnect_request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Disconnect_request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Disconnect_request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Disconnect_request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Disconnect_request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Disconnect_request parseFrom(InputStream inputStream) throws IOException {
            return (Disconnect_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Disconnect_request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Disconnect_request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Disconnect_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Disconnect_request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Disconnect_request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Disconnect_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Disconnect_request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Disconnect_request disconnect_request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(disconnect_request);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Disconnect_requestOrBuilder {
            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Disconnect_request.class, Builder.class);
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
                return Connect.internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Disconnect_request getDefaultInstanceForType() {
                return Disconnect_request.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Disconnect_request build() {
                Disconnect_request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Disconnect_request buildPartial() {
                Disconnect_request disconnect_request = new Disconnect_request(this);
                onBuilt();
                return disconnect_request;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Disconnect_request) {
                    return mergeFrom((Disconnect_request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Disconnect_request disconnect_request) {
                if (disconnect_request == Disconnect_request.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(disconnect_request.getUnknownFields());
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

        public static Disconnect_request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Disconnect_request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Disconnect_request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Disconnect_request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_Connection_types_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[0]);
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_descriptor = descriptor3;
        internal_static_com_tylohelo_tylohelo_protobuf_Sauna_features_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"ClearTextLogin", "EncryptedLoginXtea", "NbSupportedCharacters", "MaxHumidityVersion", "MaxTemperatureVersion"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_tylohelo_tylohelo_protobuf_Announcement_descriptor = descriptor4;
        internal_static_com_tylohelo_tylohelo_protobuf_Announcement_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"SystemId", "Port", "Brand", "RcbProduct", "SystemName", "SaunaFeatures", "SystemType"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_descriptor = descriptor5;
        internal_static_com_tylohelo_tylohelo_protobuf_External_unit_features_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"ConnectRejectDoorSwitch"});
        Descriptors.Descriptor descriptor6 = getDescriptor().getMessageTypes().get(4);
        internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_descriptor = descriptor6;
        internal_static_com_tylohelo_tylohelo_protobuf_Connect_request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"Profile", "Pin", "DeviceDescription", "DeviceVersion", "ApplicationDescription", "ApplicationVersion", "ExternalUnitFeatures"});
        Descriptors.Descriptor descriptor7 = getDescriptor().getMessageTypes().get(5);
        internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_descriptor = descriptor7;
        internal_static_com_tylohelo_tylohelo_protobuf_Connect_reply_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"Status", "SystemId", "Brand", "CommunicationTimeOut", "CommunicationLostTimeOut", "RcbProduct", "SystemName", "SaunaFeatures", "ApplicationDescription", "ApplicationVersion", "SystemType"});
        Descriptors.Descriptor descriptor8 = getDescriptor().getMessageTypes().get(6);
        internal_static_com_tylohelo_tylohelo_protobuf_No_connection_descriptor = descriptor8;
        internal_static_com_tylohelo_tylohelo_protobuf_No_connection_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[0]);
        Descriptors.Descriptor descriptor9 = getDescriptor().getMessageTypes().get(7);
        internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_descriptor = descriptor9;
        internal_static_com_tylohelo_tylohelo_protobuf_Keep_alive_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor9, new String[]{"SequenceNumber"});
        Descriptors.Descriptor descriptor10 = getDescriptor().getMessageTypes().get(8);
        internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_descriptor = descriptor10;
        internal_static_com_tylohelo_tylohelo_protobuf_Announcement_request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor10, new String[]{"Profile"});
        Descriptors.Descriptor descriptor11 = getDescriptor().getMessageTypes().get(9);
        internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_descriptor = descriptor11;
        internal_static_com_tylohelo_tylohelo_protobuf_Disconnect_request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor11, new String[0]);
    }
}
