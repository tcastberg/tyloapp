package com.microsoft.windowsazure.messaging;

import com.microsoft.windowsazure.messaging.Registration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Deprecated
/* loaded from: classes2.dex */
public class FcmTemplateRegistration extends TemplateRegistration {
    private static final String FCM_HANDLE_NODE = "GcmRegistrationId";
    static final String FCM_TEMPLATE_REGISTRATION_CUSTOM_NODE = "GcmTemplateRegistrationDescription";

    FcmTemplateRegistration(String str) {
        super(str);
        this.mRegistrationType = Registration.RegistrationType.fcm;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected String getSpecificPayloadNodeName() {
        return FCM_TEMPLATE_REGISTRATION_CUSTOM_NODE;
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendNodeWithValue(document, element, FCM_HANDLE_NODE, getPNSHandle());
        super.appendCustomPayload(document, element);
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        setPNSHandle(getNodeValue(element, FCM_HANDLE_NODE));
        super.loadCustomXmlData(element);
    }
}
