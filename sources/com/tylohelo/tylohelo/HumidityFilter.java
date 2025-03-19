package com.tylohelo.tylohelo;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes2.dex */
public class HumidityFilter {
    public static final int COMBI_NTC_MAX = 111;
    public static final int COMBI_NTC_MIN = 101;
    public static final int HUMIDITY_HIGH_VALUE = 70;
    public static final int HUMIDITY_LOW_VALUE = 0;
    FragmentActivity activity;
    Context context;

    public static int humidityDecrease(int i, boolean z, boolean z2) {
        return ((!z || i <= 0) && (!z2 || i <= 101)) ? i : i - 1;
    }

    public static int humidityIncrease(int i, boolean z, boolean z2) {
        return ((!z || i >= 70) && (!z2 || i >= 111 || i <= 70)) ? i : i + 1;
    }

    public HumidityFilter(Context context, FragmentActivity fragmentActivity) {
        this.context = context;
        this.activity = fragmentActivity;
    }

    public boolean showHumidity() {
        int productType = tyloApplication.getProductType();
        int systemType = tyloApplication.getSystemType();
        if (productType == 0 || systemType == 0) {
            return false;
        }
        return (productType == 30) | (systemType == 22);
    }

    public boolean showIr() {
        return tyloApplication.getProductType() == 39;
    }

    public boolean showCombiNtc() {
        return showHumidity() && tyloApplication.getHumiditySensorMissing();
    }
}
