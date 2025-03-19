package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private boolean mBackInvokedCallbackRegistered;
    private Consumer<Boolean> mEnabledConsumer;
    private final Runnable mFallbackOnBackPressed;
    private OnBackInvokedDispatcher mInvokedDispatcher;
    private OnBackInvokedCallback mOnBackInvokedCallback;
    final ArrayDeque<OnBackPressedCallback> mOnBackPressedCallbacks;

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        this.mInvokedDispatcher = onBackInvokedDispatcher;
        updateBackInvokedCallbackState();
    }

    void updateBackInvokedCallbackState() {
        boolean hasEnabledCallbacks = hasEnabledCallbacks();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.mInvokedDispatcher;
        if (onBackInvokedDispatcher != null) {
            if (hasEnabledCallbacks && !this.mBackInvokedCallbackRegistered) {
                Api33Impl.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, this.mOnBackInvokedCallback);
                this.mBackInvokedCallbackRegistered = true;
            } else {
                if (hasEnabledCallbacks || !this.mBackInvokedCallbackRegistered) {
                    return;
                }
                Api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, this.mOnBackInvokedCallback);
                this.mBackInvokedCallbackRegistered = false;
            }
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.mOnBackPressedCallbacks = new ArrayDeque<>();
        this.mBackInvokedCallbackRegistered = false;
        this.mFallbackOnBackPressed = runnable;
        if (BuildCompat.isAtLeastT()) {
            this.mEnabledConsumer = new Consumer() { // from class: androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    OnBackPressedDispatcher.this.m3lambda$new$0$androidxactivityOnBackPressedDispatcher((Boolean) obj);
                }
            };
            this.mOnBackInvokedCallback = Api33Impl.createOnBackInvokedCallback(new Runnable() { // from class: androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    OnBackPressedDispatcher.this.onBackPressed();
                }
            });
        }
    }

    /* renamed from: lambda$new$0$androidx-activity-OnBackPressedDispatcher, reason: not valid java name */
    /* synthetic */ void m3lambda$new$0$androidxactivityOnBackPressedDispatcher(Boolean bool) {
        if (BuildCompat.isAtLeastT()) {
            updateBackInvokedCallbackState();
        }
    }

    public void addCallback(OnBackPressedCallback onBackPressedCallback) {
        addCancellableCallback(onBackPressedCallback);
    }

    Cancellable addCancellableCallback(OnBackPressedCallback onBackPressedCallback) {
        this.mOnBackPressedCallbacks.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        if (BuildCompat.isAtLeastT()) {
            updateBackInvokedCallbackState();
            onBackPressedCallback.setIsEnabledConsumer(this.mEnabledConsumer);
        }
        return onBackPressedCancellable;
    }

    public void addCallback(LifecycleOwner lifecycleOwner, OnBackPressedCallback onBackPressedCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
        if (BuildCompat.isAtLeastT()) {
            updateBackInvokedCallbackState();
            onBackPressedCallback.setIsEnabledConsumer(this.mEnabledConsumer);
        }
    }

    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> descendingIterator = this.mOnBackPressedCallbacks.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public void onBackPressed() {
        Iterator<OnBackPressedCallback> descendingIterator = this.mOnBackPressedCallbacks.descendingIterator();
        while (descendingIterator.hasNext()) {
            OnBackPressedCallback next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        Runnable runnable = this.mFallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    private class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback mOnBackPressedCallback;

        OnBackPressedCancellable(OnBackPressedCallback onBackPressedCallback) {
            this.mOnBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.this.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
            this.mOnBackPressedCallback.removeCancellable(this);
            if (BuildCompat.isAtLeastT()) {
                this.mOnBackPressedCallback.setIsEnabledConsumer(null);
                OnBackPressedDispatcher.this.updateBackInvokedCallbackState();
            }
        }
    }

    private class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable mCurrentCancellable;
        private final Lifecycle mLifecycle;
        private final OnBackPressedCallback mOnBackPressedCallback;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            this.mLifecycle = lifecycle;
            this.mOnBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.mCurrentCancellable = OnBackPressedDispatcher.this.addCancellableCallback(this.mOnBackPressedCallback);
                return;
            }
            if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.mCurrentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                    return;
                }
                return;
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.mLifecycle.removeObserver(this);
            this.mOnBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.mCurrentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
                this.mCurrentCancellable = null;
            }
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static void registerOnBackInvokedCallback(Object obj, int i, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
        }

        static void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }

        static OnBackInvokedCallback createOnBackInvokedCallback(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0(runnable);
        }
    }
}
