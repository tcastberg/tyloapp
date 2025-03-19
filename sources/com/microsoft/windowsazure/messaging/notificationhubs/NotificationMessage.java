package com.microsoft.windowsazure.messaging.notificationhubs;

import java.util.Map;

/* loaded from: classes2.dex */
public interface NotificationMessage {
    String getBody();

    Map<String, String> getData();

    String getTitle();
}
