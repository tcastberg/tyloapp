package com.tylohelo.tylohelo;

import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tylohelo.tylohelo.CloudService;
import com.tylohelo.tylohelo.protobuf.Message;
import com.tylohelo.tylohelo.protobuf.UserMessage;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import tech.gusavila92.websocketclient.WebSocketClient;

/* loaded from: classes2.dex */
public class ComService {
    FragmentActivity activity;
    private WebSocketClient webSocketClient;

    public ComService(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    public void connect(String str) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(this.activity);
            tyloApplication.setSaunaService(saunaService);
        }
        final SaunaModel saunaStored = saunaService.getSaunaStored(str);
        saunaService.setCurrentSaunaId(str);
        CloudService cloudService = tyloApplication.getCloudService();
        if (cloudService == null) {
            cloudService = new CloudService(this.activity);
            tyloApplication.setCloudService(cloudService);
        }
        if (!saunaService.getCloudEnabled() || saunaStored == null || saunaStored.getAPIKey() == null) {
            return;
        }
        cloudService.getSystemInfo(new CloudService.VolleyResponseListenerInfo() { // from class: com.tylohelo.tylohelo.ComService.1
            @Override // com.tylohelo.tylohelo.CloudService.VolleyResponseListenerInfo
            public void onError(String str2) {
                Log.e("Error in ComService:", str2);
            }

            @Override // com.tylohelo.tylohelo.CloudService.VolleyResponseListenerInfo
            public void onResponse(JSONObject jSONObject) throws JSONException {
                Log.i("Get system info", "Get info success");
                saunaStored.setRcbProduct(Integer.parseInt(jSONObject.getString("rcbProduct")) + 30);
                saunaStored.setSystemName(jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
                saunaStored.setSystemId(jSONObject.getString("id"));
                saunaStored.setSystemType(Integer.parseInt(jSONObject.getString("systemType")) + 20);
                saunaStored.setApplicationDescription(jSONObject.getString("applicationDescription"));
                saunaStored.setAvailable(false);
                SaunaService saunaService2 = tyloApplication.getSaunaService();
                if (saunaService2 == null) {
                    saunaService2 = new SaunaService(ComService.this.activity);
                    tyloApplication.setSaunaService(saunaService2);
                }
                saunaService2.storeSauna(saunaStored);
            }
        }, saunaStored.getAPIKey());
        createWebSocketClient(saunaStored);
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(this.activity);
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendCharTableRequest();
        messageToSaunaSystem.sendHumidityTableRequest();
        messageToSaunaSystem.sendTemperatureTableRequest();
    }

