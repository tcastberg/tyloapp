package com.tylohelo.tylohelo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.tylohelo.tylohelo.R;

/* loaded from: classes2.dex */
public abstract class ActivityMainBinding extends ViewDataBinding {
    public final BottomNavigationView bottomNavigationView;
    public final MaterialButton buttonOff;
    public final MaterialButton buttonOn;
    public final MaterialButton buttonStandby;
    public final FrameLayout frameLayout;
    public final ImageView imageViewCloud;
    public final ImageView imageViewLogo;
    public final ImageView imageViewWifi;
    public final FragmentContainerView navHostFragment;
    public final LinearLayout topBarLayout;

    protected ActivityMainBinding(Object obj, View view, int i, BottomNavigationView bottomNavigationView, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, FragmentContainerView fragmentContainerView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.bottomNavigationView = bottomNavigationView;
        this.buttonOff = materialButton;
        this.buttonOn = materialButton2;
        this.buttonStandby = materialButton3;
        this.frameLayout = frameLayout;
        this.imageViewCloud = imageView;
        this.imageViewLogo = imageView2;
        this.imageViewWifi = imageView3;
        this.navHostFragment = fragmentContainerView;
        this.topBarLayout = linearLayout;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, viewGroup, z, obj);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, null, false, obj);
    }

    public static ActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object obj) {
        return (ActivityMainBinding) bind(obj, view, R.layout.activity_main);
    }
}
