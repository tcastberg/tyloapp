package com.microsoft.windowsazure.messaging;

import com.microsoft.windowsazure.messaging.Registration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Deprecated
/* loaded from: classes2.dex */
public class FcmNativeRegistration extends Registration {
    static final String FCM_HANDLE_NODE = "GcmRegistrationId";
    private static final String FCM_NATIVE_REGISTRATION_CUSTOM_NODE = "GcmRegistrationDescription";

    FcmNativeRegistration(String str) {
        super(str);
        this.mRegistrationType = Registration.RegistrationType.fcm;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected String getSpecificPayloadNodeName() {
        return FCM_NATIVE_REGISTRATION_CUSTOM_NODE;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendNodeWithValue(document, element, FCM_HANDLE_NODE, getPNSHandle());
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        setPNSHandle(getNodeValue(element, FCM_HANDLE_NODE));
        setName("$Default");
    }
}
