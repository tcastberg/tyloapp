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
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class UserMessage {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012user_message.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"°\u0003\n\fUser_message\u0012\u0010\n\bidentity\u0018\u0001 \u0001(\r\u0012Q\n\fmessage_type\u0018\u0002 \u0001(\u000e2;.com.tylohelo.tylohelo.protobuf.User_message.message_type_t\u0012E\n\u0006answer\u0018\u0003 \u0001(\u000e25.com.tylohelo.tylohelo.protobuf.User_message.answer_t\u0012\u0019\n\u0011presentation_time\u0018\u0004 \u0001(\r\u0012\u001f\n\u0017formatted_panel_message\u0018\u0005 \u0003(\r\"m\n\u000emessage_type_t\u0012\u0013\n\u000fTYPE_NO_MESSAGE\u0010\n\u0012\u000b\n\u0007TYPE_OK\u0010\u000b\u0012\u000f\n\u000bTYPE_YES_NO\u0010\f\u0012\u000e\n\nTYPE_ERROR\u0010\r\u0012\u0018\n\u0014TYPE_ERROR_NO_BUTTON\u0010\u000e\"I\n\banswer_t\u0012\u000f\n\u000bANSWER_NONE\u0010\u0014\u0012\r\n\tANSWER_OK\u0010\u0015\u0012\u000e\n\nANSWER_YES\u0010\u0016\u0012\r\n\tANSWER_NO\u0010\u0018B\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_User_message_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_User_message_fieldAccessorTable;

    public interface User_messageOrBuilder extends MessageOrBuilder {
        User_message.answer_t getAnswer();

        int getFormattedPanelMessage(int i);

        int getFormattedPanelMessageCount();

        List<Integer> getFormattedPanelMessageList();

        int getIdentity();

        User_message.message_type_t getMessageType();

        int getPresentationTime();

        boolean hasAnswer();

        boolean hasIdentity();

        boolean hasMessageType();

        boolean hasPresentationTime();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private UserMessage() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class User_message extends GeneratedMessageV3 implements User_messageOrBuilder {
        public static final int ANSWER_FIELD_NUMBER = 3;
        public static final int FORMATTED_PANEL_MESSAGE_FIELD_NUMBER = 5;
        public static final int IDENTITY_FIELD_NUMBER = 1;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 2;
        public static final int PRESENTATION_TIME_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int answer_;
        private int bitField0_;
        private Internal.IntList formattedPanelMessage_;
        private int identity_;
        private byte memoizedIsInitialized;
        private int messageType_;
        private int presentationTime_;
        private static final User_message DEFAULT_INSTANCE = new User_message();

        @Deprecated
        public static final Parser<User_message> PARSER = new AbstractParser<User_message>() { // from class: com.tylohelo.tylohelo.protobuf.UserMessage.User_message.1
            @Override // com.google.protobuf.Parser
            public User_message parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = User_message.newBuilder();
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

        static /* synthetic */ int access$1176(User_message user_message, int i) {
            int i2 = i | user_message.bitField0_;
            user_message.bitField0_ = i2;
            return i2;
        }

        private User_message(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.identity_ = 0;
            this.messageType_ = 10;
            this.answer_ = 20;
            this.presentationTime_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private User_message() {
            this.identity_ = 0;
            this.presentationTime_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.messageType_ = 10;
            this.answer_ = 20;
            this.formattedPanelMessage_ = emptyIntList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new User_message();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UserMessage.internal_static_com_tylohelo_tylohelo_protobuf_User_message_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UserMessage.internal_static_com_tylohelo_tylohelo_protobuf_User_message_fieldAccessorTable.ensureFieldAccessorsInitialized(User_message.class, Builder.class);
        }

        public enum message_type_t implements ProtocolMessageEnum {
            TYPE_NO_MESSAGE(10),
            TYPE_OK(11),
            TYPE_YES_NO(12),
            TYPE_ERROR(13),
            TYPE_ERROR_NO_BUTTON(14);

            public static final int TYPE_ERROR_NO_BUTTON_VALUE = 14;
            public static final int TYPE_ERROR_VALUE = 13;
            public static final int TYPE_NO_MESSAGE_VALUE = 10;
            public static final int TYPE_OK_VALUE = 11;
            public static final int TYPE_YES_NO_VALUE = 12;
            private final int value;
            private static final Internal.EnumLiteMap<message_type_t> internalValueMap = new Internal.EnumLiteMap<message_type_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserMessage.User_message.message_type_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public message_type_t findValueByNumber(int i) {
                    return message_type_t.forNumber(i);
                }
            };
            private static final message_type_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static message_type_t valueOf(int i) {
                return forNumber(i);
            }

            public static message_type_t forNumber(int i) {
                switch (i) {
                    case 10:
                        return TYPE_NO_MESSAGE;
                    case 11:
                        return TYPE_OK;
                    case 12:
                        return TYPE_YES_NO;
                    case 13:
                        return TYPE_ERROR;
                    case 14:
                        return TYPE_ERROR_NO_BUTTON;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<message_type_t> internalGetValueMap() {
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
                return User_message.getDescriptor().getEnumTypes().get(0);
            }

            public static message_type_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            message_type_t(int i) {
                this.value = i;
            }
        }

        public enum answer_t implements ProtocolMessageEnum {
            ANSWER_NONE(20),
            ANSWER_OK(21),
            ANSWER_YES(22),
            ANSWER_NO(24);

            public static final int ANSWER_NONE_VALUE = 20;
            public static final int ANSWER_NO_VALUE = 24;
            public static final int ANSWER_OK_VALUE = 21;
            public static final int ANSWER_YES_VALUE = 22;
            private final int value;
            private static final Internal.EnumLiteMap<answer_t> internalValueMap = new Internal.EnumLiteMap<answer_t>() { // from class: com.tylohelo.tylohelo.protobuf.UserMessage.User_message.answer_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public answer_t findValueByNumber(int i) {
                    return answer_t.forNumber(i);
                }
            };
            private static final answer_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static answer_t valueOf(int i) {
                return forNumber(i);
            }

            public static answer_t forNumber(int i) {
                switch (i) {
                    case 20:
                        return ANSWER_NONE;
                    case 21:
                        return ANSWER_OK;
                    case 22:
                        return ANSWER_YES;
                    case 23:
                    default:
                        return null;
                    case 24:
                        return ANSWER_NO;
                }
            }

            public static Internal.EnumLiteMap<answer_t> internalGetValueMap() {
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
                return User_message.getDescriptor().getEnumTypes().get(1);
            }

            public static answer_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            answer_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public boolean hasIdentity() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public int getIdentity() {
            return this.identity_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public boolean hasMessageType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public message_type_t getMessageType() {
            message_type_t forNumber = message_type_t.forNumber(this.messageType_);
            return forNumber == null ? message_type_t.TYPE_NO_MESSAGE : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public boolean hasAnswer() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public answer_t getAnswer() {
            answer_t forNumber = answer_t.forNumber(this.answer_);
            return forNumber == null ? answer_t.ANSWER_NONE : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public boolean hasPresentationTime() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public int getPresentationTime() {
            return this.presentationTime_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public List<Integer> getFormattedPanelMessageList() {
            return this.formattedPanelMessage_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public int getFormattedPanelMessageCount() {
            return this.formattedPanelMessage_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
        public int getFormattedPanelMessage(int i) {
            return this.formattedPanelMessage_.getInt(i);
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
                codedOutputStream.writeUInt32(1, this.identity_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeEnum(2, this.messageType_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeEnum(3, this.answer_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeUInt32(4, this.presentationTime_);
            }
            for (int i = 0; i < this.formattedPanelMessage_.size(); i++) {
                codedOutputStream.writeUInt32(5, this.formattedPanelMessage_.getInt(i));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeUInt32Size = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeUInt32Size(1, this.identity_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(2, this.messageType_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(3, this.answer_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(4, this.presentationTime_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.formattedPanelMessage_.size(); i3++) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(this.formattedPanelMessage_.getInt(i3));
            }
            int size = computeUInt32Size + i2 + getFormattedPanelMessageList().size() + getUnknownFields().getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof User_message)) {
                return super.equals(obj);
            }
            User_message user_message = (User_message) obj;
            if (hasIdentity() != user_message.hasIdentity()) {
                return false;
            }
            if ((hasIdentity() && getIdentity() != user_message.getIdentity()) || hasMessageType() != user_message.hasMessageType()) {
                return false;
            }
            if ((hasMessageType() && this.messageType_ != user_message.messageType_) || hasAnswer() != user_message.hasAnswer()) {
                return false;
            }
            if ((!hasAnswer() || this.answer_ == user_message.answer_) && hasPresentationTime() == user_message.hasPresentationTime()) {
                return (!hasPresentationTime() || getPresentationTime() == user_message.getPresentationTime()) && getFormattedPanelMessageList().equals(user_message.getFormattedPanelMessageList()) && getUnknownFields().equals(user_message.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasIdentity()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getIdentity();
            }
            if (hasMessageType()) {
                hashCode = (((hashCode * 37) + 2) * 53) + this.messageType_;
            }
            if (hasAnswer()) {
                hashCode = (((hashCode * 37) + 3) * 53) + this.answer_;
            }
            if (hasPresentationTime()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getPresentationTime();
            }
            if (getFormattedPanelMessageCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getFormattedPanelMessageList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static User_message parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static User_message parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static User_message parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static User_message parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static User_message parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static User_message parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static User_message parseFrom(InputStream inputStream) throws IOException {
            return (User_message) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static User_message parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (User_message) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static User_message parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (User_message) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static User_message parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (User_message) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static User_message parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (User_message) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static User_message parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (User_message) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(User_message user_message) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(user_message);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements User_messageOrBuilder {
            private int answer_;
            private int bitField0_;
            private Internal.IntList formattedPanelMessage_;
            private int identity_;
            private int messageType_;
            private int presentationTime_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return UserMessage.internal_static_com_tylohelo_tylohelo_protobuf_User_message_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UserMessage.internal_static_com_tylohelo_tylohelo_protobuf_User_message_fieldAccessorTable.ensureFieldAccessorsInitialized(User_message.class, Builder.class);
            }

            private Builder() {
                this.messageType_ = 10;
                this.answer_ = 20;
                this.formattedPanelMessage_ = User_message.emptyIntList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.messageType_ = 10;
                this.answer_ = 20;
                this.formattedPanelMessage_ = User_message.emptyIntList();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.identity_ = 0;
                this.messageType_ = 10;
                this.answer_ = 20;
                this.presentationTime_ = 0;
                this.formattedPanelMessage_ = User_message.emptyIntList();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UserMessage.internal_static_com_tylohelo_tylohelo_protobuf_User_message_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public User_message getDefaultInstanceForType() {
                return User_message.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public User_message build() {
                User_message buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public User_message buildPartial() {
                User_message user_message = new User_message(this);
                buildPartialRepeatedFields(user_message);
                if (this.bitField0_ != 0) {
                    buildPartial0(user_message);
                }
                onBuilt();
                return user_message;
            }

            private void buildPartialRepeatedFields(User_message user_message) {
                if ((this.bitField0_ & 16) != 0) {
                    this.formattedPanelMessage_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                user_message.formattedPanelMessage_ = this.formattedPanelMessage_;
            }

            private void buildPartial0(User_message user_message) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    user_message.identity_ = this.identity_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    user_message.messageType_ = this.messageType_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    user_message.answer_ = this.answer_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    user_message.presentationTime_ = this.presentationTime_;
                    i |= 8;
                }
                User_message.access$1176(user_message, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof User_message) {
                    return mergeFrom((User_message) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(User_message user_message) {
                if (user_message == User_message.getDefaultInstance()) {
                    return this;
                }
                if (user_message.hasIdentity()) {
                    setIdentity(user_message.getIdentity());
                }
                if (user_message.hasMessageType()) {
                    setMessageType(user_message.getMessageType());
                }
                if (user_message.hasAnswer()) {
                    setAnswer(user_message.getAnswer());
                }
                if (user_message.hasPresentationTime()) {
                    setPresentationTime(user_message.getPresentationTime());
                }
                if (!user_message.formattedPanelMessage_.isEmpty()) {
                    if (this.formattedPanelMessage_.isEmpty()) {
                        this.formattedPanelMessage_ = user_message.formattedPanelMessage_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureFormattedPanelMessageIsMutable();
                        this.formattedPanelMessage_.addAll(user_message.formattedPanelMessage_);
                    }
                    onChanged();
                }
                mergeUnknownFields(user_message.getUnknownFields());
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
                                    this.identity_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 1;
                                } else if (readTag == 16) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (message_type_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(2, readEnum);
                                    } else {
                                        this.messageType_ = readEnum;
                                        this.bitField0_ |= 2;
                                    }
                                } else if (readTag == 24) {
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (answer_t.forNumber(readEnum2) == null) {
                                        mergeUnknownVarintField(3, readEnum2);
                                    } else {
                                        this.answer_ = readEnum2;
                                        this.bitField0_ |= 4;
                                    }
                                } else if (readTag == 32) {
                                    this.presentationTime_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 8;
                                } else if (readTag == 40) {
                                    int readUInt32 = codedInputStream.readUInt32();
                                    ensureFormattedPanelMessageIsMutable();
                                    this.formattedPanelMessage_.addInt(readUInt32);
                                } else if (readTag == 42) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    ensureFormattedPanelMessageIsMutable();
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.formattedPanelMessage_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
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

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public boolean hasIdentity() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public int getIdentity() {
                return this.identity_;
            }

            public Builder setIdentity(int i) {
                this.identity_ = i;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearIdentity() {
                this.bitField0_ &= -2;
                this.identity_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public boolean hasMessageType() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public message_type_t getMessageType() {
                message_type_t forNumber = message_type_t.forNumber(this.messageType_);
                return forNumber == null ? message_type_t.TYPE_NO_MESSAGE : forNumber;
            }

            public Builder setMessageType(message_type_t message_type_tVar) {
                message_type_tVar.getClass();
                this.bitField0_ |= 2;
                this.messageType_ = message_type_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearMessageType() {
                this.bitField0_ &= -3;
                this.messageType_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public boolean hasAnswer() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public answer_t getAnswer() {
                answer_t forNumber = answer_t.forNumber(this.answer_);
                return forNumber == null ? answer_t.ANSWER_NONE : forNumber;
            }

            public Builder setAnswer(answer_t answer_tVar) {
                answer_tVar.getClass();
                this.bitField0_ |= 4;
                this.answer_ = answer_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAnswer() {
                this.bitField0_ &= -5;
                this.answer_ = 20;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public boolean hasPresentationTime() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public int getPresentationTime() {
                return this.presentationTime_;
            }

            public Builder setPresentationTime(int i) {
                this.presentationTime_ = i;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearPresentationTime() {
                this.bitField0_ &= -9;
                this.presentationTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureFormattedPanelMessageIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.formattedPanelMessage_ = User_message.mutableCopy(this.formattedPanelMessage_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public List<Integer> getFormattedPanelMessageList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.formattedPanelMessage_) : this.formattedPanelMessage_;
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public int getFormattedPanelMessageCount() {
                return this.formattedPanelMessage_.size();
            }

            @Override // com.tylohelo.tylohelo.protobuf.UserMessage.User_messageOrBuilder
            public int getFormattedPanelMessage(int i) {
                return this.formattedPanelMessage_.getInt(i);
            }

            public Builder setFormattedPanelMessage(int i, int i2) {
                ensureFormattedPanelMessageIsMutable();
                this.formattedPanelMessage_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addFormattedPanelMessage(int i) {
                ensureFormattedPanelMessageIsMutable();
                this.formattedPanelMessage_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllFormattedPanelMessage(Iterable<? extends Integer> iterable) {
                ensureFormattedPanelMessageIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.formattedPanelMessage_);
                onChanged();
                return this;
            }

            public Builder clearFormattedPanelMessage() {
                this.formattedPanelMessage_ = User_message.emptyIntList();
                this.bitField0_ &= -17;
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

        public static User_message getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<User_message> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<User_message> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public User_message getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_User_message_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_User_message_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Identity", "MessageType", "Answer", "PresentationTime", "FormattedPanelMessage"});
    }
}
