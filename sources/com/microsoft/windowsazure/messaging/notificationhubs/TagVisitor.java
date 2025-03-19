package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.windowsazure.messaging.R;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
class TagVisitor implements InstallationVisitor, Taggable {
    private static final String PREFERENCE_KEY = "tags";
    private SharedPreferences mPreferences;

    public TagVisitor(Context context) {
        this(context.getSharedPreferences(context.getString(R.string.installation_enrichment_file_key), 0));
    }

    TagVisitor(SharedPreferences sharedPreferences) {
        this.mPreferences = sharedPreferences;
    }

    private Set<String> getTagsSet() {
        return new HashSet(this.mPreferences.getStringSet(PREFERENCE_KEY, new HashSet()));
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.InstallationVisitor
    public void visitInstallation(Installation installation) {
        installation.addTags(getTagsSet());
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public boolean addTag(String str) {
        return addTags(Collections.singletonList(str));
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public boolean addTags(Collection<? extends String> collection) {
        Set<String> tagsSet = getTagsSet();
        tagsSet.addAll(collection);
        this.mPreferences.edit().putStringSet(PREFERENCE_KEY, tagsSet).apply();
        return true;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public boolean removeTag(String str) {
        return removeTags(Collections.singletonList(str));
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public boolean removeTags(Collection<? extends String> collection) {
        Set<String> tagsSet = getTagsSet();
        if (!tagsSet.removeAll(collection)) {
            return false;
        }
        this.mPreferences.edit().putStringSet(PREFERENCE_KEY, tagsSet).apply();
        return true;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public Iterable<String> getTags() {
        return getTagsSet();
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public void clearTags() {
        this.mPreferences.edit().remove(PREFERENCE_KEY).apply();
    }
}
