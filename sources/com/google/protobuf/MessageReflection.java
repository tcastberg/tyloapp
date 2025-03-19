package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
class MessageReflection {

    interface MergeTarget {

        public enum ContainerType {
            MESSAGE,
            EXTENSION_SET
        }

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value);

        MergeTarget clearField(Descriptors.FieldDescriptor field);

        MergeTarget clearOneof(Descriptors.OneofDescriptor oneof);

        ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name);

        ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber);

        Object finish();

        ContainerType getContainerType();

        Descriptors.Descriptor getDescriptorForType();

        Object getField(Descriptors.FieldDescriptor field);

        Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof);

        WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor);

        boolean hasField(Descriptors.FieldDescriptor field);

        boolean hasOneof(Descriptors.OneofDescriptor oneof);

        void mergeGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException;

        void mergeMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException;

        MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance);

        MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance);

        Object parseGroup(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor descriptor, Message defaultInstance) throws IOException;

        Object parseMessage(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor descriptor, Message defaultInstance) throws IOException;

        Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite registry, Descriptors.FieldDescriptor descriptor, Message defaultInstance) throws IOException;

        MergeTarget setField(Descriptors.FieldDescriptor field, Object value);

        MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value);
    }

    MessageReflection() {
    }

    static void writeMessageTo(Message message, Map<Descriptors.FieldDescriptor, Object> fields, CodedOutputStream output, boolean alwaysWriteRequiredFields) throws IOException {
        boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (alwaysWriteRequiredFields) {
            TreeMap treeMap = new TreeMap(fields);
            for (Descriptors.FieldDescriptor fieldDescriptor : message.getDescriptorForType().getFields()) {
                if (fieldDescriptor.isRequired() && !treeMap.containsKey(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, message.getField(fieldDescriptor));
                }
            }
            fields = treeMap;
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fields.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (messageSetWireFormat && key.isExtension() && key.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.isRepeated()) {
                output.writeMessageSetExtension(key.getNumber(), (Message) value);
            } else {
                FieldSet.writeField(key, value, output);
            }
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (messageSetWireFormat) {
            unknownFields.writeAsMessageSetTo(output);
        } else {
            unknownFields.writeTo(output);
        }
    }

    static int getSerializedSize(Message message, Map<Descriptors.FieldDescriptor, Object> fields) {
        int serializedSize;
        int computeFieldSize;
        boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        int i = 0;
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fields.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (messageSetWireFormat && key.isExtension() && key.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.isRepeated()) {
                computeFieldSize = CodedOutputStream.computeMessageSetExtensionSize(key.getNumber(), (Message) value);
            } else {
                computeFieldSize = FieldSet.computeFieldSize(key, value);
            }
            i += computeFieldSize;
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (messageSetWireFormat) {
            serializedSize = unknownFields.getSerializedSizeAsMessageSet();
        } else {
            serializedSize = unknownFields.getSerializedSize();
        }
        return i + serializedSize;
    }

    static String delimitWithCommas(List<String> parts) {
        StringBuilder sb = new StringBuilder();
        for (String str : parts) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    static boolean isInitialized(MessageOrBuilder message) {
        for (Descriptors.FieldDescriptor fieldDescriptor : message.getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !message.hasField(fieldDescriptor)) {
                return false;
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            if (key.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    Iterator it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        if (!((Message) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (!((Message) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String subMessagePrefix(final String prefix, final Descriptors.FieldDescriptor field, final int index) {
        StringBuilder sb = new StringBuilder(prefix);
        if (field.isExtension()) {
            sb.append('(').append(field.getFullName()).append(')');
        } else {
            sb.append(field.getName());
        }
        if (index != -1) {
            sb.append('[').append(index).append(']');
        }
        sb.append('.');
        return sb.toString();
    }

    private static void findMissingFields(final MessageOrBuilder message, final String prefix, final List<String> results) {
        for (Descriptors.FieldDescriptor fieldDescriptor : message.getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !message.hasField(fieldDescriptor)) {
                results.add(prefix + fieldDescriptor.getName());
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (key.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    Iterator it = ((List) value).iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        findMissingFields((MessageOrBuilder) it.next(), subMessagePrefix(prefix, key, i), results);
                        i++;
                    }
                } else if (message.hasField(key)) {
                    findMissingFields((MessageOrBuilder) value, subMessagePrefix(prefix, key, -1), results);
                }
            }
        }
    }

    static List<String> findMissingFields(final MessageOrBuilder message) {
        ArrayList arrayList = new ArrayList();
        findMissingFields(message, "", arrayList);
        return arrayList;
    }

    static class BuilderAdapter implements MergeTarget {
        private final Message.Builder builder;
        private boolean hasNestedBuilders = true;

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            return this.builder.getDescriptorForType();
        }

        public BuilderAdapter(Message.Builder builder) {
            this.builder = builder;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor field) {
            return this.builder.getField(field);
        }

        private Message.Builder getFieldBuilder(Descriptors.FieldDescriptor field) {
            if (!this.hasNestedBuilders) {
                return null;
            }
            try {
                return this.builder.getFieldBuilder(field);
            } catch (UnsupportedOperationException unused) {
                this.hasNestedBuilders = false;
                return null;
            }
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return this.builder.hasField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
            if (!field.isRepeated() && (value instanceof MessageLite.Builder)) {
                if (value != getFieldBuilder(field)) {
                    this.builder.setField(field, ((MessageLite.Builder) value).buildPartial());
                }
                return this;
            }
            this.builder.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor field) {
            this.builder.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            if (value instanceof MessageLite.Builder) {
                value = ((MessageLite.Builder) value).buildPartial();
            }
            this.builder.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            if (value instanceof MessageLite.Builder) {
                value = ((MessageLite.Builder) value).buildPartial();
            }
            this.builder.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return this.builder.hasOneof(oneof);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
            this.builder.clearOneof(oneof);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return this.builder.getOneofFieldDescriptor(oneof);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
            return registry.findImmutableExtensionByName(name);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
            return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder newBuilderForField;
            Message message;
            if (defaultInstance != null) {
                newBuilderForField = defaultInstance.newBuilderForType();
            } else {
                newBuilderForField = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForField.mergeFrom(message);
            }
            input.readGroup(field.getNumber(), newBuilderForField, extensionRegistry);
            return newBuilderForField.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder newBuilderForField;
            Message message;
            if (defaultInstance != null) {
                newBuilderForField = defaultInstance.newBuilderForType();
            } else {
                newBuilderForField = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForField.mergeFrom(message);
            }
            input.readMessage(newBuilderForField, extensionRegistry);
            return newBuilderForField.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder newBuilderForField;
            Message message;
            if (defaultInstance != null) {
                newBuilderForField = defaultInstance.newBuilderForType();
            } else {
                newBuilderForField = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForField.mergeFrom(message);
            }
            newBuilderForField.mergeFrom(bytes, extensionRegistry);
            return newBuilderForField.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder newMessageFieldInstance;
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    Message.Builder fieldBuilder = getFieldBuilder(field);
                    if (fieldBuilder != null) {
                        input.readGroup(field.getNumber(), fieldBuilder, extensionRegistry);
                        return;
                    } else {
                        newMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
                        newMessageFieldInstance.mergeFrom((Message) getField(field));
                    }
                } else {
                    newMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
                }
                input.readGroup(field.getNumber(), newMessageFieldInstance, extensionRegistry);
                setField(field, newMessageFieldInstance.buildPartial());
                return;
            }
            Message.Builder newMessageFieldInstance2 = newMessageFieldInstance(field, defaultInstance);
            input.readGroup(field.getNumber(), newMessageFieldInstance2, extensionRegistry);
            addRepeatedField(field, newMessageFieldInstance2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder newMessageFieldInstance;
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    Message.Builder fieldBuilder = getFieldBuilder(field);
                    if (fieldBuilder != null) {
                        input.readMessage(fieldBuilder, extensionRegistry);
                        return;
                    } else {
                        newMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
                        newMessageFieldInstance.mergeFrom((Message) getField(field));
                    }
                } else {
                    newMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
                }
                input.readMessage(newMessageFieldInstance, extensionRegistry);
                setField(field, newMessageFieldInstance.buildPartial());
                return;
            }
            Message.Builder newMessageFieldInstance2 = newMessageFieldInstance(field, defaultInstance);
            input.readMessage(newMessageFieldInstance2, extensionRegistry);
            addRepeatedField(field, newMessageFieldInstance2.buildPartial());
        }

        private Message.Builder newMessageFieldInstance(Descriptors.FieldDescriptor field, Message defaultInstance) {
            if (defaultInstance != null) {
                return defaultInstance.newBuilderForType();
            }
            return this.builder.newBuilderForField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor field, Message defaultInstance) {
            Message message;
            Message.Builder fieldBuilder;
            if (!field.isRepeated() && hasField(field) && (fieldBuilder = getFieldBuilder(field)) != null) {
                return new BuilderAdapter(fieldBuilder);
            }
            Message.Builder newMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newMessageFieldInstance.mergeFrom(message);
            }
            return new BuilderAdapter(newMessageFieldInstance);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor field, Message defaultInstance) {
            Message.Builder newBuilderForField;
            if (defaultInstance != null) {
                newBuilderForField = defaultInstance.newBuilderForType();
            } else {
                newBuilderForField = this.builder.newBuilderForField(field);
            }
            return new BuilderAdapter(newBuilderForField);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
            if (descriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            if (!descriptor.isRepeated() && (this.builder instanceof GeneratedMessage.Builder)) {
                return WireFormat.Utf8Validation.LAZY;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            return this.builder;
        }
    }

    static class ExtensionAdapter implements MergeTarget {
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return false;
        }

        ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> extensions) {
            this.extensions = extensions;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor field) {
            return this.extensions.getField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor field) {
            this.extensions.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            this.extensions.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
            return registry.findImmutableExtensionByName(name);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
            return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForType.mergeFrom(message);
            }
            input.readGroup(field.getNumber(), newBuilderForType, registry);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForType.mergeFrom(message);
            }
            input.readMessage(newBuilderForType, registry);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    MessageLite.Builder builder = ((MessageLite) getField(field)).toBuilder();
                    input.readGroup(field.getNumber(), builder, extensionRegistry);
                    setField(field, builder.buildPartial());
                    return;
                } else {
                    Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
                    input.readGroup(field.getNumber(), newBuilderForType, extensionRegistry);
                    setField(field, newBuilderForType.buildPartial());
                    return;
                }
            }
            Message.Builder newBuilderForType2 = defaultInstance.newBuilderForType();
            input.readGroup(field.getNumber(), newBuilderForType2, extensionRegistry);
            addRepeatedField(field, newBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    MessageLite.Builder builder = ((MessageLite) getField(field)).toBuilder();
                    input.readMessage(builder, extensionRegistry);
                    setField(field, builder.buildPartial());
                    return;
                } else {
                    Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
                    input.readMessage(newBuilderForType, extensionRegistry);
                    setField(field, newBuilderForType.buildPartial());
                    return;
                }
            }
            Message.Builder newBuilderForType2 = defaultInstance.newBuilderForType();
            input.readMessage(newBuilderForType2, extensionRegistry);
            addRepeatedField(field, newBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForType.mergeFrom(message);
            }
            newBuilderForType.mergeFrom(bytes, registry);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
            if (descriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }
    }

    static class ExtensionBuilderAdapter implements MergeTarget {
        private final FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return false;
        }

        ExtensionBuilderAdapter(FieldSet.Builder<Descriptors.FieldDescriptor> extensions) {
            this.extensions = extensions;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor field) {
            return this.extensions.getField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor field) {
            this.extensions.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            this.extensions.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
            return registry.findImmutableExtensionByName(name);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
            return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForType.mergeFrom(message);
            }
            input.readGroup(field.getNumber(), newBuilderForType, registry);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForType.mergeFrom(message);
            }
            input.readMessage(newBuilderForType, registry);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            MessageLite.Builder builder;
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(field);
                    if (fieldAllowBuilders instanceof MessageLite.Builder) {
                        builder = (MessageLite.Builder) fieldAllowBuilders;
                    } else {
                        builder = ((MessageLite) fieldAllowBuilders).toBuilder();
                        this.extensions.setField(field, builder);
                    }
                    input.readGroup(field.getNumber(), builder, extensionRegistry);
                    return;
                }
                Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
                input.readGroup(field.getNumber(), newBuilderForType, extensionRegistry);
                setField(field, newBuilderForType);
                return;
            }
            Message.Builder newBuilderForType2 = defaultInstance.newBuilderForType();
            input.readGroup(field.getNumber(), newBuilderForType2, extensionRegistry);
            addRepeatedField(field, newBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            MessageLite.Builder builder;
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(field);
                    if (fieldAllowBuilders instanceof MessageLite.Builder) {
                        builder = (MessageLite.Builder) fieldAllowBuilders;
                    } else {
                        builder = ((MessageLite) fieldAllowBuilders).toBuilder();
                        this.extensions.setField(field, builder);
                    }
                    input.readMessage(builder, extensionRegistry);
                    return;
                }
                Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
                input.readMessage(newBuilderForType, extensionRegistry);
                setField(field, newBuilderForType);
                return;
            }
            Message.Builder newBuilderForType2 = defaultInstance.newBuilderForType();
            input.readMessage(newBuilderForType2, extensionRegistry);
            addRepeatedField(field, newBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder newBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                newBuilderForType.mergeFrom(message);
            }
            newBuilderForType.mergeFrom(bytes, registry);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
            if (descriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean mergeFieldFrom(com.google.protobuf.CodedInputStream r7, com.google.protobuf.UnknownFieldSet.Builder r8, com.google.protobuf.ExtensionRegistryLite r9, com.google.protobuf.Descriptors.Descriptor r10, com.google.protobuf.MessageReflection.MergeTarget r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageReflection.mergeFieldFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.UnknownFieldSet$Builder, com.google.protobuf.ExtensionRegistryLite, com.google.protobuf.Descriptors$Descriptor, com.google.protobuf.MessageReflection$MergeTarget, int):boolean");
    }

    /* renamed from: com.google.protobuf.MessageReflection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static void mergeMessageFrom(Message.Builder target, UnknownFieldSet.Builder unknownFields, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        int readTag;
        BuilderAdapter builderAdapter = new BuilderAdapter(target);
        Descriptors.Descriptor descriptorForType = target.getDescriptorForType();
        do {
            readTag = input.readTag();
            if (readTag == 0) {
                return;
            }
        } while (mergeFieldFrom(input, unknownFields, extensionRegistry, descriptorForType, builderAdapter, readTag));
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, MergeTarget target) throws IOException {
        int i = 0;
        ByteString byteString = null;
        ExtensionRegistry.ExtensionInfo extensionInfo = null;
        while (true) {
            int readTag = input.readTag();
            if (readTag == 0) {
                break;
            }
            if (readTag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                i = input.readUInt32();
                if (i != 0 && (extensionRegistry instanceof ExtensionRegistry)) {
                    extensionInfo = target.findExtensionByNumber((ExtensionRegistry) extensionRegistry, type, i);
                }
            } else if (readTag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (i != 0 && extensionInfo != null && ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                    eagerlyMergeMessageSetExtension(input, extensionInfo, extensionRegistry, target);
                    byteString = null;
                } else {
                    byteString = input.readBytes();
                }
            } else if (!input.skipField(readTag)) {
                break;
            }
        }
        input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (byteString == null || i == 0) {
            return;
        }
        if (extensionInfo != null) {
            mergeMessageSetExtensionFromBytes(byteString, extensionInfo, extensionRegistry, target);
        } else {
            if (byteString == null || unknownFields == null) {
                return;
            }
            unknownFields.mergeField(i, UnknownFieldSet.Field.newBuilder().addLengthDelimited(byteString).build());
        }
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString rawBytes, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, MergeTarget target) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = extension.descriptor;
        if (target.hasField(fieldDescriptor) || ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            target.setField(fieldDescriptor, target.parseMessageFromBytes(rawBytes, extensionRegistry, fieldDescriptor, extension.defaultInstance));
        } else {
            target.setField(fieldDescriptor, new LazyField(extension.defaultInstance, extensionRegistry, rawBytes));
        }
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream input, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, MergeTarget target) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = extension.descriptor;
        target.setField(fieldDescriptor, target.parseMessage(input, extensionRegistry, fieldDescriptor, extension.defaultInstance));
    }
}
