package com.microsoft.windowsazure.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.microsoft.windowsazure.messaging.Registration;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.AbstractMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import tech.gusavila92.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public class NotificationHub {
    private static final String NEW_REGISTRATION_LOCATION_HEADER = "Location";
    private static final String PNS_HANDLE_KEY = "PNS_HANDLE";
    private static final String REGISTRATION_NAME_STORAGE_KEY = "REG_NAME_";
    private static final String STORAGE_PREFIX = "__NH_";
    private static final String STORAGE_VERSION = "1.0.0";
    private static final String STORAGE_VERSION_KEY = "STORAGE_VERSION";
    private static final String XML_CONTENT_TYPE = "application/atom+xml";
    private String mConnectionString;
    private boolean mIsRefreshNeeded;
    private String mNotificationHubPath;
    private SharedPreferences mSharedPreferences;

    public NotificationHub(String str, String str2, Context context) {
        this(str, str2, PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()));
    }

    NotificationHub(String str, String str2, SharedPreferences sharedPreferences) {
        this.mIsRefreshNeeded = false;
        setConnectionString(str2);
        setNotificationHubPath(str);
        if (sharedPreferences == null) {
            throw new IllegalArgumentException("sharedPreferences cannot be null");
        }
        this.mSharedPreferences = sharedPreferences;
        verifyStorageVersion();
    }

    public Registration register(String str, String... strArr) throws Exception {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("pnsHandle");
        }
        Registration createNativeRegistration = PnsSpecificRegistrationFactory.getInstance().createNativeRegistration(this.mNotificationHubPath);
        createNativeRegistration.setPNSHandle(str);
        createNativeRegistration.setName("$Default");
        createNativeRegistration.addTags(strArr);
        return registerInternal(createNativeRegistration);
    }

    public Registration registerBaidu(String str, String str2, String... strArr) throws Exception {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("userId");
        }
        if (Utils.isNullOrWhiteSpace(str2)) {
            throw new IllegalArgumentException("channelId");
        }
        PnsSpecificRegistrationFactory.getInstance().setRegistrationType(Registration.RegistrationType.baidu);
        return register(str + "-" + str2, strArr);
    }

    public TemplateRegistration registerTemplate(String str, String str2, String str3, String... strArr) throws Exception {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("pnsHandle");
        }
        if (Utils.isNullOrWhiteSpace(str2)) {
            throw new IllegalArgumentException("templateName");
        }
        if (Utils.isNullOrWhiteSpace(str3)) {
            throw new IllegalArgumentException("template");
        }
        TemplateRegistration createTemplateRegistration = PnsSpecificRegistrationFactory.getInstance().createTemplateRegistration(this.mNotificationHubPath);
        createTemplateRegistration.setPNSHandle(str);
        createTemplateRegistration.setName(str2);
        createTemplateRegistration.setBodyTemplate(str3);
        createTemplateRegistration.addTags(strArr);
        return (TemplateRegistration) registerInternal(createTemplateRegistration);
    }

    public TemplateRegistration registerBaiduTemplate(String str, String str2, String str3, String str4, String... strArr) throws Exception {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("userId");
        }
        if (Utils.isNullOrWhiteSpace(str2)) {
            throw new IllegalArgumentException("channelId");
        }
        if (Utils.isNullOrWhiteSpace(str3)) {
            throw new IllegalArgumentException("templateName");
        }
        if (Utils.isNullOrWhiteSpace(str4)) {
            throw new IllegalArgumentException("template");
        }
        PnsSpecificRegistrationFactory.getInstance().setRegistrationType(Registration.RegistrationType.baidu);
        return registerTemplate(str + "-" + str2, str3, str4, strArr);
    }

    public void unregister() throws Exception {
        unregisterInternal("$Default");
    }

    public void unregisterTemplate(String str) throws Exception {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("templateName");
        }
        unregisterInternal(str);
    }

    public void unregisterAll(String str) throws Exception {
        refreshRegistrationInformation(str);
        for (String str2 : this.mSharedPreferences.getAll().keySet()) {
            if (str2.startsWith("__NH_REG_NAME_")) {
                deleteRegistrationInternal(str2.substring(14), this.mSharedPreferences.getString(str2, ""));
            }
        }
    }

    private void refreshRegistrationInformation(String str) throws Exception {
        Registration createNativeRegistration;
        Registration.RegistrationType registrationType;
        Registration.RegistrationType registrationType2;
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("pnsHandle");
        }
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        for (String str2 : this.mSharedPreferences.getAll().keySet()) {
            if (str2.startsWith("__NH_REG_NAME_")) {
                edit.remove(str2);
            }
        }
        edit.commit();
        String executeRequest = new Connection(this.mConnectionString).executeRequest(this.mNotificationHubPath + "/Registrations/?$filter=" + URLEncoder.encode(PnsSpecificRegistrationFactory.getInstance().getPNSHandleFieldName() + " eq '" + str + "'", "UTF-8"), null, XML_CONTENT_TYPE, "GET", new AbstractMap.SimpleEntry[0]);
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        newDocumentBuilder.setEntityResolver(new EntityResolver() { // from class: com.microsoft.windowsazure.messaging.NotificationHub.1
            @Override // org.xml.sax.EntityResolver
            public InputSource resolveEntity(String str3, String str4) throws SAXException, IOException {
                return null;
            }
        });
        Document parse = newDocumentBuilder.parse(new InputSource(new StringReader(executeRequest)));
        parse.getDocumentElement().normalize();
        NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("entry");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            String xmlString = Utils.getXmlString((Element) elementsByTagName.item(i));
            if (PnsSpecificRegistrationFactory.getInstance().isTemplateRegistration(xmlString)) {
                createNativeRegistration = PnsSpecificRegistrationFactory.getInstance().createTemplateRegistration(this.mNotificationHubPath);
            } else {
                createNativeRegistration = PnsSpecificRegistrationFactory.getInstance().createNativeRegistration(this.mNotificationHubPath);
            }
            createNativeRegistration.loadXml(xmlString, this.mNotificationHubPath);
            if (Utils.isNullOrWhiteSpace(createNativeRegistration.getRegistrationId()) && ((registrationType = PnsSpecificRegistrationFactory.getInstance().getRegistrationType()) == Registration.RegistrationType.fcmv1 || registrationType == Registration.RegistrationType.fcm || registrationType == Registration.RegistrationType.gcm)) {
                if (registrationType == Registration.RegistrationType.fcmv1) {
                    registrationType2 = Registration.RegistrationType.fcm;
                } else {
                    registrationType2 = Registration.RegistrationType.fcmv1;
                }
                if (PnsSpecificRegistrationFactory.getInstance().isTemplateRegistrationForPlatform(xmlString, registrationType2)) {
                    createNativeRegistration = PnsSpecificRegistrationFactory.getInstance().createTemplateRegistrationForPlatform(this.mNotificationHubPath, registrationType2);
                } else {
                    createNativeRegistration = PnsSpecificRegistrationFactory.getInstance().createNativeRegistrationForPlatform(this.mNotificationHubPath, registrationType2);
                }
                createNativeRegistration.loadXml(xmlString, this.mNotificationHubPath);
            }
            storeRegistrationId(createNativeRegistration.getName(), createNativeRegistration.getRegistrationId(), createNativeRegistration.getPNSHandle());
        }
        this.mIsRefreshNeeded = false;
    }

    public String getConnectionString() {
        return this.mConnectionString;
    }

    public void setConnectionString(String str) {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("connectionString");
        }
        try {
            ConnectionStringParser.parse(str);
            this.mConnectionString = str;
        } catch (Exception e) {
            throw new IllegalArgumentException("connectionString", e);
        }
    }

    public String getNotificationHubPath() {
        return this.mNotificationHubPath;
    }

    public void setNotificationHubPath(String str) {
        if (Utils.isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("notificationHubPath");
        }
        this.mNotificationHubPath = str;
    }

    private Registration registerInternal(Registration registration) throws Exception {
        if (this.mIsRefreshNeeded) {
            String string = this.mSharedPreferences.getString("__NH_PNS_HANDLE", "");
            if (Utils.isNullOrWhiteSpace(string)) {
                string = registration.getPNSHandle();
            }
            refreshRegistrationInformation(string);
        }
        String retrieveRegistrationId = retrieveRegistrationId(registration.getName());
        if (Utils.isNullOrWhiteSpace(retrieveRegistrationId)) {
            retrieveRegistrationId = createRegistrationId();
        }
        registration.setRegistrationId(retrieveRegistrationId);
        try {
            return upsertRegistrationInternal(registration);
        } catch (RegistrationGoneException unused) {
            registration.setRegistrationId(this.createRegistrationId());
            return this.upsertRegistrationInternal(registration);
        }
    }

    private void unregisterInternal(String str) throws Exception {
        String retrieveRegistrationId = retrieveRegistrationId(str);
        if (Utils.isNullOrWhiteSpace(retrieveRegistrationId)) {
            return;
        }
        deleteRegistrationInternal(str, retrieveRegistrationId);
    }

    private Registration upsertRegistrationInternal(Registration registration) throws Exception {
        Registration createNativeRegistration;
        String executeRequest = new Connection(this.mConnectionString).executeRequest(registration.getURI(), registration.toXml(), XML_CONTENT_TYPE, "PUT", new AbstractMap.SimpleEntry[0]);
        if (PnsSpecificRegistrationFactory.getInstance().isTemplateRegistration(executeRequest)) {
            createNativeRegistration = PnsSpecificRegistrationFactory.getInstance().createTemplateRegistration(this.mNotificationHubPath);
        } else {
            createNativeRegistration = PnsSpecificRegistrationFactory.getInstance().createNativeRegistration(this.mNotificationHubPath);
        }
        createNativeRegistration.loadXml(executeRequest, this.mNotificationHubPath);
        storeRegistrationId(createNativeRegistration.getName(), createNativeRegistration.getRegistrationId(), registration.getPNSHandle());
        return createNativeRegistration;
    }

    private String createRegistrationId() throws Exception {
        return new URI(new Connection(this.mConnectionString).executeRequest(this.mNotificationHubPath + "/registrationids/", null, XML_CONTENT_TYPE, "POST", "Location", new AbstractMap.SimpleEntry[0])).getPath().split("/")[r7.length - 1];
    }

    private void deleteRegistrationInternal(String str, String str2) throws Exception {
        new Connection(this.mConnectionString).executeRequest(this.mNotificationHubPath + "/Registrations/" + str2, null, XML_CONTENT_TYPE, "DELETE", new AbstractMap.SimpleEntry<>(HttpHeaders.IF_MATCH, "*"));
        removeRegistrationId(str);
    }

    private String retrieveRegistrationId(String str) throws Exception {
        return this.mSharedPreferences.getString("__NH_REG_NAME_" + str, null);
    }

    private void storeRegistrationId(String str, String str2, String str3) throws Exception {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("__NH_REG_NAME_" + str, str2);
        edit.putString("__NH_PNS_HANDLE", str3);
        edit.putString("__NH_STORAGE_VERSION", STORAGE_VERSION);
        edit.commit();
    }

    private void removeRegistrationId(String str) throws Exception {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.remove("__NH_REG_NAME_" + str);
        edit.commit();
    }

    private void verifyStorageVersion() {
        String string = this.mSharedPreferences.getString("__NH_STORAGE_VERSION", "");
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        if (!string.equals(STORAGE_VERSION)) {
            for (String str : this.mSharedPreferences.getAll().keySet()) {
                if (str.startsWith(STORAGE_PREFIX)) {
                    edit.remove(str);
                }
            }
        }
        edit.commit();
        this.mIsRefreshNeeded = true;
    }
}
