package tech.gusavila92.apache.http.impl;

import tech.gusavila92.apache.http.ConnectionReuseStrategy;
import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public class NoConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final NoConnectionReuseStrategy INSTANCE = new NoConnectionReuseStrategy();

    @Override // tech.gusavila92.apache.http.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        return false;
    }
}
