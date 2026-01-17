package org.lushplugins.partypoppers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.lushplugins.partypoppers.command.PartyPoppersCommand;
import org.lushplugins.partypoppers.item.CustomItemRegistry;
import org.lushplugins.partypoppers.item.Interactable;
import org.lushplugins.partypoppers.item.ItemKey;
import org.lushplugins.partypoppers.item.partypopper.*;
import revxrsal.commands.bukkit.BukkitLamp;

public final class PartyPoppers extends JavaPlugin implements Listener {
    private static PartyPoppers plugin;

    private CustomItemRegistry customItemRegistry;
    private boolean paused = false;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        this.customItemRegistry = new CustomItemRegistry();
        customItemRegistry.register(new ItemKey(Material.PAPER, 100), new PartyPopper());
        customItemRegistry.register(new ItemKey(Material.PAPER, 101), new LesbianPartyPopper());
        customItemRegistry.register(new ItemKey(Material.PAPER, 102), new GayPartyPopper());
        customItemRegistry.register(new ItemKey(Material.PAPER, 103), new BisexualPartyPopper());
        customItemRegistry.register(new ItemKey(Material.PAPER, 104), new TransPartyPopper());

        getServer().getPluginManager().registerEvents(this, this);

        BukkitLamp.builder(this).build()
            .register(new PartyPoppersCommand());
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
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
            if (paused) {
                event.getPlayer().sendMessage(Component.text("Party items are currently paused", TextColor.fromHexString("#ff6969")));
                return;
            }

            interactable.onInteract(event);
        }
    }

    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager().hasMetadata("partypoppers:no_damage")) {
            event.setCancelled(true);
        }
    }

    public static PartyPoppers getInstance() {
        return plugin;
    }
}
