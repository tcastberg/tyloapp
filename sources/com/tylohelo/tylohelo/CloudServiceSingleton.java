package com.tylohelo.tylohelo;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/* loaded from: classes2.dex */
public class CloudServiceSingleton {
    private final Context ctx;
    private CloudServiceSingleton instance;
    private RequestQueue requestQueue = getRequestQueue();

    public CloudServiceSingleton(Context context) {
        this.ctx = context;
    }

    public synchronized CloudServiceSingleton getInstance(Context context) {
        if (this.instance == null) {
            this.instance = new CloudServiceSingleton(context);
        }
        return this.instance;
    }

    public RequestQueue getRequestQueue() {
        if (this.requestQueue == null) {
            this.requestQueue = Volley.newRequestQueue(this.ctx.getApplicationContext());
        }
        return this.requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}
