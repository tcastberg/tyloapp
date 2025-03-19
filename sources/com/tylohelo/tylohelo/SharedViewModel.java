package com.tylohelo.tylohelo;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tylohelo.tylohelo.protobuf.AuxRelay;
import com.tylohelo.tylohelo.protobuf.Calendar;
import com.tylohelo.tylohelo.protobuf.Favorite;
import com.tylohelo.tylohelo.protobuf.SaunaState;
import com.tylohelo.tylohelo.protobuf.UserMessage;
import java.util.List;

/* loaded from: classes2.dex */
public class SharedViewModel extends AndroidViewModel {
    private final MutableLiveData<List<AuxRelay.Aux_relay_post_sauna>> auxList;
    private final MutableLiveData<Integer> bathTime;
    private final MutableLiveData<List<Calendar.Calendar_post>> calendarProgramList;
    private final MutableLiveData<Boolean> cloudOnline;
    private final MutableLiveData<Integer> dateFormat;
    private final MutableLiveData<Integer> externalHumidity;
    private final MutableLiveData<Integer> externalTemperature;
    private final MutableLiveData<Integer> facilityType;
    private final MutableLiveData<List<Favorite.Favorite_post>> favList;
    private final MutableLiveData<Integer> humidityPresentation;
    private final MutableLiveData<Integer> humiditySensorAvailable;
    private final MutableLiveData<Integer> irEnabled;
    private final MutableLiveData<Boolean> isCalendarFav;
    private final MutableLiveData<Boolean> isSaunaListUpdated;
    private final MutableLiveData<Boolean> isSaunaUpdated;
    private final MutableLiveData<Integer> lightning;
    private final MutableLiveData<Calendar.Calendar_post> localCalendarPost;
    private final MutableLiveData<Calendar.Calendar_post> localCustomPost;
    private final MutableLiveData<Favorite.Favorite_post> localFavPost;
    private final MutableLiveData<Integer> lowerLimitTemperature;
    private final MutableLiveData<Integer> maxBathTime;
    private final MutableLiveData<Integer> presentedHumidity;
    private final MutableLiveData<Integer> presentedTemperature;
    private final MutableLiveData<Integer> runTimeLeft;
    private final MutableLiveData<SaunaState.Sauna_state_changed.state_t> saunaState;
    private final MutableLiveData<Long> saunaTime;
    private final MutableLiveData<Boolean> saveChanges;
    private final MutableLiveData<Integer> selectedFavIndex;
    private final MutableLiveData<Integer> standbyEnabled;
    private final MutableLiveData<Integer> targetHumidity;
    private final MutableLiveData<Integer> targetTemperature;
    private final MutableLiveData<Integer> temperaturePresentation;
    private final MutableLiveData<Integer> temperatureUnit;
    private final MutableLiveData<Integer> timeFormat;
    private final MutableLiveData<Integer> upperLimitTemperature;
    private final MutableLiveData<UserMessage.User_message> userMessage;
    private final MutableLiveData<UserMessage.User_message> userMessageLocal;
    private final MutableLiveData<Integer> waterLevel;
    private final MutableLiveData<Boolean> wifiOnline;

    public SharedViewModel(Application application) {
        super(application);
        this.presentedTemperature = new MutableLiveData<>();
        this.presentedHumidity = new MutableLiveData<>();
        this.targetTemperature = new MutableLiveData<>();
        this.externalTemperature = new MutableLiveData<>();
        this.upperLimitTemperature = new MutableLiveData<>();
        this.lowerLimitTemperature = new MutableLiveData<>();
        this.targetHumidity = new MutableLiveData<>();
        this.externalHumidity = new MutableLiveData<>();
        this.runTimeLeft = new MutableLiveData<>();
        this.bathTime = new MutableLiveData<>();
        this.maxBathTime = new MutableLiveData<>();
        this.saunaState = new MutableLiveData<>();
        this.saunaTime = new MutableLiveData<>();
        this.temperatureUnit = new MutableLiveData<>();
        this.temperaturePresentation = new MutableLiveData<>();
        this.humidityPresentation = new MutableLiveData<>();
        this.dateFormat = new MutableLiveData<>();
        this.timeFormat = new MutableLiveData<>();
        this.waterLevel = new MutableLiveData<>();
        this.facilityType = new MutableLiveData<>();
        this.humiditySensorAvailable = new MutableLiveData<>();
        this.irEnabled = new MutableLiveData<>();
        this.lightning = new MutableLiveData<>();
        this.standbyEnabled = new MutableLiveData<>();
        this.cloudOnline = new MutableLiveData<>();
        this.wifiOnline = new MutableLiveData<>();
        this.selectedFavIndex = new MutableLiveData<>();
        this.localFavPost = new MutableLiveData<>();
        this.localCalendarPost = new MutableLiveData<>();
        this.localCustomPost = new MutableLiveData<>();
        this.saveChanges = new MutableLiveData<>();
        this.isCalendarFav = new MutableLiveData<>();
        this.userMessageLocal = new MutableLiveData<>();
        this.isSaunaListUpdated = new MutableLiveData<>();
        this.isSaunaUpdated = new MutableLiveData<>();
        this.favList = new MutableLiveData<>();
        this.calendarProgramList = new MutableLiveData<>();
        this.auxList = new MutableLiveData<>();
        this.userMessage = new MutableLiveData<>();
    }

