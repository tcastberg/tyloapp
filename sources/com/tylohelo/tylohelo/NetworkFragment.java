package com.tylohelo.tylohelo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public class NetworkFragment extends Fragment implements BackPressedListener {
    public static BackPressedListener backPressedListener;
    private SharedViewModel viewModel;
    private int saunaButtonId = 1;
    private final int START_ID = 1000;
    private int dButtonId = 1000;
    private final List<Integer> saunaButtonIds = new ArrayList();
    private final List<Integer> deleteButtonIds = new ArrayList();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_network, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        final NavController findNavController = NavHostFragment.findNavController(this);
        setNetworkTypeCloud(inflate);
        onClickBackButton(inflate, findNavController);
        onClickAddSystemButton(inflate, findNavController);
        animBottomNavigation();
        onClickNetworkButton(inflate, findNavController);
        createSaunaList(inflate, findNavController);
        SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        this.viewModel = sharedViewModel;
        sharedViewModel.getIsSaunaListUpdated().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NetworkFragment.this.m322lambda$onCreateView$0$comtylohelotyloheloNetworkFragment(inflate, findNavController, (Boolean) obj);
            }
        });
        this.viewModel.getIsSaunaUpdated().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NetworkFragment.this.m323lambda$onCreateView$1$comtylohelotyloheloNetworkFragment(inflate, (Boolean) obj);
            }
        });
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-NetworkFragment, reason: not valid java name */
    /* synthetic */ void m322lambda$onCreateView$0$comtylohelotyloheloNetworkFragment(View view, NavController navController, Boolean bool) {
        if (bool.booleanValue()) {
            removeButtons(view);
            createSaunaList(view, navController);
        }
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-NetworkFragment, reason: not valid java name */
    /* synthetic */ void m323lambda$onCreateView$1$comtylohelotyloheloNetworkFragment(View view, Boolean bool) {
        SaunaModel saunaStored;
        MaterialButton materialButton;
        if (bool.booleanValue()) {
            SaunaService saunaService = tyloApplication.getSaunaService();
            if (saunaService == null) {
                saunaService = new SaunaService(getActivity());
                tyloApplication.setSaunaService(saunaService);
            }
            String currentSaunaId = saunaService.getCurrentSaunaId();
            if (currentSaunaId == null || (saunaStored = saunaService.getSaunaStored(currentSaunaId)) == null || (materialButton = (MaterialButton) view.findViewWithTag(currentSaunaId)) == null) {
                return;
            }
            if (saunaStored.isConnected() && saunaStored.getAPIKey() != null) {
                int i = 0;
                while (i < this.saunaButtonId) {
                    i++;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
                    if (materialButton2 != null) {
                        materialButton2.setIcon(null);
                    }
                }
                materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
                return;
            }
            materialButton.setIcon(null);
        }
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
            NavHostFragment.findNavController(this).navigate(R.id.action_networkFragment_to_settingsFragment2);
            backPressedListener = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createSaunaList(final View view, final NavController navController) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        final HashMap<String, SaunaModel> saunaListStored = saunaService.getSaunaListStored();
        if (saunaListStored != null) {
            this.saunaButtonId = 1;
            this.dButtonId = 1000;
            this.saunaButtonIds.clear();
            this.deleteButtonIds.clear();
            saunaListStored.forEach(new BiConsumer() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    NetworkFragment.this.m318lambda$createSaunaList$2$comtylohelotyloheloNetworkFragment(saunaListStored, view, navController, (String) obj, (SaunaModel) obj2);
                }
            });
        }
    }

    /* renamed from: lambda$createSaunaList$2$com-tylohelo-tylohelo-NetworkFragment, reason: not valid java name */
    /* synthetic */ void m318lambda$createSaunaList$2$comtylohelotyloheloNetworkFragment(HashMap hashMap, View view, NavController navController, String str, SaunaModel saunaModel) {
        Gson gson = new Gson();
        SaunaModel saunaModel2 = (SaunaModel) gson.fromJson(gson.toJson(hashMap.get(str)), SaunaModel.class);
        if (saunaModel2.getAPIKey() == null || ((MaterialButton) view.findViewWithTag(saunaModel2.getSystemId())) != null) {
            return;
        }
        addSaunaButton(view, saunaModel2, navController);
    }

    private void removeButtons(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.networkConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        Iterator<Integer> it = this.saunaButtonIds.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            constraintSet.clear(intValue, 3);
            View viewById = constraintLayout.getViewById(intValue);
            if (viewById != null) {
                constraintLayout.removeView(viewById);
                if (this.saunaButtonIds.indexOf(Integer.valueOf(intValue)) == 0) {
                    constraintSet.connect(viewById.getId(), 3, R.id.textView15, 4);
                    i = viewById.getId();
                } else if (i != 0) {
                    constraintSet.connect(viewById.getId(), 3, i, 4);
                    i = viewById.getId();
                }
                constraintSet.applyTo(constraintLayout);
            }
        }
        Iterator<Integer> it2 = this.deleteButtonIds.iterator();
        while (it2.hasNext()) {
            int intValue2 = it2.next().intValue();
            constraintSet.clear(intValue2, 3);
            View viewById2 = constraintLayout.getViewById(intValue2);
            if (viewById2 != null) {
                constraintLayout.removeView(viewById2);
                if (this.deleteButtonIds.indexOf(Integer.valueOf(intValue2)) == 0) {
                    constraintSet.connect(viewById2.getId(), 3, R.id.textView15, 4);
                    i = viewById2.getId();
                } else if (i != 0) {
                    constraintSet.connect(viewById2.getId(), 3, i, 4);
                    i = viewById2.getId();
                }
                constraintSet.applyTo(constraintLayout);
            }
        }
        this.saunaButtonIds.clear();
        this.deleteButtonIds.clear();
        this.saunaButtonId = 1;
        this.dButtonId = 1000;
    }

    private void setNetworkTypeCloud(View view) {
        Button button = (Button) view.findViewById(R.id.button8);
        button.setText(tyloApplication.alignTwoStrings(button.getText().toString(), "Cloud"));
    }

    private void animBottomNavigation() {
        getResources().getInteger(android.R.integer.config_shortAnimTime);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) requireActivity().findViewById(R.id.bottomNavigationView);
        bottomNavigationView.animate().alpha(0.0f).setDuration(1000L).setListener(new AnimatorListenerAdapter() { // from class: com.tylohelo.tylohelo.NetworkFragment.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                bottomNavigationView.setVisibility(8);
            }
        });
    }

    private void onClickNetworkButton(View view, final NavController navController) {
        ((Button) view.findViewById(R.id.button8)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_networkFragment_to_networkTypeFragment);
            }
        });
    }

    private void onClickAddSystemButton(View view, final NavController navController) {
        ((Button) view.findViewById(R.id.button10)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_networkFragment_to_addSystemFragment);
            }
        });
    }

    private void onClickBackButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.button9);
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.back_button_icon));
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_networkFragment_to_settingsFragment2);
            }
        });
    }

    private void addSaunaButton(View view, SaunaModel saunaModel, NavController navController) {
        MaterialButton materialButton = new MaterialButton(requireContext());
        materialButton.setId(this.saunaButtonId);
        this.saunaButtonIds.add(Integer.valueOf(this.saunaButtonId));
        materialButton.setTextAlignment(5);
        materialButton.setBackgroundColor(Color.parseColor("#434343"));
        materialButton.setTextColor(Color.parseColor("#FDFCFC"));
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        String currentSaunaId = saunaService.getCurrentSaunaId();
        if (currentSaunaId != null && currentSaunaId.equals(saunaModel.getSystemId()) && saunaModel.isConnected() && saunaModel.getAPIKey() != null) {
            materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        } else {
            materialButton.setIcon(null);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.networkConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.constrainWidth(materialButton.getId(), 0);
        constraintSet.constrainHeight(materialButton.getId(), -2);
        constraintSet.connect(materialButton.getId(), 6, R.id.textView15, 6);
        constraintSet.connect(materialButton.getId(), 7, R.id.textView15, 7);
        if (this.saunaButtonId == 1) {
            constraintSet.connect(materialButton.getId(), 3, R.id.textView15, 4);
        } else {
            constraintSet.connect(materialButton.getId(), 3, this.saunaButtonId - 1, 4);
        }
        this.saunaButtonId++;
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(R.drawable.delete);
        imageButton.setId(this.dButtonId);
        this.deleteButtonIds.add(Integer.valueOf(this.dButtonId));
        imageButton.setBackgroundColor(Color.parseColor("#434343"));
        imageButton.setColorFilter(Color.parseColor("#FDFCFC"));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, 55);
        layoutParams.setMarginStart(47);
        layoutParams.endToEnd = materialButton.getId();
        layoutParams.topToTop = materialButton.getId();
        layoutParams.bottomToBottom = materialButton.getId();
        imageButton.setLayoutParams(layoutParams);
        imageButton.setElevation(20.0f);
        if (!saunaModel.getSystemName().isEmpty()) {
            materialButton.setText(saunaModel.getSystemName());
        }
        if (!saunaModel.getSystemId().isEmpty()) {
            materialButton.setTag(saunaModel.getSystemId());
            imageButton.setTag(Integer.valueOf(materialButton.getId()));
            constraintLayout.addView(materialButton);
            constraintLayout.addView(imageButton);
            constraintSet.applyTo(constraintLayout);
            this.dButtonId++;
        }
        onClickSaunaButton(view);
        onClickDeleteButton(view, navController);
    }

    private void onClickSaunaButton(final View view) {
        int i = 0;
        while (i < this.saunaButtonId) {
            i++;
            final MaterialButton materialButton = (MaterialButton) view.findViewById(i);
            if (materialButton != null) {
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NetworkFragment.this.m321xc4423a00(view, materialButton, view2);
                    }
                });
            }
        }
    }

    /* renamed from: lambda$onClickSaunaButton$6$com-tylohelo-tylohelo-NetworkFragment, reason: not valid java name */
    /* synthetic */ void m321xc4423a00(View view, MaterialButton materialButton, View view2) {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        int i = 0;
        while (i < this.saunaButtonId) {
            i++;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
            if (materialButton2 != null) {
                materialButton2.setIcon(null);
                SaunaModel saunaStored = saunaService.getSaunaStored((String) materialButton2.getTag());
                if (saunaStored != null) {
                    saunaStored.setConnected(false);
                    saunaService.storeSauna(saunaStored);
                    this.viewModel.setIsSaunaUpdated(true);
                }
            }
        }
        this.viewModel.resetViewModelData();
        saunaService.setCurrentSaunaId(null);
        if (saunaService.getCloudEnabled()) {
            String str = (String) materialButton.getTag();
            ComService comService = tyloApplication.getComService();
            if (comService != null) {
                comService.close();
                comService.connect(str);
            }
        }
    }

    private void onClickDeleteButton(final View view, final NavController navController) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(false);
        int i = 999;
        while (i < this.dButtonId) {
            int i2 = i + 1;
            final ImageButton imageButton = (ImageButton) view.findViewById(i2);
            if (imageButton != null) {
                imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NetworkFragment.this.m320xb42e2c6b(imageButton, view, navController, builder, view2);
                    }
                });
            }
            i = i2;
        }
    }

    /* renamed from: lambda$onClickDeleteButton$8$com-tylohelo-tylohelo-NetworkFragment, reason: not valid java name */
    /* synthetic */ void m320xb42e2c6b(final ImageButton imageButton, final View view, final NavController navController, AlertDialog.Builder builder, View view2) {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NetworkFragment.this.m319xeb2d352a(imageButton, view, navController, dialogInterface, i);
            }
        };
        builder.setMessage("The system will be removed from both Wifi and Cloud, do you want to remove this system!").setPositiveButton("Yes", onClickListener).setNegativeButton("No", onClickListener).show();
    }

    /* renamed from: lambda$onClickDeleteButton$7$com-tylohelo-tylohelo-NetworkFragment, reason: not valid java name */
    /* synthetic */ void m319xeb2d352a(ImageButton imageButton, View view, NavController navController, DialogInterface dialogInterface, int i) {
        MaterialButton materialButton;
        if (i == -1 && (materialButton = (MaterialButton) view.findViewById(((Integer) imageButton.getTag()).intValue())) != null) {
            SaunaService saunaService = tyloApplication.getSaunaService();
            if (saunaService == null) {
                saunaService = new SaunaService(getActivity());
                tyloApplication.setSaunaService(saunaService);
            }
            String obj = materialButton.getTag().toString();
            SaunaModel saunaStored = saunaService.getSaunaStored(obj);
            saunaStored.setAPIKey(null);
            saunaService.storeSauna(saunaStored);
            this.viewModel.setIsSaunaUpdated(true);
            saunaService.removeSauna(obj);
            String currentSaunaId = saunaService.getCurrentSaunaId();
            if (currentSaunaId != null && obj.equals(currentSaunaId)) {
                saunaService.setCurrentSaunaId(null);
                ComService comService = tyloApplication.getComService();
                if (comService != null) {
                    comService.close();
                }
            }
            this.viewModel.setIsSaunaListUpdated(true);
            FirebaseService.unregisterSaunas();
            navController.navigate(R.id.action_networkFragment_self);
        }
    }
}
