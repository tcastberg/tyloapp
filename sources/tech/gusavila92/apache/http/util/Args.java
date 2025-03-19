package tech.gusavila92.apache.http.util;

import java.util.Collection;

/* loaded from: classes2.dex */
public class Args {
    public static void check(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void check(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }

    public static <T> T notNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static <T extends CharSequence> T notEmpty(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(str + " may not be empty");
        }
        return t;
    }

    public static <T extends CharSequence> T notBlank(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (TextUtils.isBlank(t)) {
            throw new IllegalArgumentException(str + " may not be blank");
        }
        return t;
    }

    public static <T extends CharSequence> T containsNoBlanks(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (TextUtils.containsBlanks(t)) {
            throw new IllegalArgumentException(str + " may not contain blanks");
        }
        return t;
    }

    public static <E, T extends Collection<E>> T notEmpty(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (t.isEmpty()) {
            throw new IllegalArgumentException(str + " may not be empty");
        }
        return t;
    }

    public static int positive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static long positive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static int notNegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static long notNegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }
}
