package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.UByte;
import tech.gusavila92.apache.http.message.TokenParser;

/* loaded from: classes.dex */
public final class Base64Variant implements Serializable {
    public static final int BASE64_VALUE_INVALID = -1;
    public static final int BASE64_VALUE_PADDING = -2;
    private static final int INT_SPACE = 32;
    static final char PADDING_CHAR_NONE = 0;
    private static final long serialVersionUID = 1;
    private final transient int[] _asciiToBase64;
    private final transient byte[] _base64ToAsciiB;
    private final transient char[] _base64ToAsciiC;
    private final transient int _maxLineLength;
    final String _name;
    private final transient char _paddingChar;
    private final transient boolean _usesPadding;

    public boolean equals(Object obj) {
        return obj == this;
    }

    public Base64Variant(String str, String str2, boolean z, char c, int i) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = this._base64ToAsciiC[i2];
            this._base64ToAsciiB[i2] = (byte) c2;
            this._asciiToBase64[c2] = i2;
        }
        if (z) {
            this._asciiToBase64[c] = -2;
        }
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant._usesPadding, base64Variant._paddingChar, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, int i) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        byte[] bArr = new byte[64];
        this._base64ToAsciiB = bArr;
        this._name = str;
        byte[] bArr2 = base64Variant._base64ToAsciiB;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant._base64ToAsciiC;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant._asciiToBase64;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
    }

    protected Object readResolve() {
        return Base64Variants.valueOf(this._name);
    }

    public String getName() {
        return this._name;
    }

    public boolean usesPadding() {
        return this._usesPadding;
    }

    public boolean usesPaddingChar(char c) {
        return c == this._paddingChar;
    }

    public boolean usesPaddingChar(int i) {
        return i == this._paddingChar;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public byte getPaddingByte() {
        return (byte) this._paddingChar;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public int decodeBase64Char(char c) {
        if (c <= 127) {
            return this._asciiToBase64[c];
        }
        return -1;
    }

    public int decodeBase64Char(int i) {
        if (i <= 127) {
            return this._asciiToBase64[i];
        }
        return -1;
    }

    public int decodeBase64Byte(byte b) {
        if (b < 0) {
            return -1;
        }
        return this._asciiToBase64[b];
    }

    public char encodeBase64BitsAsChar(int i) {
        return this._base64ToAsciiC[i];
    }

    public int encodeBase64Chunk(int i, char[] cArr, int i2) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i2] = cArr2[(i >> 18) & 63];
        cArr[i2 + 1] = cArr2[(i >> 12) & 63];
        int i3 = i2 + 3;
        cArr[i2 + 2] = cArr2[(i >> 6) & 63];
        int i4 = i2 + 4;
        cArr[i3] = cArr2[i & 63];
        return i4;
    }

    public void encodeBase64Chunk(StringBuilder sb, int i) {
        sb.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 12) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 6) & 63]);
        sb.append(this._base64ToAsciiC[i & 63]);
    }

    public int encodeBase64Partial(int i, int i2, char[] cArr, int i3) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i3] = cArr2[(i >> 18) & 63];
        int i4 = i3 + 2;
        cArr[i3 + 1] = cArr2[(i >> 12) & 63];
        if (this._usesPadding) {
            int i5 = i3 + 3;
            cArr[i4] = i2 == 2 ? cArr2[(i >> 6) & 63] : this._paddingChar;
            int i6 = i3 + 4;
            cArr[i5] = this._paddingChar;
            return i6;
        }
        if (i2 != 2) {
            return i4;
        }
        int i7 = i3 + 3;
        cArr[i4] = cArr2[(i >> 6) & 63];
        return i7;
    }

    public void encodeBase64Partial(StringBuilder sb, int i, int i2) {
        sb.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 12) & 63]);
        if (this._usesPadding) {
            sb.append(i2 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar);
            sb.append(this._paddingChar);
        } else if (i2 == 2) {
            sb.append(this._base64ToAsciiC[(i >> 6) & 63]);
        }
    }

    public byte encodeBase64BitsAsByte(int i) {
        return this._base64ToAsciiB[i];
    }

    public int encodeBase64Chunk(int i, byte[] bArr, int i2) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i2] = bArr2[(i >> 18) & 63];
        bArr[i2 + 1] = bArr2[(i >> 12) & 63];
        int i3 = i2 + 3;
        bArr[i2 + 2] = bArr2[(i >> 6) & 63];
        int i4 = i2 + 4;
        bArr[i3] = bArr2[i & 63];
        return i4;
    }

    public int encodeBase64Partial(int i, int i2, byte[] bArr, int i3) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i3] = bArr2[(i >> 18) & 63];
        int i4 = i3 + 2;
        bArr[i3 + 1] = bArr2[(i >> 12) & 63];
        if (!this._usesPadding) {
            if (i2 != 2) {
                return i4;
            }
            int i5 = i3 + 3;
            bArr[i4] = bArr2[(i >> 6) & 63];
            return i5;
        }
        byte b = (byte) this._paddingChar;
        int i6 = i3 + 3;
        bArr[i4] = i2 == 2 ? bArr2[(i >> 6) & 63] : b;
        int i7 = i3 + 4;
        bArr[i6] = b;
        return i7;
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public String encode(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z) {
            sb.append('\"');
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i = length - 3;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = i2 + 2;
            int i4 = ((bArr[i2 + 1] & UByte.MAX_VALUE) | (bArr[i2] << 8)) << 8;
            i2 += 3;
            encodeBase64Chunk(sb, i4 | (bArr[i3] & UByte.MAX_VALUE));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append(TokenParser.ESCAPE);
                sb.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i5 = length - i2;
        if (i5 > 0) {
            int i6 = i2 + 1;
            int i7 = bArr[i2] << 16;
            if (i5 == 2) {
                i7 |= (bArr[i6] & UByte.MAX_VALUE) << 8;
            }
            encodeBase64Partial(sb, i7, i5);
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public String encode(byte[] bArr, boolean z, String str) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z) {
            sb.append('\"');
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i = length - 3;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = i2 + 2;
            int i4 = ((bArr[i2 + 1] & UByte.MAX_VALUE) | (bArr[i2] << 8)) << 8;
            i2 += 3;
            encodeBase64Chunk(sb, i4 | (bArr[i3] & UByte.MAX_VALUE));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append(str);
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i5 = length - i2;
        if (i5 > 0) {
            int i6 = i2 + 1;
            int i7 = bArr[i2] << 16;
            if (i5 == 2) {
                i7 |= (bArr[i6] & UByte.MAX_VALUE) << 8;
            }
            encodeBase64Partial(sb, i7, i5);
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public byte[] decode(String str) throws IllegalArgumentException {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        decode(str, byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }

    public void decode(String str, ByteArrayBuilder byteArrayBuilder) throws IllegalArgumentException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt > ' ') {
                int decodeBase64Char = decodeBase64Char(charAt);
                if (decodeBase64Char < 0) {
                    _reportInvalidBase64(charAt, 0, null);
                }
                if (i2 >= length) {
                    _reportBase64EOF();
                }
                int i3 = i + 2;
                char charAt2 = str.charAt(i2);
                int decodeBase64Char2 = decodeBase64Char(charAt2);
                if (decodeBase64Char2 < 0) {
                    _reportInvalidBase64(charAt2, 1, null);
                }
                int i4 = (decodeBase64Char << 6) | decodeBase64Char2;
                if (i3 >= length) {
                    if (!usesPadding()) {
                        byteArrayBuilder.append(i4 >> 4);
                        return;
                    }
                    _reportBase64EOF();
                }
                int i5 = i + 3;
                char charAt3 = str.charAt(i3);
                int decodeBase64Char3 = decodeBase64Char(charAt3);
                if (decodeBase64Char3 < 0) {
                    if (decodeBase64Char3 != -2) {
                        _reportInvalidBase64(charAt3, 2, null);
                    }
                    if (i5 >= length) {
                        _reportBase64EOF();
                    }
                    i += 4;
                    char charAt4 = str.charAt(i5);
                    if (!usesPaddingChar(charAt4)) {
                        _reportInvalidBase64(charAt4, 3, "expected padding character '" + getPaddingChar() + "'");
                    }
                    byteArrayBuilder.append(i4 >> 4);
                } else {
                    int i6 = (i4 << 6) | decodeBase64Char3;
                    if (i5 >= length) {
                        if (!usesPadding()) {
                            byteArrayBuilder.appendTwoBytes(i6 >> 2);
                            return;
                        }
                        _reportBase64EOF();
                    }
                    i += 4;
                    char charAt5 = str.charAt(i5);
                    int decodeBase64Char4 = decodeBase64Char(charAt5);
                    if (decodeBase64Char4 < 0) {
                        if (decodeBase64Char4 != -2) {
                            _reportInvalidBase64(charAt5, 3, null);
                        }
                        byteArrayBuilder.appendTwoBytes(i6 >> 2);
                    } else {
                        byteArrayBuilder.appendThreeBytes((i6 << 6) | decodeBase64Char4);
                    }
                }
            } else {
                i = i2;
            }
        }
    }

    public String toString() {
        return this._name;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    protected void _reportInvalidBase64(char c, int i, String str) throws IllegalArgumentException {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (usesPaddingChar(c)) {
            str2 = "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    protected void _reportBase64EOF() throws IllegalArgumentException {
        throw new IllegalArgumentException(missingPaddingMessage());
    }

    public String missingPaddingMessage() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end", getName(), Character.valueOf(getPaddingChar()));
    }
}
