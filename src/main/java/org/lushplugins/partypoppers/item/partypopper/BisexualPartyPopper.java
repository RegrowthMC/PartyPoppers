package org.lushplugins.partypoppers.item.partypopper;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

public class BisexualPartyPopper extends PartyPopper {
    private static final FireworkEffect BISEXUAL_CONFETTI = FireworkEffect.builder()
        .with(FireworkEffect.Type.BURST)
        .withColor(
            Color.fromRGB(153, 0, 83), // pink
            Color.fromRGB(114, 75, 154), // purple
            Color.fromRGB(0, 54, 164) // blue
        )
        .build();

    @Override
    public FireworkEffect getConfetti() {
        return BISEXUAL_CONFETTI;
    }
}
