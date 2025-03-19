package com.tylohelo.tylohelo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.button.MaterialButton;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;
import com.tylohelo.tylohelo.CloudService;
import com.tylohelo.tylohelo.protobuf.UserMessage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tech.gusavila92.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public class AddSystemFragment extends Fragment {
    AlertDialog messageDialog;
    Button scanButton;
    private SharedViewModel viewModel;
    int retryPairingCount = 0;
    int thresholdValueGetSystemInfo = 10;
    ScheduledExecutorService scheduler = null;
    ActivityResultLauncher<ScanOptions> qrLauncher = registerForActivityResult(new ScanContract(), new ActivityResultCallback() { // from class: com.tylohelo.tylohelo.AddSystemFragment$$ExternalSyntheticLambda5
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            AddSystemFragment.this.m207lambda$new$2$comtylohelotyloheloAddSystemFragment((ScanIntentResult) obj);
        }
    });

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ScheduledExecutorService scheduledExecutorService = this.scheduler;
        if (scheduledExecutorService != null) {
            stopPolling(scheduledExecutorService);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_system, viewGroup, false);
        ((MainActivity) requireActivity()).hideHomeScreenElements(false);
        NavController findNavController = NavHostFragment.findNavController(this);
        this.viewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        onClickBackButton(inflate, findNavController);
        Button button = (Button) inflate.findViewById(R.id.button7);
        this.scanButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.AddSystemFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddSystemFragment.this.m209lambda$onCreateView$0$comtylohelotyloheloAddSystemFragment(view);
            }
        });
        AlertDialog create = new AlertDialog.Builder(getContext()).create();
        this.messageDialog = create;
        create.setTitle("Message");
        this.messageDialog.setMessage("Waiting for response from the system.");
        this.messageDialog.setCancelable(false);
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-tylohelo-tylohelo-AddSystemFragment, reason: not valid java name */
    /* synthetic */ void m209lambda$onCreateView$0$comtylohelotyloheloAddSystemFragment(View view) {
        scanCode();
    }

    private void scanCode() {
        ScanOptions scanOptions = new ScanOptions();
        scanOptions.setBeepEnabled(false);
        scanOptions.setOrientationLocked(true);
        scanOptions.setCaptureActivity(ScanActivity.class);
        scanOptions.setPrompt("Place a QR code inside the scan area");
        this.qrLauncher.launch(scanOptions);
    }

    /* renamed from: lambda$new$2$com-tylohelo-tylohelo-AddSystemFragment, reason: not valid java name */
    /* synthetic */ void m207lambda$new$2$comtylohelotyloheloAddSystemFragment(ScanIntentResult scanIntentResult) {
        if (scanIntentResult.getContents() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Message");
            final String contents = scanIntentResult.getContents();
            builder.setMessage("Scanning successful, now waiting for response from the system, this may take some time!");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.AddSystemFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AddSystemFragment.this.m206lambda$new$1$comtylohelotyloheloAddSystemFragment(contents, dialogInterface, i);
                }
            }).show();
        }
    }

    /* renamed from: lambda$new$1$com-tylohelo-tylohelo-AddSystemFragment, reason: not valid java name */
    /* synthetic */ void m206lambda$new$1$comtylohelotyloheloAddSystemFragment(String str, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        CloudService cloudService = tyloApplication.getCloudService();
        if (cloudService == null) {
            cloudService = new CloudService(requireActivity());
            tyloApplication.setCloudService(cloudService);
        }
        final NavController findNavController = NavHostFragment.findNavController(requireParentFragment());
        String deviceName = getDeviceName();
        this.retryPairingCount = 0;
        cloudService.getRequestToken(str, deviceName, new CloudService.VolleyResponseListener() { // from class: com.tylohelo.tylohelo.AddSystemFragment.1
            @Override // com.tylohelo.tylohelo.CloudService.VolleyResponseListener
            public void onError(String str2) {
                AddSystemFragment.this.viewModel.setUserMessageLocal(UserMessageService.buildUserMsg(UserMessage.User_message.message_type_t.TYPE_OK, str2));
            }

            @Override // com.tylohelo.tylohelo.CloudService.VolleyResponseListener
            public void onResponse(String str2) {
                if (str2 != null) {
                    CloudService cloudService2 = tyloApplication.getCloudService();
                    if (cloudService2 == null) {
                        cloudService2 = new CloudService(AddSystemFragment.this.requireActivity());
                        tyloApplication.setCloudService(cloudService2);
                    }
                    AddSystemFragment.this.scheduler = Executors.newScheduledThreadPool(1);
                    AddSystemFragment addSystemFragment = AddSystemFragment.this;
                    addSystemFragment.startPolling(cloudService2, addSystemFragment.scheduler, cloudService2.formatTokenString(str2), findNavController);
                }
            }
        });
    }

    private String getDeviceName() {
        String string = Settings.Global.getString(requireContext().getContentResolver(), "device_name");
        return string == null ? Settings.Secure.getString(requireContext().getContentResolver(), "bluetooth_name") : string;
    }

    public void startPolling(final CloudService cloudService, final ScheduledExecutorService scheduledExecutorService, final String str, final NavController navController) {
        this.retryPairingCount++;
        this.thresholdValueGetSystemInfo = 10;
        this.messageDialog.show();
        Runnable runnable = new Runnable() { // from class: com.tylohelo.tylohelo.AddSystemFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AddSystemFragment.this.m210lambda$startPolling$3$comtylohelotyloheloAddSystemFragment(cloudService, scheduledExecutorService, str, navController);
            }
        };
        if (scheduledExecutorService != null) {
            scheduledExecutorService.scheduleAtFixedRate(runnable, 0L, 2L, TimeUnit.SECONDS);
        }
    }

    /* renamed from: lambda$startPolling$3$com-tylohelo-tylohelo-AddSystemFragment, reason: not valid java name */
    /* synthetic */ void m210lambda$startPolling$3$comtylohelotyloheloAddSystemFragment(final CloudService cloudService, final ScheduledExecutorService scheduledExecutorService, final String str, final NavController navController) {
        cloudService.getSystemInfo(new CloudService.VolleyResponseListenerInfo() { // from class: com.tylohelo.tylohelo.AddSystemFragment.2
            @Override // com.tylohelo.tylohelo.CloudService.VolleyResponseListenerInfo
            public void onError(String str2) {
                AddSystemFragment addSystemFragment = AddSystemFragment.this;
                addSystemFragment.thresholdValueGetSystemInfo--;
                if (AddSystemFragment.this.thresholdValueGetSystemInfo <= 0) {
                    AddSystemFragment.this.messageDialog.hide();
                    AddSystemFragment.this.thresholdValueGetSystemInfo = 10;
                    AddSystemFragment.this.stopPolling(scheduledExecutorService);
                    if (AddSystemFragment.this.retryPairingCount < 2) {
                        AddSystemFragment.this.continueToTry(cloudService, str, navController);
                        return;
                    }
                    AddSystemFragment.this.viewModel.setUserMessageLocal(UserMessageService.buildUserMsg(UserMessage.User_message.message_type_t.TYPE_OK, "Failed to create a pairing to system, please try again."));
                    AddSystemFragment.this.retryPairingCount = 0;
                }
            }

            @Override // com.tylohelo.tylohelo.CloudService.VolleyResponseListenerInfo
            public void onResponse(JSONObject jSONObject) {
                AddSystemFragment.this.stopPolling(scheduledExecutorService);
                AddSystemFragment.this.messageDialog.hide();
                Toast.makeText(AddSystemFragment.this.getContext(), "Pairing successful.", 0).show();
                SaunaService saunaService = tyloApplication.getSaunaService();
                if (saunaService == null) {
                    saunaService = new SaunaService(AddSystemFragment.this.requireActivity());
                    tyloApplication.setSaunaService(saunaService);
                }
                String currentSaunaId = saunaService.getCurrentSaunaId();
                if (currentSaunaId != null) {
                    SaunaModel saunaStored = saunaService.getSaunaStored(currentSaunaId);
                    if (saunaStored != null) {
                        saunaStored.setConnected(false);
                        saunaService.storeSauna(saunaStored);
                        AddSystemFragment.this.viewModel.setIsSaunaUpdated(true);
                    }
                    FirebaseService.registerSaunas();
                }
                try {
                    String string = jSONObject.getString("id");
                    ComService comService = tyloApplication.getComService();
                    if (comService != null) {
                        comService.close();
                        comService.connect(string);
                    }
                } catch (JSONException e) {
                    if (e.getMessage() != null) {
                        Log.e("Exception", e.getMessage());
                    }
                }
                try {
                    navController.navigate(R.id.action_addSystemFragment_to_networkFragment);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }, str);
    }

    public void stopPolling(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            try {
                if (scheduledExecutorService.awaitTermination(2L, TimeUnit.SECONDS)) {
                    return;
                }
                Log.e(HttpHeaders.TIMEOUT, "Scheduler not terminated");
            } catch (InterruptedException e) {
                if (e.getMessage() != null) {
                    Log.e("Exception", e.getMessage());
                }
            }
        }
    }

    private void onClickBackButton(View view, final NavController navController) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.button6);
        materialButton.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.back_button_icon));
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.AddSystemFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddSystemFragment.this.m208xd2a61165(navController, view2);
            }
        });
    }

    /* renamed from: lambda$onClickBackButton$4$com-tylohelo-tylohelo-AddSystemFragment, reason: not valid java name */
    /* synthetic */ void m208xd2a61165(NavController navController, View view) {
        stopPolling(this.scheduler);
        navController.navigate(R.id.action_addSystemFragment_to_networkFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueToTry(final CloudService cloudService, final String str, final NavController navController) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(false);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.AddSystemFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AddSystemFragment.this.m205lambda$continueToTry$5$comtylohelotyloheloAddSystemFragment(cloudService, str, navController, dialogInterface, i);
            }
        };
        builder.setMessage("The pairing is not done yet, do you want to keep trying?").setPositiveButton("Yes", onClickListener).setNegativeButton("No", onClickListener).show();
    }

    /* renamed from: lambda$continueToTry$5$com-tylohelo-tylohelo-AddSystemFragment, reason: not valid java name */
    /* synthetic */ void m205lambda$continueToTry$5$comtylohelotyloheloAddSystemFragment(CloudService cloudService, String str, NavController navController, DialogInterface dialogInterface, int i) {
        if (i == -2) {
            this.retryPairingCount = 0;
        } else {
            if (i != -1) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.scheduler = newScheduledThreadPool;
            startPolling(cloudService, newScheduledThreadPool, str, navController);
        }
    }
}
