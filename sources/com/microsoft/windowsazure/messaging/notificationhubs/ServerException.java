package com.microsoft.windowsazure.messaging.notificationhubs;

import com.android.volley.ServerError;

/* loaded from: classes2.dex */
public class ServerException extends NotificationHubException {
    ServerException(ServerError serverError) {
        super(serverError.networkResponse);
    }
}
