package tech.gusavila92.websocketclient.model;

/* loaded from: classes2.dex */
public class Payload {
    private byte[] data;
    private int opcode;

    public Payload(int i, byte[] bArr) {
        this.opcode = i;
        this.data = bArr;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public byte[] getData() {
        return this.data;
    }
}
