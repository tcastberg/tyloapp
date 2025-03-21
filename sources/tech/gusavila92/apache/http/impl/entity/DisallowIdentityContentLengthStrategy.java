package tech.gusavila92.apache.http.impl.entity;

import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpMessage;
import tech.gusavila92.apache.http.ProtocolException;
import tech.gusavila92.apache.http.entity.ContentLengthStrategy;

/* loaded from: classes2.dex */
public class DisallowIdentityContentLengthStrategy implements ContentLengthStrategy {
    public static final DisallowIdentityContentLengthStrategy INSTANCE = new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0));
    private final ContentLengthStrategy contentLengthStrategy;

    public DisallowIdentityContentLengthStrategy(ContentLengthStrategy contentLengthStrategy) {
        this.contentLengthStrategy = contentLengthStrategy;
    }

    @Override // tech.gusavila92.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        long determineLength = this.contentLengthStrategy.determineLength(httpMessage);
        if (determineLength != -1) {
            return determineLength;
        }
        throw new ProtocolException("Identity transfer encoding cannot be used");
    }
}
