package tech.gusavila92.apache.http.io;

import tech.gusavila92.apache.http.HttpMessage;
import tech.gusavila92.apache.http.config.MessageConstraints;

/* loaded from: classes2.dex */
public interface HttpMessageParserFactory<T extends HttpMessage> {
    HttpMessageParser<T> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints);
}
