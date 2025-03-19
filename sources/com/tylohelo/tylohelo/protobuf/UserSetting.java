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
public final class UserSetting {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012user_setting.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"\u008d\n\n\fUser_setting\u0012Y\n\u0010temperature_unit\u0018\u0001 \u0001(\u000e2?.com.tylohelo.tylohelo.protobuf.User_setting.temperature_unit_t\u0012i\n\u0018temperature_presentation\u0018\u0002 \u0001(\u000e2G.com.tylohelo.tylohelo.protobuf.User_setting.temperature_presentation_t\u0012c\n\u0015humidity_presentation\u0018\u0003 \u0001(\u000e2D.com.tylohelo.tylohelo.protobuf.User_setting.humidity_presentation_t\u0012O\n\u000bdate_format\u0018\u0004 \u0001(\u000e2:.com.tylohelo.tylohelo.protobuf.User_setting.date_format_t\u0012O\n\u000btime_format\u0018\u0005 \u0001(\u000e2:.com.tylohelo.tylohelo.protobuf.User_setting.time_format_t\u0012K\n\tweekstart\u0018\u0006 \u0001(\u000e28.com.tylohelo.tylohelo.protobuf.User_setting.weekstart_t\u0012I\n\blanguage\u0018\u0007 \u0001(\u000e27.com.tylohelo.tylohelo.protobuf.User_setting.language_t\"E\n\u0012temperature_unit_t\u0012\u0015\n\u0011TEMP_UNIT_CELSIUS\u0010\n\u0012\u0018\n\u0014TEMP_UNIT_FAHRENHEIT\u0010\u000b\"H\n\u001atemperature_presentation_t\u0012\u0014\n\u0010TEMP_PRES_SMOOTH\u0010\n\u0012\u0014\n\u0010TEMP_PRES_DIRECT\u0010\u000b\"C\n\u0017humidity_presentation_t\u0012\u0013\n\u000fHUM_PRES_SMOOTH\u0010\n\u0012\u0013\n\u000fHUM_PRES_DIRECT\u0010\u000b\"B\n\rdate_format_t\u0012\u000f\n\u000bDATE_YYMMDD\u0010\n\u0012\u000f\n\u000bDATE_DDMMYY\u0010\u000b\u0012\u000f\n\u000bDATE_MMDDYY\u0010\f\".\n\rtime_format_t\u0012\r\n\tTIME_0_24\u0010\n\u0012\u000e\n\nTIME_AM_PM\u0010\u000b\"9\n\u000bweekstart_t\u0012\u0014\n\u0010WEEKSTART_MONDAY\u0010\n\u0012\u0014\n\u0010WEEKSTART_SUNDAY\u0010\u000b\"\u0092\u0002\n\nlanguage_t\u0012\u000f\n\nLANG_CZECH\u0010È\u0001\u0012\u000f\n\nLANG_DUTCH\u0010É\u0001\u0012\u0011\n\fLANG_ENGLISH\u0010Ê\u0001\u0012\u0011\n\fLANG_FINNISH\u0010Ë\u0001\u0012\u0010\n\u000bLANG_FRENCH\u0010Ì\u0001\u0012\u0010\n\u000bLANG_GERMAN\u0010Í\u0001\u0012\u0010\n\u000bLANG_POLISH\u0010Î\u0001\u0012\u0011\n\fLANG_RUSSIAN\u0010Ï\u0001\u0012\u0010\n\u000bLANG_SLOVAK\u0010Ð\u0001\u0012\u0011\n\fLANG_SPANISH\u0010Ñ\u0001\u0012\u0011\n\fLANG_SWEDISH\u0010Ò\u0001\u0012\u0010\n\u000bLANG_DANISH\u0010Ó\u0001\u0012\u0013\n\u000eLANG_NORWEGIAN\u0010Ô\u0001\u0012\u0014\n\u000fLANG_PORTUGUESE\u0010Õ\u0001B\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_User_setting_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_User_setting_fieldAccessorTable;

    public interface User_settingOrBuilder extends MessageOrBuilder {
        User_setting.date_format_t getDateFormat();

