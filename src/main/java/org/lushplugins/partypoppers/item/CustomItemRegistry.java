package org.lushplugins.partypoppers.item;

import java.util.HashMap;
import java.util.Map;

public class CustomItemRegistry {
    private final Map<ItemKey, Interactable> customItems = new HashMap<>();

    public Interactable get(ItemKey key) {
        return customItems.get(key);
    }

    public void register(ItemKey key, Interactable interactable) {
        customItems.put(key, interactable);
    }
}
