package org.lushplugins.partypoppers.command;

import org.lushplugins.partypoppers.PartyPoppers;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command("partypoppers")
@SuppressWarnings("unused")
public class PartyPoppersCommand {

    @Subcommand("pause")
    @CommandPermission("partypoppers.pause")
    public String pause() {
        PartyPoppers.getInstance().setPaused(true);
        return "PartyPoppers have been paused";
    }

    @Subcommand("unpause")
    @CommandPermission("partypoppers.pause")
    public String unpause() {
        PartyPoppers.getInstance().setPaused(false);
        return "PartyPoppers are no longer paused";
    }
}
