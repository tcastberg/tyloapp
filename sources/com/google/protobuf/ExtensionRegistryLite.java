package com.google.protobuf;

import androidx.core.internal.view.SupportMenu;
import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static boolean doFullRuntimeInheritanceCheck = true;
    private static volatile boolean eagerlyParseMessageSets = false;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    private static class ExtensionClassHolder {
        static final Class<?> INSTANCE = resolveExtensionClass();

        private ExtensionClassHolder() {
        }

        static Class<?> resolveExtensionClass() {
            try {
                return Class.forName(ExtensionRegistryLite.EXTENSION_CLASS_NAME);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static void setEagerlyParseMessageSets(boolean isEagerlyParse) {
        eagerlyParseMessageSets = isEagerlyParse;
    }

    public static ExtensionRegistryLite newInstance() {
        if (doFullRuntimeInheritanceCheck) {
            return ExtensionRegistryFactory.create();
        }
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        if (!doFullRuntimeInheritanceCheck) {
            return EMPTY_REGISTRY_LITE;
        }
        ExtensionRegistryLite extensionRegistryLite = emptyRegistry;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = emptyRegistry;
                if (extensionRegistryLite == null) {
                    extensionRegistryLite = ExtensionRegistryFactory.createEmpty();
                    emptyRegistry = extensionRegistryLite;
                }
            }
        }
        return extensionRegistryLite;
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(final ContainingType containingTypeDefaultInstance, final int fieldNumber) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(containingTypeDefaultInstance, fieldNumber));
    }

    public final void add(final GeneratedMessageLite.GeneratedExtension<?, ?> extension) {
        this.extensionsByNumber.put(new ObjectIntPair(extension.getContainingTypeDefaultInstance(), extension.getNumber()), extension);
    }

    public final void add(ExtensionLite<?, ?> extension) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extension.getClass())) {
            add((GeneratedMessageLite.GeneratedExtension<?, ?>) extension);
        }
        if (doFullRuntimeInheritanceCheck && ExtensionRegistryFactory.isFullRegistry(this)) {
            try {
                getClass().getMethod("add", ExtensionClassHolder.INSTANCE).invoke(this, extension);
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", extension), e);
            }
        }
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    ExtensionRegistryLite(ExtensionRegistryLite other) {
        if (other == EMPTY_REGISTRY_LITE) {
            this.extensionsByNumber = Collections.emptyMap();
        } else {
            this.extensionsByNumber = Collections.unmodifiableMap(other.extensionsByNumber);
        }
    }

    ExtensionRegistryLite(boolean empty) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    private static final class ObjectIntPair {
        private final int number;
        private final Object object;

        ObjectIntPair(final Object object, final int number) {
            this.object = object;
            this.number = number;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }

        public boolean equals(final Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            return this.object == objectIntPair.object && this.number == objectIntPair.number;
        }
    }
}
