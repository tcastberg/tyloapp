package com.google.android.gms.common.util;

import android.os.Build;
import androidx.core.os.BuildCompat;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes.dex */
public final class PlatformVersion {
    private PlatformVersion() {
    }

    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwichMR1() {
        return true;
    }

    public static boolean isAtLeastJellyBean() {
        return true;
    }

    public static boolean isAtLeastJellyBeanMR1() {
        return true;
    }

    public static boolean isAtLeastJellyBeanMR2() {
        return true;
    }

    public static boolean isAtLeastKitKat() {
        return true;
    }

    public static boolean isAtLeastKitKatWatch() {
        return true;
    }

    public static boolean isAtLeastLollipop() {
        return true;
    }

    public static boolean isAtLeastLollipopMR1() {
        return true;
    }

    public static boolean isAtLeastM() {
        return true;
    }

    public static boolean isAtLeastN() {
        return true;
    }

    public static boolean isAtLeastO() {
        return true;
    }

    public static boolean isAtLeastP() {
        return true;
    }

    public static boolean isAtLeastQ() {
        return true;
    }

    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean isAtLeastSv2() {
        return Build.VERSION.SDK_INT >= 32;
    }

    public static boolean isAtLeastT() {
        return Build.VERSION.SDK_INT >= 33 || Build.VERSION.CODENAME.charAt(0) == 'T';
    }

    public static boolean isAtLeastU() {
        if (isAtLeastT()) {
            return BuildCompat.isAtLeastU();
        }
        return false;
    }
}
