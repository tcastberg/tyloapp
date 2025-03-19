package com.microsoft.windowsazure.messaging;

import android.os.Build;
import com.microsoft.windowsazure.messaging.Registration;

/* loaded from: classes2.dex */
public final class PnsSpecificRegistrationFactory {
    private static Registration.RegistrationType mRegistrationType = Registration.RegistrationType.fcmv1;
    private static final PnsSpecificRegistrationFactory mInstance = new PnsSpecificRegistrationFactory();

    private PnsSpecificRegistrationFactory() {
        if (Build.MANUFACTURER.compareToIgnoreCase("Amazon") == 0) {
            mRegistrationType = Registration.RegistrationType.adm;
        }
    }

    public static PnsSpecificRegistrationFactory getInstance() {
        return mInstance;
    }

    public void setRegistrationType(Registration.RegistrationType registrationType) {
        mRegistrationType = registrationType;
    }

    public Registration.RegistrationType getRegistrationType() {
        return mRegistrationType;
    }

    public Registration createNativeRegistration(String str) {
        return createNativeRegistrationForPlatform(str, mRegistrationType);
    }

    /* renamed from: com.microsoft.windowsazure.messaging.PnsSpecificRegistrationFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType;

        static {
            int[] iArr = new int[Registration.RegistrationType.values().length];
            $SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType = iArr;
            try {
                iArr[Registration.RegistrationType.gcm.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[Registration.RegistrationType.fcm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[Registration.RegistrationType.fcmv1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[Registration.RegistrationType.baidu.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[Registration.RegistrationType.adm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Registration createNativeRegistrationForPlatform(String str, Registration.RegistrationType registrationType) {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[registrationType.ordinal()];
        if (i == 1) {
            return new GcmNativeRegistration(str);
        }
        if (i == 2) {
            return new FcmNativeRegistration(str);
        }
        if (i == 3) {
            return new FcmV1NativeRegistration(str);
        }
        if (i == 4) {
            return new BaiduNativeRegistration(str);
        }
        if (i == 5) {
            return new AdmNativeRegistration(str);
        }
        throw new AssertionError("Invalid registration type!");
    }

    public TemplateRegistration createTemplateRegistration(String str) {
        return createTemplateRegistrationForPlatform(str, mRegistrationType);
    }

    public TemplateRegistration createTemplateRegistrationForPlatform(String str, Registration.RegistrationType registrationType) {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[registrationType.ordinal()];
        if (i == 1) {
            return new GcmTemplateRegistration(str);
        }
        if (i == 2) {
            return new FcmTemplateRegistration(str);
        }
        if (i == 3) {
            return new FcmV1TemplateRegistration(str);
        }
        if (i == 4) {
            return new BaiduTemplateRegistration(str);
        }
        if (i == 5) {
            return new AdmTemplateRegistration(str);
        }
        throw new AssertionError("Invalid registration type!");
    }

    public boolean isTemplateRegistration(String str) {
        return isTemplateRegistrationForPlatform(str, mRegistrationType);
    }

    public boolean isTemplateRegistrationForPlatform(String str, Registration.RegistrationType registrationType) {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[registrationType.ordinal()];
        String str2 = "GcmTemplateRegistrationDescription";
        if (i != 1 && i != 2) {
            if (i == 3) {
                str2 = "FcmV1TemplateRegistrationDescription";
            } else if (i == 4) {
                str2 = "BaiduTemplateRegistrationDescription";
            } else if (i == 5) {
                str2 = "AdmTemplateRegistrationDescription";
            } else {
                throw new AssertionError("Invalid registration type!");
            }
        }
        return str.contains("<".concat(str2));
    }

    public String getPNSHandleFieldName() {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[mRegistrationType.ordinal()];
        if (i == 1 || i == 2) {
            return "GcmRegistrationId";
        }
        if (i == 3) {
            return "FcmV1RegistrationId";
        }
        if (i == 4) {
            return "BaiduUserId-BaiduChannelId";
        }
        if (i == 5) {
            return "AdmRegistrationId";
        }
        throw new AssertionError("Invalid registration type!");
    }

    public String getAPIOrigin() {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$windowsazure$messaging$Registration$RegistrationType[mRegistrationType.ordinal()];
        if (i == 1) {
            return "AndroidSdkGcm";
        }
        if (i == 2) {
            return "AndroidSdkFcm";
        }
        if (i == 3) {
            return "AndroidSdkFcmV1";
        }
        if (i == 4) {
            return "AndroidSdkBaidu";
        }
        if (i == 5) {
            return "AndroidSdkAdm";
        }
        throw new AssertionError("Invalid registration type!");
    }
}
