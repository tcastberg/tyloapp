package com.tylohelo.tylohelo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public class NetworkWifiFragment extends Fragment implements BackPressedListener {
    public static BackPressedListener backPressedListener;
    CustomListViewAdapter listAdapter;
    ListView listView;
    private SharedViewModel viewModel;
    private int buttonIdView = 0;
    private int listIndex = 0;
    ArrayList<Item> wifiList = new ArrayList<>();
    List<WifiItem> wifiInfoList = new ArrayList();

    public static class WifiItem {
        public int listId;
        public String saunaName;
        public String systemId;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_network_wifi, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(true);
        NavController findNavController = NavHostFragment.findNavController(this);
        setNetworkTypeWifi(inflate);
        this.buttonIdView = 0;
        this.listView = (ListView) inflate.findViewById(R.id.wifiScrollList);
        this.viewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        ((MainActivity) requireActivity()).listenAtFallbackPort(this.viewModel);
        final SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(requireActivity());
            tyloApplication.setSaunaService(saunaService);
        }
        displayWifiSaunas(saunaService, inflate);
        this.viewModel.getIsSaunaListUpdated().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.NetworkWifiFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NetworkWifiFragment.this.m329lambda$onCreateView$0$comtylohelotyloheloNetworkWifiFragment(saunaService, inflate, (Boolean) obj);
            }
        });
        this.viewModel.getIsSaunaUpdated().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tylohelo.tylohelo.NetworkWifiFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NetworkWifiFragment.this.m330lambda$onCreateView$1$comtylohelotyloheloNetworkWifiFragment(saunaService, (Boolean) obj);
            }
        });
        onClickBackButton(inflate, findNavController);
        onClickNetworkButton(inflate, findNavController);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-NetworkWifiFragment, reason: not valid java name */
    /* synthetic */ void m329lambda$onCreateView$0$comtylohelotyloheloNetworkWifiFragment(SaunaService saunaService, View view, Boolean bool) {
        if (bool.booleanValue()) {
            displayWifiSaunas(saunaService, view);
        }
    }

    /* renamed from: lambda$onCreateView$1$com-tylohelo-tylohelo-NetworkWifiFragment, reason: not valid java name */
    /* synthetic */ void m330lambda$onCreateView$1$comtylohelotyloheloNetworkWifiFragment(SaunaService saunaService, Boolean bool) {
        String currentSaunaId;
        if (!bool.booleanValue() || (currentSaunaId = saunaService.getCurrentSaunaId()) == null) {
            return;
        }
        this.listIndex = 0;
        boolean existInList = existInList(currentSaunaId);
        SaunaModel saunaStored = saunaService.getSaunaStored(currentSaunaId);
        if (saunaStored != null) {
            if (saunaStored.isConnected()) {
                if (existInList) {
                    Item item = this.wifiList.get(this.listIndex);
                    item.setIconId(R.drawable.select_icon_white);
                    this.wifiList.set(this.listIndex, item);
                    this.listAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (existInList) {
                Item item2 = this.wifiList.get(this.listIndex);
                item2.setIconId(0);
                this.wifiList.set(this.listIndex, item2);
                this.listAdapter.notifyDataSetChanged();
            }
        }
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
            NavHostFragment.findNavController(this).navigate(R.id.action_networkWifiFragment_to_settingsFragment);
            backPressedListener = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayWifiSaunas(final SaunaService saunaService, final View view) {
        final HashMap<String, SaunaModel> saunaListStored = saunaService.getSaunaListStored();
        if (saunaListStored != null) {
            this.listIndex = 0;
            this.wifiList.clear();
            this.wifiInfoList.clear();
            saunaListStored.forEach(new BiConsumer() { // from class: com.tylohelo.tylohelo.NetworkWifiFragment$$ExternalSyntheticLambda3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    NetworkWifiFragment.this.m328xdea21dc4(saunaListStored, view, saunaService, (String) obj, (SaunaModel) obj2);
                }
            });
        }
    }

    /* renamed from: lambda$displayWifiSaunas$2$com-tylohelo-tylohelo-NetworkWifiFragment, reason: not valid java name */
    /* synthetic */ void m328xdea21dc4(HashMap hashMap, View view, SaunaService saunaService, String str, SaunaModel saunaModel) {
        Gson gson = new Gson();
        SaunaModel saunaModel2 = (SaunaModel) gson.fromJson(gson.toJson(hashMap.get(str)), SaunaModel.class);
        String systemId = saunaModel2.getSystemId();
        if (saunaModel2.isAvailable()) {
            if (existInList(systemId)) {
                return;
            }
            addSaunaButton(view, saunaModel2, saunaService);
        } else if (systemId != null) {
            this.listIndex = 0;
            if (existInList(systemId)) {
                this.wifiList.remove(this.listIndex);
                this.wifiInfoList.remove(this.listIndex);
            }
        }
    }

    private void addSaunaButton(View view, SaunaModel saunaModel, final SaunaService saunaService) {
        String currentSaunaId = saunaService.getCurrentSaunaId();
        String systemId = saunaModel.getSystemId();
        boolean z = currentSaunaId != null && currentSaunaId.equals(systemId) && tyloApplication.isConnected(requireActivity(), this.viewModel);
        if (existInList(systemId)) {
            return;
        }
        this.buttonIdView++;
        new ConstraintSet().clone((ConstraintLayout) view.findViewById(R.id.networkWifiConstraint));
        if (saunaModel.getSystemName().isEmpty()) {
            return;
        }
        WifiItem wifiItem = new WifiItem();
        wifiItem.saunaName = saunaModel.getSystemName();
        wifiItem.listId = this.buttonIdView;
        wifiItem.systemId = saunaModel.getSystemId();
        this.wifiInfoList.add(wifiItem);
        if (z) {
            this.wifiList.add(new Item(R.drawable.select_icon_white, saunaModel.getSystemName()));
        } else {
            this.wifiList.add(new Item(0, saunaModel.getSystemName()));
        }
        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(requireContext(), R.layout.list_item, this.wifiList);
        this.listAdapter = customListViewAdapter;
        this.listView.setAdapter((ListAdapter) customListViewAdapter);
        this.listView.setBackgroundColor(Color.parseColor("#434343"));
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tylohelo.tylohelo.NetworkWifiFragment$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                NetworkWifiFragment.this.m327xccb59dba(saunaService, adapterView, view2, i, j);
            }
        });
    }

    /* renamed from: lambda$addSaunaButton$3$com-tylohelo-tylohelo-NetworkWifiFragment, reason: not valid java name */
    /* synthetic */ void m327xccb59dba(SaunaService saunaService, AdapterView adapterView, View view, int i, long j) {
        String currentSaunaId = saunaService.getCurrentSaunaId();
        if (currentSaunaId != null) {
            this.listIndex = 0;
            if (existInList(currentSaunaId)) {
                Item item = this.wifiList.get(this.listIndex);
                item.setIconId(0);
                this.wifiList.set(this.listIndex, item);
                this.listAdapter.notifyDataSetChanged();
            }
            SaunaModel saunaStored = saunaService.getSaunaStored(currentSaunaId);
            if (saunaStored != null) {
                saunaStored.setConnected(false);
                saunaService.storeSauna(saunaStored);
                this.viewModel.setIsSaunaUpdated(true);
            }
        }
        this.viewModel.resetViewModelData();
        tyloApplication.setConnectionReplyReceived(false);
        if (saunaService.getCloudEnabled()) {
            return;
        }
        String str = this.wifiInfoList.get((int) j).systemId;
        WifiService wifiService = tyloApplication.getWifiService();
        if (wifiService == null) {
            wifiService = new WifiService(requireActivity());
            tyloApplication.setWifiService(wifiService);
        }
        wifiService.connectWifi(str);
    }

    private void setNetworkTypeWifi(View view) {
        Button button = (Button) view.findViewById(R.id.button16);
        button.setText(tyloApplication.alignTwoStrings(button.getText().toString(), "Wifi"));
    }

    private void onClickBackButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.button18);
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.back_button_icon));
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkWifiFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_networkWifiFragment_to_settingsFragment);
            }
        });
    }

    private void onClickNetworkButton(View view, final NavController navController) {
        ((Button) view.findViewById(R.id.button16)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.NetworkWifiFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavController.this.navigate(R.id.action_networkWifiFragment_to_networkTypeFragment);
            }
        });
    }

    private boolean existInList(String str) {
        if (str == null || this.wifiList == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.wifiList.size(); i++) {
            if (str.equals(this.wifiInfoList.get(i).systemId)) {
                this.listIndex = i;
                z = true;
            }
        }
        return z;
    }
}
