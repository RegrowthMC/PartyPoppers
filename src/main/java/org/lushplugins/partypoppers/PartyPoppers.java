package org.lushplugins.partypoppers;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.lushplugins.partypoppers.item.CustomItemRegistry;
import org.lushplugins.partypoppers.item.Interactable;
import org.lushplugins.partypoppers.item.ItemKey;
import org.lushplugins.partypoppers.item.partypopper.*;

public final class PartyPoppers extends JavaPlugin implements Listener {
    private CustomItemRegistry customItemRegistry;

    @Override
    public void onEnable() {
        this.customItemRegistry = new CustomItemRegistry();
        customItemRegistry.register(new ItemKey(Material.PAPER, 1000), new PartyPopper());
        customItemRegistry.register(new ItemKey(Material.PAPER, 1001), new LesbianPartyPopper());
        customItemRegistry.register(new ItemKey(Material.PAPER, 1002), new GayPartyPopper());
        customItemRegistry.register(new ItemKey(Material.PAPER, 1003), new BisexualPartyPopper());
        customItemRegistry.register(new ItemKey(Material.PAPER, 1004), new TransPartyPopper());

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null || !event.getAction().isRightClick()) {
            return;
        }

        ItemKey key = ItemKey.from(item);
        Interactable interactable = customItemRegistry.get(key);
        if (interactable != null) {
            interactable.onInteract(event);
        }
    }
}
