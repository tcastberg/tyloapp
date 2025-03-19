package com.microsoft.windowsazure.messaging.notificationhubs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.util.Log;
import java.io.Closeable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
class NetworkStateHelper implements Closeable {
    private static NetworkStateHelper sSharedInstance;
    private final ConnectivityManager mConnectivityManager;
    private ConnectivityReceiver mConnectivityReceiver;
    private final Context mContext;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private final Set<Listener> mListeners = new CopyOnWriteArraySet();
    private final AtomicBoolean mConnected = new AtomicBoolean();

    public interface Listener {
        void onNetworkStateUpdated(boolean z);
    }

    public NetworkStateHelper(Context context) {
        this.mContext = context.getApplicationContext();
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        reopen();
    }

    public static synchronized void unsetInstance() {
        synchronized (NetworkStateHelper.class) {
            sSharedInstance = null;
        }
    }

    public static synchronized NetworkStateHelper getSharedInstance(Context context) {
        NetworkStateHelper networkStateHelper;
        synchronized (NetworkStateHelper.class) {
            if (sSharedInstance == null) {
                sSharedInstance = new NetworkStateHelper(context);
            }
            networkStateHelper = sSharedInstance;
        }
        return networkStateHelper;
    }

    public void reopen() {
        try {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            this.mNetworkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.microsoft.windowsazure.messaging.notificationhubs.NetworkStateHelper.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    NetworkStateHelper.this.onNetworkAvailable(network);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    NetworkStateHelper.this.onNetworkLost(network);
                }
            };
            this.mConnectivityManager.registerNetworkCallback(builder.build(), this.mNetworkCallback);
        } catch (RuntimeException e) {
            Log.e("ANH", "Cannot access network state information.", e);
            this.mConnected.set(true);
        }
    }

    private IntentFilter getOldIntentFilter() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public boolean isNetworkConnected() {
        return this.mConnected.get() || isAnyNetworkConnected();
    }

    private boolean isAnyNetworkConnected() {
        Network[] allNetworks = this.mConnectivityManager.getAllNetworks();
        if (allNetworks == null) {
            return false;
        }
        for (Network network : allNetworks) {
            NetworkInfo networkInfo = this.mConnectivityManager.getNetworkInfo(network);
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetworkAvailable(Network network) {
        Log.d("ANH", "Network " + network + " is available.");
        if (this.mConnected.compareAndSet(false, true)) {
            notifyNetworkStateUpdated(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetworkLost(Network network) {
        Log.d("ANH", "Network " + network + " is lost.");
        Network[] allNetworks = this.mConnectivityManager.getAllNetworks();
        if ((allNetworks == null || allNetworks.length == 0 || Arrays.equals(allNetworks, new Network[]{network})) && this.mConnected.compareAndSet(true, false)) {
            notifyNetworkStateUpdated(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkStateUpdate() {
        boolean isAnyNetworkConnected = isAnyNetworkConnected();
        if (this.mConnected.compareAndSet(!isAnyNetworkConnected, isAnyNetworkConnected)) {
            notifyNetworkStateUpdated(isAnyNetworkConnected);
        }
    }

    private void notifyNetworkStateUpdated(boolean z) {
        Log.d("ANH", "Network has been ".concat(z ? "connected." : "disconnected."));
        Iterator<Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkStateUpdated(z);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mConnected.set(false);
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
    }

    public void addListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public void removeListener(Listener listener) {
        this.mListeners.remove(listener);
    }

    private class ConnectivityReceiver extends BroadcastReceiver {
        private ConnectivityReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkStateHelper.this.handleNetworkStateUpdate();
        }
    }
}
