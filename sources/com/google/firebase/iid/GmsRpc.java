package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.messaging.Constants;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import tech.gusavila92.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes2.dex */
public class GmsRpc {
    public static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    private final FirebaseApp app;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<HeartBeatInfo> heartbeatInfo;
    private final Metadata metadata;
    private final Rpc rpc;
    private final Provider<UserAgentPublisher> userAgentPublisher;

    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Rpc rpc, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.app = firebaseApp;
        this.metadata = metadata;
        this.rpc = rpc;
        this.userAgentPublisher = provider;
        this.heartbeatInfo = provider2;
        this.firebaseInstallations = firebaseInstallationsApi;
    }

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata, new Rpc(firebaseApp.getApplicationContext()), provider, provider2, firebaseInstallationsApi);
    }

    private static String base64UrlSafe(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> extractResponseWhenComplete(Task<Bundle> task) {
        return task.continueWith(FirebaseIidExecutors.directExecutor(), new Continuation(this) { // from class: com.google.firebase.iid.GmsRpc$$Lambda$0
            private final GmsRpc arg$1;

            {
                this.arg$1 = this;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                return this.arg$1.lambda$extractResponseWhenComplete$0$GmsRpc(task2);
            }
        });
    }

    private String getHashedFirebaseAppName() {
        try {
            return base64UrlSafe(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1).digest(this.app.getName().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String handleResponse(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        String valueOf = String.valueOf(bundle);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
        sb.append("Unexpected response: ");
        sb.append(valueOf);
        Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
        throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
    }

    static boolean isErrorMessageForRetryableError(String str) {
        return ERROR_SERVICE_NOT_AVAILABLE.equals(str) || ERROR_INTERNAL_SERVER_ERROR.equals(str) || "InternalServerError".equals(str);
    }

    private Bundle setDefaultAttributesToBundle(String str, String str2, String str3, Bundle bundle) {
        HeartBeatInfo.HeartBeat heartBeatCode;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.app.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.metadata.getGmsVersionCode()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.metadata.getAppVersionCode());
        bundle.putString("app_ver_name", this.metadata.getAppVersionName());
        bundle.putString("firebase-app-name-hash", getHashedFirebaseAppName());
        try {
            String token = ((InstallationTokenResult) Tasks.await(this.firebaseInstallations.getToken(false))).getToken();
            if (TextUtils.isEmpty(token)) {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", token);
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        bundle.putString("cliv", "fiid-21.1.0");
        HeartBeatInfo heartBeatInfo = this.heartbeatInfo.get();
        UserAgentPublisher userAgentPublisher = this.userAgentPublisher.get();
        if (heartBeatInfo != null && userAgentPublisher != null && (heartBeatCode = heartBeatInfo.getHeartBeatCode("fire-iid")) != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
            bundle.putString("Firebase-Client", userAgentPublisher.getUserAgent());
        }
        return bundle;
    }

    private Task<Bundle> startRpc(String str, String str2, String str3, Bundle bundle) {
        setDefaultAttributesToBundle(str, str2, str3, bundle);
        return this.rpc.send(bundle);
    }

    public Task<?> deleteInstanceId(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("iid-operation", "delete");
        bundle.putString("delete", "1");
        return extractResponseWhenComplete(startRpc(str, "*", "*", bundle));
    }

    public Task<?> deleteToken(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return extractResponseWhenComplete(startRpc(str, str2, str3, bundle));
    }

    public Task<String> getToken(String str, String str2, String str3) {
        return extractResponseWhenComplete(startRpc(str, str2, str3, new Bundle()));
    }

    final /* synthetic */ String lambda$extractResponseWhenComplete$0$GmsRpc(Task task) throws Exception {
        return handleResponse((Bundle) task.getResult(IOException.class));
    }

    public Task<?> subscribeToTopic(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return extractResponseWhenComplete(startRpc(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle));
    }

    public Task<?> unsubscribeFromTopic(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return extractResponseWhenComplete(startRpc(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle));
    }
}
