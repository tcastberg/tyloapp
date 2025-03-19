package tech.gusavila92.apache.http.entity;

import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpMessage;

/* loaded from: classes2.dex */
public interface ContentLengthStrategy {
    public static final int CHUNKED = -2;
    public static final int IDENTITY = -1;

    long determineLength(HttpMessage httpMessage) throws HttpException;
}
