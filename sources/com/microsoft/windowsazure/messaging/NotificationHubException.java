package com.microsoft.windowsazure.messaging;

/* loaded from: classes2.dex */
public class NotificationHubException extends Exception {
    private static final long serialVersionUID = -2417498840698257022L;
    private int mStatusCode;

    NotificationHubException(String str, int i) {
        super(str);
        this.mStatusCode = i;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
