package com.tylohelo.tylohelo;

/* loaded from: classes2.dex */
public class Item {
    private int mIconId;
    private final String mTitle;

    public Item(int i, String str) {
        this.mIconId = i;
        this.mTitle = str;
    }

    int getIconId() {
        return this.mIconId;
    }

    void setIconId(int i) {
        this.mIconId = i;
    }

    String getTitle() {
        return this.mTitle;
    }
}
