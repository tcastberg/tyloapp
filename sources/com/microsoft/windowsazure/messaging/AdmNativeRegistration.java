package com.microsoft.windowsazure.messaging;

import com.microsoft.windowsazure.messaging.Registration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes2.dex */
public class AdmNativeRegistration extends Registration {
    static final String ADM_HANDLE_NODE = "AdmRegistrationId";
    private static final String ADM_NATIVE_REGISTRATION_CUSTOM_NODE = "AdmRegistrationDescription";

    AdmNativeRegistration(String str) {
        super(str);
        this.mRegistrationType = Registration.RegistrationType.adm;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected String getSpecificPayloadNodeName() {
        return ADM_NATIVE_REGISTRATION_CUSTOM_NODE;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendNodeWithValue(document, element, ADM_HANDLE_NODE, getPNSHandle());
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        setPNSHandle(getNodeValue(element, ADM_HANDLE_NODE));
        setName("$Default");
    }
}
