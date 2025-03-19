package tech.gusavila92.apache.http;

import tech.gusavila92.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext);
}
