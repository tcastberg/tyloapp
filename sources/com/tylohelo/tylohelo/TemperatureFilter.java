package com.tylohelo.tylohelo;

/* loaded from: classes2.dex */
public class TemperatureFilter {
    public static String temperatureFilter(int i, int i2) {
        return i == 11 ? ((i2 / 5) + 32) + "" : (i2 / 9) + "";
    }

    public static String temperatureUnit(int i) {
        if (i == 11) {
            return "℉";
        }
        return "℃";
    }

    public static Integer minusOneDegree(int i, int i2, int i3) {
        int i4;
        if (i2 != 11 ? i - 9 >= i3 : i - 5 >= i3) {
            i = i4;
        }
        return Integer.valueOf(i);
    }

    public static Integer plusOneDegree(int i, int i2, int i3) {
        int i4;
        if (i2 != 11 ? (i4 = i + 9) <= i3 : (i4 = i + 5) <= i3) {
            i = i4;
        }
        return Integer.valueOf(i);
    }
}
