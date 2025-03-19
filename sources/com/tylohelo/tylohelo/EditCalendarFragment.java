package com.tylohelo.tylohelo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;
import com.tylohelo.tylohelo.protobuf.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class EditCalendarFragment extends Fragment {
    public static final int DEFAULT_AM_PM = 0;
    public static final int DEFAULT_HOUR = 11;
    public static final int DEFAULT_MINUTE = 0;
    public static final int NO_FAVORITE = 100;
    private Integer bathTime;
    List<Calendar.Calendar_post> calendarProgramList;
    private Calendar.Calendar_post localCalendarPost;
    private boolean noCalendarProgram = false;
    private Long saunaTime;
    private String srcFragment;
    private boolean standBy;
    private Integer targetTemp;
    private Integer timeFormat;
    private SharedViewModel viewModel;

    public static EditCalendarFragment newInstance() {
        EditCalendarFragment editCalendarFragment = new EditCalendarFragment();
        editCalendarFragment.setArguments(new Bundle());
        return editCalendarFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_edit_calendar, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        NavController findNavController = NavHostFragment.findNavController(this);
        this.viewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        final MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.buttonCustom);
        final MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.buttonFavorite);
        final Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.select_icon);
        final Drawable drawable2 = ContextCompat.getDrawable(requireContext(), R.drawable.chevron_right);
        this.viewModel.getTimeFormat().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditCalendarFragment.this.m248lambda$onCreateView$0$comtylohelotyloheloEditCalendarFragment((Integer) obj);
            }
        });
        this.viewModel.getSaunaTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditCalendarFragment.this.m249lambda$onCreateView$1$comtylohelotyloheloEditCalendarFragment((Long) obj);
            }
        });
        this.viewModel.getCalendarProgramList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditCalendarFragment.this.m250lambda$onCreateView$2$comtylohelotyloheloEditCalendarFragment((List) obj);
            }
        });
        this.viewModel.getLocalCalendarPost().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditCalendarFragment.this.m251lambda$onCreateView$3$comtylohelotyloheloEditCalendarFragment(inflate, materialButton, drawable2, materialButton2, drawable, (Calendar.Calendar_post) obj);
            }
        });
        this.viewModel.getTargetTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditCalendarFragment.this.m252lambda$onCreateView$4$comtylohelotyloheloEditCalendarFragment((Integer) obj);
            }
        });
        this.viewModel.getBathTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditCalendarFragment.this.m253lambda$onCreateView$5$comtylohelotyloheloEditCalendarFragment((Integer) obj);
            }
        });
        MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R.id.buttonBackCal);
        materialButton3.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.back_button_icon));
        final MaterialButton materialButton4 = (MaterialButton) inflate.findViewById(R.id.buttonDeleteProgram);
        materialButton4.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.delete));
        final MaterialButton materialButton5 = (MaterialButton) inflate.findViewById(R.id.buttonSave);
        materialButton5.setVisibility(4);
        this.viewModel.getSaveChanges().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditCalendarFragment.this.m254lambda$onCreateView$6$comtylohelotyloheloEditCalendarFragment(materialButton4, materialButton5, inflate, (Boolean) obj);
            }
        });
        onClickReadyAt(inflate, findNavController);
        MaterialButton materialButton6 = (MaterialButton) inflate.findViewById(R.id.buttonBath);
        materialButton6.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        materialButton6.setIconGravity(1);
        MaterialButton materialButton7 = (MaterialButton) inflate.findViewById(R.id.buttonStandby);
        onClickBathButton(materialButton6, materialButton7);
        Integer value = this.viewModel.getStandbyEnabled().getValue();
        if (value != null) {
            if (value.intValue() == 1) {
                materialButton7.setClickable(true);
                onClickStandByButton(materialButton6, materialButton7);
            } else {
                materialButton7.setClickable(false);
            }
        }
        onClickBackButton(materialButton3, findNavController);
        if (getArguments() != null) {
            this.srcFragment = getArguments().getString("srcFragment");
        }
        String str = this.srcFragment;
        if (str != null && str.equals("ReadyAtFragment")) {
            materialButton4.setVisibility(4);
            materialButton5.setVisibility(0);
        }
        this.viewModel.getIsCalendarFav().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda17
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditCalendarFragment.lambda$onCreateView$7(MaterialButton.this, drawable2, materialButton2, drawable, (Boolean) obj);
            }
        });
        onClickCustomButton(materialButton, materialButton2, drawable2, drawable, findNavController);
        onClickFavorite(materialButton, materialButton2, drawable2, drawable, findNavController);
        onClickSaveButton(inflate, findNavController);
        onClickDeleteButton(materialButton4, findNavController);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m248lambda$onCreateView$0$comtylohelotyloheloEditCalendarFragment(Integer num) {
        this.timeFormat = num;
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m249lambda$onCreateView$1$comtylohelotyloheloEditCalendarFragment(Long l) {
        this.saunaTime = l;
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m250lambda$onCreateView$2$comtylohelotyloheloEditCalendarFragment(List list) {
        this.calendarProgramList = list;
        if (list != null) {
            getNextActivationTime();
        } else {
            this.noCalendarProgram = true;
        }
    }

    /* renamed from: lambda$onCreateView$3$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m251lambda$onCreateView$3$comtylohelotyloheloEditCalendarFragment(View view, MaterialButton materialButton, Drawable drawable, MaterialButton materialButton2, Drawable drawable2, Calendar.Calendar_post calendar_post) {
        this.localCalendarPost = calendar_post;
        if (calendar_post != null) {
            Integer value = this.viewModel.getStandbyEnabled().getValue();
            if (value != null && value.intValue() == 1 && this.localCalendarPost.hasStandby()) {
                boolean standby = this.localCalendarPost.getStandby();
                this.standBy = standby;
                if (standby) {
                    MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.buttonStandby);
                    materialButton3.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
                    materialButton3.setIconGravity(1);
                    ((MaterialButton) view.findViewById(R.id.buttonBath)).setIcon(null);
                }
            }
            if (this.localCalendarPost.hasActivationTime()) {
                setStringReadAt(this.localCalendarPost.getActivationTime(), view);
            }
            if (!this.localCalendarPost.hasFavorite() || this.localCalendarPost.getFavorite() == 100) {
                return;
            }
            materialButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            materialButton2.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, drawable, (Drawable) null);
            this.viewModel.setIsCalendarFav(true);
        }
    }

    /* renamed from: lambda$onCreateView$4$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m252lambda$onCreateView$4$comtylohelotyloheloEditCalendarFragment(Integer num) {
        this.targetTemp = num;
    }

    /* renamed from: lambda$onCreateView$5$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m253lambda$onCreateView$5$comtylohelotyloheloEditCalendarFragment(Integer num) {
        this.bathTime = num;
    }

    /* renamed from: lambda$onCreateView$6$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m254lambda$onCreateView$6$comtylohelotyloheloEditCalendarFragment(MaterialButton materialButton, MaterialButton materialButton2, View view, Boolean bool) {
        long j;
        Long l;
        if (bool == null || !bool.booleanValue()) {
            materialButton.setVisibility(0);
            materialButton2.setVisibility(4);
            return;
        }
        materialButton.setVisibility(4);
        materialButton2.setVisibility(0);
        if (this.localCalendarPost.hasActivationTime()) {
            return;
        }
        Integer num = this.timeFormat;
        if (num != null && (l = this.saunaTime) != null) {
            if (this.noCalendarProgram) {
                j = FormatDateTime.checkForToday(num, l.longValue(), defaultActivationTime()).getTimeInMillis();
                Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
                mergeFrom.clearActivationTime();
                mergeFrom.setActivationTime(j);
                this.viewModel.setLocalCalendarPost(mergeFrom.build());
            } else if (getNextActivationTime() != null) {
                j = FormatDateTime.checkForToday(this.timeFormat, this.saunaTime.longValue(), getNextActivationTime()).getTimeInMillis();
                Calendar.Calendar_post.Builder mergeFrom2 = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
                mergeFrom2.clearActivationTime();
                mergeFrom2.setActivationTime(j);
                this.viewModel.setLocalCalendarPost(mergeFrom2.build());
            }
            setStringReadAt(j, view);
        }
        j = 0;
        setStringReadAt(j, view);
    }

    static /* synthetic */ void lambda$onCreateView$7(MaterialButton materialButton, Drawable drawable, MaterialButton materialButton2, Drawable drawable2, Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            materialButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            materialButton2.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, drawable, (Drawable) null);
        } else {
            materialButton2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            materialButton.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, drawable, (Drawable) null);
        }
    }

    private void setStringReadAt(long j, View view) {
        String timeString;
        if (this.timeFormat != null) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(j);
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            ((TextView) view.findViewById(R.id.textViewDate)).setText(calendar.get(5) + " " + FormatDateTime.getMonth(calendar.get(2)));
            int i = calendar.get(12);
            if (this.timeFormat.intValue() == 11) {
                timeString = tyloApplication.getTimeString(calendar.get(10), i) + FormatDateTime.getAmPm(calendar.get(9));
            } else {
                timeString = tyloApplication.getTimeString(calendar.get(11), i);
            }
            ((MaterialButton) view.findViewById(R.id.buttonReadyAt)).setText(tyloApplication.alignTwoStrings("Ready at", timeString));
        }
    }

    private java.util.Calendar getNextActivationTime() {
        ArrayList arrayList = new ArrayList();
        List<Calendar.Calendar_post> list = this.calendarProgramList;
        if (list != null) {
            if (list.size() > 1) {
                for (Calendar.Calendar_post calendar_post : this.calendarProgramList) {
                    if (calendar_post.hasValid() && calendar_post.getValid()) {
                        this.noCalendarProgram = false;
                        arrayList.add(Integer.valueOf(calendar_post.getIndex()));
                    }
                }
                if (arrayList.size() != 0) {
                    Calendar.Calendar_post calendar_post2 = this.calendarProgramList.get(((Integer) arrayList.get(arrayList.size() - 1)).intValue());
                    if (calendar_post2.hasActivationTime() && calendar_post2.hasBathTime()) {
                        java.util.Calendar calendar = java.util.Calendar.getInstance();
                        calendar.setTimeInMillis(calendar_post2.getActivationTime());
                        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
                        calendar.add(12, calendar_post2.getBathTime());
                        return calendar;
                    }
                }
            }
            this.noCalendarProgram = true;
            return null;
        }
        this.noCalendarProgram = true;
        return null;
    }

    private void onClickFavorite(final MaterialButton materialButton, final MaterialButton materialButton2, final Drawable drawable, final Drawable drawable2, final NavController navController) {
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCalendarFragment.this.m244x4e7dcbac(materialButton, drawable, materialButton2, drawable2, navController, view);
            }
        });
    }

    /* renamed from: lambda$onClickFavorite$8$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m244x4e7dcbac(MaterialButton materialButton, Drawable drawable, MaterialButton materialButton2, Drawable drawable2, NavController navController, View view) {
        materialButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        materialButton2.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, drawable, (Drawable) null);
        this.viewModel.setLocalCalendarPost(this.localCalendarPost);
        try {
            navController.navigate(R.id.action_editCalendarFragment_to_calendarSelectFavoriteFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onClickCustomButton(MaterialButton materialButton, MaterialButton materialButton2, Drawable drawable, Drawable drawable2, final NavController navController) {
        materialButton2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        materialButton.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, drawable, (Drawable) null);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCalendarFragment.lambda$onClickCustomButton$9(NavController.this, view);
            }
        });
    }

    static /* synthetic */ void lambda$onClickCustomButton$9(NavController navController, View view) {
        try {
            navController.navigate(R.id.action_editCalendarFragment_to_calendarSelectCustomFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onClickSaveButton(View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonSave)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditCalendarFragment.this.m246x5d572760(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickSaveButton$10$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m246x5d572760(NavController navController, View view) {
        Integer num;
        Integer num2;
        Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
        if (!mergeFrom.hasActivationTime()) {
            if (this.noCalendarProgram && this.saunaTime != null) {
                mergeFrom.setActivationTime(defaultActivationTime().getTimeInMillis());
            } else if (getNextActivationTime() != null) {
                mergeFrom.setActivationTime(getNextActivationTime().getTimeInMillis());
            }
        }
        mergeFrom.clearStandby();
        mergeFrom.setStandby(this.standBy);
        if (!this.localCalendarPost.hasTemperatureSetPoint() && (num2 = this.targetTemp) != null) {
            mergeFrom.setTemperatureSetPoint(num2.intValue());
        }
        if (!this.localCalendarPost.hasBathTime() && (num = this.bathTime) != null) {
            mergeFrom.setBathTime(num.intValue());
        }
        mergeFrom.setWeekday(false);
        mergeFrom.setStartMode(Calendar.Calendar_post.start_mode_t.START_MODE_READY_AT);
        if (!this.localCalendarPost.hasFavorite()) {
            mergeFrom.setFavorite(100);
            this.viewModel.setIsCalendarFav(false);
        }
        Calendar.Calendar_post build = mergeFrom.build();
        if (this.calendarProgramList != null) {
            ArrayList arrayList = new ArrayList(this.calendarProgramList);
            if (build.getIndex() < arrayList.size()) {
                arrayList.set(build.getIndex(), build);
            }
            this.viewModel.setCalendarProgramList(arrayList);
        }
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendCalendarProgram(build);
        this.viewModel.setLocalCalendarPost(null);
        this.viewModel.setSaveChanges(false);
        this.viewModel.setIsCalendarFav(false);
        try {
            navController.navigate(R.id.action_editCalendarFragment_to_calendarFragment3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private java.util.Calendar defaultActivationTime() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        calendar.set(5, calendar2.get(5));
        calendar.set(2, calendar2.get(2));
        Long l = this.saunaTime;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            Integer num = this.timeFormat;
            if (num != null && num.intValue() == 11) {
                calendar.set(10, 11);
                calendar.set(9, 0);
            } else {
                calendar.set(11, 11);
            }
            calendar.set(12, 0);
        }
        return calendar;
    }

    private void onClickDeleteButton(MaterialButton materialButton, final NavController navController) {
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCalendarFragment.this.m243xed35f1ab(navController, view);
            }
        });
    }

    /* renamed from: lambda$onClickDeleteButton$13$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m243xed35f1ab(final NavController navController, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Message");
        builder.setCancelable(false);
        builder.setMessage("Confirm delete of calendar program");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EditCalendarFragment.this.m242x675d1eed(navController, dialogInterface, i);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    /* renamed from: lambda$onClickDeleteButton$11$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m242x675d1eed(NavController navController, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
        mergeFrom.setValid(false);
        Calendar.Calendar_post build = mergeFrom.build();
        ArrayList arrayList = new ArrayList(this.calendarProgramList);
        if (build.getIndex() < arrayList.size()) {
            arrayList.set(build.getIndex(), build);
            this.viewModel.setCalendarProgramList(arrayList);
        }
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(requireActivity());
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendDeleteCalendarProgram(build);
        try {
            navController.navigate(R.id.action_editCalendarFragment_to_calendarFragment3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onClickReadyAt(View view, final NavController navController) {
        ((Button) view.findViewById(R.id.buttonReadyAt)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditCalendarFragment.this.m245x642423eb(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickReadyAt$14$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m245x642423eb(NavController navController, View view) {
        Long l;
        Integer num = this.timeFormat;
        if (num != null && (l = this.saunaTime) != null) {
            if (this.noCalendarProgram) {
                Date time = FormatDateTime.checkForToday(num, l.longValue(), defaultActivationTime()).getTime();
                Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
                if (!this.localCalendarPost.hasActivationTime()) {
                    mergeFrom.setActivationTime(time.getTime());
                }
                this.viewModel.setLocalCalendarPost(mergeFrom.build());
            } else if (getNextActivationTime() != null) {
                Date time2 = FormatDateTime.checkForToday(this.timeFormat, this.saunaTime.longValue(), getNextActivationTime()).getTime();
                Calendar.Calendar_post.Builder mergeFrom2 = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
                if (!this.localCalendarPost.hasActivationTime()) {
                    mergeFrom2.setActivationTime(time2.getTime());
                }
                this.viewModel.setLocalCalendarPost(mergeFrom2.build());
            }
        }
        try {
            navController.navigate(R.id.action_editCalendarFragment_to_readyAtFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onClickBathButton(final MaterialButton materialButton, final MaterialButton materialButton2) {
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCalendarFragment.this.m241x8ad2ccb1(materialButton, materialButton2, view);
            }
        });
    }

    /* renamed from: lambda$onClickBathButton$15$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m241x8ad2ccb1(MaterialButton materialButton, MaterialButton materialButton2, View view) {
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        materialButton.setIconGravity(1);
        materialButton2.setIcon(null);
        this.standBy = false;
        this.viewModel.setSaveChanges(true);
    }

    private void onClickStandByButton(final MaterialButton materialButton, final MaterialButton materialButton2) {
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCalendarFragment.this.m247x32597712(materialButton2, materialButton, view);
            }
        });
    }

    /* renamed from: lambda$onClickStandByButton$16$com-tylohelo-tylohelo-EditCalendarFragment, reason: not valid java name */
    /* synthetic */ void m247x32597712(MaterialButton materialButton, MaterialButton materialButton2, View view) {
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        materialButton.setIconGravity(1);
        materialButton2.setIcon(null);
        this.standBy = true;
        this.viewModel.setSaveChanges(true);
        Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
        mergeFrom.setStandby(this.standBy);
        this.viewModel.setLocalCalendarPost(mergeFrom.build());
    }

    private void onClickBackButton(MaterialButton materialButton, final NavController navController) {
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.EditCalendarFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCalendarFragment.lambda$onClickBackButton$17(NavController.this, view);
            }
        });
    }

    static /* synthetic */ void lambda$onClickBackButton$17(NavController navController, View view) {
        try {
            navController.navigate(R.id.action_editCalendarFragment_to_calendarFragment3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
