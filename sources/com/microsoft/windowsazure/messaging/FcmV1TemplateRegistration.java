package com.microsoft.windowsazure.messaging;

import com.microsoft.windowsazure.messaging.Registration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes2.dex */
public class FcmV1TemplateRegistration extends TemplateRegistration {
    private static final String FCM_V1_HANDLE_NODE = "FcmV1RegistrationId";
    static final String FCM_V1_TEMPLATE_REGISTRATION_CUSTOM_NODE = "FcmV1TemplateRegistrationDescription";

    FcmV1TemplateRegistration(String str) {
        super(str);
        this.mRegistrationType = Registration.RegistrationType.fcmv1;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected String getSpecificPayloadNodeName() {
        return FCM_V1_TEMPLATE_REGISTRATION_CUSTOM_NODE;
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendNodeWithValue(document, element, FCM_V1_HANDLE_NODE, getPNSHandle());
        super.appendCustomPayload(document, element);
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        setPNSHandle(getNodeValue(element, FCM_V1_HANDLE_NODE));
        super.loadCustomXmlData(element);
    }
}
