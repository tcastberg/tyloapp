package tech.gusavila92.apache.http;

/* loaded from: classes2.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
