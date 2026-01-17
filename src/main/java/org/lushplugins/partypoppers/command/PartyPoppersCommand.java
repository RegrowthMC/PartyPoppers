package org.lushplugins.partypoppers.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.lushplugins.partypoppers.PartyPoppers;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command("partypoppers")
@SuppressWarnings("unused")
public class PartyPoppersCommand {

    @Subcommand("pause")
    @CommandPermission("partypoppers.pause")
    public void pause() {
        PartyPoppers.getInstance().setPaused(true);
        Bukkit.broadcast(Component.text("Party items have been paused", TextColor.fromHexString("#ff6969")));
    }

    @Subcommand("unpause")
    @CommandPermission("partypoppers.pause")
    public void unpause() {
        PartyPoppers.getInstance().setPaused(false);
        Bukkit.broadcast(Component.text("Party items are no longer paused!", TextColor.fromHexString("#ff9efc")));
    }
}
