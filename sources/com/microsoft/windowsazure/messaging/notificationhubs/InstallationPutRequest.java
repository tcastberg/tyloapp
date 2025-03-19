package com.microsoft.windowsazure.messaging.notificationhubs;

import android.os.Build;
import android.util.Base64;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.microsoft.windowsazure.messaging.notificationhubs.InstallationAdapter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tech.gusavila92.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
class InstallationPutRequest extends JsonObjectRequest {
    private static final String API_VERSION = "2020-06";
    private static final long TOKEN_EXPIRE_SECONDS = 300;
    private static final DateFormat sIso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.ENGLISH);
    private final ConnectionString mConnectionString;

    public InstallationPutRequest(ConnectionString connectionString, String str, Installation installation, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(2, getInstallationUrl(connectionString.getEndpoint(), str, installation.getInstallationId()), getBody(installation), listener, errorListener);
        this.mConnectionString = connectionString;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        try {
            return new HashMap<String, String>() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.InstallationPutRequest.1
                {
                    put("Content-Type", "application/json");
                    put("x-ms-version", InstallationPutRequest.API_VERSION);
                    put(HttpHeaders.AUTHORIZATION, InstallationPutRequest.generateAuthToken(InstallationPutRequest.super.getUrl(), InstallationPutRequest.this.mConnectionString.getSharedAccessKeyName(), InstallationPutRequest.this.mConnectionString.getSharedAccessKey()));
                    put("User-Agent", InstallationPutRequest.getUserAgent());
                }
            };
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.android.volley.toolbox.JsonObjectRequest, com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        if (networkResponse.statusCode == 200) {
            return Response.success(new JSONObject(), HttpHeaderParser.parseCacheHeaders(networkResponse));
        }
        return super.parseNetworkResponse(networkResponse);
    }

    public static JSONObject getBody(Installation installation) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = installation.getTags().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, InstallationTemplate> entry : installation.getTemplates().entrySet()) {
                String key = entry.getKey();
                jSONObject.put(key, InstallationTemplate.serialize(key, entry.getValue()));
            }
            JSONObject jSONObject2 = new JSONObject(jSONArray, jSONObject) { // from class: com.microsoft.windowsazure.messaging.notificationhubs.InstallationPutRequest.2
                final /* synthetic */ JSONObject val$serializedTemplates;
                final /* synthetic */ JSONArray val$tagList;

                {
                    this.val$tagList = jSONArray;
                    this.val$serializedTemplates = jSONObject;
                    put("installationId", Installation.this.getInstallationId());
                    put("platform", Installation.this.getPlatform());
                    put("pushChannel", Installation.this.getPushChannel());
                    put("tags", jSONArray);
                    put("templates", jSONObject);
                    put("userId", Installation.this.getUserId());
                }
            };
            Date expiration = installation.getExpiration();
            if (expiration != null) {
                jSONObject2.put("expirationTime", sIso8601Format.format(expiration));
            }
            return jSONObject2;
        } catch (JSONException e) {
            throw new UnsupportedOperationException("", e);
        }
    }

    public static <T> Response.Listener<T> wrapListener(final InstallationAdapter.Listener listener, final Installation installation) {
        return new Response.Listener<T>() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.InstallationPutRequest.3
            @Override // com.android.volley.Response.Listener
            public void onResponse(T t) {
                InstallationAdapter.Listener.this.onInstallationSaved(installation);
            }
        };
    }

    public static Response.ErrorListener wrapErrorListener(final InstallationAdapter.ErrorListener errorListener) {
        return new Response.ErrorListener() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.InstallationPutRequest.4
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                InstallationAdapter.ErrorListener.this.onInstallationSaveError(volleyError);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getUserAgent() {
        return String.format("NOTIFICATIONHUBS/%s (api-origin=%s; os=%s; os_version=%s;)", API_VERSION, "AndroidSdkV1FcmV2.0.0-preview", "Android", Build.VERSION.RELEASE);
    }

    static String getInstallationUrl(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("https://");
        if (str.startsWith("sb://")) {
            str = str.substring(5);
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        sb.append(str).append("/").append(str2).append("/installations/").append(str3).append("?api-version=2020-06");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateAuthToken(String str, String str2, String str3) throws InvalidKeyException {
        Mac mac;
        try {
            str = URLEncoder.encode(str, "UTF-8").toLowerCase(Locale.ENGLISH);
        } catch (UnsupportedEncodingException unused) {
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + TOKEN_EXPIRE_SECONDS;
        byte[] bytes = (str + '\n' + currentTimeMillis).getBytes();
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
        return "SharedAccessSignature sr=" + str + "&sig=" + trim + "&se=" + currentTimeMillis + "&skn=" + str2;
    }
}
