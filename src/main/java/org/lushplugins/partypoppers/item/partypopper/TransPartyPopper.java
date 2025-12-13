package org.lushplugins.partypoppers.item.partypopper;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

public class TransPartyPopper extends PartyPopper {
    private static final FireworkEffect TRANS_CONFETTI = FireworkEffect.builder()
        .with(FireworkEffect.Type.BURST)
        .withColor(
            Color.fromRGB(136, 239, 255), // blue
            Color.fromRGB(254, 166, 226), // pink
            Color.fromRGB(255, 255, 255) // white
        )
        .build();

    @Override
    public FireworkEffect getConfetti() {
        return TRANS_CONFETTI;
    }
}
