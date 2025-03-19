package com.microsoft.windowsazure.messaging.notificationhubs;

import java.util.Collection;

/* loaded from: classes2.dex */
interface Taggable {
    boolean addTag(String str);

    boolean addTags(Collection<? extends String> collection);

    void clearTags();

    Iterable<String> getTags();

    boolean removeTag(String str);

    boolean removeTags(Collection<? extends String> collection);
}
