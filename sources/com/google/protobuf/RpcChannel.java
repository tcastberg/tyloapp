package com.google.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: classes2.dex */
public interface RpcChannel {
    void callMethod(Descriptors.MethodDescriptor method, RpcController controller, Message request, Message responsePrototype, RpcCallback<Message> done);
}
