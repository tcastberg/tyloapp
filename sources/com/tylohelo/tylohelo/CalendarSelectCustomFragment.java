package com.tylohelo.tylohelo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;
import com.tylohelo.tylohelo.protobuf.Calendar;

/* loaded from: classes2.dex */
public class CalendarSelectCustomFragment extends Fragment {
    public static final int HUMIDITY_MAX_VALUE = 70;
    public static final int IR_CONSTANT = 101;
    private static final int OPERATION_DELAY_CUSTOM = 100;
    private Integer bathTime;
    private boolean humidSensorAvailable;
    private Calendar.Calendar_post localCalendarPost;
    private Calendar.Calendar_post localCustomPost;
    private Integer lowerLimit;
    private String sourceFragment;
    private int targetHumid;
    private Integer targetTemp;
    private Calendar.Calendar_post tempStopAfterPost;
    private Integer tempUnit;
    private Integer upperLimit;
    private SharedViewModel viewModel;
    private int count = 0;
    private Integer irEnabled = null;
    private boolean combiNtc = false;
    private Handler counterHandler = null;
    private Runnable counterRunnable = null;

    enum Operation {
        TEMP_PLUS,
        TEMP_MINUS,
        HUMID_PLUS,
        HUMID_MINUS
    }

    public static CalendarSelectCustomFragment newInstance() {
        CalendarSelectCustomFragment calendarSelectCustomFragment = new CalendarSelectCustomFragment();
        calendarSelectCustomFragment.setArguments(new Bundle());
        return calendarSelectCustomFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_calendar_select_custom, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        NavController findNavController = NavHostFragment.findNavController(this);
        SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        this.viewModel = sharedViewModel;
        sharedViewModel.getTemperatureUnit().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectCustomFragment.this.m225x3020a562((Integer) obj);
            }
        });
        this.viewModel.getLowerLimitTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectCustomFragment.this.m226x5df93fc1((Integer) obj);
            }
        });
        this.viewModel.getUpperLimitTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectCustomFragment.this.m227x8bd1da20((Integer) obj);
            }
        });
        final TextView textView = (TextView) inflate.findViewById(R.id.textViewHumidPercent);
        final TextView textView2 = (TextView) inflate.findViewById(R.id.textViewHumid);
        final Button button = (Button) inflate.findViewById(R.id.buttonMinusHumid);
        final Button button2 = (Button) inflate.findViewById(R.id.buttonPlusHumid);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        button.setVisibility(8);
        button2.setVisibility(8);
        this.viewModel.getHumiditySensorAvailable().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectCustomFragment.this.m229xe7830ede(textView, button, button2, textView2, (Integer) obj);
            }
        });
        if (getArguments() != null) {
            this.sourceFragment = getArguments().getString("srcCustomFragment");
        }
        String str = this.sourceFragment;
        if (str != null && str.equals("CalendarSelectCustomDurationFragment")) {
            this.viewModel.getLocalCustomPost().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda11
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CalendarSelectCustomFragment.this.m230x155ba93d(inflate, textView, (Calendar.Calendar_post) obj);
                }
            });
        } else {
            this.viewModel.getLocalCalendarPost().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CalendarSelectCustomFragment.this.m231x4334439c(inflate, textView, (Calendar.Calendar_post) obj);
                }
            });
        }
        setTextStopAfter(inflate);
        onClickCloseButton(inflate, findNavController);
        onClickMinusButton(inflate);
        onClickPlusButton(inflate);
        onClickMinusHumidButton(inflate);
        onClickPlusHumidButton(inflate);
        onClickStopAfterButton(inflate, findNavController);
        onClickSaveButton(inflate, findNavController);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m225x3020a562(Integer num) {
        this.tempUnit = num;
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m226x5df93fc1(Integer num) {
        this.lowerLimit = num;
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m227x8bd1da20(Integer num) {
        this.upperLimit = num;
    }

    /* renamed from: lambda$onCreateView$4$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m229xe7830ede(final TextView textView, final Button button, final Button button2, final TextView textView2, Integer num) {
        if (num != null) {
            this.humidSensorAvailable = num.intValue() == 1;
        } else {
            this.humidSensorAvailable = false;
        }
        HumidityFilter humidityFilter = new HumidityFilter(getContext(), getActivity());
        if (humidityFilter.showHumidity() && this.humidSensorAvailable) {
            textView.setVisibility(0);
            button.setVisibility(0);
            button2.setVisibility(0);
            textView2.setVisibility(0);
        } else if (humidityFilter.showCombiNtc()) {
            this.combiNtc = true;
            textView.setVisibility(0);
            button.setVisibility(0);
            button2.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            this.viewModel.getIREnabled().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CalendarSelectCustomFragment.this.m228xb9aa747f(textView, button, button2, textView2, (Integer) obj);
                }
            });
        }
        displayHumidOrIrValue(textView);
    }

    /* renamed from: lambda$onCreateView$3$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m228xb9aa747f(TextView textView, Button button, Button button2, TextView textView2, Integer num) {
        this.irEnabled = num;
        if (num == null || num.intValue() != 1) {
            return;
        }
        textView.setVisibility(0);
        button.setVisibility(0);
        button2.setVisibility(0);
        textView2.setVisibility(0);
        textView2.setText("IR");
    }

    /* renamed from: lambda$onCreateView$5$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m230x155ba93d(View view, TextView textView, Calendar.Calendar_post calendar_post) {
        if (calendar_post != null) {
            this.localCustomPost = calendar_post;
            this.tempStopAfterPost = calendar_post;
            this.targetTemp = Integer.valueOf(calendar_post.getTemperatureSetPoint());
            this.bathTime = Integer.valueOf(calendar_post.getBathTime());
            this.targetHumid = calendar_post.getHumiditySetPoint();
            setTextTemp(view);
            setTextStopAfter(view);
            displayHumidOrIrValue(textView);
        }
    }

    /* renamed from: lambda$onCreateView$6$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m231x4334439c(View view, TextView textView, Calendar.Calendar_post calendar_post) {
        this.localCalendarPost = calendar_post;
        this.tempStopAfterPost = calendar_post;
        Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
        if (this.count == 0) {
            if (this.localCalendarPost != null) {
                Boolean value = this.viewModel.getIsCalendarFav().getValue();
                if (this.localCalendarPost.hasBathTime() && value != null && !value.booleanValue()) {
                    this.bathTime = Integer.valueOf(this.localCalendarPost.getBathTime());
                    setTextStopAfter(view);
                } else if (this.viewModel.getBathTime().getValue() != null) {
                    Integer value2 = this.viewModel.getBathTime().getValue();
                    this.bathTime = value2;
                    mergeFrom.setBathTime(value2.intValue());
                    setTextStopAfter(view);
                }
                if (this.localCalendarPost.hasTemperatureSetPoint() && value != null && !value.booleanValue()) {
                    this.targetTemp = Integer.valueOf(this.localCalendarPost.getTemperatureSetPoint());
                    setTextTemp(view);
                } else {
                    if (this.viewModel.getTargetTemperature().getValue() != null) {
                        Integer value3 = this.viewModel.getTargetTemperature().getValue();
                        this.targetTemp = value3;
                        mergeFrom.setTemperatureSetPoint(value3.intValue());
                    }
                    setTextTemp(view);
                }
                if (this.localCalendarPost.hasHumiditySetPoint() && value != null && !value.booleanValue()) {
                    this.targetHumid = this.localCalendarPost.getHumiditySetPoint();
                    displayHumidOrIrValue(textView);
                } else if (this.viewModel.getTargetHumidity().getValue() != null) {
                    int intValue = this.viewModel.getTargetHumidity().getValue().intValue();
                    this.targetHumid = intValue;
                    mergeFrom.setHumiditySetPoint(intValue);
                    displayHumidOrIrValue(textView);
                }
                this.viewModel.setLocalCalendarPost(mergeFrom.build());
            }
            this.count++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayHumidOrIrValue(TextView textView) {
        String str;
        int i;
        Integer num = this.irEnabled;
        if (num != null) {
            if (num.intValue() != 1) {
                str = "";
            } else {
                str = String.valueOf(this.targetHumid - 101);
            }
        } else if (this.combiNtc && (i = this.targetHumid) > 70) {
            str = String.valueOf(i - 101);
        } else {
            str = this.targetHumid + "%";
        }
        textView.setText(str);
    }

    private void setTextStopAfter(View view) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonStopAfter);
        Integer num = this.bathTime;
        if (num != null) {
            SpannableString alignTwoStrings = tyloApplication.alignTwoStrings("Stop after", (num.intValue() / 60) + "hrs " + (this.bathTime.intValue() % 60) + "min");
            materialButton.setAllCaps(false);
            materialButton.setPadding(20, 0, 20, 0);
            materialButton.setText(alignTwoStrings);
            materialButton.setVisibility(0);
        }
    }

    private void setTextTemp(View view) {
        TextView textView = (TextView) view.findViewById(R.id.textViewTempDegree);
        Integer num = this.tempUnit;
        if (num == null || this.targetTemp == null) {
            return;
        }
        textView.setText(TemperatureFilter.temperatureFilter(num.intValue(), this.targetTemp.intValue()) + TemperatureFilter.temperatureUnit(this.tempUnit.intValue()));
    }

    private void onClickSaveButton(View view, final NavController navController) {
        ((Button) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CalendarSelectCustomFragment.this.m223xdcdac3d(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$7$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m223xdcdac3d(NavController navController, View view) {
        saveToLocal();
        this.viewModel.setIsCalendarFav(false);
        try {
            navController.navigate(R.id.action_calendarSelectCustomFragment_to_editCalendarFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToLocal() {
        Calendar.Calendar_post.Builder mergeFrom;
        if (this.localCustomPost == null) {
            if (this.localCalendarPost != null) {
                mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
            } else {
                mergeFrom = Calendar.Calendar_post.newBuilder();
            }
        } else {
            mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCustomPost);
        }
        mergeFrom.setTemperatureSetPoint(this.targetTemp.intValue());
        mergeFrom.setBathTime(this.bathTime.intValue());
        mergeFrom.setHumiditySetPoint(this.targetHumid);
        if (mergeFrom.hasFavorite()) {
            mergeFrom.clearFavorite();
        }
        this.viewModel.setLocalCalendarPost(mergeFrom.build());
        this.viewModel.setLocalCustomPost(null);
        this.viewModel.setIsCalendarFav(false);
        this.viewModel.setSaveChanges(true);
    }

    private void onClickCloseButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonClose);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.top_bar_icon_cancel);
        int color = ContextCompat.getColor(requireContext(), R.color.yellow);
        if (drawable != null) {
            drawable.setTint(color);
        }
        materialButton.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CalendarSelectCustomFragment.lambda$onClickCloseButton$8(NavController.this, view2);
            }
        });
    }

    static /* synthetic */ void lambda$onClickCloseButton$8(NavController navController, View view) {
        try {
            navController.navigate(R.id.action_calendarSelectCustomFragment_to_editCalendarFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onClickMinusButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonMinus), (TextView) view.findViewById(R.id.textViewTempDegree), null, Operation.TEMP_MINUS);
    }

    private void onClickPlusButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonPlus), (TextView) view.findViewById(R.id.textViewTempDegree), (TextView) view.findViewById(R.id.textViewHumidPercent), Operation.TEMP_PLUS);
    }

    private void onClickMinusHumidButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonMinusHumid), (TextView) view.findViewById(R.id.textViewHumidPercent), null, Operation.HUMID_MINUS);
    }

    private void onClickPlusHumidButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonPlusHumid), (TextView) view.findViewById(R.id.textViewHumidPercent), (TextView) view.findViewById(R.id.textViewTempDegree), Operation.HUMID_PLUS);
    }

    private void onClickStopAfterButton(View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonStopAfter)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CalendarSelectCustomFragment.this.m224xfde0736(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickStopAfterButton$9$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m224xfde0736(NavController navController, View view) {
        if (this.tempStopAfterPost != null) {
            Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.tempStopAfterPost);
            Integer num = this.targetTemp;
            if (num != null) {
                mergeFrom.setTemperatureSetPoint(num.intValue());
            }
            Integer num2 = this.bathTime;
            if (num2 != null) {
                mergeFrom.setBathTime(num2.intValue());
            }
            mergeFrom.setHumiditySetPoint(this.targetHumid);
            this.viewModel.setLocalCustomPost(mergeFrom.build());
            try {
                navController.navigate(R.id.action_calendarSelectCustomFragment_to_calendarSelectCustomDurationFragment);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class CustomSettings {
        CustomSettings() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incTemp(TextView textView, TextView textView2) {
            int maxHumidity;
            if (CalendarSelectCustomFragment.this.targetTemp == null || CalendarSelectCustomFragment.this.tempUnit == null || CalendarSelectCustomFragment.this.upperLimit == null) {
                return;
            }
            CalendarSelectCustomFragment calendarSelectCustomFragment = CalendarSelectCustomFragment.this;
            calendarSelectCustomFragment.targetTemp = TemperatureFilter.plusOneDegree(calendarSelectCustomFragment.targetTemp.intValue(), CalendarSelectCustomFragment.this.tempUnit.intValue(), CalendarSelectCustomFragment.this.upperLimit.intValue());
            textView.setText(TemperatureFilter.temperatureFilter(CalendarSelectCustomFragment.this.tempUnit.intValue(), CalendarSelectCustomFragment.this.targetTemp.intValue()) + TemperatureFilter.temperatureUnit(CalendarSelectCustomFragment.this.tempUnit.intValue()));
            if (!CalendarSelectCustomFragment.this.humidSensorAvailable || CalendarSelectCustomFragment.this.targetHumid <= (maxHumidity = tyloApplication.getMaxHumidity(CalendarSelectCustomFragment.this.targetTemp.intValue()))) {
                return;
            }
            CalendarSelectCustomFragment.this.targetHumid = maxHumidity;
            if (textView2 != null) {
                CalendarSelectCustomFragment.this.displayHumidOrIrValue(textView2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decTemp(TextView textView) {
            if (CalendarSelectCustomFragment.this.targetTemp == null || CalendarSelectCustomFragment.this.tempUnit == null || CalendarSelectCustomFragment.this.lowerLimit == null) {
                return;
            }
            CalendarSelectCustomFragment calendarSelectCustomFragment = CalendarSelectCustomFragment.this;
            calendarSelectCustomFragment.targetTemp = TemperatureFilter.minusOneDegree(calendarSelectCustomFragment.targetTemp.intValue(), CalendarSelectCustomFragment.this.tempUnit.intValue(), CalendarSelectCustomFragment.this.lowerLimit.intValue());
            textView.setText(TemperatureFilter.temperatureFilter(CalendarSelectCustomFragment.this.tempUnit.intValue(), CalendarSelectCustomFragment.this.targetTemp.intValue()) + TemperatureFilter.temperatureUnit(CalendarSelectCustomFragment.this.tempUnit.intValue()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incHumid(TextView textView, TextView textView2) {
            int maxTemperature;
            if (CalendarSelectCustomFragment.this.irEnabled != null) {
                if (CalendarSelectCustomFragment.this.irEnabled.intValue() == 1) {
                    CalendarSelectCustomFragment.this.targetHumid = IRFilter.irIncrease(CalendarSelectCustomFragment.this.targetHumid - 101) + 101;
                }
            } else {
                CalendarSelectCustomFragment calendarSelectCustomFragment = CalendarSelectCustomFragment.this;
                calendarSelectCustomFragment.targetHumid = HumidityFilter.humidityIncrease(calendarSelectCustomFragment.targetHumid, CalendarSelectCustomFragment.this.humidSensorAvailable, CalendarSelectCustomFragment.this.combiNtc);
            }
            if (CalendarSelectCustomFragment.this.humidSensorAvailable && CalendarSelectCustomFragment.this.targetTemp.intValue() > (maxTemperature = tyloApplication.getMaxTemperature(CalendarSelectCustomFragment.this.targetHumid))) {
                CalendarSelectCustomFragment.this.targetTemp = Integer.valueOf(maxTemperature);
                String str = TemperatureFilter.temperatureFilter(CalendarSelectCustomFragment.this.tempUnit.intValue(), CalendarSelectCustomFragment.this.targetTemp.intValue()) + TemperatureFilter.temperatureUnit(CalendarSelectCustomFragment.this.tempUnit.intValue());
                if (textView2 != null) {
                    textView2.setText(str);
                }
            }
            CalendarSelectCustomFragment.this.displayHumidOrIrValue(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decHumid(TextView textView) {
            if (CalendarSelectCustomFragment.this.irEnabled != null) {
                if (CalendarSelectCustomFragment.this.irEnabled.intValue() == 1) {
                    CalendarSelectCustomFragment.this.targetHumid = IRFilter.irDecrease(CalendarSelectCustomFragment.this.targetHumid - 101) + 101;
                }
            } else {
                CalendarSelectCustomFragment calendarSelectCustomFragment = CalendarSelectCustomFragment.this;
                calendarSelectCustomFragment.targetHumid = HumidityFilter.humidityDecrease(calendarSelectCustomFragment.targetHumid, CalendarSelectCustomFragment.this.humidSensorAvailable, CalendarSelectCustomFragment.this.combiNtc);
            }
            CalendarSelectCustomFragment.this.displayHumidOrIrValue(textView);
        }
    }

    private void pressHold(MaterialButton materialButton, final TextView textView, final TextView textView2, final Operation operation) {
        final CustomSettings customSettings = new CustomSettings();
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalendarSelectCustomFragment.this.m232x899acb2d(operation, customSettings, textView, textView2, view);
            }
        });
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CalendarSelectCustomFragment.this.m233xb773658c(operation, customSettings, textView, textView2, view, motionEvent);
            }
        });
    }

    /* renamed from: lambda$pressHold$10$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ void m232x899acb2d(final Operation operation, final CustomSettings customSettings, final TextView textView, final TextView textView2, View view) {
        this.counterHandler = new Handler();
        this.counterRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (operation == Operation.TEMP_PLUS) {
                    customSettings.incTemp(textView, textView2);
                } else if (operation == Operation.TEMP_MINUS) {
                    customSettings.decTemp(textView);
                } else if (operation == Operation.HUMID_PLUS) {
                    customSettings.incHumid(textView, textView2);
                } else if (operation == Operation.HUMID_MINUS) {
                    customSettings.decHumid(textView);
                }
                CalendarSelectCustomFragment.this.counterHandler.postDelayed(this, 100L);
            }
        };
    }

    /* renamed from: lambda$pressHold$11$com-tylohelo-tylohelo-CalendarSelectCustomFragment, reason: not valid java name */
    /* synthetic */ boolean m233xb773658c(Operation operation, CustomSettings customSettings, TextView textView, TextView textView2, View view, MotionEvent motionEvent) {
        Handler handler;
        Runnable runnable;
        Runnable runnable2;
        if (motionEvent.getAction() == 0) {
            view.performClick();
            if (operation == Operation.TEMP_PLUS) {
                customSettings.incTemp(textView, textView2);
            } else if (operation == Operation.TEMP_MINUS) {
                customSettings.decTemp(textView);
            } else if (operation == Operation.HUMID_PLUS) {
                customSettings.incHumid(textView, textView2);
            } else if (operation == Operation.HUMID_MINUS) {
                customSettings.decHumid(textView);
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
