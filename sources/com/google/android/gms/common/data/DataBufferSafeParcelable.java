package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zaa = {Constants.ScionAnalytics.MessageType.DATA_MESSAGE};
    private final Parcelable.Creator zab;

    public DataBufferSafeParcelable(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zab = creator;
    }

    public static <T extends SafeParcelable> void addValue(DataHolder.Builder builder, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, obtain.marshall());
        builder.withRow(contentValues);
        obtain.recycle();
    }

    public static DataHolder.Builder buildDataHolder() {
        return DataHolder.builder(zaa);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public T get(int i) {
        DataHolder dataHolder = (DataHolder) Preconditions.checkNotNull(this.mDataHolder);
        byte[] byteArray = dataHolder.getByteArray(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, i, dataHolder.getWindowIndex(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        T t = (T) this.zab.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
