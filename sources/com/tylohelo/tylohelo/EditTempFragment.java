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
public class EditTempFragment extends Fragment {
    private static final int OPERATION_DELAY_TEMP = 100;
    SharedViewModel viewModel;
    Integer targetTemp = null;
    Integer tempUnit = null;
    Integer lowerLimit = null;
    Integer upperLimit = null;
    private int count = 0;
    private Handler counterHandler = null;
    private Runnable counterRunnable = null;

    enum Operation {
        TEMP_PLUS,
        TEMP_MINUS
    }

    public static EditTempFragment newInstance() {
        EditTempFragment editTempFragment = new EditTempFragment();
        editTempFragment.setArguments(new Bundle());
        return editTempFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edit_temp, viewGroup, false);
        NavController findNavController = NavHostFragment.findNavController(this);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        final TextView textView = (TextView) inflate.findViewById(R.id.textViewTempDegree);
        SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        this.viewModel = sharedViewModel;
        sharedViewModel.getTargetTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditTempFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTempFragment.this.m283lambda$onCreateView$1$comtylohelotyloheloEditTempFragment(textView, (Integer) obj);
            }
        });
        this.viewModel.getLowerLimitTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditTempFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTempFragment.this.m284lambda$onCreateView$2$comtylohelotyloheloEditTempFragment((Integer) obj);
            }
        });
        this.viewModel.getUpperLimitTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditTempFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTempFragment.this.m285lambda$onCreateView$3$comtylohelotyloheloEditTempFragment((Integer) obj);
            }
        });
        onClickCloseButton(inflate, findNavController);
        onClickMinusButton(inflate);
        onClickPlusButton(inflate);
        onClickSaveButton(inflate, findNavController);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-EditTempFragment, reason: not valid java name */
    /* synthetic */ void m283lambda$onCreateView$1$comtylohelotyloheloEditTempFragment(final TextView textView, final Integer num) {
        if (num != null) {
            this.viewModel.getTemperatureUnit().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditTempFragment$$ExternalSyntheticLambda5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditTempFragment.this.m282lambda$onCreateView$0$comtylohelotyloheloEditTempFragment(num, textView, (Integer) obj);
                }
            });
        }
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-EditTempFragment, reason: not valid java name */
    /* synthetic */ void m282lambda$onCreateView$0$comtylohelotyloheloEditTempFragment(Integer num, TextView textView, Integer num2) {
        if (num2 == null || this.count != 0) {
            return;
        }
        this.tempUnit = num2;
        this.targetTemp = num;
        textView.setText(TemperatureFilter.temperatureFilter(num2.intValue(), this.targetTemp.intValue()) + TemperatureFilter.temperatureUnit(this.tempUnit.intValue()));
        this.count++;
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-EditTempFragment, reason: not valid java name */
    /* synthetic */ void m284lambda$onCreateView$2$comtylohelotyloheloEditTempFragment(Integer num) {
        if (num != null) {
            this.lowerLimit = num;
        }
    }

    /* renamed from: lambda$onCreateView$3$com-tylohelo-tylohelo-EditTempFragment, reason: not valid java name */
    /* synthetic */ void m285lambda$onCreateView$3$comtylohelotyloheloEditTempFragment(Integer num) {
        if (num != null) {
            this.upperLimit = num;
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
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditTempFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_editTempFragment_to_temperatureFragment3);
            }
        });
    }

    private void onClickSaveButton(View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditTempFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditTempFragment.this.m281xbc767992(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$5$com-tylohelo-tylohelo-EditTempFragment, reason: not valid java name */
    /* synthetic */ void m281xbc767992(NavController navController, View view) {
        Integer num = this.targetTemp;
        if (num != null) {
            this.viewModel.setTargetTemperature(num);
            MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
            if (messageToSaunaSystem == null) {
                messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
                tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
            }
            messageToSaunaSystem.sendTargetTemperature(this.targetTemp.intValue());
            navController.navigate(R.id.action_editTempFragment_to_temperatureFragment3);
        }
    }

    private void onClickMinusButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonMinus), (TextView) view.findViewById(R.id.textViewTempDegree), Operation.TEMP_MINUS);
    }

    class TempSettings {
        TempSettings() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incTemp(TextView textView) {
            EditTempFragment.this.viewModel.getTargetTemperature().removeObservers(EditTempFragment.this.requireActivity());
            if (EditTempFragment.this.targetTemp == null || EditTempFragment.this.tempUnit == null || EditTempFragment.this.upperLimit == null) {
                return;
            }
            EditTempFragment editTempFragment = EditTempFragment.this;
            editTempFragment.targetTemp = TemperatureFilter.plusOneDegree(editTempFragment.targetTemp.intValue(), EditTempFragment.this.tempUnit.intValue(), EditTempFragment.this.upperLimit.intValue());
            textView.setText(TemperatureFilter.temperatureFilter(EditTempFragment.this.tempUnit.intValue(), EditTempFragment.this.targetTemp.intValue()) + TemperatureFilter.temperatureUnit(EditTempFragment.this.tempUnit.intValue()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decTemp(TextView textView) {
            EditTempFragment.this.viewModel.getTargetTemperature().removeObservers(EditTempFragment.this.requireActivity());
            if (EditTempFragment.this.targetTemp == null || EditTempFragment.this.tempUnit == null || EditTempFragment.this.lowerLimit == null) {
                return;
            }
            EditTempFragment editTempFragment = EditTempFragment.this;
            editTempFragment.targetTemp = TemperatureFilter.minusOneDegree(editTempFragment.targetTemp.intValue(), EditTempFragment.this.tempUnit.intValue(), EditTempFragment.this.lowerLimit.intValue());
            textView.setText(TemperatureFilter.temperatureFilter(EditTempFragment.this.tempUnit.intValue(), EditTempFragment.this.targetTemp.intValue()) + TemperatureFilter.temperatureUnit(EditTempFragment.this.tempUnit.intValue()));
        }
    }

    private void onClickPlusButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonPlus), (TextView) view.findViewById(R.id.textViewTempDegree), Operation.TEMP_PLUS);
    }

    private void pressHold(MaterialButton materialButton, final TextView textView, final Operation operation) {
        final TempSettings tempSettings = new TempSettings();
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditTempFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditTempFragment.this.m286lambda$pressHold$6$comtylohelotyloheloEditTempFragment(operation, tempSettings, textView, view);
            }
        });
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.EditTempFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EditTempFragment.this.m287lambda$pressHold$7$comtylohelotyloheloEditTempFragment(operation, tempSettings, textView, view, motionEvent);
            }
        });
    }

    /* renamed from: lambda$pressHold$6$com-tylohelo-tylohelo-EditTempFragment, reason: not valid java name */
    /* synthetic */ void m286lambda$pressHold$6$comtylohelotyloheloEditTempFragment(final Operation operation, final TempSettings tempSettings, final TextView textView, View view) {
        this.counterHandler = new Handler();
        this.counterRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.EditTempFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (operation == Operation.TEMP_PLUS) {
                    tempSettings.incTemp(textView);
                } else if (operation == Operation.TEMP_MINUS) {
                    tempSettings.decTemp(textView);
                }
                EditTempFragment.this.counterHandler.postDelayed(this, 100L);
            }
        };
    }

    /* renamed from: lambda$pressHold$7$com-tylohelo-tylohelo-EditTempFragment, reason: not valid java name */
    /* synthetic */ boolean m287lambda$pressHold$7$comtylohelotyloheloEditTempFragment(Operation operation, TempSettings tempSettings, TextView textView, View view, MotionEvent motionEvent) {
        Handler handler;
        Runnable runnable;
        Runnable runnable2;
        if (motionEvent.getAction() == 0) {
            view.performClick();
            if (operation == Operation.TEMP_PLUS) {
                tempSettings.incTemp(textView);
            } else if (operation == Operation.TEMP_MINUS) {
                tempSettings.decTemp(textView);
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
