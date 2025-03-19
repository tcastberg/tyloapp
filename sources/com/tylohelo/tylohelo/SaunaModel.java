package com.tylohelo.tylohelo;

import com.tylohelo.tylohelo.protobuf.Connect;

/* loaded from: classes2.dex */
public class SaunaModel {
    private String apikey;
    private String applicationDescription;
    private boolean available;
    private boolean connected;
    private String ip;
    private long lastMsgTime;
    private String pin;
    private int port;
    private int rcbProduct;
    private Connect.Connect_reply.connect_status_t status;
    private String systemId;
    private String systemName;
    private int systemType;

    public void setApplicationVersion() {
    }

    public int getRcbProduct() {
        return this.rcbProduct;
    }

    public void setRcbProduct(int i) {
        this.rcbProduct = i;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public void setSystemName(String str) {
        this.systemName = str;
    }

    public String getSystemId() {
        return this.systemId;
    }

    public void setSystemId(String str) {
        this.systemId = str;
    }

    public int getSystemType() {
        return this.systemType;
    }

    public void setSystemType(int i) {
        this.systemType = i;
    }

    public String getApplicationDescription() {
        return this.applicationDescription;
    }

    public void setApplicationDescription(String str) {
        this.applicationDescription = str;
    }

    public String getAPIKey() {
        return this.apikey;
    }

    public void setAPIKey(String str) {
        this.apikey = str;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void setConnected(boolean z) {
        this.connected = z;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean z) {
        this.available = z;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public void setLastMsgTime(long j) {
        this.lastMsgTime = j;
    }

    public Connect.Connect_reply.connect_status_t getStatus() {
        return this.status;
    }

    public void setStatus(Connect.Connect_reply.connect_status_t connect_status_tVar) {
        this.status = connect_status_tVar;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String str) {
        this.pin = str;
    }
}
