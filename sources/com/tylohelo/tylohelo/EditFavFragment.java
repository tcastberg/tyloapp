package com.tylohelo.tylohelo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.tylohelo.tylohelo.protobuf.AuxRelay;
import com.tylohelo.tylohelo.protobuf.Favorite;
import com.tylohelo.tylohelo.protobuf.SaunaState;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EditFavFragment extends Fragment {
    public static final int IR_CONSTANT = 101;
    public static final int IR_HIGH_VALUE = 111;
    public static final int IR_LOW_VALUE = 101;
    private static final int MAX_STRING_LEN = 20;
    private static final int ONE_DEGREE_CELSIUS = 9;
    private static final int ONE_DEGREE_FAHRENHEIT = 5;
    private static final int OPERATION_DELAY_FAV = 100;
    private int bathTime;
    private Favorite.Favorite_post favPostSelected;
    private List<Favorite.Favorite_post> favoriteList;
    private boolean isCombiNtc;
    private boolean isHumid;
    private boolean isIr;
    private boolean isLightOn;
    private Integer lowerLimitTemp;
    private SaunaState.Sauna_state_changed.state_t saunaState;
    private Integer selectedFavIndex;
    private int targetHumidity;
    private int targetTemp;
    private Integer tempUnit;
    private String titleChanged;
    private Integer upperLimitTemp;
    private SharedViewModel viewModel;
    private int auxSwitchId = 1;
    private MessageToSaunaSystem messageToSaunaSystem = null;
    private ArrayList<Boolean> auxRelayActiveList = null;
    private Handler counterHandler = null;
    private Runnable counterRunnable = null;

    enum Operation {
        TEMP_PLUS,
        TEMP_MINUS,
        HUMID_PLUS,
        HUMID_MINUS
    }

    static /* synthetic */ void lambda$onClickDelete$14(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$startSauna$16(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ int access$708(EditFavFragment editFavFragment) {
        int i = editFavFragment.targetHumidity;
        editFavFragment.targetHumidity = i + 1;
        return i;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_edit_fav, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        final NavController findNavController = NavHostFragment.findNavController(this);
        this.viewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        this.messageToSaunaSystem = messageToSaunaSystem;
        if (messageToSaunaSystem == null) {
            MessageToSaunaSystem messageToSaunaSystem2 = new MessageToSaunaSystem(requireActivity());
            this.messageToSaunaSystem = messageToSaunaSystem2;
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem2);
        }
        this.viewModel.getFavList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditFavFragment.this.m260lambda$onCreateView$0$comtylohelotyloheloEditFavFragment((List) obj);
            }
        });
        this.viewModel.getSelectedFavIndex().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditFavFragment.this.m262lambda$onCreateView$2$comtylohelotyloheloEditFavFragment(inflate, (Integer) obj);
            }
        });
        this.viewModel.getLowerLimitTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditFavFragment.this.m263lambda$onCreateView$3$comtylohelotyloheloEditFavFragment((Integer) obj);
            }
        });
        this.viewModel.getUpperLimitTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda17
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditFavFragment.this.m264lambda$onCreateView$4$comtylohelotyloheloEditFavFragment((Integer) obj);
            }
        });
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.buttonBackFav);
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.back_button_icon));
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditFavFragment.lambda$onCreateView$5(NavController.this, view);
            }
        });
        MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.buttonDeleteFav);
        materialButton2.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.delete));
        onClickDelete(materialButton2, findNavController);
        onClickSaveButton(inflate, findNavController);
        tempDecrease(inflate);
        tempIncrease(inflate);
        humidDecrease(inflate);
        humidIncrease(inflate);
        MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R.id.buttonStart);
        this.viewModel.getSaunaState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditFavFragment.this.m265lambda$onCreateView$6$comtylohelotyloheloEditFavFragment((SaunaState.Sauna_state_changed.state_t) obj);
            }
        });
        materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditFavFragment.this.m266lambda$onCreateView$7$comtylohelotyloheloEditFavFragment(findNavController, view);
            }
        });
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m260lambda$onCreateView$0$comtylohelotyloheloEditFavFragment(List list) {
        this.favoriteList = list;
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m262lambda$onCreateView$2$comtylohelotyloheloEditFavFragment(final View view, Integer num) {
        this.selectedFavIndex = num;
        if (num != null) {
            displayAux(this.viewModel.getAuxList().getValue(), view);
            setAllProperties(this.selectedFavIndex.intValue(), view);
        }
        this.viewModel.getLocalFavPost().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditFavFragment.this.m261lambda$onCreateView$1$comtylohelotyloheloEditFavFragment(view, (Favorite.Favorite_post) obj);
            }
        });
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m261lambda$onCreateView$1$comtylohelotyloheloEditFavFragment(View view, Favorite.Favorite_post favorite_post) {
        if (favorite_post != null) {
            this.bathTime = favorite_post.getBathTime();
            setFavProperties(view, favorite_post);
        }
    }

    /* renamed from: lambda$onCreateView$3$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m263lambda$onCreateView$3$comtylohelotyloheloEditFavFragment(Integer num) {
        this.lowerLimitTemp = num;
    }

    /* renamed from: lambda$onCreateView$4$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m264lambda$onCreateView$4$comtylohelotyloheloEditFavFragment(Integer num) {
        this.upperLimitTemp = num;
    }

    static /* synthetic */ void lambda$onCreateView$5(NavController navController, View view) {
        try {
            navController.navigate(R.id.action_editFavFragment_to_favoriteFragment3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: lambda$onCreateView$6$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m265lambda$onCreateView$6$comtylohelotyloheloEditFavFragment(SaunaState.Sauna_state_changed.state_t state_tVar) {
        this.saunaState = state_tVar;
    }

    /* renamed from: lambda$onCreateView$7$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m266lambda$onCreateView$7$comtylohelotyloheloEditFavFragment(NavController navController, View view) {
        Integer num = this.selectedFavIndex;
        if (num == null || num.intValue() < 0) {
            return;
        }
        startSauna(this.selectedFavIndex.intValue());
        tyloApplication.setJumpToHomeScreen(true);
        navController.navigate(R.id.action_editFavFragment_to_homeFragment);
    }

    private void displayAux(List<AuxRelay.Aux_relay_post_sauna> list, View view) {
        if (list == null || list.size() == 1) {
            return;
        }
        this.auxSwitchId = 1;
        int i = 0;
        while (i < list.size()) {
            int i2 = i + 1;
            if (((SwitchMaterial) view.findViewById(i2)) == null && list.get(i).hasAuxRelayPost()) {
                if ((list.get(i).getAuxRelayPost().getFunction() != AuxRelay.Aux_relay_post.function_t.FUNC_NOT_USED) & list.get(i).getConnected()) {
                    addAuxSwitch(view, list.get(i).getAuxRelayPost());
                }
            }
            i = i2;
        }
    }

    private void setAllProperties(int i, View view) {
        List<Favorite.Favorite_post> list = this.favoriteList;
        if (list == null || list.isEmpty() || i >= this.favoriteList.size()) {
            return;
        }
        Favorite.Favorite_post favorite_post = this.favoriteList.get(i);
        this.favPostSelected = favorite_post;
        this.bathTime = favorite_post.getBathTime();
        setFavProperties(view, this.favPostSelected);
        int i2 = 0;
        while (i2 < this.auxSwitchId) {
            int i3 = i2 + 1;
            SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(i3);
            if (switchMaterial != null) {
                switchMaterial.setChecked(this.favPostSelected.getAuxiliaryRelayActive(i2));
            }
            i2 = i3;
        }
    }

    private void setFavProperties(View view, Favorite.Favorite_post favorite_post) {
        String valueOf;
        final NavController findNavController = NavHostFragment.findNavController(this);
        if (favorite_post.getValid()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < favorite_post.getNameCount(); i++) {
                sb.append((char) favorite_post.getName(i));
            }
            ((EditText) view.findViewById(R.id.favNameText)).setText(sb);
            onClickTitle(view);
            final TextView textView = (TextView) view.findViewById(R.id.textViewTempValue);
            this.targetTemp = favorite_post.getTemperatureSetPoint();
            this.viewModel.getTemperatureUnit().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFavFragment.this.m269lambda$setFavProperties$8$comtylohelotyloheloEditFavFragment(textView, (Integer) obj);
                }
            });
            HumidityFilter humidityFilter = new HumidityFilter(requireContext(), requireActivity());
            TextView textView2 = (TextView) view.findViewById(R.id.textViewHumidValue);
            TextView textView3 = (TextView) view.findViewById(R.id.textViewHumid);
            Button button = (Button) view.findViewById(R.id.buttonMinusHumid);
            Button button2 = (Button) view.findViewById(R.id.buttonPlusHumid);
            this.isHumid = humidityFilter.showHumidity();
            this.isIr = humidityFilter.showIr();
            boolean showCombiNtc = humidityFilter.showCombiNtc();
            this.isCombiNtc = showCombiNtc;
            if (this.isHumid || this.isIr || showCombiNtc) {
                if (favorite_post.hasHumiditySetPoint()) {
                    this.targetHumidity = favorite_post.getHumiditySetPoint();
                    String valueOf2 = String.valueOf(favorite_post.getHumiditySetPoint());
                    if ((this.isCombiNtc || this.isHumid) && this.targetHumidity > 70) {
                        valueOf = String.valueOf(favorite_post.getHumiditySetPoint() - 101);
                    } else if (this.isHumid) {
                        valueOf = valueOf2 + "%";
                    } else {
                        textView3.setText("IR");
                        valueOf = String.valueOf(favorite_post.getHumiditySetPoint() - 101);
                    }
                    textView2.setText(valueOf);
                }
            } else {
                textView2.setVisibility(8);
                textView3.setVisibility(8);
                button.setVisibility(8);
                button2.setVisibility(8);
            }
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonStopAfter);
            int bathTime = favorite_post.getBathTime();
            SpannableString alignTwoStrings = tyloApplication.alignTwoStrings("Stop after", (bathTime / 60) + "hrs " + (bathTime % 60) + "min");
            materialButton.setAllCaps(false);
            materialButton.setPadding(20, 0, 20, 0);
            materialButton.setText(alignTwoStrings);
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    EditFavFragment.this.m270lambda$setFavProperties$9$comtylohelotyloheloEditFavFragment(findNavController, view2);
                }
            });
            ((SwitchMaterial) view.findViewById(R.id.switchLightning)).setChecked(favorite_post.getLightOn());
            onClickLightSwitch(view);
            for (int i2 = 1; i2 <= this.auxSwitchId; i2++) {
                SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(i2);
                if (switchMaterial != null) {
                    switchMaterial.setChecked(favorite_post.getAuxiliaryRelayActive(i2));
                }
            }
        }
    }

    /* renamed from: lambda$setFavProperties$8$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m269lambda$setFavProperties$8$comtylohelotyloheloEditFavFragment(TextView textView, Integer num) {
        this.tempUnit = num;
        if (num != null) {
            textView.setText(TemperatureFilter.temperatureFilter(num.intValue(), this.targetTemp) + TemperatureFilter.temperatureUnit(num.intValue()));
        }
    }

    /* renamed from: lambda$setFavProperties$9$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m270lambda$setFavProperties$9$comtylohelotyloheloEditFavFragment(NavController navController, View view) {
        this.viewModel.setLocalFavPost(buildFavPost());
        Bundle bundle = new Bundle();
        bundle.putString("sourceFragment", "EditFavFragment");
        navController.navigate(R.id.action_editFavFragment_to_setBathTimeFragment, bundle);
    }

    private void addAuxSwitch(final View view, AuxRelay.Aux_relay_post aux_relay_post) {
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
        if (aux_relay_post.hasIndex()) {
            switchMaterial.setTag(Integer.valueOf(aux_relay_post.getIndex()));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.editFavConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.constrainWidth(switchMaterial.getId(), 0);
        constraintSet.constrainHeight(switchMaterial.getId(), -2);
        constraintSet.connect(switchMaterial.getId(), 6, R.id.switchLightning, 6);
        constraintSet.connect(switchMaterial.getId(), 7, R.id.switchLightning, 7);
        if (this.auxSwitchId == 1) {
            constraintSet.connect(switchMaterial.getId(), 3, R.id.switchLightning, 4);
        } else {
            constraintSet.connect(switchMaterial.getId(), 3, this.auxSwitchId - 1, 4);
        }
        constraintLayout.addView(switchMaterial);
        constraintSet.applyTo(constraintLayout);
        switchMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditFavFragment.this.m255lambda$addAuxSwitch$10$comtylohelotyloheloEditFavFragment(view, switchMaterial, view2);
            }
        });
        this.auxSwitchId++;
    }

    /* renamed from: lambda$addAuxSwitch$10$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m255lambda$addAuxSwitch$10$comtylohelotyloheloEditFavFragment(View view, SwitchMaterial switchMaterial, View view2) {
        ((MaterialButton) view.findViewById(R.id.buttonDeleteFav)).setVisibility(4);
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setVisibility(0);
        ArrayList<Boolean> arrayList = this.auxRelayActiveList;
        if (arrayList != null) {
            arrayList.set(((Integer) switchMaterial.getTag()).intValue(), Boolean.valueOf(switchMaterial.isChecked()));
        } else if (this.favPostSelected != null) {
            ArrayList<Boolean> arrayList2 = new ArrayList<>(this.favPostSelected.getAuxiliaryRelayActiveList());
            this.auxRelayActiveList = arrayList2;
            arrayList2.set(((Integer) switchMaterial.getTag()).intValue(), Boolean.valueOf(switchMaterial.isChecked()));
        }
    }

    private void onClickSaveButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonSave);
        materialButton.setVisibility(4);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditFavFragment.this.m259x1dbe72da(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$11$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m259x1dbe72da(NavController navController, View view) {
        Favorite.Favorite_post buildFavPost = buildFavPost();
        if (this.favoriteList != null) {
            ArrayList arrayList = new ArrayList(this.favoriteList);
            if (arrayList.size() == 1) {
                arrayList.set(0, buildFavPost);
            } else if (arrayList.size() > 1) {
                arrayList.set(buildFavPost.getIndex(), buildFavPost);
            }
            this.viewModel.setFavList(arrayList);
        }
        this.viewModel.setLocalFavPost(null);
        this.messageToSaunaSystem.sendFavorite(buildFavPost);
        navController.navigate(R.id.action_editFavFragment_to_favoriteFragment3);
    }

    private Favorite.Favorite_post buildFavPost() {
        Favorite.Favorite_post.Builder mergeFrom = Favorite.Favorite_post.newBuilder().mergeFrom(this.favPostSelected);
        if (this.titleChanged != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.titleChanged.length(); i++) {
                arrayList.add(Integer.valueOf(Character.codePointAt(this.titleChanged, i)));
            }
            mergeFrom.clearName();
            mergeFrom.addAllName(arrayList);
        }
        mergeFrom.clearTemperatureSetPoint();
        mergeFrom.setTemperatureSetPoint(this.targetTemp);
        if (this.isHumid || this.isIr) {
            mergeFrom.clearHumiditySetPoint();
            mergeFrom.setHumiditySetPoint(this.targetHumidity);
        }
        mergeFrom.clearBathTime();
        mergeFrom.setBathTime(this.bathTime);
        mergeFrom.clearLightOn();
        mergeFrom.setLightOn(this.isLightOn);
        if (this.auxRelayActiveList != null) {
            mergeFrom.clearAuxiliaryRelayActive();
            mergeFrom.addAllAuxiliaryRelayActive(this.auxRelayActiveList);
        }
        return mergeFrom.build();
    }

    private void onClickLightSwitch(final View view) {
        final SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.switchLightning);
        this.isLightOn = switchMaterial.isChecked();
        switchMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditFavFragment.this.m258xea479f78(view, switchMaterial, view2);
            }
        });
    }

    /* renamed from: lambda$onClickLightSwitch$12$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m258xea479f78(View view, SwitchMaterial switchMaterial, View view2) {
        ((MaterialButton) view.findViewById(R.id.buttonDeleteFav)).setVisibility(4);
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setVisibility(0);
        this.isLightOn = switchMaterial.isChecked();
    }

    private void onClickDelete(Button button, final NavController navController) {
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditFavFragment.this.m257lambda$onClickDelete$15$comtylohelotyloheloEditFavFragment(navController, view);
            }
        });
    }

    /* renamed from: lambda$onClickDelete$15$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m257lambda$onClickDelete$15$comtylohelotyloheloEditFavFragment(final NavController navController, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setCancelable(false);
        builder.setMessage("Confirm favorite delete");
        builder.setTitle("Message");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EditFavFragment.this.m256lambda$onClickDelete$13$comtylohelotyloheloEditFavFragment(navController, dialogInterface, i);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EditFavFragment.lambda$onClickDelete$14(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* renamed from: lambda$onClickDelete$13$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m256lambda$onClickDelete$13$comtylohelotyloheloEditFavFragment(NavController navController, DialogInterface dialogInterface, int i) {
        Favorite.Favorite_post favorite_post = this.favPostSelected;
        if (favorite_post != null) {
            int index = favorite_post.getIndex();
            Favorite.Favorite_post.Builder mergeFrom = Favorite.Favorite_post.newBuilder().mergeFrom(this.favPostSelected);
            mergeFrom.clearValid();
            mergeFrom.setValid(false);
            Favorite.Favorite_post build = mergeFrom.build();
            this.messageToSaunaSystem.sendFavorite(build);
            if (this.favoriteList != null) {
                List<Favorite.Favorite_post> arrayList = new ArrayList<>(this.favoriteList);
                if (index < arrayList.size()) {
                    arrayList.set(index, build);
                } else {
                    arrayList = this.viewModel.getFavList().getValue();
                    if (arrayList != null) {
                        arrayList.set(index, build);
                    }
                }
                this.viewModel.setFavList(arrayList);
            }
        }
        navController.navigate(R.id.action_editFavFragment_to_favoriteFragment3);
    }

    private void onClickTitle(final View view) {
        final EditText editText = (EditText) view.findViewById(R.id.favNameText);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.tylohelo.tylohelo.EditFavFragment.1
            final StringBuilder favNamePrevious = new StringBuilder();

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (EditFavFragment.this.favPostSelected != null) {
                    for (int i4 = 0; i4 < EditFavFragment.this.favPostSelected.getNameCount(); i4++) {
                        this.favNamePrevious.append((char) EditFavFragment.this.favPostSelected.getName(i4));
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ((MaterialButton) view.findViewById(R.id.buttonDeleteFav)).setVisibility(4);
                ((MaterialButton) view.findViewById(R.id.buttonSave)).setVisibility(0);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String valueOf = String.valueOf(editText.getText());
                if (valueOf.length() > 20) {
                    valueOf = valueOf.substring(0, 19);
                }
                if (!valueOf.equals(this.favNamePrevious.toString())) {
                    EditFavFragment.this.titleChanged = valueOf;
                } else {
                    EditFavFragment.this.titleChanged = "";
                }
            }
        });
    }

    private void tempDecrease(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonMinusTemp), view, Operation.TEMP_MINUS);
    }

    private void tempIncrease(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonPlusTemp), view, Operation.TEMP_PLUS);
    }

    private void humidDecrease(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonMinusHumid), view, Operation.HUMID_MINUS);
    }

    private void humidIncrease(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonPlusHumid), view, Operation.HUMID_PLUS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int oneDegree() {
        return this.tempUnit.intValue() == 11 ? 5 : 9;
    }

    private void startSauna(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(false);
        SaunaState.Sauna_state_changed.state_t state_tVar = this.saunaState;
        if (state_tVar != null && state_tVar == SaunaState.Sauna_state_changed.state_t.STATE_CLEANUP) {
            builder.setMessage("Sauna can not be interrupted in current mode.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    EditFavFragment.lambda$startSauna$16(dialogInterface, i2);
                }
            }).show();
        } else {
            MessageToSaunaSystem messageToSaunaSystem = this.messageToSaunaSystem;
            if (messageToSaunaSystem != null) {
                messageToSaunaSystem.sendStartFavorite(i);
            }
        }
    }

    class FavSettings {
        FavSettings() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incTemp(View view) {
            int maxHumidity;
            TextView textView = (TextView) view.findViewById(R.id.textViewTempValue);
            ((MaterialButton) view.findViewById(R.id.buttonDeleteFav)).setVisibility(4);
            ((MaterialButton) view.findViewById(R.id.buttonSave)).setVisibility(0);
            EditFavFragment.this.targetTemp += EditFavFragment.this.oneDegree();
            if (EditFavFragment.this.upperLimitTemp != null && EditFavFragment.this.targetTemp > EditFavFragment.this.upperLimitTemp.intValue()) {
                EditFavFragment editFavFragment = EditFavFragment.this;
                editFavFragment.targetTemp = editFavFragment.upperLimitTemp.intValue();
            }
            if (EditFavFragment.this.tempUnit != null) {
                textView.setText(TemperatureFilter.temperatureFilter(EditFavFragment.this.tempUnit.intValue(), EditFavFragment.this.targetTemp) + TemperatureFilter.temperatureUnit(EditFavFragment.this.tempUnit.intValue()));
            }
            if (!EditFavFragment.this.isHumid || EditFavFragment.this.targetHumidity <= (maxHumidity = tyloApplication.getMaxHumidity(EditFavFragment.this.targetTemp))) {
                return;
            }
            EditFavFragment.this.targetHumidity = maxHumidity;
            TextView textView2 = (TextView) view.findViewById(R.id.textViewHumidValue);
            if (textView2 != null) {
                textView2.setText(String.valueOf(EditFavFragment.this.targetHumidity) + "%");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decTemp(View view) {
            ((MaterialButton) view.findViewById(R.id.buttonDeleteFav)).setVisibility(4);
            ((MaterialButton) view.findViewById(R.id.buttonSave)).setVisibility(0);
            TextView textView = (TextView) view.findViewById(R.id.textViewTempValue);
            EditFavFragment.this.targetTemp -= EditFavFragment.this.oneDegree();
            if (EditFavFragment.this.lowerLimitTemp != null && EditFavFragment.this.targetTemp < EditFavFragment.this.lowerLimitTemp.intValue()) {
                EditFavFragment editFavFragment = EditFavFragment.this;
                editFavFragment.targetTemp = editFavFragment.lowerLimitTemp.intValue();
            }
            if (EditFavFragment.this.tempUnit != null) {
                textView.setText(TemperatureFilter.temperatureFilter(EditFavFragment.this.tempUnit.intValue(), EditFavFragment.this.targetTemp) + TemperatureFilter.temperatureUnit(EditFavFragment.this.tempUnit.intValue()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incHumid(View view) {
            String valueOf;
            int maxTemperature;
            ((MaterialButton) view.findViewById(R.id.buttonDeleteFav)).setVisibility(4);
            boolean z = false;
            ((MaterialButton) view.findViewById(R.id.buttonSave)).setVisibility(0);
            TextView textView = (TextView) view.findViewById(R.id.textViewHumidValue);
            if ((!EditFavFragment.this.isCombiNtc && !EditFavFragment.this.isHumid) || EditFavFragment.this.targetHumidity >= 111 || EditFavFragment.this.targetHumidity <= 70) {
                if (!EditFavFragment.this.isHumid || EditFavFragment.this.targetHumidity >= 70) {
                    if (!EditFavFragment.this.isIr || EditFavFragment.this.targetHumidity >= 111) {
                        valueOf = "";
                    } else {
                        EditFavFragment.this.targetHumidity++;
                        valueOf = String.valueOf(EditFavFragment.this.targetHumidity - 101);
                    }
                } else {
                    EditFavFragment.this.targetHumidity++;
                    valueOf = String.valueOf(EditFavFragment.this.targetHumidity);
                }
            } else {
                EditFavFragment.access$708(EditFavFragment.this);
                valueOf = String.valueOf(EditFavFragment.this.targetHumidity - 101);
                z = true;
            }
            if (!EditFavFragment.this.isIr && !EditFavFragment.this.isCombiNtc && !z && !valueOf.equals("")) {
                valueOf = valueOf + "%";
            }
            if (EditFavFragment.this.isHumid && EditFavFragment.this.targetTemp > (maxTemperature = tyloApplication.getMaxTemperature(EditFavFragment.this.targetHumidity))) {
                EditFavFragment.this.targetTemp = maxTemperature;
                if (EditFavFragment.this.upperLimitTemp != null && EditFavFragment.this.targetTemp > EditFavFragment.this.upperLimitTemp.intValue()) {
                    EditFavFragment editFavFragment = EditFavFragment.this;
                    editFavFragment.targetTemp = editFavFragment.upperLimitTemp.intValue();
                }
                TextView textView2 = (TextView) view.findViewById(R.id.textViewTempValue);
                if (EditFavFragment.this.tempUnit != null) {
                    textView2.setText(TemperatureFilter.temperatureFilter(EditFavFragment.this.tempUnit.intValue(), EditFavFragment.this.targetTemp) + TemperatureFilter.temperatureUnit(EditFavFragment.this.tempUnit.intValue()));
                }
            }
            if (valueOf.equals("")) {
                return;
            }
            textView.setText(valueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decHumid(View view) {
            String valueOf;
            ((MaterialButton) view.findViewById(R.id.buttonDeleteFav)).setVisibility(4);
            boolean z = false;
            ((MaterialButton) view.findViewById(R.id.buttonSave)).setVisibility(0);
            TextView textView = (TextView) view.findViewById(R.id.textViewHumidValue);
            if ((EditFavFragment.this.isCombiNtc || EditFavFragment.this.isHumid) && EditFavFragment.this.targetHumidity >= 101) {
                if (EditFavFragment.this.targetHumidity - 101 > 0) {
                    EditFavFragment.this.targetHumidity--;
                }
                valueOf = String.valueOf(EditFavFragment.this.targetHumidity - 101);
                z = true;
            } else if (!EditFavFragment.this.isHumid || EditFavFragment.this.targetHumidity <= 0) {
                if (!EditFavFragment.this.isIr || EditFavFragment.this.targetHumidity <= 101) {
                    valueOf = "";
                } else {
                    EditFavFragment.this.targetHumidity--;
                    valueOf = String.valueOf(EditFavFragment.this.targetHumidity - 101);
                }
            } else {
                EditFavFragment.this.targetHumidity--;
                valueOf = String.valueOf(EditFavFragment.this.targetHumidity);
            }
            if (!EditFavFragment.this.isIr && !EditFavFragment.this.isCombiNtc && !z && !valueOf.equals("")) {
                valueOf = valueOf + "%";
            }
            if (valueOf.equals("")) {
                return;
            }
            textView.setText(valueOf);
        }
    }

    private void pressHold(MaterialButton materialButton, final View view, final Operation operation) {
        final FavSettings favSettings = new FavSettings();
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditFavFragment.this.m267lambda$pressHold$17$comtylohelotyloheloEditFavFragment(operation, favSettings, view, view2);
            }
        });
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.EditFavFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return EditFavFragment.this.m268lambda$pressHold$18$comtylohelotyloheloEditFavFragment(operation, favSettings, view, view2, motionEvent);
            }
        });
    }

    /* renamed from: lambda$pressHold$17$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ void m267lambda$pressHold$17$comtylohelotyloheloEditFavFragment(final Operation operation, final FavSettings favSettings, final View view, View view2) {
        this.counterHandler = new Handler();
        this.counterRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.EditFavFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (operation == Operation.TEMP_PLUS) {
                    favSettings.incTemp(view);
                } else if (operation == Operation.TEMP_MINUS) {
                    favSettings.decTemp(view);
                } else if (operation == Operation.HUMID_PLUS) {
                    favSettings.incHumid(view);
                } else if (operation == Operation.HUMID_MINUS) {
                    favSettings.decHumid(view);
                }
                EditFavFragment.this.counterHandler.postDelayed(this, 100L);
            }
        };
    }

    /* renamed from: lambda$pressHold$18$com-tylohelo-tylohelo-EditFavFragment, reason: not valid java name */
    /* synthetic */ boolean m268lambda$pressHold$18$comtylohelotyloheloEditFavFragment(Operation operation, FavSettings favSettings, View view, View view2, MotionEvent motionEvent) {
        Handler handler;
        Runnable runnable;
        Runnable runnable2;
        if (motionEvent.getAction() == 0) {
            view2.performClick();
            if (operation == Operation.TEMP_PLUS) {
                favSettings.incTemp(view);
            } else if (operation == Operation.TEMP_MINUS) {
                favSettings.decTemp(view);
            } else if (operation == Operation.HUMID_PLUS) {
                favSettings.incHumid(view);
            } else if (operation == Operation.HUMID_MINUS) {
                favSettings.decHumid(view);
            }
            Handler handler2 = this.counterHandler;
            if (handler2 != null && (runnable2 = this.counterRunnable) != null) {
                handler2.postDelayed(runnable2, 100L);
            }
        } else if (motionEvent.getAction() == 1 && (handler = this.counterHandler) != null && (runnable = this.counterRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
        return true;
    }
}
