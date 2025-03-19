package com.microsoft.windowsazure.messaging;

import com.microsoft.windowsazure.messaging.Registration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes2.dex */
public class AdmTemplateRegistration extends TemplateRegistration {
    private static final String ADM_HANDLE_NODE = "AdmRegistrationId";
    static final String ADM_TEMPLATE_REGISTRATION_CUSTOM_NODE = "AdmTemplateRegistrationDescription";

    AdmTemplateRegistration(String str) {
        super(str);
        this.mRegistrationType = Registration.RegistrationType.adm;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected String getSpecificPayloadNodeName() {
        return ADM_TEMPLATE_REGISTRATION_CUSTOM_NODE;
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendNodeWithValue(document, element, ADM_HANDLE_NODE, getPNSHandle());
        super.appendCustomPayload(document, element);
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        setPNSHandle(getNodeValue(element, ADM_HANDLE_NODE));
        super.loadCustomXmlData(element);
    }
}
