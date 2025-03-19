package com.tylohelo.tylohelo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tylohelo.tylohelo.protobuf.Connect;
import com.tylohelo.tylohelo.protobuf.Message;
import com.tylohelo.tylohelo.protobuf.UserMessage;
import com.tylohelo.tylohelo.tyloApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public class WifiService {
    private static final int KEEP_ALIVE_PERIOD = 5;
    private static final long MILLI_SEC = 1000;
    private static final String SAUNA_PIN_DEFAULT = "0000";
    private static final int SAUNA_RECONNECTION_DELAY = 1500;
    private static Handler keepAliveHandler;
    private static int keepAliveSeqNumber;
    private static long lastKeepAliveReply = System.currentTimeMillis();
    private static Runnable runnable;
    FragmentActivity activity;

    static /* synthetic */ int access$008() {
        int i = keepAliveSeqNumber;
        keepAliveSeqNumber = i + 1;
        return i;
    }

    public WifiService(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    public void handleAnnouncementMsg(Connect.Announcement announcement, String str, SharedViewModel sharedViewModel) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(this.activity);
            tyloApplication.setSaunaService(saunaService);
        }
        int length = announcement.getSystemId().length();
        if (length > 0) {
            String substring = announcement.getSystemId().substring(1, length - 1);
            Log.d("WifiService", "Announcement msg received " + substring);
            SaunaModel saunaStored = saunaService.getSaunaStored(substring);
            if (saunaStored == null) {
                saunaStored = new SaunaModel();
            } else {
                String currentSaunaId = saunaService.getCurrentSaunaId();
                if (currentSaunaId != null && substring.equals(currentSaunaId) && !saunaStored.isConnected()) {
                    connectWifi(substring);
                }
            }
            saunaStored.setIp(str);
            saunaStored.setPort(announcement.getPort());
            saunaStored.setRcbProduct(announcement.getRcbProduct().getNumber());
            saunaStored.setSystemId(substring);
            saunaStored.setSystemName(getMsgString(announcement.getSystemNameCount(), announcement.getSystemNameList()));
            saunaStored.setSystemType(announcement.getSystemType().getNumber());
            saunaStored.setAvailable(true);
            saunaStored.setLastMsgTime(System.currentTimeMillis());
            saunaService.storeSauna(saunaStored);
            sharedViewModel.setIsSaunaUpdated(true);
            sharedViewModel.setIsSaunaListUpdated(true);
        }
    }

    public static String getMsgString(int i, List<Integer> list) {
        StringBuilder sb = new StringBuilder(i);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb.append(Character.toChars(it.next().intValue()));
        }
        return String.valueOf(sb);
    }

    public void connectWifi(String str) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(this.activity);
            tyloApplication.setSaunaService(saunaService);
        }
        SaunaModel saunaStored = saunaService.getSaunaStored(str);
        if (saunaStored != null) {
            saunaService.setCurrentSaunaId(str);
            tyloApplication.setProductType(saunaStored.getRcbProduct());
            tyloApplication.setSystemType(saunaStored.getSystemType());
            tyloApplication.setNetworkType(tyloApplication.networkType_t.NETWORK_WIFI);
            byte[] createConnectionRequestMsg = createConnectionRequestMsg(saunaStored);
            String ip = saunaStored.getIp();
            int port = saunaStored.getPort();
            if (ip != null) {
                MulticastSocket.sendPacket(createConnectionRequestMsg, ip, port);
                new Timer().schedule(new TimerTask() { // from class: com.tylohelo.tylohelo.WifiService.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        SaunaModel saunaStored2;
                        SaunaService saunaService2 = tyloApplication.getSaunaService();
                        if (saunaService2 == null) {
                            saunaService2 = new SaunaService(WifiService.this.activity);
                            tyloApplication.setSaunaService(saunaService2);
                        }
                        String currentSaunaId = saunaService2.getCurrentSaunaId();
                        if (currentSaunaId == null || (saunaStored2 = saunaService2.getSaunaStored(currentSaunaId)) == null || saunaStored2.isConnected()) {
                            return;
                        }
                        if (tyloApplication.getConnectionReplyReceived()) {
                            Log.d("WifiService", "Received connection reply");
                        } else {
                            WifiService.this.connectWifi(currentSaunaId);
                        }
                    }
                }, 1500L);
            }
        }
    }

    private byte[] createConnectionRequestMsg(SaunaModel saunaModel) {
        Connect.Connect_request.Builder newBuilder = Connect.Connect_request.newBuilder();
        newBuilder.setProfile(Connect.Connection_types.profile_t.PROFILE_SMART_PHONE_APP);
        String pin = saunaModel.getPin();
        if (pin != null) {
            newBuilder.setPin(pin);
        } else {
            newBuilder.setPin(SAUNA_PIN_DEFAULT);
        }
        newBuilder.addAllApplicationDescription(UserMessageService.strToArr("Tylö remote control"));
        Connect.External_unit_features.Builder newBuilder2 = Connect.External_unit_features.newBuilder();
        newBuilder2.setConnectRejectDoorSwitch(true);
        newBuilder.setExternalUnitFeatures(newBuilder2.build());
        return Message.External_to_sauna.newBuilder().setConnectRequest(newBuilder.build()).build().toByteArray();
    }

    public Message.Sauna_to_external parseMsgReceived(byte[] bArr) {
        try {
            return Message.Sauna_to_external.parseFrom(bArr);
        } catch (InvalidProtocolBufferException unused) {
            Log.e("Exception", "Error parsing sauna message. ");
            return null;
        }
    }

    public void handleConnectionReply(Connect.Connect_reply connect_reply, SharedViewModel sharedViewModel) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(this.activity);
            tyloApplication.setSaunaService(saunaService);
        }
        SaunaService saunaService2 = saunaService;
        String substring = connect_reply.getSystemId().substring(1, connect_reply.getSystemId().length() - 1);
        SaunaModel saunaStored = saunaService2.getSaunaStored(substring);
        if (connect_reply.hasStatus()) {
            tyloApplication.setConnectionReplyReceived(true);
            if (connect_reply.getStatus().getNumber() != 10) {
                sharedViewModel.setWifiOnline(false);
                Log.d("MulticastSocketActivity", "Connection failed " + connect_reply.getStatus() + " " + connect_reply.getSystemId());
                handleConnectionFailed(connect_reply.getStatus().getNumber(), saunaService2, saunaStored);
                return;
            }
            if (saunaStored != null) {
                saunaStored.setSystemId(substring);
                int communicationTimeOut = connect_reply.getCommunicationTimeOut();
                int communicationLostTimeOut = connect_reply.getCommunicationLostTimeOut();
                saunaStored.setStatus(connect_reply.getStatus());
                saunaStored.setConnected(true);
                sharedViewModel.setWifiOnline(true);
                sharedViewModel.setCloudOnline(false);
                saunaStored.setApplicationDescription(getMsgString(connect_reply.getApplicationDescriptionCount(), connect_reply.getApplicationDescriptionList()));
                saunaStored.setApplicationVersion();
                saunaStored.setSystemType(connect_reply.getSystemType().getNumber());
                saunaStored.setAvailable(true);
                saunaStored.setLastMsgTime(System.currentTimeMillis());
                saunaService2.storeSauna(saunaStored);
                sharedViewModel.setIsSaunaUpdated(true);
                sharedViewModel.setIsSaunaListUpdated(true);
                MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
                if (messageToSaunaSystem == null) {
                    messageToSaunaSystem = new MessageToSaunaSystem(this.activity);
                    tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
                }
                lastKeepAliveReply = System.currentTimeMillis();
                startKeepAlive(communicationTimeOut, communicationLostTimeOut, substring, messageToSaunaSystem, saunaService2, sharedViewModel);
                messageToSaunaSystem.sendCharTableRequest();
                messageToSaunaSystem.sendHumidityTableRequest();
                messageToSaunaSystem.sendTemperatureTableRequest();
                return;
            }
            sharedViewModel.setWifiOnline(false);
        }
    }

    private void startKeepAlive(final int i, final int i2, final String str, final MessageToSaunaSystem messageToSaunaSystem, final SaunaService saunaService, final SharedViewModel sharedViewModel) {
        final String currentSaunaId = saunaService.getCurrentSaunaId();
        if (currentSaunaId == null || !currentSaunaId.equals(str) || saunaService.getSaunaStored(currentSaunaId) == null) {
            return;
        }
        keepAliveSeqNumber = 0;
        stopKeepAlive();
        keepAliveHandler = new Handler(Looper.getMainLooper());
        Runnable runnable2 = new Runnable() { // from class: com.tylohelo.tylohelo.WifiService.2
            @Override // java.lang.Runnable
            public void run() {
                String currentSaunaId2 = saunaService.getCurrentSaunaId();
                if (currentSaunaId2 == null || !currentSaunaId2.equals(str) || saunaService.getSaunaStored(currentSaunaId) == null) {
                    return;
                }
                WifiService.access$008();
                if (!saunaService.getCloudEnabled()) {
                    messageToSaunaSystem.sendKeepAlive(WifiService.keepAliveSeqNumber);
                } else {
                    WifiService.stopKeepAlive();
                }
                if (i == 0 || i2 == 0) {
                    return;
                }
                if ((System.currentTimeMillis() - WifiService.lastKeepAliveReply) / WifiService.MILLI_SEC > i2) {
                    tyloApplication.resetSaunaParams();
                    WifiService.this.disConnectAll(saunaService, sharedViewModel);
                    WifiService.stopKeepAlive();
                    WifiService.this.connectWifi(currentSaunaId2);
                    Log.d("WifiService", "Reconnect");
                }
                Log.d("WifiService", "Check keep alive communication.");
                WifiService.keepAliveHandler.postDelayed(this, (i - 5) * WifiService.MILLI_SEC);
            }
        };
        runnable = runnable2;
        keepAliveHandler.postDelayed(runnable2, (i - 5) * MILLI_SEC);
    }

    public void disConnectAll(SaunaService saunaService, SharedViewModel sharedViewModel) {
        final HashMap<String, SaunaModel> saunaListStored = saunaService.getSaunaListStored();
        if (saunaListStored != null) {
            saunaListStored.forEach(new BiConsumer() { // from class: com.tylohelo.tylohelo.WifiService$$ExternalSyntheticLambda3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    WifiService.lambda$disConnectAll$0(saunaListStored, (String) obj, (SaunaModel) obj2);
                }
            });
            sharedViewModel.setIsSaunaUpdated(true);
        }
    }

    static /* synthetic */ void lambda$disConnectAll$0(HashMap hashMap, String str, SaunaModel saunaModel) {
        Gson gson = new Gson();
        ((SaunaModel) gson.fromJson(gson.toJson(hashMap.get(str)), SaunaModel.class)).setConnected(false);
    }

    public static void stopKeepAlive() {
        Handler handler = keepAliveHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void handleKeepAliveReply() {
        lastKeepAliveReply = System.currentTimeMillis();
    }

    private void handleConnectionFailed(int i, final SaunaService saunaService, SaunaModel saunaModel) {
        String str;
        final SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this.activity).get(SharedViewModel.class);
        if (i == 20) {
            final MainActivity mainActivity = (MainActivity) this.activity;
            mainActivity.runOnUiThread(new Runnable() { // from class: com.tylohelo.tylohelo.WifiService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WifiService.this.m364x73a89efd(mainActivity, saunaService, sharedViewModel);
                }
            });
            sharedViewModel.setWifiOnline(false);
            str = "";
        } else if (i == 23) {
            sharedViewModel.setWifiOnline(false);
            str = "Connection failed, no door switch";
        } else {
            sharedViewModel.setWifiOnline(false);
            str = "Connection failed";
        }
        if (str.isEmpty()) {
            return;
        }
        UserMessage.User_message.Builder newBuilder = UserMessage.User_message.newBuilder();
        newBuilder.addAllFormattedPanelMessage(UserMessageService.strToArr(str));
        newBuilder.setMessageType(UserMessage.User_message.message_type_t.TYPE_OK);
        newBuilder.setIdentity(0);
        sharedViewModel.setUserMessage(newBuilder.build());
        saunaModel.setConnected(false);
        saunaService.storeSauna(saunaModel);
        sharedViewModel.setIsSaunaUpdated(true);
        sharedViewModel.setWifiOnline(false);
    }

    /* renamed from: showPinAlertBox, reason: merged with bridge method [inline-methods] */
    public void m364x73a89efd(Activity activity, final SaunaService saunaService, final SharedViewModel sharedViewModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("PIN code");
        builder.setCancelable(false);
        final EditText editText = new EditText(activity);
        editText.setInputType(129);
        builder.setView(editText);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.WifiService$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WifiService.this.m365lambda$showPinAlertBox$2$comtylohelotyloheloWifiService(editText, saunaService, sharedViewModel, dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.WifiService$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* renamed from: lambda$showPinAlertBox$2$com-tylohelo-tylohelo-WifiService, reason: not valid java name */
    /* synthetic */ void m365lambda$showPinAlertBox$2$comtylohelotyloheloWifiService(EditText editText, SaunaService saunaService, SharedViewModel sharedViewModel, DialogInterface dialogInterface, int i) {
        SaunaModel saunaStored;
        String obj = editText.getText().toString();
        String currentSaunaId = saunaService.getCurrentSaunaId();
        if (currentSaunaId == null || (saunaStored = saunaService.getSaunaStored(currentSaunaId)) == null) {
            return;
        }
        if (!obj.isEmpty()) {
            saunaStored.setPin(obj);
            saunaService.storeSauna(saunaStored);
            connectWifi(currentSaunaId);
        } else {
            saunaStored.setConnected(false);
            saunaService.storeSauna(saunaStored);
            sharedViewModel.setIsSaunaUpdated(true);
        }
    }
}
