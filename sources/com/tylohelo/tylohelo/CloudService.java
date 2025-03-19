package com.tylohelo.tylohelo;

import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tylohelo.tylohelo.CloudService;
import com.tylohelo.tylohelo.tyloApplication;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tech.gusavila92.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public class CloudService {
    public static final int PRODUCT_CONSTANT = 30;
    public static final int SYSTEM_TYPE_CONSTANT = 20;
    public static final String URL_DIRECT_MESSAGES = "https://remote.tylohelo.com/api/directmessages";
    public static final String URL_DIRECT_MESSAGES_DEV = "https://api-th-cab-dev.azurewebsites.net/api/directmessages";
    public static final String URL_REQUEST_TOKEN = "https://remote.tylohelo.com/api/RequestToken";
    public static final String URL_REQUEST_TOKEN_DEV = "https://api-th-cab-dev.azurewebsites.net/api/RequestToken";
    public static final String URL_SYSTEM_INFO = "https://remote.tylohelo.com/api/SystemInfo";
    public static final String URL_SYSTEM_INFO_DEV = "https://api-th-cab-dev.azurewebsites.net/api/SystemInfo";
    public static final String URL_WEBSOCKET = "wss://remote.tylohelo.com/api/Socket";
    public static final String URL_WEBSOCKET_DEV = "wss://api-th-cab-dev.azurewebsites.net/api/Socket";
    public static boolean debug = false;
    public static SaunaModel saunaModel = new SaunaModel();
    FragmentActivity activity;
    CloudServiceSingleton serviceSingleton;

    public interface VolleyResponseListener {
        void onError(String str);

        void onResponse(String str);
    }

    public interface VolleyResponseListenerInfo {
        void onError(String str);

        void onResponse(JSONObject jSONObject) throws JSONException;
    }

    public CloudService(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
        this.serviceSingleton = new CloudServiceSingleton(fragmentActivity.getApplicationContext());
    }

    public static boolean isDebug() {
        return debug;
    }

    public void getRequestToken(String str, String str2, final VolleyResponseListener volleyResponseListener) {
        String str3;
        if (isDebug()) {
            str3 = "https://api-th-cab-dev.azurewebsites.net/api/RequestToken?code=" + str + "&deviceName=" + str2;
        } else {
            str3 = "https://remote.tylohelo.com/api/RequestToken?code=" + str + "&deviceName=Android";
        }
        StringRequest stringRequest = new StringRequest(0, str3, new Response.Listener() { // from class: com.tylohelo.tylohelo.CloudService$$ExternalSyntheticLambda0
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                CloudService.this.m238lambda$getRequestToken$0$comtylohelotyloheloCloudService(volleyResponseListener, (String) obj);
            }
        }, new Response.ErrorListener() { // from class: com.tylohelo.tylohelo.CloudService$$ExternalSyntheticLambda1
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                CloudService.VolleyResponseListener.this.onError("QRCode invalid, try again!");
            }
        });
        CloudServiceSingleton cloudServiceSingleton = this.serviceSingleton;
        if (cloudServiceSingleton != null) {
            cloudServiceSingleton.getInstance(this.activity.getApplicationContext()).addToRequestQueue(stringRequest);
        }
    }

    /* renamed from: lambda$getRequestToken$0$com-tylohelo-tylohelo-CloudService, reason: not valid java name */
    /* synthetic */ void m238lambda$getRequestToken$0$comtylohelotyloheloCloudService(VolleyResponseListener volleyResponseListener, String str) {
        String formatTokenString = formatTokenString(str);
        if (formatTokenString != null) {
            saunaModel.setAPIKey(formatTokenString);
        }
        volleyResponseListener.onResponse(str);
    }

    public void getSystemInfo(final VolleyResponseListenerInfo volleyResponseListenerInfo, final String str) {
        String str2;
        if (isDebug()) {
            str2 = URL_SYSTEM_INFO_DEV;
        } else {
            str2 = URL_SYSTEM_INFO;
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(0, str2, null, new Response.Listener() { // from class: com.tylohelo.tylohelo.CloudService$$ExternalSyntheticLambda4
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                CloudService.this.m239lambda$getSystemInfo$2$comtylohelotyloheloCloudService(str, volleyResponseListenerInfo, (JSONObject) obj);
            }
        }, new Response.ErrorListener() { // from class: com.tylohelo.tylohelo.CloudService$$ExternalSyntheticLambda5
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                CloudService.lambda$getSystemInfo$3(CloudService.VolleyResponseListenerInfo.this, volleyError);
            }
        }) { // from class: com.tylohelo.tylohelo.CloudService.1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap hashMap = new HashMap();
                hashMap.put(HttpHeaders.AUTHORIZATION, "Bearer " + str);
                return hashMap;
            }
        };
        CloudServiceSingleton cloudServiceSingleton = this.serviceSingleton;
        if (cloudServiceSingleton != null) {
            cloudServiceSingleton.getInstance(this.activity.getApplicationContext()).addToRequestQueue(jsonObjectRequest);
        }
    }

    /* renamed from: lambda$getSystemInfo$2$com-tylohelo-tylohelo-CloudService, reason: not valid java name */
    /* synthetic */ void m239lambda$getSystemInfo$2$comtylohelotyloheloCloudService(String str, VolleyResponseListenerInfo volleyResponseListenerInfo, JSONObject jSONObject) {
        try {
            int parseInt = Integer.parseInt(jSONObject.getString("rcbProduct")) + 30;
            saunaModel.setRcbProduct(parseInt);
            tyloApplication.setProductType(parseInt);
            tyloApplication.setNetworkType(tyloApplication.networkType_t.NETWORK_CLOUD);
            saunaModel.setSystemName(jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
            saunaModel.setSystemId(jSONObject.getString("id"));
            int parseInt2 = Integer.parseInt(jSONObject.getString("systemType")) + 20;
            saunaModel.setSystemType(parseInt2);
            tyloApplication.setSystemType(parseInt2);
            saunaModel.setApplicationDescription(jSONObject.getString("applicationDescription"));
            saunaModel.setAPIKey(str);
            saunaModel.setAvailable(false);
            if (saunaModel != null) {
                SaunaService saunaService = tyloApplication.getSaunaService();
                if (saunaService == null) {
                    saunaService = new SaunaService(this.activity);
                    tyloApplication.setSaunaService(saunaService);
                }
                saunaService.storeSauna(saunaModel);
            }
            volleyResponseListenerInfo.onResponse(jSONObject);
        } catch (JSONException e) {
            if (e.getMessage() != null) {
                Log.e("Exception", e.getMessage());
            }
        }
    }

    static /* synthetic */ void lambda$getSystemInfo$3(VolleyResponseListenerInfo volleyResponseListenerInfo, VolleyError volleyError) {
        if (volleyError != null && volleyError.networkResponse != null) {
            Log.e("Error", "Error getting system info " + volleyError.networkResponse.statusCode);
        }
        volleyResponseListenerInfo.onError("Error getting system info");
    }

    public String formatTokenString(String str) {
        byte[] bytes = str.getBytes();
        byte[] copyOf = Arrays.copyOf(bytes, bytes.length - 1);
        return new String(Arrays.copyOfRange(copyOf, 1, copyOf.length), StandardCharsets.UTF_8);
    }

    public void sendPacket(byte[] bArr) {
        String str;
        String replace = Base64.getEncoder().encodeToString(bArr).replace('+', '-').replace(JsonPointer.SEPARATOR, '_');
        if (isDebug()) {
            str = "https://api-th-cab-dev.azurewebsites.net/api/directmessages?base64encodedMessage=" + replace;
        } else {
            str = "https://remote.tylohelo.com/api/directmessages?base64encodedMessage=" + replace;
        }
        String str2 = str;
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(this.activity);
            tyloApplication.setSaunaService(saunaService);
        }
        String currentSaunaId = saunaService.getCurrentSaunaId();
        SaunaModel saunaStored = currentSaunaId != null ? saunaService.getSaunaStored(currentSaunaId) : null;
        if (saunaStored != null) {
            final String aPIKey = saunaStored.getAPIKey();
            StringRequest stringRequest = new StringRequest(1, str2, new Response.Listener() { // from class: com.tylohelo.tylohelo.CloudService$$ExternalSyntheticLambda2
                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    System.out.println("Post data success");
                }
            }, new Response.ErrorListener() { // from class: com.tylohelo.tylohelo.CloudService$$ExternalSyntheticLambda3
                @Override // com.android.volley.Response.ErrorListener
                public final void onErrorResponse(VolleyError volleyError) {
                    CloudService.this.m240lambda$sendPacket$5$comtylohelotyloheloCloudService(volleyError);
                }
            }) { // from class: com.tylohelo.tylohelo.CloudService.2
                @Override // com.android.volley.Request
                public Map<String, String> getHeaders() {
                    HashMap hashMap = new HashMap();
                    hashMap.put(HttpHeaders.AUTHORIZATION, "Bearer " + aPIKey);
                    return hashMap;
                }
            };
            CloudServiceSingleton cloudServiceSingleton = this.serviceSingleton;
            if (cloudServiceSingleton != null) {
                cloudServiceSingleton.getInstance(this.activity.getApplicationContext()).addToRequestQueue(stringRequest);
            }
        }
    }

    /* renamed from: lambda$sendPacket$5$com-tylohelo-tylohelo-CloudService, reason: not valid java name */
    /* synthetic */ void m240lambda$sendPacket$5$comtylohelotyloheloCloudService(VolleyError volleyError) {
        Toast.makeText(this.activity.getApplicationContext(), "Fail to get response from cloud. Check internet connection.", 0).show();
        if (volleyError == null || volleyError.getMessage() == null) {
            return;
        }
        Log.e("Error in sendPacket", volleyError.getMessage());
    }
}
