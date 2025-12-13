package org.lushplugins.partypoppers;

import org.bukkit.plugin.java.JavaPlugin;

public final class PartyPoppers extends JavaPlugin {
    private static PartyPoppers plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        // Enable implementation
    }

    @Override
    public void onDisable() {
        // Disable implementation
    }

    public static PartyPoppers getInstance() {
        return plugin;
    }
}
