package com.user;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private final AdminCommandsPlugin plugin;
    private FileConfiguration config;

    public ConfigManager(AdminCommandsPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        plugin.saveDefaultConfig();
    }

    public String getMessage(String path) {
        return config.getString(path, "Message not found");
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        config = plugin.getConfig();
    }
}