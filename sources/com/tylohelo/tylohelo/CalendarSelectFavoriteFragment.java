package com.tylohelo.tylohelo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.tylohelo.tylohelo.protobuf.Calendar;
import com.tylohelo.tylohelo.protobuf.Favorite;
import java.util.List;

/* loaded from: classes2.dex */
public class CalendarSelectFavoriteFragment extends Fragment {
    public static final int HUMIDITY_MAX_VALUE = 100;
    public static final int IR_CONSTANT = 101;
    public static final int IR_MAX_VALUE = 111;
    private List<Favorite.Favorite_post> favoriteList;
    private Calendar.Calendar_post localCalendarPost;
    private Integer tempUnit;
    private SharedViewModel viewModel;
    private int favButtonId = 1;
    private int count = 0;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_calendar_select_favorite, viewGroup, false);
        NavController findNavController = NavHostFragment.findNavController(this);
        this.viewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.buttonBackFav);
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.back_button_icon));
        ((TextView) inflate.findViewById(R.id.textViewSelectedFav)).setVisibility(4);
        this.viewModel.getLocalCalendarPost().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectFavoriteFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectFavoriteFragment.this.m235xa5296c4d((Calendar.Calendar_post) obj);
            }
        });
        this.viewModel.getTemperatureUnit().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectFavoriteFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectFavoriteFragment.this.m236xbf44eaec((Integer) obj);
            }
        });
        this.viewModel.getFavList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.CalendarSelectFavoriteFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarSelectFavoriteFragment.this.m237xd960698b(inflate, (List) obj);
            }
        });
        onClickBackButton(materialButton, findNavController);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-CalendarSelectFavoriteFragment, reason: not valid java name */
    /* synthetic */ void m235xa5296c4d(Calendar.Calendar_post calendar_post) {
        if (calendar_post != null) {
            this.localCalendarPost = calendar_post;
        }
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-CalendarSelectFavoriteFragment, reason: not valid java name */
    /* synthetic */ void m236xbf44eaec(Integer num) {
        this.tempUnit = num;
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-CalendarSelectFavoriteFragment, reason: not valid java name */
    /* synthetic */ void m237xd960698b(View view, List list) {
        this.favoriteList = list;
        if (list == null || this.count != 0) {
            return;
        }
        if (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (((Favorite.Favorite_post) list.get(i)).getValid()) {
                    addFavButtons(view, (Favorite.Favorite_post) list.get(i));
                }
            }
        }
        this.count++;
    }

    private void onClickBackButton(MaterialButton materialButton, final NavController navController) {
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectFavoriteFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalendarSelectFavoriteFragment.lambda$onClickBackButton$3(NavController.this, view);
            }
        });
    }

    static /* synthetic */ void lambda$onClickBackButton$3(NavController navController, View view) {
        try {
            navController.navigate(R.id.action_calendarSelectFavoriteFragment_to_editCalendarFragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addFavButtons(View view, Favorite.Favorite_post favorite_post) {
        int favorite;
        MaterialButton materialButton = new MaterialButton(requireContext());
        materialButton.setId(this.favButtonId);
        materialButton.setTextAlignment(5);
        materialButton.setBackgroundColor(Color.parseColor("#434343"));
        materialButton.setTextColor(Color.parseColor("#FDFCFC"));
        Calendar.Calendar_post calendar_post = this.localCalendarPost;
        if (calendar_post != null && calendar_post.hasFavorite() && (favorite = this.localCalendarPost.getFavorite()) == favorite_post.getIndex()) {
            materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
            TextView textView = (TextView) view.findViewById(R.id.textViewSelectedFav);
            textView.setVisibility(0);
            setSelectedFavText(favorite, textView);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.calendarSelectFavConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.constrainWidth(materialButton.getId(), 0);
        constraintSet.constrainHeight(materialButton.getId(), -2);
        constraintSet.connect(this.favButtonId, 6, R.id.textViewSelectedFav, 6);
        constraintSet.connect(this.favButtonId, 7, R.id.textViewSelectedFav, 7);
        int i = this.favButtonId;
        if (i == 1) {
            constraintSet.connect(i, 3, R.id.textViewSelectedFav, 4);
        } else {
            constraintSet.connect(i, 3, i - 1, 4);
        }
        if (favorite_post.getValid()) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < favorite_post.getNameCount(); i2++) {
                sb.append((char) favorite_post.getName(i2));
            }
            materialButton.setText(sb.toString());
            materialButton.setTag(Integer.valueOf(favorite_post.getIndex()));
        }
        constraintLayout.addView(materialButton);
        constraintSet.applyTo(constraintLayout);
        addClickListeners(view);
        this.favButtonId++;
    }

    private void addClickListeners(final View view) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(this.favButtonId);
        final TextView textView = (TextView) view.findViewById(R.id.textViewSelectedFav);
        if (materialButton != null) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.CalendarSelectFavoriteFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CalendarSelectFavoriteFragment.this.m234x5b4562cb(view, materialButton, textView, view2);
                }
            });
        }
    }

    /* renamed from: lambda$addClickListeners$4$com-tylohelo-tylohelo-CalendarSelectFavoriteFragment, reason: not valid java name */
    /* synthetic */ void m234x5b4562cb(View view, MaterialButton materialButton, TextView textView, View view2) {
        int i = 0;
        while (i < this.favButtonId) {
            i++;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
            if (materialButton2 != null) {
                materialButton2.setIcon(null);
            }
        }
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.select_icon));
        int intValue = ((Integer) materialButton.getTag()).intValue();
        textView.setVisibility(0);
        setSelectedFavText(intValue, textView);
        setSelectedFavToCalendarPost(intValue);
        this.viewModel.setIsCalendarFav(true);
        this.viewModel.setSaveChanges(true);
    }

    private void setSelectedFavText(int i, TextView textView) {
        String str;
        List<Favorite.Favorite_post> list = this.favoriteList;
        if (list == null || this.tempUnit == null) {
            return;
        }
        Favorite.Favorite_post favorite_post = list.get(i);
        if (favorite_post.hasTemperatureSetPoint()) {
            str = TemperatureFilter.temperatureFilter(this.tempUnit.intValue(), favorite_post.getTemperatureSetPoint()) + TemperatureFilter.temperatureUnit(this.tempUnit.intValue());
        } else {
            str = null;
        }
        String str2 = str + ", ";
        if (favorite_post.hasHumiditySetPoint()) {
            if (favorite_post.getHumiditySetPoint() <= 100) {
                str2 = (str2 + String.valueOf(favorite_post.getHumiditySetPoint())) + "%";
            } else if (favorite_post.getHumiditySetPoint() <= 111) {
                str2 = str2 + String.valueOf(favorite_post.getHumiditySetPoint() - 101);
            }
        }
        String str3 = str2 + ", ";
        if (favorite_post.hasBathTime()) {
            str3 = str3 + (favorite_post.getBathTime() / 60) + "h " + (favorite_post.getBathTime() % 60) + "min";
        }
        textView.setText(str3);
    }

    private void setSelectedFavToCalendarPost(int i) {
        List<Favorite.Favorite_post> list = this.favoriteList;
        if (list != null) {
            Favorite.Favorite_post favorite_post = list.get(i);
            Calendar.Calendar_post.Builder mergeFrom = Calendar.Calendar_post.newBuilder().mergeFrom(this.localCalendarPost);
            if (favorite_post.hasTemperatureSetPoint()) {
                mergeFrom.clearTemperatureSetPoint();
                mergeFrom.setTemperatureSetPoint(favorite_post.getTemperatureSetPoint());
            }
            if (favorite_post.hasHumiditySetPoint()) {
                mergeFrom.clearHumiditySetPoint();
                mergeFrom.setHumiditySetPoint(favorite_post.getHumiditySetPoint());
            }
            if (favorite_post.hasBathTime()) {
                mergeFrom.clearBathTime();
                mergeFrom.setBathTime(favorite_post.getBathTime());
            }
            mergeFrom.clearFavorite();
            mergeFrom.setFavorite(i);
            this.viewModel.setLocalCalendarPost(mergeFrom.build());
        }
    }
}
