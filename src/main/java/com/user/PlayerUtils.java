package com.user;

import org.bukkit.entity.Player;

public class PlayerUtils {
    public static void sendMessage(Player player, String message) {
        player.sendMessage(message);
    }

    public static boolean hasPermission(Player player, String permission) {
        return player.hasPermission(permission);
    }
}