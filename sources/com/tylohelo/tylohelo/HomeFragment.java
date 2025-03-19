package com.tylohelo.tylohelo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tylohelo.tylohelo.protobuf.SaunaState;

/* loaded from: classes2.dex */
public class HomeFragment extends Fragment implements BackPressedListener {
    public static BackPressedListener backPressedListener;
    private Integer externalHumid;
    private Integer externalTemp;
    private Integer humiditySensorAvailable;
    private Integer presentedHumidity;
    TextView presentedHumidityPercentTextBox;
    private Integer presentedHumiditySettingsVal;
    TextView presentedHumidityTextBox;
    private Integer presentedTemp;
    private Integer presentedTempSettingsVal;
    TextView presentedTempTexBox;
    private SaunaState.Sauna_state_changed.state_t saunaState;
    private Integer targetHumidity;
    private Integer targetTemp;
    private Integer tempUnit;
    private Integer upperLimitTemp;
    View viewLine;
    private Integer waterLevelValue;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        ((MainActivity) requireActivity()).setLinearLayoutVisibility(true);
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(getActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        if (saunaService.getCloudEnabled()) {
            ((MainActivity) requireActivity()).setCloudImageVisibility(true);
            ((MainActivity) requireActivity()).setWifiImageVisibility(false);
        } else {
            ((MainActivity) requireActivity()).setCloudImageVisibility(false);
        }
        ((MainActivity) requireActivity()).setTouchListener(inflate);
        final SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        this.presentedHumidityTextBox = (TextView) inflate.findViewById(R.id.textViewPresentedHumidityValue);
        this.presentedHumidityPercentTextBox = (TextView) inflate.findViewById(R.id.textViewPresentedHumidity);
        this.viewLine = inflate.findViewById(R.id.viewLine);
        this.presentedTempTexBox = (TextView) inflate.findViewById(R.id.textViewPresentedTemp);
        defaultHome(inflate, sharedViewModel);
        sharedViewModel.getPresentedTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m292lambda$onCreateView$0$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        sharedViewModel.getTargetTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m293lambda$onCreateView$1$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        sharedViewModel.getPresentedHumidity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m297lambda$onCreateView$2$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        sharedViewModel.getHumidityPresentation().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m298lambda$onCreateView$3$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        sharedViewModel.getExternalHumidity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m299lambda$onCreateView$4$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        showWifiSymbol(sharedViewModel, saunaService);
        ((MainActivity) requireActivity()).setLogoImageVisibility(true);
        ((MainActivity) requireActivity()).handleStandbyButton();
        sharedViewModel.getTargetHumidity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m300lambda$onCreateView$5$comtylohelotyloheloHomeFragment(inflate, sharedViewModel, (Integer) obj);
            }
        });
        sharedViewModel.getWaterLevel().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m301lambda$onCreateView$6$comtylohelotyloheloHomeFragment(inflate, sharedViewModel, (Integer) obj);
            }
        });
        sharedViewModel.getSaunaState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m302lambda$onCreateView$7$comtylohelotyloheloHomeFragment(inflate, sharedViewModel, (SaunaState.Sauna_state_changed.state_t) obj);
            }
        });
        sharedViewModel.getTemperatureUnit().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m303lambda$onCreateView$8$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        sharedViewModel.getTemperaturePresentation().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m304lambda$onCreateView$9$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        sharedViewModel.getExternalTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m294lambda$onCreateView$10$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        sharedViewModel.getUpperLimitTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m295lambda$onCreateView$11$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        sharedViewModel.getHumiditySensorAvailable().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m296lambda$onCreateView$12$comtylohelotyloheloHomeFragment(sharedViewModel, inflate, (Integer) obj);
            }
        });
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m292lambda$onCreateView$0$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.presentedTemp = num;
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel) && this.presentedTemp != null) {
            setTextTemperatureCenter(view);
        } else {
            defaultHome(view, sharedViewModel);
        }
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m293lambda$onCreateView$1$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.targetTemp = num;
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel) && this.targetTemp != null) {
            setTextTemperatureTop(view);
        } else {
            defaultHome(view, sharedViewModel);
        }
    }

    /* renamed from: lambda$onCreateView$2$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m297lambda$onCreateView$2$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.presentedHumidity = num;
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel) && num != null) {
            setTextHumidityCentre(sharedViewModel);
        } else {
            defaultHome(view, sharedViewModel);
        }
    }

    /* renamed from: lambda$onCreateView$3$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m298lambda$onCreateView$3$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.presentedHumiditySettingsVal = num;
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel) && num != null) {
            setTextHumidityCentre(sharedViewModel);
        } else {
            defaultHome(view, sharedViewModel);
        }
    }

    /* renamed from: lambda$onCreateView$4$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m299lambda$onCreateView$4$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.externalHumid = num;
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel) && num != null) {
            setTextHumidityCentre(sharedViewModel);
        } else {
            defaultHome(view, sharedViewModel);
        }
    }

    /* renamed from: lambda$onCreateView$5$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m300lambda$onCreateView$5$comtylohelotyloheloHomeFragment(View view, SharedViewModel sharedViewModel, Integer num) {
        TextView textView = (TextView) view.findViewById(R.id.textViewTargetHumidity);
        this.targetHumidity = num;
        if (!tyloApplication.isConnected(requireActivity(), sharedViewModel) || this.targetHumidity == null) {
            textView.setVisibility(8);
        } else {
            setTextHumidityTopRight(textView);
        }
    }

    /* renamed from: lambda$onCreateView$6$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m301lambda$onCreateView$6$comtylohelotyloheloHomeFragment(View view, SharedViewModel sharedViewModel, Integer num) {
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewWaterLevel);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageViewWaterLevel2);
        this.waterLevelValue = num;
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel) && this.waterLevelValue != null) {
            setWaterLevel(imageView, imageView2, sharedViewModel);
        } else {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
        }
    }

    /* renamed from: lambda$onCreateView$7$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m302lambda$onCreateView$7$comtylohelotyloheloHomeFragment(View view, SharedViewModel sharedViewModel, SaunaState.Sauna_state_changed.state_t state_tVar) {
        TextView textView = (TextView) view.findViewById(R.id.textViewBathTime);
        this.saunaState = state_tVar;
        if (!tyloApplication.isConnected(requireActivity(), sharedViewModel) || this.saunaState == null) {
            textView.setVisibility(8);
        } else {
            bathTimeLeft(textView);
        }
    }

    /* renamed from: lambda$onCreateView$8$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m303lambda$onCreateView$8$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.tempUnit = num;
        if (!tyloApplication.isConnected(requireActivity(), sharedViewModel) || this.tempUnit == null) {
            return;
        }
        setTextTemperatureCenter(view);
        setTextTemperatureTop(view);
    }

    /* renamed from: lambda$onCreateView$9$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m304lambda$onCreateView$9$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.presentedTempSettingsVal = num;
        if (!tyloApplication.isConnected(requireActivity(), sharedViewModel) || this.presentedTempSettingsVal == null) {
            return;
        }
        setTextTemperatureCenter(view);
    }

    /* renamed from: lambda$onCreateView$10$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m294lambda$onCreateView$10$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.externalTemp = num;
        if (!tyloApplication.isConnected(requireActivity(), sharedViewModel) || this.externalTemp == null) {
            return;
        }
        setTextTemperatureCenter(view);
    }

    /* renamed from: lambda$onCreateView$11$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m295lambda$onCreateView$11$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.upperLimitTemp = num;
        if (!tyloApplication.isConnected(requireActivity(), sharedViewModel) || this.upperLimitTemp == null) {
            return;
        }
        setTextTemperatureTop(view);
    }

    /* renamed from: lambda$onCreateView$12$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m296lambda$onCreateView$12$comtylohelotyloheloHomeFragment(SharedViewModel sharedViewModel, View view, Integer num) {
        this.humiditySensorAvailable = num;
        if (!tyloApplication.isConnected(requireActivity(), sharedViewModel) || this.humiditySensorAvailable == null) {
            return;
        }
        setTextHumidityTopRight((TextView) view.findViewById(R.id.textViewTargetHumidity));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        backPressedListener = null;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        backPressedListener = null;
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        backPressedListener = this;
    }

    @Override // com.tylohelo.tylohelo.BackPressedListener
    public void onBackPressed() {
        try {
            requireActivity().finish();
            backPressedListener = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTextTemperatureCenter(View view) {
        TextView textView = (TextView) view.findViewById(R.id.textViewPresentedTemp);
        TextView textView2 = (TextView) view.findViewById(R.id.textViewPresentedUnit);
        if (this.tempUnit != null) {
            Integer num = this.presentedTempSettingsVal;
            if (num != null && num.intValue() == 10 && this.presentedTemp != null) {
                textView.setText(TemperatureFilter.temperatureFilter(this.tempUnit.intValue(), this.presentedTemp.intValue()));
                textView2.setText(TemperatureFilter.temperatureUnit(this.tempUnit.intValue()));
            } else if (this.externalTemp != null) {
                textView.setText(TemperatureFilter.temperatureFilter(this.tempUnit.intValue(), this.externalTemp.intValue()));
                textView2.setText(TemperatureFilter.temperatureUnit(this.tempUnit.intValue()));
            }
        }
    }

    private void setTextHumidityCentre(SharedViewModel sharedViewModel) {
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel)) {
            if (new HumidityFilter(requireContext(), requireActivity()).showHumidity()) {
                checkForHumidityPresentationSettings(sharedViewModel);
                return;
            }
            this.presentedHumidityTextBox.setVisibility(8);
            this.presentedHumidityPercentTextBox.setVisibility(8);
            this.viewLine.setVisibility(8);
            return;
        }
        this.viewLine.setVisibility(4);
        this.presentedHumidityTextBox.setVisibility(4);
        this.presentedHumidityPercentTextBox.setVisibility(4);
    }

    private void checkForHumidityPresentationSettings(SharedViewModel sharedViewModel) {
        Integer num;
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel)) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.presentedTempTexBox.getLayoutParams();
            layoutParams.verticalBias = 0.3f;
            Integer num2 = this.presentedHumidity;
            if (num2 != null) {
                if (num2.intValue() == 0 && (num = this.presentedHumiditySettingsVal) != null && num.intValue() == 10) {
                    layoutParams.verticalBias = 0.5f;
                    this.presentedTempTexBox.setLayoutParams(layoutParams);
                    this.presentedHumidityPercentTextBox.setVisibility(4);
                    this.presentedHumidityTextBox.setVisibility(4);
                    this.viewLine.setVisibility(4);
                    return;
                }
                this.presentedTempTexBox.setLayoutParams(layoutParams);
                this.presentedHumidityTextBox.setText(this.presentedHumidity.toString());
                this.presentedHumidityPercentTextBox.setText("%");
                this.viewLine.setVisibility(0);
                this.presentedHumidityTextBox.setVisibility(0);
                this.presentedHumidityPercentTextBox.setVisibility(0);
                return;
            }
            Integer num3 = this.externalHumid;
            if (num3 != null && num3.intValue() == 0) {
                layoutParams.verticalBias = 0.5f;
                this.presentedTempTexBox.setLayoutParams(layoutParams);
                this.presentedHumidityTextBox.setVisibility(4);
                this.presentedHumidityPercentTextBox.setVisibility(4);
                this.viewLine.setVisibility(4);
                return;
            }
            if (this.externalHumid != null) {
                this.presentedTempTexBox.setLayoutParams(layoutParams);
                this.presentedHumidityTextBox.setText(this.externalHumid.toString());
                this.presentedHumidityPercentTextBox.setText("%");
                this.viewLine.setVisibility(0);
                this.presentedHumidityTextBox.setVisibility(0);
                this.presentedHumidityPercentTextBox.setVisibility(0);
            }
        }
    }

    private void setTextTemperatureTop(View view) {
        Integer num;
        String temperatureFilter;
        TextView textView = (TextView) view.findViewById(R.id.textViewTargetTemp);
        if (this.tempUnit == null || (num = this.targetTemp) == null) {
            return;
        }
        if (this.upperLimitTemp != null && num.intValue() > this.upperLimitTemp.intValue()) {
            temperatureFilter = TemperatureFilter.temperatureFilter(this.tempUnit.intValue(), this.upperLimitTemp.intValue());
        } else {
            temperatureFilter = TemperatureFilter.temperatureFilter(this.tempUnit.intValue(), this.targetTemp.intValue());
        }
        textView.setText(temperatureFilter + TemperatureFilter.temperatureUnit(this.tempUnit.intValue()));
    }

    private void setTextHumidityTopRight(TextView textView) {
        Integer num;
        HumidityFilter humidityFilter = new HumidityFilter(requireContext(), requireActivity());
        if (this.targetHumidity != null) {
            if (humidityFilter.showHumidity() && (num = this.humiditySensorAvailable) != null && num.intValue() == 1) {
                textView.setText(this.targetHumidity + "%");
                textView.setVisibility(0);
            } else if (humidityFilter.showIr()) {
                textView.setText("IR " + (this.targetHumidity.intValue() - 101));
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    private void setWaterLevel(ImageView imageView, ImageView imageView2, SharedViewModel sharedViewModel) {
        Integer num;
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(requireActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        String currentSaunaId = saunaService.getCurrentSaunaId();
        if (currentSaunaId != null) {
            if (saunaService.getSaunaStored(currentSaunaId) != null && tyloApplication.isConnected(requireActivity(), sharedViewModel)) {
                if (showWaterLevel() && (num = this.waterLevelValue) != null) {
                    if (num.intValue() == 10 || this.waterLevelValue.intValue() == 11 || this.waterLevelValue.intValue() == 12) {
                        imageView.setVisibility(0);
                        imageView2.setVisibility(0);
                        if (this.waterLevelValue.intValue() == 10) {
                            imageView.setImageResource(R.drawable.water_level_low);
                            imageView2.setImageResource(R.drawable.water_level_low);
                            imageView.setColorFilter(Color.parseColor("#434343"));
                            imageView2.setColorFilter(Color.parseColor("#434343"));
                            return;
                        }
                        if (this.waterLevelValue.intValue() == 11) {
                            imageView.setImageResource(R.drawable.water_level_high);
                            imageView2.setImageResource(R.drawable.water_level_low);
                            imageView.clearColorFilter();
                            imageView2.setColorFilter(Color.parseColor("#434343"));
                            return;
                        }
                        if (this.waterLevelValue.intValue() == 12) {
                            imageView.setImageResource(R.drawable.water_level_high);
                            imageView2.setImageResource(R.drawable.water_level_high);
                            imageView.clearColorFilter();
                            imageView2.clearColorFilter();
                            return;
                        }
                        return;
                    }
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    return;
                }
                imageView.setVisibility(8);
                imageView2.setVisibility(8);
                return;
            }
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
            return;
        }
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
    }

    private void bathTimeLeft(final TextView textView) {
        SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        SaunaState.Sauna_state_changed.state_t state_tVar = this.saunaState;
        if (state_tVar != null) {
            if (state_tVar.getNumber() == 11 || this.saunaState.getNumber() == 12) {
                sharedViewModel.getRunTimeLeft().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeFragment.lambda$bathTimeLeft$13(textView, (Integer) obj);
                    }
                });
                return;
            } else {
                textView.setVisibility(8);
                return;
            }
        }
        textView.setVisibility(8);
    }

    static /* synthetic */ void lambda$bathTimeLeft$13(TextView textView, Integer num) {
        String valueOf;
        if (num == null || num.intValue() > 9999 || num.intValue() == 0) {
            textView.setVisibility(8);
            return;
        }
        int intValue = num.intValue() / 60;
        int intValue2 = num.intValue() % 60;
        if (intValue2 == 0) {
            valueOf = "00";
        } else if (intValue2 < 10) {
            valueOf = "0" + intValue2;
        } else {
            valueOf = String.valueOf(intValue2);
        }
        textView.setText(" " + intValue + ":" + valueOf);
        textView.setVisibility(0);
    }

    private void defaultHome(View view, SharedViewModel sharedViewModel) {
        TextView textView = (TextView) view.findViewById(R.id.textViewTargetTemp);
        TextView textView2 = (TextView) view.findViewById(R.id.textViewBathTime);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewWaterLevel);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageViewWaterLevel2);
        TextView textView3 = (TextView) view.findViewById(R.id.textViewTargetHumidity);
        TextView textView4 = (TextView) view.findViewById(R.id.textViewPresentedTemp);
        View findViewById = view.findViewById(R.id.viewLine);
        TextView textView5 = (TextView) view.findViewById(R.id.textViewPresentedHumidityValue);
        TextView textView6 = (TextView) view.findViewById(R.id.textViewPresentedHumidity);
        textView.setVisibility(0);
        textView4.setVisibility(0);
        if (tyloApplication.isConnected(requireActivity(), sharedViewModel)) {
            getHomeElements(sharedViewModel);
            setTextTemperatureCenter(view);
            setTextHumidityCentre(sharedViewModel);
            setTextTemperatureTop(view);
            setTextHumidityTopRight(textView3);
            setWaterLevel(imageView, imageView2, sharedViewModel);
            bathTimeLeft(textView2);
            return;
        }
        textView.setText("0°");
        findViewById.setVisibility(4);
        textView5.setVisibility(4);
        textView6.setVisibility(4);
        textView3.setVisibility(4);
        imageView.setVisibility(4);
        imageView2.setVisibility(4);
        textView2.setVisibility(4);
    }

    private void getHomeElements(SharedViewModel sharedViewModel) {
        this.presentedTemp = sharedViewModel.getPresentedTemperature().getValue();
        this.targetTemp = sharedViewModel.getTargetTemperature().getValue();
        this.presentedHumidity = sharedViewModel.getPresentedHumidity().getValue();
        this.presentedHumiditySettingsVal = sharedViewModel.getHumidityPresentation().getValue();
        this.externalHumid = sharedViewModel.getExternalHumidity().getValue();
        this.targetHumidity = sharedViewModel.getTargetHumidity().getValue();
        this.waterLevelValue = sharedViewModel.getWaterLevel().getValue();
        this.saunaState = sharedViewModel.getSaunaState().getValue();
        this.tempUnit = sharedViewModel.getTemperatureUnit().getValue();
        this.presentedTempSettingsVal = sharedViewModel.getTemperaturePresentation().getValue();
        this.externalTemp = sharedViewModel.getExternalTemperature().getValue();
        this.humiditySensorAvailable = sharedViewModel.getHumiditySensorAvailable().getValue();
    }

    private void showWifiSymbol(final SharedViewModel sharedViewModel, final SaunaService saunaService) {
        sharedViewModel.getWifiOnline().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.HomeFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.m305lambda$showWifiSymbol$14$comtylohelotyloheloHomeFragment(saunaService, sharedViewModel, (Boolean) obj);
            }
        });
    }

    /* renamed from: lambda$showWifiSymbol$14$com-tylohelo-tylohelo-HomeFragment, reason: not valid java name */
    /* synthetic */ void m305lambda$showWifiSymbol$14$comtylohelotyloheloHomeFragment(SaunaService saunaService, SharedViewModel sharedViewModel, Boolean bool) {
        if (saunaService.getCloudEnabled()) {
            ((MainActivity) requireActivity()).setWifiImageVisibility(false);
        } else {
            ((MainActivity) requireActivity()).setWifiImageVisibility(tyloApplication.isConnected(requireActivity(), sharedViewModel));
        }
    }

    private boolean showWaterLevel() {
        return ((tyloApplication.getProductType() == 30) || (tyloApplication.getProductType() == 31)) && tyloApplication.getSystemType() != 22;
    }
}
