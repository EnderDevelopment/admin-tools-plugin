package com.user;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    private final AdminCommandsPlugin plugin;

    public CommandListener(AdminCommandsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().split(" ")[0].toLowerCase();
        if (command.equals("/fly") || command.equals("/heal") || command.equals("/feed") || command.equals("/gamemode") || command.equals("/teleport")) {
            if (!event.getPlayer().hasPermission("admincommands.use")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("You don't have permission to use this command.");
            }
        }
    }
}