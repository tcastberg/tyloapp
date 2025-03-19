package com.microsoft.windowsazure.messaging.notificationhubs;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class InstallationTemplate {
    private String mBody;
    private Set<String> mTags = new HashSet();
    private Map<String, String> mHeaders = new HashMap();

    public String getBody() {
        return this.mBody;
    }

    public void setBody(String str) {
        this.mBody = str;
    }

    public void addTag(String str) {
        this.mTags.add(str);
    }

    public void addTags(List<String> list) {
        this.mTags.addAll(list);
    }

    public void removeTag(String str) {
        this.mTags.remove(str);
    }

    public void removeTags(List<String> list) {
        this.mTags.removeAll(list);
    }

    public Iterable<String> getTags() {
        return this.mTags;
    }

    public void clearTags() {
        this.mTags = new HashSet();
    }

    public void setHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public void removeHeader(String str) {
        this.mHeaders.remove(str);
    }

    static JSONObject serialize(String str, InstallationTemplate installationTemplate) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
            jSONObject.put("body", installationTemplate.getBody());
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : installationTemplate.getHeaders().entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("headers", jSONObject2);
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = installationTemplate.getTags().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("tags", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException("Invalid template, unable to serialize", e);
        }
    }

    static InstallationTemplate deserialize(JSONObject jSONObject) throws JSONException {
        InstallationTemplate installationTemplate = new InstallationTemplate();
        installationTemplate.setBody(jSONObject.getString("body"));
        if (jSONObject.has("tags")) {
            JSONArray jSONArray = jSONObject.getJSONArray("tags");
            for (int i = 0; i < jSONArray.length(); i++) {
                installationTemplate.addTag(jSONArray.getString(i));
            }
        }
        if (jSONObject.has("tags")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("headers");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                installationTemplate.setHeader(next, jSONObject2.getString(next));
            }
        }
        return installationTemplate;
    }

    public Map<String, String> getHeaders() {
        return new HashMap(this.mHeaders);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTemplate)) {
            return false;
        }
        InstallationTemplate installationTemplate = (InstallationTemplate) obj;
        return this.mBody.equals(installationTemplate.mBody) && this.mTags.equals(installationTemplate.mTags) && this.mHeaders.equals(installationTemplate.mHeaders);
    }

    public int hashCode() {
        return Objects.hash(this.mBody, this.mTags, this.mHeaders);
    }
}
