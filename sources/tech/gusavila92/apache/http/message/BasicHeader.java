package tech.gusavila92.apache.http.message;

import java.io.Serializable;
import tech.gusavila92.apache.http.Header;
import tech.gusavila92.apache.http.HeaderElement;
import tech.gusavila92.apache.http.ParseException;
import tech.gusavila92.apache.http.util.Args;
import tech.gusavila92.apache.http.util.CharArrayBuffer;

/* loaded from: classes2.dex */
public class BasicHeader implements Header, Cloneable, Serializable {
    private static final long serialVersionUID = -5427236326487562174L;
    private final String name;
    private final String value;

    public BasicHeader(String str, String str2) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
    }

    @Override // tech.gusavila92.apache.http.Header
    public String getName() {
        return this.name;
    }

    @Override // tech.gusavila92.apache.http.Header
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatHeader((CharArrayBuffer) null, this).toString();
    }

    @Override // tech.gusavila92.apache.http.Header
    public HeaderElement[] getElements() throws ParseException {
        String str = this.value;
        if (str != null) {
            return BasicHeaderValueParser.parseElements(str, (HeaderValueParser) null);
        }
        return new HeaderElement[0];
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
