package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.TextFormatParseInfoTree;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.lang.Character;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class TextFormat {
    private static final String DEBUG_STRING_SILENT_MARKER = "\t ";
    private static final Logger logger = Logger.getLogger(TextFormat.class.getName());
    private static final Parser PARSER = Parser.newBuilder().build();

    private static int digitValue(final byte c) {
        return (48 > c || c > 57) ? (97 > c || c > 122) ? c - 55 : c - 87 : c - 48;
    }

    private static boolean isHex(final byte c) {
        return (48 <= c && c <= 57) || (97 <= c && c <= 102) || (65 <= c && c <= 70);
    }

    private static boolean isOctal(final byte c) {
        return 48 <= c && c <= 55;
    }

    private TextFormat() {
    }

    @Deprecated
    public static void print(final MessageOrBuilder message, final Appendable output) throws IOException {
        printer().print(message, output);
    }

    @Deprecated
    public static void print(final UnknownFieldSet fields, final Appendable output) throws IOException {
        printer().print(fields, output);
    }

    @Deprecated
    public static void printUnicode(final MessageOrBuilder message, final Appendable output) throws IOException {
        printer().escapingNonAscii(false).print(message, output);
    }

    @Deprecated
    public static void printUnicode(final UnknownFieldSet fields, final Appendable output) throws IOException {
        printer().escapingNonAscii(false).print(fields, output);
    }

    public static String shortDebugString(final MessageOrBuilder message) {
        return printer().shortDebugString(message);
    }

    @Deprecated
    public static String shortDebugString(final Descriptors.FieldDescriptor field, final Object value) {
        return printer().shortDebugString(field, value);
    }

    @Deprecated
    public static String shortDebugString(final UnknownFieldSet fields) {
        return printer().shortDebugString(fields);
    }

    @Deprecated
    public static String printToString(final MessageOrBuilder message) {
        return printer().printToString(message);
    }

    @Deprecated
    public static String printToString(final UnknownFieldSet fields) {
        return printer().printToString(fields);
    }

    @Deprecated
    public static String printToUnicodeString(final MessageOrBuilder message) {
        return printer().escapingNonAscii(false).printToString(message);
    }

    @Deprecated
    public static String printToUnicodeString(final UnknownFieldSet fields) {
        return printer().escapingNonAscii(false).printToString(fields);
    }

    @Deprecated
    public static void printField(final Descriptors.FieldDescriptor field, final Object value, final Appendable output) throws IOException {
        printer().printField(field, value, output);
    }

    @Deprecated
    public static String printFieldToString(final Descriptors.FieldDescriptor field, final Object value) {
        return printer().printFieldToString(field, value);
    }

    @Deprecated
    public static void printUnicodeFieldValue(final Descriptors.FieldDescriptor field, final Object value, final Appendable output) throws IOException {
        printer().escapingNonAscii(false).printFieldValue(field, value, output);
    }

    @Deprecated
    public static void printFieldValue(final Descriptors.FieldDescriptor field, final Object value, final Appendable output) throws IOException {
        printer().printFieldValue(field, value, output);
    }

    public static void printUnknownFieldValue(final int tag, final Object value, final Appendable output) throws IOException {
        printUnknownFieldValue(tag, value, multiLineOutput(output));
    }

    private static void printUnknownFieldValue(final int tag, final Object value, final TextGenerator generator) throws IOException {
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            generator.print(unsignedToString(((Long) value).longValue()));
            return;
        }
        if (tagWireType == 1) {
            generator.print(String.format(null, "0x%016x", (Long) value));
            return;
        }
        if (tagWireType != 2) {
            if (tagWireType == 3) {
                Printer.printUnknownFields((UnknownFieldSet) value, generator);
                return;
            } else {
                if (tagWireType == 5) {
                    generator.print(String.format(null, "0x%08x", (Integer) value));
                    return;
                }
                throw new IllegalArgumentException("Bad tag: " + tag);
            }
        }
        try {
            UnknownFieldSet parseFrom = UnknownFieldSet.parseFrom((ByteString) value);
            generator.print("{");
            generator.eol();
            generator.indent();
            Printer.printUnknownFields(parseFrom, generator);
            generator.outdent();
            generator.print("}");
        } catch (InvalidProtocolBufferException unused) {
            generator.print("\"");
            generator.print(escapeBytes((ByteString) value));
            generator.print("\"");
        }
    }

    public static Printer printer() {
        return Printer.DEFAULT;
    }

    public static final class Printer {
        private static final Printer DEFAULT = new Printer(true, TypeRegistry.getEmptyTypeRegistry());
        private final boolean escapeNonAscii;
        private final TypeRegistry typeRegistry;

        private Printer(boolean escapeNonAscii, TypeRegistry typeRegistry) {
            this.escapeNonAscii = escapeNonAscii;
            this.typeRegistry = typeRegistry;
        }

        public Printer escapingNonAscii(boolean escapeNonAscii) {
            return new Printer(escapeNonAscii, this.typeRegistry);
        }

        public Printer usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.typeRegistry != TypeRegistry.getEmptyTypeRegistry()) {
                throw new IllegalArgumentException("Only one typeRegistry is allowed.");
            }
            return new Printer(this.escapeNonAscii, typeRegistry);
        }

        public void print(final MessageOrBuilder message, final Appendable output) throws IOException {
            print(message, TextFormat.multiLineOutput(output));
        }

        public void print(final UnknownFieldSet fields, final Appendable output) throws IOException {
            printUnknownFields(fields, TextFormat.multiLineOutput(output));
        }

        private void print(final MessageOrBuilder message, final TextGenerator generator) throws IOException {
            if (message.getDescriptorForType().getFullName().equals("google.protobuf.Any") && printAny(message, generator)) {
                return;
            }
            printMessage(message, generator);
        }

        private boolean printAny(final MessageOrBuilder message, final TextGenerator generator) throws IOException {
            Descriptors.Descriptor descriptorForType = message.getDescriptorForType();
            Descriptors.FieldDescriptor findFieldByNumber = descriptorForType.findFieldByNumber(1);
            Descriptors.FieldDescriptor findFieldByNumber2 = descriptorForType.findFieldByNumber(2);
            if (findFieldByNumber != null && findFieldByNumber.getType() == Descriptors.FieldDescriptor.Type.STRING && findFieldByNumber2 != null && findFieldByNumber2.getType() == Descriptors.FieldDescriptor.Type.BYTES) {
                String str = (String) message.getField(findFieldByNumber);
                if (str.isEmpty()) {
                    return false;
                }
                Object field = message.getField(findFieldByNumber2);
                try {
                    Descriptors.Descriptor descriptorForTypeUrl = this.typeRegistry.getDescriptorForTypeUrl(str);
                    if (descriptorForTypeUrl == null) {
                        return false;
                    }
                    DynamicMessage.Builder newBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                    newBuilderForType.mergeFrom((ByteString) field);
                    generator.print("[");
                    generator.print(str);
                    generator.print("] {");
                    generator.eol();
                    generator.indent();
                    print(newBuilderForType, generator);
                    generator.outdent();
                    generator.print("}");
                    generator.eol();
                    return true;
                } catch (InvalidProtocolBufferException unused) {
                }
            }
            return false;
        }

        public String printFieldToString(final Descriptors.FieldDescriptor field, final Object value) {
            try {
                StringBuilder sb = new StringBuilder();
                printField(field, value, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public void printField(final Descriptors.FieldDescriptor field, final Object value, final Appendable output) throws IOException {
            printField(field, value, TextFormat.multiLineOutput(output));
        }

        private void printField(final Descriptors.FieldDescriptor field, final Object value, final TextGenerator generator) throws IOException {
            if (field.isMapField()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(new MapEntryAdapter(it.next(), field));
                }
                Collections.sort(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    printSingleField(field, ((MapEntryAdapter) it2.next()).getEntry(), generator);
                }
                return;
            }
            if (field.isRepeated()) {
                Iterator it3 = ((List) value).iterator();
                while (it3.hasNext()) {
                    printSingleField(field, it3.next(), generator);
                }
                return;
            }
            printSingleField(field, value, generator);
        }

        private static class MapEntryAdapter implements Comparable<MapEntryAdapter> {
            private Object entry;
            private final Descriptors.FieldDescriptor.JavaType fieldType;
            private MapEntry mapEntry;

            MapEntryAdapter(Object entry, Descriptors.FieldDescriptor fieldDescriptor) {
                if (entry instanceof MapEntry) {
                    this.mapEntry = (MapEntry) entry;
                } else {
                    this.entry = entry;
                }
                this.fieldType = extractFieldType(fieldDescriptor);
            }

            private static Descriptors.FieldDescriptor.JavaType extractFieldType(Descriptors.FieldDescriptor fieldDescriptor) {
                return fieldDescriptor.getMessageType().getFields().get(0).getJavaType();
            }

            Object getKey() {
                MapEntry mapEntry = this.mapEntry;
                if (mapEntry != null) {
                    return mapEntry.getKey();
                }
                return null;
            }

            Object getEntry() {
                MapEntry mapEntry = this.mapEntry;
                return mapEntry != null ? mapEntry : this.entry;
            }

            @Override // java.lang.Comparable
            public int compareTo(MapEntryAdapter b) {
                if (getKey() == null || b.getKey() == null) {
                    TextFormat.logger.info("Invalid key for map field.");
                    return -1;
                }
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.fieldType.ordinal()];
                if (i == 1) {
                    return Boolean.valueOf(((Boolean) getKey()).booleanValue()).compareTo(Boolean.valueOf(((Boolean) b.getKey()).booleanValue()));
                }
                if (i == 2) {
                    return Long.valueOf(((Long) getKey()).longValue()).compareTo(Long.valueOf(((Long) b.getKey()).longValue()));
                }
                if (i == 3) {
                    return Integer.valueOf(((Integer) getKey()).intValue()).compareTo(Integer.valueOf(((Integer) b.getKey()).intValue()));
                }
                if (i != 4) {
                    return 0;
                }
                String str = (String) getKey();
                String str2 = (String) b.getKey();
                if (str == null && str2 == null) {
                    return 0;
                }
                if (str == null && str2 != null) {
                    return -1;
                }
                if (str == null || str2 != null) {
                    return str.compareTo(str2);
                }
                return 1;
            }
        }

        public void printFieldValue(final Descriptors.FieldDescriptor field, final Object value, final Appendable output) throws IOException {
            printFieldValue(field, value, TextFormat.multiLineOutput(output));
        }

        private void printFieldValue(final Descriptors.FieldDescriptor field, final Object value, final TextGenerator generator) throws IOException {
            String replace;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[field.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    generator.print(((Integer) value).toString());
                    break;
                case 4:
                case 5:
                case 6:
                    generator.print(((Long) value).toString());
                    break;
                case 7:
                    generator.print(((Boolean) value).toString());
                    break;
                case 8:
                    generator.print(((Float) value).toString());
                    break;
                case 9:
                    generator.print(((Double) value).toString());
                    break;
                case 10:
                case 11:
                    generator.print(TextFormat.unsignedToString(((Integer) value).intValue()));
                    break;
                case 12:
                case 13:
                    generator.print(TextFormat.unsignedToString(((Long) value).longValue()));
                    break;
                case 14:
                    generator.print("\"");
                    if (this.escapeNonAscii) {
                        replace = TextFormatEscaper.escapeText((String) value);
                    } else {
                        replace = TextFormat.escapeDoubleQuotesAndBackslashes((String) value).replace("\n", "\\n");
                    }
                    generator.print(replace);
                    generator.print("\"");
                    break;
                case 15:
                    generator.print("\"");
                    if (value instanceof ByteString) {
                        generator.print(TextFormat.escapeBytes((ByteString) value));
                    } else {
                        generator.print(TextFormat.escapeBytes((byte[]) value));
                    }
                    generator.print("\"");
                    break;
                case 16:
                    generator.print(((Descriptors.EnumValueDescriptor) value).getName());
                    break;
                case 17:
                case 18:
                    print((MessageOrBuilder) value, generator);
                    break;
            }
        }

        public String printToString(final MessageOrBuilder message) {
            try {
                StringBuilder sb = new StringBuilder();
                print(message, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String printToString(final UnknownFieldSet fields) {
            try {
                StringBuilder sb = new StringBuilder();
                print(fields, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String shortDebugString(final MessageOrBuilder message) {
            try {
                StringBuilder sb = new StringBuilder();
                print(message, TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String shortDebugString(final Descriptors.FieldDescriptor field, final Object value) {
            try {
                StringBuilder sb = new StringBuilder();
                printField(field, value, TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String shortDebugString(final UnknownFieldSet fields) {
            try {
                StringBuilder sb = new StringBuilder();
                printUnknownFields(fields, TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        private static void printUnknownFieldValue(final int tag, final Object value, final TextGenerator generator) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                generator.print(TextFormat.unsignedToString(((Long) value).longValue()));
                return;
            }
            if (tagWireType == 1) {
                generator.print(String.format(null, "0x%016x", (Long) value));
                return;
            }
            if (tagWireType != 2) {
                if (tagWireType == 3) {
                    printUnknownFields((UnknownFieldSet) value, generator);
                    return;
                } else {
                    if (tagWireType == 5) {
                        generator.print(String.format(null, "0x%08x", (Integer) value));
                        return;
                    }
                    throw new IllegalArgumentException("Bad tag: " + tag);
                }
            }
            try {
                UnknownFieldSet parseFrom = UnknownFieldSet.parseFrom((ByteString) value);
                generator.print("{");
                generator.eol();
                generator.indent();
                printUnknownFields(parseFrom, generator);
                generator.outdent();
                generator.print("}");
            } catch (InvalidProtocolBufferException unused) {
                generator.print("\"");
                generator.print(TextFormat.escapeBytes((ByteString) value));
                generator.print("\"");
            }
        }

        private void printMessage(final MessageOrBuilder message, final TextGenerator generator) throws IOException {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
                printField(entry.getKey(), entry.getValue(), generator);
            }
            printUnknownFields(message.getUnknownFields(), generator);
        }

        private void printSingleField(final Descriptors.FieldDescriptor field, final Object value, final TextGenerator generator) throws IOException {
            if (field.isExtension()) {
                generator.print("[");
                if (field.getContainingType().getOptions().getMessageSetWireFormat() && field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && field.isOptional() && field.getExtensionScope() == field.getMessageType()) {
                    generator.print(field.getMessageType().getFullName());
                } else {
                    generator.print(field.getFullName());
                }
                generator.print("]");
            } else if (field.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
                generator.print(field.getMessageType().getName());
            } else {
                generator.print(field.getName());
            }
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                generator.print(" {");
                generator.eol();
                generator.indent();
            } else {
                generator.print(": ");
            }
            printFieldValue(field, value, generator);
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                generator.outdent();
                generator.print("}");
            }
            generator.eol();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void printUnknownFields(final UnknownFieldSet unknownFields, final TextGenerator generator) throws IOException {
            for (Map.Entry<Integer, UnknownFieldSet.Field> entry : unknownFields.asMap().entrySet()) {
                int intValue = entry.getKey().intValue();
                UnknownFieldSet.Field value = entry.getValue();
                printUnknownField(intValue, 0, value.getVarintList(), generator);
                printUnknownField(intValue, 5, value.getFixed32List(), generator);
                printUnknownField(intValue, 1, value.getFixed64List(), generator);
                printUnknownField(intValue, 2, value.getLengthDelimitedList(), generator);
                for (UnknownFieldSet unknownFieldSet : value.getGroupList()) {
                    generator.print(entry.getKey().toString());
                    generator.print(" {");
                    generator.eol();
                    generator.indent();
                    printUnknownFields(unknownFieldSet, generator);
                    generator.outdent();
                    generator.print("}");
                    generator.eol();
                }
            }
        }

        private static void printUnknownField(final int number, final int wireType, final List<?> values, final TextGenerator generator) throws IOException {
            for (Object obj : values) {
                generator.print(String.valueOf(number));
                generator.print(": ");
                printUnknownFieldValue(wireType, obj, generator);
                generator.eol();
            }
        }
    }

    /* renamed from: com.google.protobuf.TextFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = iArr2;
            try {
                iArr2[Descriptors.FieldDescriptor.JavaType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    public static String unsignedToString(final int value) {
        if (value >= 0) {
            return Integer.toString(value);
        }
        return Long.toString(value & 4294967295L);
    }

    public static String unsignedToString(final long value) {
        if (value >= 0) {
            return Long.toString(value);
        }
        return BigInteger.valueOf(value & Long.MAX_VALUE).setBit(63).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TextGenerator multiLineOutput(Appendable output) {
        return new TextGenerator(output, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TextGenerator singleLineOutput(Appendable output) {
        return new TextGenerator(output, true, null);
    }

    private static final class TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;
        private final boolean singleLineMode;

        /* synthetic */ TextGenerator(Appendable appendable, boolean z, AnonymousClass1 anonymousClass1) {
            this(appendable, z);
        }

        private TextGenerator(final Appendable output, boolean singleLineMode) {
            this.indent = new StringBuilder();
            this.atStartOfLine = false;
            this.output = output;
            this.singleLineMode = singleLineMode;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.setLength(length - 2);
        }

        public void print(final CharSequence text) throws IOException {
            if (this.atStartOfLine) {
                this.atStartOfLine = false;
                this.output.append(this.singleLineMode ? " " : this.indent);
            }
            this.output.append(text);
        }

        public void eol() throws IOException {
            if (!this.singleLineMode) {
                this.output.append("\n");
            }
            this.atStartOfLine = true;
        }
    }

    private static final class Tokenizer {
        private int column;
        private boolean containsSilentMarkerAfterCurrentToken;
        private boolean containsSilentMarkerAfterPrevToken;
        private String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;
        private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
        private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
        private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
        private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
        private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);

        /* synthetic */ Tokenizer(CharSequence charSequence, AnonymousClass1 anonymousClass1) {
            this(charSequence);
        }

        private Tokenizer(final CharSequence text) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.containsSilentMarkerAfterCurrentToken = false;
            this.containsSilentMarkerAfterPrevToken = false;
            this.text = text;
            this.matcher = WHITESPACE.matcher(text);
            skipWhitespace();
            nextToken();
        }

        int getPreviousLine() {
            return this.previousLine;
        }

        int getPreviousColumn() {
            return this.previousColumn;
        }

        int getLine() {
            return this.line;
        }

        int getColumn() {
            return this.column;
        }

        boolean getContainsSilentMarkerAfterCurrentToken() {
            return this.containsSilentMarkerAfterCurrentToken;
        }

        boolean getContainsSilentMarkerAfterPrevToken() {
            return this.containsSilentMarkerAfterPrevToken;
        }

        boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == '\n') {
                    this.line++;
                    this.column = 0;
                } else {
                    this.column++;
                }
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = "";
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                Matcher matcher = this.matcher;
                matcher.region(matcher.end(), this.matcher.regionEnd());
            } else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                Matcher matcher2 = this.matcher;
                matcher2.region(this.pos + 1, matcher2.regionEnd());
            }
            skipWhitespace();
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                Matcher matcher = this.matcher;
                matcher.region(matcher.end(), this.matcher.regionEnd());
            }
        }

        boolean tryConsume(final String token) {
            if (!this.currentToken.equals(token)) {
                return false;
            }
            nextToken();
            return true;
        }

        void consume(final String token) throws ParseException {
            if (!tryConsume(token)) {
                throw parseException("Expected \"" + token + "\".");
            }
        }

        boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char charAt = this.currentToken.charAt(0);
            return ('0' <= charAt && charAt <= '9') || charAt == '-' || charAt == '+';
        }

        boolean lookingAt(String text) {
            return this.currentToken.equals(text);
        }

        String consumeIdentifier() throws ParseException {
            for (int i = 0; i < this.currentToken.length(); i++) {
                char charAt = this.currentToken.charAt(i);
                if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && !(('0' <= charAt && charAt <= '9') || charAt == '_' || charAt == '.'))) {
                    throw parseException("Expected identifier. Found '" + this.currentToken + "'");
                }
            }
            String str = this.currentToken;
            nextToken();
            return str;
        }

        boolean tryConsumeIdentifier() {
            try {
                consumeIdentifier();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        int consumeInt32() throws ParseException {
            try {
                int parseInt32 = TextFormat.parseInt32(this.currentToken);
                nextToken();
                return parseInt32;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        int consumeUInt32() throws ParseException {
            try {
                int parseUInt32 = TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return parseUInt32;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        long consumeInt64() throws ParseException {
            try {
                long parseInt64 = TextFormat.parseInt64(this.currentToken);
                nextToken();
                return parseInt64;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        boolean tryConsumeInt64() {
            try {
                consumeInt64();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        long consumeUInt64() throws ParseException {
            try {
                long parseUInt64 = TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return parseUInt64;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public boolean tryConsumeUInt64() {
            try {
                consumeUInt64();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean startsWith = this.currentToken.startsWith("-");
                nextToken();
                return startsWith ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            }
            if (this.currentToken.equalsIgnoreCase("nan")) {
                nextToken();
                return Double.NaN;
            }
            try {
                double parseDouble = Double.parseDouble(this.currentToken);
                nextToken();
                return parseDouble;
            } catch (NumberFormatException e) {
                throw floatParseException(e);
            }
        }

        public boolean tryConsumeDouble() {
            try {
                consumeDouble();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean startsWith = this.currentToken.startsWith("-");
                nextToken();
                return startsWith ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            }
            if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            }
            try {
                float parseFloat = Float.parseFloat(this.currentToken);
                nextToken();
                return parseFloat;
            } catch (NumberFormatException e) {
                throw floatParseException(e);
            }
        }

        public boolean tryConsumeFloat() {
            try {
                consumeFloat();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals("true") || this.currentToken.equals("True") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
                nextToken();
                return true;
            }
            if (this.currentToken.equals("false") || this.currentToken.equals("False") || this.currentToken.equals("f") || this.currentToken.equals("0")) {
                nextToken();
                return false;
            }
            throw parseException("Expected \"true\" or \"false\". Found \"" + this.currentToken + "\".");
        }

        public String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        boolean tryConsumeString() {
            try {
                consumeString();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        ByteString consumeByteString() throws ParseException {
            ArrayList arrayList = new ArrayList();
            consumeByteString(arrayList);
            while (true) {
                if (this.currentToken.startsWith("'") || this.currentToken.startsWith("\"")) {
                    consumeByteString(arrayList);
                } else {
                    return ByteString.copyFrom(arrayList);
                }
            }
        }

        private void consumeByteString(List<ByteString> list) throws ParseException {
            char charAt = this.currentToken.length() > 0 ? this.currentToken.charAt(0) : (char) 0;
            if (charAt != '\"' && charAt != '\'') {
                throw parseException("Expected string.");
            }
            if (this.currentToken.length() >= 2) {
                String str = this.currentToken;
                if (str.charAt(str.length() - 1) == charAt) {
                    try {
                        String str2 = this.currentToken;
                        ByteString unescapeBytes = TextFormat.unescapeBytes(str2.substring(1, str2.length() - 1));
                        nextToken();
                        list.add(unescapeBytes);
                        return;
                    } catch (InvalidEscapeSequenceException e) {
                        throw parseException(e.getMessage());
                    }
                }
            }
            throw parseException("String missing ending quote.");
        }

        ParseException parseException(final String description) {
            return new ParseException(this.line + 1, this.column + 1, description);
        }

        ParseException parseExceptionPreviousToken(final String description) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, description);
        }

        private ParseException integerParseException(final NumberFormatException e) {
            return parseException("Couldn't parse integer: " + e.getMessage());
        }

        private ParseException floatParseException(final NumberFormatException e) {
            return parseException("Couldn't parse number: " + e.getMessage());
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(final String message) {
            this(-1, -1, message);
        }

        public ParseException(final int line, final int column, final String message) {
            super(Integer.toString(line) + ":" + column + ": " + message);
            this.line = line;
            this.column = column;
        }

        public int getLine() {
            return this.line;
        }

        public int getColumn() {
            return this.column;
        }
    }

    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(final String message) {
            this(-1, -1, "", message);
        }

        public UnknownFieldParseException(final int line, final int column, final String unknownField, final String message) {
            super(line, column, message);
            this.unknownField = unknownField;
        }

        public String getUnknownField() {
            return this.unknownField;
        }
    }

    public static Parser getParser() {
        return PARSER;
    }

    public static void merge(final Readable input, final Message.Builder builder) throws IOException {
        PARSER.merge(input, builder);
    }

    public static void merge(final CharSequence input, final Message.Builder builder) throws ParseException {
        PARSER.merge(input, builder);
    }

    public static <T extends Message> T parse(CharSequence charSequence, Class<T> cls) throws ParseException {
        Message.Builder newBuilderForType = ((Message) Internal.getDefaultInstance(cls)).newBuilderForType();
        merge(charSequence, newBuilderForType);
        return (T) newBuilderForType.build();
    }

    public static void merge(final Readable input, final ExtensionRegistry extensionRegistry, final Message.Builder builder) throws IOException {
        PARSER.merge(input, extensionRegistry, builder);
    }

    public static void merge(final CharSequence input, final ExtensionRegistry extensionRegistry, final Message.Builder builder) throws ParseException {
        PARSER.merge(input, extensionRegistry, builder);
    }

    public static <T extends Message> T parse(CharSequence charSequence, ExtensionRegistry extensionRegistry, Class<T> cls) throws ParseException {
        Message.Builder newBuilderForType = ((Message) Internal.getDefaultInstance(cls)).newBuilderForType();
        merge(charSequence, extensionRegistry, newBuilderForType);
        return (T) newBuilderForType.build();
    }

    public static class Parser {
        private static final int BUFFER_SIZE = 4096;
        private final boolean allowUnknownEnumValues;
        private final boolean allowUnknownExtensions;
        private final boolean allowUnknownFields;
        private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private final SingularOverwritePolicy singularOverwritePolicy;
        private final TypeRegistry typeRegistry;

        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        private void detectSilentMarker(Tokenizer tokenizer, Descriptors.Descriptor immediateMessageType, String fieldName) {
        }

        /* synthetic */ Parser(TypeRegistry typeRegistry, boolean z, boolean z2, boolean z3, SingularOverwritePolicy singularOverwritePolicy, TextFormatParseInfoTree.Builder builder, AnonymousClass1 anonymousClass1) {
            this(typeRegistry, z, z2, z3, singularOverwritePolicy, builder);
        }

        private Parser(TypeRegistry typeRegistry, boolean allowUnknownFields, boolean allowUnknownEnumValues, boolean allowUnknownExtensions, SingularOverwritePolicy singularOverwritePolicy, TextFormatParseInfoTree.Builder parseInfoTreeBuilder) {
            this.typeRegistry = typeRegistry;
            this.allowUnknownFields = allowUnknownFields;
            this.allowUnknownEnumValues = allowUnknownEnumValues;
            this.allowUnknownExtensions = allowUnknownExtensions;
            this.singularOverwritePolicy = singularOverwritePolicy;
            this.parseInfoTreeBuilder = parseInfoTreeBuilder;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static class Builder {
            private boolean allowUnknownFields = false;
            private boolean allowUnknownEnumValues = false;
            private boolean allowUnknownExtensions = false;
            private SingularOverwritePolicy singularOverwritePolicy = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
            private TextFormatParseInfoTree.Builder parseInfoTreeBuilder = null;
            private TypeRegistry typeRegistry = TypeRegistry.getEmptyTypeRegistry();

            public Builder setTypeRegistry(TypeRegistry typeRegistry) {
                this.typeRegistry = typeRegistry;
                return this;
            }

            public Builder setAllowUnknownFields(boolean allowUnknownFields) {
                this.allowUnknownFields = allowUnknownFields;
                return this;
            }

            public Builder setAllowUnknownExtensions(boolean allowUnknownExtensions) {
                this.allowUnknownExtensions = allowUnknownExtensions;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy p) {
                this.singularOverwritePolicy = p;
                return this;
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder parseInfoTreeBuilder) {
                this.parseInfoTreeBuilder = parseInfoTreeBuilder;
                return this;
            }

            public Parser build() {
                return new Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder, null);
            }
        }

        public void merge(final Readable input, final Message.Builder builder) throws IOException {
            merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(final CharSequence input, final Message.Builder builder) throws ParseException {
            merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(final Readable input, final ExtensionRegistry extensionRegistry, final Message.Builder builder) throws IOException {
            merge(toStringBuilder(input), extensionRegistry, builder);
        }

        private static StringBuilder toStringBuilder(final Readable input) throws IOException {
            StringBuilder sb = new StringBuilder();
            CharBuffer allocate = CharBuffer.allocate(4096);
            while (true) {
                int read = input.read(allocate);
                if (read == -1) {
                    return sb;
                }
                Java8Compatibility.flip(allocate);
                sb.append((CharSequence) allocate, 0, read);
            }
        }

        static final class UnknownField {
            final String message;
            final Type type;

            enum Type {
                FIELD,
                EXTENSION
            }

            UnknownField(String message, Type type) {
                this.message = message;
                this.type = type;
            }
        }

        private void checkUnknownFields(final List<UnknownField> unknownFields) throws ParseException {
            int i;
            if (unknownFields.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder("Input contains unknown fields and/or extensions:");
            Iterator<UnknownField> it = unknownFields.iterator();
            while (it.hasNext()) {
                sb.append('\n').append(it.next().message);
            }
            if (this.allowUnknownFields) {
                TextFormat.logger.warning(sb.toString());
                return;
            }
            if (this.allowUnknownExtensions) {
                Iterator<UnknownField> it2 = unknownFields.iterator();
                i = 0;
                while (it2.hasNext()) {
                    if (it2.next().type != UnknownField.Type.FIELD) {
                        i++;
                    }
                }
                TextFormat.logger.warning(sb.toString());
                return;
            }
            i = 0;
            String[] split = unknownFields.get(i).message.split(":");
            throw new ParseException(Integer.parseInt(split[0]), Integer.parseInt(split[1]), sb.toString());
        }

        public void merge(final CharSequence input, final ExtensionRegistry extensionRegistry, final Message.Builder builder) throws ParseException {
            Tokenizer tokenizer = new Tokenizer(input, null);
            MessageReflection.BuilderAdapter builderAdapter = new MessageReflection.BuilderAdapter(builder);
            ArrayList arrayList = new ArrayList();
            while (!tokenizer.atEnd()) {
                mergeField(tokenizer, extensionRegistry, builderAdapter, arrayList);
            }
            checkUnknownFields(arrayList);
        }

        private void mergeField(final Tokenizer tokenizer, final ExtensionRegistry extensionRegistry, final MessageReflection.MergeTarget target, List<UnknownField> unknownFields) throws ParseException {
            mergeField(tokenizer, extensionRegistry, target, this.parseInfoTreeBuilder, unknownFields);
        }

        private void mergeField(final Tokenizer tokenizer, final ExtensionRegistry extensionRegistry, final MessageReflection.MergeTarget target, TextFormatParseInfoTree.Builder parseTreeBuilder, List<UnknownField> unknownFields) throws ParseException {
            String consumeIdentifier;
            Descriptors.FieldDescriptor fieldDescriptor;
            ExtensionRegistry.ExtensionInfo extensionInfo;
            Descriptors.FieldDescriptor fieldDescriptor2;
            int line = tokenizer.getLine();
            int column = tokenizer.getColumn();
            Descriptors.Descriptor descriptorForType = target.getDescriptorForType();
            if ("google.protobuf.Any".equals(descriptorForType.getFullName()) && tokenizer.tryConsume("[")) {
                mergeAnyFieldValue(tokenizer, extensionRegistry, target, parseTreeBuilder, unknownFields, descriptorForType);
                return;
            }
            if (tokenizer.tryConsume("[")) {
                StringBuilder sb = new StringBuilder(tokenizer.consumeIdentifier());
                while (tokenizer.tryConsume(".")) {
                    sb.append('.');
                    sb.append(tokenizer.consumeIdentifier());
                }
                consumeIdentifier = sb.toString();
                ExtensionRegistry.ExtensionInfo findExtensionByName = target.findExtensionByName(extensionRegistry, consumeIdentifier);
                if (findExtensionByName == null) {
                    unknownFields.add(new UnknownField((tokenizer.getPreviousLine() + 1) + ":" + (tokenizer.getPreviousColumn() + 1) + ":\t" + descriptorForType.getFullName() + ".[" + consumeIdentifier + "]", UnknownField.Type.EXTENSION));
                    fieldDescriptor2 = null;
                } else {
                    if (findExtensionByName.descriptor.getContainingType() != descriptorForType) {
                        throw tokenizer.parseExceptionPreviousToken("Extension \"" + consumeIdentifier + "\" does not extend message type \"" + descriptorForType.getFullName() + "\".");
                    }
                    fieldDescriptor2 = findExtensionByName.descriptor;
                }
                tokenizer.consume("]");
                fieldDescriptor = fieldDescriptor2;
                extensionInfo = findExtensionByName;
            } else {
                consumeIdentifier = tokenizer.consumeIdentifier();
                Descriptors.FieldDescriptor findFieldByName = descriptorForType.findFieldByName(consumeIdentifier);
                if (findFieldByName == null && (findFieldByName = descriptorForType.findFieldByName(consumeIdentifier.toLowerCase(Locale.US))) != null && findFieldByName.getType() != Descriptors.FieldDescriptor.Type.GROUP) {
                    findFieldByName = null;
                }
                if (findFieldByName != null && findFieldByName.getType() == Descriptors.FieldDescriptor.Type.GROUP && !findFieldByName.getMessageType().getName().equals(consumeIdentifier)) {
                    findFieldByName = null;
                }
                if (findFieldByName == null) {
                    unknownFields.add(new UnknownField((tokenizer.getPreviousLine() + 1) + ":" + (tokenizer.getPreviousColumn() + 1) + ":\t" + descriptorForType.getFullName() + "." + consumeIdentifier, UnknownField.Type.FIELD));
                }
                fieldDescriptor = findFieldByName;
                extensionInfo = null;
            }
            if (fieldDescriptor == null) {
                detectSilentMarker(tokenizer, descriptorForType, consumeIdentifier);
                guessFieldTypeAndSkip(tokenizer, descriptorForType);
                return;
            }
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                detectSilentMarker(tokenizer, descriptorForType, fieldDescriptor.getFullName());
                tokenizer.tryConsume(":");
                if (parseTreeBuilder != null) {
                    consumeFieldValues(tokenizer, extensionRegistry, target, fieldDescriptor, extensionInfo, parseTreeBuilder.getBuilderForSubMessageField(fieldDescriptor), unknownFields);
                } else {
                    consumeFieldValues(tokenizer, extensionRegistry, target, fieldDescriptor, extensionInfo, parseTreeBuilder, unknownFields);
                }
            } else {
                detectSilentMarker(tokenizer, descriptorForType, fieldDescriptor.getFullName());
                tokenizer.consume(":");
                consumeFieldValues(tokenizer, extensionRegistry, target, fieldDescriptor, extensionInfo, parseTreeBuilder, unknownFields);
            }
            if (parseTreeBuilder != null) {
                parseTreeBuilder.setLocation(fieldDescriptor, TextFormatParseLocation.create(line, column));
            }
            if (tokenizer.tryConsume(";")) {
                return;
            }
            tokenizer.tryConsume(",");
        }

        private String consumeFullTypeName(Tokenizer tokenizer) throws ParseException {
            if (!tokenizer.tryConsume("[")) {
                return tokenizer.consumeIdentifier();
            }
            String consumeIdentifier = tokenizer.consumeIdentifier();
            while (tokenizer.tryConsume(".")) {
                consumeIdentifier = consumeIdentifier + "." + tokenizer.consumeIdentifier();
            }
            if (tokenizer.tryConsume("/")) {
                consumeIdentifier = consumeIdentifier + "/" + tokenizer.consumeIdentifier();
                while (tokenizer.tryConsume(".")) {
                    consumeIdentifier = consumeIdentifier + "." + tokenizer.consumeIdentifier();
                }
            }
            tokenizer.consume("]");
            return consumeIdentifier;
        }

        private void consumeFieldValues(final Tokenizer tokenizer, final ExtensionRegistry extensionRegistry, final MessageReflection.MergeTarget target, final Descriptors.FieldDescriptor field, final ExtensionRegistry.ExtensionInfo extension, final TextFormatParseInfoTree.Builder parseTreeBuilder, List<UnknownField> unknownFields) throws ParseException {
            if (field.isRepeated() && tokenizer.tryConsume("[")) {
                if (tokenizer.tryConsume("]")) {
                    return;
                }
                while (true) {
                    consumeFieldValue(tokenizer, extensionRegistry, target, field, extension, parseTreeBuilder, unknownFields);
                    if (tokenizer.tryConsume("]")) {
                        return;
                    } else {
                        tokenizer.consume(",");
                    }
                }
            } else {
                consumeFieldValue(tokenizer, extensionRegistry, target, field, extension, parseTreeBuilder, unknownFields);
            }
        }

        private void consumeFieldValue(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, Descriptors.FieldDescriptor fieldDescriptor, ExtensionRegistry.ExtensionInfo extensionInfo, TextFormatParseInfoTree.Builder builder, List<UnknownField> list) throws ParseException {
            String str;
            Object finish;
            if (this.singularOverwritePolicy == SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && !fieldDescriptor.isRepeated()) {
                if (mergeTarget.hasField(fieldDescriptor)) {
                    throw tokenizer.parseExceptionPreviousToken("Non-repeated field \"" + fieldDescriptor.getFullName() + "\" cannot be overwritten.");
                }
                if (fieldDescriptor.getContainingOneof() != null && mergeTarget.hasOneof(fieldDescriptor.getContainingOneof())) {
                    Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
                    throw tokenizer.parseExceptionPreviousToken("Field \"" + fieldDescriptor.getFullName() + "\" is specified along with field \"" + mergeTarget.getOneofFieldDescriptor(containingOneof).getFullName() + "\", another member of oneof \"" + containingOneof.getName() + "\".");
                }
            }
            Object obj = null;
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (tokenizer.tryConsume("<")) {
                    str = ">";
                } else {
                    tokenizer.consume("{");
                    str = "}";
                }
                String str2 = str;
                if (fieldDescriptor.getMessageType().getFullName().equals("google.protobuf.Any") && tokenizer.tryConsume("[")) {
                    MessageReflection.MergeTarget newMergeTargetForField = mergeTarget.newMergeTargetForField(fieldDescriptor, DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()));
                    mergeAnyFieldValue(tokenizer, extensionRegistry, newMergeTargetForField, builder, list, fieldDescriptor.getMessageType());
                    finish = newMergeTargetForField.finish();
                    tokenizer.consume(str2);
                } else {
                    MessageReflection.MergeTarget newMergeTargetForField2 = mergeTarget.newMergeTargetForField(fieldDescriptor, extensionInfo != null ? extensionInfo.defaultInstance : null);
                    while (!tokenizer.tryConsume(str2)) {
                        if (tokenizer.atEnd()) {
                            throw tokenizer.parseException("Expected \"" + str2 + "\".");
                        }
                        mergeField(tokenizer, extensionRegistry, newMergeTargetForField2, builder, list);
                    }
                    finish = newMergeTargetForField2.finish();
                }
                obj = finish;
            } else {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        obj = Integer.valueOf(tokenizer.consumeInt32());
                        break;
                    case 4:
                    case 5:
                    case 6:
                        obj = Long.valueOf(tokenizer.consumeInt64());
                        break;
                    case 7:
                        obj = Boolean.valueOf(tokenizer.consumeBoolean());
                        break;
                    case 8:
                        obj = Float.valueOf(tokenizer.consumeFloat());
                        break;
                    case 9:
                        obj = Double.valueOf(tokenizer.consumeDouble());
                        break;
                    case 10:
                    case 11:
                        obj = Integer.valueOf(tokenizer.consumeUInt32());
                        break;
                    case 12:
                    case 13:
                        obj = Long.valueOf(tokenizer.consumeUInt64());
                        break;
                    case 14:
                        obj = tokenizer.consumeString();
                        break;
                    case 15:
                        obj = tokenizer.consumeByteString();
                        break;
                    case 16:
                        Descriptors.EnumDescriptor enumType = fieldDescriptor.getEnumType();
                        if (tokenizer.lookingAtInteger()) {
                            int consumeInt32 = tokenizer.consumeInt32();
                            obj = enumType.findValueByNumber(consumeInt32);
                            if (obj == null) {
                                String str3 = "Enum type \"" + enumType.getFullName() + "\" has no value with number " + consumeInt32 + '.';
                                if (this.allowUnknownEnumValues) {
                                    TextFormat.logger.warning(str3);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + consumeInt32 + '.');
                            }
                        } else {
                            String consumeIdentifier = tokenizer.consumeIdentifier();
                            obj = enumType.findValueByName(consumeIdentifier);
                            if (obj == null) {
                                String str4 = "Enum type \"" + enumType.getFullName() + "\" has no value named \"" + consumeIdentifier + "\".";
                                if (this.allowUnknownEnumValues) {
                                    TextFormat.logger.warning(str4);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken(str4);
                            }
                        }
                        break;
                    case 17:
                    case 18:
                        throw new RuntimeException("Can't get here.");
                }
            }
            if (fieldDescriptor.isRepeated()) {
                mergeTarget.addRepeatedField(fieldDescriptor, obj);
            } else {
                mergeTarget.setField(fieldDescriptor, obj);
            }
        }

        private void mergeAnyFieldValue(final Tokenizer tokenizer, final ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget target, final TextFormatParseInfoTree.Builder parseTreeBuilder, List<UnknownField> unknownFields, Descriptors.Descriptor anyDescriptor) throws ParseException {
            String str;
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append(tokenizer.consumeIdentifier());
                if (!tokenizer.tryConsume("]")) {
                    if (tokenizer.tryConsume("/")) {
                        sb.append("/");
                    } else if (tokenizer.tryConsume(".")) {
                        sb.append(".");
                    } else {
                        throw tokenizer.parseExceptionPreviousToken("Expected a valid type URL.");
                    }
                } else {
                    detectSilentMarker(tokenizer, anyDescriptor, sb.toString());
                    tokenizer.tryConsume(":");
                    if (tokenizer.tryConsume("<")) {
                        str = ">";
                    } else {
                        tokenizer.consume("{");
                        str = "}";
                    }
                    String str2 = str;
                    String sb2 = sb.toString();
                    try {
                        Descriptors.Descriptor descriptorForTypeUrl = this.typeRegistry.getDescriptorForTypeUrl(sb2);
                        if (descriptorForTypeUrl == null) {
                            throw tokenizer.parseException("Unable to parse Any of type: " + sb2 + ". Please make sure that the TypeRegistry contains the descriptors for the given types.");
                        }
                        DynamicMessage.Builder newBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                        MessageReflection.BuilderAdapter builderAdapter = new MessageReflection.BuilderAdapter(newBuilderForType);
                        while (!tokenizer.tryConsume(str2)) {
                            mergeField(tokenizer, extensionRegistry, builderAdapter, parseTreeBuilder, unknownFields);
                        }
                        target.setField(anyDescriptor.findFieldByName("type_url"), sb.toString());
                        target.setField(anyDescriptor.findFieldByName("value"), newBuilderForType.build().toByteString());
                        return;
                    } catch (InvalidProtocolBufferException unused) {
                        throw tokenizer.parseException("Invalid valid type URL. Found: " + sb2);
                    }
                }
            }
        }

        private void skipField(Tokenizer tokenizer, Descriptors.Descriptor type) throws ParseException {
            detectSilentMarker(tokenizer, type, consumeFullTypeName(tokenizer));
            guessFieldTypeAndSkip(tokenizer, type);
            if (tokenizer.tryConsume(";")) {
                return;
            }
            tokenizer.tryConsume(",");
        }

        private void skipFieldMessage(Tokenizer tokenizer, Descriptors.Descriptor type) throws ParseException {
            String str;
            if (tokenizer.tryConsume("<")) {
                str = ">";
            } else {
                tokenizer.consume("{");
                str = "}";
            }
            while (!tokenizer.lookingAt(">") && !tokenizer.lookingAt("}")) {
                skipField(tokenizer, type);
            }
            tokenizer.consume(str);
        }

        private void skipFieldValue(Tokenizer tokenizer) throws ParseException {
            if (tokenizer.tryConsumeString()) {
                while (tokenizer.tryConsumeString()) {
                }
            } else if (!tokenizer.tryConsumeIdentifier() && !tokenizer.tryConsumeInt64() && !tokenizer.tryConsumeUInt64() && !tokenizer.tryConsumeDouble() && !tokenizer.tryConsumeFloat()) {
                throw tokenizer.parseException("Invalid field value: " + tokenizer.currentToken);
            }
        }

        private void guessFieldTypeAndSkip(Tokenizer tokenizer, Descriptors.Descriptor type) throws ParseException {
            boolean tryConsume = tokenizer.tryConsume(":");
            if (tokenizer.lookingAt("[")) {
                skipFieldShortFormedRepeated(tokenizer, tryConsume, type);
            } else if (tryConsume && !tokenizer.lookingAt("{") && !tokenizer.lookingAt("<")) {
                skipFieldValue(tokenizer);
            } else {
                skipFieldMessage(tokenizer, type);
            }
        }

        private void skipFieldShortFormedRepeated(Tokenizer tokenizer, boolean scalarAllowed, Descriptors.Descriptor type) throws ParseException {
            if (!tokenizer.tryConsume("[") || tokenizer.tryConsume("]")) {
                return;
            }
            while (true) {
                if (tokenizer.lookingAt("{") || tokenizer.lookingAt("<")) {
                    skipFieldMessage(tokenizer, type);
                } else if (scalarAllowed) {
                    skipFieldValue(tokenizer);
                } else {
                    throw tokenizer.parseException("Invalid repeated scalar field: missing \":\" before \"[\".");
                }
                if (tokenizer.tryConsume("]")) {
                    return;
                } else {
                    tokenizer.consume(",");
                }
            }
        }
    }

    public static String escapeBytes(ByteString input) {
        return TextFormatEscaper.escapeBytes(input);
    }

    public static String escapeBytes(byte[] input) {
        return TextFormatEscaper.escapeBytes(input);
    }

    public static ByteString unescapeBytes(CharSequence charString) throws InvalidEscapeSequenceException {
        int i;
        int i2;
        int length;
        int i3;
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(charString.toString());
        int size = copyFromUtf8.size();
        byte[] bArr = new byte[size];
        int i4 = 0;
        int i5 = 0;
        while (i4 < copyFromUtf8.size()) {
            byte byteAt = copyFromUtf8.byteAt(i4);
            if (byteAt == 92) {
                int i6 = i4 + 1;
                if (i6 < copyFromUtf8.size()) {
                    byte byteAt2 = copyFromUtf8.byteAt(i6);
                    if (isOctal(byteAt2)) {
                        int digitValue = digitValue(byteAt2);
                        int i7 = i4 + 2;
                        if (i7 < copyFromUtf8.size() && isOctal(copyFromUtf8.byteAt(i7))) {
                            digitValue = (digitValue * 8) + digitValue(copyFromUtf8.byteAt(i7));
                            i6 = i7;
                        }
                        i4 = i6 + 1;
                        if (i4 >= copyFromUtf8.size() || !isOctal(copyFromUtf8.byteAt(i4))) {
                            i4 = i6;
                        } else {
                            digitValue = (digitValue * 8) + digitValue(copyFromUtf8.byteAt(i4));
                        }
                        i3 = i5 + 1;
                        bArr[i5] = (byte) digitValue;
                    } else {
                        if (byteAt2 == 34) {
                            i = i5 + 1;
                            bArr[i5] = 34;
                        } else if (byteAt2 == 39) {
                            i = i5 + 1;
                            bArr[i5] = 39;
                        } else if (byteAt2 != 63) {
                            if (byteAt2 == 85) {
                                int i8 = i4 + 2;
                                i2 = i4 + 9;
                                if (i2 >= copyFromUtf8.size()) {
                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
                                }
                                int i9 = 0;
                                int i10 = i8;
                                while (true) {
                                    int i11 = i4 + 10;
                                    if (i10 < i11) {
                                        byte byteAt3 = copyFromUtf8.byteAt(i10);
                                        if (!isHex(byteAt3)) {
                                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
                                        }
                                        i9 = (i9 << 4) | digitValue(byteAt3);
                                        i10++;
                                    } else {
                                        if (!Character.isValidCodePoint(i9)) {
                                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + copyFromUtf8.substring(i8, i11).toStringUtf8() + "' is not a valid code point value");
                                        }
                                        Character.UnicodeBlock of = Character.UnicodeBlock.of(i9);
                                        if (of != null && (of.equals(Character.UnicodeBlock.LOW_SURROGATES) || of.equals(Character.UnicodeBlock.HIGH_SURROGATES) || of.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES))) {
                                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + copyFromUtf8.substring(i8, i11).toStringUtf8() + "' refers to a surrogate code unit");
                                        }
                                        byte[] bytes = new String(new int[]{i9}, 0, 1).getBytes(Internal.UTF_8);
                                        System.arraycopy(bytes, 0, bArr, i5, bytes.length);
                                        length = bytes.length;
                                    }
                                }
                            } else if (byteAt2 == 92) {
                                i = i5 + 1;
                                bArr[i5] = 92;
                            } else if (byteAt2 == 102) {
                                i = i5 + 1;
                                bArr[i5] = 12;
                            } else if (byteAt2 == 110) {
                                i = i5 + 1;
                                bArr[i5] = 10;
                            } else if (byteAt2 == 114) {
                                i = i5 + 1;
                                bArr[i5] = 13;
                            } else if (byteAt2 == 120) {
                                int i12 = i4 + 2;
                                if (i12 < copyFromUtf8.size() && isHex(copyFromUtf8.byteAt(i12))) {
                                    int digitValue2 = digitValue(copyFromUtf8.byteAt(i12));
                                    i4 += 3;
                                    if (i4 >= copyFromUtf8.size() || !isHex(copyFromUtf8.byteAt(i4))) {
                                        i4 = i12;
                                    } else {
                                        digitValue2 = (digitValue2 * 16) + digitValue(copyFromUtf8.byteAt(i4));
                                    }
                                    i3 = i5 + 1;
                                    bArr[i5] = (byte) digitValue2;
                                } else {
                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                                }
                            } else if (byteAt2 == 97) {
                                i = i5 + 1;
                                bArr[i5] = 7;
                            } else if (byteAt2 == 98) {
                                i = i5 + 1;
                                bArr[i5] = 8;
                            } else {
                                switch (byteAt2) {
                                    case 116:
                                        i = i5 + 1;
                                        bArr[i5] = 9;
                                        break;
                                    case 117:
                                        int i13 = i4 + 2;
                                        i2 = i4 + 5;
                                        if (i2 < copyFromUtf8.size() && isHex(copyFromUtf8.byteAt(i13))) {
                                            int i14 = i4 + 3;
                                            if (isHex(copyFromUtf8.byteAt(i14))) {
                                                int i15 = i4 + 4;
                                                if (isHex(copyFromUtf8.byteAt(i15)) && isHex(copyFromUtf8.byteAt(i2))) {
                                                    char digitValue3 = (char) ((digitValue(copyFromUtf8.byteAt(i15)) << 4) | (digitValue(copyFromUtf8.byteAt(i13)) << 12) | (digitValue(copyFromUtf8.byteAt(i14)) << 8) | digitValue(copyFromUtf8.byteAt(i2)));
                                                    if (digitValue3 >= 55296 && digitValue3 <= 57343) {
                                                        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' refers to a surrogate");
                                                    }
                                                    byte[] bytes2 = Character.toString(digitValue3).getBytes(Internal.UTF_8);
                                                    System.arraycopy(bytes2, 0, bArr, i5, bytes2.length);
                                                    length = bytes2.length;
                                                    break;
                                                }
                                            }
                                        }
                                        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' with too few hex chars");
                                    case 118:
                                        i = i5 + 1;
                                        bArr[i5] = 11;
                                        break;
                                    default:
                                        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) byteAt2) + '\'');
                                }
                            }
                            i5 += length;
                            i4 = i2;
                        } else {
                            i = i5 + 1;
                            bArr[i5] = 63;
                        }
                        i5 = i;
                        i4 = i6;
                    }
                    i5 = i3;
                } else {
                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                bArr[i5] = byteAt;
                i5++;
            }
            i4++;
        }
        if (size == i5) {
            return ByteString.wrap(bArr);
        }
        return ByteString.copyFrom(bArr, 0, i5);
    }

    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(final String description) {
            super(description);
        }
    }

    static String escapeText(final String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    public static String escapeDoubleQuotesAndBackslashes(final String input) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(input);
    }

    static String unescapeText(final String input) throws InvalidEscapeSequenceException {
        return unescapeBytes(input).toStringUtf8();
    }

    static int parseInt32(final String text) throws NumberFormatException {
        return (int) parseInteger(text, true, false);
    }

    static int parseUInt32(final String text) throws NumberFormatException {
        return (int) parseInteger(text, false, false);
    }

    static long parseInt64(final String text) throws NumberFormatException {
        return parseInteger(text, true, true);
    }

    static long parseUInt64(final String text) throws NumberFormatException {
        return parseInteger(text, false, true);
    }

    private static long parseInteger(final String text, final boolean isSigned, final boolean isLong) throws NumberFormatException {
        int i;
        int i2 = 0;
        if (text.startsWith("-", 0)) {
            if (!isSigned) {
                throw new NumberFormatException("Number must be positive: " + text);
            }
            i2 = 1;
        }
        int i3 = i2;
        if (text.startsWith("0x", i2)) {
            i2 += 2;
            i = 16;
        } else {
            i = text.startsWith("0", i2) ? 8 : 10;
        }
        String substring = text.substring(i2);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i);
            if (i3 != 0) {
                parseLong = -parseLong;
            }
            if (isLong) {
                return parseLong;
            }
            if (isSigned) {
                if (parseLong > 2147483647L || parseLong < -2147483648L) {
                    throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
                }
                return parseLong;
            }
            if (parseLong >= 4294967296L || parseLong < 0) {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
            }
            return parseLong;
        }
        BigInteger bigInteger = new BigInteger(substring, i);
        if (i3 != 0) {
            bigInteger = bigInteger.negate();
        }
        if (isLong) {
            if (isSigned) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + text);
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + text);
            }
        } else if (isSigned) {
            if (bigInteger.bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
            }
        } else if (bigInteger.bitLength() > 32) {
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
        }
        return bigInteger.longValue();
    }
}
