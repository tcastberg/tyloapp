package com.google.protobuf;

import java.util.Map;

/* loaded from: classes2.dex */
public interface StructOrBuilder extends MessageOrBuilder {
    boolean containsFields(String key);

    @Deprecated
    Map<String, Value> getFields();

    int getFieldsCount();

    Map<String, Value> getFieldsMap();

    Value getFieldsOrDefault(String key, Value defaultValue);

    Value getFieldsOrThrow(String key);
}
