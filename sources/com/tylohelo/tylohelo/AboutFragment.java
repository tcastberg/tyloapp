package com.tylohelo.tylohelo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes2.dex */
public class AboutFragment extends Fragment {
    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_about, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(false);
        NavController findNavController = NavHostFragment.findNavController(this);
        SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        ((TextView) inflate.findViewById(R.id.textView10)).setText("App version: 2.0.43");
        sharedViewModel.getFacilityType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.AboutFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AboutFragment.this.m204lambda$onCreateView$0$comtylohelotyloheloAboutFragment(inflate, (Integer) obj);
            }
        });
        onClickBackButton(inflate, findNavController);
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        String currentSaunaId = saunaService.getCurrentSaunaId();
        SaunaModel saunaStored = currentSaunaId != null ? saunaService.getSaunaStored(currentSaunaId) : null;
        if (saunaStored != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.textView14);
            String applicationDescription = saunaStored.getApplicationDescription();
            if (applicationDescription != null) {
                textView.setText("Software: " + applicationDescription);
            }
            ((TextView) inflate.findViewById(R.id.textView13)).setText("System: " + getSystemString());
        }
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-AboutFragment, reason: not valid java name */
    /* synthetic */ void m204lambda$onCreateView$0$comtylohelotyloheloAboutFragment(View view, Integer num) {
        if (num != null) {
            ((TextView) view.findViewById(R.id.textView12)).setText("Facility Type: " + getFacilityType(num.intValue()));
        }
    }

    private String getFacilityType(int i) {
        switch (i) {
            case 20:
                return "Supervised";
            case 21:
                return "Time Controlled";
            case 22:
                return "Private";
            case 23:
                return "Public";
            default:
                return "Unknown";
        }
    }

    private void onClickBackButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.button14);
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.back_button_icon));
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.AboutFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_aboutFragment_to_settingsFragment);
            }
        });
    }

    private String getSystemString() {
        switch (tyloApplication.getProductType()) {
            case 30:
                return "Combi manual";
            case 31:
                return "Combi auto";
            case 32:
                return "Steam private";
            case 33:
                return "Steam private auto";
            case 34:
                return "Steam public";
            case 35:
                return "Steam public/private Manual Empty";
            case 36:
                return "Sauna box addon";
            case 37:
                return "Sauna";
            case 38:
                return "Sauna low";
            case 39:
                return "Sauna IR";
            case 40:
                return "Other";
            default:
                return "";
        }
    }
}
