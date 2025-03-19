package com.tylohelo.tylohelo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;
import com.tylohelo.tylohelo.protobuf.Calendar;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ReadyAtFragment extends Fragment {
    private static final int OPERATION_DELAY_READY_AT = 200;
    private static final int PM_INT_VALUE = 1;
    private int hour;
    private int minute;
    private Long saunaTime;
    private Integer timeFormat;
    private SharedViewModel viewModel;
    private int formatCount = 0;
    private Calendar calendarSaunaDate = null;
    private Calendar.Calendar_post localCalendarPost = null;
    private final String am = "AM";
    private final String pm = "PM";
    private boolean endMarginChanged = false;
    private Handler counterHandler = null;
    private Runnable counterRunnable = null;

    enum Operation {
        HOUR_PLUS,
        HOUR_MINUS,
        MIN_PLUS,
        MIN_MINUS
    }

    enum clockSetting {
        minutes,
        hours,
        both
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_ready_at, viewGroup, false);
        this.viewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        NavController findNavController = NavHostFragment.findNavController(this);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        this.calendarSaunaDate = java.util.Calendar.getInstance();
        this.viewModel.getSaunaTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadyAtFragment.this.m332lambda$onCreateView$0$comtylohelotyloheloReadyAtFragment((Long) obj);
            }
        });
        this.viewModel.getTimeFormat().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadyAtFragment.this.m335lambda$onCreateView$3$comtylohelotyloheloReadyAtFragment(inflate, (Integer) obj);
            }
        });
        this.viewModel.getLocalCalendarPost().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadyAtFragment.this.m336lambda$onCreateView$4$comtylohelotyloheloReadyAtFragment(inflate, (Calendar.Calendar_post) obj);
            }
        });
        onClickIncreaseHourButton(inflate);
        onClickIncreaseMinuteButton(inflate);
        onClickDecreaseHourButton(inflate);
        onClickDecreaseMinuteButton(inflate);
        onClickCloseButton(inflate, findNavController);
        onClickSaveButton(inflate, findNavController);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-ReadyAtFragment, reason: not valid java name */
    /* synthetic */ void m332lambda$onCreateView$0$comtylohelotyloheloReadyAtFragment(Long l) {
        this.saunaTime = l;
    }

    /* renamed from: lambda$onCreateView$3$com-tylohelo-tylohelo-ReadyAtFragment, reason: not valid java name */
    /* synthetic */ void m335lambda$onCreateView$3$comtylohelotyloheloReadyAtFragment(View view, Integer num) {
        if (num == null || this.formatCount != 0) {
            return;
        }
        this.timeFormat = num;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonIncreaseAm);
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.buttonDecreasePm);
        final TextView textView = (TextView) view.findViewById(R.id.textViewAmPm);
        if (this.timeFormat.intValue() == 11) {
            if (!this.endMarginChanged) {
                this.endMarginChanged = true;
                MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.buttonIncreaseHour);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) materialButton3.getLayoutParams();
                layoutParams.setMarginEnd(layoutParams.getMarginEnd() + 200);
                materialButton3.setLayoutParams(layoutParams);
                MaterialButton materialButton4 = (MaterialButton) view.findViewById(R.id.buttonDecreaseHour);
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) materialButton4.getLayoutParams();
                layoutParams2.setMarginEnd(layoutParams2.getMarginEnd() + 200);
                materialButton4.setLayoutParams(layoutParams2);
            }
            materialButton.setVisibility(0);
            materialButton2.setVisibility(0);
            textView.setVisibility(0);
            if (this.calendarSaunaDate.get(9) == 0) {
                textView.setText("AM");
            } else {
                textView.setText("PM");
            }
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReadyAtFragment.this.m333lambda$onCreateView$1$comtylohelotyloheloReadyAtFragment(textView, view2);
                }
            });
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReadyAtFragment.this.m334lambda$onCreateView$2$comtylohelotyloheloReadyAtFragment(textView, view2);
                }
            });
        } else {
            this.endMarginChanged = false;
            materialButton.setVisibility(4);
            materialButton2.setVisibility(4);
            textView.setVisibility(4);
        }
        this.formatCount++;
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-ReadyAtFragment, reason: not valid java name */
    /* synthetic */ void m333lambda$onCreateView$1$comtylohelotyloheloReadyAtFragment(TextView textView, View view) {
        changeAmPm(textView);
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-ReadyAtFragment, reason: not valid java name */
    /* synthetic */ void m334lambda$onCreateView$2$comtylohelotyloheloReadyAtFragment(TextView textView, View view) {
        changeAmPm(textView);
    }

    /* renamed from: lambda$onCreateView$4$com-tylohelo-tylohelo-ReadyAtFragment, reason: not valid java name */
    /* synthetic */ void m336lambda$onCreateView$4$comtylohelotyloheloReadyAtFragment(View view, Calendar.Calendar_post calendar_post) {
        this.localCalendarPost = calendar_post;
        if (calendar_post == null || !calendar_post.hasActivationTime()) {
            return;
        }
        this.calendarSaunaDate.setTimeInMillis(this.localCalendarPost.getActivationTime());
        this.calendarSaunaDate.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (this.timeFormat.intValue() == 11) {
            int i = this.calendarSaunaDate.get(9);
            this.hour = this.calendarSaunaDate.get(10);
            this.minute = this.calendarSaunaDate.get(12);
            this.calendarSaunaDate.set(10, this.hour);
            this.calendarSaunaDate.set(9, i);
            TextView textView = (TextView) view.findViewById(R.id.textViewAmPm);
            if (i == 1) {
                textView.setText("PM");
            } else {
                textView.setText("AM");
            }
        } else {
            this.hour = this.calendarSaunaDate.get(11);
        }
        this.minute = this.calendarSaunaDate.get(12);
        setHourMinText(view, clockSetting.both);
    }

    private void onClickSaveButton(final View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadyAtFragment.this.m331lambda$onClickSaveButton$5$comtylohelotyloheloReadyAtFragment(view, navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$5$com-tylohelo-tylohelo-ReadyAtFragment, reason: not valid java name */
    /* synthetic */ void m331lambda$onClickSaveButton$5$comtylohelotyloheloReadyAtFragment(View view, NavController navController, View view2) {
        if (this.localCalendarPost == null) {
            this.localCalendarPost = Calendar.Calendar_post.newBuilder().build();
        }
        Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
        mergeFrom.clearActivationTime();
        Integer num = this.timeFormat;
        if (num != null && num.intValue() == 11) {
            if (((TextView) view.findViewById(R.id.textViewAmPm)).getText() == "AM") {
                this.calendarSaunaDate.set(9, 0);
            } else {
                this.calendarSaunaDate.set(9, 1);
            }
        }
        Long l = this.saunaTime;
        if (l != null) {
            FormatDateTime.checkForToday(this.timeFormat, l.longValue(), this.calendarSaunaDate);
            mergeFrom.setActivationTime(this.calendarSaunaDate.getTimeInMillis());
            this.viewModel.setLocalCalendarPost(mergeFrom.build());
            this.viewModel.setSaveChanges(true);
        }
        Bundle bundle = new Bundle();
        bundle.putString("srcFragment", "ReadyAtFragment");
        try {
            navController.navigate(R.id.action_readyAtFragment_to_editCalendarFragment, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeAmPm(TextView textView) {
        if (textView.getText() == "AM") {
            textView.setText("PM");
            this.calendarSaunaDate.set(9, 1);
        } else {
            textView.setText("AM");
            this.calendarSaunaDate.set(9, 0);
        }
    }

    private void onClickIncreaseHourButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonIncreaseHour), view, Operation.HOUR_PLUS);
    }

    private void onClickIncreaseMinuteButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonIncreaseMin), view, Operation.MIN_PLUS);
    }

    private void onClickDecreaseHourButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonDecreaseHour), view, Operation.HOUR_MINUS);
    }

    private void onClickDecreaseMinuteButton(View view) {
        pressHold((MaterialButton) view.findViewById(R.id.buttonDecreaseMin), view, Operation.MIN_MINUS);
    }

    private void onClickCloseButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonClose);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.top_bar_icon_cancel);
        int color = ContextCompat.getColor(requireContext(), R.color.yellow);
        if (drawable != null) {
            drawable.setTint(color);
        }
        materialButton.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_readyAtFragment_to_editCalendarFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHourMinText(View view, clockSetting clocksetting) {
        if (clocksetting == clockSetting.minutes || clocksetting == clockSetting.both) {
            TextView textView = (TextView) view.findViewById(R.id.textViewMinutesValue);
            int i = this.minute;
            if (i < 10) {
                textView.setText("0" + String.valueOf(this.minute));
            } else {
                textView.setText(String.valueOf(i));
            }
        }
        if (clocksetting == clockSetting.hours || clocksetting == clockSetting.both) {
            TextView textView2 = (TextView) view.findViewById(R.id.textViewHourValue);
            Integer num = this.timeFormat;
            if (num != null && num.intValue() == 11) {
                int i2 = this.hour;
                if (i2 == 0) {
                    textView2.setText(String.valueOf(12));
                    return;
                } else if (i2 < 10) {
                    textView2.setText("0" + String.valueOf(this.hour));
                    return;
                } else {
                    textView2.setText(String.valueOf(i2));
                    return;
                }
            }
            int i3 = this.hour;
            if (i3 < 10) {
                textView2.setText("0" + String.valueOf(this.hour));
            } else {
                textView2.setText(String.valueOf(i3));
            }
        }
    }

    class ReadyAtSettings {
        ReadyAtSettings() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incHour(View view) {
            TextView textView = (TextView) view.findViewById(R.id.textViewAmPm);
            if (ReadyAtFragment.this.timeFormat == null || ReadyAtFragment.this.timeFormat.intValue() != 11) {
                ReadyAtFragment.this.calendarSaunaDate.add(11, 1);
                ReadyAtFragment readyAtFragment = ReadyAtFragment.this;
                readyAtFragment.hour = readyAtFragment.calendarSaunaDate.get(11);
            } else {
                ReadyAtFragment.this.calendarSaunaDate.add(10, 1);
                if (ReadyAtFragment.this.calendarSaunaDate.get(9) == 1) {
                    textView.setText("PM");
                } else {
                    textView.setText("AM");
                }
                ReadyAtFragment readyAtFragment2 = ReadyAtFragment.this;
                readyAtFragment2.hour = readyAtFragment2.calendarSaunaDate.get(10);
            }
            ReadyAtFragment readyAtFragment3 = ReadyAtFragment.this;
            readyAtFragment3.minute = readyAtFragment3.calendarSaunaDate.get(12);
            ReadyAtFragment.this.setHourMinText(view, clockSetting.hours);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incMinute(View view) {
            ReadyAtFragment.this.calendarSaunaDate.add(12, 1);
            if (ReadyAtFragment.this.timeFormat.intValue() == 11) {
                ReadyAtFragment readyAtFragment = ReadyAtFragment.this;
                readyAtFragment.hour = readyAtFragment.calendarSaunaDate.get(10);
            } else {
                ReadyAtFragment readyAtFragment2 = ReadyAtFragment.this;
                readyAtFragment2.hour = readyAtFragment2.calendarSaunaDate.get(11);
            }
            ReadyAtFragment readyAtFragment3 = ReadyAtFragment.this;
            readyAtFragment3.minute = readyAtFragment3.calendarSaunaDate.get(12);
            if (ReadyAtFragment.this.minute == 0) {
                ReadyAtFragment.this.setHourMinText(view, clockSetting.both);
            } else {
                ReadyAtFragment.this.setHourMinText(view, clockSetting.minutes);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decHour(View view) {
            TextView textView = (TextView) view.findViewById(R.id.textViewAmPm);
            if (ReadyAtFragment.this.timeFormat.intValue() == 11) {
                ReadyAtFragment.this.calendarSaunaDate.add(10, -1);
                if (ReadyAtFragment.this.calendarSaunaDate.get(9) == 1) {
                    textView.setText("PM");
                } else {
                    textView.setText("AM");
                }
                ReadyAtFragment readyAtFragment = ReadyAtFragment.this;
                readyAtFragment.hour = readyAtFragment.calendarSaunaDate.get(10);
            } else {
                ReadyAtFragment.this.calendarSaunaDate.add(11, -1);
                ReadyAtFragment readyAtFragment2 = ReadyAtFragment.this;
                readyAtFragment2.hour = readyAtFragment2.calendarSaunaDate.get(11);
            }
            ReadyAtFragment readyAtFragment3 = ReadyAtFragment.this;
            readyAtFragment3.minute = readyAtFragment3.calendarSaunaDate.get(12);
            ReadyAtFragment.this.setHourMinText(view, clockSetting.hours);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decMinute(View view) {
            ReadyAtFragment.this.calendarSaunaDate.add(12, -1);
            if (ReadyAtFragment.this.timeFormat.intValue() == 11) {
                ReadyAtFragment readyAtFragment = ReadyAtFragment.this;
                readyAtFragment.hour = readyAtFragment.calendarSaunaDate.get(10);
            } else {
                ReadyAtFragment readyAtFragment2 = ReadyAtFragment.this;
                readyAtFragment2.hour = readyAtFragment2.calendarSaunaDate.get(11);
            }
            ReadyAtFragment readyAtFragment3 = ReadyAtFragment.this;
            readyAtFragment3.minute = readyAtFragment3.calendarSaunaDate.get(12);
            if (ReadyAtFragment.this.minute == 59) {
                ReadyAtFragment.this.setHourMinText(view, clockSetting.both);
            } else {
                ReadyAtFragment.this.setHourMinText(view, clockSetting.minutes);
            }
        }
    }

    private void pressHold(MaterialButton materialButton, final View view, final Operation operation) {
        final ReadyAtSettings readyAtSettings = new ReadyAtSettings();
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadyAtFragment.this.m337lambda$pressHold$7$comtylohelotyloheloReadyAtFragment(operation, readyAtSettings, view, view2);
            }
        });
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.ReadyAtFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ReadyAtFragment.this.m338lambda$pressHold$8$comtylohelotyloheloReadyAtFragment(operation, readyAtSettings, view, view2, motionEvent);
            }
        });
    }

    /* renamed from: lambda$pressHold$7$com-tylohelo-tylohelo-ReadyAtFragment, reason: not valid java name */
    /* synthetic */ void m337lambda$pressHold$7$comtylohelotyloheloReadyAtFragment(final Operation operation, final ReadyAtSettings readyAtSettings, final View view, View view2) {
        this.counterHandler = new Handler();
        this.counterRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.ReadyAtFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (operation == Operation.HOUR_PLUS) {
                    readyAtSettings.incHour(view);
                } else if (operation == Operation.HOUR_MINUS) {
                    readyAtSettings.decHour(view);
                } else if (operation == Operation.MIN_PLUS) {
                    readyAtSettings.incMinute(view);
                } else if (operation == Operation.MIN_MINUS) {
                    readyAtSettings.decMinute(view);
                }
                ReadyAtFragment.this.counterHandler.postDelayed(this, 200L);
            }
        };
    }

    /* renamed from: lambda$pressHold$8$com-tylohelo-tylohelo-ReadyAtFragment, reason: not valid java name */
    /* synthetic */ boolean m338lambda$pressHold$8$comtylohelotyloheloReadyAtFragment(Operation operation, ReadyAtSettings readyAtSettings, View view, View view2, MotionEvent motionEvent) {
        Handler handler;
        Runnable runnable;
        Runnable runnable2;
        if (motionEvent.getAction() == 0) {
            view2.performClick();
            if (operation == Operation.HOUR_PLUS) {
                readyAtSettings.incHour(view);
            } else if (operation == Operation.HOUR_MINUS) {
                readyAtSettings.decHour(view);
            } else if (operation == Operation.MIN_PLUS) {
                readyAtSettings.incMinute(view);
            } else if (operation == Operation.MIN_MINUS) {
                readyAtSettings.decMinute(view);
            }
            Handler handler2 = this.counterHandler;
            if (handler2 != null && (runnable2 = this.counterRunnable) != null) {
                handler2.postDelayed(runnable2, 200L);
            }
        } else if (motionEvent.getAction() == 1 && (handler = this.counterHandler) != null && (runnable = this.counterRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
        return true;
    }
}
