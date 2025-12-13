package org.lushplugins.partypoppers.item.partypopper;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;
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
        World world = player.getWorld();

        world.spawn(player.getLocation(), Firework.class, (firework) -> {
            firework.setSilent(true);
            firework.setVelocity(player.getLocation().getDirection().normalize());

            FireworkMeta fireworkMeta = firework.getFireworkMeta();
            fireworkMeta.addEffect(this.getConfetti());
            firework.setFireworkMeta(fireworkMeta);

            firework.detonate();
        });
    }

    public FireworkEffect getConfetti() {
        return CONFETTI;
    }
}
