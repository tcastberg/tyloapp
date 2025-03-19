package com.microsoft.windowsazure.messaging.notificationhubs;

import com.android.volley.AuthFailureError;

/* loaded from: classes2.dex */
public class AuthorizationException extends NotificationHubException {
    AuthorizationException(AuthFailureError authFailureError) {
        super(authFailureError.networkResponse);
    }
}
