package tech.gusavila92.apache.http.impl;

import tech.gusavila92.apache.http.ConnectionReuseStrategy;
import tech.gusavila92.apache.http.HeaderIterator;
import tech.gusavila92.apache.http.HttpRequest;
import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.TokenIterator;
import tech.gusavila92.apache.http.message.BasicTokenIterator;

/* loaded from: classes2.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    /* JADX WARN: Code restructure failed: missing block: B:43:0x006a, code lost:
    
        if (java.lang.Integer.parseInt(r6[0].getValue()) < 0) goto L22;
     */
    @Override // tech.gusavila92.apache.http.ConnectionReuseStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean keepAlive(tech.gusavila92.apache.http.HttpResponse r7, tech.gusavila92.apache.http.protocol.HttpContext r8) {
        /*
            r6 = this;
            java.lang.String r0 = "HTTP response"
            tech.gusavila92.apache.http.util.Args.notNull(r7, r0)
            java.lang.String r0 = "HTTP context"
            tech.gusavila92.apache.http.util.Args.notNull(r8, r0)
            java.lang.String r0 = "http.request"
            java.lang.Object r8 = r8.getAttribute(r0)
            tech.gusavila92.apache.http.HttpRequest r8 = (tech.gusavila92.apache.http.HttpRequest) r8
            java.lang.String r0 = "Close"
            java.lang.String r1 = "Connection"
            r2 = 0
            if (r8 == 0) goto L33
            tech.gusavila92.apache.http.message.BasicTokenIterator r3 = new tech.gusavila92.apache.http.message.BasicTokenIterator     // Catch: tech.gusavila92.apache.http.ParseException -> L32
            tech.gusavila92.apache.http.HeaderIterator r4 = r8.headerIterator(r1)     // Catch: tech.gusavila92.apache.http.ParseException -> L32
            r3.<init>(r4)     // Catch: tech.gusavila92.apache.http.ParseException -> L32
        L22:
            boolean r4 = r3.hasNext()     // Catch: tech.gusavila92.apache.http.ParseException -> L32
            if (r4 == 0) goto L33
            java.lang.String r4 = r3.nextToken()     // Catch: tech.gusavila92.apache.http.ParseException -> L32
            boolean r4 = r0.equalsIgnoreCase(r4)     // Catch: tech.gusavila92.apache.http.ParseException -> L32
            if (r4 == 0) goto L22
        L32:
            return r2
        L33:
            tech.gusavila92.apache.http.StatusLine r3 = r7.getStatusLine()
            tech.gusavila92.apache.http.ProtocolVersion r3 = r3.getProtocolVersion()
            java.lang.String r4 = "Transfer-Encoding"
            tech.gusavila92.apache.http.Header r4 = r7.getFirstHeader(r4)
            r5 = 1
            if (r4 == 0) goto L51
            java.lang.String r6 = "chunked"
            java.lang.String r8 = r4.getValue()
            boolean r6 = r6.equalsIgnoreCase(r8)
            if (r6 != 0) goto L6d
            return r2
        L51:
            boolean r6 = r6.canResponseHaveBody(r8, r7)
            if (r6 == 0) goto L6d
            java.lang.String r6 = "Content-Length"
            tech.gusavila92.apache.http.Header[] r6 = r7.getHeaders(r6)
            int r8 = r6.length
            if (r8 != r5) goto L6c
            r6 = r6[r2]
            java.lang.String r6 = r6.getValue()     // Catch: java.lang.NumberFormatException -> L6c
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.NumberFormatException -> L6c
            if (r6 >= 0) goto L6d
        L6c:
            return r2
        L6d:
            tech.gusavila92.apache.http.HeaderIterator r6 = r7.headerIterator(r1)
            boolean r8 = r6.hasNext()
            if (r8 != 0) goto L7d
            java.lang.String r6 = "Proxy-Connection"
            tech.gusavila92.apache.http.HeaderIterator r6 = r7.headerIterator(r6)
        L7d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto La8
            tech.gusavila92.apache.http.message.BasicTokenIterator r7 = new tech.gusavila92.apache.http.message.BasicTokenIterator     // Catch: tech.gusavila92.apache.http.ParseException -> La7
            r7.<init>(r6)     // Catch: tech.gusavila92.apache.http.ParseException -> La7
            r6 = r2
        L89:
            boolean r8 = r7.hasNext()     // Catch: tech.gusavila92.apache.http.ParseException -> La7
            if (r8 == 0) goto La4
            java.lang.String r8 = r7.nextToken()     // Catch: tech.gusavila92.apache.http.ParseException -> La7
            boolean r1 = r0.equalsIgnoreCase(r8)     // Catch: tech.gusavila92.apache.http.ParseException -> La7
            if (r1 == 0) goto L9a
            return r2
        L9a:
            java.lang.String r1 = "Keep-Alive"
            boolean r8 = r1.equalsIgnoreCase(r8)     // Catch: tech.gusavila92.apache.http.ParseException -> La7
            if (r8 == 0) goto L89
            r6 = r5
            goto L89
        La4:
            if (r6 == 0) goto La8
            return r5
        La7:
            return r2
        La8:
            tech.gusavila92.apache.http.HttpVersion r6 = tech.gusavila92.apache.http.HttpVersion.HTTP_1_0
            boolean r6 = r3.lessEquals(r6)
            r6 = r6 ^ r5
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tech.gusavila92.apache.http.impl.DefaultConnectionReuseStrategy.keepAlive(tech.gusavila92.apache.http.HttpResponse, tech.gusavila92.apache.http.protocol.HttpContext):boolean");
    }

    protected TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        return ((httpRequest != null && httpRequest.getRequestLine().getMethod().equalsIgnoreCase("HEAD")) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }
}
