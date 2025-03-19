package com.google.protobuf;

import java.util.List;

/* loaded from: classes2.dex */
public interface ListValueOrBuilder extends MessageOrBuilder {
    Value getValues(int index);

    int getValuesCount();

    List<Value> getValuesList();

    ValueOrBuilder getValuesOrBuilder(int index);

    List<? extends ValueOrBuilder> getValuesOrBuilderList();
}