    public void setPresentedTemperature(Integer num) {
        this.presentedTemperature.postValue(num);
    }

    public LiveData<Integer> getPresentedTemperature() {
        return this.presentedTemperature;
    }

    public void setTargetTemperature(Integer num) {
        this.targetTemperature.postValue(num);
    }

    public LiveData<Integer> getTargetTemperature() {
        return this.targetTemperature;
    }

    public MutableLiveData<Integer> getExternalTemperature() {
        return this.externalTemperature;
    }

    public void setExternalTemperature(Integer num) {
        this.externalTemperature.postValue(num);
    }

    public MutableLiveData<Integer> getExternalHumidity() {
        return this.externalHumidity;
    }

    public void setExternalHumidity(Integer num) {
        this.externalHumidity.postValue(num);
    }

    public MutableLiveData<Integer> getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public void setTemperatureUnit(Integer num) {
        this.temperatureUnit.postValue(num);
    }

    public MutableLiveData<Integer> getTemperaturePresentation() {
        return this.temperaturePresentation;
    }

    public void setTemperaturePresentation(Integer num) {
        this.temperaturePresentation.postValue(num);
    }

    public MutableLiveData<Integer> getHumidityPresentation() {
        return this.humidityPresentation;
    }

    public void setHumidityPresentation(Integer num) {
        this.humidityPresentation.postValue(num);
    }

    public MutableLiveData<Integer> getUpperLimitTemperature() {
        return this.upperLimitTemperature;
    }

    public void setUpperLimitTemperature(Integer num) {
        this.upperLimitTemperature.postValue(num);
    }

    public MutableLiveData<Integer> getLowerLimitTemperature() {
        return this.lowerLimitTemperature;
    }

    public void setLowerLimitTemperature(Integer num) {
        this.lowerLimitTemperature.postValue(num);
    }

    public LiveData<SaunaState.Sauna_state_changed.state_t> getSaunaState() {
        return this.saunaState;
    }

    public void setSaunaState(SaunaState.Sauna_state_changed.state_t state_tVar) {
        this.saunaState.postValue(state_tVar);
    }

    public void setTargetHumidity(Integer num) {
        this.targetHumidity.postValue(num);
    }

    public LiveData<Integer> getTargetHumidity() {
        return this.targetHumidity;
    }

    public MutableLiveData<Integer> getWaterLevel() {
        return this.waterLevel;
    }

    public void setWaterLevel(Integer num) {
        this.waterLevel.postValue(num);
    }

    public MutableLiveData<Integer> getHumiditySensorAvailable() {
        return this.humiditySensorAvailable;
    }

    public void setHumiditySensorAvailable(Integer num) {
        this.humiditySensorAvailable.postValue(num);
    }

    public void setRunTimeLeft(Integer num) {
        this.runTimeLeft.postValue(num);
    }

    public MutableLiveData<Integer> getRunTimeLeft() {
        return this.runTimeLeft;
    }

    public MutableLiveData<Integer> getPresentedHumidity() {
        return this.presentedHumidity;
    }

    public void setPresentedHumidity(Integer num) {
        this.presentedHumidity.postValue(num);
    }

    public MutableLiveData<Integer> getIREnabled() {
        return this.irEnabled;
    }

    public void setIREnabled(Integer num) {
        this.irEnabled.postValue(num);
    }

    public MutableLiveData<Integer> getStandbyEnabled() {
        return this.standbyEnabled;
    }

    public void setStandbyEnabled(Integer num) {
        this.standbyEnabled.postValue(num);
    }

    public MutableLiveData<Boolean> getCloudOnline() {
        return this.cloudOnline;
    }

    public MutableLiveData<Boolean> getWifiOnline() {
        return this.wifiOnline;
    }

    public void setCloudOnline(Boolean bool) {
        this.cloudOnline.postValue(bool);
    }

    public void setWifiOnline(Boolean bool) {
        this.wifiOnline.postValue(bool);
    }

    public MutableLiveData<Integer> getSelectedFavIndex() {
        return this.selectedFavIndex;
    }

    public void setSelectedFavIndex(Integer num) {
        this.selectedFavIndex.postValue(num);
    }

    public void setDateFormat(Integer num) {
        this.dateFormat.postValue(num);
    }

    public void setTimeFormat(Integer num) {
        this.timeFormat.postValue(num);
    }

    public MutableLiveData<Integer> getTimeFormat() {
        return this.timeFormat;
    }

    public void setSaunaTime(Long l) {
        this.saunaTime.postValue(l);
    }

    public MutableLiveData<Long> getSaunaTime() {
        return this.saunaTime;
    }

