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
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes2.dex */
public class EditIRFragment extends Fragment {
    private static final int OPERATION_DELAY_IR = 100;
    SharedViewModel viewModel;
    Integer targetIR = null;
    private int count = 0;
    private Handler counterHandler = null;
    private Runnable counterRunnable = null;

    enum Operation {
        IR_PLUS,
        IR_MINUS
    }

    public static EditIRFragment newInstance() {
        EditIRFragment editIRFragment = new EditIRFragment();
        editIRFragment.setArguments(new Bundle());
        return editIRFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edit_i_r, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        final TextView textView = (TextView) inflate.findViewById(R.id.textViewIRValue);
        SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        this.viewModel = sharedViewModel;
        sharedViewModel.getTargetHumidity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditIRFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditIRFragment.this.m278lambda$onCreateView$1$comtylohelotyloheloEditIRFragment(textView, (Integer) obj);
            }
        });
        NavController findNavController = NavHostFragment.findNavController(this);
        onClickCloseButton(inflate, findNavController);
        onClickPlusButton(inflate);
        onClickMinusButton(inflate);
        onClickSaveButton(inflate, findNavController);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-EditIRFragment, reason: not valid java name */
    /* synthetic */ void m278lambda$onCreateView$1$comtylohelotyloheloEditIRFragment(final TextView textView, final Integer num) {
        this.viewModel.getIREnabled().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditIRFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditIRFragment.this.m277lambda$onCreateView$0$comtylohelotyloheloEditIRFragment(num, textView, (Integer) obj);
            }
        });
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-EditIRFragment, reason: not valid java name */
    /* synthetic */ void m277lambda$onCreateView$0$comtylohelotyloheloEditIRFragment(Integer num, TextView textView, Integer num2) {
        if (this.count != 0 || num2 == null || num == null) {
            return;
        }
        if (num2.intValue() == 1) {
            this.targetIR = Integer.valueOf(num.intValue() - 101);
        } else {
            this.targetIR = null;
        }
        Integer num3 = this.targetIR;
        if (num3 != null) {
            textView.setText(String.valueOf(num3));
        }
        this.count++;
    }

    private void onClickCloseButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonClose);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.top_bar_icon_cancel);
        int color = ContextCompat.getColor(requireContext(), R.color.yellow);
        if (drawable != null) {
            drawable.setTint(color);
        }
        materialButton.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditIRFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_editIRFragment_to_temperatureFragment3);
            }
        });
    }

    private void onClickSaveButton(View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditIRFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditIRFragment.this.m276lambda$onClickSaveButton$3$comtylohelotyloheloEditIRFragment(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$3$com-tylohelo-tylohelo-EditIRFragment, reason: not valid java name */
    /* synthetic */ void m276lambda$onClickSaveButton$3$comtylohelotyloheloEditIRFragment(NavController navController, View view) {
        this.viewModel.setTargetHumidity(Integer.valueOf(this.targetIR.intValue() + 101));
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendTargetHumidity(this.targetIR.intValue() + 101);
        navController.navigate(R.id.action_editIRFragment_to_temperatureFragment3);
    }

    private void onClickPlusButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonPlus), (TextView) view.findViewById(R.id.textViewIRValue), Operation.IR_PLUS);
    }

    private void onClickMinusButton(View view) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonMinus);
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.stepper_control_minus_btn));
        pressHold(materialButton, (TextView) view.findViewById(R.id.textViewIRValue), Operation.IR_MINUS);
    }

    class IRSettings {
        IRSettings() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incIR(TextView textView) {
            if (EditIRFragment.this.targetIR != null) {
                EditIRFragment editIRFragment = EditIRFragment.this;
                editIRFragment.targetIR = Integer.valueOf(IRFilter.irIncrease(editIRFragment.targetIR.intValue()));
                textView.setText(String.valueOf(EditIRFragment.this.targetIR));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decIR(TextView textView) {
            if (EditIRFragment.this.targetIR != null) {
                EditIRFragment editIRFragment = EditIRFragment.this;
                editIRFragment.targetIR = Integer.valueOf(IRFilter.irDecrease(editIRFragment.targetIR.intValue()));
                textView.setText(String.valueOf(EditIRFragment.this.targetIR));
            }
        }
    }

    private void pressHold(MaterialButton materialButton, final TextView textView, final Operation operation) {
        final IRSettings iRSettings = new IRSettings();
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditIRFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditIRFragment.this.m279lambda$pressHold$4$comtylohelotyloheloEditIRFragment(operation, iRSettings, textView, view);
            }
        });
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.EditIRFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EditIRFragment.this.m280lambda$pressHold$5$comtylohelotyloheloEditIRFragment(operation, iRSettings, textView, view, motionEvent);
            }
        });
    }

    /* renamed from: lambda$pressHold$4$com-tylohelo-tylohelo-EditIRFragment, reason: not valid java name */
    /* synthetic */ void m279lambda$pressHold$4$comtylohelotyloheloEditIRFragment(final Operation operation, final IRSettings iRSettings, final TextView textView, View view) {
        this.counterHandler = new Handler();
        this.counterRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.EditIRFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (operation == Operation.IR_PLUS) {
                    iRSettings.incIR(textView);
                } else if (operation == Operation.IR_MINUS) {
                    iRSettings.decIR(textView);
                }
                EditIRFragment.this.counterHandler.postDelayed(this, 100L);
            }
        };
    }

    /* renamed from: lambda$pressHold$5$com-tylohelo-tylohelo-EditIRFragment, reason: not valid java name */
    /* synthetic */ boolean m280lambda$pressHold$5$comtylohelotyloheloEditIRFragment(Operation operation, IRSettings iRSettings, TextView textView, View view, MotionEvent motionEvent) {
        Handler handler;
        Runnable runnable;
        Runnable runnable2;
        if (motionEvent.getAction() == 0) {
            view.performClick();
            if (operation == Operation.IR_PLUS) {
                iRSettings.incIR(textView);
            } else if (operation == Operation.IR_MINUS) {
                iRSettings.decIR(textView);
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
