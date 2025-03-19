package tech.gusavila92.apache.http.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    Registry(Map<String, I> map) {
        this.map = new ConcurrentHashMap(map);
    }

    @Override // tech.gusavila92.apache.http.config.Lookup
    public I lookup(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str.toLowerCase(Locale.ROOT));
    }

    public String toString() {
        return this.map.toString();
    }
}
