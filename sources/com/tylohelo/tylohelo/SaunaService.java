package com.tylohelo.tylohelo;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SaunaService {
    public static HashMap<String, SaunaModel> saunas = new HashMap<>();
    FragmentActivity activity;

    public SaunaService(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    public boolean getCloudEnabled() {
        return this.activity.getSharedPreferences("preferences", 0).getString("cloudEnabled", "").equals("1");
    }

    public void setCloudEnabled(int i) {
        SharedPreferences.Editor edit = this.activity.getSharedPreferences("preferences", 0).edit();
        edit.putString("cloudEnabled", Integer.toString(i));
        edit.apply();
    }

    public void storeSauna(SaunaModel saunaModel) {
        HashMap<String, SaunaModel> saunaListStored = getSaunaListStored();
        saunas = saunaListStored;
        if (saunaListStored == null) {
            saunas = new HashMap<>();
        }
        saunas.put(saunaModel.getSystemId(), saunaModel);
        String json = new Gson().toJson(saunas);
        SharedPreferences.Editor edit = this.activity.getSharedPreferences("preferences", 0).edit();
        edit.putString("saunas", json);
        edit.apply();
    }

    public SaunaModel getSaunaStored(String str) {
        HashMap hashMap;
        String string = this.activity.getSharedPreferences("preferences", 0).getString("saunas", "");
        if (!string.isEmpty()) {
            try {
                hashMap = (HashMap) new ObjectMapper().readValue(string, new TypeReference<HashMap<String, SaunaModel>>() { // from class: com.tylohelo.tylohelo.SaunaService.1
                    @Override // com.fasterxml.jackson.core.type.TypeReference
                    public Type getType() {
                        return super.getType();
                    }
                });
            } catch (JsonProcessingException e) {
                if (e.getMessage() != null) {
                    Log.e("Exception", e.getMessage());
                }
                hashMap = null;
            }
            if (hashMap != null) {
                Gson gson = new Gson();
                return (SaunaModel) gson.fromJson(gson.toJson(((HashMap) Objects.requireNonNull(hashMap)).get(str)), SaunaModel.class);
            }
        }
        return null;
    }

    public HashMap<String, SaunaModel> getSaunaListStored() {
        String string = this.activity.getSharedPreferences("preferences", 0).getString("saunas", "");
        if (string.isEmpty()) {
            return null;
        }
        try {
            return (HashMap) new ObjectMapper().readValue(string, new TypeReference<HashMap<String, SaunaModel>>() { // from class: com.tylohelo.tylohelo.SaunaService.2
                @Override // com.fasterxml.jackson.core.type.TypeReference
                public Type getType() {
                    return super.getType();
                }
            });
        } catch (JsonProcessingException e) {
            if (e.getMessage() == null) {
                return null;
            }
            Log.e("Exception", e.getMessage());
            return null;
        }
    }

    public void setCurrentSaunaId(String str) {
        SharedPreferences.Editor edit = this.activity.getSharedPreferences("preferences", 0).edit();
        edit.putString("saunaId", str);
        edit.apply();
        if (str == null) {
            tyloApplication.resetSaunaParams();
        }
    }

    public String getCurrentSaunaId() {
        return this.activity.getSharedPreferences("preferences", 0).getString("saunaId", null);
    }

    public void removeSauna(String str) {
        HashMap<String, SaunaModel> saunaListStored = getSaunaListStored();
        if (saunaListStored.containsKey(str)) {
            saunaListStored.remove(str);
            String json = new Gson().toJson(saunaListStored);
            SharedPreferences.Editor edit = this.activity.getSharedPreferences("preferences", 0).edit();
            edit.putString("saunas", json);
            edit.apply();
        }
    }
}