        User_setting.humidity_presentation_t getHumidityPresentation();

        User_setting.language_t getLanguage();

        User_setting.temperature_presentation_t getTemperaturePresentation();

        User_setting.temperature_unit_t getTemperatureUnit();

        User_setting.time_format_t getTimeFormat();

        User_setting.weekstart_t getWeekstart();

        boolean hasDateFormat();

        boolean hasHumidityPresentation();

        boolean hasLanguage();

        boolean hasTemperaturePresentation();

        boolean hasTemperatureUnit();

        boolean hasTimeFormat();

        boolean hasWeekstart();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private UserSetting() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class User_setting extends GeneratedMessageV3 implements User_settingOrBuilder {
        public static final int DATE_FORMAT_FIELD_NUMBER = 4;
        public static final int HUMIDITY_PRESENTATION_FIELD_NUMBER = 3;
        public static final int LANGUAGE_FIELD_NUMBER = 7;
        public static final int TEMPERATURE_PRESENTATION_FIELD_NUMBER = 2;
        public static final int TEMPERATURE_UNIT_FIELD_NUMBER = 1;
        public static final int TIME_FORMAT_FIELD_NUMBER = 5;
        public static final int WEEKSTART_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int dateFormat_;
        private int humidityPresentation_;
        private int language_;
        private byte memoizedIsInitialized;
        private int temperaturePresentation_;
        private int temperatureUnit_;
        private int timeFormat_;
        private int weekstart_;
        private static final User_setting DEFAULT_INSTANCE = new User_setting();

        @Deprecated
        public static final Parser<User_setting> PARSER = new AbstractParser<User_setting>() { // from class: com.tylohelo.tylohelo.protobuf.UserSetting.User_setting.1
            @Override // com.google.protobuf.Parser
            public User_setting parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = User_setting.newBuilder();
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

        static /* synthetic */ int access$1276(User_setting user_setting, int i) {
            int i2 = i | user_setting.bitField0_;
            user_setting.bitField0_ = i2;
            return i2;
        }

        private User_setting(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.temperatureUnit_ = 10;
            this.temperaturePresentation_ = 10;
            this.humidityPresentation_ = 10;
            this.dateFormat_ = 10;
            this.timeFormat_ = 10;
            this.weekstart_ = 10;
            this.language_ = 200;
            this.memoizedIsInitialized = (byte) -1;
        }

        private User_setting() {
            this.memoizedIsInitialized = (byte) -1;
            this.temperatureUnit_ = 10;
            this.temperaturePresentation_ = 10;
            this.humidityPresentation_ = 10;
            this.dateFormat_ = 10;
            this.timeFormat_ = 10;
            this.weekstart_ = 10;
            this.language_ = 200;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new User_setting();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UserSetting.internal_static_com_tylohelo_tylohelo_protobuf_User_setting_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UserSetting.internal_static_com_tylohelo_tylohelo_protobuf_User_setting_fieldAccessorTable.ensureFieldAccessorsInitialized(User_setting.class, Builder.class);
        }

        public enum temperature_unit_t implements ProtocolMessageEnum {
            TEMP_UNIT_CELSIUS(10),
            TEMP_UNIT_FAHRENHEIT(11);

            public static final int TEMP_UNIT_CELSIUS_VALUE = 10;
            public static final int TEMP_UNIT_FAHRENHEIT_VALUE = 11;
            private final int value;
            private static final Internal.EnumLiteMap<temperature_unit_t> internalValueMap = new Internal.EnumLiteMap<temperature_unit_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserSetting.User_setting.temperature_unit_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public temperature_unit_t findValueByNumber(int i) {
                    return temperature_unit_t.forNumber(i);
                }
            };
            private static final temperature_unit_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static temperature_unit_t valueOf(int i) {
                return forNumber(i);
            }

            public static temperature_unit_t forNumber(int i) {
                if (i == 10) {
                    return TEMP_UNIT_CELSIUS;
                }
                if (i != 11) {
                    return null;
                }
                return TEMP_UNIT_FAHRENHEIT;
            }

            public static Internal.EnumLiteMap<temperature_unit_t> internalGetValueMap() {
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
                return User_setting.getDescriptor().getEnumTypes().get(0);
            }

            public static temperature_unit_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            temperature_unit_t(int i) {
                this.value = i;
            }
        }

        public enum temperature_presentation_t implements ProtocolMessageEnum {
            TEMP_PRES_SMOOTH(10),
            TEMP_PRES_DIRECT(11);

            public static final int TEMP_PRES_DIRECT_VALUE = 11;
            public static final int TEMP_PRES_SMOOTH_VALUE = 10;
            private final int value;
            private static final Internal.EnumLiteMap<temperature_presentation_t> internalValueMap = new Internal.EnumLiteMap<temperature_presentation_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserSetting.User_setting.temperature_presentation_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public temperature_presentation_t findValueByNumber(int i) {
                    return temperature_presentation_t.forNumber(i);
                }
            };
            private static final temperature_presentation_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static temperature_presentation_t valueOf(int i) {
                return forNumber(i);
            }

            public static temperature_presentation_t forNumber(int i) {
                if (i == 10) {
                    return TEMP_PRES_SMOOTH;
                }
                if (i != 11) {
                    return null;
                }
                return TEMP_PRES_DIRECT;
            }

            public static Internal.EnumLiteMap<temperature_presentation_t> internalGetValueMap() {
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
                return User_setting.getDescriptor().getEnumTypes().get(1);
            }

            public static temperature_presentation_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            temperature_presentation_t(int i) {
                this.value = i;
            }
        }

