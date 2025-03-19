package com.microsoft.windowsazure.messaging.notificationhubs;

import java.util.Map;

/* loaded from: classes2.dex */
class BasicNotificationMessage implements NotificationMessage {
    private final Map<String, String> mData;
    private final String mMessage;
    private final String mTitle;

    public BasicNotificationMessage(String str, String str2, Map<String, String> map) {
        this.mTitle = str;
        this.mMessage = str2;
        this.mData = map;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.NotificationMessage
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.NotificationMessage
    public String getBody() {
        return this.mMessage;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.NotificationMessage
    public Map<String, String> getData() {
        return this.mData;
    }
}
