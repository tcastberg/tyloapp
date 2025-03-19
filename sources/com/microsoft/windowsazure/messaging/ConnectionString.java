package com.microsoft.windowsazure.messaging;

import java.net.URI;

/* loaded from: classes2.dex */
public class ConnectionString {
    public static String createUsingSharedAccessKey(URI uri, String str, String str2) {
        if (uri == null) {
            throw new IllegalArgumentException("endPoint");
        }
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("keyName");
        }
        if (Utils.isNullOrWhiteSpace(str2)) {
            throw new IllegalArgumentException("accessSecret");
        }
        return String.format("Endpoint=%s;SharedAccessKeyName=%s;SharedAccessKey=%s", uri.toString(), str, str2);
    }

    public static String createUsingSharedAccessKeyWithFullAccess(URI uri, String str) {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("fullAccessSecret");
        }
        return createUsingSharedAccessKey(uri, "DefaultFullSharedAccessSignature", str);
    }

    public static String createUsingSharedAccessKeyWithListenAccess(URI uri, String str) {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("listenAccessSecret");
        }
        return createUsingSharedAccessKey(uri, "DefaultListenSharedAccessSignature", str);
    }
}
