package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tech.gusavila92.apache.http.HttpStatus;

/* compiled from: Share.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", i = {0, 0}, l = {HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 423}, m = "onSubscription", n = {"this", "safeCollector"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
final class SubscribedFlowCollector$onSubscription$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubscribedFlowCollector<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubscribedFlowCollector$onSubscription$1(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super SubscribedFlowCollector$onSubscription$1> continuation) {
        super(continuation);
        this.this$0 = subscribedFlowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onSubscription(this);
    }
}
