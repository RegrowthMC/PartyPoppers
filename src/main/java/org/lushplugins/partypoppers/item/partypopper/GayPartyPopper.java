package org.lushplugins.partypoppers.item.partypopper;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

public class GayPartyPopper extends PartyPopper {
    private static final FireworkEffect GAY_CONFETTI = FireworkEffect.builder()
        .with(FireworkEffect.Type.BURST)
        .withColor(
            Color.fromRGB(1, 140, 112), // teal
            Color.fromRGB(31, 207, 172), // turquoise
            Color.fromRGB(154, 233, 195), // mint
            Color.fromRGB(255, 255, 255), // white
            Color.fromRGB(123, 173, 229), // light blue
            Color.fromRGB(79, 71, 203), // blurple
            Color.fromRGB(62, 20, 123) // deep purple
        )
        .build();

    @Override
    public FireworkEffect getConfetti() {
        return GAY_CONFETTI;
    }
}
