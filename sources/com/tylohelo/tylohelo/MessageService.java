package com.tylohelo.tylohelo;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tylohelo.tylohelo.protobuf.AuxRelay;
import com.tylohelo.tylohelo.protobuf.BooleanValue;
import com.tylohelo.tylohelo.protobuf.Calendar;
import com.tylohelo.tylohelo.protobuf.EnumValue;
import com.tylohelo.tylohelo.protobuf.Favorite;
import com.tylohelo.tylohelo.protobuf.IntegerValue;
import com.tylohelo.tylohelo.protobuf.Message;
import com.tylohelo.tylohelo.protobuf.PresentedValue;
import com.tylohelo.tylohelo.protobuf.SaunaState;
import com.tylohelo.tylohelo.protobuf.UserMessage;
import com.tylohelo.tylohelo.protobuf.UserSetting;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MessageService {
    FragmentActivity activity;
    Context context;

    public MessageService(Context context, FragmentActivity fragmentActivity) {
        this.context = context;
        this.activity = fragmentActivity;
    }

    public void handle(Message.Sauna_to_external sauna_to_external, SharedViewModel sharedViewModel) {
        if (sauna_to_external != null) {
            if (!String.valueOf(sauna_to_external.getUserMessage()).isEmpty()) {
                handleUserMessage(sauna_to_external.getUserMessage(), sharedViewModel);
            }
            if (!String.valueOf(sauna_to_external.getPresentedValue()).isEmpty()) {
                handlePresentedValue(sauna_to_external.getPresentedValue(), sharedViewModel);
            }
            if (!String.valueOf(sauna_to_external.getIntegerValueCount()).isEmpty() && sauna_to_external.getIntegerValueCount() > 0) {
                for (IntegerValue.Integer_value_changed integer_value_changed : sauna_to_external.getIntegerValueList()) {
                    if (integer_value_changed != null && integer_value_changed.hasValueType()) {
                        switch (integer_value_changed.getValueType().getNumber()) {
                            case 10:
                                System.out.println("Target Temperature: " + integer_value_changed.getValue());
                                if (integer_value_changed.getValue() > 0) {
                                    sharedViewModel.setTargetTemperature(Integer.valueOf(integer_value_changed.getValue()));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                System.out.println("standbyOffsetTemperature: " + integer_value_changed.getValue());
                                break;
                            case 12:
                                System.out.println("External temperature: " + integer_value_changed.getValue());
                                sharedViewModel.setExternalTemperature(Integer.valueOf(integer_value_changed.getValue()));
                                break;
                            case 13:
                                System.out.println("lowerLimitTemperature: " + integer_value_changed.getValue());
                                sharedViewModel.setLowerLimitTemperature(Integer.valueOf(integer_value_changed.getValue()));
                                break;
                            case 14:
                                sharedViewModel.setUpperLimitTemperature(Integer.valueOf(integer_value_changed.getValue()));
                                break;
                            case 15:
                                System.out.println("systemLowerLimitTemperature: " + integer_value_changed.getValue());
                                break;
                            case 17:
                                System.out.println("bathTime: " + integer_value_changed.getValue());
                                sharedViewModel.setBathTime(Integer.valueOf(integer_value_changed.getValue()));
                                break;
                            case 18:
                                System.out.println("maxBathTime: " + integer_value_changed.getValue());
                                sharedViewModel.setMaxBathTime(Integer.valueOf(integer_value_changed.getValue()));
                                break;
                            case 19:
                                System.out.println("externalHumidity: " + integer_value_changed.getValue());
                                sharedViewModel.setExternalHumidity(Integer.valueOf(integer_value_changed.getValue()));
                                break;
                            case 20:
                                System.out.println("targetHumidity: " + integer_value_changed.getValue());
                                sharedViewModel.setTargetHumidity(Integer.valueOf(integer_value_changed.getValue()));
                                break;
                            case 21:
                                System.out.println("tankWaterTemperature: " + integer_value_changed.getValue());
                                break;
                            case 22:
                                System.out.println("runTimeLeft: " + integer_value_changed.getValue());
                                sharedViewModel.setRunTimeLeft(Integer.valueOf(integer_value_changed.getValue()));
                                break;
                            case 23:
                                System.out.println("TimeToAllowedStart: " + integer_value_changed.getValue());
                                break;
                            case 24:
                                System.out.println("tankStandbyTemperature: " + integer_value_changed.getValue());
                                break;
                        }
                    }
                }
            }
            if (sauna_to_external.hasUserSetting()) {
                UserSetting.User_setting userSetting = sauna_to_external.getUserSetting();
                if (userSetting.hasTemperatureUnit()) {
                    sharedViewModel.setTemperatureUnit(Integer.valueOf(userSetting.getTemperatureUnit().getNumber()));
                }
                if (userSetting.hasTemperaturePresentation()) {
                    sharedViewModel.setTemperaturePresentation(Integer.valueOf(userSetting.getTemperaturePresentation().getNumber()));
                }
                if (userSetting.hasHumidityPresentation()) {
                    sharedViewModel.setHumidityPresentation(Integer.valueOf(userSetting.getHumidityPresentation().getNumber()));
                }
                if (userSetting.hasDateFormat()) {
                    sharedViewModel.setDateFormat(Integer.valueOf(userSetting.getDateFormat().getNumber()));
                }
                if (userSetting.hasTimeFormat()) {
                    sharedViewModel.setTimeFormat(Integer.valueOf(userSetting.getTimeFormat().getNumber()));
                }
            }
            if (sauna_to_external.hasSaunaState()) {
                SaunaState.Sauna_state_changed saunaState = sauna_to_external.getSaunaState();
                if (saunaState.hasState()) {
                    sharedViewModel.setSaunaState(saunaState.getState());
                }
                if (saunaState.hasTime()) {
                    sharedViewModel.setSaunaTime(Long.valueOf(saunaState.getTime()));
                }
            }
            if (sauna_to_external.getEnumValueCount() > 0) {
                for (EnumValue.Enum_value_changed enum_value_changed : sauna_to_external.getEnumValueList()) {
                    if (enum_value_changed.hasWaterLevel()) {
                        sharedViewModel.setWaterLevel(Integer.valueOf(enum_value_changed.getWaterLevel().getNumber()));
                    }
                    if (enum_value_changed.hasFacilityType()) {
                        sharedViewModel.setFacilityType(Integer.valueOf(enum_value_changed.getFacilityType().getNumber()));
                    }
                }
            }
            if (sauna_to_external.getBooleanValueCount() > 0) {
                for (BooleanValue.Boolean_value_changed boolean_value_changed : sauna_to_external.getBooleanValueList()) {
                    if (boolean_value_changed.hasValueType()) {
                        int number = boolean_value_changed.getValueType().getNumber();
                        if (number == 23) {
                            if (boolean_value_changed.hasValue()) {
                                sharedViewModel.setIREnabled(Integer.valueOf(boolean_value_changed.getValue()));
                            }
                        } else {
                            switch (number) {
                                case 10:
                                    if (boolean_value_changed.hasValue()) {
                                        sharedViewModel.setLightning(Integer.valueOf(boolean_value_changed.getValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 11:
                                    if (boolean_value_changed.hasValue()) {
                                        sharedViewModel.setStandbyEnabled(Integer.valueOf(boolean_value_changed.getValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 12:
                                    if (boolean_value_changed.hasValue()) {
                                        sharedViewModel.setHumiditySensorAvailable(Integer.valueOf(boolean_value_changed.getValue()));
                                        tyloApplication.setHumiditySensorMissing(Integer.valueOf(boolean_value_changed.getValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                    }
                }
            }
            if (sauna_to_external.getFavoriteCount() > 0) {
                List<Favorite.Favorite_post> favoriteList = sauna_to_external.getFavoriteList();
                List<Favorite.Favorite_post> value = sharedViewModel.getFavList().getValue();
                if (favoriteList.size() == 1) {
                    Favorite.Favorite_post favorite_post = favoriteList.get(0);
                    if (favorite_post.hasIndex()) {
                        int index = favorite_post.getIndex();
                        if (value != null) {
                            ArrayList arrayList = new ArrayList(value);
                            arrayList.set(index, favorite_post);
                            sharedViewModel.setFavList(arrayList);
                        }
                    }
                } else if (!favoriteList.equals(value)) {
                    sharedViewModel.setFavList(favoriteList);
                }
            }
            if (sauna_to_external.getAuxRelaySaunaCount() > 0) {
                List<AuxRelay.Aux_relay_post_sauna> auxRelaySaunaList = sauna_to_external.getAuxRelaySaunaList();
                List<AuxRelay.Aux_relay_post_sauna> value2 = sharedViewModel.getAuxList().getValue();
                if (auxRelaySaunaList.size() == 1) {
                    AuxRelay.Aux_relay_post_sauna aux_relay_post_sauna = auxRelaySaunaList.get(0);
                    AuxRelay.Aux_relay_post auxRelayPost = aux_relay_post_sauna.getAuxRelayPost();
                    if (auxRelayPost.hasIndex()) {
                        int index2 = auxRelayPost.getIndex();
                        if (value2 != null) {
                            ArrayList arrayList2 = new ArrayList(value2);
                            arrayList2.set(index2, aux_relay_post_sauna);
                            sharedViewModel.setAuxList(arrayList2);
                        }
                    }
                }
                if (!auxRelaySaunaList.equals(value2) && auxRelaySaunaList.size() != 1) {
                    sharedViewModel.setAuxList(auxRelaySaunaList);
                }
            }
            if (sauna_to_external.getCalendarProgramCount() > 0) {
                List<Calendar.Calendar_post> calendarProgramList = sauna_to_external.getCalendarProgramList();
                List<Calendar.Calendar_post> value3 = sharedViewModel.getCalendarProgramList().getValue();
                if (calendarProgramList.size() == 1) {
                    Calendar.Calendar_post calendar_post = calendarProgramList.get(0);
                    if (calendar_post.hasIndex()) {
                        int index3 = calendar_post.getIndex();
                        if (value3 != null) {
                            ArrayList arrayList3 = new ArrayList(value3);
                            arrayList3.set(index3, calendar_post);
                            sharedViewModel.setCalendarProgramList(arrayList3);
                        }
                    }
                }
                if (calendarProgramList.equals(value3) || calendarProgramList.size() == 1) {
                    return;
                }
                sharedViewModel.setCalendarProgramList(calendarProgramList);
            }
        }
    }

    private void handlePresentedValue(PresentedValue.Presented_value presented_value, SharedViewModel sharedViewModel) {
        if (presented_value.hasTemperature()) {
            sharedViewModel.setPresentedTemperature(Integer.valueOf(presented_value.getTemperature()));
            System.out.println("PresentedTemperature: " + presented_value.getTemperature());
        }
        if (presented_value.hasHumidity()) {
            sharedViewModel.setPresentedHumidity(Integer.valueOf(presented_value.getHumidity()));
            System.out.println("PresentedHumidity: " + presented_value.getHumidity());
        }
    }

    private void handleUserMessage(UserMessage.User_message user_message, SharedViewModel sharedViewModel) {
        sharedViewModel.setUserMessage(user_message);
    }
}
