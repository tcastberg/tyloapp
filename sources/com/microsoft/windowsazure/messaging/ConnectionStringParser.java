package com.microsoft.windowsazure.messaging;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
class ConnectionStringParser {
    private int _pos = 0;
    private ParserState _state = ParserState.EXPECT_KEY;
    private String _value;

    private enum ParserState {
        EXPECT_KEY,
        EXPECT_ASSIGNMENT,
        EXPECT_VALUE,
        EXPECT_SEPARATOR
    }

    public static Map<String, String> parse(String str) {
        return new ConnectionStringParser(str).parse();
    }

    private ConnectionStringParser(String str) {
        this._value = str;
    }

    private Map<String, String> parse() {
        HashMap hashMap = new HashMap();
        loop0: while (true) {
            String str = null;
            while (true) {
                skipWhitespaces();
                if (this._pos == this._value.length() && this._state != ParserState.EXPECT_VALUE) {
                    break loop0;
                }
                int i = AnonymousClass1.$SwitchMap$com$microsoft$windowsazure$messaging$ConnectionStringParser$ParserState[this._state.ordinal()];
                if (i == 1) {
                    str = extractKey();
                    this._state = ParserState.EXPECT_ASSIGNMENT;
                } else if (i == 2) {
                    skipOperator('=');
                    this._state = ParserState.EXPECT_VALUE;
                } else if (i != 3) {
                    skipOperator(';');
                    this._state = ParserState.EXPECT_KEY;
                }
            }
            String extractValue = extractValue();
            this._state = ParserState.EXPECT_SEPARATOR;
            hashMap.put(str, extractValue);
        }
        if (this._state != ParserState.EXPECT_ASSIGNMENT) {
            return hashMap;
        }
        throw createException(this._pos, "Missing character %s", "=");
    }

    /* renamed from: com.microsoft.windowsazure.messaging.ConnectionStringParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$windowsazure$messaging$ConnectionStringParser$ParserState;

        static {
            int[] iArr = new int[ParserState.values().length];
            $SwitchMap$com$microsoft$windowsazure$messaging$ConnectionStringParser$ParserState = iArr;
            try {
                iArr[ParserState.EXPECT_KEY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$windowsazure$messaging$ConnectionStringParser$ParserState[ParserState.EXPECT_ASSIGNMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$windowsazure$messaging$ConnectionStringParser$ParserState[ParserState.EXPECT_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private IllegalArgumentException createException(int i, String str, Object... objArr) {
        return new IllegalArgumentException(String.format("Invalid connection string: %s.", String.format("Error parsing connection string: %s. Position %s", String.format(str, objArr), Integer.valueOf(this._pos))));
    }

    private void skipWhitespaces() {
        while (this._pos < this._value.length() && Character.isWhitespace(this._value.charAt(this._pos))) {
            this._pos++;
        }
    }

    private String extractKey() {
        String extractString;
        int i = this._pos;
        String str = this._value;
        this._pos = i + 1;
        char charAt = str.charAt(i);
        if (charAt == '\"' || charAt == '\'') {
            extractString = extractString(charAt);
        } else {
            if (charAt == ';' || charAt == '=') {
                throw createException(i, "Missing key", new Object[0]);
            }
            while (this._pos < this._value.length() && this._value.charAt(this._pos) != '=') {
                this._pos++;
            }
            extractString = this._value.substring(i, this._pos).trim();
        }
        if (extractString.length() != 0) {
            return extractString;
        }
        throw createException(i, "Empty key", new Object[0]);
    }

    private String extractString(char c) {
        int i = this._pos;
        while (this._pos < this._value.length() && this._value.charAt(this._pos) != c) {
            this._pos++;
        }
        if (this._pos == this._value.length()) {
            throw createException(this._pos, "Missing character", Character.valueOf(c));
        }
        String str = this._value;
        int i2 = this._pos;
        this._pos = i2 + 1;
        return str.substring(i, i2);
    }

    private void skipOperator(char c) {
        if (this._value.charAt(this._pos) != c) {
            throw createException(this._pos, "Missing character", Character.valueOf(c));
        }
        this._pos++;
    }

    private String extractValue() {
        if (this._pos >= this._value.length()) {
            return "";
        }
        char charAt = this._value.charAt(this._pos);
        if (charAt == '\'' || charAt == '\"') {
            this._pos++;
            return extractString(charAt);
        }
        int i = this._pos;
        boolean z = false;
        while (this._pos < this._value.length() && !z) {
            if (this._value.charAt(this._pos) == ';') {
                if (isStartWithKnownKey()) {
                    z = true;
                } else {
                    this._pos++;
                }
            } else {
                this._pos++;
            }
        }
        return this._value.substring(i, this._pos).trim();
    }

    private boolean isStartWithKnownKey() {
        Locale locale = Locale.getDefault();
        int length = this._value.length();
        int i = this._pos;
        return length <= i + 1 || this._value.substring(i + 1).toLowerCase(locale).startsWith("endpoint") || this._value.substring(this._pos + 1).toLowerCase(locale).startsWith("stsendpoint") || this._value.substring(this._pos + 1).toLowerCase(locale).startsWith("sharedsecretissuer") || this._value.substring(this._pos + 1).toLowerCase(locale).startsWith("sharedsecretvalue") || this._value.substring(this._pos + 1).toLowerCase(locale).startsWith("sharedaccesskeyname") || this._value.substring(this._pos + 1).toLowerCase(locale).startsWith("sharedaccesskey");
    }
}
