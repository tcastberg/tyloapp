package tech.gusavila92.apache.http.impl.io;

import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.HttpResponseFactory;
import tech.gusavila92.apache.http.config.MessageConstraints;
import tech.gusavila92.apache.http.impl.DefaultHttpResponseFactory;
import tech.gusavila92.apache.http.io.HttpMessageParser;
import tech.gusavila92.apache.http.io.HttpMessageParserFactory;
import tech.gusavila92.apache.http.io.SessionInputBuffer;
import tech.gusavila92.apache.http.message.BasicLineParser;
import tech.gusavila92.apache.http.message.LineParser;

/* loaded from: classes2.dex */
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    public DefaultHttpResponseParserFactory(LineParser lineParser, HttpResponseFactory httpResponseFactory) {
        this.lineParser = lineParser == null ? BasicLineParser.INSTANCE : lineParser;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
    }

    public DefaultHttpResponseParserFactory() {
        this(null, null);
    }

    @Override // tech.gusavila92.apache.http.io.HttpMessageParserFactory
    public HttpMessageParser<HttpResponse> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpResponseParser(sessionInputBuffer, this.lineParser, this.responseFactory, messageConstraints);
    }
}
