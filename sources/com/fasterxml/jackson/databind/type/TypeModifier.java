package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public abstract class TypeModifier {
    public abstract JavaType modifyType(JavaType javaType, Type type, TypeBindings typeBindings, TypeFactory typeFactory);
}
