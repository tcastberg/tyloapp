package com.tylohelo.tylohelo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.tylohelo.tylohelo.protobuf.Favorite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class FavoriteFragment extends Fragment {
    private List<Favorite.Favorite_post> favoriteList;
    private SharedViewModel viewModel;
    private int refId = 0;
    private final List<Integer> favButtonsList = new ArrayList();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_favorite, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(false);
        ((BottomNavigationView) requireActivity().findViewById(R.id.bottomNavigationView)).setVisibility(0);
        this.viewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        final NavController findNavController = NavHostFragment.findNavController(this);
        this.favButtonsList.clear();
        this.refId = 0;
        displayFavList(inflate, findNavController);
        this.viewModel.getFavList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.FavoriteFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FavoriteFragment.this.m289lambda$onCreateView$0$comtylohelotyloheloFavoriteFragment(inflate, findNavController, (List) obj);
            }
        });
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-FavoriteFragment, reason: not valid java name */
    /* synthetic */ void m289lambda$onCreateView$0$comtylohelotyloheloFavoriteFragment(View view, NavController navController, List list) {
        if (this.favoriteList != list) {
            this.favoriteList = list;
            displayFavList(view, navController);
        }
    }

    private void displayFavList(View view, NavController navController) {
        if (!tyloApplication.isConnected(requireActivity(), this.viewModel) || this.favoriteList == null) {
            return;
        }
        for (int i = 0; i < this.favoriteList.size(); i++) {
            Favorite.Favorite_post favorite_post = this.favoriteList.get(i);
            if (favorite_post != null && favorite_post.hasValid()) {
                if (favorite_post.getValid()) {
                    if (!this.favButtonsList.contains(Integer.valueOf(favorite_post.getIndex()))) {
                        addFavButtons(view, favorite_post, navController);
                        this.favButtonsList.add(Integer.valueOf(favorite_post.getIndex()));
                    }
                } else if (this.favButtonsList.contains(Integer.valueOf(favorite_post.getIndex()))) {
                    boolean z = this.favButtonsList.indexOf(Integer.valueOf(favorite_post.getIndex())) == this.favButtonsList.size() - 1;
                    this.favButtonsList.remove(Integer.valueOf(favorite_post.getIndex()));
                    removeFavButton(view, favorite_post.getIndex(), z);
                }
            }
        }
    }

    private void removeFavButton(View view, int i, boolean z) {
        View findViewWithTag = view.findViewWithTag(Integer.valueOf(i));
        if (this.refId == findViewWithTag.getId() && this.favButtonsList.size() > 0) {
            List<Integer> list = this.favButtonsList;
            this.refId = view.findViewWithTag(Integer.valueOf(list.get(list.size() - 1).intValue())).getId();
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.favConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintLayout.removeView(findViewWithTag);
        if (!z) {
            this.refId = 0;
            Iterator<Integer> it = this.favButtonsList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                constraintSet.clear(intValue, 3);
                View findViewWithTag2 = view.findViewWithTag(Integer.valueOf(intValue));
                if (findViewWithTag2 != null) {
                    if (this.favButtonsList.indexOf(Integer.valueOf(intValue)) == 0 || this.favButtonsList.size() == 1 || this.refId == 0) {
                        constraintSet.connect(findViewWithTag2.getId(), 3, R.id.textViewFav, 4);
                    } else {
                        constraintSet.connect(findViewWithTag2.getId(), 3, this.refId, 4);
                    }
                    this.refId = findViewWithTag2.getId();
                }
            }
        }
        if (this.favButtonsList.size() == 0) {
            this.refId = 0;
        }
        constraintSet.applyTo(constraintLayout);
    }

    private void addFavButtons(View view, Favorite.Favorite_post favorite_post, NavController navController) {
        MaterialButton materialButton = new MaterialButton(requireContext());
        materialButton.setId(View.generateViewId());
        materialButton.setTextAlignment(5);
        materialButton.setBackgroundColor(Color.parseColor("#434343"));
        materialButton.setTextColor(Color.parseColor("#FDFCFC"));
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.favConstraintLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.constrainWidth(materialButton.getId(), 0);
        constraintSet.constrainHeight(materialButton.getId(), -2);
        constraintSet.connect(materialButton.getId(), 6, R.id.textViewFav, 6);
        constraintSet.connect(materialButton.getId(), 7, R.id.textViewFav, 7);
        if (this.refId == 0) {
            constraintSet.connect(materialButton.getId(), 3, R.id.textViewFav, 4);
        } else {
            constraintSet.connect(materialButton.getId(), 3, this.refId, 4);
        }
        this.refId = materialButton.getId();
        if (favorite_post.getValid()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < favorite_post.getNameCount(); i++) {
                sb.append((char) favorite_post.getName(i));
            }
            materialButton.setText(sb.toString());
            materialButton.setTag(Integer.valueOf(favorite_post.getIndex()));
            materialButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.chevron_right, 0);
        }
        constraintLayout.addView(materialButton);
        constraintSet.applyTo(constraintLayout);
        addClickListeners(materialButton, navController);
    }

    private void addClickListeners(final MaterialButton materialButton, final NavController navController) {
        if (materialButton != null) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.FavoriteFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FavoriteFragment.this.m288xed8f96f4(materialButton, navController, view);
                }
            });
        }
    }

    /* renamed from: lambda$addClickListeners$1$com-tylohelo-tylohelo-FavoriteFragment, reason: not valid java name */
    /* synthetic */ void m288xed8f96f4(MaterialButton materialButton, NavController navController, View view) {
        this.viewModel.setSelectedFavIndex(Integer.valueOf(((Integer) materialButton.getTag()).intValue()));
        List<Favorite.Favorite_post> list = this.favoriteList;
        if (list != null) {
            this.viewModel.setFavList(list);
        }
        navController.navigate(R.id.action_favoriteFragment3_to_editFavFragment);
    }
}
