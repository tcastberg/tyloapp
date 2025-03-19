package com.microsoft.windowsazure.messaging;

import tech.gusavila92.apache.http.HttpStatus;

/* loaded from: classes2.dex */
public class NotificationHubResourceNotFoundException extends NotificationHubException {
    private static final long serialVersionUID = -1205615098165583127L;

    NotificationHubResourceNotFoundException() {
        super("Resource not found", HttpStatus.SC_NOT_FOUND);
    }
}
