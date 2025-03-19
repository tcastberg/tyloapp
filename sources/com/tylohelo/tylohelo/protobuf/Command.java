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
public final class Command {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rcommand.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\"ç\u0001\n\u000fGeneral_command\u0012J\n\u0007command\u0018\u0001 \u0001(\u000e29.com.tylohelo.tylohelo.protobuf.General_command.command_t\"\u0087\u0001\n\tcommand_t\u0012\u0018\n\u0014SEND_CHARACTER_TABLE\u0010\u0002\u0012\u000e\n\nSEND_STATE\u0010\u0003\u0012\u001b\n\u0017SEND_MAX_HUMIDITY_TABLE\u0010\u0004\u0012\u001e\n\u001aSEND_MAX_TEMPERATURE_TABLE\u0010\u0005\u0012\u0013\n\u000fRENEW_BATH_TIME\u0010\u0006B\u0002H\u0003"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_General_command_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_General_command_fieldAccessorTable;

    public interface General_commandOrBuilder extends MessageOrBuilder {
        General_command.command_t getCommand();

        boolean hasCommand();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Command() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class General_command extends GeneratedMessageV3 implements General_commandOrBuilder {
        public static final int COMMAND_FIELD_NUMBER = 1;
        private static final General_command DEFAULT_INSTANCE = new General_command();

        @Deprecated
        public static final Parser<General_command> PARSER = new AbstractParser<General_command>() { // from class: com.tylohelo.tylohelo.protobuf.Command.General_command.1
            @Override // com.google.protobuf.Parser
            public General_command parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = General_command.newBuilder();
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
        private int command_;
        private byte memoizedIsInitialized;

        static /* synthetic */ int access$676(General_command general_command, int i) {
            int i2 = i | general_command.bitField0_;
            general_command.bitField0_ = i2;
            return i2;
        }

        private General_command(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.command_ = 2;
            this.memoizedIsInitialized = (byte) -1;
        }

        private General_command() {
            this.memoizedIsInitialized = (byte) -1;
            this.command_ = 2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new General_command();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Command.internal_static_com_tylohelo_tylohelo_protobuf_General_command_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Command.internal_static_com_tylohelo_tylohelo_protobuf_General_command_fieldAccessorTable.ensureFieldAccessorsInitialized(General_command.class, Builder.class);
        }

        public enum command_t implements ProtocolMessageEnum {
            SEND_CHARACTER_TABLE(2),
            SEND_STATE(3),
            SEND_MAX_HUMIDITY_TABLE(4),
            SEND_MAX_TEMPERATURE_TABLE(5),
            RENEW_BATH_TIME(6);

            public static final int RENEW_BATH_TIME_VALUE = 6;
            public static final int SEND_CHARACTER_TABLE_VALUE = 2;
            public static final int SEND_MAX_HUMIDITY_TABLE_VALUE = 4;
            public static final int SEND_MAX_TEMPERATURE_TABLE_VALUE = 5;
            public static final int SEND_STATE_VALUE = 3;
            private final int value;
            private static final Internal.EnumLiteMap<command_t> internalValueMap = new Internal.EnumLiteMap<command_t>() { // from class: com.tylohelo.tylohelo.protobuf.Command.General_command.command_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public command_t findValueByNumber(int i) {
                    return command_t.forNumber(i);
                }
            };
            private static final command_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static command_t valueOf(int i) {
                return forNumber(i);
            }

            public static command_t forNumber(int i) {
                if (i == 2) {
                    return SEND_CHARACTER_TABLE;
                }
                if (i == 3) {
                    return SEND_STATE;
                }
                if (i == 4) {
                    return SEND_MAX_HUMIDITY_TABLE;
                }
                if (i == 5) {
                    return SEND_MAX_TEMPERATURE_TABLE;
                }
                if (i != 6) {
                    return null;
                }
                return RENEW_BATH_TIME;
            }

            public static Internal.EnumLiteMap<command_t> internalGetValueMap() {
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
                return General_command.getDescriptor().getEnumTypes().get(0);
            }

            public static command_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            command_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.Command.General_commandOrBuilder
        public boolean hasCommand() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.Command.General_commandOrBuilder
        public command_t getCommand() {
            command_t forNumber = command_t.forNumber(this.command_);
            return forNumber == null ? command_t.SEND_CHARACTER_TABLE : forNumber;
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
                codedOutputStream.writeEnum(1, this.command_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = ((this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(1, this.command_) : 0) + getUnknownFields().getSerializedSize();
            this.memoizedSize = computeEnumSize;
            return computeEnumSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof General_command)) {
                return super.equals(obj);
            }
            General_command general_command = (General_command) obj;
            if (hasCommand() != general_command.hasCommand()) {
                return false;
            }
            return (!hasCommand() || this.command_ == general_command.command_) && getUnknownFields().equals(general_command.getUnknownFields());
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasCommand()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.command_;
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static General_command parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static General_command parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static General_command parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static General_command parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static General_command parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static General_command parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static General_command parseFrom(InputStream inputStream) throws IOException {
            return (General_command) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static General_command parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (General_command) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static General_command parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (General_command) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static General_command parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (General_command) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static General_command parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (General_command) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static General_command parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (General_command) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(General_command general_command) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(general_command);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements General_commandOrBuilder {
            private int bitField0_;
            private int command_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Command.internal_static_com_tylohelo_tylohelo_protobuf_General_command_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Command.internal_static_com_tylohelo_tylohelo_protobuf_General_command_fieldAccessorTable.ensureFieldAccessorsInitialized(General_command.class, Builder.class);
            }

            private Builder() {
                this.command_ = 2;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.command_ = 2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.command_ = 2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Command.internal_static_com_tylohelo_tylohelo_protobuf_General_command_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public General_command getDefaultInstanceForType() {
                return General_command.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public General_command build() {
                General_command buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public General_command buildPartial() {
                General_command general_command = new General_command(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(general_command);
                }
                onBuilt();
                return general_command;
            }

            private void buildPartial0(General_command general_command) {
                int i = 1;
                if ((this.bitField0_ & 1) != 0) {
                    general_command.command_ = this.command_;
                } else {
                    i = 0;
                }
                General_command.access$676(general_command, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof General_command) {
                    return mergeFrom((General_command) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(General_command general_command) {
                if (general_command == General_command.getDefaultInstance()) {
                    return this;
                }
                if (general_command.hasCommand()) {
                    setCommand(general_command.getCommand());
                }
                mergeUnknownFields(general_command.getUnknownFields());
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
                                    if (command_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(1, readEnum);
                                    } else {
                                        this.command_ = readEnum;
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

            @Override // com.tylohelo.tylohelo.protobuf.Command.General_commandOrBuilder
            public boolean hasCommand() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.Command.General_commandOrBuilder
            public command_t getCommand() {
                command_t forNumber = command_t.forNumber(this.command_);
                return forNumber == null ? command_t.SEND_CHARACTER_TABLE : forNumber;
            }

            public Builder setCommand(command_t command_tVar) {
                command_tVar.getClass();
                this.bitField0_ |= 1;
                this.command_ = command_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearCommand() {
                this.bitField0_ &= -2;
                this.command_ = 2;
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

        public static General_command getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<General_command> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<General_command> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public General_command getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_General_command_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_General_command_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Command"});
    }
}
