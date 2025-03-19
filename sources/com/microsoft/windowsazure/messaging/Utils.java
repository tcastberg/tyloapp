package com.microsoft.windowsazure.messaging;

import java.io.ByteArrayOutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;

/* loaded from: classes2.dex */
class Utils {
    Utils() {
    }

    public static boolean isNullOrWhiteSpace(String str) {
        return str == null || str.trim().equals("");
    }

    public static String getXmlString(Element element) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StreamResult streamResult = new StreamResult(byteArrayOutputStream);
        DOMSource dOMSource = new DOMSource(element);
        Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
        newTransformer.setOutputProperty("omit-xml-declaration", "yes");
        newTransformer.transform(dOMSource, streamResult);
        return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
    }
}
