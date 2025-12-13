package org.lushplugins.partypoppers.item;

import org.bukkit.event.player.PlayerInteractEvent;

public interface Interactable {

    void onInteract(PlayerInteractEvent event);
}