    public void createWebSocketClient(final SaunaModel saunaModel) {
        URI uri;
        if (tyloApplication.getSaunaService() == null) {
            tyloApplication.setSaunaService(new SaunaService(this.activity));
        }
        final SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this.activity).get(SharedViewModel.class);
        try {
            if (CloudService.isDebug()) {
                uri = new URI(CloudService.URL_WEBSOCKET_DEV);
            } else {
                uri = new URI(CloudService.URL_WEBSOCKET);
            }
            WebSocketClient webSocketClient = new WebSocketClient(uri) { // from class: com.tylohelo.tylohelo.ComService.2
                @Override // tech.gusavila92.websocketclient.WebSocketClient
                public void onBinaryReceived(byte[] bArr) {
                }

                @Override // tech.gusavila92.websocketclient.WebSocketClient
                public void onPingReceived(byte[] bArr) {
                }

                @Override // tech.gusavila92.websocketclient.WebSocketClient
                public void onPongReceived(byte[] bArr) {
                }

                @Override // tech.gusavila92.websocketclient.WebSocketClient
                public void onOpen() {
                    SaunaModel saunaModel2 = saunaModel;
                    if (saunaModel2 != null) {
                        ComService.this.webSocketClient.send(saunaModel2.getAPIKey());
                    }
                }

                @Override // tech.gusavila92.websocketclient.WebSocketClient
                public void onTextReceived(String str) {
                    System.out.println("Message: " + str);
                    if (Objects.equals(str, "ACCEPTED")) {
                        Log.i("Websocket: ", "Websocket connection accepted.");
                        return;
                    }
                    if (Objects.equals(str, "REJECTED")) {
                        saunaModel.setConnected(false);
                        SaunaService saunaService = tyloApplication.getSaunaService();
                        if (saunaService == null) {
                            saunaService = new SaunaService(ComService.this.activity);
                            tyloApplication.setSaunaService(saunaService);
                        }
                        saunaModel.setAPIKey(null);
                        saunaService.storeSauna(saunaModel);
                        sharedViewModel.setIsSaunaUpdated(true);
                        sharedViewModel.setCloudOnline(false);
                        sharedViewModel.setUserMessageLocal(UserMessageService.buildUserMsg(UserMessage.User_message.message_type_t.TYPE_OK, "This device is no longer trusted. Re-connect at the Control panel!"));
                        return;
                    }
                    SaunaService saunaService2 = tyloApplication.getSaunaService();
                    if (saunaService2 == null) {
                        saunaService2 = new SaunaService(ComService.this.activity);
                        tyloApplication.setSaunaService(saunaService2);
                    }
                    if (saunaService2.getCloudEnabled()) {
                        saunaModel.setConnected(true);
                        saunaService2.storeSauna(saunaModel);
                        sharedViewModel.setCloudOnline(true);
                        sharedViewModel.setWifiOnline(false);
                        sharedViewModel.setIsSaunaUpdated(true);
                        ComService.this.decodeMessage(str, sharedViewModel);
                        return;
                    }
                    saunaModel.setConnected(false);
                    saunaService2.storeSauna(saunaModel);
                    sharedViewModel.setIsSaunaUpdated(true);
                    sharedViewModel.setCloudOnline(false);
                    ComService.this.webSocketClient.close();
                }

                @Override // tech.gusavila92.websocketclient.WebSocketClient
                public void onException(Exception exc) {
                    if (exc != null && exc.getMessage() != null) {
                        Log.e("WebSocket Exception: ", exc.getMessage());
                    }
                    saunaModel.setConnected(false);
                    SaunaService saunaService = tyloApplication.getSaunaService();
                    if (saunaService == null) {
                        saunaService = new SaunaService(ComService.this.activity);
                        tyloApplication.setSaunaService(saunaService);
                    }
                    saunaService.storeSauna(saunaModel);
                    sharedViewModel.setIsSaunaUpdated(true);
                    sharedViewModel.setCloudOnline(false);
                }

                @Override // tech.gusavila92.websocketclient.WebSocketClient
                public void onCloseReceived() {
                    Log.i("WebSocket Info: ", "Connection closed.");
                    saunaModel.setConnected(false);
                    SaunaService saunaService = tyloApplication.getSaunaService();
                    if (saunaService == null) {
                        saunaService = new SaunaService(ComService.this.activity);
                        tyloApplication.setSaunaService(saunaService);
                    }
                    saunaService.storeSauna(saunaModel);
                    sharedViewModel.setIsSaunaUpdated(true);
                    sharedViewModel.setCloudOnline(false);
                }
            };
            this.webSocketClient = webSocketClient;
            webSocketClient.setConnectTimeout(16000);
            this.webSocketClient.setReadTimeout(15000);
            this.webSocketClient.enableAutomaticReconnection(5000L);
            this.webSocketClient.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        WebSocketClient webSocketClient = this.webSocketClient;
        if (webSocketClient != null) {
            webSocketClient.close();
        }
    }

    public void decodeMessage(String str, SharedViewModel sharedViewModel) {
        Message.Sauna_to_external sauna_to_external;
        try {
            sauna_to_external = Message.Sauna_to_external.parseFrom(Base64.getDecoder().decode(str.replace('-', '+').replace('_', JsonPointer.SEPARATOR)));
        } catch (InvalidProtocolBufferException unused) {
            Log.e("Exception", "Error parsing sauna message. ");
            sauna_to_external = null;
        }
        new MessageService(this.activity.getApplicationContext(), this.activity).handle(sauna_to_external, sharedViewModel);
    }
}
