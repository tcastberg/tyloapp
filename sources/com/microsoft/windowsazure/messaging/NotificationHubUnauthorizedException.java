package com.microsoft.windowsazure.messaging;

/* loaded from: classes2.dex */
public class NotificationHubUnauthorizedException extends NotificationHubException {
    private static final long serialVersionUID = -5926583893712403416L;

    NotificationHubUnauthorizedException() {
        super("Unauthorized", 401);
    }
}
