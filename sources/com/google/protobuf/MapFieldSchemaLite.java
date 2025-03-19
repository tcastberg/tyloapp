package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes2.dex */
class MapFieldSchemaLite implements MapFieldSchema {
    MapFieldSchemaLite() {
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object mapField) {
        return (MapFieldLite) mapField;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object mapDefaultEntry) {
        return ((MapEntryLite) mapDefaultEntry).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object mapField) {
        return (MapFieldLite) mapField;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(Object mapField) {
        return !((MapFieldLite) mapField).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object toImmutable(Object mapField) {
        ((MapFieldLite) mapField).makeImmutable();
        return mapField;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object newMapField(Object unused) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object mergeFrom(Object destMapField, Object srcMapField) {
        return mergeFromLite(destMapField, srcMapField);
    }

    private static <K, V> MapFieldLite<K, V> mergeFromLite(Object destMapField, Object srcMapField) {
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) destMapField;
        MapFieldLite<K, V> mapFieldLite2 = (MapFieldLite) srcMapField;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.isMutable()) {
                mapFieldLite = mapFieldLite.mutableCopy();
            }
            mapFieldLite.mergeFrom(mapFieldLite2);
        }
        return mapFieldLite;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int fieldNumber, Object mapField, Object mapDefaultEntry) {
        return getSerializedSizeLite(fieldNumber, mapField, mapDefaultEntry);
    }

    private static <K, V> int getSerializedSizeLite(int fieldNumber, Object mapField, Object defaultEntry) {
        MapFieldLite mapFieldLite = (MapFieldLite) mapField;
        MapEntryLite mapEntryLite = (MapEntryLite) defaultEntry;
        int i = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : mapFieldLite.entrySet()) {
            i += mapEntryLite.computeMessageSize(fieldNumber, entry.getKey(), entry.getValue());
        }
        return i;
    }
}
