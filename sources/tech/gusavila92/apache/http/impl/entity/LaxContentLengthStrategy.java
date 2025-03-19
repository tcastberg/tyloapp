package tech.gusavila92.apache.http.impl.entity;

import tech.gusavila92.apache.http.Header;
import tech.gusavila92.apache.http.HeaderElement;
import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpMessage;
import tech.gusavila92.apache.http.ParseException;
import tech.gusavila92.apache.http.ProtocolException;
import tech.gusavila92.apache.http.entity.ContentLengthStrategy;
import tech.gusavila92.apache.http.protocol.HTTP;
import tech.gusavila92.apache.http.util.Args;

/* loaded from: classes2.dex */
public class LaxContentLengthStrategy implements ContentLengthStrategy {
    public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
    private final int implicitLen;

    public LaxContentLengthStrategy(int i) {
        this.implicitLen = i;
    }

    public LaxContentLengthStrategy() {
        this(-1);
    }

    @Override // tech.gusavila92.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        long j;
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            try {
                HeaderElement[] elements = firstHeader.getElements();
                int length = elements.length;
                return (!HTTP.IDENTITY_CODING.equalsIgnoreCase(firstHeader.getValue()) && length > 0 && HTTP.CHUNK_CODING.equalsIgnoreCase(elements[length + (-1)].getName())) ? -2L : -1L;
            } catch (ParseException e) {
                throw new ProtocolException("Invalid Transfer-Encoding header value: " + firstHeader, e);
            }
        }
        if (httpMessage.getFirstHeader("Content-Length") != null) {
            Header[] headers = httpMessage.getHeaders("Content-Length");
            int length2 = headers.length - 1;
            while (true) {
                if (length2 < 0) {
                    j = -1;
                    break;
                }
                try {
                    j = Long.parseLong(headers[length2].getValue());
                    break;
                } catch (NumberFormatException unused) {
                    length2--;
                }
            }
            if (j >= 0) {
                return j;
            }
            return -1L;
        }
        return this.implicitLen;
    }
}
