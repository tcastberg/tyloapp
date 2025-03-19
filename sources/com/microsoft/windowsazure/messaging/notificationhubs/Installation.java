package com.microsoft.windowsazure.messaging.notificationhubs;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public class Installation implements Taggable {
    private Date mExpiration;
    private String mInstallationId;
    private String mPushChannel;
    private String mUserId;
    private String mPlatform = "fcmv1";
    private Set<String> mTags = new HashSet();
    private Map<String, InstallationTemplate> mTemplates = new HashMap();

    public String getPushChannel() {
        return this.mPushChannel;
    }

    public void setPushChannel(String str) {
        this.mPushChannel = str;
    }

    public String getPlatform() {
        return this.mPlatform;
    }

    public void setPlatform(String str) {
        this.mPlatform = str;
    }

    public String getInstallationId() {
        return this.mInstallationId;
    }

    public void setInstallationId(String str) {
        this.mInstallationId = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public boolean addTag(String str) {
        return this.mTags.add(str);
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public boolean addTags(Collection<? extends String> collection) {
        return this.mTags.addAll(collection);
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public Iterable<String> getTags() {
        return this.mTags;
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public void clearTags() {
        this.mTags.clear();
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public boolean removeTag(String str) {
        return this.mTags.remove(str);
    }

    @Override // com.microsoft.windowsazure.messaging.notificationhubs.Taggable
    public boolean removeTags(Collection<? extends String> collection) {
        return this.mTags.removeAll(collection);
    }

    public void setTemplates(Map<String, InstallationTemplate> map) {
        this.mTemplates.putAll(map);
    }

    public Map<String, InstallationTemplate> getTemplates() {
        return this.mTemplates;
    }

    public Date getExpiration() {
        return this.mExpiration;
    }

    public void setExpiration(Date date) {
        this.mExpiration = date;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Installation installation = (Installation) obj;
        return this.mPushChannel.equals(installation.mPushChannel) && this.mTags.equals(installation.mTags) && this.mTemplates.equals(installation.mTemplates) && this.mInstallationId.equals(installation.mInstallationId) && this.mUserId.equals(installation.mUserId) && this.mExpiration.equals(installation.mExpiration);
    }

    public int hashCode() {
        return Objects.hash(this.mPushChannel, this.mTags, this.mTemplates, this.mInstallationId, this.mUserId, this.mExpiration);
    }
}
