package tech.gusavila92.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class EntityTemplate extends AbstractHttpEntity {
    private final ContentProducer contentproducer;

    @Override // tech.gusavila92.apache.http.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    public EntityTemplate(ContentProducer contentProducer) {
        this.contentproducer = (ContentProducer) Args.notNull(contentProducer, "Content producer");
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // tech.gusavila92.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        this.contentproducer.writeTo(outputStream);
    }
}
