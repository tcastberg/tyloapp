package com.microsoft.windowsazure.messaging;

import com.microsoft.windowsazure.messaging.Registration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes2.dex */
public class FcmV1NativeRegistration extends Registration {
    static final String FCM_V1_HANDLE_NODE = "FcmV1RegistrationId";
    private static final String FCM_V1_NATIVE_REGISTRATION_CUSTOM_NODE = "FcmV1RegistrationDescription";

    FcmV1NativeRegistration(String str) {
        super(str);
        this.mRegistrationType = Registration.RegistrationType.fcmv1;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected String getSpecificPayloadNodeName() {
        return FCM_V1_NATIVE_REGISTRATION_CUSTOM_NODE;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendNodeWithValue(document, element, FCM_V1_HANDLE_NODE, getPNSHandle());
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        setPNSHandle(getNodeValue(element, FCM_V1_HANDLE_NODE));
        setName("$Default");
    }
}
