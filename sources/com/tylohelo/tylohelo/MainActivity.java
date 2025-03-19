package com.tylohelo.tylohelo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.BottomNavigationViewKt;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.tylohelo.tylohelo.MainActivity;
import com.tylohelo.tylohelo.protobuf.SaunaState;
import com.tylohelo.tylohelo.protobuf.UserMessage;
import com.tylohelo.tylohelo.tyloApplication;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public class MainActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CHECK_FOR_SAUNA = 3000;
    public static final int WIFI_TIMEOUT = 30000;
    private static boolean animateStarted = false;
    private static boolean bottomSymbolsVisible = false;
    private static MulticastSocket multicastSocket = null;
    private static boolean stopAnimate = false;
    BottomNavigationView bottomNavigationView;
    private Handler handler;
    private Runnable hideRunnable;
    LinearLayout linearLayout;
    private boolean isLayoutVisible = false;
    private Handler handlerInterval = null;
    private Runnable runnableSauna = null;
    private boolean standbyEnabled = false;
    private MaterialButton stopButton = null;
    private boolean stopButtonVisible = false;

    static /* synthetic */ void lambda$powerOn$2(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$powerOn$3(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$powerOn$4(DialogInterface dialogInterface, int i) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        NavController navController = ((NavHostFragment) Objects.requireNonNull((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))).getNavController();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        this.bottomNavigationView = bottomNavigationView;
        BottomNavigationViewKt.setupWithNavController(bottomNavigationView, navController);
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.buttonOff);
        materialButton.setTextAlignment(4);
        materialButton.setIcon(ContextCompat.getDrawable(this, R.drawable.off));
        this.linearLayout = (LinearLayout) findViewById(R.id.topBarLayout);
        handleStandbyButton();
        MaterialButton materialButton2 = (MaterialButton) findViewById(R.id.buttonOn);
        materialButton2.setText("|");
        materialButton2.setTextAlignment(4);
        this.handler = new Handler(Looper.getMainLooper());
        this.hideRunnable = new Runnable() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m310lambda$onCreate$0$comtylohelotyloheloMainActivity();
            }
        };
        setCloudImageVisibility(false);
        saunaStateChange();
        onClickPowerOn();
        onClickPowerOff();
        onClickStandby();
        cloudStatus();
        checkForCurrentSauna();
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == -1 && Build.VERSION.SDK_INT >= 33) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
        }
        FirebaseService.createChannelAndHandleNotifications(getApplicationContext());
        showUserMsg();
    }

    /* renamed from: lambda$onCreate$0$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m310lambda$onCreate$0$comtylohelotyloheloMainActivity() {
        if (!this.stopButtonVisible) {
            this.linearLayout.setVisibility(4);
        }
        this.bottomNavigationView.setVisibility(4);
        this.isLayoutVisible = false;
        animateBottomSymbols();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (NetworkTypeFragment.backPressedListener != null) {
            NetworkTypeFragment.backPressedListener.onBackPressed();
            return;
        }
        if (NetworkWifiFragment.backPressedListener != null) {
            NetworkWifiFragment.backPressedListener.onBackPressed();
            return;
        }
        if (NetworkFragment.backPressedListener != null) {
            NetworkFragment.backPressedListener.onBackPressed();
            return;
        }
        if (SettingsFragment.backPressedListener != null) {
            SettingsFragment.backPressedListener.onBackPressed();
        } else if (HomeFragment.backPressedListener != null) {
            HomeFragment.backPressedListener.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        tyloApplication.setIsVisible(true);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        tyloApplication.setComService(null);
        tyloApplication.setComService(new ComService(navHostFragment.getActivity()));
        connectToSauna(navHostFragment.getActivity());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        tyloApplication.setIsVisible(false);
        ComService comService = tyloApplication.getComService();
        if (comService != null) {
            comService.close();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        tyloApplication.setIsVisible(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        tyloApplication.setIsVisible(false);
        disconnectSauna();
        MulticastSocket.closeMulticastSocket();
        stopHandler();
        resetSauna();
        WifiService.stopKeepAlive();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        tyloApplication.setIsVisible(false);
        disconnectSauna();
        MulticastSocket.closeMulticastSocket();
        stopHandler();
        resetSauna();
        WifiService.stopKeepAlive();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (configuration.fontScale > 1.0f || configuration.fontScale < 1.0f) {
            configuration.fontScale = 1.0f;
        }
        applyOverrideConfiguration(configuration);
        super.attachBaseContext(context);
    }

    private void disconnectSauna() {
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(this);
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendDisconnectionRequest();
    }

    private void connectToSauna(FragmentActivity fragmentActivity) {
        ComService comService;
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(fragmentActivity);
            tyloApplication.setSaunaService(saunaService);
        }
        SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class);
        sharedViewModel.setCloudOnline(false);
        String currentSaunaId = saunaService.getCurrentSaunaId();
        if (!saunaService.getCloudEnabled()) {
            sharedViewModel.setCloudOnline(false);
            listenForSaunas(currentSaunaId, sharedViewModel, saunaService);
        } else {
            if (currentSaunaId == null || (comService = tyloApplication.getComService()) == null) {
                return;
            }
            comService.connect(currentSaunaId);
        }
    }

    public void listenForSaunas(String str, SharedViewModel sharedViewModel, SaunaService saunaService) {
        if (multicastSocket != null) {
            MulticastSocket.closeMulticastSocket();
        }
        MulticastSocket multicastSocket2 = new MulticastSocket(this);
        multicastSocket = multicastSocket2;
        multicastSocket2.startMulticastListener(sharedViewModel);
        listenAtFallbackPort(sharedViewModel);
        if (str != null) {
            WifiService wifiService = tyloApplication.getWifiService();
            if (wifiService == null) {
                wifiService = new WifiService(this);
                tyloApplication.setWifiService(wifiService);
            }
            wifiService.connectWifi(str);
        }
        timedUpdate(saunaService, sharedViewModel);
    }

    public void listenAtFallbackPort(SharedViewModel sharedViewModel) {
        MulticastSocket multicastSocket2 = multicastSocket;
        if (multicastSocket2 != null) {
            multicastSocket2.startMulticastListenerOnFallbackPort(sharedViewModel);
            multicastSocket.sendAnnouncementRequest();
        }
    }

    public void stopListening() {
        if (multicastSocket != null) {
            MulticastSocket.closeMulticastSocket();
        }
        stopHandler();
        resetSauna();
    }

    private void slideInTopBar() {
        handleStandbyButton();
        this.linearLayout.setVisibility(0);
        this.isLayoutVisible = true;
        this.linearLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in));
    }

    private void slideOutTopBar() {
        this.isLayoutVisible = false;
        this.linearLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out));
        this.linearLayout.setVisibility(4);
    }

    private void slideInBottomBar() {
        hideBottomSymbols();
        this.bottomNavigationView.setVisibility(0);
        this.bottomNavigationView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom));
        if (animateStarted) {
            stopAnimate = true;
        }
    }

    private void slideOutBottomBar() {
        this.bottomNavigationView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom));
        this.bottomNavigationView.setVisibility(4);
        animateBottomSymbols();
        animateStarted = true;
    }

    private void showStopDryUp() {
        final MaterialButton materialButton = (MaterialButton) this.linearLayout.findViewById(R.id.buttonOn);
        materialButton.setVisibility(8);
        final MaterialButton materialButton2 = (MaterialButton) this.linearLayout.findViewById(R.id.buttonOff);
        materialButton2.setVisibility(8);
        ((MaterialButton) this.linearLayout.findViewById(R.id.buttonStandby)).setVisibility(8);
        MaterialButton materialButton3 = this.stopButton;
        if (materialButton3 == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.topBarLayout);
            MaterialButton materialButton4 = new MaterialButton(this);
            this.stopButton = materialButton4;
            materialButton4.setText(R.string.stop);
            this.stopButton.setTextSize(24.0f);
            this.stopButton.setIcon(ContextCompat.getDrawable(this, R.drawable.dryup_small));
            this.stopButton.setIconGravity(2);
            this.stopButton.setBackgroundColor(Color.parseColor("#ff0006"));
            this.stopButton.setTextColor(Color.parseColor("#FFFFFFFF"));
            this.stopButton.setTextAlignment(4);
            this.stopButton.setLayoutParams(linearLayout.getLayoutParams());
            linearLayout.addView(this.stopButton);
            slideInTopBar();
            slideInBottomBar();
            animateStarted = false;
            this.isLayoutVisible = true;
            stopTimer();
            startTimer();
        } else {
            materialButton3.setVisibility(0);
        }
        this.stopButtonVisible = true;
        if (!this.isLayoutVisible && ((this.linearLayout.getVisibility() == 8 || this.linearLayout.getVisibility() == 4) && this.stopButtonVisible)) {
            slideInTopBar();
            slideInBottomBar();
            animateStarted = false;
            this.isLayoutVisible = true;
            stopTimer();
            startTimer();
        }
        this.stopButton.setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m313lambda$showStopDryUp$1$comtylohelotyloheloMainActivity(materialButton, materialButton2, view);
            }
        });
    }

    /* renamed from: lambda$showStopDryUp$1$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m313lambda$showStopDryUp$1$comtylohelotyloheloMainActivity(MaterialButton materialButton, MaterialButton materialButton2, View view) {
        this.stopButton.setVisibility(8);
        this.stopButtonVisible = false;
        materialButton.setVisibility(0);
        materialButton2.setVisibility(0);
        handleStandbyButton();
        if (this.bottomNavigationView.getVisibility() == 0) {
            if (this.linearLayout.getVisibility() != 0) {
                this.linearLayout.setVisibility(0);
            }
        } else if (this.linearLayout.getVisibility() == 0) {
            this.linearLayout.setVisibility(8);
        }
        ((SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class)).setSaunaState(SaunaState.Sauna_state_changed.state_t.STATE_OFF);
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(this);
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendSaunaStateMsg(SaunaState.Sauna_state_change_request.state_t.STATE_OFF);
    }

    private void powerOn() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        SaunaState.Sauna_state_changed.state_t value = ((SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class)).getSaunaState().getValue();
        if (value != null) {
            if (value == SaunaState.Sauna_state_changed.state_t.STATE_DRYUP) {
                builder.setMessage("Tank emptying has started, operation is possible when draining is complete.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda13
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.lambda$powerOn$2(dialogInterface, i);
                    }
                }).show();
                return;
            }
            if (value == SaunaState.Sauna_state_changed.state_t.STATE_CLEANUP) {
                builder.setMessage("Sauna can not be interrupted in current mode.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda14
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.lambda$powerOn$3(dialogInterface, i);
                    }
                }).show();
            } else {
                if (value == SaunaState.Sauna_state_changed.state_t.STATE_DESCALING) {
                    builder.setMessage("Descaling has started, operation not possible.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.lambda$powerOn$4(dialogInterface, i);
                        }
                    }).show();
                    return;
                }
                MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
                if (messageToSaunaSystem == null) {
                    messageToSaunaSystem = new MessageToSaunaSystem(this);
                    tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
                }
                messageToSaunaSystem.sendSaunaStateMsg(SaunaState.Sauna_state_change_request.state_t.STATE_ON);
                builder.setMessage("power on");
            }
        }
    }

    private void onClickPowerOn() {
        final SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class);
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            ((MaterialButton) linearLayout.findViewById(R.id.buttonOn)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.m308lambda$onClickPowerOn$5$comtylohelotyloheloMainActivity(sharedViewModel, view);
                }
            });
        }
    }

    /* renamed from: lambda$onClickPowerOn$5$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m308lambda$onClickPowerOn$5$comtylohelotyloheloMainActivity(SharedViewModel sharedViewModel, View view) {
        if (tyloApplication.getSaunaService() == null) {
            tyloApplication.setSaunaService(new SaunaService(this));
        }
        if (tyloApplication.isConnected(this, sharedViewModel)) {
            powerOn();
        }
    }

    private void powerOff() {
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(this);
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendSaunaStateMsg(SaunaState.Sauna_state_change_request.state_t.STATE_OFF);
    }

    private void onClickPowerOff() {
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            ((MaterialButton) linearLayout.findViewById(R.id.buttonOff)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.m307lambda$onClickPowerOff$6$comtylohelotyloheloMainActivity(view);
                }
            });
        }
    }

    /* renamed from: lambda$onClickPowerOff$6$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m307lambda$onClickPowerOff$6$comtylohelotyloheloMainActivity(View view) {
        powerOff();
    }

    private void standBy() {
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (messageToSaunaSystem == null) {
            messageToSaunaSystem = new MessageToSaunaSystem(this);
            tyloApplication.setMessageToSaunaSystem(messageToSaunaSystem);
        }
        messageToSaunaSystem.sendSaunaStateMsg(SaunaState.Sauna_state_change_request.state_t.STATE_STANDBY);
    }

    private void onClickStandby() {
        final SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class);
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            ((MaterialButton) linearLayout.findViewById(R.id.buttonStandby)).setOnClickListener(new View.OnClickListener() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.m309lambda$onClickStandby$7$comtylohelotyloheloMainActivity(sharedViewModel, view);
                }
            });
        }
    }

    /* renamed from: lambda$onClickStandby$7$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m309lambda$onClickStandby$7$comtylohelotyloheloMainActivity(SharedViewModel sharedViewModel, View view) {
        if (tyloApplication.getSaunaService() == null) {
            tyloApplication.setSaunaService(new SaunaService(this));
        }
        if (tyloApplication.isConnected(this, sharedViewModel)) {
            standBy();
        }
    }

    private void saunaStateChange() {
        final SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class);
        sharedViewModel.getSaunaState().observe(this, new Observer() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.m311lambda$saunaStateChange$8$comtylohelotyloheloMainActivity(sharedViewModel, (SaunaState.Sauna_state_changed.state_t) obj);
            }
        });
    }

    /* renamed from: lambda$saunaStateChange$8$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m311lambda$saunaStateChange$8$comtylohelotyloheloMainActivity(SharedViewModel sharedViewModel, SaunaState.Sauna_state_changed.state_t state_tVar) {
        if (state_tVar == null) {
            uiChangeOff();
            return;
        }
        if (state_tVar == SaunaState.Sauna_state_changed.state_t.STATE_ON) {
            uiChangeOn(sharedViewModel);
            return;
        }
        if (state_tVar == SaunaState.Sauna_state_changed.state_t.STATE_OFF) {
            uiChangeOff();
        } else if (state_tVar == SaunaState.Sauna_state_changed.state_t.STATE_STANDBY) {
            uiChangeStandby(sharedViewModel);
        } else if (state_tVar == SaunaState.Sauna_state_changed.state_t.STATE_DRYUP) {
            showStopDryUp();
        }
    }

    private void uiChangeOn(SharedViewModel sharedViewModel) {
        if (tyloApplication.isConnected(this, sharedViewModel)) {
            ((MaterialButton) this.linearLayout.findViewById(R.id.buttonOn)).setBackgroundColor(Color.parseColor("#3bc639"));
            ((MaterialButton) this.linearLayout.findViewById(R.id.buttonOff)).setBackgroundColor(Color.parseColor("#434343"));
            if (this.standbyEnabled) {
                ((MaterialButton) this.linearLayout.findViewById(R.id.buttonStandby)).setBackgroundColor(Color.parseColor("#434343"));
                return;
            }
            return;
        }
        uiChangeOff();
    }

    public void uiChangeOff() {
        MaterialButton materialButton = (MaterialButton) this.linearLayout.findViewById(R.id.buttonOn);
        materialButton.setBackgroundColor(Color.parseColor("#434343"));
        MaterialButton materialButton2 = (MaterialButton) this.linearLayout.findViewById(R.id.buttonOff);
        materialButton2.setBackgroundColor(Color.parseColor("#ff0006"));
        MaterialButton materialButton3 = (MaterialButton) this.linearLayout.findViewById(R.id.buttonStandby);
        if (this.standbyEnabled) {
            materialButton3.setBackgroundColor(Color.parseColor("#434343"));
        }
        MaterialButton materialButton4 = this.stopButton;
        if (materialButton4 == null || materialButton4.getVisibility() != 0) {
            return;
        }
        this.stopButton.setVisibility(8);
        this.linearLayout.setVisibility(8);
        this.stopButtonVisible = false;
        materialButton.setVisibility(0);
        materialButton2.setVisibility(0);
        handleStandbyButton();
    }

    private void uiChangeStandby(SharedViewModel sharedViewModel) {
        if (tyloApplication.isConnected(this, sharedViewModel)) {
            ((MaterialButton) this.linearLayout.findViewById(R.id.buttonOn)).setBackgroundColor(Color.parseColor("#434343"));
            ((MaterialButton) this.linearLayout.findViewById(R.id.buttonOff)).setBackgroundColor(Color.parseColor("#434343"));
            ((MaterialButton) this.linearLayout.findViewById(R.id.buttonStandby)).setBackgroundColor(Color.parseColor("#FAD02C"));
            return;
        }
        uiChangeOff();
    }

    public void setLinearLayoutVisibility(boolean z) {
        this.linearLayout.setVisibility(z ? 0 : 4);
    }

    private void cloudStatus() {
        SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class);
        final ImageView imageView = (ImageView) findViewById(R.id.imageViewCloud);
        sharedViewModel.getCloudOnline().observe(this, new Observer() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.lambda$cloudStatus$9(imageView, (Boolean) obj);
            }
        });
    }

    static /* synthetic */ void lambda$cloudStatus$9(ImageView imageView, Boolean bool) {
        if (bool.booleanValue()) {
            imageView.setImageResource(R.drawable.cloud);
        } else {
            imageView.setImageResource(R.drawable.cloud_err);
        }
    }

    public void setCloudImageVisibility(boolean z) {
        ImageView imageView = (ImageView) findViewById(R.id.imageViewCloud);
        imageView.setVisibility(z ? 0 : 8);
        if (bottomSymbolsVisible) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void setBottomNavBarVisibility(boolean z) {
        this.bottomNavigationView.setVisibility(z ? 0 : 8);
        if (z) {
            hideBottomSymbols();
        }
    }

    public void setWifiImageVisibility(boolean z) {
        ImageView imageView = (ImageView) findViewById(R.id.imageViewWifi);
        imageView.setVisibility(z ? 0 : 8);
        if (bottomSymbolsVisible) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void setTouchListener(View view) {
        this.isLayoutVisible = this.linearLayout.getVisibility() == 0;
        hideBottomSymbols();
        startTimer();
        if (tyloApplication.getJumpToHomeScreen()) {
            slideInBottomBar();
            this.isLayoutVisible = true;
            tyloApplication.setJumpToHomeScreen(false);
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return MainActivity.this.m312lambda$setTouchListener$10$comtylohelotyloheloMainActivity(view2, motionEvent);
            }
        });
    }

    /* renamed from: lambda$setTouchListener$10$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m312lambda$setTouchListener$10$comtylohelotyloheloMainActivity(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            view.performClick();
            startTimer();
            if (!this.isLayoutVisible) {
                if (this.stopButtonVisible) {
                    Log.d("MainActivity", "Top status bar is visible");
                } else {
                    slideInTopBar();
                }
                slideInBottomBar();
                this.isLayoutVisible = true;
            } else {
                if (this.stopButtonVisible) {
                    Log.d("MainActivity", "Top status bar should be visible here");
                } else {
                    slideOutTopBar();
                }
                slideOutBottomBar();
                this.isLayoutVisible = false;
            }
        }
        return true;
    }

    private void startTimer() {
        this.handler.removeCallbacks(this.hideRunnable);
        this.handler.postDelayed(this.hideRunnable, 10000L);
    }

    public void stopTimer() {
        this.handler.removeCallbacks(this.hideRunnable);
    }

    private void showUserMsg() {
        final SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(this).get(SharedViewModel.class);
        sharedViewModel.getUserMessage().observe(this, new Observer() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.m314lambda$showUserMsg$11$comtylohelotyloheloMainActivity((UserMessage.User_message) obj);
            }
        });
        sharedViewModel.getUserMessageLocal().observe(this, new Observer() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.m315lambda$showUserMsg$12$comtylohelotyloheloMainActivity(sharedViewModel, (UserMessage.User_message) obj);
            }
        });
    }

    /* renamed from: lambda$showUserMsg$11$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m314lambda$showUserMsg$11$comtylohelotyloheloMainActivity(UserMessage.User_message user_message) {
        if (user_message != null) {
            UserMessageService.createAlertBox(UserMessageService.getUserMsgString(user_message), user_message, this, this, false);
        }
    }

    /* renamed from: lambda$showUserMsg$12$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m315lambda$showUserMsg$12$comtylohelotyloheloMainActivity(SharedViewModel sharedViewModel, UserMessage.User_message user_message) {
        String userMsgString = UserMessageService.getUserMsgString(user_message);
        if (userMsgString.equals("This device is no longer trusted. Re-connect at the Control panel!")) {
            SaunaService saunaService = tyloApplication.getSaunaService();
            if (saunaService == null) {
                saunaService = new SaunaService(this);
                tyloApplication.setSaunaService(saunaService);
            }
            String currentSaunaId = saunaService.getCurrentSaunaId();
            if (currentSaunaId != null) {
                saunaService.removeSauna(currentSaunaId);
                sharedViewModel.setIsSaunaListUpdated(true);
                saunaService.setCurrentSaunaId(null);
            }
        }
        UserMessageService.createAlertBox(userMsgString, user_message, this, this, true);
    }

    /* renamed from: com.tylohelo.tylohelo.MainActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ SaunaService val$saunaService;
        final /* synthetic */ SharedViewModel val$viewModel;

        AnonymousClass1(SaunaService saunaService, SharedViewModel sharedViewModel) {
            this.val$saunaService = saunaService;
            this.val$viewModel = sharedViewModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            final HashMap<String, SaunaModel> saunaListStored = this.val$saunaService.getSaunaListStored();
            final String currentSaunaId = this.val$saunaService.getCurrentSaunaId();
            if (saunaListStored != null) {
                final SaunaService saunaService = this.val$saunaService;
                final SharedViewModel sharedViewModel = this.val$viewModel;
                saunaListStored.forEach(new BiConsumer() { // from class: com.tylohelo.tylohelo.MainActivity$1$$ExternalSyntheticLambda0
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        MainActivity.AnonymousClass1.lambda$run$0(saunaListStored, currentSaunaId, saunaService, sharedViewModel, (String) obj, (SaunaModel) obj2);
                    }
                });
            }
            Log.d("MainActivity", "Check last msg time of sauna ");
            MainActivity.this.handlerInterval.postDelayed(this, 3000L);
        }

        static /* synthetic */ void lambda$run$0(HashMap hashMap, String str, SaunaService saunaService, SharedViewModel sharedViewModel, String str2, SaunaModel saunaModel) {
            Gson gson = new Gson();
            SaunaModel saunaModel2 = (SaunaModel) gson.fromJson(gson.toJson(hashMap.get(str2)), SaunaModel.class);
            if (System.currentTimeMillis() - saunaModel2.getLastMsgTime() > 30000) {
                saunaModel2.setAvailable(false);
                saunaModel2.setConnected(false);
            } else {
                if (!saunaModel2.getSystemId().equals(str) || saunaModel2.isConnected()) {
                    return;
                }
                if (tyloApplication.getConnectionReplyReceived()) {
                    Log.d("MainActivity", "Received connection reply");
                    saunaModel2.setLastMsgTime(System.currentTimeMillis());
                } else {
                    tyloApplication.getWifiService().connectWifi(saunaModel2.getSystemId());
                    return;
                }
            }
            saunaService.storeSauna(saunaModel2);
            sharedViewModel.setIsSaunaUpdated(true);
            sharedViewModel.setIsSaunaListUpdated(true);
        }
    }

    private void timedUpdate(SaunaService saunaService, SharedViewModel sharedViewModel) {
        this.handlerInterval = new Handler();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(saunaService, sharedViewModel);
        this.runnableSauna = anonymousClass1;
        this.handlerInterval.postDelayed(anonymousClass1, 3000L);
    }

    private void stopHandler() {
        Runnable runnable;
        Handler handler = this.handlerInterval;
        if (handler == null || (runnable = this.runnableSauna) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public void resetSauna() {
        SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(this).get(SharedViewModel.class);
        final SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(this);
            tyloApplication.setSaunaService(saunaService);
        }
        final HashMap<String, SaunaModel> saunaListStored = saunaService.getSaunaListStored();
        if (saunaListStored != null) {
            saunaListStored.forEach(new BiConsumer() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    MainActivity.lambda$resetSauna$13(saunaListStored, saunaService, (String) obj, (SaunaModel) obj2);
                }
            });
            sharedViewModel.setIsSaunaListUpdated(true);
        }
    }

    static /* synthetic */ void lambda$resetSauna$13(HashMap hashMap, SaunaService saunaService, String str, SaunaModel saunaModel) {
        Gson gson = new Gson();
        SaunaModel saunaModel2 = (SaunaModel) gson.fromJson(gson.toJson(hashMap.get(str)), SaunaModel.class);
        saunaModel2.setAvailable(false);
        saunaModel2.setConnected(false);
        saunaModel2.setLastMsgTime(0L);
        saunaService.storeSauna(saunaModel2);
    }

    private void checkForCurrentSauna() {
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(this);
            tyloApplication.setSaunaService(saunaService);
        }
        if (saunaService.getCurrentSaunaId() == null) {
            SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(this).get(SharedViewModel.class);
            sharedViewModel.setWifiOnline(false);
            sharedViewModel.setCloudOnline(false);
        }
    }

    public void hideHomeScreenElements(boolean z) {
        stopTimer();
        setLinearLayoutVisibility(false);
        if (z) {
            setBottomNavBarVisibility(false);
        }
        hideBottomSymbols();
    }

    public void setLogoImageVisibility(boolean z) {
        ImageView imageView = (ImageView) findViewById(R.id.imageViewLogo);
        String packageName = getPackageName();
        if (packageName.equals(BuildConfig.APPLICATION_ID)) {
            imageView.setImageResource(R.drawable.tylo_logo);
        } else if (packageName.equals("com.tylohelo.helo")) {
            imageView.setImageResource(R.drawable.helo_logo);
        }
        imageView.setVisibility(z ? 0 : 8);
        if (bottomSymbolsVisible) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void handleStandbyButton() {
        final MaterialButton materialButton = (MaterialButton) findViewById(R.id.buttonStandby);
        materialButton.setTextAlignment(4);
        materialButton.setIcon(ContextCompat.getDrawable(this, R.drawable.standby));
        this.linearLayout.setWeightSum(2.0f);
        materialButton.setVisibility(8);
        final SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class);
        sharedViewModel.getStandbyEnabled().observe(this, new Observer() { // from class: com.tylohelo.tylohelo.MainActivity$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.m306lambda$handleStandbyButton$14$comtylohelotyloheloMainActivity(sharedViewModel, materialButton, (Integer) obj);
            }
        });
    }

    /* renamed from: lambda$handleStandbyButton$14$com-tylohelo-tylohelo-MainActivity, reason: not valid java name */
    /* synthetic */ void m306lambda$handleStandbyButton$14$comtylohelotyloheloMainActivity(SharedViewModel sharedViewModel, MaterialButton materialButton, Integer num) {
        if (num != null) {
            this.standbyEnabled = num.intValue() == 1;
        }
        if (!this.standbyEnabled) {
            this.linearLayout.setWeightSum(2.0f);
            materialButton.setVisibility(8);
        } else {
            if (sharedViewModel.getSaunaState().getValue() == SaunaState.Sauna_state_changed.state_t.STATE_DRYUP || this.stopButtonVisible) {
                return;
            }
            materialButton.setVisibility(0);
            this.linearLayout.setWeightSum(3.0f);
        }
    }

    public void hideBottomSymbols() {
        setCloudImageVisibility(false);
        setWifiImageVisibility(false);
        setLogoImageVisibility(false);
        bottomSymbolsVisible = false;
    }

    private void animateBottomSymbols() {
        final SharedViewModel sharedViewModel = (SharedViewModel) ViewModelProviders.of(this).get(SharedViewModel.class);
        getResources().getInteger(android.R.integer.config_shortAnimTime);
        this.bottomNavigationView.animate().alpha(1.0f).setDuration(800L).setListener(new AnimatorListenerAdapter() { // from class: com.tylohelo.tylohelo.MainActivity.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                boolean unused = MainActivity.animateStarted = false;
                if (MainActivity.stopAnimate) {
                    boolean unused2 = MainActivity.stopAnimate = false;
                    return;
                }
                if (MainActivity.this.bottomNavigationView.getVisibility() != 0) {
                    boolean unused3 = MainActivity.bottomSymbolsVisible = true;
                    MainActivity.this.setLogoImageVisibility(true);
                    if (tyloApplication.getNetworkType() == tyloApplication.networkType_t.NETWORK_CLOUD) {
                        MainActivity.this.setCloudImageVisibility(true);
                    } else if (tyloApplication.getNetworkType() == tyloApplication.networkType_t.NETWORK_WIFI && tyloApplication.isConnected(MainActivity.this, sharedViewModel)) {
                        MainActivity.this.setWifiImageVisibility(true);
                    }
                }
            }
        });
    }
}
