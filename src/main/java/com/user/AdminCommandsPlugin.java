package com.user;

import org.bukkit.plugin.java.JavaPlugin;

public class AdminCommandsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("AdminCommandsPlugin has been enabled!");
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);
        getCommand("fly").setExecutor(new AdminCommands(this));
        getCommand("heal").setExecutor(new AdminCommands(this));
        getCommand("feed").setExecutor(new AdminCommands(this));
        getCommand("gamemode").setExecutor(new AdminCommands(this));
        getCommand("teleport").setExecutor(new AdminCommands(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("AdminCommandsPlugin has been disabled!");
    }
}