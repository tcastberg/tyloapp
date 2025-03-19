package tech.gusavila92.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class InputStreamEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    @Override // tech.gusavila92.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    public InputStreamEntity(InputStream inputStream) {
        this(inputStream, -1L);
    }

    public InputStreamEntity(InputStream inputStream, long j) {
        this(inputStream, j, null);
    }

    public InputStreamEntity(InputStream inputStream, ContentType contentType) {
        this(inputStream, -1L, contentType);
    }

    public InputStreamEntity(InputStream inputStream, long j, ContentType contentType) {
        this.content = (InputStream) Args.notNull(inputStream, "Source input stream");
        this.length = j;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        return this.content;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        int read;
        Args.notNull(outputStream, "Output stream");
        InputStream inputStream = this.content;
        try {
            byte[] bArr = new byte[4096];
            long j = this.length;
            if (j < 0) {
                while (true) {
                    int read2 = inputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, read2);
                    }
                }
            } else {
                while (j > 0 && (read = inputStream.read(bArr, 0, (int) Math.min(4096L, j))) != -1) {
                    outputStream.write(bArr, 0, read);
                    j -= read;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
