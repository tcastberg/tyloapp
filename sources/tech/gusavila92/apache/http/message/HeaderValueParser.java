package tech.gusavila92.apache.http.message;

import tech.gusavila92.apache.http.HeaderElement;
import tech.gusavila92.apache.http.NameValuePair;
import tech.gusavila92.apache.http.ParseException;
import tech.gusavila92.apache.http.util.CharArrayBuffer;

/* loaded from: classes2.dex */
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;
}