        public enum humidity_presentation_t implements ProtocolMessageEnum {
            HUM_PRES_SMOOTH(10),
            HUM_PRES_DIRECT(11);

            public static final int HUM_PRES_DIRECT_VALUE = 11;
            public static final int HUM_PRES_SMOOTH_VALUE = 10;
            private final int value;
            private static final Internal.EnumLiteMap<humidity_presentation_t> internalValueMap = new Internal.EnumLiteMap<humidity_presentation_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserSetting.User_setting.humidity_presentation_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public humidity_presentation_t findValueByNumber(int i) {
                    return humidity_presentation_t.forNumber(i);
                }
            };
            private static final humidity_presentation_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static humidity_presentation_t valueOf(int i) {
                return forNumber(i);
            }

            public static humidity_presentation_t forNumber(int i) {
                if (i == 10) {
                    return HUM_PRES_SMOOTH;
                }
                if (i != 11) {
                    return null;
                }
                return HUM_PRES_DIRECT;
            }

            public static Internal.EnumLiteMap<humidity_presentation_t> internalGetValueMap() {
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
                return User_setting.getDescriptor().getEnumTypes().get(2);
            }

            public static humidity_presentation_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            humidity_presentation_t(int i) {
                this.value = i;
            }
        }

        public enum date_format_t implements ProtocolMessageEnum {
            DATE_YYMMDD(10),
            DATE_DDMMYY(11),
            DATE_MMDDYY(12);

            public static final int DATE_DDMMYY_VALUE = 11;
            public static final int DATE_MMDDYY_VALUE = 12;
            public static final int DATE_YYMMDD_VALUE = 10;
            private final int value;
            private static final Internal.EnumLiteMap<date_format_t> internalValueMap = new Internal.EnumLiteMap<date_format_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserSetting.User_setting.date_format_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public date_format_t findValueByNumber(int i) {
                    return date_format_t.forNumber(i);
                }
            };
            private static final date_format_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static date_format_t valueOf(int i) {
                return forNumber(i);
            }

