package com.tylohelo.tylohelo;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: classes2.dex */
public class LineOverlapSpan implements LineHeightSpan {
    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        fontMetricsInt.bottom += fontMetricsInt.top;
        fontMetricsInt.descent += fontMetricsInt.top;
    }
}
