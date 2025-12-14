package org.lushplugins.partypoppers.item.partypopper;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

public class LesbianPartyPopper extends PartyPopper {
    private static final FireworkEffect LESBIAN_CONFETTI = FireworkEffect.builder()
        .with(FireworkEffect.Type.BURST)
        .withColor(
            Color.fromRGB(198, 62, 13), // orange
            Color.fromRGB(230, 132, 77), // pastel orange
            Color.fromRGB(255, 255, 255), // white
            Color.fromRGB(173, 80, 136), // pink
            Color.fromRGB(138, 1, 109) // maroon
        )
        .build();

    @Override
    public FireworkEffect getConfetti() {
        return LESBIAN_CONFETTI;
    }
}
