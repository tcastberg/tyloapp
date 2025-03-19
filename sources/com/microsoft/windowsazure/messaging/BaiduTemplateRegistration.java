package com.microsoft.windowsazure.messaging;

import com.microsoft.windowsazure.messaging.Registration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes2.dex */
public class BaiduTemplateRegistration extends TemplateRegistration {
    private static final String BAIDU_CHANNEL_ID = "BaiduChannelId";
    private static final String BAIDU_HANDLE_NODE = "BaiduUserId-BaiduChannelId";
    static final String BAIDU_TEMPLATE_REGISTRATION_CUSTOM_NODE = "BaiduTemplateRegistrationDescription";
    private static final String BAIDU_USER_ID = "BaiduUserId";
    protected String mChannelId;
    protected String mUserId;

    BaiduTemplateRegistration(String str) {
        super(str);
        this.mRegistrationType = Registration.RegistrationType.baidu;
    }

    public String getUserId() {
        return this.mUserId;
    }

    void setUserId(String str) {
        this.mUserId = str;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    void setChannelId(String str) {
        this.mChannelId = str;
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    void setPNSHandle(String str) {
        if (Utils.isNullOrWhiteSpace(str)) {
            return;
        }
        this.mPNSHandle = str;
        String[] split = str.split("-");
        String str2 = split[0];
        if (Utils.isNullOrWhiteSpace(str2)) {
            throw new AssertionError("Baidu userId is inalid!");
        }
        setUserId(str2);
        String str3 = split[1];
        if (Utils.isNullOrWhiteSpace(str2)) {
            throw new AssertionError("Baidu channelId is inalid!");
        }
        setChannelId(str3);
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected String getSpecificPayloadNodeName() {
        return BAIDU_TEMPLATE_REGISTRATION_CUSTOM_NODE;
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendNodeWithValue(document, element, BAIDU_USER_ID, getUserId());
        appendNodeWithValue(document, element, BAIDU_CHANNEL_ID, getChannelId());
        super.appendCustomPayload(document, element);
    }

    @Override // com.microsoft.windowsazure.messaging.TemplateRegistration, com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        setPNSHandle(getNodeValue(element, BAIDU_HANDLE_NODE));
        super.loadCustomXmlData(element);
    }
}