            public static date_format_t forNumber(int i) {
                switch (i) {
                    case 10:
                        return DATE_YYMMDD;
                    case 11:
                        return DATE_DDMMYY;
                    case 12:
                        return DATE_MMDDYY;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<date_format_t> internalGetValueMap() {
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
                return User_setting.getDescriptor().getEnumTypes().get(3);
            }

            public static date_format_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            date_format_t(int i) {
                this.value = i;
            }
        }

        public enum time_format_t implements ProtocolMessageEnum {
            TIME_0_24(10),
            TIME_AM_PM(11);

            public static final int TIME_0_24_VALUE = 10;
            public static final int TIME_AM_PM_VALUE = 11;
            private final int value;
            private static final Internal.EnumLiteMap<time_format_t> internalValueMap = new Internal.EnumLiteMap<time_format_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserSetting.User_setting.time_format_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public time_format_t findValueByNumber(int i) {
                    return time_format_t.forNumber(i);
                }
            };
            private static final time_format_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static time_format_t valueOf(int i) {
                return forNumber(i);
            }

            public static time_format_t forNumber(int i) {
                if (i == 10) {
                    return TIME_0_24;
                }
                if (i != 11) {
                    return null;
                }
                return TIME_AM_PM;
            }

            public static Internal.EnumLiteMap<time_format_t> internalGetValueMap() {
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
                return User_setting.getDescriptor().getEnumTypes().get(4);
            }

            public static time_format_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            time_format_t(int i) {
                this.value = i;
            }
        }

        public enum weekstart_t implements ProtocolMessageEnum {
            WEEKSTART_MONDAY(10),
            WEEKSTART_SUNDAY(11);

            public static final int WEEKSTART_MONDAY_VALUE = 10;
            public static final int WEEKSTART_SUNDAY_VALUE = 11;
            private final int value;
            private static final Internal.EnumLiteMap<weekstart_t> internalValueMap = new Internal.EnumLiteMap<weekstart_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserSetting.User_setting.weekstart_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public weekstart_t findValueByNumber(int i) {
                    return weekstart_t.forNumber(i);
                }
            };
            private static final weekstart_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static weekstart_t valueOf(int i) {
                return forNumber(i);
            }

            public static weekstart_t forNumber(int i) {
                if (i == 10) {
                    return WEEKSTART_MONDAY;
                }
                if (i != 11) {
                    return null;
                }
                return WEEKSTART_SUNDAY;
            }

            public static Internal.EnumLiteMap<weekstart_t> internalGetValueMap() {
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
                return User_setting.getDescriptor().getEnumTypes().get(5);
            }

