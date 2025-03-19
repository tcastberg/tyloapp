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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.tylohelo.tylohelo.protobuf.Node;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class SaunaState {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011sauna_state.proto\u0012\u001ecom.tylohelo.tylohelo.protobuf\u001a\nnode.proto\"\u0081\u0001\n\u0005Relay\u0012G\n\rcontrol_board\u0018\n \u0001(\u000e20.com.tylohelo.tylohelo.protobuf.Node_types.rcb_t\u0012\r\n\u0005index\u0018\u000b \u0001(\r\u0012\u0011\n\tavailable\u0018\f \u0001(\b\u0012\r\n\u0005state\u0018\r \u0001(\b\"\u00ad\u0002\n\u0013Sauna_state_changed\u0012J\n\u0005state\u0018\u000b \u0001(\u000e2;.com.tylohelo.tylohelo.protobuf.Sauna_state_changed.state_t\u0012\u0012\n\ntime_valid\u0018\f \u0001(\b\u0012\f\n\u0004time\u0018\r \u0001(\u0004\u00124\n\u0005relay\u0018\u000e \u0003(\u000b2%.com.tylohelo.tylohelo.protobuf.Relay\"r\n\u0007state_t\u0012\r\n\tSTATE_OFF\u0010\n\u0012\f\n\bSTATE_ON\u0010\u000b\u0012\u0011\n\rSTATE_STANDBY\u0010\f\u0012\u000f\n\u000bSTATE_DRYUP\u0010\r\u0012\u0011\n\rSTATE_CLEANUP\u0010\u000e\u0012\u0013\n\u000fSTATE_DESCALING\u0010\u000f\"¸\u0001\n\u001aSauna_state_change_request\u0012Q\n\u0005state\u0018\n \u0001(\u000e2B.com.tylohelo.tylohelo.protobuf.Sauna_state_change_request.state_t\u0012\f\n\u0004time\u0018\u000b \u0001(\u0004\"9\n\u0007state_t\u0012\r\n\tSTATE_OFF\u0010\n\u0012\f\n\bSTATE_ON\u0010\u000b\u0012\u0011\n\rSTATE_STANDBY\u0010\fB\u0002H\u0003"}, new Descriptors.FileDescriptor[]{Node.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Relay_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Relay_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_fieldAccessorTable;

    public interface RelayOrBuilder extends MessageOrBuilder {
        boolean getAvailable();

        Node.Node_types.rcb_t getControlBoard();

        int getIndex();

        boolean getState();

        boolean hasAvailable();

        boolean hasControlBoard();

        boolean hasIndex();

        boolean hasState();
    }

    public interface Sauna_state_change_requestOrBuilder extends MessageOrBuilder {
        Sauna_state_change_request.state_t getState();

        long getTime();

        boolean hasState();

        boolean hasTime();
    }

    public interface Sauna_state_changedOrBuilder extends MessageOrBuilder {
        Relay getRelay(int i);

        int getRelayCount();

        List<Relay> getRelayList();

        RelayOrBuilder getRelayOrBuilder(int i);

        List<? extends RelayOrBuilder> getRelayOrBuilderList();

        Sauna_state_changed.state_t getState();

        long getTime();

        boolean getTimeValid();

        boolean hasState();

        boolean hasTime();

        boolean hasTimeValid();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private SaunaState() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Relay extends GeneratedMessageV3 implements RelayOrBuilder {
        public static final int AVAILABLE_FIELD_NUMBER = 12;
        public static final int CONTROL_BOARD_FIELD_NUMBER = 10;
        public static final int INDEX_FIELD_NUMBER = 11;
        public static final int STATE_FIELD_NUMBER = 13;
        private static final long serialVersionUID = 0;
        private boolean available_;
        private int bitField0_;
        private int controlBoard_;
        private int index_;
        private byte memoizedIsInitialized;
        private boolean state_;
        private static final Relay DEFAULT_INSTANCE = new Relay();

        @Deprecated
        public static final Parser<Relay> PARSER = new AbstractParser<Relay>() { // from class: com.tylohelo.tylohelo.protobuf.SaunaState.Relay.1
            @Override // com.google.protobuf.Parser
            public Relay parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Relay.newBuilder();
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

        static /* synthetic */ int access$976(Relay relay, int i) {
            int i2 = i | relay.bitField0_;
            relay.bitField0_ = i2;
            return i2;
        }

        private Relay(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.controlBoard_ = 0;
            this.index_ = 0;
            this.available_ = false;
            this.state_ = false;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Relay() {
            this.index_ = 0;
            this.available_ = false;
            this.state_ = false;
            this.memoizedIsInitialized = (byte) -1;
            this.controlBoard_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Relay();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Relay_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Relay_fieldAccessorTable.ensureFieldAccessorsInitialized(Relay.class, Builder.class);
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
        public boolean hasControlBoard() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
        public Node.Node_types.rcb_t getControlBoard() {
            Node.Node_types.rcb_t forNumber = Node.Node_types.rcb_t.forNumber(this.controlBoard_);
            return forNumber == null ? Node.Node_types.rcb_t.RCB_MASTER : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
        public boolean hasIndex() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
        public boolean hasAvailable() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
        public boolean getAvailable() {
            return this.available_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
        public boolean hasState() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
        public boolean getState() {
            return this.state_;
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
                codedOutputStream.writeEnum(10, this.controlBoard_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeUInt32(11, this.index_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeBool(12, this.available_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.writeBool(13, this.state_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(10, this.controlBoard_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += CodedOutputStream.computeUInt32Size(11, this.index_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeEnumSize += CodedOutputStream.computeBoolSize(12, this.available_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeEnumSize += CodedOutputStream.computeBoolSize(13, this.state_);
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
            if (!(obj instanceof Relay)) {
                return super.equals(obj);
            }
            Relay relay = (Relay) obj;
            if (hasControlBoard() != relay.hasControlBoard()) {
                return false;
            }
            if ((hasControlBoard() && this.controlBoard_ != relay.controlBoard_) || hasIndex() != relay.hasIndex()) {
                return false;
            }
            if ((hasIndex() && getIndex() != relay.getIndex()) || hasAvailable() != relay.hasAvailable()) {
                return false;
            }
            if ((!hasAvailable() || getAvailable() == relay.getAvailable()) && hasState() == relay.hasState()) {
                return (!hasState() || getState() == relay.getState()) && getUnknownFields().equals(relay.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasControlBoard()) {
                hashCode = (((hashCode * 37) + 10) * 53) + this.controlBoard_;
            }
            if (hasIndex()) {
                hashCode = (((hashCode * 37) + 11) * 53) + getIndex();
            }
            if (hasAvailable()) {
                hashCode = (((hashCode * 37) + 12) * 53) + Internal.hashBoolean(getAvailable());
            }
            if (hasState()) {
                hashCode = (((hashCode * 37) + 13) * 53) + Internal.hashBoolean(getState());
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Relay parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Relay parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Relay parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Relay parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Relay parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Relay parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Relay parseFrom(InputStream inputStream) throws IOException {
            return (Relay) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Relay parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Relay) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Relay parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Relay) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Relay parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Relay) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Relay parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Relay) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Relay parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Relay) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Relay relay) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(relay);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RelayOrBuilder {
            private boolean available_;
            private int bitField0_;
            private int controlBoard_;
            private int index_;
            private boolean state_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Relay_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Relay_fieldAccessorTable.ensureFieldAccessorsInitialized(Relay.class, Builder.class);
            }

            private Builder() {
                this.controlBoard_ = 0;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.controlBoard_ = 0;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.controlBoard_ = 0;
                this.index_ = 0;
                this.available_ = false;
                this.state_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Relay_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Relay getDefaultInstanceForType() {
                return Relay.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Relay build() {
                Relay buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Relay buildPartial() {
                Relay relay = new Relay(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(relay);
                }
                onBuilt();
                return relay;
            }

            private void buildPartial0(Relay relay) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    relay.controlBoard_ = this.controlBoard_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    relay.index_ = this.index_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    relay.available_ = this.available_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    relay.state_ = this.state_;
                    i |= 8;
                }
                Relay.access$976(relay, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Relay) {
                    return mergeFrom((Relay) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Relay relay) {
                if (relay == Relay.getDefaultInstance()) {
                    return this;
                }
                if (relay.hasControlBoard()) {
                    setControlBoard(relay.getControlBoard());
                }
                if (relay.hasIndex()) {
                    setIndex(relay.getIndex());
                }
                if (relay.hasAvailable()) {
                    setAvailable(relay.getAvailable());
                }
                if (relay.hasState()) {
                    setState(relay.getState());
                }
                mergeUnknownFields(relay.getUnknownFields());
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
                                    if (Node.Node_types.rcb_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(10, readEnum);
                                    } else {
                                        this.controlBoard_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                } else if (readTag == 88) {
                                    this.index_ = codedInputStream.readUInt32();
                                    this.bitField0_ |= 2;
                                } else if (readTag == 96) {
                                    this.available_ = codedInputStream.readBool();
                                    this.bitField0_ |= 4;
                                } else if (readTag == 104) {
                                    this.state_ = codedInputStream.readBool();
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

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
            public boolean hasControlBoard() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
            public Node.Node_types.rcb_t getControlBoard() {
                Node.Node_types.rcb_t forNumber = Node.Node_types.rcb_t.forNumber(this.controlBoard_);
                return forNumber == null ? Node.Node_types.rcb_t.RCB_MASTER : forNumber;
            }

            public Builder setControlBoard(Node.Node_types.rcb_t rcb_tVar) {
                rcb_tVar.getClass();
                this.bitField0_ |= 1;
                this.controlBoard_ = rcb_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearControlBoard() {
                this.bitField0_ &= -2;
                this.controlBoard_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
            public boolean hasIndex() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
            public int getIndex() {
                return this.index_;
            }

            public Builder setIndex(int i) {
                this.index_ = i;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.bitField0_ &= -3;
                this.index_ = 0;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
            public boolean hasAvailable() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
            public boolean getAvailable() {
                return this.available_;
            }

            public Builder setAvailable(boolean z) {
                this.available_ = z;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearAvailable() {
                this.bitField0_ &= -5;
                this.available_ = false;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
            public boolean hasState() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.RelayOrBuilder
            public boolean getState() {
                return this.state_;
            }

            public Builder setState(boolean z) {
                this.state_ = z;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= -9;
                this.state_ = false;
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

        public static Relay getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Relay> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Relay> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Relay getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Sauna_state_changed extends GeneratedMessageV3 implements Sauna_state_changedOrBuilder {
        private static final Sauna_state_changed DEFAULT_INSTANCE = new Sauna_state_changed();

        @Deprecated
        public static final Parser<Sauna_state_changed> PARSER = new AbstractParser<Sauna_state_changed>() { // from class: com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changed.1
            @Override // com.google.protobuf.Parser
            public Sauna_state_changed parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Sauna_state_changed.newBuilder();
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
        public static final int RELAY_FIELD_NUMBER = 14;
        public static final int STATE_FIELD_NUMBER = 11;
        public static final int TIME_FIELD_NUMBER = 13;
        public static final int TIME_VALID_FIELD_NUMBER = 12;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private List<Relay> relay_;
        private int state_;
        private boolean timeValid_;
        private long time_;

        static /* synthetic */ int access$1976(Sauna_state_changed sauna_state_changed, int i) {
            int i2 = i | sauna_state_changed.bitField0_;
            sauna_state_changed.bitField0_ = i2;
            return i2;
        }

        private Sauna_state_changed(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.state_ = 10;
            this.timeValid_ = false;
            this.time_ = 0L;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Sauna_state_changed() {
            this.timeValid_ = false;
            this.time_ = 0L;
            this.memoizedIsInitialized = (byte) -1;
            this.state_ = 10;
            this.relay_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Sauna_state_changed();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_fieldAccessorTable.ensureFieldAccessorsInitialized(Sauna_state_changed.class, Builder.class);
        }

        public enum state_t implements ProtocolMessageEnum {
            STATE_OFF(10),
            STATE_ON(11),
            STATE_STANDBY(12),
            STATE_DRYUP(13),
            STATE_CLEANUP(14),
            STATE_DESCALING(15);

            public static final int STATE_CLEANUP_VALUE = 14;
            public static final int STATE_DESCALING_VALUE = 15;
            public static final int STATE_DRYUP_VALUE = 13;
            public static final int STATE_OFF_VALUE = 10;
            public static final int STATE_ON_VALUE = 11;
            public static final int STATE_STANDBY_VALUE = 12;
            private final int value;
            private static final Internal.EnumLiteMap<state_t> internalValueMap = new Internal.EnumLiteMap<state_t>() { // from class: com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changed.state_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public state_t findValueByNumber(int i) {
                    return state_t.forNumber(i);
                }
            };
            private static final state_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static state_t valueOf(int i) {
                return forNumber(i);
            }

            public static state_t forNumber(int i) {
                switch (i) {
                    case 10:
                        return STATE_OFF;
                    case 11:
                        return STATE_ON;
                    case 12:
                        return STATE_STANDBY;
                    case 13:
                        return STATE_DRYUP;
                    case 14:
                        return STATE_CLEANUP;
                    case 15:
                        return STATE_DESCALING;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<state_t> internalGetValueMap() {
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
                return Sauna_state_changed.getDescriptor().getEnumTypes().get(0);
            }

            public static state_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            state_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public boolean hasState() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public state_t getState() {
            state_t forNumber = state_t.forNumber(this.state_);
            return forNumber == null ? state_t.STATE_OFF : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public boolean hasTimeValid() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public boolean getTimeValid() {
            return this.timeValid_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public List<Relay> getRelayList() {
            return this.relay_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public List<? extends RelayOrBuilder> getRelayOrBuilderList() {
            return this.relay_;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public int getRelayCount() {
            return this.relay_.size();
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public Relay getRelay(int i) {
            return this.relay_.get(i);
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
        public RelayOrBuilder getRelayOrBuilder(int i) {
            return this.relay_.get(i);
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
                codedOutputStream.writeEnum(11, this.state_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeBool(12, this.timeValid_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeUInt64(13, this.time_);
            }
            for (int i = 0; i < this.relay_.size(); i++) {
                codedOutputStream.writeMessage(14, this.relay_.get(i));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(11, this.state_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += CodedOutputStream.computeBoolSize(12, this.timeValid_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeEnumSize += CodedOutputStream.computeUInt64Size(13, this.time_);
            }
            for (int i2 = 0; i2 < this.relay_.size(); i2++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(14, this.relay_.get(i2));
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
            if (!(obj instanceof Sauna_state_changed)) {
                return super.equals(obj);
            }
            Sauna_state_changed sauna_state_changed = (Sauna_state_changed) obj;
            if (hasState() != sauna_state_changed.hasState()) {
                return false;
            }
            if ((hasState() && this.state_ != sauna_state_changed.state_) || hasTimeValid() != sauna_state_changed.hasTimeValid()) {
                return false;
            }
            if ((!hasTimeValid() || getTimeValid() == sauna_state_changed.getTimeValid()) && hasTime() == sauna_state_changed.hasTime()) {
                return (!hasTime() || getTime() == sauna_state_changed.getTime()) && getRelayList().equals(sauna_state_changed.getRelayList()) && getUnknownFields().equals(sauna_state_changed.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasState()) {
                hashCode = (((hashCode * 37) + 11) * 53) + this.state_;
            }
            if (hasTimeValid()) {
                hashCode = (((hashCode * 37) + 12) * 53) + Internal.hashBoolean(getTimeValid());
            }
            if (hasTime()) {
                hashCode = (((hashCode * 37) + 13) * 53) + Internal.hashLong(getTime());
            }
            if (getRelayCount() > 0) {
                hashCode = (((hashCode * 37) + 14) * 53) + getRelayList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Sauna_state_changed parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Sauna_state_changed parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Sauna_state_changed parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Sauna_state_changed parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Sauna_state_changed parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Sauna_state_changed parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Sauna_state_changed parseFrom(InputStream inputStream) throws IOException {
            return (Sauna_state_changed) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Sauna_state_changed parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_state_changed) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Sauna_state_changed parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Sauna_state_changed) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Sauna_state_changed parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_state_changed) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Sauna_state_changed parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Sauna_state_changed) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Sauna_state_changed parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_state_changed) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Sauna_state_changed sauna_state_changed) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sauna_state_changed);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Sauna_state_changedOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> relayBuilder_;
            private List<Relay> relay_;
            private int state_;
            private boolean timeValid_;
            private long time_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_fieldAccessorTable.ensureFieldAccessorsInitialized(Sauna_state_changed.class, Builder.class);
            }

            private Builder() {
                this.state_ = 10;
                this.relay_ = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.state_ = 10;
                this.relay_ = Collections.emptyList();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.state_ = 10;
                this.timeValid_ = false;
                this.time_ = 0L;
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.relay_ = Collections.emptyList();
                } else {
                    this.relay_ = null;
                    repeatedFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Sauna_state_changed getDefaultInstanceForType() {
                return Sauna_state_changed.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Sauna_state_changed build() {
                Sauna_state_changed buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Sauna_state_changed buildPartial() {
                Sauna_state_changed sauna_state_changed = new Sauna_state_changed(this);
                buildPartialRepeatedFields(sauna_state_changed);
                if (this.bitField0_ != 0) {
                    buildPartial0(sauna_state_changed);
                }
                onBuilt();
                return sauna_state_changed;
            }

            private void buildPartialRepeatedFields(Sauna_state_changed sauna_state_changed) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    sauna_state_changed.relay_ = repeatedFieldBuilderV3.build();
                    return;
                }
                if ((this.bitField0_ & 8) != 0) {
                    this.relay_ = Collections.unmodifiableList(this.relay_);
                    this.bitField0_ &= -9;
                }
                sauna_state_changed.relay_ = this.relay_;
            }

            private void buildPartial0(Sauna_state_changed sauna_state_changed) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    sauna_state_changed.state_ = this.state_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    sauna_state_changed.timeValid_ = this.timeValid_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    sauna_state_changed.time_ = this.time_;
                    i |= 4;
                }
                Sauna_state_changed.access$1976(sauna_state_changed, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Sauna_state_changed) {
                    return mergeFrom((Sauna_state_changed) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Sauna_state_changed sauna_state_changed) {
                if (sauna_state_changed == Sauna_state_changed.getDefaultInstance()) {
                    return this;
                }
                if (sauna_state_changed.hasState()) {
                    setState(sauna_state_changed.getState());
                }
                if (sauna_state_changed.hasTimeValid()) {
                    setTimeValid(sauna_state_changed.getTimeValid());
                }
                if (sauna_state_changed.hasTime()) {
                    setTime(sauna_state_changed.getTime());
                }
                if (this.relayBuilder_ == null) {
                    if (!sauna_state_changed.relay_.isEmpty()) {
                        if (this.relay_.isEmpty()) {
                            this.relay_ = sauna_state_changed.relay_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureRelayIsMutable();
                            this.relay_.addAll(sauna_state_changed.relay_);
                        }
                        onChanged();
                    }
                } else if (!sauna_state_changed.relay_.isEmpty()) {
                    if (!this.relayBuilder_.isEmpty()) {
                        this.relayBuilder_.addAllMessages(sauna_state_changed.relay_);
                    } else {
                        this.relayBuilder_.dispose();
                        this.relayBuilder_ = null;
                        this.relay_ = sauna_state_changed.relay_;
                        this.bitField0_ &= -9;
                        this.relayBuilder_ = Sauna_state_changed.alwaysUseFieldBuilders ? getRelayFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(sauna_state_changed.getUnknownFields());
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
                                    if (state_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(11, readEnum);
                                    } else {
                                        this.state_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                } else if (readTag == 96) {
                                    this.timeValid_ = codedInputStream.readBool();
                                    this.bitField0_ |= 2;
                                } else if (readTag == 104) {
                                    this.time_ = codedInputStream.readUInt64();
                                    this.bitField0_ |= 4;
                                } else if (readTag == 114) {
                                    Relay relay = (Relay) codedInputStream.readMessage(Relay.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                                    if (repeatedFieldBuilderV3 == null) {
                                        ensureRelayIsMutable();
                                        this.relay_.add(relay);
                                    } else {
                                        repeatedFieldBuilderV3.addMessage(relay);
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

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public boolean hasState() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public state_t getState() {
                state_t forNumber = state_t.forNumber(this.state_);
                return forNumber == null ? state_t.STATE_OFF : forNumber;
            }

            public Builder setState(state_t state_tVar) {
                state_tVar.getClass();
                this.bitField0_ |= 1;
                this.state_ = state_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= -2;
                this.state_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public boolean hasTimeValid() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public boolean getTimeValid() {
                return this.timeValid_;
            }

            public Builder setTimeValid(boolean z) {
                this.timeValid_ = z;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearTimeValid() {
                this.bitField0_ &= -3;
                this.timeValid_ = false;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public boolean hasTime() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public long getTime() {
                return this.time_;
            }

            public Builder setTime(long j) {
                this.time_ = j;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.bitField0_ &= -5;
                this.time_ = 0L;
                onChanged();
                return this;
            }

            private void ensureRelayIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.relay_ = new ArrayList(this.relay_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public List<Relay> getRelayList() {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.relay_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public int getRelayCount() {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.relay_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public Relay getRelay(int i) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.relay_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setRelay(int i, Relay relay) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    relay.getClass();
                    ensureRelayIsMutable();
                    this.relay_.set(i, relay);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, relay);
                }
                return this;
            }

            public Builder setRelay(int i, Relay.Builder builder) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRelayIsMutable();
                    this.relay_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addRelay(Relay relay) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    relay.getClass();
                    ensureRelayIsMutable();
                    this.relay_.add(relay);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(relay);
                }
                return this;
            }

            public Builder addRelay(int i, Relay relay) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    relay.getClass();
                    ensureRelayIsMutable();
                    this.relay_.add(i, relay);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, relay);
                }
                return this;
            }

            public Builder addRelay(Relay.Builder builder) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRelayIsMutable();
                    this.relay_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addRelay(int i, Relay.Builder builder) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRelayIsMutable();
                    this.relay_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllRelay(Iterable<? extends Relay> iterable) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRelayIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.relay_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearRelay() {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.relay_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeRelay(int i) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRelayIsMutable();
                    this.relay_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Relay.Builder getRelayBuilder(int i) {
                return getRelayFieldBuilder().getBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public RelayOrBuilder getRelayOrBuilder(int i) {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.relay_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_changedOrBuilder
            public List<? extends RelayOrBuilder> getRelayOrBuilderList() {
                RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> repeatedFieldBuilderV3 = this.relayBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.relay_);
            }

            public Relay.Builder addRelayBuilder() {
                return getRelayFieldBuilder().addBuilder(Relay.getDefaultInstance());
            }

            public Relay.Builder addRelayBuilder(int i) {
                return getRelayFieldBuilder().addBuilder(i, Relay.getDefaultInstance());
            }

            public List<Relay.Builder> getRelayBuilderList() {
                return getRelayFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Relay, Relay.Builder, RelayOrBuilder> getRelayFieldBuilder() {
                if (this.relayBuilder_ == null) {
                    this.relayBuilder_ = new RepeatedFieldBuilderV3<>(this.relay_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.relay_ = null;
                }
                return this.relayBuilder_;
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

        public static Sauna_state_changed getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Sauna_state_changed> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Sauna_state_changed> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Sauna_state_changed getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Sauna_state_change_request extends GeneratedMessageV3 implements Sauna_state_change_requestOrBuilder {
        private static final Sauna_state_change_request DEFAULT_INSTANCE = new Sauna_state_change_request();

        @Deprecated
        public static final Parser<Sauna_state_change_request> PARSER = new AbstractParser<Sauna_state_change_request>() { // from class: com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_request.1
            @Override // com.google.protobuf.Parser
            public Sauna_state_change_request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = Sauna_state_change_request.newBuilder();
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
        public static final int STATE_FIELD_NUMBER = 10;
        public static final int TIME_FIELD_NUMBER = 11;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int state_;
        private long time_;

        static /* synthetic */ int access$2876(Sauna_state_change_request sauna_state_change_request, int i) {
            int i2 = i | sauna_state_change_request.bitField0_;
            sauna_state_change_request.bitField0_ = i2;
            return i2;
        }

        private Sauna_state_change_request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.state_ = 10;
            this.time_ = 0L;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Sauna_state_change_request() {
            this.time_ = 0L;
            this.memoizedIsInitialized = (byte) -1;
            this.state_ = 10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Sauna_state_change_request();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Sauna_state_change_request.class, Builder.class);
        }

        public enum state_t implements ProtocolMessageEnum {
            STATE_OFF(10),
            STATE_ON(11),
            STATE_STANDBY(12);

            public static final int STATE_OFF_VALUE = 10;
            public static final int STATE_ON_VALUE = 11;
            public static final int STATE_STANDBY_VALUE = 12;
            private final int value;
            private static final Internal.EnumLiteMap<state_t> internalValueMap = new Internal.EnumLiteMap<state_t>() { // from class: com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_request.state_t.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public state_t findValueByNumber(int i) {
                    return state_t.forNumber(i);
                }
            };
            private static final state_t[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static state_t valueOf(int i) {
                return forNumber(i);
            }

            public static state_t forNumber(int i) {
                switch (i) {
                    case 10:
                        return STATE_OFF;
                    case 11:
                        return STATE_ON;
                    case 12:
                        return STATE_STANDBY;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<state_t> internalGetValueMap() {
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
                return Sauna_state_change_request.getDescriptor().getEnumTypes().get(0);
            }

            public static state_t valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            state_t(int i) {
                this.value = i;
            }
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_requestOrBuilder
        public boolean hasState() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_requestOrBuilder
        public state_t getState() {
            state_t forNumber = state_t.forNumber(this.state_);
            return forNumber == null ? state_t.STATE_OFF : forNumber;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_requestOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_requestOrBuilder
        public long getTime() {
            return this.time_;
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
                codedOutputStream.writeEnum(10, this.state_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeUInt64(11, this.time_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(10, this.state_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                computeEnumSize += CodedOutputStream.computeUInt64Size(11, this.time_);
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
            if (!(obj instanceof Sauna_state_change_request)) {
                return super.equals(obj);
            }
            Sauna_state_change_request sauna_state_change_request = (Sauna_state_change_request) obj;
            if (hasState() != sauna_state_change_request.hasState()) {
                return false;
            }
            if ((!hasState() || this.state_ == sauna_state_change_request.state_) && hasTime() == sauna_state_change_request.hasTime()) {
                return (!hasTime() || getTime() == sauna_state_change_request.getTime()) && getUnknownFields().equals(sauna_state_change_request.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasState()) {
                hashCode = (((hashCode * 37) + 10) * 53) + this.state_;
            }
            if (hasTime()) {
                hashCode = (((hashCode * 37) + 11) * 53) + Internal.hashLong(getTime());
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Sauna_state_change_request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Sauna_state_change_request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Sauna_state_change_request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Sauna_state_change_request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Sauna_state_change_request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Sauna_state_change_request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Sauna_state_change_request parseFrom(InputStream inputStream) throws IOException {
            return (Sauna_state_change_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Sauna_state_change_request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_state_change_request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Sauna_state_change_request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Sauna_state_change_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Sauna_state_change_request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_state_change_request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Sauna_state_change_request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Sauna_state_change_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Sauna_state_change_request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Sauna_state_change_request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Sauna_state_change_request sauna_state_change_request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sauna_state_change_request);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Sauna_state_change_requestOrBuilder {
            private int bitField0_;
            private int state_;
            private long time_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_fieldAccessorTable.ensureFieldAccessorsInitialized(Sauna_state_change_request.class, Builder.class);
            }

            private Builder() {
                this.state_ = 10;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.state_ = 10;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.state_ = 10;
                this.time_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SaunaState.internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Sauna_state_change_request getDefaultInstanceForType() {
                return Sauna_state_change_request.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Sauna_state_change_request build() {
                Sauna_state_change_request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Sauna_state_change_request buildPartial() {
                Sauna_state_change_request sauna_state_change_request = new Sauna_state_change_request(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(sauna_state_change_request);
                }
                onBuilt();
                return sauna_state_change_request;
            }

            private void buildPartial0(Sauna_state_change_request sauna_state_change_request) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    sauna_state_change_request.state_ = this.state_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    sauna_state_change_request.time_ = this.time_;
                    i |= 2;
                }
                Sauna_state_change_request.access$2876(sauna_state_change_request, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Sauna_state_change_request) {
                    return mergeFrom((Sauna_state_change_request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Sauna_state_change_request sauna_state_change_request) {
                if (sauna_state_change_request == Sauna_state_change_request.getDefaultInstance()) {
                    return this;
                }
                if (sauna_state_change_request.hasState()) {
                    setState(sauna_state_change_request.getState());
                }
                if (sauna_state_change_request.hasTime()) {
                    setTime(sauna_state_change_request.getTime());
                }
                mergeUnknownFields(sauna_state_change_request.getUnknownFields());
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
                                    if (state_t.forNumber(readEnum) == null) {
                                        mergeUnknownVarintField(10, readEnum);
                                    } else {
                                        this.state_ = readEnum;
                                        this.bitField0_ |= 1;
                                    }
                                } else if (readTag == 88) {
                                    this.time_ = codedInputStream.readUInt64();
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

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_requestOrBuilder
            public boolean hasState() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_requestOrBuilder
            public state_t getState() {
                state_t forNumber = state_t.forNumber(this.state_);
                return forNumber == null ? state_t.STATE_OFF : forNumber;
            }

            public Builder setState(state_t state_tVar) {
                state_tVar.getClass();
                this.bitField0_ |= 1;
                this.state_ = state_tVar.getNumber();
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= -2;
                this.state_ = 10;
                onChanged();
                return this;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_requestOrBuilder
            public boolean hasTime() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.tylohelo.tylohelo.protobuf.SaunaState.Sauna_state_change_requestOrBuilder
            public long getTime() {
                return this.time_;
            }

            public Builder setTime(long j) {
                this.time_ = j;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.bitField0_ &= -3;
                this.time_ = 0L;
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

        public static Sauna_state_change_request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Sauna_state_change_request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Sauna_state_change_request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Sauna_state_change_request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_tylohelo_tylohelo_protobuf_Relay_descriptor = descriptor2;
        internal_static_com_tylohelo_tylohelo_protobuf_Relay_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"ControlBoard", "Index", "Available", "State"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_descriptor = descriptor3;
        internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_changed_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"State", "TimeValid", "Time", "Relay"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_descriptor = descriptor4;
        internal_static_com_tylohelo_tylohelo_protobuf_Sauna_state_change_request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"State", "Time"});
        Node.getDescriptor();
    }
}
