package com.microsoft.windowsazure.messaging.notificationhubs;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class ConnectionString {
    private static final String ENDPOINT_KEY = "Endpoint";
    private static final Pattern PORTAL_FORMAT_PATTERN = Pattern.compile("([^=]+)=([^;]+);?");
    private static final String SHARED_ACCESS_KEY = "SharedAccessKey";
    private static final String SHARED_ACCESS_KEY_NAME_KEY = "SharedAccessKeyName";
    private String mEndpoint;
    private String mSharedAccessKey;
    private String mSharedAccessKeyName;

    ConnectionString(String str, String str2, String str3) {
        if (isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("Endpoint parameter can not be null or empty");
        }
        if (isNullOrWhiteSpace(str2)) {
            throw new IllegalArgumentException("SharedAccessKeyName parameter can not be null or empty");
        }
        if (isNullOrWhiteSpace(str3)) {
            throw new IllegalArgumentException("SharedAccessKey parameter can not be null or empty");
        }
        this.mEndpoint = str;
        this.mSharedAccessKeyName = str2;
        this.mSharedAccessKey = str3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
    
        if (r4.equals(com.microsoft.windowsazure.messaging.notificationhubs.ConnectionString.SHARED_ACCESS_KEY_NAME_KEY) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.microsoft.windowsazure.messaging.notificationhubs.ConnectionString parse(java.lang.String r8) {
        /*
            java.util.regex.Pattern r0 = com.microsoft.windowsazure.messaging.notificationhubs.ConnectionString.PORTAL_FORMAT_PATTERN
            java.util.regex.Matcher r8 = r0.matcher(r8)
            java.lang.String r0 = ""
            r1 = r0
            r2 = r1
        La:
            boolean r3 = r8.find()
            if (r3 == 0) goto L54
            r3 = 1
            java.lang.String r4 = r8.group(r3)
            r4.hashCode()
            int r5 = r4.hashCode()
            r6 = 2
            r7 = -1
            switch(r5) {
                case -716565674: goto L37;
                case 820602625: goto L2e;
                case 1805746613: goto L23;
                default: goto L21;
            }
        L21:
            r3 = r7
            goto L41
        L23:
            java.lang.String r3 = "Endpoint"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L2c
            goto L21
        L2c:
            r3 = r6
            goto L41
        L2e:
            java.lang.String r5 = "SharedAccessKeyName"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L41
            goto L21
        L37:
            java.lang.String r3 = "SharedAccessKey"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L40
            goto L21
        L40:
            r3 = 0
        L41:
            switch(r3) {
                case 0: goto L4f;
                case 1: goto L4a;
                case 2: goto L45;
                default: goto L44;
            }
        L44:
            goto La
        L45:
            java.lang.String r0 = r8.group(r6)
            goto La
        L4a:
            java.lang.String r1 = r8.group(r6)
            goto La
        L4f:
            java.lang.String r2 = r8.group(r6)
            goto La
        L54:
            com.microsoft.windowsazure.messaging.notificationhubs.ConnectionString r8 = new com.microsoft.windowsazure.messaging.notificationhubs.ConnectionString
            r8.<init>(r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.windowsazure.messaging.notificationhubs.ConnectionString.parse(java.lang.String):com.microsoft.windowsazure.messaging.notificationhubs.ConnectionString");
    }

    public String getEndpoint() {
        return this.mEndpoint;
    }

    public String getSharedAccessKeyName() {
        return this.mSharedAccessKeyName;
    }

    public String getSharedAccessKey() {
        return this.mSharedAccessKey;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionString)) {
            return false;
        }
        ConnectionString connectionString = (ConnectionString) obj;
        return this.mSharedAccessKey.equals(connectionString.mSharedAccessKey) && this.mSharedAccessKeyName.equals(connectionString.mSharedAccessKeyName) && this.mEndpoint.equalsIgnoreCase(connectionString.mEndpoint);
    }

    public String toString() {
        return "Endpoint=" + this.mEndpoint + ";SharedAccessKeyName=" + this.mSharedAccessKeyName + ";SharedAccessKey=" + this.mSharedAccessKey + ';';
    }

    private static boolean isNullOrWhiteSpace(String str) {
        return str == null || str.trim().equals("");
    }
}