            public static weekstart_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            weekstart_t(int i) {
                this.value = i;
            }
        }

        public enum language_t implements ProtocolMessageEnum {
            LANG_CZECH(200),
            LANG_DUTCH(201),
            LANG_ENGLISH(202),
            LANG_FINNISH(203),
            LANG_FRENCH(204),
            LANG_GERMAN(205),
            LANG_POLISH(206),
            LANG_RUSSIAN(207),
            LANG_SLOVAK(LANG_SLOVAK_VALUE),
            LANG_SPANISH(LANG_SPANISH_VALUE),
            LANG_SWEDISH(LANG_SWEDISH_VALUE),
            LANG_DANISH(LANG_DANISH_VALUE),
            LANG_NORWEGIAN(LANG_NORWEGIAN_VALUE),
            LANG_PORTUGUESE(LANG_PORTUGUESE_VALUE);

            public static final int LANG_CZECH_VALUE = 200;
            public static final int LANG_DANISH_VALUE = 211;
            public static final int LANG_DUTCH_VALUE = 201;
            public static final int LANG_ENGLISH_VALUE = 202;
            public static final int LANG_FINNISH_VALUE = 203;
            public static final int LANG_FRENCH_VALUE = 204;
            public static final int LANG_GERMAN_VALUE = 205;
            public static final int LANG_NORWEGIAN_VALUE = 212;
            public static final int LANG_POLISH_VALUE = 206;
            public static final int LANG_PORTUGUESE_VALUE = 213;
            public static final int LANG_RUSSIAN_VALUE = 207;
            public static final int LANG_SLOVAK_VALUE = 208;
            public static final int LANG_SPANISH_VALUE = 209;
            public static final int LANG_SWEDISH_VALUE = 210;
            private final int value;
            private static final Internal.EnumLiteMap<language_t> internalValueMap = new Internal.EnumLiteMap<language_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserSetting.User_setting.language_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public language_t findValueByNumber(int i) {
                    return language_t.forNumber(i);
                }
            };
            private static final language_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static language_t valueOf(int i) {
                return forNumber(i);
            }

            public static language_t forNumber(int i) {
                switch (i) {
                    case 200:
                        return LANG_CZECH;
                    case 201:
                        return LANG_DUTCH;
                    case 202:
                        return LANG_ENGLISH;
                    case 203:
                        return LANG_FINNISH;
                    case 204:
                        return LANG_FRENCH;
                    case 205:
                        return LANG_GERMAN;
                    case 206:
                        return LANG_POLISH;
                    case 207:
                        return LANG_RUSSIAN;
                    case LANG_SLOVAK_VALUE:
                        return LANG_SLOVAK;
                    case LANG_SPANISH_VALUE:
                        return LANG_SPANISH;
                    case LANG_SWEDISH_VALUE:
                        return LANG_SWEDISH;
                    case LANG_DANISH_VALUE:
                        return LANG_DANISH;
                    case LANG_NORWEGIAN_VALUE:
                        return LANG_NORWEGIAN;
                    case LANG_PORTUGUESE_VALUE:
                        return LANG_PORTUGUESE;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<language_t> internalGetValueMap() {
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
                return User_setting.getDescriptor().getEnumTypes().get(6);
            }

            public static language_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            language_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public boolean hasTemperatureUnit() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public temperature_unit_t getTemperatureUnit() {
            temperature_unit_t forNumber = temperature_unit_t.forNumber(this.temperatureUnit_);
            return forNumber == null ? temperature_unit_t.TEMP_UNIT_CELSIUS : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public boolean hasTemperaturePresentation() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public temperature_presentation_t getTemperaturePresentation() {
            temperature_presentation_t forNumber = temperature_presentation_t.forNumber(this.temperaturePresentation_);
            return forNumber == null ? temperature_presentation_t.TEMP_PRES_SMOOTH : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public boolean hasHumidityPresentation() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public humidity_presentation_t getHumidityPresentation() {
            humidity_presentation_t forNumber = humidity_presentation_t.forNumber(this.humidityPresentation_);
            return forNumber == null ? humidity_presentation_t.HUM_PRES_SMOOTH : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public boolean hasDateFormat() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public date_format_t getDateFormat() {
            date_format_t forNumber = date_format_t.forNumber(this.dateFormat_);
            return forNumber == null ? date_format_t.DATE_YYMMDD : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public boolean hasTimeFormat() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public time_format_t getTimeFormat() {
            time_format_t forNumber = time_format_t.forNumber(this.timeFormat_);
            return forNumber == null ? time_format_t.TIME_0_24 : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public boolean hasWeekstart() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public weekstart_t getWeekstart() {
            weekstart_t forNumber = weekstart_t.forNumber(this.weekstart_);
            return forNumber == null ? weekstart_t.WEEKSTART_MONDAY : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public boolean hasLanguage() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
        public language_t getLanguage() {
            language_t forNumber = language_t.forNumber(this.language_);
            return forNumber == null ? language_t.LANG_CZECH : forNumber;
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
                codedOutputStream.writeEnum(1, this.temperatureUnit_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeEnum(2, this.temperaturePresentation_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeEnum(3, this.humidityPresentation_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeEnum(4, this.dateFormat_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeEnum(5, this.timeFormat_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.writeEnum(6, this.weekstart_);
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputStream.writeEnum(7, this.language_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(1, this.temperatureUnit_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(2, this.temperaturePresentation_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(3, this.humidityPresentation_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(4, this.dateFormat_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(5, this.timeFormat_);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(6, this.weekstart_);
            }
            if ((this.bitField0_ & 64) != 0) {
                computeEnumSize += CodedOutputStream.computeEnumSize(7, this.language_);
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
            if (!(obj instanceof User_setting)) {
                return super.equals(obj);
            }
            User_setting user_setting = (User_setting) obj;
            if (hasTemperatureUnit() != user_setting.hasTemperatureUnit()) {
                return false;
            }
            if ((hasTemperatureUnit() && this.temperatureUnit_ != user_setting.temperatureUnit_) || hasTemperaturePresentation() != user_setting.hasTemperaturePresentation()) {
                return false;
            }
            if ((hasTemperaturePresentation() && this.temperaturePresentation_ != user_setting.temperaturePresentation_) || hasHumidityPresentation() != user_setting.hasHumidityPresentation()) {
                return false;
            }
            if ((hasHumidityPresentation() && this.humidityPresentation_ != user_setting.humidityPresentation_) || hasDateFormat() != user_setting.hasDateFormat()) {
                return false;
            }
            if ((hasDateFormat() && this.dateFormat_ != user_setting.dateFormat_) || hasTimeFormat() != user_setting.hasTimeFormat()) {
                return false;
            }
            if ((hasTimeFormat() && this.timeFormat_ != user_setting.timeFormat_) || hasWeekstart() != user_setting.hasWeekstart()) {
                return false;
            }
            if ((!hasWeekstart() || this.weekstart_ == user_setting.weekstart_) && hasLanguage() == user_setting.hasLanguage()) {
                return (!hasLanguage() || this.language_ == user_setting.language_) && getUnknownFields().equals(user_setting.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasTemperatureUnit()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.temperatureUnit_;
            }
            if (hasTemperaturePresentation()) {
                hashCode = (((hashCode * 37) + 2) * 53) + this.temperaturePresentation_;
            }
            if (hasHumidityPresentation()) {
                hashCode = (((hashCode * 37) + 3) * 53) + this.humidityPresentation_;
            }
            if (hasDateFormat()) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.dateFormat_;
            }
            if (hasTimeFormat()) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.timeFormat_;
            }
            if (hasWeekstart()) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.weekstart_;
            }
            if (hasLanguage()) {
                hashCode = (((hashCode * 37) + 7) * 53) + this.language_;
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static User_setting parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static User_setting parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static User_setting parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static User_setting parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static User_setting parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static User_setting parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static User_setting parseFrom(InputStream inputStream) throws IOException {
            return (User_setting) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static User_setting parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (User_setting) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static User_setting parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (User_setting) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static User_setting parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (User_setting) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static User_setting parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (User_setting) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static User_setting parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (User_setting) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(User_setting user_setting) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(user_setting);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements User_settingOrBuilder {
            private int bitField0_;
            private int dateFormat_;
            private int humidityPresentation_;
            private int language_;
            private int temperaturePresentation_;
            private int temperatureUnit_;
            private int timeFormat_;
            private int weekstart_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return UserSetting.internal_static_com_tylohelo_tylohelo_protobuf_User_setting_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UserSetting.internal_static_com_tylohelo_tylohelo_protobuf_User_setting_fieldAccessorTable.ensureFieldAccessorsInitialized(User_setting.class, Builder.class);
            }

            private Builder() {
                this.temperatureUnit_ = 10;
                this.temperaturePresentation_ = 10;
                this.humidityPresentation_ = 10;
                this.dateFormat_ = 10;
                this.timeFormat_ = 10;
                this.weekstart_ = 10;
                this.language_ = 200;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.temperatureUnit_ = 10;
                this.temperaturePresentation_ = 10;
                this.humidityPresentation_ = 10;
                this.dateFormat_ = 10;
                this.timeFormat_ = 10;
                this.weekstart_ = 10;
                this.language_ = 200;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.temperatureUnit_ = 10;
                this.temperaturePresentation_ = 10;
                this.humidityPresentation_ = 10;
                this.dateFormat_ = 10;
                this.timeFormat_ = 10;
                this.weekstart_ = 10;
                this.language_ = 200;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UserSetting.internal_static_com_tylohelo_tylohelo_protobuf_User_setting_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public User_setting getDefaultInstanceForType() {
                return User_setting.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public User_setting build() {
                User_setting buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public User_setting buildPartial() {
                User_setting user_setting = new User_setting(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(user_setting);
                }
                onBuilt();
                return user_setting;
            }

            private void buildPartial0(User_setting user_setting) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    user_setting.temperatureUnit_ = this.temperatureUnit_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    user_setting.temperaturePresentation_ = this.temperaturePresentation_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    user_setting.humidityPresentation_ = this.humidityPresentation_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    user_setting.dateFormat_ = this.dateFormat_;
                    i |= 8;
                }
                if ((i2 & 16) != 0) {
                    user_setting.timeFormat_ = this.timeFormat_;
                    i |= 16;
                }
                if ((i2 & 32) != 0) {
                    user_setting.weekstart_ = this.weekstart_;
                    i |= 32;
                }
                if ((i2 & 64) != 0) {
                    user_setting.language_ = this.language_;
                    i |= 64;
                }
                User_setting.access$1276(user_setting, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof User_setting) {
                    return mergeFrom((User_setting) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(User_setting user_setting) {
                if (user_setting == User_setting.getDefaultInstance()) {
                    return this;
                }
                if (user_setting.hasTemperatureUnit()) {
                    setTemperatureUnit(user_setting.getTemperatureUnit());
                }
                if (user_setting.hasTemperaturePresentation()) {
                    setTemperaturePresentation(user_setting.getTemperaturePresentation());
                }
                if (user_setting.hasHumidityPresentation()) {
                    setHumidityPresentation(user_setting.getHumidityPresentation());
                }
                if (user_setting.hasDateFormat()) {
                    setDateFormat(user_setting.getDateFormat());
                }
                if (user_setting.hasTimeFormat()) {
                    setTimeFormat(user_setting.getTimeFormat());
                }
                if (user_setting.hasWeekstart()) {
                    setWeekstart(user_setting.getWeekstart());
                }
                if (user_setting.hasLanguage()) {
                    setLanguage(user_setting.getLanguage());
                }
                mergeUnknownFields(user_setting.getUnknownFields());
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
                                    if (temperature_unit_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(1, readEnum);
                                    } else {
                                        this.temperatureUnit_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                } else if (readTag == 16) {
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (temperature_presentation_t.forNumber(readEnum2) == null) {
                                        mergeUnknownVarintField(2, readEnum2);
                                    } else {
                                        this.temperaturePresentation_ = readEnum2;
                                        this.bitField0_ |= 2;
                                    }
                                } else if (readTag == 24) {
                                    int readEnum3 = codedInputStream.readEnum();
                                    if (humidity_presentation_t.forNumber(readEnum3) == null) {
                                        mergeUnknownVarintField(3, readEnum3);
                                    } else {
                                        this.humidityPresentation_ = readEnum3;
                                        this.bitField0_ |= 4;
                                    }
                                } else if (readTag == 32) {
                                    int readEnum4 = codedInputStream.readEnum();
                                    if (date_format_t.forNumber(readEnum4) == null) {
                                        mergeUnknownVarintField(4, readEnum4);
                                    } else {
                                        this.dateFormat_ = readEnum4;
                                        this.bitField0_ |= 8;
                                    }
                                } else if (readTag == 40) {
                                    int readEnum5 = codedInputStream.readEnum();
                                    if (time_format_t.forNumber(readEnum5) == null) {
                                        mergeUnknownVarintField(5, readEnum5);
                                    } else {
                                        this.timeFormat_ = readEnum5;
                                        this.bitField0_ |= 16;
                                    }
                                } else if (readTag == 48) {
                                    int readEnum6 = codedInputStream.readEnum();
                                    if (weekstart_t.forNumber(readEnum6) == null) {
                                        mergeUnknownVarintField(6, readEnum6);
                                    } else {
                                        this.weekstart_ = readEnum6;
                                        this.bitField0_ |= 32;
                                    }
                                } else if (readTag == 56) {
                                    int readEnum7 = codedInputStream.readEnum();
                                    if (language_t.forNumber(readEnum7) == null) {
                                        mergeUnknownVarintField(7, readEnum7);
                                    } else {
                                        this.language_ = readEnum7;
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

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public boolean hasTemperatureUnit() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public temperature_unit_t getTemperatureUnit() {
                temperature_unit_t forNumber = temperature_unit_t.forNumber(this.temperatureUnit_);
                return forNumber == null ? temperature_unit_t.TEMP_UNIT_CELSIUS : forNumber;
            }

            public Builder setTemperatureUnit(temperature_unit_t temperature_unit_tVar) {
                temperature_unit_tVar.getClass();
                this.bitField0_ |= 1;
                this.temperatureUnit_ = temperature_unit_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearTemperatureUnit() {
                this.bitField0_ &= -2;
                this.temperatureUnit_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public boolean hasTemperaturePresentation() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public temperature_presentation_t getTemperaturePresentation() {
                temperature_presentation_t forNumber = temperature_presentation_t.forNumber(this.temperaturePresentation_);
                return forNumber == null ? temperature_presentation_t.TEMP_PRES_SMOOTH : forNumber;
            }

            public Builder setTemperaturePresentation(temperature_presentation_t temperature_presentation_tVar) {
                temperature_presentation_tVar.getClass();
                this.bitField0_ |= 2;
                this.temperaturePresentation_ = temperature_presentation_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearTemperaturePresentation() {
                this.bitField0_ &= -3;
                this.temperaturePresentation_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public boolean hasHumidityPresentation() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public humidity_presentation_t getHumidityPresentation() {
                humidity_presentation_t forNumber = humidity_presentation_t.forNumber(this.humidityPresentation_);
                return forNumber == null ? humidity_presentation_t.HUM_PRES_SMOOTH : forNumber;
            }

            public Builder setHumidityPresentation(humidity_presentation_t humidity_presentation_tVar) {
                humidity_presentation_tVar.getClass();
                this.bitField0_ |= 4;
                this.humidityPresentation_ = humidity_presentation_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearHumidityPresentation() {
                this.bitField0_ &= -5;
                this.humidityPresentation_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public boolean hasDateFormat() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public date_format_t getDateFormat() {
                date_format_t forNumber = date_format_t.forNumber(this.dateFormat_);
                return forNumber == null ? date_format_t.DATE_YYMMDD : forNumber;
            }

            public Builder setDateFormat(date_format_t date_format_tVar) {
                date_format_tVar.getClass();
                this.bitField0_ |= 8;
                this.dateFormat_ = date_format_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearDateFormat() {
                this.bitField0_ &= -9;
                this.dateFormat_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public boolean hasTimeFormat() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public time_format_t getTimeFormat() {
                time_format_t forNumber = time_format_t.forNumber(this.timeFormat_);
                return forNumber == null ? time_format_t.TIME_0_24 : forNumber;
            }

            public Builder setTimeFormat(time_format_t time_format_tVar) {
                time_format_tVar.getClass();
                this.bitField0_ |= 16;
                this.timeFormat_ = time_format_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearTimeFormat() {
                this.bitField0_ &= -17;
                this.timeFormat_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public boolean hasWeekstart() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public weekstart_t getWeekstart() {
                weekstart_t forNumber = weekstart_t.forNumber(this.weekstart_);
                return forNumber == null ? weekstart_t.WEEKSTART_MONDAY : forNumber;
            }

            public Builder setWeekstart(weekstart_t weekstart_tVar) {
                weekstart_tVar.getClass();
                this.bitField0_ |= 32;
                this.weekstart_ = weekstart_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearWeekstart() {
                this.bitField0_ &= -33;
                this.weekstart_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public boolean hasLanguage() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserSetting.User_settingOrBuilder
            public language_t getLanguage() {
                language_t forNumber = language_t.forNumber(this.language_);
                return forNumber == null ? language_t.LANG_CZECH : forNumber;
            }

            public Builder setLanguage(language_t language_tVar) {
                language_tVar.getClass();
                this.bitField0_ |= 64;
                this.language_ = language_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLanguage() {
                this.bitField0_ &= -65;
                this.language_ = 200;
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

        public static User_setting getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<User_setting> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<User_setting> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public User_setting getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_User_setting_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_User_setting_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"TemperatureUnit", "TemperaturePresentation", "HumidityPresentation", "DateFormat", "TimeFormat", "Weekstart", "Language"});
    }
}
