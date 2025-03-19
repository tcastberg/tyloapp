package tech.gusavila92.apache.http.message;

import tech.gusavila92.apache.http.Header;
import tech.gusavila92.apache.http.ParseException;
import tech.gusavila92.apache.http.ProtocolVersion;
import tech.gusavila92.apache.http.RequestLine;
import tech.gusavila92.apache.http.StatusLine;
import tech.gusavila92.apache.http.util.CharArrayBuffer;

/* loaded from: classes2.dex */
public interface LineParser {
    boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException;

    ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;
}