    public MutableLiveData<Integer> getBathTime() {
        return this.bathTime;
    }

    public void setBathTime(Integer num) {
        this.bathTime.postValue(num);
    }

    public MutableLiveData<Integer> getMaxBathTime() {
        return this.maxBathTime;
    }

    public void setMaxBathTime(Integer num) {
        this.maxBathTime.postValue(num);
    }

    public MutableLiveData<List<Favorite.Favorite_post>> getFavList() {
        return this.favList;
    }

    public void setFavList(List<Favorite.Favorite_post> list) {
        this.favList.postValue(list);
    }

    public MutableLiveData<List<AuxRelay.Aux_relay_post_sauna>> getAuxList() {
        return this.auxList;
    }

    public void setAuxList(List<AuxRelay.Aux_relay_post_sauna> list) {
        this.auxList.postValue(list);
    }

    public MutableLiveData<Integer> getLightning() {
        return this.lightning;
    }

    public void setLightning(Integer num) {
        this.lightning.postValue(num);
    }

    public MutableLiveData<Favorite.Favorite_post> getLocalFavPost() {
        return this.localFavPost;
    }

    public void setLocalFavPost(Favorite.Favorite_post favorite_post) {
        this.localFavPost.postValue(favorite_post);
    }

    public MutableLiveData<List<Calendar.Calendar_post>> getCalendarProgramList() {
        return this.calendarProgramList;
    }

    public void setCalendarProgramList(List<Calendar.Calendar_post> list) {
        this.calendarProgramList.postValue(list);
    }

    public MutableLiveData<Calendar.Calendar_post> getLocalCalendarPost() {
        return this.localCalendarPost;
    }

    public void setLocalCalendarPost(Calendar.Calendar_post calendar_post) {
        this.localCalendarPost.postValue(calendar_post);
    }

    public MutableLiveData<Calendar.Calendar_post> getLocalCustomPost() {
        return this.localCustomPost;
    }

    public void setLocalCustomPost(Calendar.Calendar_post calendar_post) {
        this.localCustomPost.postValue(calendar_post);
    }

    public MutableLiveData<Boolean> getSaveChanges() {
        return this.saveChanges;
    }

    public void setSaveChanges(Boolean bool) {
        this.saveChanges.postValue(bool);
    }

    public MutableLiveData<Boolean> getIsCalendarFav() {
        return this.isCalendarFav;
    }

    public void setIsCalendarFav(Boolean bool) {
        this.isCalendarFav.postValue(bool);
    }

    public MutableLiveData<Integer> getFacilityType() {
        return this.facilityType;
    }

    public void setFacilityType(Integer num) {
        this.facilityType.postValue(num);
    }

    public MutableLiveData<UserMessage.User_message> getUserMessage() {
        return this.userMessage;
    }

    public void setUserMessage(UserMessage.User_message user_message) {
        this.userMessage.postValue(user_message);
    }

    public MutableLiveData<UserMessage.User_message> getUserMessageLocal() {
        return this.userMessageLocal;
    }

    public void setUserMessageLocal(UserMessage.User_message user_message) {
        this.userMessageLocal.postValue(user_message);
    }

    public MutableLiveData<Boolean> getIsSaunaListUpdated() {
        return this.isSaunaListUpdated;
    }

    public void setIsSaunaListUpdated(Boolean bool) {
        this.isSaunaListUpdated.postValue(bool);
    }

    public MutableLiveData<Boolean> getIsSaunaUpdated() {
        return this.isSaunaUpdated;
    }

    public void setIsSaunaUpdated(Boolean bool) {
        this.isSaunaUpdated.postValue(bool);
    }

    public void resetViewModelData() {
        this.irEnabled.postValue(null);
        this.presentedTemperature.postValue(null);
        this.presentedHumidity.postValue(null);
        this.targetTemperature.postValue(null);
        this.externalTemperature.postValue(null);
        this.upperLimitTemperature.postValue(null);
        this.lowerLimitTemperature.postValue(null);
        this.targetHumidity.postValue(null);
        this.externalHumidity.postValue(null);
        this.runTimeLeft.postValue(null);
        this.bathTime.postValue(null);
        this.maxBathTime.postValue(null);
        this.saunaState.postValue(null);
        this.saunaTime.postValue(null);
        this.temperatureUnit.postValue(null);
        this.temperaturePresentation.postValue(null);
        this.humidityPresentation.postValue(null);
        this.dateFormat.postValue(null);
        this.timeFormat.postValue(null);
        this.waterLevel.postValue(null);
        this.facilityType.postValue(null);
        this.humiditySensorAvailable.postValue(null);
        this.irEnabled.postValue(null);
        this.lightning.postValue(null);
        this.favList.postValue(null);
        this.calendarProgramList.postValue(null);
        this.auxList.postValue(null);
        this.userMessage.postValue(null);
        this.localCalendarPost.postValue(null);
        this.localCustomPost.postValue(null);
        this.saveChanges.postValue(null);
        this.isCalendarFav.postValue(null);
    }
}
