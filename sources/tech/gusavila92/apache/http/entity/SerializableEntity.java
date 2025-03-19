package tech.gusavila92.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class SerializableEntity extends AbstractHttpEntity {
    private Serializable objRef;
    private byte[] objSer;

    @Override // tech.gusavila92.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    public SerializableEntity(Serializable serializable, boolean z) throws IOException {
        Args.notNull(serializable, "Source object");
        if (z) {
            createBytes(serializable);
        } else {
            this.objRef = serializable;
        }
    }

    public SerializableEntity(Serializable serializable) {
        Args.notNull(serializable, "Source object");
        this.objRef = serializable;
    }

    private void createBytes(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.flush();
        this.objSer = byteArrayOutputStream.toByteArray();
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public InputStream getContent() throws IOException, IllegalStateException {
        if (this.objSer == null) {
            createBytes(this.objRef);
        }
        return new ByteArrayInputStream(this.objSer);
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public long getContentLength() {
        if (this.objSer == null) {
            return -1L;
        }
        return r2.length;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.objSer == null;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        byte[] bArr = this.objSer;
        if (bArr == null) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this.objRef);
            objectOutputStream.flush();
        } else {
            outputStream.write(bArr);
            outputStream.flush();
        }
    }
}
