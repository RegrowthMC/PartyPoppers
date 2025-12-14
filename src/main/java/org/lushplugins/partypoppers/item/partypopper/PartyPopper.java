package org.lushplugins.partypoppers.item.partypopper;

import net.kyori.adventure.key.Key;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.lushplugins.partypoppers.PartyPoppers;
import org.lushplugins.partypoppers.item.Interactable;

public class PartyPopper implements Interactable {
    private static final FireworkEffect CONFETTI = FireworkEffect.builder()
        .with(FireworkEffect.Type.BURST)
        .withColor(
            Color.fromRGB(136, 239, 255), // blue
            Color.fromRGB(255, 171, 170), // red
            Color.fromRGB(211, 255, 170), // green
            Color.fromRGB(226, 170, 255), // purple
            Color.fromRGB(255, 246, 170) // yellow
        )
        .build();

    @Override
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (player.hasCooldown(item)) {
            return;
        }

        player.getWorld().spawn(player.getLocation().clone().add(0, 1, 0), Firework.class, (firework) -> {
            firework.setSilent(true);
            firework.setVelocity(player.getLocation().getDirection().normalize());

            FireworkMeta fireworkMeta = firework.getFireworkMeta();
            fireworkMeta.addEffect(this.getConfetti());
            firework.setFireworkMeta(fireworkMeta);

            firework.setMetadata("partypoppers:no_damage", new FixedMetadataValue(PartyPoppers.getInstance(), null));
            firework.setPersistent(false);
            firework.detonate();
        });

        player.setCooldown(item, 20);
        player.setCooldown(Key.key("partypopper:popper"), 20);
    }

    public FireworkEffect getConfetti() {
        return CONFETTI;
    }
}
