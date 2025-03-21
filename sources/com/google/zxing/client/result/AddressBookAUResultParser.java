package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import tech.gusavila92.apache.http.message.TokenParser;

/* loaded from: classes2.dex */
public final class AddressBookAUResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        if (!massagedText.contains("MEMORY") || !massagedText.contains("\r\n")) {
            return null;
        }
        String matchSinglePrefixedField = matchSinglePrefixedField("NAME1:", massagedText, TokenParser.CR, true);
        String matchSinglePrefixedField2 = matchSinglePrefixedField("NAME2:", massagedText, TokenParser.CR, true);
        String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", massagedText);
        String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", massagedText);
        String matchSinglePrefixedField3 = matchSinglePrefixedField("MEMORY:", massagedText, TokenParser.CR, false);
        String matchSinglePrefixedField4 = matchSinglePrefixedField("ADD:", massagedText, TokenParser.CR, true);
        return new AddressBookParsedResult(maybeWrap(matchSinglePrefixedField), null, matchSinglePrefixedField2, matchMultipleValuePrefix, null, matchMultipleValuePrefix2, null, null, matchSinglePrefixedField3, matchSinglePrefixedField4 != null ? new String[]{matchSinglePrefixedField4} : null, null, null, null, null, null, null);
    }

    private static String[] matchMultipleValuePrefix(String str, String str2) {
        String matchSinglePrefixedField;
        ArrayList arrayList = null;
        for (int i = 1; i <= 3 && (matchSinglePrefixedField = matchSinglePrefixedField(str + i + ':', str2, TokenParser.CR, true)) != null; i++) {
            if (arrayList == null) {
                arrayList = new ArrayList(3);
            }
            arrayList.add(matchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(EMPTY_STR_ARRAY);
    }
}
