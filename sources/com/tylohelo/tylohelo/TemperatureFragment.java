package com.tylohelo.tylohelo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.tylohelo.tylohelo.protobuf.AuxRelay;
import com.tylohelo.tylohelo.protobuf.Favorite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class TemperatureFragment extends Fragment {
    public static final int IR_CONSTANT = 101;
    private static final int MAX_NUM_FAV = 8;
    private static final int MAX_STRING_LEN = 20;
    private Integer bathTime;
    private Integer humiditySensorAvailable;
    private boolean lightOn;
    private Integer targetHumid;
    private Integer tempSetPoint;
    private SharedViewModel viewModel;
    private Integer irEnable = 0;
    private List<Favorite.Favorite_post> favoriteList = null;
    private Integer humiditySetPoint = null;
    private int auxSwitchId = 1;
    private int refId = 0;
    private final List<Integer> auxSwitchList = new ArrayList();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_temperature, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(false);
        ((BottomNavigationView) requireActivity().findViewById(R.id.bottomNavigationView)).setVisibility(0);
        this.viewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        final NavController findNavController = NavHostFragment.findNavController(this);
        defaultTempScreen(inflate);
        this.viewModel.getAuxList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m359lambda$onCreateView$0$comtylohelotyloheloTemperatureFragment(inflate, (List) obj);
            }
        });
        this.viewModel.getTargetHumidity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m360lambda$onCreateView$1$comtylohelotyloheloTemperatureFragment(inflate, findNavController, (Integer) obj);
            }
        });
        this.viewModel.getIREnabled().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m361lambda$onCreateView$2$comtylohelotyloheloTemperatureFragment(inflate, findNavController, (Integer) obj);
            }
        });
        this.viewModel.getHumiditySensorAvailable().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m362lambda$onCreateView$3$comtylohelotyloheloTemperatureFragment(inflate, findNavController, (Integer) obj);
            }
        });
        onClickTempButton(inflate, findNavController);
        onClickHumidityButton(inflate, findNavController);
        onClickStopAfterButton(inflate, findNavController);
        onClickSaveAsFavButton(inflate);
        getFavElements(inflate);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.saveAsFavConstraint);
        onClickCloseFav(inflate, constraintLayout);
        onClickSaveFav(inflate, constraintLayout);
        this.viewModel.getLightning().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m363lambda$onCreateView$4$comtylohelotyloheloTemperatureFragment(inflate, (Integer) obj);
            }
        });
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m359lambda$onCreateView$0$comtylohelotyloheloTemperatureFragment(View view, List list) {
        if (!tyloApplication.isConnected(requireActivity(), this.viewModel) || list == null) {
            return;
        }
        displayAux(view, list);
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m360lambda$onCreateView$1$comtylohelotyloheloTemperatureFragment(View view, NavController navController, Integer num) {
        if (tyloApplication.isConnected(requireActivity(), this.viewModel) && num != null) {
            this.humiditySetPoint = num;
            this.targetHumid = num;
            onClickHumidityButton(view, navController);
            return;
        }
        defaultTempScreen(view);
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m361lambda$onCreateView$2$comtylohelotyloheloTemperatureFragment(View view, NavController navController, Integer num) {
        if (tyloApplication.isConnected(requireActivity(), this.viewModel) && num != null) {
            this.irEnable = num;
            onClickHumidityButton(view, navController);
        } else {
            this.irEnable = null;
            defaultTempScreen(view);
        }
    }

    /* renamed from: lambda$onCreateView$3$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m362lambda$onCreateView$3$comtylohelotyloheloTemperatureFragment(View view, NavController navController, Integer num) {
        if (tyloApplication.isConnected(requireActivity(), this.viewModel) && num != null) {
            this.humiditySensorAvailable = num;
            onClickHumidityButton(view, navController);
        } else {
            defaultTempScreen(view);
        }
    }

    /* renamed from: lambda$onCreateView$4$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m363lambda$onCreateView$4$comtylohelotyloheloTemperatureFragment(View view, Integer num) {
        if (tyloApplication.isConnected(requireActivity(), this.viewModel) && num != null) {
            boolean z = num.intValue() == 1;
            this.lightOn = z;
            onClickLightSwitch(view, z);
            return;
        }
        defaultTempScreen(view);
    }

    private void onClickLightSwitch(View view, boolean z) {
        final SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.switchLight);
        switchMaterial.setChecked(z);
        switchMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TemperatureFragment.this.m354xd97ba6c3(switchMaterial, view2);
            }
        });
    }

    /* renamed from: lambda$onClickLightSwitch$5$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m354xd97ba6c3(SwitchMaterial switchMaterial, View view) {
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendLightningState(switchMaterial.isChecked());
    }

    private void onClickTempButton(final View view, final NavController navController) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonTemp);
        this.viewModel.getTargetTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m358x35a7b159(materialButton, view, (Integer) obj);
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_temperatureFragment3_to_editTempFragment);
            }
        });
    }

    /* renamed from: lambda$onClickTempButton$7$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m358x35a7b159(final MaterialButton materialButton, View view, final Integer num) {
        if (num != null) {
            this.viewModel.getTemperatureUnit().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda18
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TemperatureFragment.this.m357x50664298(num, materialButton, (Integer) obj);
                }
            });
        } else {
            defaultTempScreen(view);
        }
    }

    /* renamed from: lambda$onClickTempButton$6$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m357x50664298(Integer num, MaterialButton materialButton, Integer num2) {
        if (num2 == null || !tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            return;
        }
        SpannableString alignTwoStrings = tyloApplication.alignTwoStrings("Temperature", TemperatureFilter.temperatureFilter(num2.intValue(), num.intValue()) + TemperatureFilter.temperatureUnit(num2.intValue()));
        materialButton.setAllCaps(false);
        materialButton.setPadding(20, 0, 20, 0);
        materialButton.setText(alignTwoStrings);
    }

    private void onClickHumidityButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonHumidity);
        HumidityFilter humidityFilter = new HumidityFilter(requireContext(), requireActivity());
        if (!humidityFilter.showHumidity()) {
            materialButton.setVisibility(8);
        } else {
            materialButton.setVisibility(0);
        }
        if (this.targetHumid != null) {
            if (this.humiditySensorAvailable != null && humidityFilter.showHumidity() && this.humiditySensorAvailable.intValue() == 1) {
                SpannableString alignTwoStrings = tyloApplication.alignTwoStrings("Humidity", this.targetHumid + "%");
                materialButton.setAllCaps(false);
                materialButton.setPadding(20, 0, 20, 0);
                materialButton.setText(alignTwoStrings);
                materialButton.setVisibility(0);
            } else {
                Integer num = this.irEnable;
                if (num != null && num.intValue() == 1) {
                    SpannableString alignTwoStrings2 = tyloApplication.alignTwoStrings("IR", String.valueOf(this.targetHumid.intValue() - 101));
                    materialButton.setAllCaps(false);
                    materialButton.setPadding(20, 0, 20, 0);
                    materialButton.setText(alignTwoStrings2);
                    materialButton.setVisibility(0);
                } else if (tyloApplication.getProductType() == 30) {
                    SpannableString alignTwoStrings3 = tyloApplication.alignTwoStrings("Humidity", String.valueOf(this.targetHumid.intValue() - 101));
                    materialButton.setAllCaps(false);
                    materialButton.setPadding(20, 0, 20, 0);
                    materialButton.setText(alignTwoStrings3);
                    materialButton.setVisibility(0);
                } else {
                    materialButton.setVisibility(8);
                }
            }
        } else {
            defaultTempScreen(view);
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TemperatureFragment.this.m353xa0427bfa(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickHumidityButton$9$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m353xa0427bfa(NavController navController, View view) {
        Integer num = this.irEnable;
        if (num != null && num.intValue() == 1) {
            navController.navigate(R.id.action_temperatureFragment3_to_editIRFragment);
        } else {
            navController.navigate(R.id.action_temperatureFragment3_to_editHumidityFragment);
        }
    }

    private void onClickStopAfterButton(final View view, final NavController navController) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonStopAfter);
        this.viewModel.getBathTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m356x62ca7297(materialButton, view, (Integer) obj);
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_temperatureFragment3_to_setBathTimeFragment);
            }
        });
    }

    /* renamed from: lambda$onClickStopAfterButton$10$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m356x62ca7297(MaterialButton materialButton, View view, Integer num) {
        if (num == null || !tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            defaultTempScreen(view);
            return;
        }
        SpannableString alignTwoStrings = tyloApplication.alignTwoStrings("Stop after", (num.intValue() / 60) + "hrs " + (num.intValue() % 60) + "min");
        materialButton.setAllCaps(false);
        materialButton.setPadding(20, 0, 20, 0);
        materialButton.setText(alignTwoStrings);
        materialButton.setVisibility(0);
    }

    private void onClickSaveAsFavButton(View view) {
        Button button = (Button) view.findViewById(R.id.buttonSaveFav);
        final ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.saveAsFavConstraint);
        constraintLayout.setVisibility(8);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConstraintLayout.this.setVisibility(0);
            }
        });
    }

    private void onClickCloseFav(View view, final ConstraintLayout constraintLayout) {
        Button button = (Button) view.findViewById(R.id.buttonClose);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.top_bar_icon_cancel);
        int color = ContextCompat.getColor(requireContext(), R.color.yellow);
        if (drawable != null) {
            drawable.setTint(color);
        }
        button.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConstraintLayout.this.setVisibility(8);
            }
        });
    }

    private void onClickSaveFav(final View view, final ConstraintLayout constraintLayout) {
        ((Button) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TemperatureFragment.this.m355xb0b1a949(view, constraintLayout, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveFav$14$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m355xb0b1a949(View view, ConstraintLayout constraintLayout, View view2) {
        int i;
        boolean z;
        String valueOf = String.valueOf(((EditText) view.findViewById(R.id.favEditText)).getText());
        if (valueOf.length() > 20) {
            valueOf = valueOf.substring(0, 19);
        }
        try {
            ((InputMethodManager) requireActivity().getSystemService("input_method")).hideSoftInputFromWindow(((View) Objects.requireNonNull(requireActivity().getCurrentFocus())).getWindowToken(), 0);
        } catch (Exception e) {
            Log.d("PROFILE KEYBOARD ERROR", e.toString());
        }
        if (this.favoriteList != null) {
            i = 0;
            while (true) {
                if (i >= this.favoriteList.size()) {
                    i = 0;
                    z = false;
                    break;
                } else {
                    if (!this.favoriteList.get(i).getValid()) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (i >= 7 || !z) {
                i = 7;
            }
        } else {
            this.favoriteList = new ArrayList();
            i = 0;
        }
        Favorite.Favorite_post.Builder newBuilder = Favorite.Favorite_post.newBuilder();
        newBuilder.addAllName(UserMessageService.strToArr(valueOf));
        newBuilder.setIndex(i);
        Integer num = this.bathTime;
        if (num != null) {
            newBuilder.setBathTime(num.intValue());
        }
        newBuilder.setLightOn(this.lightOn);
        Integer num2 = this.humiditySetPoint;
        if (num2 != null) {
            newBuilder.setHumiditySetPoint(num2.intValue());
        }
        Integer num3 = this.tempSetPoint;
        if (num3 != null) {
            newBuilder.setTemperatureSetPoint(num3.intValue());
        }
        newBuilder.setValid(true);
        ArrayList arrayList = new ArrayList();
        List<AuxRelay.Aux_relay_post_sauna> value = this.viewModel.getAuxList().getValue();
        if (value != null) {
            for (int i2 = 0; i2 < value.size(); i2++) {
                if (value.get(i2).hasAuxRelayPost()) {
                    if ((value.get(i2).getAuxRelayPost().getFunction() != AuxRelay.Aux_relay_post.function_t.FUNC_NOT_USED) && value.get(i2).getConnected()) {
                        arrayList.add(Boolean.valueOf(value.get(i2).getAuxRelayPost().getActive()));
                    } else {
                        arrayList.add(false);
                    }
                }
            }
        }
        newBuilder.addAllAuxiliaryRelayActive(arrayList);
        Favorite.Favorite_post build = newBuilder.build();
        ArrayList arrayList2 = new ArrayList(this.favoriteList);
        if (arrayList2.size() > 0 && build.getIndex() < arrayList2.size()) {
            arrayList2.set(build.getIndex(), build);
            this.viewModel.setFavList(arrayList2);
        }
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendFavorite(build);
        constraintLayout.setVisibility(8);
    }

    private void getFavElements(final View view) {
        this.viewModel.getFavList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m350x6a95dca3(view, (List) obj);
            }
        });
        this.viewModel.getBathTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m351x4fd74b64(view, (Integer) obj);
            }
        });
        this.viewModel.getTargetTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TemperatureFragment.this.m352x3518ba25(view, (Integer) obj);
            }
        });
    }

    /* renamed from: lambda$getFavElements$15$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m350x6a95dca3(View view, List list) {
        if (list == null || !tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            defaultTempScreen(view);
        } else {
            this.favoriteList = list;
        }
    }

    /* renamed from: lambda$getFavElements$16$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m351x4fd74b64(View view, Integer num) {
        if (num == null || !tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            defaultTempScreen(view);
        } else {
            this.bathTime = num;
        }
    }

    /* renamed from: lambda$getFavElements$17$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m352x3518ba25(View view, Integer num) {
        if (num == null || !tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            defaultTempScreen(view);
        } else {
            this.tempSetPoint = num;
        }
    }

    private void displayAux(View view, List<AuxRelay.Aux_relay_post_sauna> list) {
        this.auxSwitchId = 1;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).hasAuxRelayPost()) {
                    int index = list.get(i).getAuxRelayPost().getIndex();
                    if ((list.get(i).getAuxRelayPost().getFunction() != AuxRelay.Aux_relay_post.function_t.FUNC_NOT_USED) & list.get(i).getConnected()) {
                        if (!this.auxSwitchList.contains(Integer.valueOf(index))) {
                            addAuxSwitch(view, list.get(i).getAuxRelayPost());
                            this.auxSwitchList.add(Integer.valueOf(index));
                        } else {
                            SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewWithTag(Integer.valueOf(index));
                            if (switchMaterial != null) {
                                if (switchMaterial.isChecked() != list.get(i).getAuxRelayPost().getActive()) {
                                    switchMaterial.setChecked(list.get(i).getAuxRelayPost().getActive());
                                }
                            } else {
                                addAuxSwitch(view, list.get(i).getAuxRelayPost());
                            }
                        }
                    } else if (this.auxSwitchList.contains(Integer.valueOf(index))) {
                        boolean z = this.auxSwitchList.indexOf(Integer.valueOf(index)) == this.auxSwitchList.size() - 1;
                        this.auxSwitchList.remove(Integer.valueOf(index));
                        removeAux(view, index, z);
                    }
                }
            }
        }
    }

    private void removeAux(View view, int i, boolean z) {
        View findViewWithTag = view.findViewWithTag(Integer.valueOf(i));
        if (this.refId == findViewWithTag.getId()) {
            List<Integer> list = this.auxSwitchList;
            this.refId = view.findViewWithTag(Integer.valueOf(list.get(list.size() - 1).intValue())).getId();
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.tempConstraint);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintLayout.removeView(findViewWithTag);
        if (!z) {
            this.refId = 0;
            Iterator<Integer> it = this.auxSwitchList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                View findViewWithTag2 = view.findViewWithTag(Integer.valueOf(intValue));
                if (findViewWithTag2 != null) {
                    int id = findViewWithTag2.getId();
                    if (this.auxSwitchList.indexOf(Integer.valueOf(intValue)) == 0 || this.auxSwitchList.size() == 1) {
                        constraintSet.connect(id, 3, R.id.switchLight, 4);
                        this.refId = findViewWithTag2.getId();
                    } else {
                        int i2 = this.refId;
                        if (i2 != 0) {
                            constraintSet.connect(id, 3, i2, 4);
                            this.refId = findViewWithTag2.getId();
                        }
                    }
                }
            }
        }
        constraintSet.applyTo(constraintLayout);
    }

    private void addAuxSwitch(View view, AuxRelay.Aux_relay_post aux_relay_post) {
        final SwitchMaterial switchMaterial = new SwitchMaterial(requireContext());
        switchMaterial.setId(this.auxSwitchId);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aux_relay_post.getNameCount(); i++) {
            sb.append((char) aux_relay_post.getName(i));
        }
        if (sb.toString().isEmpty()) {
            sb.append("Aux ");
            sb.append(aux_relay_post.getIndex());
        }
        switchMaterial.setText(sb);
        switchMaterial.setTextColor(Color.parseColor("#FFFFFFFF"));
        if (aux_relay_post.hasActive()) {
            switchMaterial.setChecked(aux_relay_post.getActive());
        }
        if (aux_relay_post.hasIndex()) {
            switchMaterial.setTag(Integer.valueOf(aux_relay_post.getIndex()));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.tempConstraint);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.constrainWidth(switchMaterial.getId(), 0);
        constraintSet.constrainHeight(switchMaterial.getId(), -2);
        constraintSet.connect(switchMaterial.getId(), 6, R.id.switchLight, 6);
        constraintSet.connect(switchMaterial.getId(), 7, R.id.switchLight, 7);
        if (this.auxSwitchId == 1) {
            constraintSet.connect(switchMaterial.getId(), 3, R.id.switchLight, 4);
        } else {
            constraintSet.connect(switchMaterial.getId(), 3, this.refId, 4);
        }
        this.auxSwitchId++;
        this.refId = switchMaterial.getId();
        constraintLayout.addView(switchMaterial);
        constraintSet.applyTo(constraintLayout);
        switchMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.TemperatureFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TemperatureFragment.this.m349lambda$addAuxSwitch$18$comtylohelotyloheloTemperatureFragment(switchMaterial, view2);
            }
        });
    }

    /* renamed from: lambda$addAuxSwitch$18$com-tylohelo-tylohelo-TemperatureFragment, reason: not valid java name */
    /* synthetic */ void m349lambda$addAuxSwitch$18$comtylohelotyloheloTemperatureFragment(SwitchMaterial switchMaterial, View view) {
        int intValue = ((Integer) switchMaterial.getTag()).intValue();
        List<AuxRelay.Aux_relay_post_sauna> value = this.viewModel.getAuxList().getValue();
        if (value != null && intValue < value.size()) {
            AuxRelay.Aux_relay_post auxRelayPost = value.get(intValue).getAuxRelayPost();
            AuxRelay.Aux_relay_post_sauna aux_relay_post_sauna = value.get(intValue);
            AuxRelay.Aux_relay_post.Builder newBuilder = AuxRelay.Aux_relay_post.newBuilder();
            newBuilder.mergeFrom(auxRelayPost);
            newBuilder.setActive(switchMaterial.isChecked());
            AuxRelay.Aux_relay_post build = newBuilder.build();
            AuxRelay.Aux_relay_post_sauna.Builder newBuilder2 = AuxRelay.Aux_relay_post_sauna.newBuilder();
            newBuilder2.mergeFrom(aux_relay_post_sauna);
            newBuilder2.setAuxRelayPost(build);
            try {
                value.set(intValue, newBuilder2.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AuxRelay.Aux_relay_post.Builder newBuilder3 = AuxRelay.Aux_relay_post.newBuilder();
        newBuilder3.setActive(switchMaterial.isChecked());
        newBuilder3.setIndex(intValue);
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendAuxRelayPost(newBuilder3.build());
    }

    private void defaultTempScreen(View view) {
        ((MaterialButton) view.findViewById(R.id.buttonTemp)).setVisibility(0);
        ((MaterialButton) view.findViewById(R.id.buttonHumidity)).setVisibility(8);
        ((MaterialButton) view.findViewById(R.id.buttonStopAfter)).setVisibility(0);
        ((Button) view.findViewById(R.id.buttonSaveFav)).setVisibility(0);
        SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.switchLight);
        switchMaterial.setVisibility(0);
        switchMaterial.setChecked(false);
        if (tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            displayAux(view, this.viewModel.getAuxList().getValue());
        }
    }
}
