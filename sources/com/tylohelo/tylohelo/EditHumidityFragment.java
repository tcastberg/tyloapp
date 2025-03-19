package com.tylohelo.tylohelo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes2.dex */
public class EditHumidityFragment extends Fragment {
    public static final int HUMIDITY_CONSTANT_NTC = 101;
    public static final int HUMIDITY_MAX_NTC = 10;
    private static final int OPERATION_DELAY_HUMID = 100;
    SharedViewModel viewModel;
    int targetHumidity = 0;
    boolean humidSensorAvailable = false;
    private int count = 0;
    private Handler counterHandler = null;
    private Runnable counterRunnable = null;

    enum Operation {
        HUMID_PLUS,
        HUMID_MINUS
    }

    public static EditHumidityFragment newInstance() {
        EditHumidityFragment editHumidityFragment = new EditHumidityFragment();
        editHumidityFragment.setArguments(new Bundle());
        return editHumidityFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edit_humidity, viewGroup, false);
        NavController findNavController = NavHostFragment.findNavController(this);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        final TextView textView = (TextView) inflate.findViewById(R.id.textViewHumidPercent);
        SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        this.viewModel = sharedViewModel;
        sharedViewModel.getTargetHumidity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditHumidityFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditHumidityFragment.this.m272lambda$onCreateView$0$comtylohelotyloheloEditHumidityFragment(textView, (Integer) obj);
            }
        });
        this.viewModel.getHumiditySensorAvailable().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditHumidityFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditHumidityFragment.this.m273lambda$onCreateView$1$comtylohelotyloheloEditHumidityFragment((Integer) obj);
            }
        });
        onClickCloseButton(inflate, findNavController);
        onClickMinusButton(inflate);
        onClickPlusButton(inflate);
        onClickSaveButton(inflate, findNavController);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-EditHumidityFragment, reason: not valid java name */
    /* synthetic */ void m272lambda$onCreateView$0$comtylohelotyloheloEditHumidityFragment(TextView textView, Integer num) {
        if (num == null || this.count != 0) {
            return;
        }
        textView.setText(tyloApplication.getHumiditySensorMissing() ? (num.intValue() - 101) + "" : num + "%");
        this.targetHumidity = num.intValue();
        this.count++;
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-EditHumidityFragment, reason: not valid java name */
    /* synthetic */ void m273lambda$onCreateView$1$comtylohelotyloheloEditHumidityFragment(Integer num) {
        if (num != null) {
            this.humidSensorAvailable = num.intValue() == 1;
        }
    }

    private void onClickCloseButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonClose);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.top_bar_icon_cancel);
        int color = ContextCompat.getColor(requireContext(), R.color.yellow);
        if (drawable != null) {
            drawable.setTint(color);
        }
        materialButton.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditHumidityFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_editHumidityFragment_to_temperatureFragment3);
            }
        });
    }

    private void onClickSaveButton(View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditHumidityFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditHumidityFragment.this.m271x40c7f9b3(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$3$com-tylohelo-tylohelo-EditHumidityFragment, reason: not valid java name */
    /* synthetic */ void m271x40c7f9b3(NavController navController, View view) {
        this.viewModel.setTargetHumidity(Integer.valueOf(this.targetHumidity));
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendTargetHumidity(this.targetHumidity);
        navController.navigate(R.id.action_editHumidityFragment_to_temperatureFragment3);
    }

    private void onClickMinusButton(View view) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonMinus);
        pressHold(materialButton, (TextView) view.findViewById(R.id.textViewHumidPercent), Operation.HUMID_MINUS);
        materialButton.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), R.drawable.stepper_control_minus_btn), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHumidDisplayed(TextView textView) {
        String valueOf = String.valueOf(textView.getText());
        StringBuilder sb = new StringBuilder();
        for (char c : valueOf.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private void onClickPlusButton(View view) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonPlus);
        pressHold(materialButton, (TextView) view.findViewById(R.id.textViewHumidPercent), Operation.HUMID_PLUS);
        materialButton.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), R.drawable.stepper_control_plus_btn_active), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    class HumidSettings {
        HumidSettings() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incHumid(TextView textView) {
            boolean z = true;
            int humidDisplayed = EditHumidityFragment.this.getHumidDisplayed(textView) + 1;
            if (EditHumidityFragment.this.humidSensorAvailable && EditHumidityFragment.this.targetHumidity < 70) {
                textView.setText(humidDisplayed + "%");
            } else if (tyloApplication.getProductType() == 30) {
                if (humidDisplayed <= 10) {
                    textView.setText(humidDisplayed + "");
                }
                EditHumidityFragment.this.viewModel.getTargetHumidity().removeObservers(EditHumidityFragment.this.requireActivity());
                EditHumidityFragment editHumidityFragment = EditHumidityFragment.this;
                editHumidityFragment.targetHumidity = HumidityFilter.humidityIncrease(editHumidityFragment.targetHumidity, EditHumidityFragment.this.humidSensorAvailable, z);
            }
            z = false;
            EditHumidityFragment.this.viewModel.getTargetHumidity().removeObservers(EditHumidityFragment.this.requireActivity());
            EditHumidityFragment editHumidityFragment2 = EditHumidityFragment.this;
            editHumidityFragment2.targetHumidity = HumidityFilter.humidityIncrease(editHumidityFragment2.targetHumidity, EditHumidityFragment.this.humidSensorAvailable, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decHumid(TextView textView) {
            boolean z = true;
            int humidDisplayed = EditHumidityFragment.this.getHumidDisplayed(textView) - 1;
            if (!EditHumidityFragment.this.humidSensorAvailable || EditHumidityFragment.this.targetHumidity <= 0) {
                if (tyloApplication.getProductType() == 30) {
                    if (humidDisplayed >= 0) {
                        textView.setText(humidDisplayed + "");
                    }
                    EditHumidityFragment.this.viewModel.getTargetHumidity().removeObservers(EditHumidityFragment.this.requireActivity());
                    EditHumidityFragment editHumidityFragment = EditHumidityFragment.this;
                    editHumidityFragment.targetHumidity = HumidityFilter.humidityDecrease(editHumidityFragment.targetHumidity, EditHumidityFragment.this.humidSensorAvailable, z);
                }
            } else if (humidDisplayed >= 0) {
                textView.setText(humidDisplayed + "%");
            }
            z = false;
            EditHumidityFragment.this.viewModel.getTargetHumidity().removeObservers(EditHumidityFragment.this.requireActivity());
            EditHumidityFragment editHumidityFragment2 = EditHumidityFragment.this;
            editHumidityFragment2.targetHumidity = HumidityFilter.humidityDecrease(editHumidityFragment2.targetHumidity, EditHumidityFragment.this.humidSensorAvailable, z);
        }
    }

    private void pressHold(MaterialButton materialButton, final TextView textView, final Operation operation) {
        final HumidSettings humidSettings = new HumidSettings();
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditHumidityFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditHumidityFragment.this.m274lambda$pressHold$4$comtylohelotyloheloEditHumidityFragment(operation, humidSettings, textView, view);
            }
        });
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.EditHumidityFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EditHumidityFragment.this.m275lambda$pressHold$5$comtylohelotyloheloEditHumidityFragment(operation, humidSettings, textView, view, motionEvent);
            }
        });
    }

    /* renamed from: lambda$pressHold$4$com-tylohelo-tylohelo-EditHumidityFragment, reason: not valid java name */
    /* synthetic */ void m274lambda$pressHold$4$comtylohelotyloheloEditHumidityFragment(final Operation operation, final HumidSettings humidSettings, final TextView textView, View view) {
        this.counterHandler = new Handler();
        this.counterRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.EditHumidityFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (operation == Operation.HUMID_PLUS) {
                    humidSettings.incHumid(textView);
                } else if (operation == Operation.HUMID_MINUS) {
                    humidSettings.decHumid(textView);
                }
                EditHumidityFragment.this.counterHandler.postDelayed(this, 100L);
            }
        };
    }

    /* renamed from: lambda$pressHold$5$com-tylohelo-tylohelo-EditHumidityFragment, reason: not valid java name */
    /* synthetic */ boolean m275lambda$pressHold$5$comtylohelotyloheloEditHumidityFragment(Operation operation, HumidSettings humidSettings, TextView textView, View view, MotionEvent motionEvent) {
        Handler handler;
        Runnable runnable;
        Runnable runnable2;
        if (motionEvent.getAction() == 0) {
            view.performClick();
            if (operation == Operation.HUMID_PLUS) {
                humidSettings.incHumid(textView);
            } else if (operation == Operation.HUMID_MINUS) {
                humidSettings.decHumid(textView);
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
