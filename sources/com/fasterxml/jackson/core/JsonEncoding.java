package com.fasterxml.jackson.core;

import tech.gusavila92.apache.commons.codec.CharEncoding;

/* loaded from: classes.dex */
public enum JsonEncoding {
    UTF8("UTF-8", false, 8),
    UTF16_BE(CharEncoding.UTF_16BE, true, 16),
    UTF16_LE(CharEncoding.UTF_16LE, false, 16),
    UTF32_BE("UTF-32BE", true, 32),
    UTF32_LE("UTF-32LE", false, 32);

    private final boolean _bigEndian;
    private final int _bits;
    private final String _javaName;

    JsonEncoding(String str, boolean z, int i) {
        this._javaName = str;
        this._bigEndian = z;
        this._bits = i;
    }

    public String getJavaName() {
        return this._javaName;
    }

    public boolean isBigEndian() {
        return this._bigEndian;
    }

    public int bits() {
        return this._bits;
    }
}
