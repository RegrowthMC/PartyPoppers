package org.lushplugins.partypoppers.item.partypopper;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

public class BisexualPartyPopper extends PartyPopper {
    private static final FireworkEffect BISEXUAL_CONFETTI = FireworkEffect.builder()
        .with(FireworkEffect.Type.BURST)
        .withColor(
            Color.fromRGB(251, 183, 224), // pink
            Color.fromRGB(213, 170, 249), // purple
            Color.fromRGB(170, 189, 255) // blue
        )
        .build();

    @Override
    public FireworkEffect getConfetti() {
        return BISEXUAL_CONFETTI;
    }
}
