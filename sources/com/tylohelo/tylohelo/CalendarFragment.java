package com.tylohelo.tylohelo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.tylohelo.tylohelo.protobuf.Calendar;
import com.tylohelo.tylohelo.protobuf.Favorite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class CalendarFragment extends Fragment {
    private List<Favorite.Favorite_post> favList;
    private Long saunaTime;
    private Integer timeFormat;
    private SharedViewModel viewModel;
    private List<Calendar.Calendar_post> calendarProgramList = null;
    private int programIndex = 1;
    private final List<Integer> programButtonsList = new ArrayList();
    private int refId = 0;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_calendar, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(false);
        ((BottomNavigationView) requireActivity().findViewById(R.id.bottomNavigationView)).setVisibility(0);
        final NavController findNavController = NavHostFragment.findNavController(this);
        this.viewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        this.programButtonsList.clear();
        this.refId = 0;
        displayCalendarPrograms(inflate, findNavController);
        this.viewModel.getTimeFormat().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarFragment.this.m213lambda$onCreateView$0$comtylohelotyloheloCalendarFragment((Integer) obj);
            }
        });
        this.viewModel.getSaunaTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarFragment.this.m214lambda$onCreateView$1$comtylohelotyloheloCalendarFragment((Long) obj);
            }
        });
        this.viewModel.getCalendarProgramList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarFragment.this.m215lambda$onCreateView$2$comtylohelotyloheloCalendarFragment(inflate, findNavController, (List) obj);
            }
        });
        if (tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            onClickAddProgram(inflate, findNavController);
        }
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-CalendarFragment, reason: not valid java name */
    /* synthetic */ void m213lambda$onCreateView$0$comtylohelotyloheloCalendarFragment(Integer num) {
        if (tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            this.timeFormat = num;
        }
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-CalendarFragment, reason: not valid java name */
    /* synthetic */ void m214lambda$onCreateView$1$comtylohelotyloheloCalendarFragment(Long l) {
        if (tyloApplication.isConnected(requireActivity(), this.viewModel)) {
            this.saunaTime = l;
        }
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-CalendarFragment, reason: not valid java name */
    /* synthetic */ void m215lambda$onCreateView$2$comtylohelotyloheloCalendarFragment(View view, NavController navController, List list) {
        if (this.calendarProgramList != list) {
            this.calendarProgramList = list;
            displayCalendarPrograms(view, navController);
        }
    }

    private void displayCalendarPrograms(View view, NavController navController) {
        List<Calendar.Calendar_post> list;
        if (!tyloApplication.isConnected(requireActivity(), this.viewModel) || (list = this.calendarProgramList) == null) {
            return;
        }
        for (Calendar.Calendar_post calendar_post : list) {
            if (calendar_post.hasValid()) {
                if (calendar_post.getValid()) {
                    if (!this.programButtonsList.contains(Integer.valueOf(calendar_post.getIndex())) && isNext24h(calendar_post)) {
                        createProgramButton(view, calendar_post, navController);
                        changePosition(view);
                        this.programButtonsList.add(Integer.valueOf(calendar_post.getIndex()));
                        this.programIndex = calendar_post.getIndex() + 1;
                    } else {
                        MaterialButton materialButton = (MaterialButton) view.findViewWithTag(Integer.valueOf(calendar_post.getIndex()));
                        if (materialButton != null) {
                            setTextCalendarProgram(calendar_post, materialButton);
                        }
                    }
                } else if (this.programButtonsList.contains(Integer.valueOf(calendar_post.getIndex()))) {
                    boolean z = this.programButtonsList.indexOf(Integer.valueOf(calendar_post.getIndex())) == this.programButtonsList.size() - 1;
                    this.programButtonsList.remove(Integer.valueOf(calendar_post.getIndex()));
                    removeButton(view, calendar_post.getIndex(), z);
                }
            }
        }
    }

    private boolean isNext24h(Calendar.Calendar_post calendar_post) {
        if (!calendar_post.hasActivationTime() || this.saunaTime == null) {
            return false;
        }
        long activationTime = calendar_post.getActivationTime();
        int bathTime = calendar_post.getBathTime();
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(activationTime);
        calendar.add(12, bathTime);
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTimeInMillis(this.saunaTime.longValue());
        int i = calendar2.get(5);
        java.util.Calendar calendar3 = java.util.Calendar.getInstance();
        calendar3.setTimeInMillis(this.saunaTime.longValue());
        calendar3.set(5, i + 1);
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar3.getTimeInMillis();
        if (activationTime <= this.saunaTime.longValue() || activationTime >= timeInMillis2) {
            return timeInMillis > this.saunaTime.longValue() && timeInMillis < timeInMillis2;
        }
        return true;
    }

    private void removeButton(View view, int i, boolean z) {
        View findViewWithTag = view.findViewWithTag(Integer.valueOf(i));
        if (this.refId == findViewWithTag.getId() && this.programButtonsList.size() > 0) {
            List<Integer> list = this.programButtonsList;
            this.refId = view.findViewWithTag(Integer.valueOf(list.get(list.size() - 1).intValue())).getId();
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.calendarConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintLayout.removeView(findViewWithTag);
        if (!z) {
            this.refId = 0;
            Iterator<Integer> it = this.programButtonsList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                constraintSet.clear(intValue, 3);
                View findViewWithTag2 = view.findViewWithTag(Integer.valueOf(intValue));
                if (findViewWithTag2 != null) {
                    if (this.programButtonsList.indexOf(Integer.valueOf(intValue)) == 0 || this.programButtonsList.size() == 1) {
                        constraintSet.connect(findViewWithTag2.getId(), 3, R.id.textViewPrograms, 4);
                        this.refId = findViewWithTag2.getId();
                    } else if (this.refId != 0) {
                        constraintSet.connect(findViewWithTag2.getId(), 3, this.refId, 4);
                        this.refId = findViewWithTag2.getId();
                    }
                }
            }
        }
        if (this.refId == 0 || this.programButtonsList.size() == 0) {
            constraintSet.connect(R.id.buttonAddProgram, 3, R.id.textViewPrograms, 4);
            this.refId = 0;
        } else {
            constraintSet.connect(R.id.buttonAddProgram, 3, this.refId, 4);
        }
        constraintSet.applyTo(constraintLayout);
    }

    private void createProgramButton(View view, Calendar.Calendar_post calendar_post, NavController navController) {
        MaterialButton materialButton = new MaterialButton(requireContext());
        materialButton.setId(View.generateViewId());
        materialButton.setTextAlignment(5);
        materialButton.setBackgroundColor(Color.parseColor("#434343"));
        materialButton.setTextColor(Color.parseColor("#FDFCFC"));
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.chevron_right));
        materialButton.setIconGravity(3);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.calendarConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.constrainWidth(materialButton.getId(), 0);
        constraintSet.constrainHeight(materialButton.getId(), -2);
        constraintSet.connect(materialButton.getId(), 6, R.id.textViewPrograms, 6);
        constraintSet.connect(materialButton.getId(), 7, R.id.textViewPrograms, 7);
        if (this.refId == 0) {
            constraintSet.connect(materialButton.getId(), 3, R.id.textViewPrograms, 4);
        } else {
            constraintSet.connect(materialButton.getId(), 3, this.refId, 4);
        }
        this.refId = materialButton.getId();
        if (calendar_post.hasActivationTime()) {
            setTextCalendarProgram(calendar_post, materialButton);
        }
        materialButton.setTag(Integer.valueOf(calendar_post.getIndex()));
        constraintLayout.addView(materialButton);
        constraintSet.applyTo(constraintLayout);
        addClickListeners(materialButton, navController, calendar_post);
    }

    private void setTextCalendarProgram(Calendar.Calendar_post calendar_post, MaterialButton materialButton) {
        String timeString;
        String timeString2;
        CharSequence alignTwoStrings;
        if (this.timeFormat != null) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(calendar_post.getActivationTime());
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            int i = calendar.get(12);
            if (this.timeFormat.intValue() == 11) {
                timeString = tyloApplication.getTimeString(calendar.get(10), i) + FormatDateTime.getAmPm(calendar.get(9));
            } else {
                timeString = tyloApplication.getTimeString(calendar.get(11), i);
            }
            java.util.Calendar calendar2 = java.util.Calendar.getInstance();
            calendar2.setTimeInMillis(calendar_post.getActivationTime());
            calendar2.setTimeZone(TimeZone.getTimeZone("UTC"));
            calendar2.add(12, calendar_post.getBathTime());
            int i2 = calendar2.get(12);
            if (this.timeFormat.intValue() == 11) {
                timeString2 = tyloApplication.getTimeString(calendar2.get(10), i2) + FormatDateTime.getAmPm(calendar2.get(9));
            } else {
                timeString2 = tyloApplication.getTimeString(calendar2.get(11), i2);
            }
            String str = timeString + " - " + timeString2;
            if (calendar_post.hasFavorite()) {
                this.viewModel.getFavList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarFragment$$ExternalSyntheticLambda5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        CalendarFragment.this.m216x89dca33b((List) obj);
                    }
                });
                if (this.favList != null) {
                    int favorite = calendar_post.getFavorite();
                    if (favorite < this.favList.size()) {
                        Favorite.Favorite_post favorite_post = this.favList.get(favorite);
                        if (favorite_post != null) {
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < favorite_post.getNameCount(); i3++) {
                                sb.append((char) favorite_post.getName(i3));
                            }
                            if (calendar_post.hasStandby()) {
                                Integer value = this.viewModel.getStandbyEnabled().getValue();
                                if (value != null && value.intValue() == 1) {
                                    if (calendar_post.getStandby()) {
                                        alignTwoStrings = tyloApplication.alignTwoStrings(str, ((Object) sb) + "\nstandby");
                                    } else {
                                        alignTwoStrings = tyloApplication.alignTwoStrings(str, sb.toString());
                                    }
                                } else {
                                    alignTwoStrings = tyloApplication.alignTwoStrings(str, sb.toString());
                                }
                            } else {
                                alignTwoStrings = tyloApplication.alignTwoStrings(str, sb.toString());
                            }
                            materialButton.setText(alignTwoStrings);
                            return;
                        }
                        return;
                    }
                    materialButton.setText(str);
                    return;
                }
                return;
            }
            if (calendar_post.hasStandby()) {
                Integer value2 = this.viewModel.getStandbyEnabled().getValue();
                if (value2 != null && value2.intValue() == 1) {
                    if (calendar_post.getStandby()) {
                        materialButton.setText(tyloApplication.alignTwoStrings(str, "standby"));
                        return;
                    } else {
                        materialButton.setText(str);
                        return;
                    }
                }
                materialButton.setText(str);
                return;
            }
            materialButton.setText(str);
        }
    }

    /* renamed from: lambda$setTextCalendarProgram$3$com-tylohelo-tylohelo-CalendarFragment, reason: not valid java name */
    /* synthetic */ void m216x89dca33b(List list) {
        this.favList = list;
    }

    private void addClickListeners(Button button, final NavController navController, final Calendar.Calendar_post calendar_post) {
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CalendarFragment.this.m211x8933d933(calendar_post, navController, view);
                }
            });
        }
    }

    /* renamed from: lambda$addClickListeners$4$com-tylohelo-tylohelo-CalendarFragment, reason: not valid java name */
    /* synthetic */ void m211x8933d933(Calendar.Calendar_post calendar_post, NavController navController, View view) {
        this.viewModel.setLocalCalendarPost(calendar_post);
        try {
            navController.navigate(R.id.action_calendarFragment3_to_editCalendarFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changePosition(View view) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.buttonAddProgram);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.calendarConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintLayout.removeView(materialButton);
        constraintSet.applyTo(constraintLayout);
        constraintSet.connect(materialButton.getId(), 3, this.refId, 4);
        constraintLayout.addView(materialButton);
        constraintSet.applyTo(constraintLayout);
    }

    private void onClickAddProgram(View view, final NavController navController) {
        ((MaterialButton) view.findViewById(R.id.buttonAddProgram)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CalendarFragment.this.m212x9cf0c6be(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickAddProgram$5$com-tylohelo-tylohelo-CalendarFragment, reason: not valid java name */
    /* synthetic */ void m212x9cf0c6be(NavController navController, View view) {
        Calendar.Calendar_post.Builder newBuilder = Calendar.Calendar_post.newBuilder();
        newBuilder.setValid(true);
        newBuilder.setIndex(this.programIndex);
        this.viewModel.setLocalCalendarPost(newBuilder.build());
        try {
            navController.navigate(R.id.action_calendarFragment3_to_editCalendarFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
