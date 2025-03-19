package com.microsoft.windowsazure.messaging;

import android.os.Build;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
class Connection {
    private static final String API_VERSION = "2014-09";
    private static final String API_VERSION_KEY = "api-version";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String ENDPOINT_KEY = "Endpoint";
    private static final int EXPIRE_MINUTES = 5;
    private static final String SDK_VERSION = "2014-09";
    private static final String SHARED_ACCESS_KEY = "SharedAccessKey";
    private static final String SHARED_ACCESS_KEY_NAME = "SharedAccessKeyName";
    private static final String UTC_TIME_ZONE = "UTC";
    private static final String UTF8_ENCODING = "UTF-8";
    private Map<String, String> mConnectionData;

    public Connection(String str) {
        this.mConnectionData = ConnectionStringParser.parse(str);
    }

    public String executeRequest(String str, String str2, String str3, String str4, AbstractMap.SimpleEntry<String, String>... simpleEntryArr) throws Exception {
        return executeRequest(str, str2, str3, str4, null, simpleEntryArr);
    }

    public String executeRequest(String str, String str2, String str3, String str4, String str5, AbstractMap.SimpleEntry<String, String>... simpleEntryArr) throws Exception {
        URI create = URI.create(this.mConnectionData.get(ENDPOINT_KEY));
        String str6 = "https" + create.toString().substring(create.getScheme().length());
        if (!str6.endsWith("/")) {
            str6 = str6 + "/";
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(AddApiVersionToUrl(str6 + str)).openConnection();
        httpURLConnection.setRequestMethod(str4);
        httpURLConnection.setRequestProperty("Content-Type", str3);
        if (simpleEntryArr != null) {
            for (AbstractMap.SimpleEntry<String, String> simpleEntry : simpleEntryArr) {
                httpURLConnection.setRequestProperty(simpleEntry.getKey(), simpleEntry.getValue());
            }
        }
        return executeRequest(httpURLConnection, str5, str2);
    }

    private String AddApiVersionToUrl(String str) {
        String str2;
        if (URI.create(str).getQuery() == null) {
            str2 = str + "?";
        } else {
            str2 = str + "&";
        }
        return str2 + "api-version=2014-09";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String executeRequest(java.net.HttpURLConnection r6, java.lang.String r7, java.lang.String r8) throws java.lang.Exception {
        /*
            r5 = this;
            r5.addAuthorizationHeader(r6)
            java.lang.String r0 = "User-Agent"
            java.lang.String r1 = r5.getUserAgent()     // Catch: java.lang.Throwable -> La1
            r6.setRequestProperty(r0, r1)     // Catch: java.lang.Throwable -> La1
            boolean r0 = com.microsoft.windowsazure.messaging.Utils.isNullOrWhiteSpace(r8)     // Catch: java.lang.Throwable -> La1
            r1 = 1
            if (r0 == 0) goto L17
            r6.connect()     // Catch: java.lang.Throwable -> La1
            goto L36
        L17:
            r6.setDoOutput(r1)     // Catch: java.lang.Throwable -> La1
            java.io.OutputStream r0 = r6.getOutputStream()     // Catch: java.lang.Throwable -> La1
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> La1
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> La1
            java.lang.String r4 = "UTF-8"
            r3.<init>(r0, r4)     // Catch: java.lang.Throwable -> La1
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La1
            r2.write(r8)     // Catch: java.lang.Throwable -> La1
            r2.flush()     // Catch: java.lang.Throwable -> La1
            r2.close()     // Catch: java.lang.Throwable -> La1
            r0.close()     // Catch: java.lang.Throwable -> La1
        L36:
            int r8 = r6.getResponseCode()     // Catch: java.lang.Throwable -> La1
            java.lang.String r5 = r5.getResponseContent(r6)     // Catch: java.lang.Throwable -> La1
            r0 = 0
            r2 = 0
            if (r7 == 0) goto L4d
            java.lang.String r3 = r6.getHeaderField(r7)     // Catch: java.lang.Throwable -> La1
            if (r3 != 0) goto L49
            goto L4e
        L49:
            java.lang.String r0 = r6.getHeaderField(r7)     // Catch: java.lang.Throwable -> La1
        L4d:
            r1 = r2
        L4e:
            if (r6 == 0) goto L53
            r6.disconnect()
        L53:
            r6 = 200(0xc8, float:2.8E-43)
            if (r8 < r6) goto L7d
            r6 = 300(0x12c, float:4.2E-43)
            if (r8 >= r6) goto L7d
            if (r1 != 0) goto L62
            if (r7 != 0) goto L60
            goto L61
        L60:
            r5 = r0
        L61:
            return r5
        L62:
            com.microsoft.windowsazure.messaging.NotificationHubException r5 = new com.microsoft.windowsazure.messaging.NotificationHubException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "The '"
            r6.<init>(r0)
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = "' header does not present in collection"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6, r8)
            throw r5
        L7d:
            r6 = 404(0x194, float:5.66E-43)
            if (r8 == r6) goto L9b
            r6 = 401(0x191, float:5.62E-43)
            if (r8 == r6) goto L95
            r6 = 410(0x19a, float:5.75E-43)
            if (r8 != r6) goto L8f
            com.microsoft.windowsazure.messaging.RegistrationGoneException r5 = new com.microsoft.windowsazure.messaging.RegistrationGoneException
            r5.<init>()
            throw r5
        L8f:
            com.microsoft.windowsazure.messaging.NotificationHubException r6 = new com.microsoft.windowsazure.messaging.NotificationHubException
            r6.<init>(r5, r8)
            throw r6
        L95:
            com.microsoft.windowsazure.messaging.NotificationHubUnauthorizedException r5 = new com.microsoft.windowsazure.messaging.NotificationHubUnauthorizedException
            r5.<init>()
            throw r5
        L9b:
            com.microsoft.windowsazure.messaging.NotificationHubResourceNotFoundException r5 = new com.microsoft.windowsazure.messaging.NotificationHubResourceNotFoundException
            r5.<init>()
            throw r5
        La1:
            r5 = move-exception
            if (r6 == 0) goto La7
            r6.disconnect()
        La7:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.windowsazure.messaging.Connection.executeRequest(java.net.HttpURLConnection, java.lang.String, java.lang.String):java.lang.String");
    }

    private String getResponseContent(HttpURLConnection httpURLConnection) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            while (readLine != null) {
                sb.append(readLine);
                sb.append('\n');
                readLine = bufferedReader.readLine();
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void addAuthorizationHeader(HttpURLConnection httpURLConnection) throws InvalidKeyException {
        httpURLConnection.setRequestProperty("Authorization", generateAuthToken(httpURLConnection.getURL().toString()));
    }

    private String generateAuthToken(String str) throws InvalidKeyException {
        Mac mac;
        String str2 = this.mConnectionData.get(SHARED_ACCESS_KEY_NAME);
        if (Utils.isNullOrWhiteSpace(str2)) {
            throw new AssertionError(SHARED_ACCESS_KEY_NAME);
        }
        String str3 = this.mConnectionData.get(SHARED_ACCESS_KEY);
        if (Utils.isNullOrWhiteSpace(str3)) {
            throw new AssertionError(SHARED_ACCESS_KEY);
        }
        try {
            str = URLEncoder.encode(str, "UTF-8").toLowerCase(Locale.ENGLISH);
        } catch (UnsupportedEncodingException unused) {
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(UTC_TIME_ZONE));
        calendar.add(12, 5);
        long timeInMillis = calendar.getTimeInMillis() / 1000;
        byte[] bytes = (str + '\n' + timeInMillis).getBytes();
        try {
            mac = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException unused2) {
            mac = null;
        }
        mac.init(new SecretKeySpec(str3.getBytes(), mac.getAlgorithm()));
        String trim = Base64.encodeToString(mac.doFinal(bytes), 0).trim();
        try {
            trim = URLEncoder.encode(trim, "UTF-8");
        } catch (UnsupportedEncodingException unused3) {
        }
        return "SharedAccessSignature sr=" + str + "&sig=" + trim + "&se=" + timeInMillis + "&skn=" + str2;
    }

    private String getUserAgent() {
        return String.format("NOTIFICATIONHUBS/%s (api-origin=%s; os=%s; os_version=%s;)", "2014-09", PnsSpecificRegistrationFactory.getInstance().getAPIOrigin(), "Android", Build.VERSION.RELEASE);
    }
}
