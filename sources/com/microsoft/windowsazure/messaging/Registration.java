package com.microsoft.windowsazure.messaging;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import tech.gusavila92.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public abstract class Registration {
    static final String DEFAULT_REGISTRATION_NAME = "$Default";
    static final String REGISTRATIONID_JSON_PROPERTY = "registrationid";
    static final String REGISTRATION_NAME_JSON_PROPERTY = "registrationName";
    protected String mETag;
    protected String mExpirationTime;
    protected String mName;
    protected String mNotificationHubPath;
    protected String mPNSHandle;
    protected String mRegistrationId;
    public RegistrationType mRegistrationType;
    protected List<String> mTags = new ArrayList();
    protected String mURI;
    protected String mUpdated;

    public enum RegistrationType {
        unknown,
        gcm,
        fcm,
        fcmv1,
        adm,
        baidu
    }

    protected abstract void appendCustomPayload(Document document, Element element);

    protected abstract String getSpecificPayloadNodeName();

    protected abstract void loadCustomXmlData(Element element);

    String toXml() throws Exception {
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        newDocumentBuilder.setEntityResolver(new EntityResolver() { // from class: com.microsoft.windowsazure.messaging.Registration.1
            @Override // org.xml.sax.EntityResolver
            public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
                return null;
            }
        });
        Document newDocument = newDocumentBuilder.newDocument();
        Element createElement = newDocument.createElement("entry");
        createElement.setAttribute("xmlns", "http://www.w3.org/2005/Atom");
        newDocument.appendChild(createElement);
        appendNodeWithValue(newDocument, createElement, "id", getURI());
        appendNodeWithValue(newDocument, createElement, "updated", getUpdatedString());
        appendContentNode(newDocument, createElement);
        return Utils.getXmlString(newDocument.getDocumentElement());
    }

    private void appendContentNode(Document document, Element element) {
        Element createElement = document.createElement(FirebaseAnalytics.Param.CONTENT);
        createElement.setAttribute("type", "application/xml");
        element.appendChild(createElement);
        Element createElement2 = document.createElement(getSpecificPayloadNodeName());
        createElement2.setAttribute("xmlns:i", "http://www.w3.org/2001/XMLSchema-instance");
        createElement2.setAttribute("xmlns", "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect");
        createElement.appendChild(createElement2);
        appendNodeWithValue(document, createElement2, HttpHeaders.ETAG, getETag());
        appendNodeWithValue(document, createElement2, "ExpirationTime", getExpirationTimeString());
        appendNodeWithValue(document, createElement2, "RegistrationId", getRegistrationId());
        appendTagsNode(document, createElement2);
        appendCustomPayload(document, createElement2);
    }

    protected void appendTagsNode(Document document, Element element) {
        List<String> tags = getTags();
        if (tags == null || tags.size() <= 0) {
            return;
        }
        String str = tags.get(0);
        for (int i = 1; i < tags.size(); i++) {
            str = str + "," + tags.get(i);
        }
        Element createElement = document.createElement("Tags");
        createElement.appendChild(document.createTextNode(str));
        element.appendChild(createElement);
    }

    protected void appendNodeWithValue(Document document, Element element, String str, String str2) {
        if (Utils.isNullOrWhiteSpace(str2)) {
            return;
        }
        Element createElement = document.createElement(str);
        createElement.appendChild(document.createTextNode(str2));
        element.appendChild(createElement);
    }

    void loadXml(String str, String str2) throws Exception {
        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
        parse.getDocumentElement().normalize();
        Element documentElement = parse.getDocumentElement();
        this.mNotificationHubPath = str2;
        this.mUpdated = getNodeValue(documentElement, "updated");
        NodeList elementsByTagName = parse.getElementsByTagName(getSpecificPayloadNodeName());
        if (elementsByTagName.getLength() > 0) {
            Element element = (Element) elementsByTagName.item(0);
            this.mETag = getNodeValue(element, HttpHeaders.ETAG);
            this.mExpirationTime = getNodeValue(element, "ExpirationTime");
            this.mRegistrationId = getNodeValue(element, "RegistrationId");
            this.mURI = str2 + "/Registrations/" + this.mRegistrationId;
            String nodeValue = getNodeValue(element, "Tags");
            if (!Utils.isNullOrWhiteSpace(nodeValue)) {
                for (String str3 : nodeValue.trim().split(",")) {
                    this.mTags.add(str3);
                }
            }
            loadCustomXmlData(element);
        }
    }

    protected static String getNodeValue(Element element, String str) {
        NodeList elementsByTagName = element.getElementsByTagName(str);
        if (elementsByTagName.getLength() > 0) {
            return elementsByTagName.item(0).getTextContent();
        }
        return null;
    }

    Registration(String str) {
        this.mNotificationHubPath = str;
    }

    public RegistrationType getRegistrationType() {
        return this.mRegistrationType;
    }

    void setRegistrationType(RegistrationType registrationType) {
        this.mRegistrationType = registrationType;
    }

    public String getRegistrationId() {
        return this.mRegistrationId;
    }

    void setRegistrationId(String str) {
        this.mRegistrationId = str;
    }

    public String getNotificationHubPath() {
        return this.mNotificationHubPath;
    }

    void setNotificationHubPath(String str) {
        this.mNotificationHubPath = str;
    }

    String getName() {
        return this.mName;
    }

    void setName(String str) {
        this.mName = str;
    }

    public List<String> getTags() {
        return new ArrayList(this.mTags);
    }

    public String getURI() {
        return getNotificationHubPath() + "/Registrations/" + this.mRegistrationId;
    }

    String getETag() {
        return this.mETag;
    }

    void setETag(String str) {
        this.mETag = str;
    }

    private static Date UTCDateStringToDate(String str) throws ParseException {
        String replace = str.replace("Z", "+00:00");
        try {
            String str2 = replace.substring(0, 26) + replace.substring(27);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSSZ", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat.parse(str2);
        } catch (IndexOutOfBoundsException unused) {
            throw new ParseException("The 'updated' value has an invalid format", 26);
        }
    }

    Date getUpdated() throws ParseException {
        return UTCDateStringToDate(this.mUpdated);
    }

    String getUpdatedString() {
        return this.mUpdated;
    }

    void setUpdatedString(String str) {
        this.mUpdated = str;
    }

    public String getPNSHandle() {
        return this.mPNSHandle;
    }

    void setPNSHandle(String str) {
        this.mPNSHandle = str;
    }

    public Date getExpirationTime() throws ParseException {
        return UTCDateStringToDate(this.mExpirationTime);
    }

    String getExpirationTimeString() {
        return this.mExpirationTime;
    }

    void setExpirationTimeString(String str) {
        this.mExpirationTime = str;
    }

    void addTags(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (!Utils.isNullOrWhiteSpace(str)) {
                    this.mTags.add(str);
                }
            }
        }
    }

    JSONObject getRegistrationInformation() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(REGISTRATIONID_JSON_PROPERTY, getRegistrationId());
        jSONObject.put(REGISTRATION_NAME_JSON_PROPERTY, getName());
        return jSONObject;
    }
}
