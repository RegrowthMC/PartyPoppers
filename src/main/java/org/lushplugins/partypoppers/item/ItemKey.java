package org.lushplugins.partypoppers.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public record ItemKey(Material material, Integer customModelData) {

    public static ItemKey from(ItemStack item) {
        Material material = item.getType();

        Integer customModelData = null;
        if (item.hasItemMeta()) {
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta.hasCustomModelData()) {
                customModelData = itemMeta.getCustomModelData();
            }
        }

        return new ItemKey(material, customModelData);
    }
}
