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
import com.tylohelo.tylohelo.protobuf.Favorite;
import java.util.List;

/* loaded from: classes2.dex */
public class SetBathTimeFragment extends Fragment {
    private static final int OPERATION_DELAY_BATH = 120;
    private Favorite.Favorite_post favPostSelected;
    private List<Favorite.Favorite_post> favoriteList;
    int hour;
    int maxHour;
    int maxMinutesAtMaxHour;
    int minute;
    private String sourceFragment;
    SharedViewModel viewModel;
    int count = 0;
    private int found = 0;
    private Handler counterHandler = null;
    private Runnable counterRunnable = null;

    enum Operation {
        HOUR_PLUS,
        HOUR_MINUS,
        MIN_PLUS,
        MIN_MINUS
    }

    public static SetBathTimeFragment newInstance() {
        SetBathTimeFragment setBathTimeFragment = new SetBathTimeFragment();
        setBathTimeFragment.setArguments(new Bundle());
        return setBathTimeFragment;
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
        this.viewModel.getBathTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SetBathTimeFragment.this.m341lambda$onCreateView$0$comtylohelotyloheloSetBathTimeFragment(inflate, (Integer) obj);
            }
        });
        if (getArguments() != null) {
            this.sourceFragment = getArguments().getString("sourceFragment");
        }
        String str = this.sourceFragment;
        if (str != null && str.equals("EditFavFragment")) {
            this.viewModel.getFavList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SetBathTimeFragment.this.m342lambda$onCreateView$1$comtylohelotyloheloSetBathTimeFragment((List) obj);
                }
            });
            this.viewModel.getSelectedFavIndex().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SetBathTimeFragment.this.m343lambda$onCreateView$2$comtylohelotyloheloSetBathTimeFragment(inflate, (Integer) obj);
                }
            });
        } else {
            this.viewModel.getBathTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SetBathTimeFragment.this.m344lambda$onCreateView$3$comtylohelotyloheloSetBathTimeFragment(inflate, (Integer) obj);
                }
            });
        }
        this.viewModel.getMaxBathTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SetBathTimeFragment.this.m345lambda$onCreateView$4$comtylohelotyloheloSetBathTimeFragment((Integer) obj);
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

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ void m341lambda$onCreateView$0$comtylohelotyloheloSetBathTimeFragment(View view, Integer num) {
        if (num == null || this.count != 0) {
            return;
        }
        this.hour = num.intValue() / 60;
        this.minute = num.intValue() % 60;
        setHourMinText(view);
        this.count++;
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ void m342lambda$onCreateView$1$comtylohelotyloheloSetBathTimeFragment(List list) {
        int i;
        if (list == null || (i = this.found) != 0) {
            return;
        }
        this.favoriteList = list;
        this.found = i + 1;
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ void m343lambda$onCreateView$2$comtylohelotyloheloSetBathTimeFragment(View view, Integer num) {
        if (num == null || this.favoriteList.isEmpty()) {
            return;
        }
        Favorite.Favorite_post favorite_post = this.favoriteList.get(num.intValue());
        this.favPostSelected = favorite_post;
        int bathTime = favorite_post.getBathTime();
        this.hour = bathTime / 60;
        this.minute = bathTime % 60;
        setHourMinText(view);
    }

    /* renamed from: lambda$onCreateView$3$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ void m344lambda$onCreateView$3$comtylohelotyloheloSetBathTimeFragment(View view, Integer num) {
        if (num == null || this.count != 0) {
            return;
        }
        this.hour = num.intValue() / 60;
        this.minute = num.intValue() % 60;
        setHourMinText(view);
        this.count++;
    }

    /* renamed from: lambda$onCreateView$4$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ void m345lambda$onCreateView$4$comtylohelotyloheloSetBathTimeFragment(Integer num) {
        if (num != null) {
            this.maxHour = num.intValue() / 60;
            this.maxMinutesAtMaxHour = num.intValue() % 60;
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
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SetBathTimeFragment.this.m339xecdd2591(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickCloseButton$5$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ void m339xecdd2591(NavController navController, View view) {
        String str = this.sourceFragment;
        if (str != null && str.equals("EditFavFragment")) {
            navController.navigate(R.id.action_setBathTimeFragment_to_editFavFragment);
        } else {
            navController.navigate(R.id.action_setBathTimeFragment_to_temperatureFragment3);
        }
    }

    private void onClickSaveButton(final View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SetBathTimeFragment.this.m340xc14ecb6f(view, navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$6$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ void m340xc14ecb6f(View view, NavController navController, View view2) {
        Favorite.Favorite_post.Builder mergeFrom;
        int textHour = (getTextHour(view) * 60) + getTextMinute(view);
        String str = this.sourceFragment;
        if (str != null) {
            if (str.equals("EditFavFragment")) {
                if (this.viewModel.getLocalFavPost() != null) {
                    mergeFrom = Favorite.Favorite_post.newBuilder().mergeFrom(this.viewModel.getLocalFavPost().getValue());
                } else {
                    mergeFrom = Favorite.Favorite_post.newBuilder().mergeFrom(this.favPostSelected);
                }
                mergeFrom.clearBathTime();
                mergeFrom.setBathTime(textHour);
                this.viewModel.setLocalFavPost(mergeFrom.build());
                navController.navigate(R.id.action_setBathTimeFragment_to_editFavFragment);
                return;
            }
            this.viewModel.setBathTime(Integer.valueOf(textHour));
            MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
            if (messageToSaunaSystem == null) {
                messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
                tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
            }
            messageToSaunaSystem.sendBathTime(textHour);
            navController.navigate(R.id.action_setBathTimeFragment_to_temperatureFragment3);
            return;
        }
        this.viewModel.setBathTime(Integer.valueOf(textHour));
        MessageToSaunaSystem messageToSaunaSystem2 = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem2 == null) {
            messageToSaunaSystem2 = new MessageToSaunaSystem(requireActivity());
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem2);
        }
        messageToSaunaSystem2.sendBathTime(textHour);
        navController.navigate(R.id.action_setBathTimeFragment_to_temperatureFragment3);
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
        int i = this.hour + 1;
        this.hour = i;
        int i2 = this.maxHour;
        boolean z = i == i2;
        int i3 = this.minute;
        int i4 = this.maxMinutesAtMaxHour;
        if (z & (i3 > i4)) {
            this.minute = i4;
        }
        if (i > i2) {
            if (this.minute == i4) {
                this.hour = 0;
                this.minute = 1;
            } else {
                this.hour = i2;
                this.minute = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hourDecrease() {
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
                this.minute = this.maxMinutesAtMaxHour;
                this.hour = this.maxHour;
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

    class BathTimeSettings {
        BathTimeSettings() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incHour(View view) {
            SetBathTimeFragment.this.hourIncrease();
            SetBathTimeFragment.this.setHourMinText(view);
            ((Button) view.findViewById(R.id.buttonIncreaseMin)).setEnabled(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incMinute(View view) {
            if (!((SetBathTimeFragment.this.hour == SetBathTimeFragment.this.maxHour) & (SetBathTimeFragment.this.minute == SetBathTimeFragment.this.maxMinutesAtMaxHour))) {
                SetBathTimeFragment.this.minute++;
                if (SetBathTimeFragment.this.minute > 59) {
                    SetBathTimeFragment.this.minute = 0;
                    SetBathTimeFragment.this.hourIncrease();
                }
            }
            if (SetBathTimeFragment.this.hour == SetBathTimeFragment.this.maxHour) {
                SetBathTimeFragment.this.minute = 0;
            }
            ((Button) view.findViewById(R.id.buttonDecreaseMin)).setEnabled(true);
            SetBathTimeFragment.this.setHourMinText(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decHour(View view) {
            ((Button) view.findViewById(R.id.buttonIncreaseMin)).setEnabled(true);
            ((Button) view.findViewById(R.id.buttonDecreaseMin)).setEnabled(true);
            SetBathTimeFragment.this.hourDecrease();
            SetBathTimeFragment.this.setHourMinText(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decMinute(View view, MaterialButton materialButton) {
            if (!((SetBathTimeFragment.this.hour == 0) & (SetBathTimeFragment.this.minute == 1))) {
                SetBathTimeFragment.this.minute--;
                if (SetBathTimeFragment.this.minute < 0) {
                    SetBathTimeFragment.this.minute = 59;
                    SetBathTimeFragment.this.hourDecrease();
                }
            }
            ((Button) view.findViewById(R.id.buttonIncreaseMin)).setEnabled(true);
            materialButton.setEnabled(true);
            SetBathTimeFragment.this.setHourMinText(view);
        }
    }

    private void pressHold(final MaterialButton materialButton, final View view, final Operation operation) {
        final BathTimeSettings bathTimeSettings = new BathTimeSettings();
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SetBathTimeFragment.this.m346lambda$pressHold$7$comtylohelotyloheloSetBathTimeFragment(operation, bathTimeSettings, view, materialButton, view2);
            }
        });
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return SetBathTimeFragment.this.m347lambda$pressHold$8$comtylohelotyloheloSetBathTimeFragment(operation, bathTimeSettings, view, materialButton, view2, motionEvent);
            }
        });
    }

    /* renamed from: lambda$pressHold$7$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ void m346lambda$pressHold$7$comtylohelotyloheloSetBathTimeFragment(final Operation operation, final BathTimeSettings bathTimeSettings, final View view, final MaterialButton materialButton, View view2) {
        this.counterHandler = new Handler();
        this.counterRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.SetBathTimeFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (operation == Operation.HOUR_PLUS) {
                    bathTimeSettings.incHour(view);
                } else if (operation == Operation.HOUR_MINUS) {
                    bathTimeSettings.decHour(view);
                } else if (operation == Operation.MIN_PLUS) {
                    bathTimeSettings.incMinute(view);
                } else if (operation == Operation.MIN_MINUS) {
                    bathTimeSettings.decMinute(view, materialButton);
                }
                SetBathTimeFragment.this.counterHandler.postDelayed(this, 120L);
            }
        };
    }

    /* renamed from: lambda$pressHold$8$com-tylohelo-tylohelo-SetBathTimeFragment, reason: not valid java name */
    /* synthetic */ boolean m347lambda$pressHold$8$comtylohelotyloheloSetBathTimeFragment(Operation operation, BathTimeSettings bathTimeSettings, View view, MaterialButton materialButton, View view2, MotionEvent motionEvent) {
        Handler handler;
        Runnable runnable;
        Runnable runnable2;
        if (motionEvent.getAction() == 0) {
            view2.performClick();
            if (operation == Operation.HOUR_PLUS) {
                bathTimeSettings.incHour(view);
            } else if (operation == Operation.HOUR_MINUS) {
                bathTimeSettings.decHour(view);
            } else if (operation == Operation.MIN_PLUS) {
                bathTimeSettings.incMinute(view);
            } else if (operation == Operation.MIN_MINUS) {
                bathTimeSettings.decMinute(view, materialButton);
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
