package com.google.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: classes2.dex */
public interface BlockingRpcChannel {
    Message callBlockingMethod(Descriptors.MethodDescriptor method, RpcController controller, Message request, Message responsePrototype) throws ServiceException;
}
