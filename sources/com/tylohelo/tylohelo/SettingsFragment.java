package com.tylohelo.tylohelo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* loaded from: classes2.dex */
public class SettingsFragment extends Fragment implements BackPressedListener {
    public static BackPressedListener backPressedListener;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(false);
        NavController findNavController = NavHostFragment.findNavController(this);
        onClickNetworkButton(inflate, findNavController);
        animBottomNavigation();
        onClickAboutButton(inflate, findNavController);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        backPressedListener = null;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        backPressedListener = null;
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        backPressedListener = this;
    }

    @Override // com.tylohelo.tylohelo.BackPressedListener
    public void onBackPressed() {
        try {
            NavHostFragment.findNavController(this).navigate(R.id.action_settingsFragment_to_homeFragment2);
            backPressedListener = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onClickAboutButton(View view, final NavController navController) {
        ((Button) view.findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.SettingsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_settingsFragment_to_aboutFragment);
            }
        });
    }

    private void animBottomNavigation() {
        getResources().getInteger(android.R.integer.config_shortAnimTime);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) requireActivity().findViewById(R.id.bottomNavigationView);
        bottomNavigationView.animate().alpha(1.0f).setDuration(800L).setListener(new AnimatorListenerAdapter() { // from class: com.tylohelo.tylohelo.SettingsFragment.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                bottomNavigationView.setVisibility(0);
            }
        });
    }

    private void onClickNetworkButton(View view, final NavController navController) {
        ((Button) view.findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.SettingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.this.m348x397a9442(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickNetworkButton$1$com-tylohelo-tylohelo-SettingsFragment, reason: not valid java name */
    /* synthetic */ void m348x397a9442(NavController navController, View view) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        if (saunaService.getCloudEnabled()) {
            navController.navigate(R.id.action_settingsFragment_to_networkFragment);
        } else {
            navController.navigate(R.id.action_settingsFragment_to_networkWifiFragment);
        }
    }
}
