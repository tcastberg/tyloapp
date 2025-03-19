package com.tylohelo.tylohelo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.tylohelo.tylohelo.protobuf.UserMessage;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class UserMessageService {
    private static AlertDialog alertDialogBox;

    public static UserMessage.User_message buildUserMsg(UserMessage.User_message.message_type_t message_type_tVar, String str) {
        UserMessage.User_message.Builder newBuilder = UserMessage.User_message.newBuilder();
        newBuilder.setMessageType(message_type_tVar);
        newBuilder.setIdentity(0);
        newBuilder.addAllFormattedPanelMessage(strToArr(str));
        return newBuilder.build();
    }

    public static Iterable<? extends Integer> strToArr(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            arrayList.add(Integer.valueOf(Character.codePointAt(str, i)));
        }
        return arrayList;
    }

    public static String getUserMsgString(UserMessage.User_message user_message) {
        StringBuilder sb = new StringBuilder(user_message.getFormattedPanelMessageCount());
        Iterator<Integer> it = user_message.getFormattedPanelMessageList().iterator();
        while (it.hasNext()) {
            sb.append(Character.toChars(it.next().intValue()));
        }
        return String.valueOf(sb);
    }

    public static void createAlertBox(String str, UserMessage.User_message user_message, Context context, FragmentActivity fragmentActivity, final boolean z) {
        if (tyloApplication.getMessageToSaunaSystem() == null) {
            tyloApplication.setMessageToSaunaSystem(new MessageToSaunaSystem(fragmentActivity));
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str);
        builder.setTitle("Message");
        builder.setCancelable(false);
        if (user_message.hasMessageType()) {
            if (user_message.getMessageType() == UserMessage.User_message.message_type_t.TYPE_NO_MESSAGE) {
                AlertDialog alertDialog = alertDialogBox;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    return;
                }
                return;
            }
            final UserMessage.User_message.Builder mergeFrom = UserMessage.User_message.newBuilder().mergeFrom(user_message);
            mergeFrom.clearAnswer();
            if (user_message.getMessageType().getNumber() == 11 || user_message.getMessageType().getNumber() == 13) {
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.UserMessageService$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        UserMessageService.lambda$createAlertBox$0(z, mergeFrom, dialogInterface, i);
                    }
                });
            }
            if (user_message.getMessageType().getNumber() == 12) {
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.UserMessageService$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        UserMessageService.lambda$createAlertBox$1(z, mergeFrom, dialogInterface, i);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.tylohelo.tylohelo.UserMessageService$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        UserMessageService.lambda$createAlertBox$2(z, mergeFrom, dialogInterface, i);
                    }
                });
            }
            AlertDialog create = builder.create();
            alertDialogBox = create;
            create.show();
        }
    }

    static /* synthetic */ void lambda$createAlertBox$0(boolean z, UserMessage.User_message.Builder builder, DialogInterface dialogInterface, int i) {
        MessageToSaunaSystem messageToSaunaSystem = tyloApplication.getMessageToSaunaSystem();
        if (z) {
            return;
        }
        builder.setAnswer(UserMessage.User_message.answer_t.ANSWER_OK);
        messageToSaunaSystem.sendUserMsg(builder.build());
    }

    static /* synthetic */ void lambda$createAlertBox$1(boolean z, UserMessage.User_message.Builder builder, DialogInterface dialogInterface, int i) {
        if (z) {
            return;
        }
        builder.setAnswer(UserMessage.User_message.answer_t.ANSWER_YES);
        tyloApplication.getMessageToSaunaSystem().sendUserMsg(builder.build());
    }

    static /* synthetic */ void lambda$createAlertBox$2(boolean z, UserMessage.User_message.Builder builder, DialogInterface dialogInterface, int i) {
        if (z) {
            return;
        }
        builder.setAnswer(UserMessage.User_message.answer_t.ANSWER_NO);
        tyloApplication.getMessageToSaunaSystem().sendUserMsg(builder.build());
    }
}
