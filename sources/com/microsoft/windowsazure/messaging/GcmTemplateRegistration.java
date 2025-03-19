package com.microsoft.windowsazure.messaging;

import com.microsoft.windowsazure.messaging.Registration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Deprecated
/* loaded from: classes2.dex */
public class GcmTemplateRegistration extends TemplateRegistration {
    private static final String GCM_HANDLE_NODE = "GcmRegistrationId";
    static final String GCM_TEMPLATE_REGISTRATION_CUSTOM_NODE = "GcmTemplateRegistrationDescription";

    GcmTemplateRegistration(String str) {
        super(str);
        this.mRegistrationType = Registration.RegistrationType.gcm;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected String getSpecificPayloadNodeName() {
        return GCM_TEMPLATE_REGISTRATION_CUSTOM_NODE;
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendNodeWithValue(document, element, GCM_HANDLE_NODE, getPNSHandle());
        super.appendCustomPayload(document, element);
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        setPNSHandle(getNodeValue(element, GCM_HANDLE_NODE));
        super.loadCustomXmlData(element);
    }
}
