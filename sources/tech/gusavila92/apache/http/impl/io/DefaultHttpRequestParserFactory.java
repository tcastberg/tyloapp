package tech.gusavila92.apache.http.impl.io;

import tech.gusavila92.apache.http.HttpRequest;
import tech.gusavila92.apache.http.HttpRequestFactory;
import tech.gusavila92.apache.http.config.MessageConstraints;
import tech.gusavila92.apache.http.impl.DefaultHttpRequestFactory;
import tech.gusavila92.apache.http.io.HttpMessageParser;
import tech.gusavila92.apache.http.io.HttpMessageParserFactory;
import tech.gusavila92.apache.http.io.SessionInputBuffer;
import tech.gusavila92.apache.http.message.BasicLineParser;
import tech.gusavila92.apache.http.message.LineParser;

/* loaded from: classes2.dex */
public class DefaultHttpRequestParserFactory implements HttpMessageParserFactory<HttpRequest> {
    public static final DefaultHttpRequestParserFactory INSTANCE = new DefaultHttpRequestParserFactory();
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;

    public DefaultHttpRequestParserFactory(LineParser lineParser, HttpRequestFactory httpRequestFactory) {
        this.lineParser = lineParser == null ? BasicLineParser.INSTANCE : lineParser;
        this.requestFactory = httpRequestFactory == null ? DefaultHttpRequestFactory.INSTANCE : httpRequestFactory;
    }

    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }

    @Override // tech.gusavila92.apache.http.io.HttpMessageParserFactory
    public HttpMessageParser<HttpRequest> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpRequestParser(sessionInputBuffer, this.lineParser, this.requestFactory, messageConstraints);
    }
}
