package com.tylohelo.tylohelo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
public class CalendarSelectCustomDurationFragment extends Fragment {
    private static final int OPERATION_DELAY = 120;
    private Handler counterHandler = null;
    private Runnable counterRunnable = null;
    private int hour;
    private Calendar.Calendar_post localCustomPost;
    private Integer maxHour;
    private Integer maxMinutesAtMaxHour;
    private int minute;
    private SharedViewModel viewModel;

    enum Operation {
        HOUR_PLUS,
        HOUR_MINUS,
        MIN_PLUS,
        MIN_MINUS
    }

    static /* synthetic */ int access$408(CalendarSelectCustomDurationFragment calendarSelectCustomDurationFragment) {
        int i = calendarSelectCustomDurationFragment.minute;
        calendarSelectCustomDurationFragment.minute = i + 1;
        return i;
    }

    static /* synthetic */ int access$410(CalendarSelectCustomDurationFragment calendarSelectCustomDurationFragment) {
        int i = calendarSelectCustomDurationFragment.minute;
        calendarSelectCustomDurationFragment.minute = i - 1;
        return i;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_set_bath_time, viewGroup, false);
        NavController findNavController = NavHostFragment.findNavController(this);
        this.viewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        this.viewModel.getMaxBathTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomDurationFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectCustomDurationFragment.this.m218x468f5116((Integer) obj);
            }
        });
        this.viewModel.getLocalCustomPost().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomDurationFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectCustomDurationFragment.this.m220x5296e7d4(inflate, (Calendar.Calendar_post) obj);
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

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-CalendarSelectCustomDurationFragment, reason: not valid java name */
    /* synthetic */ void m218x468f5116(Integer num) {
        if (num != null) {
            this.maxHour = Integer.valueOf(num.intValue() / 60);
            this.maxMinutesAtMaxHour = Integer.valueOf(num.intValue() % 60);
        } else {
            this.maxHour = null;
            this.maxMinutesAtMaxHour = null;
        }
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-CalendarSelectCustomDurationFragment, reason: not valid java name */
    /* synthetic */ void m220x5296e7d4(View view, Calendar.Calendar_post calendar_post) {
        this.localCustomPost = calendar_post;
        if (calendar_post == null) {
            this.viewModel.getLocalCalendarPost().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomDurationFragment$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CalendarSelectCustomDurationFragment.this.m219x4c931c75((Calendar.Calendar_post) obj);
                }
            });
        }
        Calendar.Calendar_post calendar_post2 = this.localCustomPost;
        if (calendar_post2 != null) {
            this.hour = calendar_post2.getBathTime() / 60;
            this.minute = this.localCustomPost.getBathTime() % 60;
            setHourMinText(view);
        }
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-CalendarSelectCustomDurationFragment, reason: not valid java name */
    /* synthetic */ void m219x4c931c75(Calendar.Calendar_post calendar_post) {
        if (calendar_post != null) {
            this.localCustomPost = calendar_post;
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
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomDurationFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CalendarSelectCustomDurationFragment.lambda$onClickCloseButton$3(NavController.this, view2);
            }
        });
    }

    static /* synthetic */ void lambda$onClickCloseButton$3(NavController navController, View view) {
        try {
            navController.navigate(R.id.action_calendarSelectCustomDurationFragment_to_calendarSelectCustomFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onClickSaveButton(final View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomDurationFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CalendarSelectCustomDurationFragment.this.m217x8655ead4(view, navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$4$com-tylohelo-tylohelo-CalendarSelectCustomDurationFragment, reason: not valid java name */
    /* synthetic */ void m217x8655ead4(View view, NavController navController, View view2) {
        int textHour = (getTextHour(view) * 60) + getTextMinute(view);
        Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCustomPost);
        mergeFrom.clearBathTime();
        mergeFrom.setBathTime(textHour);
        this.viewModel.setLocalCustomPost(mergeFrom.build());
        Bundle bundle = new Bundle();
        bundle.putString("srcCustomFragment", "CalendarSelectCustomDurationFragment");
        try {
            navController.navigate(R.id.action_calendarSelectCustomDurationFragment_to_calendarSelectCustomFragment, bundle);
        } catch (Exception e) {
            e.printStackTrace();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void hourIncrease() {
        Integer num;
        int i = this.hour + 1;
        this.hour = i;
        Integer num2 = this.maxHour;
        if (num2 != null && i == num2.intValue() && this.minute > this.maxMinutesAtMaxHour.intValue()) {
            this.minute = this.maxMinutesAtMaxHour.intValue();
        }
        Integer num3 = this.maxHour;
        if (num3 == null || this.hour <= num3.intValue() || (num = this.maxMinutesAtMaxHour) == null) {
            return;
        }
        if (this.minute == num.intValue()) {
            this.hour = 0;
            this.minute = 1;
        } else {
            this.hour = this.maxHour.intValue();
            this.minute = this.maxMinutesAtMaxHour.intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hourDecrease() {
        Integer num;
        int i = this.hour - 1;
        this.hour = i;
        if ((i == 0) & (this.minute == 0)) {
            this.minute = 1;
        }
        if (i < 0) {
            if (this.minute > 1) {
                this.minute = 1;
                this.hour = 0;
            } else {
                if (this.maxHour == null || (num = this.maxMinutesAtMaxHour) == null) {
                    return;
                }
                this.minute = num.intValue();
                this.hour = this.maxHour.intValue();
            }
        }
    }

    private int getTextHour(View view) {
        return Integer.parseInt(((TextView) view.findViewById(R.id.textViewHourValue)).getText().toString());
    }

    private int getTextMinute(View view) {
        return Integer.parseInt(((TextView) view.findViewById(R.id.textViewMinutesValue)).getText().toString().trim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHourMinText(View view) {
        TextView textView = (TextView) view.findViewById(R.id.textViewMinutesValue);
        int i = this.minute;
        if (i < 10) {
            textView.setText(" " + this.minute);
        } else {
            textView.setText(String.valueOf(i));
        }
        ((TextView) view.findViewById(R.id.textViewHourValue)).setText(String.valueOf(this.hour));
    }

    class CustomDurationSettings {
        CustomDurationSettings() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incHour(View view) {
            CalendarSelectCustomDurationFragment.this.hourIncrease();
            CalendarSelectCustomDurationFragment.this.setHourMinText(view);
            ((Button) view.findViewById(R.id.buttonIncreaseMin)).setEnabled(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incMinute(View view) {
            if (CalendarSelectCustomDurationFragment.this.maxHour == null || CalendarSelectCustomDurationFragment.this.hour != CalendarSelectCustomDurationFragment.this.maxHour.intValue() || CalendarSelectCustomDurationFragment.this.minute != CalendarSelectCustomDurationFragment.this.maxMinutesAtMaxHour.intValue()) {
                CalendarSelectCustomDurationFragment.access$408(CalendarSelectCustomDurationFragment.this);
                if (CalendarSelectCustomDurationFragment.this.minute > 59) {
                    CalendarSelectCustomDurationFragment.this.minute = 0;
                    CalendarSelectCustomDurationFragment.this.hourIncrease();
                }
            }
            if (CalendarSelectCustomDurationFragment.this.maxHour != null && CalendarSelectCustomDurationFragment.this.hour == CalendarSelectCustomDurationFragment.this.maxHour.intValue()) {
                CalendarSelectCustomDurationFragment.this.minute = 0;
            }
            ((Button) view.findViewById(R.id.buttonDecreaseMin)).setEnabled(true);
            CalendarSelectCustomDurationFragment.this.setHourMinText(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decHour(View view) {
            ((Button) view.findViewById(R.id.buttonIncreaseMin)).setEnabled(true);
            ((Button) view.findViewById(R.id.buttonDecreaseMin)).setEnabled(true);
            CalendarSelectCustomDurationFragment.this.hourDecrease();
            CalendarSelectCustomDurationFragment.this.setHourMinText(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decMinute(View view, MaterialButton materialButton) {
            if (!((CalendarSelectCustomDurationFragment.this.hour == 0) & (CalendarSelectCustomDurationFragment.this.minute == 1))) {
                CalendarSelectCustomDurationFragment.access$410(CalendarSelectCustomDurationFragment.this);
                if (CalendarSelectCustomDurationFragment.this.minute < 0) {
                    CalendarSelectCustomDurationFragment.this.minute = 59;
                    CalendarSelectCustomDurationFragment.this.hourDecrease();
                }
            }
            ((Button) view.findViewById(R.id.buttonIncreaseMin)).setEnabled(true);
            materialButton.setEnabled(true);
            CalendarSelectCustomDurationFragment.this.setHourMinText(view);
        }
    }

    private void pressHold(final MaterialButton materialButton, final View view, final Operation operation) {
        final CustomDurationSettings customDurationSettings = new CustomDurationSettings();
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomDurationFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CalendarSelectCustomDurationFragment.this.m221x5faa0ea9(operation, customDurationSettings, view, materialButton, view2);
            }
        });
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomDurationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return CalendarSelectCustomDurationFragment.this.m222x65adda08(operation, customDurationSettings, view, materialButton, view2, motionEvent);
            }
        });
    }

    /* renamed from: lambda$pressHold$5$com-tylohelo-tylohelo-CalendarSelectCustomDurationFragment, reason: not valid java name */
    /* synthetic */ void m221x5faa0ea9(final Operation operation, final CustomDurationSettings customDurationSettings, final View view, final MaterialButton materialButton, View view2) {
        this.counterHandler = new Handler();
        this.counterRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.CalendarSelectCustomDurationFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (operation == Operation.HOUR_PLUS) {
                    customDurationSettings.incHour(view);
                } else if (operation == Operation.HOUR_MINUS) {
                    customDurationSettings.decHour(view);
                } else if (operation == Operation.MIN_PLUS) {
                    customDurationSettings.incMinute(view);
                } else if (operation == Operation.MIN_MINUS) {
                    customDurationSettings.decMinute(view, materialButton);
                }
                CalendarSelectCustomDurationFragment.this.counterHandler.postDelayed(this, 120L);
            }
        };
    }

    /* renamed from: lambda$pressHold$6$com-tylohelo-tylohelo-CalendarSelectCustomDurationFragment, reason: not valid java name */
    /* synthetic */ boolean m222x65adda08(Operation operation, CustomDurationSettings customDurationSettings, View view, MaterialButton materialButton, View view2, MotionEvent motionEvent) {
        Handler handler;
        Runnable runnable;
        Runnable runnable2;
        if (motionEvent.getAction() == 0) {
            view2.performClick();
            if (operation == Operation.HOUR_PLUS) {
                customDurationSettings.incHour(view);
            } else if (operation == Operation.HOUR_MINUS) {
                customDurationSettings.decHour(view);
            } else if (operation == Operation.MIN_PLUS) {
                customDurationSettings.incMinute(view);
            } else if (operation == Operation.MIN_MINUS) {
                customDurationSettings.decMinute(view, materialButton);
            }
            Handler handler2 = this.counterHandler;
            if (handler2 != null && (runnable2 = this.counterRunnable) != null) {
                handler2.postDelayed(runnable2, 120L);
            }
        } else if (motionEvent.getAction() == 1 && (handler = this.counterHandler) != null && (runnable = this.counterRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
        return true;
    }
}
