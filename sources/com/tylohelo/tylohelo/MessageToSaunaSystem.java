package com.tylohelo.tylohelo;

import androidx.fragment.app.FragmentActivity;
import com.tylohelo.tylohelo.protobuf.AuxRelay;
import com.tylohelo.tylohelo.protobuf.BooleanValue;
import com.tylohelo.tylohelo.protobuf.Calendar;
import com.tylohelo.tylohelo.protobuf.Command;
import com.tylohelo.tylohelo.protobuf.Connect;
import com.tylohelo.tylohelo.protobuf.Favorite;
import com.tylohelo.tylohelo.protobuf.IntegerValue;
import com.tylohelo.tylohelo.protobuf.Message;
import com.tylohelo.tylohelo.protobuf.SaunaState;
import com.tylohelo.tylohelo.protobuf.UserMessage;

/* loaded from: classes2.dex */
public class MessageToSaunaSystem {
    FragmentActivity activity;

    public MessageToSaunaSystem(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    private void sendDataToSauna(byte[] bArr) {
        SaunaModel saunaStored;
        SaunaService saunaService = tyloApplication.getSaunaService();
        if (saunaService == null) {
            saunaService = new SaunaService(this.activity);
            tyloApplication.setSaunaService(saunaService);
        }
        String currentSaunaId = saunaService.getCurrentSaunaId();
        if (currentSaunaId == null || (saunaStored = saunaService.getSaunaStored(currentSaunaId)) == null || !saunaStored.isConnected()) {
            return;
        }
        if (saunaService.getCloudEnabled() && saunaStored.getAPIKey() != null) {
            CloudService cloudService = tyloApplication.getCloudService();
            if (cloudService == null) {
                cloudService = new CloudService(this.activity);
                tyloApplication.setCloudService(cloudService);
            }
            cloudService.sendPacket(bArr);
            return;
        }
        MulticastSocket.sendData(bArr, saunaService);
    }

    public void sendSaunaStateMsg(SaunaState.Sauna_state_change_request.state_t state_tVar) {
        sendDataToSauna(Message.External_to_sauna.newBuilder().setSaunaState(SaunaState.Sauna_state_change_request.newBuilder().setState(state_tVar).build()).build().toByteArray());
    }

    public void sendTargetTemperature(int i) {
        IntegerValue.Integer_value_change_request.Builder newBuilder = IntegerValue.Integer_value_change_request.newBuilder();
        newBuilder.setValueType(IntegerValue.Integer_value_change_request.value_t.TARGET_TEMPERATURE);
        newBuilder.setValue(i);
        sendDataToSauna(Message.External_to_sauna.newBuilder().addIntegerValue(newBuilder.build()).build().toByteArray());
    }

    public void sendTargetHumidity(int i) {
        IntegerValue.Integer_value_change_request.Builder newBuilder = IntegerValue.Integer_value_change_request.newBuilder();
        newBuilder.setValueType(IntegerValue.Integer_value_change_request.value_t.TARGET_HUMIDITY);
        newBuilder.setValue(i);
        sendDataToSauna(Message.External_to_sauna.newBuilder().addIntegerValue(newBuilder.build()).build().toByteArray());
    }

    public void sendBathTime(int i) {
        IntegerValue.Integer_value_change_request.Builder newBuilder = IntegerValue.Integer_value_change_request.newBuilder();
        newBuilder.setValueType(IntegerValue.Integer_value_change_request.value_t.BATH_TIME);
        newBuilder.setValue(i);
        sendDataToSauna(Message.External_to_sauna.newBuilder().addIntegerValue(newBuilder.build()).build().toByteArray());
    }

    public void sendFavorite(Favorite.Favorite_post favorite_post) {
        sendDataToSauna(Message.External_to_sauna.newBuilder().addFavorite(favorite_post).build().toByteArray());
    }

    public void sendLightningState(boolean z) {
        BooleanValue.Boolean_value_change_request.Builder newBuilder = BooleanValue.Boolean_value_change_request.newBuilder();
        newBuilder.setValueType(BooleanValue.Boolean_value_change_request.value_t.LIGHTING);
        if (z) {
            newBuilder.setValue(1);
        } else {
            newBuilder.setValue(0);
        }
        sendDataToSauna(Message.External_to_sauna.newBuilder().addBooleanValue(newBuilder.build()).build().toByteArray());
    }

    public void sendAuxRelayPost(AuxRelay.Aux_relay_post aux_relay_post) {
        sendDataToSauna(Message.External_to_sauna.newBuilder().addAuxRelay(aux_relay_post).build().toByteArray());
    }

    public void sendStartFavorite(int i) {
        IntegerValue.Integer_value_change_request.Builder newBuilder = IntegerValue.Integer_value_change_request.newBuilder();
        newBuilder.setValueType(IntegerValue.Integer_value_change_request.value_t.START_FAVORITE);
        newBuilder.setValue(i);
        sendDataToSauna(Message.External_to_sauna.newBuilder().addIntegerValue(newBuilder.build()).build().toByteArray());
    }

    public void sendCalendarProgram(Calendar.Calendar_post calendar_post) {
        sendDataToSauna(Message.External_to_sauna.newBuilder().addCalendarProgram(calendar_post).build().toByteArray());
    }

    public void sendDeleteCalendarProgram(Calendar.Calendar_post calendar_post) {
        sendDataToSauna(Message.External_to_sauna.newBuilder().addCalendarProgram(calendar_post).build().toByteArray());
    }

    public void sendUserMsg(UserMessage.User_message user_message) {
        sendDataToSauna(Message.External_to_sauna.newBuilder().setUserMessage(user_message).build().toByteArray());
    }

    public void sendCharTableRequest() {
        sendDataToSauna(Message.External_to_sauna.newBuilder().addGeneralCommand(Command.General_command.newBuilder().setCommand(Command.General_command.command_t.SEND_CHARACTER_TABLE).build()).build().toByteArray());
    }

    public void sendHumidityTableRequest() {
        sendDataToSauna(Message.External_to_sauna.newBuilder().addGeneralCommand(Command.General_command.newBuilder().setCommand(Command.General_command.command_t.SEND_MAX_HUMIDITY_TABLE).build()).build().toByteArray());
    }

    public void sendTemperatureTableRequest() {
        sendDataToSauna(Message.External_to_sauna.newBuilder().addGeneralCommand(Command.General_command.newBuilder().setCommand(Command.General_command.command_t.SEND_MAX_TEMPERATURE_TABLE).build()).build().toByteArray());
    }

    public void sendKeepAlive(int i) {
        Connect.Keep_alive.Builder newBuilder = Connect.Keep_alive.newBuilder();
        newBuilder.setSequenceNumber(i);
        sendDataToSauna(Message.External_to_sauna.newBuilder().setKeepAlive(newBuilder.build()).build().toByteArray());
    }

    public void sendDisconnectionRequest() {
        sendDataToSauna(Message.External_to_sauna.newBuilder().setDisconnectRequest(Connect.Disconnect_request.newBuilder().build()).build().toByteArray());
    }
}
