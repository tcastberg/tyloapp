package com.microsoft.windowsazure.messaging.notificationhubs;

import com.android.volley.ClientError;

/* loaded from: classes2.dex */
public class ClientException extends NotificationHubException {
    ClientException(ClientError clientError) {
        super(clientError.networkResponse);
    }
}
