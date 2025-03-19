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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.tylohelo.tylohelo.protobuf.AuxRelay;
import com.tylohelo.tylohelo.protobuf.BooleanValue;
import com.tylohelo.tylohelo.protobuf.Calendar;
import com.tylohelo.tylohelo.protobuf.Command;
import com.tylohelo.tylohelo.protobuf.Connect;
import com.tylohelo.tylohelo.protobuf.EnumValue;
import com.tylohelo.tylohelo.protobuf.Favorite;
import com.tylohelo.tylohelo.protobuf.IntegerValue;
import com.tylohelo.tylohelo.protobuf.PresentedValue;
import com.tylohelo.tylohelo.protobuf.SaunaState;
import com.tylohelo.tylohelo.protobuf.UserMessage;
import com.tylohelo.tylohelo.protobuf.UserSetting;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Message {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rmessage.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\u001a\u000faux_relay.proto\u001a\rcommand.proto\u001a\u000ecalendar.proto\u001a\u0013integer_value.proto\u001a\u0015presented_value.proto\u001a\u0012user_message.proto\u001a\u0012user_setting.proto\u001a\u0011sauna_state.proto\u001a\u0010enum_value.proto\u001a\u0013boolean_value.proto\u001a\u000efavorite.proto\u001a\rconnect.proto\"\u009e\u0007\n\u0011External_to_sauna\u0012I\n\u000fconnect_request\u0018è\u0007 \u0001(\u000b2/.com.tylohelo.tylohelo.protobuf.Connect_request\u0012O\n\u0012disconnect_request\u0018é\u0007 \u0001(\u000b22.com.tylohelo.tylohelo.protobuf.Disconnect_request\u0012?\n\nkeep_alive\u0018ê\u0007 \u0001(\u000b2*.com.tylohelo.tylohelo.protobuf.Keep_alive\u0012I\n\u000fgeneral_command\u0018\u0090\b \u0003(\u000b2/.com.tylohelo.tylohelo.protobuf.General_command\u0012T\n\rinteger_value\u0018\u009a\b \u0003(\u000b2<.com.tylohelo.tylohelo.protobuf.Integer_value_change_request\u0012C\n\fuser_message\u0018à\b \u0001(\u000b2,.com.tylohelo.tylohelo.protobuf.User_message\u0012P\n\u000bsauna_state\u0018¸\b \u0001(\u000b2:.com.tylohelo.tylohelo.protobuf.Sauna_state_change_request\u0012N\n\nenum_value\u0018Ö\b \u0003(\u000b29.com.tylohelo.tylohelo.protobuf.Enum_value_change_request\u0012@\n\bfavorite\u0018®\b \u0003(\u000b2-.com.tylohelo.tylohelo.protobuf.Favorite_post\u0012T\n\rboolean_value\u0018¤\b \u0003(\u000b2<.com.tylohelo.tylohelo.protobuf.Boolean_value_change_request\u0012B\n\taux_relay\u0018Â\b \u0003(\u000b2..com.tylohelo.tylohelo.protobuf.Aux_relay_post\u0012H\n\u0010calendar_program\u0018³\b \u0003(\u000b2-.com.tylohelo.tylohelo.protobuf.Calendar_post\"Å\u0007\n\u0011Sauna_to_external\u0012E\n\rconnect_reply\u0018Ð\u000f \u0001(\u000b2-.com.tylohelo.tylohelo.protobuf.Connect_reply\u0012E\n\rno_connection\u0018Ñ\u000f \u0001(\u000b2-.com.tylohelo.tylohelo.protobuf.No_connection\u0012?\n\nkeep_alive\u0018Ò\u000f \u0001(\u000b2*.com.tylohelo.tylohelo.protobuf.Keep_alive\u0012M\n\rinteger_value\u0018Ú\u000f \u0003(\u000b25.com.tylohelo.tylohelo.protobuf.Integer_value_changed\u0012I\n\u000fpresented_value\u0018î\u000f \u0001(\u000b2/.com.tylohelo.tylohelo.protobuf.Presented_value\u0012C\n\fuser_message\u0018¾\u0010 \u0001(\u000b2,.com.tylohelo.tylohelo.protobuf.User_message\u0012C\n\fuser_setting\u0018ä\u000f \u0001(\u000b2,.com.tylohelo.tylohelo.protobuf.User_setting\u0012I\n\u000bsauna_state\u0018\u0082\u0010 \u0001(\u000b23.com.tylohelo.tylohelo.protobuf.Sauna_state_changed\u0012G\n\nenum_value\u0018´\u0010 \u0003(\u000b22.com.tylohelo.tylohelo.protobuf.Enum_value_changed\u0012M\n\rboolean_value\u0018Û\u000f \u0003(\u000b25.com.tylohelo.tylohelo.protobuf.Boolean_value_changed\u0012@\n\bfavorite\u0018ø\u000f \u0003(\u000b2-.com.tylohelo.tylohelo.protobuf.Favorite_post\u0012N\n\u000faux_relay_sauna\u0018\u0096\u0010 \u0003(\u000b24.com.tylohelo.tylohelo.protobuf.Aux_relay_post_sauna\u0012H\n\u0010calendar_program\u0018ý\u000f \u0003(\u000b2-.com.tylohelo.tylohelo.protobuf.Calendar_postB\u0002H\u0003"}, new Descriptors.FileDescriptor[]{AuxRelay.getDescriptor(), Command.getDescriptor(), Calendar.getDescriptor(), IntegerValue.getDescriptor(), PresentedValue.getDescriptor(), UserMessage.getDescriptor(), UserSetting.getDescriptor(), SaunaState.getDescriptor(), EnumValue.getDescriptor(), BooleanValue.getDescriptor(), Favorite.getDescriptor(), Connect.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_fieldAccessorTable;

    public interface External_to_saunaOrBuilder extends MessageOrBuilder {
        AuxRelay.Aux_relay_post getAuxRelay(int i);

        int getAuxRelayCount();

        List<AuxRelay.Aux_relay_post> getAuxRelayList();

        AuxRelay.Aux_relay_postOrBuilder getAuxRelayOrBuilder(int i);

        List<? extends AuxRelay.Aux_relay_postOrBuilder> getAuxRelayOrBuilderList();

        BooleanValue.Boolean_value_change_request getBooleanValue(int i);

        int getBooleanValueCount();

        List<BooleanValue.Boolean_value_change_request> getBooleanValueList();

        BooleanValue.Boolean_value_change_requestOrBuilder getBooleanValueOrBuilder(int i);

        List<? extends BooleanValue.Boolean_value_change_requestOrBuilder> getBooleanValueOrBuilderList();

        Calendar.Calendar_post getCalendarProgram(int i);

        int getCalendarProgramCount();

        List<Calendar.Calendar_post> getCalendarProgramList();

        Calendar.Calendar_postOrBuilder getCalendarProgramOrBuilder(int i);

        List<? extends Calendar.Calendar_postOrBuilder> getCalendarProgramOrBuilderList();

        Connect.Connect_request getConnectRequest();

        Connect.Connect_requestOrBuilder getConnectRequestOrBuilder();

        Connect.Disconnect_request getDisconnectRequest();

        Connect.Disconnect_requestOrBuilder getDisconnectRequestOrBuilder();

        EnumValue.Enum_value_change_request getEnumValue(int i);

        int getEnumValueCount();

        List<EnumValue.Enum_value_change_request> getEnumValueList();

        EnumValue.Enum_value_change_requestOrBuilder getEnumValueOrBuilder(int i);

        List<? extends EnumValue.Enum_value_change_requestOrBuilder> getEnumValueOrBuilderList();

        Favorite.Favorite_post getFavorite(int i);

        int getFavoriteCount();

        List<Favorite.Favorite_post> getFavoriteList();

        Favorite.Favorite_postOrBuilder getFavoriteOrBuilder(int i);

        List<? extends Favorite.Favorite_postOrBuilder> getFavoriteOrBuilderList();

        Command.General_command getGeneralCommand(int i);

        int getGeneralCommandCount();

        List<Command.General_command> getGeneralCommandList();

        Command.General_commandOrBuilder getGeneralCommandOrBuilder(int i);

        List<? extends Command.General_commandOrBuilder> getGeneralCommandOrBuilderList();

        IntegerValue.Integer_value_change_request getIntegerValue(int i);

        int getIntegerValueCount();

        List<IntegerValue.Integer_value_change_request> getIntegerValueList();

        IntegerValue.Integer_value_change_requestOrBuilder getIntegerValueOrBuilder(int i);

        List<? extends IntegerValue.Integer_value_change_requestOrBuilder> getIntegerValueOrBuilderList();

        Connect.Keep_alive getKeepAlive();

        Connect.Keep_aliveOrBuilder getKeepAliveOrBuilder();

        SaunaState.Sauna_state_change_request getSaunaState();

        SaunaState.Sauna_state_change_requestOrBuilder getSaunaStateOrBuilder();

        UserMessage.User_message getUserMessage();

        UserMessage.User_messageOrBuilder getUserMessageOrBuilder();

        boolean hasConnectRequest();

        boolean hasDisconnectRequest();

        boolean hasKeepAlive();

        boolean hasSaunaState();

        boolean hasUserMessage();
    }

    public interface Sauna_to_externalOrBuilder extends MessageOrBuilder {
        AuxRelay.Aux_relay_post_sauna getAuxRelaySauna(int i);

        int getAuxRelaySaunaCount();

        List<AuxRelay.Aux_relay_post_sauna> getAuxRelaySaunaList();

        AuxRelay.Aux_relay_post_saunaOrBuilder getAuxRelaySaunaOrBuilder(int i);

        List<? extends AuxRelay.Aux_relay_post_saunaOrBuilder> getAuxRelaySaunaOrBuilderList();

        BooleanValue.Boolean_value_changed getBooleanValue(int i);

        int getBooleanValueCount();

        List<BooleanValue.Boolean_value_changed> getBooleanValueList();

        BooleanValue.Boolean_value_changedOrBuilder getBooleanValueOrBuilder(int i);

        List<? extends BooleanValue.Boolean_value_changedOrBuilder> getBooleanValueOrBuilderList();

        Calendar.Calendar_post getCalendarProgram(int i);

        int getCalendarProgramCount();

        List<Calendar.Calendar_post> getCalendarProgramList();

        Calendar.Calendar_postOrBuilder getCalendarProgramOrBuilder(int i);

        List<? extends Calendar.Calendar_postOrBuilder> getCalendarProgramOrBuilderList();

        Connect.Connect_reply getConnectReply();

        Connect.Connect_replyOrBuilder getConnectReplyOrBuilder();

        EnumValue.Enum_value_changed getEnumValue(int i);

        int getEnumValueCount();

        List<EnumValue.Enum_value_changed> getEnumValueList();

        EnumValue.Enum_value_changedOrBuilder getEnumValueOrBuilder(int i);

        List<? extends EnumValue.Enum_value_changedOrBuilder> getEnumValueOrBuilderList();

        Favorite.Favorite_post getFavorite(int i);

        int getFavoriteCount();

        List<Favorite.Favorite_post> getFavoriteList();

        Favorite.Favorite_postOrBuilder getFavoriteOrBuilder(int i);

        List<? extends Favorite.Favorite_postOrBuilder> getFavoriteOrBuilderList();

        IntegerValue.Integer_value_changed getIntegerValue(int i);

        int getIntegerValueCount();

        List<IntegerValue.Integer_value_changed> getIntegerValueList();

        IntegerValue.Integer_value_changedOrBuilder getIntegerValueOrBuilder(int i);

        List<? extends IntegerValue.Integer_value_changedOrBuilder> getIntegerValueOrBuilderList();

        Connect.Keep_alive getKeepAlive();

        Connect.Keep_aliveOrBuilder getKeepAliveOrBuilder();

        Connect.No_connection getNoConnection();

        Connect.No_connectionOrBuilder getNoConnectionOrBuilder();

        PresentedValue.Presented_value getPresentedValue();

        PresentedValue.Presented_valueOrBuilder getPresentedValueOrBuilder();

        SaunaState.Sauna_state_changed getSaunaState();

        SaunaState.Sauna_state_changedOrBuilder getSaunaStateOrBuilder();

        UserMessage.User_message getUserMessage();

        UserMessage.User_messageOrBuilder getUserMessageOrBuilder();

        UserSetting.User_setting getUserSetting();

        UserSetting.User_settingOrBuilder getUserSettingOrBuilder();

        boolean hasConnectReply();

        boolean hasKeepAlive();

        boolean hasNoConnection();

        boolean hasPresentedValue();

        boolean hasSaunaState();

        boolean hasUserMessage();

        boolean hasUserSetting();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Message() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class External_to_sauna extends GeneratedMessageV3 implements External_to_saunaOrBuilder {
        public static final int AUX_RELAY_FIELD_NUMBER = 1090;
        public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1060;
        public static final int CALENDAR_PROGRAM_FIELD_NUMBER = 1075;
        public static final int CONNECT_REQUEST_FIELD_NUMBER = 1000;
        public static final int DISCONNECT_REQUEST_FIELD_NUMBER = 1001;
        public static final int ENUM_VALUE_FIELD_NUMBER = 1110;
        public static final int FAVORITE_FIELD_NUMBER = 1070;
        public static final int GENERAL_COMMAND_FIELD_NUMBER = 1040;
        public static final int INTEGER_VALUE_FIELD_NUMBER = 1050;
        public static final int KEEP_ALIVE_FIELD_NUMBER = 1002;
        public static final int SAUNA_STATE_FIELD_NUMBER = 1080;
        public static final int USER_MESSAGE_FIELD_NUMBER = 1120;
        private static final long serialVersionUID = 0;
        private List<AuxRelay.Aux_relay_post> auxRelay_;
        private int bitField0_;
        private List<BooleanValue.Boolean_value_change_request> booleanValue_;
        private List<Calendar.Calendar_post> calendarProgram_;
        private Connect.Connect_request connectRequest_;
        private Connect.Disconnect_request disconnectRequest_;
        private List<EnumValue.Enum_value_change_request> enumValue_;
        private List<Favorite.Favorite_post> favorite_;
        private List<Command.General_command> generalCommand_;
        private List<IntegerValue.Integer_value_change_request> integerValue_;
        private Connect.Keep_alive keepAlive_;
        private byte memoizedIsInitialized;
        private SaunaState.Sauna_state_change_request saunaState_;
        private UserMessage.User_message userMessage_;
        private static final External_to_sauna DEFAULT_INSTANCE = new External_to_sauna();

        @Deprecated
        public static final Parser<External_to_sauna> PARSER = new AbstractParser<External_to_sauna>() { // from class: com.tylohelo.tylohelo.protobuf.Message.External_to_sauna.1
            @Override // com.google.protobuf.Parser
            public External_to_sauna parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = External_to_sauna.newBuilder();
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

        static /* synthetic */ int access$1876(External_to_sauna external_to_sauna, int i) {
            int i2 = i | external_to_sauna.bitField0_;
            external_to_sauna.bitField0_ = i2;
            return i2;
        }

        private External_to_sauna(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private External_to_sauna() {
            this.memoizedIsInitialized = (byte) -1;
            this.generalCommand_ = Collections.emptyList();
            this.integerValue_ = Collections.emptyList();
            this.enumValue_ = Collections.emptyList();
            this.favorite_ = Collections.emptyList();
            this.booleanValue_ = Collections.emptyList();
            this.auxRelay_ = Collections.emptyList();
            this.calendarProgram_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new External_to_sauna();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Message.internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Message.internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_fieldAccessorTable.ensureFieldAccessorsInitialized(External_to_sauna.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public boolean hasConnectRequest() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Connect.Connect_request getConnectRequest() {
            Connect.Connect_request connect_request = this.connectRequest_;
            return connect_request == null ? Connect.Connect_request.getDefaultInstance() : connect_request;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Connect.Connect_requestOrBuilder getConnectRequestOrBuilder() {
            Connect.Connect_request connect_request = this.connectRequest_;
            return connect_request == null ? Connect.Connect_request.getDefaultInstance() : connect_request;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public boolean hasDisconnectRequest() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Connect.Disconnect_request getDisconnectRequest() {
            Connect.Disconnect_request disconnect_request = this.disconnectRequest_;
            return disconnect_request == null ? Connect.Disconnect_request.getDefaultInstance() : disconnect_request;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Connect.Disconnect_requestOrBuilder getDisconnectRequestOrBuilder() {
            Connect.Disconnect_request disconnect_request = this.disconnectRequest_;
            return disconnect_request == null ? Connect.Disconnect_request.getDefaultInstance() : disconnect_request;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public boolean hasKeepAlive() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Connect.Keep_alive getKeepAlive() {
            Connect.Keep_alive keep_alive = this.keepAlive_;
            return keep_alive == null ? Connect.Keep_alive.getDefaultInstance() : keep_alive;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Connect.Keep_aliveOrBuilder getKeepAliveOrBuilder() {
            Connect.Keep_alive keep_alive = this.keepAlive_;
            return keep_alive == null ? Connect.Keep_alive.getDefaultInstance() : keep_alive;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<Command.General_command> getGeneralCommandList() {
            return this.generalCommand_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<? extends Command.General_commandOrBuilder> getGeneralCommandOrBuilderList() {
            return this.generalCommand_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public int getGeneralCommandCount() {
            return this.generalCommand_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Command.General_command getGeneralCommand(int i) {
            return this.generalCommand_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Command.General_commandOrBuilder getGeneralCommandOrBuilder(int i) {
            return this.generalCommand_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<IntegerValue.Integer_value_change_request> getIntegerValueList() {
            return this.integerValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<? extends IntegerValue.Integer_value_change_requestOrBuilder> getIntegerValueOrBuilderList() {
            return this.integerValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public int getIntegerValueCount() {
            return this.integerValue_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public IntegerValue.Integer_value_change_request getIntegerValue(int i) {
            return this.integerValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public IntegerValue.Integer_value_change_requestOrBuilder getIntegerValueOrBuilder(int i) {
            return this.integerValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public boolean hasUserMessage() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public UserMessage.User_message getUserMessage() {
            UserMessage.User_message user_message = this.userMessage_;
            return user_message == null ? UserMessage.User_message.getDefaultInstance() : user_message;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public UserMessage.User_messageOrBuilder getUserMessageOrBuilder() {
            UserMessage.User_message user_message = this.userMessage_;
            return user_message == null ? UserMessage.User_message.getDefaultInstance() : user_message;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public boolean hasSaunaState() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public SaunaState.Sauna_state_change_request getSaunaState() {
            SaunaState.Sauna_state_change_request sauna_state_change_request = this.saunaState_;
            return sauna_state_change_request == null ? SaunaState.Sauna_state_change_request.getDefaultInstance() : sauna_state_change_request;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public SaunaState.Sauna_state_change_requestOrBuilder getSaunaStateOrBuilder() {
            SaunaState.Sauna_state_change_request sauna_state_change_request = this.saunaState_;
            return sauna_state_change_request == null ? SaunaState.Sauna_state_change_request.getDefaultInstance() : sauna_state_change_request;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<EnumValue.Enum_value_change_request> getEnumValueList() {
            return this.enumValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<? extends EnumValue.Enum_value_change_requestOrBuilder> getEnumValueOrBuilderList() {
            return this.enumValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public int getEnumValueCount() {
            return this.enumValue_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public EnumValue.Enum_value_change_request getEnumValue(int i) {
            return this.enumValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public EnumValue.Enum_value_change_requestOrBuilder getEnumValueOrBuilder(int i) {
            return this.enumValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<Favorite.Favorite_post> getFavoriteList() {
            return this.favorite_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<? extends Favorite.Favorite_postOrBuilder> getFavoriteOrBuilderList() {
            return this.favorite_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public int getFavoriteCount() {
            return this.favorite_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Favorite.Favorite_post getFavorite(int i) {
            return this.favorite_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Favorite.Favorite_postOrBuilder getFavoriteOrBuilder(int i) {
            return this.favorite_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<BooleanValue.Boolean_value_change_request> getBooleanValueList() {
            return this.booleanValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<? extends BooleanValue.Boolean_value_change_requestOrBuilder> getBooleanValueOrBuilderList() {
            return this.booleanValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public int getBooleanValueCount() {
            return this.booleanValue_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public BooleanValue.Boolean_value_change_request getBooleanValue(int i) {
            return this.booleanValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public BooleanValue.Boolean_value_change_requestOrBuilder getBooleanValueOrBuilder(int i) {
            return this.booleanValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<AuxRelay.Aux_relay_post> getAuxRelayList() {
            return this.auxRelay_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<? extends AuxRelay.Aux_relay_postOrBuilder> getAuxRelayOrBuilderList() {
            return this.auxRelay_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public int getAuxRelayCount() {
            return this.auxRelay_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public AuxRelay.Aux_relay_post getAuxRelay(int i) {
            return this.auxRelay_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public AuxRelay.Aux_relay_postOrBuilder getAuxRelayOrBuilder(int i) {
            return this.auxRelay_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<Calendar.Calendar_post> getCalendarProgramList() {
            return this.calendarProgram_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public List<? extends Calendar.Calendar_postOrBuilder> getCalendarProgramOrBuilderList() {
            return this.calendarProgram_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public int getCalendarProgramCount() {
            return this.calendarProgram_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Calendar.Calendar_post getCalendarProgram(int i) {
            return this.calendarProgram_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
        public Calendar.Calendar_postOrBuilder getCalendarProgramOrBuilder(int i) {
            return this.calendarProgram_.get(i);
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
                codedOutputStream.writeMessage(1000, getConnectRequest());
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeMessage(1001, getDisconnectRequest());
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeMessage(1002, getKeepAlive());
            }
            for (int i = 0; i < this.generalCommand_.size(); i++) {
                codedOutputStream.writeMessage(GENERAL_COMMAND_FIELD_NUMBER, this.generalCommand_.get(i));
            }
            for (int i2 = 0; i2 < this.integerValue_.size(); i2++) {
                codedOutputStream.writeMessage(INTEGER_VALUE_FIELD_NUMBER, this.integerValue_.get(i2));
            }
            for (int i3 = 0; i3 < this.booleanValue_.size(); i3++) {
                codedOutputStream.writeMessage(BOOLEAN_VALUE_FIELD_NUMBER, this.booleanValue_.get(i3));
            }
            for (int i4 = 0; i4 < this.favorite_.size(); i4++) {
                codedOutputStream.writeMessage(FAVORITE_FIELD_NUMBER, this.favorite_.get(i4));
            }
            for (int i5 = 0; i5 < this.calendarProgram_.size(); i5++) {
                codedOutputStream.writeMessage(CALENDAR_PROGRAM_FIELD_NUMBER, this.calendarProgram_.get(i5));
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeMessage(SAUNA_STATE_FIELD_NUMBER, getSaunaState());
            }
            for (int i6 = 0; i6 < this.auxRelay_.size(); i6++) {
                codedOutputStream.writeMessage(AUX_RELAY_FIELD_NUMBER, this.auxRelay_.get(i6));
            }
            for (int i7 = 0; i7 < this.enumValue_.size(); i7++) {
                codedOutputStream.writeMessage(ENUM_VALUE_FIELD_NUMBER, this.enumValue_.get(i7));
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeMessage(USER_MESSAGE_FIELD_NUMBER, getUserMessage());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeMessageSize(1000, getConnectRequest()) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(1001, getDisconnectRequest());
            }
            if ((this.bitField0_ & 4) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(1002, getKeepAlive());
            }
            for (int i2 = 0; i2 < this.generalCommand_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(GENERAL_COMMAND_FIELD_NUMBER, this.generalCommand_.get(i2));
            }
            for (int i3 = 0; i3 < this.integerValue_.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(INTEGER_VALUE_FIELD_NUMBER, this.integerValue_.get(i3));
            }
            for (int i4 = 0; i4 < this.booleanValue_.size(); i4++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(BOOLEAN_VALUE_FIELD_NUMBER, this.booleanValue_.get(i4));
            }
            for (int i5 = 0; i5 < this.favorite_.size(); i5++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(FAVORITE_FIELD_NUMBER, this.favorite_.get(i5));
            }
            for (int i6 = 0; i6 < this.calendarProgram_.size(); i6++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(CALENDAR_PROGRAM_FIELD_NUMBER, this.calendarProgram_.get(i6));
            }
            if ((this.bitField0_ & 16) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(SAUNA_STATE_FIELD_NUMBER, getSaunaState());
            }
            for (int i7 = 0; i7 < this.auxRelay_.size(); i7++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(AUX_RELAY_FIELD_NUMBER, this.auxRelay_.get(i7));
            }
            for (int i8 = 0; i8 < this.enumValue_.size(); i8++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(ENUM_VALUE_FIELD_NUMBER, this.enumValue_.get(i8));
            }
            if ((this.bitField0_ & 8) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(USER_MESSAGE_FIELD_NUMBER, getUserMessage());
            }
            int serializedSize = computeMessageSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof External_to_sauna)) {
                return super.equals(obj);
            }
            External_to_sauna external_to_sauna = (External_to_sauna) obj;
            if (hasConnectRequest() != external_to_sauna.hasConnectRequest()) {
                return false;
            }
            if ((hasConnectRequest() && !getConnectRequest().equals(external_to_sauna.getConnectRequest())) || hasDisconnectRequest() != external_to_sauna.hasDisconnectRequest()) {
                return false;
            }
            if ((hasDisconnectRequest() && !getDisconnectRequest().equals(external_to_sauna.getDisconnectRequest())) || hasKeepAlive() != external_to_sauna.hasKeepAlive()) {
                return false;
            }
            if ((hasKeepAlive() && !getKeepAlive().equals(external_to_sauna.getKeepAlive())) || !getGeneralCommandList().equals(external_to_sauna.getGeneralCommandList()) || !getIntegerValueList().equals(external_to_sauna.getIntegerValueList()) || hasUserMessage() != external_to_sauna.hasUserMessage()) {
                return false;
            }
            if ((!hasUserMessage() || getUserMessage().equals(external_to_sauna.getUserMessage())) && hasSaunaState() == external_to_sauna.hasSaunaState()) {
                return (!hasSaunaState() || getSaunaState().equals(external_to_sauna.getSaunaState())) && getEnumValueList().equals(external_to_sauna.getEnumValueList()) && getFavoriteList().equals(external_to_sauna.getFavoriteList()) && getBooleanValueList().equals(external_to_sauna.getBooleanValueList()) && getAuxRelayList().equals(external_to_sauna.getAuxRelayList()) && getCalendarProgramList().equals(external_to_sauna.getCalendarProgramList()) && getUnknownFields().equals(external_to_sauna.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasConnectRequest()) {
                hashCode = (((hashCode * 37) + 1000) * 53) + getConnectRequest().hashCode();
            }
            if (hasDisconnectRequest()) {
                hashCode = (((hashCode * 37) + 1001) * 53) + getDisconnectRequest().hashCode();
            }
            if (hasKeepAlive()) {
                hashCode = (((hashCode * 37) + 1002) * 53) + getKeepAlive().hashCode();
            }
            if (getGeneralCommandCount() > 0) {
                hashCode = (((hashCode * 37) + GENERAL_COMMAND_FIELD_NUMBER) * 53) + getGeneralCommandList().hashCode();
            }
            if (getIntegerValueCount() > 0) {
                hashCode = (((hashCode * 37) + INTEGER_VALUE_FIELD_NUMBER) * 53) + getIntegerValueList().hashCode();
            }
            if (hasUserMessage()) {
                hashCode = (((hashCode * 37) + USER_MESSAGE_FIELD_NUMBER) * 53) + getUserMessage().hashCode();
            }
            if (hasSaunaState()) {
                hashCode = (((hashCode * 37) + SAUNA_STATE_FIELD_NUMBER) * 53) + getSaunaState().hashCode();
            }
            if (getEnumValueCount() > 0) {
                hashCode = (((hashCode * 37) + ENUM_VALUE_FIELD_NUMBER) * 53) + getEnumValueList().hashCode();
            }
            if (getFavoriteCount() > 0) {
                hashCode = (((hashCode * 37) + FAVORITE_FIELD_NUMBER) * 53) + getFavoriteList().hashCode();
            }
            if (getBooleanValueCount() > 0) {
                hashCode = (((hashCode * 37) + BOOLEAN_VALUE_FIELD_NUMBER) * 53) + getBooleanValueList().hashCode();
            }
            if (getAuxRelayCount() > 0) {
                hashCode = (((hashCode * 37) + AUX_RELAY_FIELD_NUMBER) * 53) + getAuxRelayList().hashCode();
            }
            if (getCalendarProgramCount() > 0) {
                hashCode = (((hashCode * 37) + CALENDAR_PROGRAM_FIELD_NUMBER) * 53) + getCalendarProgramList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static External_to_sauna parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static External_to_sauna parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static External_to_sauna parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static External_to_sauna parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static External_to_sauna parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static External_to_sauna parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static External_to_sauna parseFrom(InputStream inputStream) throws IOException {
            return (External_to_sauna) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static External_to_sauna parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (External_to_sauna) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static External_to_sauna parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (External_to_sauna) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static External_to_sauna parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (External_to_sauna) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static External_to_sauna parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (External_to_sauna) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static External_to_sauna parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (External_to_sauna) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(External_to_sauna external_to_sauna) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(external_to_sauna);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements External_to_saunaOrBuilder {
            private RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> auxRelayBuilder_;
            private List<AuxRelay.Aux_relay_post> auxRelay_;
            private int bitField0_;
            private RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> booleanValueBuilder_;
            private List<BooleanValue.Boolean_value_change_request> booleanValue_;
            private RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> calendarProgramBuilder_;
            private List<Calendar.Calendar_post> calendarProgram_;
            private SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> connectRequestBuilder_;
            private Connect.Connect_request connectRequest_;
            private SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> disconnectRequestBuilder_;
            private Connect.Disconnect_request disconnectRequest_;
            private RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> enumValueBuilder_;
            private List<EnumValue.Enum_value_change_request> enumValue_;
            private RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> favoriteBuilder_;
            private List<Favorite.Favorite_post> favorite_;
            private RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> generalCommandBuilder_;
            private List<Command.General_command> generalCommand_;
            private RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> integerValueBuilder_;
            private List<IntegerValue.Integer_value_change_request> integerValue_;
            private SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> keepAliveBuilder_;
            private Connect.Keep_alive keepAlive_;
            private SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> saunaStateBuilder_;
            private SaunaState.Sauna_state_change_request saunaState_;
            private SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> userMessageBuilder_;
            private UserMessage.User_message userMessage_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Message.internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Message.internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_fieldAccessorTable.ensureFieldAccessorsInitialized(External_to_sauna.class, Builder.class);
            }

            private Builder() {
                this.generalCommand_ = Collections.emptyList();
                this.integerValue_ = Collections.emptyList();
                this.enumValue_ = Collections.emptyList();
                this.favorite_ = Collections.emptyList();
                this.booleanValue_ = Collections.emptyList();
                this.auxRelay_ = Collections.emptyList();
                this.calendarProgram_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.generalCommand_ = Collections.emptyList();
                this.integerValue_ = Collections.emptyList();
                this.enumValue_ = Collections.emptyList();
                this.favorite_ = Collections.emptyList();
                this.booleanValue_ = Collections.emptyList();
                this.auxRelay_ = Collections.emptyList();
                this.calendarProgram_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (External_to_sauna.alwaysUseFieldBuilders) {
                    getConnectRequestFieldBuilder();
                    getDisconnectRequestFieldBuilder();
                    getKeepAliveFieldBuilder();
                    getGeneralCommandFieldBuilder();
                    getIntegerValueFieldBuilder();
                    getUserMessageFieldBuilder();
                    getSaunaStateFieldBuilder();
                    getEnumValueFieldBuilder();
                    getFavoriteFieldBuilder();
                    getBooleanValueFieldBuilder();
                    getAuxRelayFieldBuilder();
                    getCalendarProgramFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.connectRequest_ = null;
                SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> singleFieldBuilderV3 = this.connectRequestBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.connectRequestBuilder_ = null;
                }
                this.disconnectRequest_ = null;
                SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> singleFieldBuilderV32 = this.disconnectRequestBuilder_;
                if (singleFieldBuilderV32 != null) {
                    singleFieldBuilderV32.dispose();
                    this.disconnectRequestBuilder_ = null;
                }
                this.keepAlive_ = null;
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV33 = this.keepAliveBuilder_;
                if (singleFieldBuilderV33 != null) {
                    singleFieldBuilderV33.dispose();
                    this.keepAliveBuilder_ = null;
                }
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.generalCommand_ = Collections.emptyList();
                } else {
                    this.generalCommand_ = null;
                    repeatedFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV32 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV32 == null) {
                    this.integerValue_ = Collections.emptyList();
                } else {
                    this.integerValue_ = null;
                    repeatedFieldBuilderV32.clear();
                }
                this.bitField0_ &= -17;
                this.userMessage_ = null;
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV34 = this.userMessageBuilder_;
                if (singleFieldBuilderV34 != null) {
                    singleFieldBuilderV34.dispose();
                    this.userMessageBuilder_ = null;
                }
                this.saunaState_ = null;
                SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> singleFieldBuilderV35 = this.saunaStateBuilder_;
                if (singleFieldBuilderV35 != null) {
                    singleFieldBuilderV35.dispose();
                    this.saunaStateBuilder_ = null;
                }
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV33 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV33 == null) {
                    this.enumValue_ = Collections.emptyList();
                } else {
                    this.enumValue_ = null;
                    repeatedFieldBuilderV33.clear();
                }
                this.bitField0_ &= -129;
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV34 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV34 == null) {
                    this.favorite_ = Collections.emptyList();
                } else {
                    this.favorite_ = null;
                    repeatedFieldBuilderV34.clear();
                }
                this.bitField0_ &= -257;
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV35 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV35 == null) {
                    this.booleanValue_ = Collections.emptyList();
                } else {
                    this.booleanValue_ = null;
                    repeatedFieldBuilderV35.clear();
                }
                this.bitField0_ &= -513;
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV36 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV36 == null) {
                    this.auxRelay_ = Collections.emptyList();
                } else {
                    this.auxRelay_ = null;
                    repeatedFieldBuilderV36.clear();
                }
                this.bitField0_ &= -1025;
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV37 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV37 == null) {
                    this.calendarProgram_ = Collections.emptyList();
                } else {
                    this.calendarProgram_ = null;
                    repeatedFieldBuilderV37.clear();
                }
                this.bitField0_ &= -2049;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Message.internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public External_to_sauna getDefaultInstanceForType() {
                return External_to_sauna.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public External_to_sauna build() {
                External_to_sauna buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public External_to_sauna buildPartial() {
                External_to_sauna external_to_sauna = new External_to_sauna(this);
                buildPartialRepeatedFields(external_to_sauna);
                if (this.bitField0_ != 0) {
                    buildPartial0(external_to_sauna);
                }
                onBuilt();
                return external_to_sauna;
            }

            private void buildPartialRepeatedFields(External_to_sauna external_to_sauna) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    external_to_sauna.generalCommand_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 8) != 0) {
                        this.generalCommand_ = Collections.unmodifiableList(this.generalCommand_);
                        this.bitField0_ &= -9;
                    }
                    external_to_sauna.generalCommand_ = this.generalCommand_;
                }
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV32 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV32 != null) {
                    external_to_sauna.integerValue_ = repeatedFieldBuilderV32.build();
                } else {
                    if ((this.bitField0_ & 16) != 0) {
                        this.integerValue_ = Collections.unmodifiableList(this.integerValue_);
                        this.bitField0_ &= -17;
                    }
                    external_to_sauna.integerValue_ = this.integerValue_;
                }
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV33 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV33 != null) {
                    external_to_sauna.enumValue_ = repeatedFieldBuilderV33.build();
                } else {
                    if ((this.bitField0_ & 128) != 0) {
                        this.enumValue_ = Collections.unmodifiableList(this.enumValue_);
                        this.bitField0_ &= -129;
                    }
                    external_to_sauna.enumValue_ = this.enumValue_;
                }
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV34 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV34 != null) {
                    external_to_sauna.favorite_ = repeatedFieldBuilderV34.build();
                } else {
                    if ((this.bitField0_ & 256) != 0) {
                        this.favorite_ = Collections.unmodifiableList(this.favorite_);
                        this.bitField0_ &= -257;
                    }
                    external_to_sauna.favorite_ = this.favorite_;
                }
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV35 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV35 != null) {
                    external_to_sauna.booleanValue_ = repeatedFieldBuilderV35.build();
                } else {
                    if ((this.bitField0_ & 512) != 0) {
                        this.booleanValue_ = Collections.unmodifiableList(this.booleanValue_);
                        this.bitField0_ &= -513;
                    }
                    external_to_sauna.booleanValue_ = this.booleanValue_;
                }
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV36 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV36 != null) {
                    external_to_sauna.auxRelay_ = repeatedFieldBuilderV36.build();
                } else {
                    if ((this.bitField0_ & 1024) != 0) {
                        this.auxRelay_ = Collections.unmodifiableList(this.auxRelay_);
                        this.bitField0_ &= -1025;
                    }
                    external_to_sauna.auxRelay_ = this.auxRelay_;
                }
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV37 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV37 != null) {
                    external_to_sauna.calendarProgram_ = repeatedFieldBuilderV37.build();
                    return;
                }
                if ((this.bitField0_ & 2048) != 0) {
                    this.calendarProgram_ = Collections.unmodifiableList(this.calendarProgram_);
                    this.bitField0_ &= -2049;
                }
                external_to_sauna.calendarProgram_ = this.calendarProgram_;
            }

            private void buildPartial0(External_to_sauna external_to_sauna) {
                int i;
                SaunaState.Sauna_state_change_request build;
                UserMessage.User_message build2;
                Connect.Keep_alive build3;
                Connect.Disconnect_request build4;
                Connect.Connect_request build5;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> singleFieldBuilderV3 = this.connectRequestBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        build5 = this.connectRequest_;
                    } else {
                        build5 = singleFieldBuilderV3.build();
                    }
                    external_to_sauna.connectRequest_ = build5;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> singleFieldBuilderV32 = this.disconnectRequestBuilder_;
                    if (singleFieldBuilderV32 == null) {
                        build4 = this.disconnectRequest_;
                    } else {
                        build4 = singleFieldBuilderV32.build();
                    }
                    external_to_sauna.disconnectRequest_ = build4;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV33 = this.keepAliveBuilder_;
                    if (singleFieldBuilderV33 == null) {
                        build3 = this.keepAlive_;
                    } else {
                        build3 = singleFieldBuilderV33.build();
                    }
                    external_to_sauna.keepAlive_ = build3;
                    i |= 4;
                }
                if ((i2 & 32) != 0) {
                    SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV34 = this.userMessageBuilder_;
                    if (singleFieldBuilderV34 == null) {
                        build2 = this.userMessage_;
                    } else {
                        build2 = singleFieldBuilderV34.build();
                    }
                    external_to_sauna.userMessage_ = build2;
                    i |= 8;
                }
                if ((i2 & 64) != 0) {
                    SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> singleFieldBuilderV35 = this.saunaStateBuilder_;
                    if (singleFieldBuilderV35 == null) {
                        build = this.saunaState_;
                    } else {
                        build = singleFieldBuilderV35.build();
                    }
                    external_to_sauna.saunaState_ = build;
                    i |= 16;
                }
                External_to_sauna.access$1876(external_to_sauna, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof External_to_sauna) {
                    return mergeFrom((External_to_sauna) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(External_to_sauna external_to_sauna) {
                if (external_to_sauna == External_to_sauna.getDefaultInstance()) {
                    return this;
                }
                if (external_to_sauna.hasConnectRequest()) {
                    mergeConnectRequest(external_to_sauna.getConnectRequest());
                }
                if (external_to_sauna.hasDisconnectRequest()) {
                    mergeDisconnectRequest(external_to_sauna.getDisconnectRequest());
                }
                if (external_to_sauna.hasKeepAlive()) {
                    mergeKeepAlive(external_to_sauna.getKeepAlive());
                }
                if (this.generalCommandBuilder_ == null) {
                    if (!external_to_sauna.generalCommand_.isEmpty()) {
                        if (this.generalCommand_.isEmpty()) {
                            this.generalCommand_ = external_to_sauna.generalCommand_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureGeneralCommandIsMutable();
                            this.generalCommand_.addAll(external_to_sauna.generalCommand_);
                        }
                        onChanged();
                    }
                } else if (!external_to_sauna.generalCommand_.isEmpty()) {
                    if (!this.generalCommandBuilder_.isEmpty()) {
                        this.generalCommandBuilder_.addAllMessages(external_to_sauna.generalCommand_);
                    } else {
                        this.generalCommandBuilder_.dispose();
                        this.generalCommandBuilder_ = null;
                        this.generalCommand_ = external_to_sauna.generalCommand_;
                        this.bitField0_ &= -9;
                        this.generalCommandBuilder_ = External_to_sauna.alwaysUseFieldBuilders ? getGeneralCommandFieldBuilder() : null;
                    }
                }
                if (this.integerValueBuilder_ == null) {
                    if (!external_to_sauna.integerValue_.isEmpty()) {
                        if (this.integerValue_.isEmpty()) {
                            this.integerValue_ = external_to_sauna.integerValue_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureIntegerValueIsMutable();
                            this.integerValue_.addAll(external_to_sauna.integerValue_);
                        }
                        onChanged();
                    }
                } else if (!external_to_sauna.integerValue_.isEmpty()) {
                    if (!this.integerValueBuilder_.isEmpty()) {
                        this.integerValueBuilder_.addAllMessages(external_to_sauna.integerValue_);
                    } else {
                        this.integerValueBuilder_.dispose();
                        this.integerValueBuilder_ = null;
                        this.integerValue_ = external_to_sauna.integerValue_;
                        this.bitField0_ &= -17;
                        this.integerValueBuilder_ = External_to_sauna.alwaysUseFieldBuilders ? getIntegerValueFieldBuilder() : null;
                    }
                }
                if (external_to_sauna.hasUserMessage()) {
                    mergeUserMessage(external_to_sauna.getUserMessage());
                }
                if (external_to_sauna.hasSaunaState()) {
                    mergeSaunaState(external_to_sauna.getSaunaState());
                }
                if (this.enumValueBuilder_ == null) {
                    if (!external_to_sauna.enumValue_.isEmpty()) {
                        if (this.enumValue_.isEmpty()) {
                            this.enumValue_ = external_to_sauna.enumValue_;
                            this.bitField0_ &= -129;
                        } else {
                            ensureEnumValueIsMutable();
                            this.enumValue_.addAll(external_to_sauna.enumValue_);
                        }
                        onChanged();
                    }
                } else if (!external_to_sauna.enumValue_.isEmpty()) {
                    if (!this.enumValueBuilder_.isEmpty()) {
                        this.enumValueBuilder_.addAllMessages(external_to_sauna.enumValue_);
                    } else {
                        this.enumValueBuilder_.dispose();
                        this.enumValueBuilder_ = null;
                        this.enumValue_ = external_to_sauna.enumValue_;
                        this.bitField0_ &= -129;
                        this.enumValueBuilder_ = External_to_sauna.alwaysUseFieldBuilders ? getEnumValueFieldBuilder() : null;
                    }
                }
                if (this.favoriteBuilder_ == null) {
                    if (!external_to_sauna.favorite_.isEmpty()) {
                        if (this.favorite_.isEmpty()) {
                            this.favorite_ = external_to_sauna.favorite_;
                            this.bitField0_ &= -257;
                        } else {
                            ensureFavoriteIsMutable();
                            this.favorite_.addAll(external_to_sauna.favorite_);
                        }
                        onChanged();
                    }
                } else if (!external_to_sauna.favorite_.isEmpty()) {
                    if (!this.favoriteBuilder_.isEmpty()) {
                        this.favoriteBuilder_.addAllMessages(external_to_sauna.favorite_);
                    } else {
                        this.favoriteBuilder_.dispose();
                        this.favoriteBuilder_ = null;
                        this.favorite_ = external_to_sauna.favorite_;
                        this.bitField0_ &= -257;
                        this.favoriteBuilder_ = External_to_sauna.alwaysUseFieldBuilders ? getFavoriteFieldBuilder() : null;
                    }
                }
                if (this.booleanValueBuilder_ == null) {
                    if (!external_to_sauna.booleanValue_.isEmpty()) {
                        if (this.booleanValue_.isEmpty()) {
                            this.booleanValue_ = external_to_sauna.booleanValue_;
                            this.bitField0_ &= -513;
                        } else {
                            ensureBooleanValueIsMutable();
                            this.booleanValue_.addAll(external_to_sauna.booleanValue_);
                        }
                        onChanged();
                    }
                } else if (!external_to_sauna.booleanValue_.isEmpty()) {
                    if (!this.booleanValueBuilder_.isEmpty()) {
                        this.booleanValueBuilder_.addAllMessages(external_to_sauna.booleanValue_);
                    } else {
                        this.booleanValueBuilder_.dispose();
                        this.booleanValueBuilder_ = null;
                        this.booleanValue_ = external_to_sauna.booleanValue_;
                        this.bitField0_ &= -513;
                        this.booleanValueBuilder_ = External_to_sauna.alwaysUseFieldBuilders ? getBooleanValueFieldBuilder() : null;
                    }
                }
                if (this.auxRelayBuilder_ == null) {
                    if (!external_to_sauna.auxRelay_.isEmpty()) {
                        if (this.auxRelay_.isEmpty()) {
                            this.auxRelay_ = external_to_sauna.auxRelay_;
                            this.bitField0_ &= -1025;
                        } else {
                            ensureAuxRelayIsMutable();
                            this.auxRelay_.addAll(external_to_sauna.auxRelay_);
                        }
                        onChanged();
                    }
                } else if (!external_to_sauna.auxRelay_.isEmpty()) {
                    if (!this.auxRelayBuilder_.isEmpty()) {
                        this.auxRelayBuilder_.addAllMessages(external_to_sauna.auxRelay_);
                    } else {
                        this.auxRelayBuilder_.dispose();
                        this.auxRelayBuilder_ = null;
                        this.auxRelay_ = external_to_sauna.auxRelay_;
                        this.bitField0_ &= -1025;
                        this.auxRelayBuilder_ = External_to_sauna.alwaysUseFieldBuilders ? getAuxRelayFieldBuilder() : null;
                    }
                }
                if (this.calendarProgramBuilder_ == null) {
                    if (!external_to_sauna.calendarProgram_.isEmpty()) {
                        if (this.calendarProgram_.isEmpty()) {
                            this.calendarProgram_ = external_to_sauna.calendarProgram_;
                            this.bitField0_ &= -2049;
                        } else {
                            ensureCalendarProgramIsMutable();
                            this.calendarProgram_.addAll(external_to_sauna.calendarProgram_);
                        }
                        onChanged();
                    }
                } else if (!external_to_sauna.calendarProgram_.isEmpty()) {
                    if (!this.calendarProgramBuilder_.isEmpty()) {
                        this.calendarProgramBuilder_.addAllMessages(external_to_sauna.calendarProgram_);
                    } else {
                        this.calendarProgramBuilder_.dispose();
                        this.calendarProgramBuilder_ = null;
                        this.calendarProgram_ = external_to_sauna.calendarProgram_;
                        this.bitField0_ &= -2049;
                        this.calendarProgramBuilder_ = External_to_sauna.alwaysUseFieldBuilders ? getCalendarProgramFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(external_to_sauna.getUnknownFields());
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
                                case 8002:
                                    codedInputStream.readMessage(getConnectRequestFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 1;
                                case 8010:
                                    codedInputStream.readMessage(getDisconnectRequestFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 2;
                                case 8018:
                                    codedInputStream.readMessage(getKeepAliveFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 4;
                                case 8322:
                                    Command.General_command general_command = (Command.General_command) codedInputStream.readMessage(Command.General_command.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                                    if (repeatedFieldBuilderV3 == null) {
                                        ensureGeneralCommandIsMutable();
                                        this.generalCommand_.add(general_command);
                                    } else {
                                        repeatedFieldBuilderV3.addMessage(general_command);
                                    }
                                case 8402:
                                    IntegerValue.Integer_value_change_request integer_value_change_request = (IntegerValue.Integer_value_change_request) codedInputStream.readMessage(IntegerValue.Integer_value_change_request.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV32 = this.integerValueBuilder_;
                                    if (repeatedFieldBuilderV32 == null) {
                                        ensureIntegerValueIsMutable();
                                        this.integerValue_.add(integer_value_change_request);
                                    } else {
                                        repeatedFieldBuilderV32.addMessage(integer_value_change_request);
                                    }
                                case 8482:
                                    BooleanValue.Boolean_value_change_request boolean_value_change_request = (BooleanValue.Boolean_value_change_request) codedInputStream.readMessage(BooleanValue.Boolean_value_change_request.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV33 = this.booleanValueBuilder_;
                                    if (repeatedFieldBuilderV33 == null) {
                                        ensureBooleanValueIsMutable();
                                        this.booleanValue_.add(boolean_value_change_request);
                                    } else {
                                        repeatedFieldBuilderV33.addMessage(boolean_value_change_request);
                                    }
                                case 8562:
                                    Favorite.Favorite_post favorite_post = (Favorite.Favorite_post) codedInputStream.readMessage(Favorite.Favorite_post.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV34 = this.favoriteBuilder_;
                                    if (repeatedFieldBuilderV34 == null) {
                                        ensureFavoriteIsMutable();
                                        this.favorite_.add(favorite_post);
                                    } else {
                                        repeatedFieldBuilderV34.addMessage(favorite_post);
                                    }
                                case 8602:
                                    Calendar.Calendar_post calendar_post = (Calendar.Calendar_post) codedInputStream.readMessage(Calendar.Calendar_post.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV35 = this.calendarProgramBuilder_;
                                    if (repeatedFieldBuilderV35 == null) {
                                        ensureCalendarProgramIsMutable();
                                        this.calendarProgram_.add(calendar_post);
                                    } else {
                                        repeatedFieldBuilderV35.addMessage(calendar_post);
                                    }
                                case 8642:
                                    codedInputStream.readMessage(getSaunaStateFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 64;
                                case 8722:
                                    AuxRelay.Aux_relay_post aux_relay_post = (AuxRelay.Aux_relay_post) codedInputStream.readMessage(AuxRelay.Aux_relay_post.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV36 = this.auxRelayBuilder_;
                                    if (repeatedFieldBuilderV36 == null) {
                                        ensureAuxRelayIsMutable();
                                        this.auxRelay_.add(aux_relay_post);
                                    } else {
                                        repeatedFieldBuilderV36.addMessage(aux_relay_post);
                                    }
                                case 8882:
                                    EnumValue.Enum_value_change_request enum_value_change_request = (EnumValue.Enum_value_change_request) codedInputStream.readMessage(EnumValue.Enum_value_change_request.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV37 = this.enumValueBuilder_;
                                    if (repeatedFieldBuilderV37 == null) {
                                        ensureEnumValueIsMutable();
                                        this.enumValue_.add(enum_value_change_request);
                                    } else {
                                        repeatedFieldBuilderV37.addMessage(enum_value_change_request);
                                    }
                                case 8962:
                                    codedInputStream.readMessage(getUserMessageFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 32;
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

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public boolean hasConnectRequest() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Connect.Connect_request getConnectRequest() {
                SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> singleFieldBuilderV3 = this.connectRequestBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Connect.Connect_request connect_request = this.connectRequest_;
                    return connect_request == null ? Connect.Connect_request.getDefaultInstance() : connect_request;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setConnectRequest(Connect.Connect_request connect_request) {
                SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> singleFieldBuilderV3 = this.connectRequestBuilder_;
                if (singleFieldBuilderV3 == null) {
                    connect_request.getClass();
                    this.connectRequest_ = connect_request;
                } else {
                    singleFieldBuilderV3.setMessage(connect_request);
                }
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setConnectRequest(Connect.Connect_request.Builder builder) {
                SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> singleFieldBuilderV3 = this.connectRequestBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.connectRequest_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder mergeConnectRequest(Connect.Connect_request connect_request) {
                Connect.Connect_request connect_request2;
                SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> singleFieldBuilderV3 = this.connectRequestBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0 && (connect_request2 = this.connectRequest_) != null && connect_request2 != Connect.Connect_request.getDefaultInstance()) {
                        getConnectRequestBuilder().mergeFrom(connect_request);
                    } else {
                        this.connectRequest_ = connect_request;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(connect_request);
                }
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearConnectRequest() {
                this.bitField0_ &= -2;
                this.connectRequest_ = null;
                SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> singleFieldBuilderV3 = this.connectRequestBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.connectRequestBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Connect.Connect_request.Builder getConnectRequestBuilder() {
                this.bitField0_ |= 1;
                onChanged();
                return getConnectRequestFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Connect.Connect_requestOrBuilder getConnectRequestOrBuilder() {
                SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> singleFieldBuilderV3 = this.connectRequestBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Connect.Connect_request connect_request = this.connectRequest_;
                return connect_request == null ? Connect.Connect_request.getDefaultInstance() : connect_request;
            }

            private SingleFieldBuilderV3<Connect.Connect_request, Connect.Connect_request.Builder, Connect.Connect_requestOrBuilder> getConnectRequestFieldBuilder() {
                if (this.connectRequestBuilder_ == null) {
                    this.connectRequestBuilder_ = new SingleFieldBuilderV3<>(getConnectRequest(), getParentForChildren(), isClean());
                    this.connectRequest_ = null;
                }
                return this.connectRequestBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public boolean hasDisconnectRequest() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Connect.Disconnect_request getDisconnectRequest() {
                SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> singleFieldBuilderV3 = this.disconnectRequestBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Connect.Disconnect_request disconnect_request = this.disconnectRequest_;
                    return disconnect_request == null ? Connect.Disconnect_request.getDefaultInstance() : disconnect_request;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setDisconnectRequest(Connect.Disconnect_request disconnect_request) {
                SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> singleFieldBuilderV3 = this.disconnectRequestBuilder_;
                if (singleFieldBuilderV3 == null) {
                    disconnect_request.getClass();
                    this.disconnectRequest_ = disconnect_request;
                } else {
                    singleFieldBuilderV3.setMessage(disconnect_request);
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setDisconnectRequest(Connect.Disconnect_request.Builder builder) {
                SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> singleFieldBuilderV3 = this.disconnectRequestBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.disconnectRequest_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder mergeDisconnectRequest(Connect.Disconnect_request disconnect_request) {
                Connect.Disconnect_request disconnect_request2;
                SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> singleFieldBuilderV3 = this.disconnectRequestBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) != 0 && (disconnect_request2 = this.disconnectRequest_) != null && disconnect_request2 != Connect.Disconnect_request.getDefaultInstance()) {
                        getDisconnectRequestBuilder().mergeFrom(disconnect_request);
                    } else {
                        this.disconnectRequest_ = disconnect_request;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(disconnect_request);
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearDisconnectRequest() {
                this.bitField0_ &= -3;
                this.disconnectRequest_ = null;
                SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> singleFieldBuilderV3 = this.disconnectRequestBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.disconnectRequestBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Connect.Disconnect_request.Builder getDisconnectRequestBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return getDisconnectRequestFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Connect.Disconnect_requestOrBuilder getDisconnectRequestOrBuilder() {
                SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> singleFieldBuilderV3 = this.disconnectRequestBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Connect.Disconnect_request disconnect_request = this.disconnectRequest_;
                return disconnect_request == null ? Connect.Disconnect_request.getDefaultInstance() : disconnect_request;
            }

            private SingleFieldBuilderV3<Connect.Disconnect_request, Connect.Disconnect_request.Builder, Connect.Disconnect_requestOrBuilder> getDisconnectRequestFieldBuilder() {
                if (this.disconnectRequestBuilder_ == null) {
                    this.disconnectRequestBuilder_ = new SingleFieldBuilderV3<>(getDisconnectRequest(), getParentForChildren(), isClean());
                    this.disconnectRequest_ = null;
                }
                return this.disconnectRequestBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public boolean hasKeepAlive() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Connect.Keep_alive getKeepAlive() {
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Connect.Keep_alive keep_alive = this.keepAlive_;
                    return keep_alive == null ? Connect.Keep_alive.getDefaultInstance() : keep_alive;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setKeepAlive(Connect.Keep_alive keep_alive) {
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 == null) {
                    keep_alive.getClass();
                    this.keepAlive_ = keep_alive;
                } else {
                    singleFieldBuilderV3.setMessage(keep_alive);
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setKeepAlive(Connect.Keep_alive.Builder builder) {
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.keepAlive_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder mergeKeepAlive(Connect.Keep_alive keep_alive) {
                Connect.Keep_alive keep_alive2;
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 4) != 0 && (keep_alive2 = this.keepAlive_) != null && keep_alive2 != Connect.Keep_alive.getDefaultInstance()) {
                        getKeepAliveBuilder().mergeFrom(keep_alive);
                    } else {
                        this.keepAlive_ = keep_alive;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(keep_alive);
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearKeepAlive() {
                this.bitField0_ &= -5;
                this.keepAlive_ = null;
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.keepAliveBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Connect.Keep_alive.Builder getKeepAliveBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return getKeepAliveFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Connect.Keep_aliveOrBuilder getKeepAliveOrBuilder() {
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Connect.Keep_alive keep_alive = this.keepAlive_;
                return keep_alive == null ? Connect.Keep_alive.getDefaultInstance() : keep_alive;
            }

            private SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> getKeepAliveFieldBuilder() {
                if (this.keepAliveBuilder_ == null) {
                    this.keepAliveBuilder_ = new SingleFieldBuilderV3<>(getKeepAlive(), getParentForChildren(), isClean());
                    this.keepAlive_ = null;
                }
                return this.keepAliveBuilder_;
            }

            private void ensureGeneralCommandIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.generalCommand_ = new ArrayList(this.generalCommand_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<Command.General_command> getGeneralCommandList() {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.generalCommand_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public int getGeneralCommandCount() {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.generalCommand_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Command.General_command getGeneralCommand(int i) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.generalCommand_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setGeneralCommand(int i, Command.General_command general_command) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    general_command.getClass();
                    ensureGeneralCommandIsMutable();
                    this.generalCommand_.set(i, general_command);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, general_command);
                }
                return this;
            }

            public Builder setGeneralCommand(int i, Command.General_command.Builder builder) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureGeneralCommandIsMutable();
                    this.generalCommand_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addGeneralCommand(Command.General_command general_command) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    general_command.getClass();
                    ensureGeneralCommandIsMutable();
                    this.generalCommand_.add(general_command);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(general_command);
                }
                return this;
            }

            public Builder addGeneralCommand(int i, Command.General_command general_command) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    general_command.getClass();
                    ensureGeneralCommandIsMutable();
                    this.generalCommand_.add(i, general_command);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, general_command);
                }
                return this;
            }

            public Builder addGeneralCommand(Command.General_command.Builder builder) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureGeneralCommandIsMutable();
                    this.generalCommand_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addGeneralCommand(int i, Command.General_command.Builder builder) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureGeneralCommandIsMutable();
                    this.generalCommand_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllGeneralCommand(Iterable<? extends Command.General_command> iterable) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureGeneralCommandIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.generalCommand_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearGeneralCommand() {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.generalCommand_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeGeneralCommand(int i) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureGeneralCommandIsMutable();
                    this.generalCommand_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Command.General_command.Builder getGeneralCommandBuilder(int i) {
                return getGeneralCommandFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Command.General_commandOrBuilder getGeneralCommandOrBuilder(int i) {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.generalCommand_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<? extends Command.General_commandOrBuilder> getGeneralCommandOrBuilderList() {
                RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> repeatedFieldBuilderV3 = this.generalCommandBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.generalCommand_);
            }

            public Command.General_command.Builder addGeneralCommandBuilder() {
                return getGeneralCommandFieldBuilder().addBuilder(Command.General_command.getDefaultInstance());
            }

            public Command.General_command.Builder addGeneralCommandBuilder(int i) {
                return getGeneralCommandFieldBuilder().addBuilder(i, Command.General_command.getDefaultInstance());
            }

            public List<Command.General_command.Builder> getGeneralCommandBuilderList() {
                return getGeneralCommandFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Command.General_command, Command.General_command.Builder, Command.General_commandOrBuilder> getGeneralCommandFieldBuilder() {
                if (this.generalCommandBuilder_ == null) {
                    this.generalCommandBuilder_ = new RepeatedFieldBuilderV3<>(this.generalCommand_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.generalCommand_ = null;
                }
                return this.generalCommandBuilder_;
            }

            private void ensureIntegerValueIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.integerValue_ = new ArrayList(this.integerValue_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<IntegerValue.Integer_value_change_request> getIntegerValueList() {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.integerValue_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public int getIntegerValueCount() {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.integerValue_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public IntegerValue.Integer_value_change_request getIntegerValue(int i) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.integerValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setIntegerValue(int i, IntegerValue.Integer_value_change_request integer_value_change_request) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    integer_value_change_request.getClass();
                    ensureIntegerValueIsMutable();
                    this.integerValue_.set(i, integer_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, integer_value_change_request);
                }
                return this;
            }

            public Builder setIntegerValue(int i, IntegerValue.Integer_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    this.integerValue_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addIntegerValue(IntegerValue.Integer_value_change_request integer_value_change_request) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    integer_value_change_request.getClass();
                    ensureIntegerValueIsMutable();
                    this.integerValue_.add(integer_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(integer_value_change_request);
                }
                return this;
            }

            public Builder addIntegerValue(int i, IntegerValue.Integer_value_change_request integer_value_change_request) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    integer_value_change_request.getClass();
                    ensureIntegerValueIsMutable();
                    this.integerValue_.add(i, integer_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, integer_value_change_request);
                }
                return this;
            }

            public Builder addIntegerValue(IntegerValue.Integer_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    this.integerValue_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addIntegerValue(int i, IntegerValue.Integer_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    this.integerValue_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllIntegerValue(Iterable<? extends IntegerValue.Integer_value_change_request> iterable) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.integerValue_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearIntegerValue() {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.integerValue_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeIntegerValue(int i) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    this.integerValue_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public IntegerValue.Integer_value_change_request.Builder getIntegerValueBuilder(int i) {
                return getIntegerValueFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public IntegerValue.Integer_value_change_requestOrBuilder getIntegerValueOrBuilder(int i) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.integerValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<? extends IntegerValue.Integer_value_change_requestOrBuilder> getIntegerValueOrBuilderList() {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.integerValue_);
            }

            public IntegerValue.Integer_value_change_request.Builder addIntegerValueBuilder() {
                return getIntegerValueFieldBuilder().addBuilder(IntegerValue.Integer_value_change_request.getDefaultInstance());
            }

            public IntegerValue.Integer_value_change_request.Builder addIntegerValueBuilder(int i) {
                return getIntegerValueFieldBuilder().addBuilder(i, IntegerValue.Integer_value_change_request.getDefaultInstance());
            }

            public List<IntegerValue.Integer_value_change_request.Builder> getIntegerValueBuilderList() {
                return getIntegerValueFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IntegerValue.Integer_value_change_request, IntegerValue.Integer_value_change_request.Builder, IntegerValue.Integer_value_change_requestOrBuilder> getIntegerValueFieldBuilder() {
                if (this.integerValueBuilder_ == null) {
                    this.integerValueBuilder_ = new RepeatedFieldBuilderV3<>(this.integerValue_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.integerValue_ = null;
                }
                return this.integerValueBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public boolean hasUserMessage() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public UserMessage.User_message getUserMessage() {
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 == null) {
                    UserMessage.User_message user_message = this.userMessage_;
                    return user_message == null ? UserMessage.User_message.getDefaultInstance() : user_message;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setUserMessage(UserMessage.User_message user_message) {
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 == null) {
                    user_message.getClass();
                    this.userMessage_ = user_message;
                } else {
                    singleFieldBuilderV3.setMessage(user_message);
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setUserMessage(UserMessage.User_message.Builder builder) {
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.userMessage_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder mergeUserMessage(UserMessage.User_message user_message) {
                UserMessage.User_message user_message2;
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 32) != 0 && (user_message2 = this.userMessage_) != null && user_message2 != UserMessage.User_message.getDefaultInstance()) {
                        getUserMessageBuilder().mergeFrom(user_message);
                    } else {
                        this.userMessage_ = user_message;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(user_message);
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder clearUserMessage() {
                this.bitField0_ &= -33;
                this.userMessage_ = null;
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.userMessageBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public UserMessage.User_message.Builder getUserMessageBuilder() {
                this.bitField0_ |= 32;
                onChanged();
                return getUserMessageFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public UserMessage.User_messageOrBuilder getUserMessageOrBuilder() {
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                UserMessage.User_message user_message = this.userMessage_;
                return user_message == null ? UserMessage.User_message.getDefaultInstance() : user_message;
            }

            private SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> getUserMessageFieldBuilder() {
                if (this.userMessageBuilder_ == null) {
                    this.userMessageBuilder_ = new SingleFieldBuilderV3<>(getUserMessage(), getParentForChildren(), isClean());
                    this.userMessage_ = null;
                }
                return this.userMessageBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public boolean hasSaunaState() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public SaunaState.Sauna_state_change_request getSaunaState() {
                SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SaunaState.Sauna_state_change_request sauna_state_change_request = this.saunaState_;
                    return sauna_state_change_request == null ? SaunaState.Sauna_state_change_request.getDefaultInstance() : sauna_state_change_request;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSaunaState(SaunaState.Sauna_state_change_request sauna_state_change_request) {
                SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sauna_state_change_request.getClass();
                    this.saunaState_ = sauna_state_change_request;
                } else {
                    singleFieldBuilderV3.setMessage(sauna_state_change_request);
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setSaunaState(SaunaState.Sauna_state_change_request.Builder builder) {
                SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.saunaState_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder mergeSaunaState(SaunaState.Sauna_state_change_request sauna_state_change_request) {
                SaunaState.Sauna_state_change_request sauna_state_change_request2;
                SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 64) != 0 && (sauna_state_change_request2 = this.saunaState_) != null && sauna_state_change_request2 != SaunaState.Sauna_state_change_request.getDefaultInstance()) {
                        getSaunaStateBuilder().mergeFrom(sauna_state_change_request);
                    } else {
                        this.saunaState_ = sauna_state_change_request;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(sauna_state_change_request);
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder clearSaunaState() {
                this.bitField0_ &= -65;
                this.saunaState_ = null;
                SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.saunaStateBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public SaunaState.Sauna_state_change_request.Builder getSaunaStateBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return getSaunaStateFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public SaunaState.Sauna_state_change_requestOrBuilder getSaunaStateOrBuilder() {
                SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                SaunaState.Sauna_state_change_request sauna_state_change_request = this.saunaState_;
                return sauna_state_change_request == null ? SaunaState.Sauna_state_change_request.getDefaultInstance() : sauna_state_change_request;
            }

            private SingleFieldBuilderV3<SaunaState.Sauna_state_change_request, SaunaState.Sauna_state_change_request.Builder, SaunaState.Sauna_state_change_requestOrBuilder> getSaunaStateFieldBuilder() {
                if (this.saunaStateBuilder_ == null) {
                    this.saunaStateBuilder_ = new SingleFieldBuilderV3<>(getSaunaState(), getParentForChildren(), isClean());
                    this.saunaState_ = null;
                }
                return this.saunaStateBuilder_;
            }

            private void ensureEnumValueIsMutable() {
                if ((this.bitField0_ & 128) == 0) {
                    this.enumValue_ = new ArrayList(this.enumValue_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<EnumValue.Enum_value_change_request> getEnumValueList() {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.enumValue_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public int getEnumValueCount() {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.enumValue_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public EnumValue.Enum_value_change_request getEnumValue(int i) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.enumValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setEnumValue(int i, EnumValue.Enum_value_change_request enum_value_change_request) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    enum_value_change_request.getClass();
                    ensureEnumValueIsMutable();
                    this.enumValue_.set(i, enum_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, enum_value_change_request);
                }
                return this;
            }

            public Builder setEnumValue(int i, EnumValue.Enum_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    this.enumValue_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addEnumValue(EnumValue.Enum_value_change_request enum_value_change_request) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    enum_value_change_request.getClass();
                    ensureEnumValueIsMutable();
                    this.enumValue_.add(enum_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(enum_value_change_request);
                }
                return this;
            }

            public Builder addEnumValue(int i, EnumValue.Enum_value_change_request enum_value_change_request) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    enum_value_change_request.getClass();
                    ensureEnumValueIsMutable();
                    this.enumValue_.add(i, enum_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, enum_value_change_request);
                }
                return this;
            }

            public Builder addEnumValue(EnumValue.Enum_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    this.enumValue_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addEnumValue(int i, EnumValue.Enum_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    this.enumValue_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllEnumValue(Iterable<? extends EnumValue.Enum_value_change_request> iterable) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.enumValue_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearEnumValue() {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.enumValue_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeEnumValue(int i) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    this.enumValue_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public EnumValue.Enum_value_change_request.Builder getEnumValueBuilder(int i) {
                return getEnumValueFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public EnumValue.Enum_value_change_requestOrBuilder getEnumValueOrBuilder(int i) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.enumValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<? extends EnumValue.Enum_value_change_requestOrBuilder> getEnumValueOrBuilderList() {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.enumValue_);
            }

            public EnumValue.Enum_value_change_request.Builder addEnumValueBuilder() {
                return getEnumValueFieldBuilder().addBuilder(EnumValue.Enum_value_change_request.getDefaultInstance());
            }

            public EnumValue.Enum_value_change_request.Builder addEnumValueBuilder(int i) {
                return getEnumValueFieldBuilder().addBuilder(i, EnumValue.Enum_value_change_request.getDefaultInstance());
            }

            public List<EnumValue.Enum_value_change_request.Builder> getEnumValueBuilderList() {
                return getEnumValueFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EnumValue.Enum_value_change_request, EnumValue.Enum_value_change_request.Builder, EnumValue.Enum_value_change_requestOrBuilder> getEnumValueFieldBuilder() {
                if (this.enumValueBuilder_ == null) {
                    this.enumValueBuilder_ = new RepeatedFieldBuilderV3<>(this.enumValue_, (this.bitField0_ & 128) != 0, getParentForChildren(), isClean());
                    this.enumValue_ = null;
                }
                return this.enumValueBuilder_;
            }

            private void ensureFavoriteIsMutable() {
                if ((this.bitField0_ & 256) == 0) {
                    this.favorite_ = new ArrayList(this.favorite_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<Favorite.Favorite_post> getFavoriteList() {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.favorite_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public int getFavoriteCount() {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.favorite_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Favorite.Favorite_post getFavorite(int i) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.favorite_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setFavorite(int i, Favorite.Favorite_post favorite_post) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    favorite_post.getClass();
                    ensureFavoriteIsMutable();
                    this.favorite_.set(i, favorite_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, favorite_post);
                }
                return this;
            }

            public Builder setFavorite(int i, Favorite.Favorite_post.Builder builder) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    this.favorite_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addFavorite(Favorite.Favorite_post favorite_post) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    favorite_post.getClass();
                    ensureFavoriteIsMutable();
                    this.favorite_.add(favorite_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(favorite_post);
                }
                return this;
            }

            public Builder addFavorite(int i, Favorite.Favorite_post favorite_post) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    favorite_post.getClass();
                    ensureFavoriteIsMutable();
                    this.favorite_.add(i, favorite_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, favorite_post);
                }
                return this;
            }

            public Builder addFavorite(Favorite.Favorite_post.Builder builder) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    this.favorite_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addFavorite(int i, Favorite.Favorite_post.Builder builder) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    this.favorite_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllFavorite(Iterable<? extends Favorite.Favorite_post> iterable) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.favorite_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearFavorite() {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.favorite_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeFavorite(int i) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    this.favorite_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Favorite.Favorite_post.Builder getFavoriteBuilder(int i) {
                return getFavoriteFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Favorite.Favorite_postOrBuilder getFavoriteOrBuilder(int i) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.favorite_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<? extends Favorite.Favorite_postOrBuilder> getFavoriteOrBuilderList() {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.favorite_);
            }

            public Favorite.Favorite_post.Builder addFavoriteBuilder() {
                return getFavoriteFieldBuilder().addBuilder(Favorite.Favorite_post.getDefaultInstance());
            }

            public Favorite.Favorite_post.Builder addFavoriteBuilder(int i) {
                return getFavoriteFieldBuilder().addBuilder(i, Favorite.Favorite_post.getDefaultInstance());
            }

            public List<Favorite.Favorite_post.Builder> getFavoriteBuilderList() {
                return getFavoriteFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> getFavoriteFieldBuilder() {
                if (this.favoriteBuilder_ == null) {
                    this.favoriteBuilder_ = new RepeatedFieldBuilderV3<>(this.favorite_, (this.bitField0_ & 256) != 0, getParentForChildren(), isClean());
                    this.favorite_ = null;
                }
                return this.favoriteBuilder_;
            }

            private void ensureBooleanValueIsMutable() {
                if ((this.bitField0_ & 512) == 0) {
                    this.booleanValue_ = new ArrayList(this.booleanValue_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<BooleanValue.Boolean_value_change_request> getBooleanValueList() {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.booleanValue_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public int getBooleanValueCount() {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.booleanValue_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public BooleanValue.Boolean_value_change_request getBooleanValue(int i) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.booleanValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setBooleanValue(int i, BooleanValue.Boolean_value_change_request boolean_value_change_request) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    boolean_value_change_request.getClass();
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.set(i, boolean_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, boolean_value_change_request);
                }
                return this;
            }

            public Builder setBooleanValue(int i, BooleanValue.Boolean_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addBooleanValue(BooleanValue.Boolean_value_change_request boolean_value_change_request) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    boolean_value_change_request.getClass();
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.add(boolean_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(boolean_value_change_request);
                }
                return this;
            }

            public Builder addBooleanValue(int i, BooleanValue.Boolean_value_change_request boolean_value_change_request) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    boolean_value_change_request.getClass();
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.add(i, boolean_value_change_request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, boolean_value_change_request);
                }
                return this;
            }

            public Builder addBooleanValue(BooleanValue.Boolean_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addBooleanValue(int i, BooleanValue.Boolean_value_change_request.Builder builder) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllBooleanValue(Iterable<? extends BooleanValue.Boolean_value_change_request> iterable) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.booleanValue_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearBooleanValue() {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.booleanValue_ = Collections.emptyList();
                    this.bitField0_ &= -513;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeBooleanValue(int i) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public BooleanValue.Boolean_value_change_request.Builder getBooleanValueBuilder(int i) {
                return getBooleanValueFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public BooleanValue.Boolean_value_change_requestOrBuilder getBooleanValueOrBuilder(int i) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.booleanValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<? extends BooleanValue.Boolean_value_change_requestOrBuilder> getBooleanValueOrBuilderList() {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.booleanValue_);
            }

            public BooleanValue.Boolean_value_change_request.Builder addBooleanValueBuilder() {
                return getBooleanValueFieldBuilder().addBuilder(BooleanValue.Boolean_value_change_request.getDefaultInstance());
            }

            public BooleanValue.Boolean_value_change_request.Builder addBooleanValueBuilder(int i) {
                return getBooleanValueFieldBuilder().addBuilder(i, BooleanValue.Boolean_value_change_request.getDefaultInstance());
            }

            public List<BooleanValue.Boolean_value_change_request.Builder> getBooleanValueBuilderList() {
                return getBooleanValueFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BooleanValue.Boolean_value_change_request, BooleanValue.Boolean_value_change_request.Builder, BooleanValue.Boolean_value_change_requestOrBuilder> getBooleanValueFieldBuilder() {
                if (this.booleanValueBuilder_ == null) {
                    this.booleanValueBuilder_ = new RepeatedFieldBuilderV3<>(this.booleanValue_, (this.bitField0_ & 512) != 0, getParentForChildren(), isClean());
                    this.booleanValue_ = null;
                }
                return this.booleanValueBuilder_;
            }

            private void ensureAuxRelayIsMutable() {
                if ((this.bitField0_ & 1024) == 0) {
                    this.auxRelay_ = new ArrayList(this.auxRelay_);
                    this.bitField0_ |= 1024;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<AuxRelay.Aux_relay_post> getAuxRelayList() {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.auxRelay_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public int getAuxRelayCount() {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.auxRelay_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public AuxRelay.Aux_relay_post getAuxRelay(int i) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.auxRelay_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setAuxRelay(int i, AuxRelay.Aux_relay_post aux_relay_post) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    aux_relay_post.getClass();
                    ensureAuxRelayIsMutable();
                    this.auxRelay_.set(i, aux_relay_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, aux_relay_post);
                }
                return this;
            }

            public Builder setAuxRelay(int i, AuxRelay.Aux_relay_post.Builder builder) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelayIsMutable();
                    this.auxRelay_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAuxRelay(AuxRelay.Aux_relay_post aux_relay_post) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    aux_relay_post.getClass();
                    ensureAuxRelayIsMutable();
                    this.auxRelay_.add(aux_relay_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(aux_relay_post);
                }
                return this;
            }

            public Builder addAuxRelay(int i, AuxRelay.Aux_relay_post aux_relay_post) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    aux_relay_post.getClass();
                    ensureAuxRelayIsMutable();
                    this.auxRelay_.add(i, aux_relay_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, aux_relay_post);
                }
                return this;
            }

            public Builder addAuxRelay(AuxRelay.Aux_relay_post.Builder builder) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelayIsMutable();
                    this.auxRelay_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addAuxRelay(int i, AuxRelay.Aux_relay_post.Builder builder) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelayIsMutable();
                    this.auxRelay_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllAuxRelay(Iterable<? extends AuxRelay.Aux_relay_post> iterable) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelayIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.auxRelay_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearAuxRelay() {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.auxRelay_ = Collections.emptyList();
                    this.bitField0_ &= -1025;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeAuxRelay(int i) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelayIsMutable();
                    this.auxRelay_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public AuxRelay.Aux_relay_post.Builder getAuxRelayBuilder(int i) {
                return getAuxRelayFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public AuxRelay.Aux_relay_postOrBuilder getAuxRelayOrBuilder(int i) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.auxRelay_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<? extends AuxRelay.Aux_relay_postOrBuilder> getAuxRelayOrBuilderList() {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> repeatedFieldBuilderV3 = this.auxRelayBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.auxRelay_);
            }

            public AuxRelay.Aux_relay_post.Builder addAuxRelayBuilder() {
                return getAuxRelayFieldBuilder().addBuilder(AuxRelay.Aux_relay_post.getDefaultInstance());
            }

            public AuxRelay.Aux_relay_post.Builder addAuxRelayBuilder(int i) {
                return getAuxRelayFieldBuilder().addBuilder(i, AuxRelay.Aux_relay_post.getDefaultInstance());
            }

            public List<AuxRelay.Aux_relay_post.Builder> getAuxRelayBuilderList() {
                return getAuxRelayFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post, AuxRelay.Aux_relay_post.Builder, AuxRelay.Aux_relay_postOrBuilder> getAuxRelayFieldBuilder() {
                if (this.auxRelayBuilder_ == null) {
                    this.auxRelayBuilder_ = new RepeatedFieldBuilderV3<>(this.auxRelay_, (this.bitField0_ & 1024) != 0, getParentForChildren(), isClean());
                    this.auxRelay_ = null;
                }
                return this.auxRelayBuilder_;
            }

            private void ensureCalendarProgramIsMutable() {
                if ((this.bitField0_ & 2048) == 0) {
                    this.calendarProgram_ = new ArrayList(this.calendarProgram_);
                    this.bitField0_ |= 2048;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<Calendar.Calendar_post> getCalendarProgramList() {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.calendarProgram_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public int getCalendarProgramCount() {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.calendarProgram_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Calendar.Calendar_post getCalendarProgram(int i) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.calendarProgram_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setCalendarProgram(int i, Calendar.Calendar_post calendar_post) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    calendar_post.getClass();
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.set(i, calendar_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, calendar_post);
                }
                return this;
            }

            public Builder setCalendarProgram(int i, Calendar.Calendar_post.Builder builder) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addCalendarProgram(Calendar.Calendar_post calendar_post) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    calendar_post.getClass();
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.add(calendar_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(calendar_post);
                }
                return this;
            }

            public Builder addCalendarProgram(int i, Calendar.Calendar_post calendar_post) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    calendar_post.getClass();
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.add(i, calendar_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, calendar_post);
                }
                return this;
            }

            public Builder addCalendarProgram(Calendar.Calendar_post.Builder builder) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addCalendarProgram(int i, Calendar.Calendar_post.Builder builder) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllCalendarProgram(Iterable<? extends Calendar.Calendar_post> iterable) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.calendarProgram_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearCalendarProgram() {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.calendarProgram_ = Collections.emptyList();
                    this.bitField0_ &= -2049;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeCalendarProgram(int i) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Calendar.Calendar_post.Builder getCalendarProgramBuilder(int i) {
                return getCalendarProgramFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public Calendar.Calendar_postOrBuilder getCalendarProgramOrBuilder(int i) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.calendarProgram_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.External_to_saunaOrBuilder
            public List<? extends Calendar.Calendar_postOrBuilder> getCalendarProgramOrBuilderList() {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.calendarProgram_);
            }

            public Calendar.Calendar_post.Builder addCalendarProgramBuilder() {
                return getCalendarProgramFieldBuilder().addBuilder(Calendar.Calendar_post.getDefaultInstance());
            }

            public Calendar.Calendar_post.Builder addCalendarProgramBuilder(int i) {
                return getCalendarProgramFieldBuilder().addBuilder(i, Calendar.Calendar_post.getDefaultInstance());
            }

            public List<Calendar.Calendar_post.Builder> getCalendarProgramBuilderList() {
                return getCalendarProgramFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> getCalendarProgramFieldBuilder() {
                if (this.calendarProgramBuilder_ == null) {
                    this.calendarProgramBuilder_ = new RepeatedFieldBuilderV3<>(this.calendarProgram_, (this.bitField0_ & 2048) != 0, getParentForChildren(), isClean());
                    this.calendarProgram_ = null;
                }
                return this.calendarProgramBuilder_;
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

        public static External_to_sauna getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<External_to_sauna> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<External_to_sauna> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public External_to_sauna getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Sauna_to_external extends GeneratedMessageV3 implements Sauna_to_externalOrBuilder {
        public static final int AUX_RELAY_SAUNA_FIELD_NUMBER = 2070;
        public static final int BOOLEAN_VALUE_FIELD_NUMBER = 2011;
        public static final int CALENDAR_PROGRAM_FIELD_NUMBER = 2045;
        public static final int CONNECT_REPLY_FIELD_NUMBER = 2000;
        public static final int ENUM_VALUE_FIELD_NUMBER = 2100;
        public static final int FAVORITE_FIELD_NUMBER = 2040;
        public static final int INTEGER_VALUE_FIELD_NUMBER = 2010;
        public static final int KEEP_ALIVE_FIELD_NUMBER = 2002;
        public static final int NO_CONNECTION_FIELD_NUMBER = 2001;
        public static final int PRESENTED_VALUE_FIELD_NUMBER = 2030;
        public static final int SAUNA_STATE_FIELD_NUMBER = 2050;
        public static final int USER_MESSAGE_FIELD_NUMBER = 2110;
        public static final int USER_SETTING_FIELD_NUMBER = 2020;
        private static final long serialVersionUID = 0;
        private List<AuxRelay.Aux_relay_post_sauna> auxRelaySauna_;
        private int bitField0_;
        private List<BooleanValue.Boolean_value_changed> booleanValue_;
        private List<Calendar.Calendar_post> calendarProgram_;
        private Connect.Connect_reply connectReply_;
        private List<EnumValue.Enum_value_changed> enumValue_;
        private List<Favorite.Favorite_post> favorite_;
        private List<IntegerValue.Integer_value_changed> integerValue_;
        private Connect.Keep_alive keepAlive_;
        private byte memoizedIsInitialized;
        private Connect.No_connection noConnection_;
        private PresentedValue.Presented_value presentedValue_;
        private SaunaState.Sauna_state_changed saunaState_;
        private UserMessage.User_message userMessage_;
        private UserSetting.User_setting userSetting_;
        private static final Sauna_to_external DEFAULT_INSTANCE = new Sauna_to_external();

        @Deprecated
        public static final Parser<Sauna_to_external> PARSER = new AbstractParser<Sauna_to_external>() { // from class: com.tylohelo.tylohelo.protobuf.Message.Sauna_to_external.1
            @Override // com.google.protobuf.Parser
            public Sauna_to_external parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Sauna_to_external.newBuilder();
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

        static /* synthetic */ int access$4576(Sauna_to_external sauna_to_external, int i) {
            int i2 = i | sauna_to_external.bitField0_;
            sauna_to_external.bitField0_ = i2;
            return i2;
        }

        private Sauna_to_external(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Sauna_to_external() {
            this.memoizedIsInitialized = (byte) -1;
            this.integerValue_ = Collections.emptyList();
            this.enumValue_ = Collections.emptyList();
            this.booleanValue_ = Collections.emptyList();
            this.favorite_ = Collections.emptyList();
            this.auxRelaySauna_ = Collections.emptyList();
            this.calendarProgram_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Sauna_to_external();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Message.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Message.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_fieldAccessorTable.ensureFieldAccessorsInitialized(Sauna_to_external.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public boolean hasConnectReply() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Connect.Connect_reply getConnectReply() {
            Connect.Connect_reply connect_reply = this.connectReply_;
            return connect_reply == null ? Connect.Connect_reply.getDefaultInstance() : connect_reply;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Connect.Connect_replyOrBuilder getConnectReplyOrBuilder() {
            Connect.Connect_reply connect_reply = this.connectReply_;
            return connect_reply == null ? Connect.Connect_reply.getDefaultInstance() : connect_reply;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public boolean hasNoConnection() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Connect.No_connection getNoConnection() {
            Connect.No_connection no_connection = this.noConnection_;
            return no_connection == null ? Connect.No_connection.getDefaultInstance() : no_connection;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Connect.No_connectionOrBuilder getNoConnectionOrBuilder() {
            Connect.No_connection no_connection = this.noConnection_;
            return no_connection == null ? Connect.No_connection.getDefaultInstance() : no_connection;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public boolean hasKeepAlive() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Connect.Keep_alive getKeepAlive() {
            Connect.Keep_alive keep_alive = this.keepAlive_;
            return keep_alive == null ? Connect.Keep_alive.getDefaultInstance() : keep_alive;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Connect.Keep_aliveOrBuilder getKeepAliveOrBuilder() {
            Connect.Keep_alive keep_alive = this.keepAlive_;
            return keep_alive == null ? Connect.Keep_alive.getDefaultInstance() : keep_alive;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<IntegerValue.Integer_value_changed> getIntegerValueList() {
            return this.integerValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<? extends IntegerValue.Integer_value_changedOrBuilder> getIntegerValueOrBuilderList() {
            return this.integerValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public int getIntegerValueCount() {
            return this.integerValue_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public IntegerValue.Integer_value_changed getIntegerValue(int i) {
            return this.integerValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public IntegerValue.Integer_value_changedOrBuilder getIntegerValueOrBuilder(int i) {
            return this.integerValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public boolean hasPresentedValue() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public PresentedValue.Presented_value getPresentedValue() {
            PresentedValue.Presented_value presented_value = this.presentedValue_;
            return presented_value == null ? PresentedValue.Presented_value.getDefaultInstance() : presented_value;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public PresentedValue.Presented_valueOrBuilder getPresentedValueOrBuilder() {
            PresentedValue.Presented_value presented_value = this.presentedValue_;
            return presented_value == null ? PresentedValue.Presented_value.getDefaultInstance() : presented_value;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public boolean hasUserMessage() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public UserMessage.User_message getUserMessage() {
            UserMessage.User_message user_message = this.userMessage_;
            return user_message == null ? UserMessage.User_message.getDefaultInstance() : user_message;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public UserMessage.User_messageOrBuilder getUserMessageOrBuilder() {
            UserMessage.User_message user_message = this.userMessage_;
            return user_message == null ? UserMessage.User_message.getDefaultInstance() : user_message;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public boolean hasUserSetting() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public UserSetting.User_setting getUserSetting() {
            UserSetting.User_setting user_setting = this.userSetting_;
            return user_setting == null ? UserSetting.User_setting.getDefaultInstance() : user_setting;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public UserSetting.User_settingOrBuilder getUserSettingOrBuilder() {
            UserSetting.User_setting user_setting = this.userSetting_;
            return user_setting == null ? UserSetting.User_setting.getDefaultInstance() : user_setting;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public boolean hasSaunaState() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public SaunaState.Sauna_state_changed getSaunaState() {
            SaunaState.Sauna_state_changed sauna_state_changed = this.saunaState_;
            return sauna_state_changed == null ? SaunaState.Sauna_state_changed.getDefaultInstance() : sauna_state_changed;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public SaunaState.Sauna_state_changedOrBuilder getSaunaStateOrBuilder() {
            SaunaState.Sauna_state_changed sauna_state_changed = this.saunaState_;
            return sauna_state_changed == null ? SaunaState.Sauna_state_changed.getDefaultInstance() : sauna_state_changed;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<EnumValue.Enum_value_changed> getEnumValueList() {
            return this.enumValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<? extends EnumValue.Enum_value_changedOrBuilder> getEnumValueOrBuilderList() {
            return this.enumValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public int getEnumValueCount() {
            return this.enumValue_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public EnumValue.Enum_value_changed getEnumValue(int i) {
            return this.enumValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public EnumValue.Enum_value_changedOrBuilder getEnumValueOrBuilder(int i) {
            return this.enumValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<BooleanValue.Boolean_value_changed> getBooleanValueList() {
            return this.booleanValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<? extends BooleanValue.Boolean_value_changedOrBuilder> getBooleanValueOrBuilderList() {
            return this.booleanValue_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public int getBooleanValueCount() {
            return this.booleanValue_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public BooleanValue.Boolean_value_changed getBooleanValue(int i) {
            return this.booleanValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public BooleanValue.Boolean_value_changedOrBuilder getBooleanValueOrBuilder(int i) {
            return this.booleanValue_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<Favorite.Favorite_post> getFavoriteList() {
            return this.favorite_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<? extends Favorite.Favorite_postOrBuilder> getFavoriteOrBuilderList() {
            return this.favorite_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public int getFavoriteCount() {
            return this.favorite_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Favorite.Favorite_post getFavorite(int i) {
            return this.favorite_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Favorite.Favorite_postOrBuilder getFavoriteOrBuilder(int i) {
            return this.favorite_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<AuxRelay.Aux_relay_post_sauna> getAuxRelaySaunaList() {
            return this.auxRelaySauna_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<? extends AuxRelay.Aux_relay_post_saunaOrBuilder> getAuxRelaySaunaOrBuilderList() {
            return this.auxRelaySauna_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public int getAuxRelaySaunaCount() {
            return this.auxRelaySauna_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public AuxRelay.Aux_relay_post_sauna getAuxRelaySauna(int i) {
            return this.auxRelaySauna_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public AuxRelay.Aux_relay_post_saunaOrBuilder getAuxRelaySaunaOrBuilder(int i) {
            return this.auxRelaySauna_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<Calendar.Calendar_post> getCalendarProgramList() {
            return this.calendarProgram_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public List<? extends Calendar.Calendar_postOrBuilder> getCalendarProgramOrBuilderList() {
            return this.calendarProgram_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public int getCalendarProgramCount() {
            return this.calendarProgram_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Calendar.Calendar_post getCalendarProgram(int i) {
            return this.calendarProgram_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
        public Calendar.Calendar_postOrBuilder getCalendarProgramOrBuilder(int i) {
            return this.calendarProgram_.get(i);
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
                codedOutputStream.writeMessage(CONNECT_REPLY_FIELD_NUMBER, getConnectReply());
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeMessage(NO_CONNECTION_FIELD_NUMBER, getNoConnection());
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeMessage(KEEP_ALIVE_FIELD_NUMBER, getKeepAlive());
            }
            for (int i = 0; i < this.integerValue_.size(); i++) {
                codedOutputStream.writeMessage(INTEGER_VALUE_FIELD_NUMBER, this.integerValue_.get(i));
            }
            for (int i2 = 0; i2 < this.booleanValue_.size(); i2++) {
                codedOutputStream.writeMessage(BOOLEAN_VALUE_FIELD_NUMBER, this.booleanValue_.get(i2));
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.writeMessage(USER_SETTING_FIELD_NUMBER, getUserSetting());
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeMessage(PRESENTED_VALUE_FIELD_NUMBER, getPresentedValue());
            }
            for (int i3 = 0; i3 < this.favorite_.size(); i3++) {
                codedOutputStream.writeMessage(FAVORITE_FIELD_NUMBER, this.favorite_.get(i3));
            }
            for (int i4 = 0; i4 < this.calendarProgram_.size(); i4++) {
                codedOutputStream.writeMessage(CALENDAR_PROGRAM_FIELD_NUMBER, this.calendarProgram_.get(i4));
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputStream.writeMessage(SAUNA_STATE_FIELD_NUMBER, getSaunaState());
            }
            for (int i5 = 0; i5 < this.auxRelaySauna_.size(); i5++) {
                codedOutputStream.writeMessage(AUX_RELAY_SAUNA_FIELD_NUMBER, this.auxRelaySauna_.get(i5));
            }
            for (int i6 = 0; i6 < this.enumValue_.size(); i6++) {
                codedOutputStream.writeMessage(ENUM_VALUE_FIELD_NUMBER, this.enumValue_.get(i6));
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.writeMessage(USER_MESSAGE_FIELD_NUMBER, getUserMessage());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeMessageSize(CONNECT_REPLY_FIELD_NUMBER, getConnectReply()) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(NO_CONNECTION_FIELD_NUMBER, getNoConnection());
            }
            if ((this.bitField0_ & 4) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(KEEP_ALIVE_FIELD_NUMBER, getKeepAlive());
            }
            for (int i2 = 0; i2 < this.integerValue_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(INTEGER_VALUE_FIELD_NUMBER, this.integerValue_.get(i2));
            }
            for (int i3 = 0; i3 < this.booleanValue_.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(BOOLEAN_VALUE_FIELD_NUMBER, this.booleanValue_.get(i3));
            }
            if ((this.bitField0_ & 32) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(USER_SETTING_FIELD_NUMBER, getUserSetting());
            }
            if ((this.bitField0_ & 8) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(PRESENTED_VALUE_FIELD_NUMBER, getPresentedValue());
            }
            for (int i4 = 0; i4 < this.favorite_.size(); i4++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(FAVORITE_FIELD_NUMBER, this.favorite_.get(i4));
            }
            for (int i5 = 0; i5 < this.calendarProgram_.size(); i5++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(CALENDAR_PROGRAM_FIELD_NUMBER, this.calendarProgram_.get(i5));
            }
            if ((this.bitField0_ & 64) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(SAUNA_STATE_FIELD_NUMBER, getSaunaState());
            }
            for (int i6 = 0; i6 < this.auxRelaySauna_.size(); i6++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(AUX_RELAY_SAUNA_FIELD_NUMBER, this.auxRelaySauna_.get(i6));
            }
            for (int i7 = 0; i7 < this.enumValue_.size(); i7++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(ENUM_VALUE_FIELD_NUMBER, this.enumValue_.get(i7));
            }
            if ((this.bitField0_ & 16) != 0) {
                computeMessageSize += CodedOutputStream.computeMessageSize(USER_MESSAGE_FIELD_NUMBER, getUserMessage());
            }
            int serializedSize = computeMessageSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Sauna_to_external)) {
                return super.equals(obj);
            }
            Sauna_to_external sauna_to_external = (Sauna_to_external) obj;
            if (hasConnectReply() != sauna_to_external.hasConnectReply()) {
                return false;
            }
            if ((hasConnectReply() && !getConnectReply().equals(sauna_to_external.getConnectReply())) || hasNoConnection() != sauna_to_external.hasNoConnection()) {
                return false;
            }
            if ((hasNoConnection() && !getNoConnection().equals(sauna_to_external.getNoConnection())) || hasKeepAlive() != sauna_to_external.hasKeepAlive()) {
                return false;
            }
            if ((hasKeepAlive() && !getKeepAlive().equals(sauna_to_external.getKeepAlive())) || !getIntegerValueList().equals(sauna_to_external.getIntegerValueList()) || hasPresentedValue() != sauna_to_external.hasPresentedValue()) {
                return false;
            }
            if ((hasPresentedValue() && !getPresentedValue().equals(sauna_to_external.getPresentedValue())) || hasUserMessage() != sauna_to_external.hasUserMessage()) {
                return false;
            }
            if ((hasUserMessage() && !getUserMessage().equals(sauna_to_external.getUserMessage())) || hasUserSetting() != sauna_to_external.hasUserSetting()) {
                return false;
            }
            if ((!hasUserSetting() || getUserSetting().equals(sauna_to_external.getUserSetting())) && hasSaunaState() == sauna_to_external.hasSaunaState()) {
                return (!hasSaunaState() || getSaunaState().equals(sauna_to_external.getSaunaState())) && getEnumValueList().equals(sauna_to_external.getEnumValueList()) && getBooleanValueList().equals(sauna_to_external.getBooleanValueList()) && getFavoriteList().equals(sauna_to_external.getFavoriteList()) && getAuxRelaySaunaList().equals(sauna_to_external.getAuxRelaySaunaList()) && getCalendarProgramList().equals(sauna_to_external.getCalendarProgramList()) && getUnknownFields().equals(sauna_to_external.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasConnectReply()) {
                hashCode = (((hashCode * 37) + CONNECT_REPLY_FIELD_NUMBER) * 53) + getConnectReply().hashCode();
            }
            if (hasNoConnection()) {
                hashCode = (((hashCode * 37) + NO_CONNECTION_FIELD_NUMBER) * 53) + getNoConnection().hashCode();
            }
            if (hasKeepAlive()) {
                hashCode = (((hashCode * 37) + KEEP_ALIVE_FIELD_NUMBER) * 53) + getKeepAlive().hashCode();
            }
            if (getIntegerValueCount() > 0) {
                hashCode = (((hashCode * 37) + INTEGER_VALUE_FIELD_NUMBER) * 53) + getIntegerValueList().hashCode();
            }
            if (hasPresentedValue()) {
                hashCode = (((hashCode * 37) + PRESENTED_VALUE_FIELD_NUMBER) * 53) + getPresentedValue().hashCode();
            }
            if (hasUserMessage()) {
                hashCode = (((hashCode * 37) + USER_MESSAGE_FIELD_NUMBER) * 53) + getUserMessage().hashCode();
            }
            if (hasUserSetting()) {
                hashCode = (((hashCode * 37) + USER_SETTING_FIELD_NUMBER) * 53) + getUserSetting().hashCode();
            }
            if (hasSaunaState()) {
                hashCode = (((hashCode * 37) + SAUNA_STATE_FIELD_NUMBER) * 53) + getSaunaState().hashCode();
            }
            if (getEnumValueCount() > 0) {
                hashCode = (((hashCode * 37) + ENUM_VALUE_FIELD_NUMBER) * 53) + getEnumValueList().hashCode();
            }
            if (getBooleanValueCount() > 0) {
                hashCode = (((hashCode * 37) + BOOLEAN_VALUE_FIELD_NUMBER) * 53) + getBooleanValueList().hashCode();
            }
            if (getFavoriteCount() > 0) {
                hashCode = (((hashCode * 37) + FAVORITE_FIELD_NUMBER) * 53) + getFavoriteList().hashCode();
            }
            if (getAuxRelaySaunaCount() > 0) {
                hashCode = (((hashCode * 37) + AUX_RELAY_SAUNA_FIELD_NUMBER) * 53) + getAuxRelaySaunaList().hashCode();
            }
            if (getCalendarProgramCount() > 0) {
                hashCode = (((hashCode * 37) + CALENDAR_PROGRAM_FIELD_NUMBER) * 53) + getCalendarProgramList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Sauna_to_external parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Sauna_to_external parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Sauna_to_external parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Sauna_to_external parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Sauna_to_external parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Sauna_to_external parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Sauna_to_external parseFrom(InputStream inputStream) throws IOException {
            return (Sauna_to_external) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Sauna_to_external parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_to_external) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Sauna_to_external parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Sauna_to_external) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Sauna_to_external parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_to_external) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Sauna_to_external parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Sauna_to_external) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Sauna_to_external parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_to_external) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Sauna_to_external sauna_to_external) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sauna_to_external);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Sauna_to_externalOrBuilder {
            private RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> auxRelaySaunaBuilder_;
            private List<AuxRelay.Aux_relay_post_sauna> auxRelaySauna_;
            private int bitField0_;
            private RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> booleanValueBuilder_;
            private List<BooleanValue.Boolean_value_changed> booleanValue_;
            private RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> calendarProgramBuilder_;
            private List<Calendar.Calendar_post> calendarProgram_;
            private SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> connectReplyBuilder_;
            private Connect.Connect_reply connectReply_;
            private RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> enumValueBuilder_;
            private List<EnumValue.Enum_value_changed> enumValue_;
            private RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> favoriteBuilder_;
            private List<Favorite.Favorite_post> favorite_;
            private RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> integerValueBuilder_;
            private List<IntegerValue.Integer_value_changed> integerValue_;
            private SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> keepAliveBuilder_;
            private Connect.Keep_alive keepAlive_;
            private SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> noConnectionBuilder_;
            private Connect.No_connection noConnection_;
            private SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> presentedValueBuilder_;
            private PresentedValue.Presented_value presentedValue_;
            private SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> saunaStateBuilder_;
            private SaunaState.Sauna_state_changed saunaState_;
            private SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> userMessageBuilder_;
            private UserMessage.User_message userMessage_;
            private SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> userSettingBuilder_;
            private UserSetting.User_setting userSetting_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Message.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Message.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_fieldAccessorTable.ensureFieldAccessorsInitialized(Sauna_to_external.class, Builder.class);
            }

            private Builder() {
                this.integerValue_ = Collections.emptyList();
                this.enumValue_ = Collections.emptyList();
                this.booleanValue_ = Collections.emptyList();
                this.favorite_ = Collections.emptyList();
                this.auxRelaySauna_ = Collections.emptyList();
                this.calendarProgram_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.integerValue_ = Collections.emptyList();
                this.enumValue_ = Collections.emptyList();
                this.booleanValue_ = Collections.emptyList();
                this.favorite_ = Collections.emptyList();
                this.auxRelaySauna_ = Collections.emptyList();
                this.calendarProgram_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Sauna_to_external.alwaysUseFieldBuilders) {
                    getConnectReplyFieldBuilder();
                    getNoConnectionFieldBuilder();
                    getKeepAliveFieldBuilder();
                    getIntegerValueFieldBuilder();
                    getPresentedValueFieldBuilder();
                    getUserMessageFieldBuilder();
                    getUserSettingFieldBuilder();
                    getSaunaStateFieldBuilder();
                    getEnumValueFieldBuilder();
                    getBooleanValueFieldBuilder();
                    getFavoriteFieldBuilder();
                    getAuxRelaySaunaFieldBuilder();
                    getCalendarProgramFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.connectReply_ = null;
                SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> singleFieldBuilderV3 = this.connectReplyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.connectReplyBuilder_ = null;
                }
                this.noConnection_ = null;
                SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> singleFieldBuilderV32 = this.noConnectionBuilder_;
                if (singleFieldBuilderV32 != null) {
                    singleFieldBuilderV32.dispose();
                    this.noConnectionBuilder_ = null;
                }
                this.keepAlive_ = null;
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV33 = this.keepAliveBuilder_;
                if (singleFieldBuilderV33 != null) {
                    singleFieldBuilderV33.dispose();
                    this.keepAliveBuilder_ = null;
                }
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.integerValue_ = Collections.emptyList();
                } else {
                    this.integerValue_ = null;
                    repeatedFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                this.presentedValue_ = null;
                SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> singleFieldBuilderV34 = this.presentedValueBuilder_;
                if (singleFieldBuilderV34 != null) {
                    singleFieldBuilderV34.dispose();
                    this.presentedValueBuilder_ = null;
                }
                this.userMessage_ = null;
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV35 = this.userMessageBuilder_;
                if (singleFieldBuilderV35 != null) {
                    singleFieldBuilderV35.dispose();
                    this.userMessageBuilder_ = null;
                }
                this.userSetting_ = null;
                SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> singleFieldBuilderV36 = this.userSettingBuilder_;
                if (singleFieldBuilderV36 != null) {
                    singleFieldBuilderV36.dispose();
                    this.userSettingBuilder_ = null;
                }
                this.saunaState_ = null;
                SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> singleFieldBuilderV37 = this.saunaStateBuilder_;
                if (singleFieldBuilderV37 != null) {
                    singleFieldBuilderV37.dispose();
                    this.saunaStateBuilder_ = null;
                }
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV32 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV32 == null) {
                    this.enumValue_ = Collections.emptyList();
                } else {
                    this.enumValue_ = null;
                    repeatedFieldBuilderV32.clear();
                }
                this.bitField0_ &= -257;
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV33 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV33 == null) {
                    this.booleanValue_ = Collections.emptyList();
                } else {
                    this.booleanValue_ = null;
                    repeatedFieldBuilderV33.clear();
                }
                this.bitField0_ &= -513;
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV34 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV34 == null) {
                    this.favorite_ = Collections.emptyList();
                } else {
                    this.favorite_ = null;
                    repeatedFieldBuilderV34.clear();
                }
                this.bitField0_ &= -1025;
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV35 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV35 == null) {
                    this.auxRelaySauna_ = Collections.emptyList();
                } else {
                    this.auxRelaySauna_ = null;
                    repeatedFieldBuilderV35.clear();
                }
                this.bitField0_ &= -2049;
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV36 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV36 == null) {
                    this.calendarProgram_ = Collections.emptyList();
                } else {
                    this.calendarProgram_ = null;
                    repeatedFieldBuilderV36.clear();
                }
                this.bitField0_ &= -4097;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Message.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Sauna_to_external getDefaultInstanceForType() {
                return Sauna_to_external.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Sauna_to_external build() {
                Sauna_to_external buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Sauna_to_external buildPartial() {
                Sauna_to_external sauna_to_external = new Sauna_to_external(this);
                buildPartialRepeatedFields(sauna_to_external);
                if (this.bitField0_ != 0) {
                    buildPartial0(sauna_to_external);
                }
                onBuilt();
                return sauna_to_external;
            }

            private void buildPartialRepeatedFields(Sauna_to_external sauna_to_external) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    sauna_to_external.integerValue_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 8) != 0) {
                        this.integerValue_ = Collections.unmodifiableList(this.integerValue_);
                        this.bitField0_ &= -9;
                    }
                    sauna_to_external.integerValue_ = this.integerValue_;
                }
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV32 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV32 != null) {
                    sauna_to_external.enumValue_ = repeatedFieldBuilderV32.build();
                } else {
                    if ((this.bitField0_ & 256) != 0) {
                        this.enumValue_ = Collections.unmodifiableList(this.enumValue_);
                        this.bitField0_ &= -257;
                    }
                    sauna_to_external.enumValue_ = this.enumValue_;
                }
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV33 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV33 != null) {
                    sauna_to_external.booleanValue_ = repeatedFieldBuilderV33.build();
                } else {
                    if ((this.bitField0_ & 512) != 0) {
                        this.booleanValue_ = Collections.unmodifiableList(this.booleanValue_);
                        this.bitField0_ &= -513;
                    }
                    sauna_to_external.booleanValue_ = this.booleanValue_;
                }
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV34 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV34 != null) {
                    sauna_to_external.favorite_ = repeatedFieldBuilderV34.build();
                } else {
                    if ((this.bitField0_ & 1024) != 0) {
                        this.favorite_ = Collections.unmodifiableList(this.favorite_);
                        this.bitField0_ &= -1025;
                    }
                    sauna_to_external.favorite_ = this.favorite_;
                }
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV35 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV35 != null) {
                    sauna_to_external.auxRelaySauna_ = repeatedFieldBuilderV35.build();
                } else {
                    if ((this.bitField0_ & 2048) != 0) {
                        this.auxRelaySauna_ = Collections.unmodifiableList(this.auxRelaySauna_);
                        this.bitField0_ &= -2049;
                    }
                    sauna_to_external.auxRelaySauna_ = this.auxRelaySauna_;
                }
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV36 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV36 != null) {
                    sauna_to_external.calendarProgram_ = repeatedFieldBuilderV36.build();
                    return;
                }
                if ((this.bitField0_ & 4096) != 0) {
                    this.calendarProgram_ = Collections.unmodifiableList(this.calendarProgram_);
                    this.bitField0_ &= -4097;
                }
                sauna_to_external.calendarProgram_ = this.calendarProgram_;
            }

            private void buildPartial0(Sauna_to_external sauna_to_external) {
                int i;
                SaunaState.Sauna_state_changed build;
                UserSetting.User_setting build2;
                UserMessage.User_message build3;
                PresentedValue.Presented_value build4;
                Connect.Keep_alive build5;
                Connect.No_connection build6;
                Connect.Connect_reply build7;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> singleFieldBuilderV3 = this.connectReplyBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        build7 = this.connectReply_;
                    } else {
                        build7 = singleFieldBuilderV3.build();
                    }
                    sauna_to_external.connectReply_ = build7;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> singleFieldBuilderV32 = this.noConnectionBuilder_;
                    if (singleFieldBuilderV32 == null) {
                        build6 = this.noConnection_;
                    } else {
                        build6 = singleFieldBuilderV32.build();
                    }
                    sauna_to_external.noConnection_ = build6;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV33 = this.keepAliveBuilder_;
                    if (singleFieldBuilderV33 == null) {
                        build5 = this.keepAlive_;
                    } else {
                        build5 = singleFieldBuilderV33.build();
                    }
                    sauna_to_external.keepAlive_ = build5;
                    i |= 4;
                }
                if ((i2 & 16) != 0) {
                    SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> singleFieldBuilderV34 = this.presentedValueBuilder_;
                    if (singleFieldBuilderV34 == null) {
                        build4 = this.presentedValue_;
                    } else {
                        build4 = singleFieldBuilderV34.build();
                    }
                    sauna_to_external.presentedValue_ = build4;
                    i |= 8;
                }
                if ((i2 & 32) != 0) {
                    SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV35 = this.userMessageBuilder_;
                    if (singleFieldBuilderV35 == null) {
                        build3 = this.userMessage_;
                    } else {
                        build3 = singleFieldBuilderV35.build();
                    }
                    sauna_to_external.userMessage_ = build3;
                    i |= 16;
                }
                if ((i2 & 64) != 0) {
                    SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> singleFieldBuilderV36 = this.userSettingBuilder_;
                    if (singleFieldBuilderV36 == null) {
                        build2 = this.userSetting_;
                    } else {
                        build2 = singleFieldBuilderV36.build();
                    }
                    sauna_to_external.userSetting_ = build2;
                    i |= 32;
                }
                if ((i2 & 128) != 0) {
                    SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> singleFieldBuilderV37 = this.saunaStateBuilder_;
                    if (singleFieldBuilderV37 == null) {
                        build = this.saunaState_;
                    } else {
                        build = singleFieldBuilderV37.build();
                    }
                    sauna_to_external.saunaState_ = build;
                    i |= 64;
                }
                Sauna_to_external.access$4576(sauna_to_external, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Sauna_to_external) {
                    return mergeFrom((Sauna_to_external) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Sauna_to_external sauna_to_external) {
                if (sauna_to_external == Sauna_to_external.getDefaultInstance()) {
                    return this;
                }
                if (sauna_to_external.hasConnectReply()) {
                    mergeConnectReply(sauna_to_external.getConnectReply());
                }
                if (sauna_to_external.hasNoConnection()) {
                    mergeNoConnection(sauna_to_external.getNoConnection());
                }
                if (sauna_to_external.hasKeepAlive()) {
                    mergeKeepAlive(sauna_to_external.getKeepAlive());
                }
                if (this.integerValueBuilder_ == null) {
                    if (!sauna_to_external.integerValue_.isEmpty()) {
                        if (this.integerValue_.isEmpty()) {
                            this.integerValue_ = sauna_to_external.integerValue_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureIntegerValueIsMutable();
                            this.integerValue_.addAll(sauna_to_external.integerValue_);
                        }
                        onChanged();
                    }
                } else if (!sauna_to_external.integerValue_.isEmpty()) {
                    if (!this.integerValueBuilder_.isEmpty()) {
                        this.integerValueBuilder_.addAllMessages(sauna_to_external.integerValue_);
                    } else {
                        this.integerValueBuilder_.dispose();
                        this.integerValueBuilder_ = null;
                        this.integerValue_ = sauna_to_external.integerValue_;
                        this.bitField0_ &= -9;
                        this.integerValueBuilder_ = Sauna_to_external.alwaysUseFieldBuilders ? getIntegerValueFieldBuilder() : null;
                    }
                }
                if (sauna_to_external.hasPresentedValue()) {
                    mergePresentedValue(sauna_to_external.getPresentedValue());
                }
                if (sauna_to_external.hasUserMessage()) {
                    mergeUserMessage(sauna_to_external.getUserMessage());
                }
                if (sauna_to_external.hasUserSetting()) {
                    mergeUserSetting(sauna_to_external.getUserSetting());
                }
                if (sauna_to_external.hasSaunaState()) {
                    mergeSaunaState(sauna_to_external.getSaunaState());
                }
                if (this.enumValueBuilder_ == null) {
                    if (!sauna_to_external.enumValue_.isEmpty()) {
                        if (this.enumValue_.isEmpty()) {
                            this.enumValue_ = sauna_to_external.enumValue_;
                            this.bitField0_ &= -257;
                        } else {
                            ensureEnumValueIsMutable();
                            this.enumValue_.addAll(sauna_to_external.enumValue_);
                        }
                        onChanged();
                    }
                } else if (!sauna_to_external.enumValue_.isEmpty()) {
                    if (!this.enumValueBuilder_.isEmpty()) {
                        this.enumValueBuilder_.addAllMessages(sauna_to_external.enumValue_);
                    } else {
                        this.enumValueBuilder_.dispose();
                        this.enumValueBuilder_ = null;
                        this.enumValue_ = sauna_to_external.enumValue_;
                        this.bitField0_ &= -257;
                        this.enumValueBuilder_ = Sauna_to_external.alwaysUseFieldBuilders ? getEnumValueFieldBuilder() : null;
                    }
                }
                if (this.booleanValueBuilder_ == null) {
                    if (!sauna_to_external.booleanValue_.isEmpty()) {
                        if (this.booleanValue_.isEmpty()) {
                            this.booleanValue_ = sauna_to_external.booleanValue_;
                            this.bitField0_ &= -513;
                        } else {
                            ensureBooleanValueIsMutable();
                            this.booleanValue_.addAll(sauna_to_external.booleanValue_);
                        }
                        onChanged();
                    }
                } else if (!sauna_to_external.booleanValue_.isEmpty()) {
                    if (!this.booleanValueBuilder_.isEmpty()) {
                        this.booleanValueBuilder_.addAllMessages(sauna_to_external.booleanValue_);
                    } else {
                        this.booleanValueBuilder_.dispose();
                        this.booleanValueBuilder_ = null;
                        this.booleanValue_ = sauna_to_external.booleanValue_;
                        this.bitField0_ &= -513;
                        this.booleanValueBuilder_ = Sauna_to_external.alwaysUseFieldBuilders ? getBooleanValueFieldBuilder() : null;
                    }
                }
                if (this.favoriteBuilder_ == null) {
                    if (!sauna_to_external.favorite_.isEmpty()) {
                        if (this.favorite_.isEmpty()) {
                            this.favorite_ = sauna_to_external.favorite_;
                            this.bitField0_ &= -1025;
                        } else {
                            ensureFavoriteIsMutable();
                            this.favorite_.addAll(sauna_to_external.favorite_);
                        }
                        onChanged();
                    }
                } else if (!sauna_to_external.favorite_.isEmpty()) {
                    if (!this.favoriteBuilder_.isEmpty()) {
                        this.favoriteBuilder_.addAllMessages(sauna_to_external.favorite_);
                    } else {
                        this.favoriteBuilder_.dispose();
                        this.favoriteBuilder_ = null;
                        this.favorite_ = sauna_to_external.favorite_;
                        this.bitField0_ &= -1025;
                        this.favoriteBuilder_ = Sauna_to_external.alwaysUseFieldBuilders ? getFavoriteFieldBuilder() : null;
                    }
                }
                if (this.auxRelaySaunaBuilder_ == null) {
                    if (!sauna_to_external.auxRelaySauna_.isEmpty()) {
                        if (this.auxRelaySauna_.isEmpty()) {
                            this.auxRelaySauna_ = sauna_to_external.auxRelaySauna_;
                            this.bitField0_ &= -2049;
                        } else {
                            ensureAuxRelaySaunaIsMutable();
                            this.auxRelaySauna_.addAll(sauna_to_external.auxRelaySauna_);
                        }
                        onChanged();
                    }
                } else if (!sauna_to_external.auxRelaySauna_.isEmpty()) {
                    if (!this.auxRelaySaunaBuilder_.isEmpty()) {
                        this.auxRelaySaunaBuilder_.addAllMessages(sauna_to_external.auxRelaySauna_);
                    } else {
                        this.auxRelaySaunaBuilder_.dispose();
                        this.auxRelaySaunaBuilder_ = null;
                        this.auxRelaySauna_ = sauna_to_external.auxRelaySauna_;
                        this.bitField0_ &= -2049;
                        this.auxRelaySaunaBuilder_ = Sauna_to_external.alwaysUseFieldBuilders ? getAuxRelaySaunaFieldBuilder() : null;
                    }
                }
                if (this.calendarProgramBuilder_ == null) {
                    if (!sauna_to_external.calendarProgram_.isEmpty()) {
                        if (this.calendarProgram_.isEmpty()) {
                            this.calendarProgram_ = sauna_to_external.calendarProgram_;
                            this.bitField0_ &= -4097;
                        } else {
                            ensureCalendarProgramIsMutable();
                            this.calendarProgram_.addAll(sauna_to_external.calendarProgram_);
                        }
                        onChanged();
                    }
                } else if (!sauna_to_external.calendarProgram_.isEmpty()) {
                    if (!this.calendarProgramBuilder_.isEmpty()) {
                        this.calendarProgramBuilder_.addAllMessages(sauna_to_external.calendarProgram_);
                    } else {
                        this.calendarProgramBuilder_.dispose();
                        this.calendarProgramBuilder_ = null;
                        this.calendarProgram_ = sauna_to_external.calendarProgram_;
                        this.bitField0_ &= -4097;
                        this.calendarProgramBuilder_ = Sauna_to_external.alwaysUseFieldBuilders ? getCalendarProgramFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(sauna_to_external.getUnknownFields());
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
                                case 16002:
                                    codedInputStream.readMessage(getConnectReplyFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 1;
                                case 16010:
                                    codedInputStream.readMessage(getNoConnectionFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 2;
                                case 16018:
                                    codedInputStream.readMessage(getKeepAliveFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 4;
                                case 16082:
                                    IntegerValue.Integer_value_changed integer_value_changed = (IntegerValue.Integer_value_changed) codedInputStream.readMessage(IntegerValue.Integer_value_changed.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                                    if (repeatedFieldBuilderV3 == null) {
                                        ensureIntegerValueIsMutable();
                                        this.integerValue_.add(integer_value_changed);
                                    } else {
                                        repeatedFieldBuilderV3.addMessage(integer_value_changed);
                                    }
                                case 16090:
                                    BooleanValue.Boolean_value_changed boolean_value_changed = (BooleanValue.Boolean_value_changed) codedInputStream.readMessage(BooleanValue.Boolean_value_changed.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV32 = this.booleanValueBuilder_;
                                    if (repeatedFieldBuilderV32 == null) {
                                        ensureBooleanValueIsMutable();
                                        this.booleanValue_.add(boolean_value_changed);
                                    } else {
                                        repeatedFieldBuilderV32.addMessage(boolean_value_changed);
                                    }
                                case 16162:
                                    codedInputStream.readMessage(getUserSettingFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 64;
                                case 16242:
                                    codedInputStream.readMessage(getPresentedValueFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 16;
                                case 16322:
                                    Favorite.Favorite_post favorite_post = (Favorite.Favorite_post) codedInputStream.readMessage(Favorite.Favorite_post.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV33 = this.favoriteBuilder_;
                                    if (repeatedFieldBuilderV33 == null) {
                                        ensureFavoriteIsMutable();
                                        this.favorite_.add(favorite_post);
                                    } else {
                                        repeatedFieldBuilderV33.addMessage(favorite_post);
                                    }
                                case 16362:
                                    Calendar.Calendar_post calendar_post = (Calendar.Calendar_post) codedInputStream.readMessage(Calendar.Calendar_post.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV34 = this.calendarProgramBuilder_;
                                    if (repeatedFieldBuilderV34 == null) {
                                        ensureCalendarProgramIsMutable();
                                        this.calendarProgram_.add(calendar_post);
                                    } else {
                                        repeatedFieldBuilderV34.addMessage(calendar_post);
                                    }
                                case 16402:
                                    codedInputStream.readMessage(getSaunaStateFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 128;
                                case 16562:
                                    AuxRelay.Aux_relay_post_sauna aux_relay_post_sauna = (AuxRelay.Aux_relay_post_sauna) codedInputStream.readMessage(AuxRelay.Aux_relay_post_sauna.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV35 = this.auxRelaySaunaBuilder_;
                                    if (repeatedFieldBuilderV35 == null) {
                                        ensureAuxRelaySaunaIsMutable();
                                        this.auxRelaySauna_.add(aux_relay_post_sauna);
                                    } else {
                                        repeatedFieldBuilderV35.addMessage(aux_relay_post_sauna);
                                    }
                                case 16802:
                                    EnumValue.Enum_value_changed enum_value_changed = (EnumValue.Enum_value_changed) codedInputStream.readMessage(EnumValue.Enum_value_changed.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV36 = this.enumValueBuilder_;
                                    if (repeatedFieldBuilderV36 == null) {
                                        ensureEnumValueIsMutable();
                                        this.enumValue_.add(enum_value_changed);
                                    } else {
                                        repeatedFieldBuilderV36.addMessage(enum_value_changed);
                                    }
                                case 16882:
                                    codedInputStream.readMessage(getUserMessageFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 32;
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

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public boolean hasConnectReply() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Connect.Connect_reply getConnectReply() {
                SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> singleFieldBuilderV3 = this.connectReplyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Connect.Connect_reply connect_reply = this.connectReply_;
                    return connect_reply == null ? Connect.Connect_reply.getDefaultInstance() : connect_reply;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setConnectReply(Connect.Connect_reply connect_reply) {
                SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> singleFieldBuilderV3 = this.connectReplyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    connect_reply.getClass();
                    this.connectReply_ = connect_reply;
                } else {
                    singleFieldBuilderV3.setMessage(connect_reply);
                }
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setConnectReply(Connect.Connect_reply.Builder builder) {
                SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> singleFieldBuilderV3 = this.connectReplyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.connectReply_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder mergeConnectReply(Connect.Connect_reply connect_reply) {
                Connect.Connect_reply connect_reply2;
                SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> singleFieldBuilderV3 = this.connectReplyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0 && (connect_reply2 = this.connectReply_) != null && connect_reply2 != Connect.Connect_reply.getDefaultInstance()) {
                        getConnectReplyBuilder().mergeFrom(connect_reply);
                    } else {
                        this.connectReply_ = connect_reply;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(connect_reply);
                }
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearConnectReply() {
                this.bitField0_ &= -2;
                this.connectReply_ = null;
                SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> singleFieldBuilderV3 = this.connectReplyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.connectReplyBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Connect.Connect_reply.Builder getConnectReplyBuilder() {
                this.bitField0_ |= 1;
                onChanged();
                return getConnectReplyFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Connect.Connect_replyOrBuilder getConnectReplyOrBuilder() {
                SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> singleFieldBuilderV3 = this.connectReplyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Connect.Connect_reply connect_reply = this.connectReply_;
                return connect_reply == null ? Connect.Connect_reply.getDefaultInstance() : connect_reply;
            }

            private SingleFieldBuilderV3<Connect.Connect_reply, Connect.Connect_reply.Builder, Connect.Connect_replyOrBuilder> getConnectReplyFieldBuilder() {
                if (this.connectReplyBuilder_ == null) {
                    this.connectReplyBuilder_ = new SingleFieldBuilderV3<>(getConnectReply(), getParentForChildren(), isClean());
                    this.connectReply_ = null;
                }
                return this.connectReplyBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public boolean hasNoConnection() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Connect.No_connection getNoConnection() {
                SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> singleFieldBuilderV3 = this.noConnectionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Connect.No_connection no_connection = this.noConnection_;
                    return no_connection == null ? Connect.No_connection.getDefaultInstance() : no_connection;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setNoConnection(Connect.No_connection no_connection) {
                SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> singleFieldBuilderV3 = this.noConnectionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    no_connection.getClass();
                    this.noConnection_ = no_connection;
                } else {
                    singleFieldBuilderV3.setMessage(no_connection);
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setNoConnection(Connect.No_connection.Builder builder) {
                SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> singleFieldBuilderV3 = this.noConnectionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.noConnection_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder mergeNoConnection(Connect.No_connection no_connection) {
                Connect.No_connection no_connection2;
                SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> singleFieldBuilderV3 = this.noConnectionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) != 0 && (no_connection2 = this.noConnection_) != null && no_connection2 != Connect.No_connection.getDefaultInstance()) {
                        getNoConnectionBuilder().mergeFrom(no_connection);
                    } else {
                        this.noConnection_ = no_connection;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(no_connection);
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearNoConnection() {
                this.bitField0_ &= -3;
                this.noConnection_ = null;
                SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> singleFieldBuilderV3 = this.noConnectionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.noConnectionBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Connect.No_connection.Builder getNoConnectionBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return getNoConnectionFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Connect.No_connectionOrBuilder getNoConnectionOrBuilder() {
                SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> singleFieldBuilderV3 = this.noConnectionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Connect.No_connection no_connection = this.noConnection_;
                return no_connection == null ? Connect.No_connection.getDefaultInstance() : no_connection;
            }

            private SingleFieldBuilderV3<Connect.No_connection, Connect.No_connection.Builder, Connect.No_connectionOrBuilder> getNoConnectionFieldBuilder() {
                if (this.noConnectionBuilder_ == null) {
                    this.noConnectionBuilder_ = new SingleFieldBuilderV3<>(getNoConnection(), getParentForChildren(), isClean());
                    this.noConnection_ = null;
                }
                return this.noConnectionBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public boolean hasKeepAlive() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Connect.Keep_alive getKeepAlive() {
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Connect.Keep_alive keep_alive = this.keepAlive_;
                    return keep_alive == null ? Connect.Keep_alive.getDefaultInstance() : keep_alive;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setKeepAlive(Connect.Keep_alive keep_alive) {
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 == null) {
                    keep_alive.getClass();
                    this.keepAlive_ = keep_alive;
                } else {
                    singleFieldBuilderV3.setMessage(keep_alive);
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setKeepAlive(Connect.Keep_alive.Builder builder) {
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.keepAlive_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder mergeKeepAlive(Connect.Keep_alive keep_alive) {
                Connect.Keep_alive keep_alive2;
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 4) != 0 && (keep_alive2 = this.keepAlive_) != null && keep_alive2 != Connect.Keep_alive.getDefaultInstance()) {
                        getKeepAliveBuilder().mergeFrom(keep_alive);
                    } else {
                        this.keepAlive_ = keep_alive;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(keep_alive);
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearKeepAlive() {
                this.bitField0_ &= -5;
                this.keepAlive_ = null;
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.keepAliveBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Connect.Keep_alive.Builder getKeepAliveBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return getKeepAliveFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Connect.Keep_aliveOrBuilder getKeepAliveOrBuilder() {
                SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> singleFieldBuilderV3 = this.keepAliveBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Connect.Keep_alive keep_alive = this.keepAlive_;
                return keep_alive == null ? Connect.Keep_alive.getDefaultInstance() : keep_alive;
            }

            private SingleFieldBuilderV3<Connect.Keep_alive, Connect.Keep_alive.Builder, Connect.Keep_aliveOrBuilder> getKeepAliveFieldBuilder() {
                if (this.keepAliveBuilder_ == null) {
                    this.keepAliveBuilder_ = new SingleFieldBuilderV3<>(getKeepAlive(), getParentForChildren(), isClean());
                    this.keepAlive_ = null;
                }
                return this.keepAliveBuilder_;
            }

            private void ensureIntegerValueIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.integerValue_ = new ArrayList(this.integerValue_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<IntegerValue.Integer_value_changed> getIntegerValueList() {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.integerValue_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public int getIntegerValueCount() {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.integerValue_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public IntegerValue.Integer_value_changed getIntegerValue(int i) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.integerValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setIntegerValue(int i, IntegerValue.Integer_value_changed integer_value_changed) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    integer_value_changed.getClass();
                    ensureIntegerValueIsMutable();
                    this.integerValue_.set(i, integer_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, integer_value_changed);
                }
                return this;
            }

            public Builder setIntegerValue(int i, IntegerValue.Integer_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    this.integerValue_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addIntegerValue(IntegerValue.Integer_value_changed integer_value_changed) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    integer_value_changed.getClass();
                    ensureIntegerValueIsMutable();
                    this.integerValue_.add(integer_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(integer_value_changed);
                }
                return this;
            }

            public Builder addIntegerValue(int i, IntegerValue.Integer_value_changed integer_value_changed) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    integer_value_changed.getClass();
                    ensureIntegerValueIsMutable();
                    this.integerValue_.add(i, integer_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, integer_value_changed);
                }
                return this;
            }

            public Builder addIntegerValue(IntegerValue.Integer_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    this.integerValue_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addIntegerValue(int i, IntegerValue.Integer_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    this.integerValue_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllIntegerValue(Iterable<? extends IntegerValue.Integer_value_changed> iterable) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.integerValue_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearIntegerValue() {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.integerValue_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeIntegerValue(int i) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureIntegerValueIsMutable();
                    this.integerValue_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public IntegerValue.Integer_value_changed.Builder getIntegerValueBuilder(int i) {
                return getIntegerValueFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public IntegerValue.Integer_value_changedOrBuilder getIntegerValueOrBuilder(int i) {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.integerValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<? extends IntegerValue.Integer_value_changedOrBuilder> getIntegerValueOrBuilderList() {
                RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> repeatedFieldBuilderV3 = this.integerValueBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.integerValue_);
            }

            public IntegerValue.Integer_value_changed.Builder addIntegerValueBuilder() {
                return getIntegerValueFieldBuilder().addBuilder(IntegerValue.Integer_value_changed.getDefaultInstance());
            }

            public IntegerValue.Integer_value_changed.Builder addIntegerValueBuilder(int i) {
                return getIntegerValueFieldBuilder().addBuilder(i, IntegerValue.Integer_value_changed.getDefaultInstance());
            }

            public List<IntegerValue.Integer_value_changed.Builder> getIntegerValueBuilderList() {
                return getIntegerValueFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IntegerValue.Integer_value_changed, IntegerValue.Integer_value_changed.Builder, IntegerValue.Integer_value_changedOrBuilder> getIntegerValueFieldBuilder() {
                if (this.integerValueBuilder_ == null) {
                    this.integerValueBuilder_ = new RepeatedFieldBuilderV3<>(this.integerValue_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.integerValue_ = null;
                }
                return this.integerValueBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public boolean hasPresentedValue() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public PresentedValue.Presented_value getPresentedValue() {
                SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> singleFieldBuilderV3 = this.presentedValueBuilder_;
                if (singleFieldBuilderV3 == null) {
                    PresentedValue.Presented_value presented_value = this.presentedValue_;
                    return presented_value == null ? PresentedValue.Presented_value.getDefaultInstance() : presented_value;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setPresentedValue(PresentedValue.Presented_value presented_value) {
                SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> singleFieldBuilderV3 = this.presentedValueBuilder_;
                if (singleFieldBuilderV3 == null) {
                    presented_value.getClass();
                    this.presentedValue_ = presented_value;
                } else {
                    singleFieldBuilderV3.setMessage(presented_value);
                }
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setPresentedValue(PresentedValue.Presented_value.Builder builder) {
                SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> singleFieldBuilderV3 = this.presentedValueBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.presentedValue_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder mergePresentedValue(PresentedValue.Presented_value presented_value) {
                PresentedValue.Presented_value presented_value2;
                SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> singleFieldBuilderV3 = this.presentedValueBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 16) != 0 && (presented_value2 = this.presentedValue_) != null && presented_value2 != PresentedValue.Presented_value.getDefaultInstance()) {
                        getPresentedValueBuilder().mergeFrom(presented_value);
                    } else {
                        this.presentedValue_ = presented_value;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(presented_value);
                }
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder clearPresentedValue() {
                this.bitField0_ &= -17;
                this.presentedValue_ = null;
                SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> singleFieldBuilderV3 = this.presentedValueBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.presentedValueBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public PresentedValue.Presented_value.Builder getPresentedValueBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return getPresentedValueFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public PresentedValue.Presented_valueOrBuilder getPresentedValueOrBuilder() {
                SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> singleFieldBuilderV3 = this.presentedValueBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                PresentedValue.Presented_value presented_value = this.presentedValue_;
                return presented_value == null ? PresentedValue.Presented_value.getDefaultInstance() : presented_value;
            }

            private SingleFieldBuilderV3<PresentedValue.Presented_value, PresentedValue.Presented_value.Builder, PresentedValue.Presented_valueOrBuilder> getPresentedValueFieldBuilder() {
                if (this.presentedValueBuilder_ == null) {
                    this.presentedValueBuilder_ = new SingleFieldBuilderV3<>(getPresentedValue(), getParentForChildren(), isClean());
                    this.presentedValue_ = null;
                }
                return this.presentedValueBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public boolean hasUserMessage() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public UserMessage.User_message getUserMessage() {
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 == null) {
                    UserMessage.User_message user_message = this.userMessage_;
                    return user_message == null ? UserMessage.User_message.getDefaultInstance() : user_message;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setUserMessage(UserMessage.User_message user_message) {
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 == null) {
                    user_message.getClass();
                    this.userMessage_ = user_message;
                } else {
                    singleFieldBuilderV3.setMessage(user_message);
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setUserMessage(UserMessage.User_message.Builder builder) {
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.userMessage_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder mergeUserMessage(UserMessage.User_message user_message) {
                UserMessage.User_message user_message2;
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 32) != 0 && (user_message2 = this.userMessage_) != null && user_message2 != UserMessage.User_message.getDefaultInstance()) {
                        getUserMessageBuilder().mergeFrom(user_message);
                    } else {
                        this.userMessage_ = user_message;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(user_message);
                }
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder clearUserMessage() {
                this.bitField0_ &= -33;
                this.userMessage_ = null;
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.userMessageBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public UserMessage.User_message.Builder getUserMessageBuilder() {
                this.bitField0_ |= 32;
                onChanged();
                return getUserMessageFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public UserMessage.User_messageOrBuilder getUserMessageOrBuilder() {
                SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> singleFieldBuilderV3 = this.userMessageBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                UserMessage.User_message user_message = this.userMessage_;
                return user_message == null ? UserMessage.User_message.getDefaultInstance() : user_message;
            }

            private SingleFieldBuilderV3<UserMessage.User_message, UserMessage.User_message.Builder, UserMessage.User_messageOrBuilder> getUserMessageFieldBuilder() {
                if (this.userMessageBuilder_ == null) {
                    this.userMessageBuilder_ = new SingleFieldBuilderV3<>(getUserMessage(), getParentForChildren(), isClean());
                    this.userMessage_ = null;
                }
                return this.userMessageBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public boolean hasUserSetting() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public UserSetting.User_setting getUserSetting() {
                SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> singleFieldBuilderV3 = this.userSettingBuilder_;
                if (singleFieldBuilderV3 == null) {
                    UserSetting.User_setting user_setting = this.userSetting_;
                    return user_setting == null ? UserSetting.User_setting.getDefaultInstance() : user_setting;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setUserSetting(UserSetting.User_setting user_setting) {
                SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> singleFieldBuilderV3 = this.userSettingBuilder_;
                if (singleFieldBuilderV3 == null) {
                    user_setting.getClass();
                    this.userSetting_ = user_setting;
                } else {
                    singleFieldBuilderV3.setMessage(user_setting);
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setUserSetting(UserSetting.User_setting.Builder builder) {
                SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> singleFieldBuilderV3 = this.userSettingBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.userSetting_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder mergeUserSetting(UserSetting.User_setting user_setting) {
                UserSetting.User_setting user_setting2;
                SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> singleFieldBuilderV3 = this.userSettingBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 64) != 0 && (user_setting2 = this.userSetting_) != null && user_setting2 != UserSetting.User_setting.getDefaultInstance()) {
                        getUserSettingBuilder().mergeFrom(user_setting);
                    } else {
                        this.userSetting_ = user_setting;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(user_setting);
                }
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder clearUserSetting() {
                this.bitField0_ &= -65;
                this.userSetting_ = null;
                SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> singleFieldBuilderV3 = this.userSettingBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.userSettingBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public UserSetting.User_setting.Builder getUserSettingBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return getUserSettingFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public UserSetting.User_settingOrBuilder getUserSettingOrBuilder() {
                SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> singleFieldBuilderV3 = this.userSettingBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                UserSetting.User_setting user_setting = this.userSetting_;
                return user_setting == null ? UserSetting.User_setting.getDefaultInstance() : user_setting;
            }

            private SingleFieldBuilderV3<UserSetting.User_setting, UserSetting.User_setting.Builder, UserSetting.User_settingOrBuilder> getUserSettingFieldBuilder() {
                if (this.userSettingBuilder_ == null) {
                    this.userSettingBuilder_ = new SingleFieldBuilderV3<>(getUserSetting(), getParentForChildren(), isClean());
                    this.userSetting_ = null;
                }
                return this.userSettingBuilder_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public boolean hasSaunaState() {
                return (this.bitField0_ & 128) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public SaunaState.Sauna_state_changed getSaunaState() {
                SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SaunaState.Sauna_state_changed sauna_state_changed = this.saunaState_;
                    return sauna_state_changed == null ? SaunaState.Sauna_state_changed.getDefaultInstance() : sauna_state_changed;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSaunaState(SaunaState.Sauna_state_changed sauna_state_changed) {
                SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sauna_state_changed.getClass();
                    this.saunaState_ = sauna_state_changed;
                } else {
                    singleFieldBuilderV3.setMessage(sauna_state_changed);
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setSaunaState(SaunaState.Sauna_state_changed.Builder builder) {
                SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.saunaState_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder mergeSaunaState(SaunaState.Sauna_state_changed sauna_state_changed) {
                SaunaState.Sauna_state_changed sauna_state_changed2;
                SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 128) != 0 && (sauna_state_changed2 = this.saunaState_) != null && sauna_state_changed2 != SaunaState.Sauna_state_changed.getDefaultInstance()) {
                        getSaunaStateBuilder().mergeFrom(sauna_state_changed);
                    } else {
                        this.saunaState_ = sauna_state_changed;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(sauna_state_changed);
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder clearSaunaState() {
                this.bitField0_ &= -129;
                this.saunaState_ = null;
                SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.saunaStateBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public SaunaState.Sauna_state_changed.Builder getSaunaStateBuilder() {
                this.bitField0_ |= 128;
                onChanged();
                return getSaunaStateFieldBuilder().getBuilder();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public SaunaState.Sauna_state_changedOrBuilder getSaunaStateOrBuilder() {
                SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> singleFieldBuilderV3 = this.saunaStateBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                SaunaState.Sauna_state_changed sauna_state_changed = this.saunaState_;
                return sauna_state_changed == null ? SaunaState.Sauna_state_changed.getDefaultInstance() : sauna_state_changed;
            }

            private SingleFieldBuilderV3<SaunaState.Sauna_state_changed, SaunaState.Sauna_state_changed.Builder, SaunaState.Sauna_state_changedOrBuilder> getSaunaStateFieldBuilder() {
                if (this.saunaStateBuilder_ == null) {
                    this.saunaStateBuilder_ = new SingleFieldBuilderV3<>(getSaunaState(), getParentForChildren(), isClean());
                    this.saunaState_ = null;
                }
                return this.saunaStateBuilder_;
            }

            private void ensureEnumValueIsMutable() {
                if ((this.bitField0_ & 256) == 0) {
                    this.enumValue_ = new ArrayList(this.enumValue_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<EnumValue.Enum_value_changed> getEnumValueList() {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.enumValue_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public int getEnumValueCount() {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.enumValue_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public EnumValue.Enum_value_changed getEnumValue(int i) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.enumValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setEnumValue(int i, EnumValue.Enum_value_changed enum_value_changed) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    enum_value_changed.getClass();
                    ensureEnumValueIsMutable();
                    this.enumValue_.set(i, enum_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, enum_value_changed);
                }
                return this;
            }

            public Builder setEnumValue(int i, EnumValue.Enum_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    this.enumValue_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addEnumValue(EnumValue.Enum_value_changed enum_value_changed) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    enum_value_changed.getClass();
                    ensureEnumValueIsMutable();
                    this.enumValue_.add(enum_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(enum_value_changed);
                }
                return this;
            }

            public Builder addEnumValue(int i, EnumValue.Enum_value_changed enum_value_changed) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    enum_value_changed.getClass();
                    ensureEnumValueIsMutable();
                    this.enumValue_.add(i, enum_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, enum_value_changed);
                }
                return this;
            }

            public Builder addEnumValue(EnumValue.Enum_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    this.enumValue_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addEnumValue(int i, EnumValue.Enum_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    this.enumValue_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllEnumValue(Iterable<? extends EnumValue.Enum_value_changed> iterable) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.enumValue_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearEnumValue() {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.enumValue_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeEnumValue(int i) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEnumValueIsMutable();
                    this.enumValue_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public EnumValue.Enum_value_changed.Builder getEnumValueBuilder(int i) {
                return getEnumValueFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public EnumValue.Enum_value_changedOrBuilder getEnumValueOrBuilder(int i) {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.enumValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<? extends EnumValue.Enum_value_changedOrBuilder> getEnumValueOrBuilderList() {
                RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> repeatedFieldBuilderV3 = this.enumValueBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.enumValue_);
            }

            public EnumValue.Enum_value_changed.Builder addEnumValueBuilder() {
                return getEnumValueFieldBuilder().addBuilder(EnumValue.Enum_value_changed.getDefaultInstance());
            }

            public EnumValue.Enum_value_changed.Builder addEnumValueBuilder(int i) {
                return getEnumValueFieldBuilder().addBuilder(i, EnumValue.Enum_value_changed.getDefaultInstance());
            }

            public List<EnumValue.Enum_value_changed.Builder> getEnumValueBuilderList() {
                return getEnumValueFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EnumValue.Enum_value_changed, EnumValue.Enum_value_changed.Builder, EnumValue.Enum_value_changedOrBuilder> getEnumValueFieldBuilder() {
                if (this.enumValueBuilder_ == null) {
                    this.enumValueBuilder_ = new RepeatedFieldBuilderV3<>(this.enumValue_, (this.bitField0_ & 256) != 0, getParentForChildren(), isClean());
                    this.enumValue_ = null;
                }
                return this.enumValueBuilder_;
            }

            private void ensureBooleanValueIsMutable() {
                if ((this.bitField0_ & 512) == 0) {
                    this.booleanValue_ = new ArrayList(this.booleanValue_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<BooleanValue.Boolean_value_changed> getBooleanValueList() {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.booleanValue_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public int getBooleanValueCount() {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.booleanValue_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public BooleanValue.Boolean_value_changed getBooleanValue(int i) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.booleanValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setBooleanValue(int i, BooleanValue.Boolean_value_changed boolean_value_changed) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    boolean_value_changed.getClass();
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.set(i, boolean_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, boolean_value_changed);
                }
                return this;
            }

            public Builder setBooleanValue(int i, BooleanValue.Boolean_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addBooleanValue(BooleanValue.Boolean_value_changed boolean_value_changed) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    boolean_value_changed.getClass();
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.add(boolean_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(boolean_value_changed);
                }
                return this;
            }

            public Builder addBooleanValue(int i, BooleanValue.Boolean_value_changed boolean_value_changed) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    boolean_value_changed.getClass();
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.add(i, boolean_value_changed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, boolean_value_changed);
                }
                return this;
            }

            public Builder addBooleanValue(BooleanValue.Boolean_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addBooleanValue(int i, BooleanValue.Boolean_value_changed.Builder builder) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllBooleanValue(Iterable<? extends BooleanValue.Boolean_value_changed> iterable) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.booleanValue_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearBooleanValue() {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.booleanValue_ = Collections.emptyList();
                    this.bitField0_ &= -513;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeBooleanValue(int i) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBooleanValueIsMutable();
                    this.booleanValue_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public BooleanValue.Boolean_value_changed.Builder getBooleanValueBuilder(int i) {
                return getBooleanValueFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public BooleanValue.Boolean_value_changedOrBuilder getBooleanValueOrBuilder(int i) {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.booleanValue_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<? extends BooleanValue.Boolean_value_changedOrBuilder> getBooleanValueOrBuilderList() {
                RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> repeatedFieldBuilderV3 = this.booleanValueBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.booleanValue_);
            }

            public BooleanValue.Boolean_value_changed.Builder addBooleanValueBuilder() {
                return getBooleanValueFieldBuilder().addBuilder(BooleanValue.Boolean_value_changed.getDefaultInstance());
            }

            public BooleanValue.Boolean_value_changed.Builder addBooleanValueBuilder(int i) {
                return getBooleanValueFieldBuilder().addBuilder(i, BooleanValue.Boolean_value_changed.getDefaultInstance());
            }

            public List<BooleanValue.Boolean_value_changed.Builder> getBooleanValueBuilderList() {
                return getBooleanValueFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BooleanValue.Boolean_value_changed, BooleanValue.Boolean_value_changed.Builder, BooleanValue.Boolean_value_changedOrBuilder> getBooleanValueFieldBuilder() {
                if (this.booleanValueBuilder_ == null) {
                    this.booleanValueBuilder_ = new RepeatedFieldBuilderV3<>(this.booleanValue_, (this.bitField0_ & 512) != 0, getParentForChildren(), isClean());
                    this.booleanValue_ = null;
                }
                return this.booleanValueBuilder_;
            }

            private void ensureFavoriteIsMutable() {
                if ((this.bitField0_ & 1024) == 0) {
                    this.favorite_ = new ArrayList(this.favorite_);
                    this.bitField0_ |= 1024;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<Favorite.Favorite_post> getFavoriteList() {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.favorite_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public int getFavoriteCount() {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.favorite_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Favorite.Favorite_post getFavorite(int i) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.favorite_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setFavorite(int i, Favorite.Favorite_post favorite_post) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    favorite_post.getClass();
                    ensureFavoriteIsMutable();
                    this.favorite_.set(i, favorite_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, favorite_post);
                }
                return this;
            }

            public Builder setFavorite(int i, Favorite.Favorite_post.Builder builder) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    this.favorite_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addFavorite(Favorite.Favorite_post favorite_post) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    favorite_post.getClass();
                    ensureFavoriteIsMutable();
                    this.favorite_.add(favorite_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(favorite_post);
                }
                return this;
            }

            public Builder addFavorite(int i, Favorite.Favorite_post favorite_post) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    favorite_post.getClass();
                    ensureFavoriteIsMutable();
                    this.favorite_.add(i, favorite_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, favorite_post);
                }
                return this;
            }

            public Builder addFavorite(Favorite.Favorite_post.Builder builder) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    this.favorite_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addFavorite(int i, Favorite.Favorite_post.Builder builder) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    this.favorite_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllFavorite(Iterable<? extends Favorite.Favorite_post> iterable) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.favorite_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearFavorite() {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.favorite_ = Collections.emptyList();
                    this.bitField0_ &= -1025;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeFavorite(int i) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFavoriteIsMutable();
                    this.favorite_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Favorite.Favorite_post.Builder getFavoriteBuilder(int i) {
                return getFavoriteFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Favorite.Favorite_postOrBuilder getFavoriteOrBuilder(int i) {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.favorite_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<? extends Favorite.Favorite_postOrBuilder> getFavoriteOrBuilderList() {
                RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> repeatedFieldBuilderV3 = this.favoriteBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.favorite_);
            }

            public Favorite.Favorite_post.Builder addFavoriteBuilder() {
                return getFavoriteFieldBuilder().addBuilder(Favorite.Favorite_post.getDefaultInstance());
            }

            public Favorite.Favorite_post.Builder addFavoriteBuilder(int i) {
                return getFavoriteFieldBuilder().addBuilder(i, Favorite.Favorite_post.getDefaultInstance());
            }

            public List<Favorite.Favorite_post.Builder> getFavoriteBuilderList() {
                return getFavoriteFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Favorite.Favorite_post, Favorite.Favorite_post.Builder, Favorite.Favorite_postOrBuilder> getFavoriteFieldBuilder() {
                if (this.favoriteBuilder_ == null) {
                    this.favoriteBuilder_ = new RepeatedFieldBuilderV3<>(this.favorite_, (this.bitField0_ & 1024) != 0, getParentForChildren(), isClean());
                    this.favorite_ = null;
                }
                return this.favoriteBuilder_;
            }

            private void ensureAuxRelaySaunaIsMutable() {
                if ((this.bitField0_ & 2048) == 0) {
                    this.auxRelaySauna_ = new ArrayList(this.auxRelaySauna_);
                    this.bitField0_ |= 2048;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<AuxRelay.Aux_relay_post_sauna> getAuxRelaySaunaList() {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.auxRelaySauna_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public int getAuxRelaySaunaCount() {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.auxRelaySauna_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public AuxRelay.Aux_relay_post_sauna getAuxRelaySauna(int i) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.auxRelaySauna_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setAuxRelaySauna(int i, AuxRelay.Aux_relay_post_sauna aux_relay_post_sauna) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    aux_relay_post_sauna.getClass();
                    ensureAuxRelaySaunaIsMutable();
                    this.auxRelaySauna_.set(i, aux_relay_post_sauna);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, aux_relay_post_sauna);
                }
                return this;
            }

            public Builder setAuxRelaySauna(int i, AuxRelay.Aux_relay_post_sauna.Builder builder) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelaySaunaIsMutable();
                    this.auxRelaySauna_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAuxRelaySauna(AuxRelay.Aux_relay_post_sauna aux_relay_post_sauna) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    aux_relay_post_sauna.getClass();
                    ensureAuxRelaySaunaIsMutable();
                    this.auxRelaySauna_.add(aux_relay_post_sauna);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(aux_relay_post_sauna);
                }
                return this;
            }

            public Builder addAuxRelaySauna(int i, AuxRelay.Aux_relay_post_sauna aux_relay_post_sauna) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    aux_relay_post_sauna.getClass();
                    ensureAuxRelaySaunaIsMutable();
                    this.auxRelaySauna_.add(i, aux_relay_post_sauna);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, aux_relay_post_sauna);
                }
                return this;
            }

            public Builder addAuxRelaySauna(AuxRelay.Aux_relay_post_sauna.Builder builder) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelaySaunaIsMutable();
                    this.auxRelaySauna_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addAuxRelaySauna(int i, AuxRelay.Aux_relay_post_sauna.Builder builder) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelaySaunaIsMutable();
                    this.auxRelaySauna_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllAuxRelaySauna(Iterable<? extends AuxRelay.Aux_relay_post_sauna> iterable) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelaySaunaIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.auxRelaySauna_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearAuxRelaySauna() {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.auxRelaySauna_ = Collections.emptyList();
                    this.bitField0_ &= -2049;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeAuxRelaySauna(int i) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAuxRelaySaunaIsMutable();
                    this.auxRelaySauna_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public AuxRelay.Aux_relay_post_sauna.Builder getAuxRelaySaunaBuilder(int i) {
                return getAuxRelaySaunaFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public AuxRelay.Aux_relay_post_saunaOrBuilder getAuxRelaySaunaOrBuilder(int i) {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.auxRelaySauna_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<? extends AuxRelay.Aux_relay_post_saunaOrBuilder> getAuxRelaySaunaOrBuilderList() {
                RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> repeatedFieldBuilderV3 = this.auxRelaySaunaBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.auxRelaySauna_);
            }

            public AuxRelay.Aux_relay_post_sauna.Builder addAuxRelaySaunaBuilder() {
                return getAuxRelaySaunaFieldBuilder().addBuilder(AuxRelay.Aux_relay_post_sauna.getDefaultInstance());
            }

            public AuxRelay.Aux_relay_post_sauna.Builder addAuxRelaySaunaBuilder(int i) {
                return getAuxRelaySaunaFieldBuilder().addBuilder(i, AuxRelay.Aux_relay_post_sauna.getDefaultInstance());
            }

            public List<AuxRelay.Aux_relay_post_sauna.Builder> getAuxRelaySaunaBuilderList() {
                return getAuxRelaySaunaFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AuxRelay.Aux_relay_post_sauna, AuxRelay.Aux_relay_post_sauna.Builder, AuxRelay.Aux_relay_post_saunaOrBuilder> getAuxRelaySaunaFieldBuilder() {
                if (this.auxRelaySaunaBuilder_ == null) {
                    this.auxRelaySaunaBuilder_ = new RepeatedFieldBuilderV3<>(this.auxRelaySauna_, (this.bitField0_ & 2048) != 0, getParentForChildren(), isClean());
                    this.auxRelaySauna_ = null;
                }
                return this.auxRelaySaunaBuilder_;
            }

            private void ensureCalendarProgramIsMutable() {
                if ((this.bitField0_ & 4096) == 0) {
                    this.calendarProgram_ = new ArrayList(this.calendarProgram_);
                    this.bitField0_ |= 4096;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<Calendar.Calendar_post> getCalendarProgramList() {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.calendarProgram_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public int getCalendarProgramCount() {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.calendarProgram_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Calendar.Calendar_post getCalendarProgram(int i) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.calendarProgram_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setCalendarProgram(int i, Calendar.Calendar_post calendar_post) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    calendar_post.getClass();
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.set(i, calendar_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, calendar_post);
                }
                return this;
            }

            public Builder setCalendarProgram(int i, Calendar.Calendar_post.Builder builder) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addCalendarProgram(Calendar.Calendar_post calendar_post) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    calendar_post.getClass();
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.add(calendar_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(calendar_post);
                }
                return this;
            }

            public Builder addCalendarProgram(int i, Calendar.Calendar_post calendar_post) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    calendar_post.getClass();
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.add(i, calendar_post);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, calendar_post);
                }
                return this;
            }

            public Builder addCalendarProgram(Calendar.Calendar_post.Builder builder) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addCalendarProgram(int i, Calendar.Calendar_post.Builder builder) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllCalendarProgram(Iterable<? extends Calendar.Calendar_post> iterable) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.calendarProgram_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearCalendarProgram() {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.calendarProgram_ = Collections.emptyList();
                    this.bitField0_ &= -4097;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeCalendarProgram(int i) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureCalendarProgramIsMutable();
                    this.calendarProgram_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Calendar.Calendar_post.Builder getCalendarProgramBuilder(int i) {
                return getCalendarProgramFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public Calendar.Calendar_postOrBuilder getCalendarProgramOrBuilder(int i) {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.calendarProgram_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.Message.Sauna_to_externalOrBuilder
            public List<? extends Calendar.Calendar_postOrBuilder> getCalendarProgramOrBuilderList() {
                RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> repeatedFieldBuilderV3 = this.calendarProgramBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.calendarProgram_);
            }

            public Calendar.Calendar_post.Builder addCalendarProgramBuilder() {
                return getCalendarProgramFieldBuilder().addBuilder(Calendar.Calendar_post.getDefaultInstance());
            }

            public Calendar.Calendar_post.Builder addCalendarProgramBuilder(int i) {
                return getCalendarProgramFieldBuilder().addBuilder(i, Calendar.Calendar_post.getDefaultInstance());
            }

            public List<Calendar.Calendar_post.Builder> getCalendarProgramBuilderList() {
                return getCalendarProgramFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Calendar.Calendar_post, Calendar.Calendar_post.Builder, Calendar.Calendar_postOrBuilder> getCalendarProgramFieldBuilder() {
                if (this.calendarProgramBuilder_ == null) {
                    this.calendarProgramBuilder_ = new RepeatedFieldBuilderV3<>(this.calendarProgram_, (this.bitField0_ & 4096) != 0, getParentForChildren(), isClean());
                    this.calendarProgram_ = null;
                }
                return this.calendarProgramBuilder_;
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

        public static Sauna_to_external getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Sauna_to_external> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Sauna_to_external> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Sauna_to_external getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_External_to_sauna_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"ConnectRequest", "DisconnectRequest", "KeepAlive", "GeneralCommand", "IntegerValue", "UserMessage", "SaunaState", "EnumValue", "Favorite", "BooleanValue", "AuxRelay", "CalendarProgram"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_descriptor = descriptor3;
        internal_static_com_tylohelo_tylohelo_protobuf_Sauna_to_external_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"ConnectReply", "NoConnection", "KeepAlive", "IntegerValue", "PresentedValue", "UserMessage", "UserSetting", "SaunaState", "EnumValue", "BooleanValue", "Favorite", "AuxRelaySauna", "CalendarProgram"});
        AuxRelay.getDescriptor();
        Command.getDescriptor();
        Calendar.getDescriptor();
        IntegerValue.getDescriptor();
        PresentedValue.getDescriptor();
        UserMessage.getDescriptor();
        UserSetting.getDescriptor();
        SaunaState.getDescriptor();
        EnumValue.getDescriptor();
        BooleanValue.getDescriptor();
        Favorite.getDescriptor();
        Connect.getDescriptor();
    }
}
