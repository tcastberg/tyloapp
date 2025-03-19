package com.tylohelo.tylohelo;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class FormatDateTime {
    public static String getAmPm(int i) {
        if (i == 1) {
            return "PM";
        }
        return "AM";
    }

    public static String getMonth(int i) {
        switch (i) {
            case 0:
                return "Jan";
            case 1:
                return "Feb";
            case 2:
                return "Mar";
            case 3:
                return "Apr";
            case 4:
                return "May";
            case 5:
                return "Jun";
            case 6:
                return "Jul";
            case 7:
                return "Aug";
            case 8:
                return "Sep";
            case 9:
                return "Oct";
            case 10:
                return "Nov";
            case 11:
                return "Dec";
            default:
                return "";
        }
    }

    public static Calendar checkForToday(Integer num, long j, Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        calendar2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = calendar2.get(1);
        int i2 = calendar2.get(2);
        int i3 = calendar2.get(5);
        if (num.intValue() == 11) {
            int i4 = calendar2.get(10);
            int i5 = calendar2.get(12);
            int i6 = calendar.get(10);
            int i7 = calendar.get(12);
            if (calendar2.get(9) == 1 && calendar.get(9) == 0) {
                if (calendar.get(5) <= i3) {
                    calendar.set(5, i3);
                    calendar.set(5, i3 + 1);
                } else {
                    calendar.set(5, i3);
                }
            } else if (calendar2.get(9) == 1 && calendar.get(9) == 1) {
                if (i6 < i4 || (i6 == i4 && i7 < i5)) {
                    calendar.set(5, i3 + 1);
                } else {
                    calendar.set(5, i3);
                }
            } else if (calendar2.get(9) == 0 && calendar.get(9) == 0) {
                if (i6 < i4 || (i6 == i4 && i7 < i5)) {
                    calendar.set(5, i3 + 1);
                } else {
                    calendar.set(5, i3);
                }
            }
        } else {
            int i8 = calendar2.get(11);
            int i9 = calendar2.get(12);
            int i10 = calendar.get(11);
            int i11 = calendar.get(12);
            if (i10 < i8 || (i10 == i8 && i11 < i9)) {
                calendar.set(5, i3 + 1);
            } else {
                calendar.set(5, i3);
            }
        }
        calendar.set(2, i2);
        calendar.set(1, i);
        return calendar;
    }
}
