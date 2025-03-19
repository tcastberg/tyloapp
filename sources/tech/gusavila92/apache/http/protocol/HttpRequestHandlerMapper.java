package tech.gusavila92.apache.http.protocol;

import tech.gusavila92.apache.http.HttpRequest;

/* loaded from: classes2.dex */
public interface HttpRequestHandlerMapper {
    HttpRequestHandler lookup(HttpRequest httpRequest);
}
