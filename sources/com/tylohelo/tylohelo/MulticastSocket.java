package com.tylohelo.tylohelo;

import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.tylohelo.tylohelo.protobuf.Connect;
import com.tylohelo.tylohelo.protobuf.Message;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class MulticastSocket {
    private static final String MULTICAST_GROUP_ADDRESS = "239.255.255.255";
    private static final int MULTICAST_GROUP_PORT = 54377;
    private static final int MULTICAST_GROUP_PORT_FALLBACK = 54378;
    public static java.net.MulticastSocket multicastSocket;
    public static java.net.MulticastSocket multicastSocketFallback;
    FragmentActivity activity;
    private String saunaId;

    public MulticastSocket(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    public static void sendPacket(final byte[] bArr, final String str, final int i) {
        new Thread(new Runnable() { // from class: com.tylohelo.tylohelo.MulticastSocket$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MulticastSocket.lambda$sendPacket$0(str, bArr, i);
            }
        }).start();
    }

    static /* synthetic */ void lambda$sendPacket$0(String str, byte[] bArr, int i) {
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByName(str.substring(1)), i);
            java.net.MulticastSocket multicastSocket2 = multicastSocket;
            if (multicastSocket2 != null) {
                multicastSocket2.send(datagramPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendAnnouncementRequest() {
        Connect.Announcement_request.Builder newBuilder = Connect.Announcement_request.newBuilder();
        newBuilder.setProfile(Connect.Connection_types.profile_t.PROFILE_SMART_PHONE_APP);
        sendPacketToFallbackPort(newBuilder.build().toByteArray());
    }

    public static void sendPacketToFallbackPort(final byte[] bArr) {
        new Thread(new Runnable() { // from class: com.tylohelo.tylohelo.MulticastSocket$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MulticastSocket.lambda$sendPacketToFallbackPort$1(bArr);
            }
        }).start();
    }

    static /* synthetic */ void lambda$sendPacketToFallbackPort$1(byte[] bArr) {
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByName(MULTICAST_GROUP_ADDRESS), MULTICAST_GROUP_PORT_FALLBACK);
            java.net.MulticastSocket multicastSocket2 = multicastSocketFallback;
            if (multicastSocket2 != null) {
                multicastSocket2.send(datagramPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendData(byte[] bArr, SaunaService saunaService) {
        SaunaModel saunaStored;
        String currentSaunaId = saunaService.getCurrentSaunaId();
        if (currentSaunaId == null || (saunaStored = saunaService.getSaunaStored(currentSaunaId)) == null) {
            return;
        }
        sendPacket(bArr, saunaStored.getIp(), saunaStored.getPort());
    }

    public void startMulticastListener(final SharedViewModel sharedViewModel) {
        new Thread(new Runnable() { // from class: com.tylohelo.tylohelo.MulticastSocket$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MulticastSocket.this.m316xac8f31f0(sharedViewModel);
            }
        }).start();
    }

    /* renamed from: lambda$startMulticastListener$2$com-tylohelo-tylohelo-MulticastSocket, reason: not valid java name */
    /* synthetic */ void m316xac8f31f0(SharedViewModel sharedViewModel) {
        SaunaModel saunaStored;
        Message.Sauna_to_external parseMsgReceived;
        try {
            InetAddress byName = InetAddress.getByName(MULTICAST_GROUP_ADDRESS);
            java.net.MulticastSocket multicastSocket2 = new java.net.MulticastSocket(MULTICAST_GROUP_PORT);
            multicastSocket = multicastSocket2;
            multicastSocket2.joinGroup(byName);
            WifiService wifiService = tyloApplication.getWifiService();
            if (wifiService == null) {
                wifiService = new WifiService(this.activity);
                tyloApplication.setWifiService(wifiService);
            }
            Log.d("MulticastSocket", "Multicast socket started. Listening for messages...");
            while (multicastSocket != null) {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[16384], 16384);
                java.net.MulticastSocket multicastSocket3 = multicastSocket;
                if (multicastSocket3 != null && !multicastSocket3.isClosed()) {
                    multicastSocket.receive(datagramPacket);
                    InetAddress address = datagramPacket.getAddress();
                    byte[] data = datagramPacket.getData();
                    int length = datagramPacket.getLength();
                    int port = datagramPacket.getPort();
                    SaunaService saunaService = tyloApplication.getSaunaService();
                    if (saunaService == null) {
                        saunaService = new SaunaService(this.activity);
                        tyloApplication.setSaunaService(saunaService);
                    }
                    if (!saunaService.getCloudEnabled()) {
                        try {
                            Connect.Announcement parseFrom = Connect.Announcement.parseFrom(Arrays.copyOf(data, length));
                            if (parseFrom != null) {
                                wifiService.handleAnnouncementMsg(parseFrom, address.toString(), sharedViewModel);
                            }
                        } catch (Exception unused) {
                            Log.d("MulticastSocket", "Not an announcement msg.");
                        }
                        String currentSaunaId = saunaService.getCurrentSaunaId();
                        if (currentSaunaId != null && (saunaStored = saunaService.getSaunaStored(currentSaunaId)) != null && port == saunaStored.getPort() && (parseMsgReceived = wifiService.parseMsgReceived(Arrays.copyOf(data, length))) != null) {
                            if (parseMsgReceived.hasConnectReply()) {
                                Connect.Connect_reply connectReply = parseMsgReceived.getConnectReply();
                                wifiService.handleConnectionReply(connectReply, sharedViewModel);
                                this.saunaId = parseMsgReceived.getConnectReply().getSystemId().substring(1, connectReply.getSystemId().length() - 1);
                                Log.d("MulticastSocket", "Connection reply received " + this.saunaId);
                            }
                            String str = this.saunaId;
                            if (str != null && str.equals(currentSaunaId)) {
                                if (parseMsgReceived.hasKeepAlive()) {
                                    wifiService.handleKeepAliveReply();
                                }
                                Log.d("MulticastSocket", "Received sauna message: " + parseMsgReceived);
                                new MessageService(this.activity.getApplicationContext(), this.activity).handle(parseMsgReceived, sharedViewModel);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startMulticastListenerOnFallbackPort(final SharedViewModel sharedViewModel) {
        new Thread(new Runnable() { // from class: com.tylohelo.tylohelo.MulticastSocket$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MulticastSocket.this.m317xd26e5113(sharedViewModel);
            }
        }).start();
    }

    /* renamed from: lambda$startMulticastListenerOnFallbackPort$3$com-tylohelo-tylohelo-MulticastSocket, reason: not valid java name */
    /* synthetic */ void m317xd26e5113(SharedViewModel sharedViewModel) {
        try {
            InetAddress byName = InetAddress.getByName(MULTICAST_GROUP_ADDRESS);
            java.net.MulticastSocket multicastSocket2 = new java.net.MulticastSocket(MULTICAST_GROUP_PORT_FALLBACK);
            multicastSocketFallback = multicastSocket2;
            multicastSocket2.joinGroup(byName);
            WifiService wifiService = tyloApplication.getWifiService();
            if (wifiService == null) {
                wifiService = new WifiService(this.activity);
                tyloApplication.setWifiService(wifiService);
            }
            Log.d("MulticastSocket", "Multicast socket on fallback port started. Listening for messages...");
            while (multicastSocketFallback != null) {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[16384], 16384);
                java.net.MulticastSocket multicastSocket3 = multicastSocketFallback;
                if (multicastSocket3 != null && !multicastSocket3.isClosed()) {
                    multicastSocketFallback.receive(datagramPacket);
                    InetAddress address = datagramPacket.getAddress();
                    byte[] data = datagramPacket.getData();
                    int length = datagramPacket.getLength();
                    SaunaService saunaService = tyloApplication.getSaunaService();
                    if (saunaService == null) {
                        saunaService = new SaunaService(this.activity);
                        tyloApplication.setSaunaService(saunaService);
                    }
                    if (!saunaService.getCloudEnabled()) {
                        try {
                            Connect.Announcement parseFrom = Connect.Announcement.parseFrom(Arrays.copyOf(data, length));
                            if (parseFrom != null) {
                                wifiService.handleAnnouncementMsg(parseFrom, address.toString(), sharedViewModel);
                            }
                        } catch (Exception unused) {
                            Log.d("MulticastSocket", "Not an announcement msg.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeMulticastSocket() {
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(InetAddress.getByName(MULTICAST_GROUP_ADDRESS));
                multicastSocket.close();
                multicastSocket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (multicastSocketFallback != null) {
            try {
                multicastSocketFallback.leaveGroup(InetAddress.getByName(MULTICAST_GROUP_ADDRESS));
                multicastSocketFallback.close();
                multicastSocketFallback = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
