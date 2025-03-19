package com.tylohelo.tylohelo;

import android.app.Application;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import androidx.fragment.app.FragmentActivity;
import com.microsoft.windowsazure.messaging.NotificationHub;

/* loaded from: classes2.dex */
public class tyloApplication extends Application {
    private static CloudService cloudService;
    private static ComService comService;
    private static NotificationHub hub;
    private static MessageToSaunaSystem msgToSauna;
    private static SaunaService saunaService;
    private static WifiService wifiService;
    private static Boolean isVisible = false;
    private static int productType = 0;
    private static int systemType = 0;
    private static boolean humiditySensorMissing = false;
    private static networkType_t networkType = networkType_t.NETWORK_NONE;
    private static boolean jumpToHomeScreen = false;
    private static boolean connectionReplyReceived = false;
    private static final int[] maxHumidityFromTemperature = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 80, 70, 65, 62, 60, 58, 55, 52, 50, 48, 46, 44, 42, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 25, 24, 23, 22, 21, 21, 20, 19, 18, 17, 17, 16, 15, 14, 14, 13, 13, 12, 11, 10, 10, 9, 8, 7, 7, 6, 5, 4, 3, 2, 1, 0, 0, 0, 0, 0};
    private static final int[] maxTemperatureFromHumidity = {110, 105, 104, 103, 102, 101, 100, 99, 97, 96, 95, 93, 92, 91, 89, 87, 86, 85, 83, 82, 81, 80, 78, 77, 76, 75, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 58, 57, 57, 56, 56, 55, 55, 54, 54, 53, 53, 52, 52, 52, 51, 51, 51, 50, 50, 49, 49, 48, 48, 48, 47, 47, 47, 47, 47, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45};

    enum networkType_t {
        NETWORK_NONE,
        NETWORK_CLOUD,
        NETWORK_WIFI
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
    }

    public static ComService getComService() {
        return comService;
    }

    public static void setComService(ComService comService2) {
        comService = comService2;
    }

    public static Boolean getIsVisible() {
        return isVisible;
    }

    public static void setIsVisible(Boolean bool) {
        isVisible = bool;
    }

    public static CloudService getCloudService() {
        return cloudService;
    }

    public static void setCloudService(CloudService cloudService2) {
        cloudService = cloudService2;
    }

    public static SaunaService getSaunaService() {
        return saunaService;
    }

    public static void setSaunaService(SaunaService saunaService2) {
        saunaService = saunaService2;
    }

    public static NotificationHub getNotificationHub() {
        return hub;
    }

    public static void setNotificationHub(NotificationHub notificationHub) {
        hub = notificationHub;
    }

    public static MessageToSaunaSystem getMessageToSaunaSystem() {
        return msgToSauna;
    }

    public static void setMessageToSaunaSystem(MessageToSaunaSystem messageToSaunaSystem) {
        msgToSauna = messageToSaunaSystem;
    }

    public static WifiService getWifiService() {
        return wifiService;
    }

    public static void setWifiService(WifiService wifiService2) {
        wifiService = wifiService2;
    }

    public static SpannableString alignTwoStrings(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + "\n" + str2);
        spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL), 0, str.length(), 17);
        spannableString.setSpan(new LineOverlapSpan(), str.length(), str.length() + 1, 17);
        spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), str.length() + 1, str.length() + 1 + str2.length(), 17);
        return spannableString;
    }

    public static String getTimeString(int i, int i2) {
        String str = i + ":";
        String str2 = i2 + "";
        if (i < 10) {
            str = "0" + i + ":";
        }
        if (i2 < 10) {
            str2 = "0" + i2;
        }
        return str + str2;
    }

    public static void setProductType(int i) {
        productType = i;
    }

    public static int getProductType() {
        return productType;
    }

    public static void setSystemType(int i) {
        systemType = i;
    }

    public static int getSystemType() {
        return systemType;
    }

    public static void setHumiditySensorMissing(Integer num) {
        humiditySensorMissing = num.intValue() == 0;
    }

    public static boolean getHumiditySensorMissing() {
        return humiditySensorMissing;
    }

    public static boolean isConnected(FragmentActivity fragmentActivity, SharedViewModel sharedViewModel) {
        SaunaService saunaService2 = getSaunaService();
        if (saunaService2 == null) {
            saunaService2 = new SaunaService(fragmentActivity);
            setSaunaService(saunaService2);
        }
        String currentSaunaId = saunaService2.getCurrentSaunaId();
        if (currentSaunaId != null) {
            SaunaModel saunaStored = saunaService2.getSaunaStored(currentSaunaId);
            if (saunaService2.getCloudEnabled() && saunaStored.getAPIKey() == null) {
                saunaStored.setConnected(false);
                saunaService2.storeSauna(saunaStored);
                sharedViewModel.setWifiOnline(false);
                sharedViewModel.setIsSaunaUpdated(true);
                return false;
            }
            if (saunaStored != null && saunaStored.isConnected()) {
                return true;
            }
            sharedViewModel.setWifiOnline(false);
            sharedViewModel.setCloudOnline(false);
            return false;
        }
        sharedViewModel.setWifiOnline(false);
        sharedViewModel.setCloudOnline(false);
        return false;
    }

    public static void setNetworkType(networkType_t networktype_t) {
        networkType = networktype_t;
    }

    public static networkType_t getNetworkType() {
        return networkType;
    }

    public static void resetSaunaParams() {
        networkType = networkType_t.NETWORK_NONE;
        productType = 0;
        systemType = 0;
        humiditySensorMissing = false;
    }

    public static void setJumpToHomeScreen(boolean z) {
        jumpToHomeScreen = z;
    }

    public static boolean getJumpToHomeScreen() {
        return jumpToHomeScreen;
    }

    public static void setConnectionReplyReceived(boolean z) {
        connectionReplyReceived = z;
    }

    public static boolean getConnectionReplyReceived() {
        return connectionReplyReceived;
    }

    public static int getMaxTemperature(int i) {
        return maxTemperatureFromHumidity[i] * 9;
    }

    public static int getMaxHumidity(int i) {
        return maxHumidityFromTemperature[i / 9];
    }
}
