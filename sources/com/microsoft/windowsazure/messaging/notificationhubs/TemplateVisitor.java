package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.microsoft.windowsazure.messaging.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class TemplateVisitor implements InstallationVisitor {
    private static final String PREFERENCE_KEY = "templates";
    private final SharedPreferences mPreferences;

    public TemplateVisitor(Context context) {
        this(context.getSharedPreferences(String.valueOf(R.string.installation_enrichment_file_key), 0));
    }

    TemplateVisitor(SharedPreferences sharedPreferences) {
        this.mPreferences = sharedPreferences;
    }

    public TemplateVisitor(Context context, Map<String, InstallationTemplate> map) {
        this(context);
        setTemplates(map);
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationVisitor
    public void visitInstallation(Installation installation) {
        installation.setTemplates(getSharedPreferenceTemplates());
    }

    private Map<String, InstallationTemplate> getSharedPreferenceTemplates() {
        Set<String> stringSet = this.mPreferences.getStringSet(PREFERENCE_KEY, new HashSet());
        if (stringSet == null) {
            return new HashMap();
        }
        try {
            return deserializeInstallationTemplateFromJson(stringSet);
        } catch (JSONException e) {
            throw new RuntimeException("Unable to deserialize installation template", e);
        }
    }

    public void setTemplate(String str, InstallationTemplate installationTemplate) {
        setTemplates(Collections.singletonMap(str, installationTemplate));
    }

    public void setTemplates(Map<String, InstallationTemplate> map) {
        Map<String, InstallationTemplate> sharedPreferenceTemplates = getSharedPreferenceTemplates();
        sharedPreferenceTemplates.putAll(map);
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, InstallationTemplate> entry : sharedPreferenceTemplates.entrySet()) {
            hashSet.add(serializeInstallationTemplateToJson(entry.getKey(), entry.getValue()));
        }
        this.mPreferences.edit().putStringSet(PREFERENCE_KEY, hashSet).apply();
    }

    public boolean removeTemplate(String str) {
        return removeTemplates(Collections.singletonList(str));
    }

    public boolean removeTemplates(List<String> list) {
        Map<String, InstallationTemplate> sharedPreferenceTemplates = getSharedPreferenceTemplates();
        sharedPreferenceTemplates.keySet().removeAll(list);
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, InstallationTemplate> entry : sharedPreferenceTemplates.entrySet()) {
            hashSet.add(serializeInstallationTemplateToJson(entry.getKey(), entry.getValue()));
        }
        this.mPreferences.edit().putStringSet(PREFERENCE_KEY, hashSet).apply();
        return true;
    }

    public InstallationTemplate getTemplate(String str) {
        return getSharedPreferenceTemplates().get(str);
    }

    public Iterable<Map.Entry<String, InstallationTemplate>> getTemplates() {
        return getSharedPreferenceTemplates().entrySet();
    }

    public void clearTemplates() {
        this.mPreferences.edit().remove(PREFERENCE_KEY).apply();
    }

    private static String serializeInstallationTemplateToJson(String str, InstallationTemplate installationTemplate) {
        return InstallationTemplate.serialize(str, installationTemplate).toString();
    }

    private static Map<String, InstallationTemplate> deserializeInstallationTemplateFromJson(Set<String> set) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = new JSONObject(it.next());
            hashMap.put(jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), InstallationTemplate.deserialize(jSONObject));
        }
        return hashMap;
    }
}
