package com.tylohelo.tylohelo;

/* loaded from: classes2.dex */
public class IRFilter {
    public static final int IR_CONSTANT = 101;
    public static final int IR_HIGH_VALUE = 10;
    public static final int IR_LOW_VALUE = 0;

    public static int irDecrease(int i) {
        return i > 0 ? i - 1 : i;
    }

    public static int irIncrease(int i) {
        return i < 10 ? i + 1 : i;
    }
}
