package com.tylohelo.tylohelo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;
import com.tylohelo.tylohelo.tyloApplication;

/* loaded from: classes2.dex */
public class NetworkTypeFragment extends Fragment implements BackPressedListener {
    public static BackPressedListener backPressedListener;
    private SharedViewModel viewModel;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_network_type, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        NavController findNavController = NavHostFragment.findNavController(this);
        this.viewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.button13);
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.back_button_icon));
        MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.button11);
        MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R.id.button12);
        onClickWifiButton(materialButton3, materialButton2);
        onClickCloudButton(materialButton3, materialButton2);
        onClickBackButton(findNavController, materialButton);
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        if (saunaService.getCloudEnabled()) {
            materialButton2.setIcon(null);
            materialButton3.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        } else {
            materialButton3.setIcon(null);
            materialButton2.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        }
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
        NavController findNavController = NavHostFragment.findNavController(this);
        try {
            SaunaService saunaService = tyloApplication.getSaunaService();
            if (saunaService == null) {
                saunaService = new SaunaService(getActivity());
                tyloApplication.setSaunaService(saunaService);
            }
            if (saunaService.getCloudEnabled()) {
                findNavController.navigate(R.id.action_networkTypeFragment_to_networkFragment);
            } else {
                findNavController.navigate(R.id.action_networkTypeFragment_to_networkWifiFragment);
            }
            backPressedListener = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onClickWifiButton(final MaterialButton materialButton, final MaterialButton materialButton2) {
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkTypeFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetworkTypeFragment.this.m326x30806027(materialButton, materialButton2, view);
            }
        });
    }

    /* renamed from: lambda$onClickWifiButton$0$com-tylohelo-tylohelo-NetworkTypeFragment, reason: not valid java name */
    /* synthetic */ void m326x30806027(MaterialButton materialButton, MaterialButton materialButton2, View view) {
        materialButton.setIcon(null);
        materialButton2.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        tyloApplication.setNetworkType(tyloApplication.networkType_t.NETWORK_NONE);
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        saunaService.setCloudEnabled(0);
        ComService comService = tyloApplication.getComService();
        if (comService != null) {
            comService.close();
        }
        ((MainActivity) requireActivity()).resetSauna();
        this.viewModel.resetViewModelData();
        this.viewModel.setCloudOnline(false);
        saunaService.setCurrentSaunaId(null);
        ((MainActivity) requireActivity()).listenForSaunas(null, (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class), saunaService);
    }

    private void onClickCloudButton(final MaterialButton materialButton, final MaterialButton materialButton2) {
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkTypeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetworkTypeFragment.this.m325x3bd15730(materialButton2, materialButton, view);
            }
        });
    }

    /* renamed from: lambda$onClickCloudButton$1$com-tylohelo-tylohelo-NetworkTypeFragment, reason: not valid java name */
    /* synthetic */ void m325x3bd15730(MaterialButton materialButton, MaterialButton materialButton2, View view) {
        ComService comService;
        materialButton.setIcon(null);
        materialButton2.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        tyloApplication.setNetworkType(tyloApplication.networkType_t.NETWORK_NONE);
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        saunaService.setCloudEnabled(1);
        this.viewModel.resetViewModelData();
        ((MainActivity) requireActivity()).resetSauna();
        ((MainActivity) requireActivity()).stopListening();
        this.viewModel.setWifiOnline(false);
        WifiService.stopKeepAlive();
        String currentSaunaId = saunaService.getCurrentSaunaId();
        if (currentSaunaId == null || (comService = tyloApplication.getComService()) == null) {
            return;
        }
        comService.connect(currentSaunaId);
    }

    private void onClickBackButton(final NavController navController, MaterialButton materialButton) {
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkTypeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetworkTypeFragment.this.m324x6a78bafb(navController, view);
            }
        });
    }

    /* renamed from: lambda$onClickBackButton$2$com-tylohelo-tylohelo-NetworkTypeFragment, reason: not valid java name */
    /* synthetic */ void m324x6a78bafb(NavController navController, View view) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        if (saunaService.getCloudEnabled()) {
            navController.navigate(R.id.action_networkTypeFragment_to_networkFragment);
        } else {
            navController.navigate(R.id.action_networkTypeFragment_to_networkWifiFragment);
        }
    }
}
