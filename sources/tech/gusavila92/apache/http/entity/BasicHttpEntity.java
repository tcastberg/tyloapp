package tech.gusavila92.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tech.gusavila92.apache.http.impl.io.EmptyInputStream;
import tech.gusavila92.apache.http.util.Args;
import tech.gusavila92.apache.http.util.Asserts;

/* loaded from: classes2.dex */
public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length = -1;

    @Override // tech.gusavila92.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public InputStream getContent() throws IllegalStateException {
        Asserts.check(this.content != null, "Content has not been provided");
        return this.content;
    }

    public void setContentLength(long j) {
        this.length = j;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, read);
                }
            }
        } finally {
            content.close();
        }
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public boolean isStreaming() {
        InputStream inputStream = this.content;
        return (inputStream == null || inputStream == EmptyInputStream.INSTANCE) ? false : true;
    }
}
