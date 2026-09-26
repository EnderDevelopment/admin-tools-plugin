package com.user;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor {
    private final AdminCommandsPlugin plugin;

    public AdminCommands(AdminCommandsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("admincommands.use")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return true;
        }

        switch (command.getName().toLowerCase()) {
            case "fly":
                handleFlyCommand(player, args);
                break;
            case "heal":
                handleHealCommand(player, args);
                break;
            case "feed":
                handleFeedCommand(player, args);
                break;
            case "gamemode":
                handleGameModeCommand(player, args);
                break;
            case "teleport":
                handleTeleportCommand(player, args);
                break;
        }

        return true;
    }

    private void handleFlyCommand(Player player, String[] args) {
        Player target = args.length > 0 ? Bukkit.getPlayer(args[0]) : player;
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Player not found.");
            return;
        }

        target.setAllowFlight(!target.getAllowFlight());
        target.sendMessage(ChatColor.GREEN + "Fly mode " + (target.getAllowFlight() ? "enabled" : "disabled") + "!");
        if (!player.equals(target)) {
            player.sendMessage(ChatColor.GREEN + "Fly mode " + (target.getAllowFlight() ? "enabled" : "disabled") + " for " + target.getName() + "!");
        }
    }

    private void handleHealCommand(Player player, String[] args) {
        Player target = args.length > 0 ? Bukkit.getPlayer(args[0]) : player;
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Player not found.");
            return;
        }

        target.setHealth(target.getMaxHealth());
        target.sendMessage(ChatColor.GREEN + "You have been healed!");
        if (!player.equals(target)) {
            player.sendMessage(ChatColor.GREEN + "Healed " + target.getName() + "!");
        }
    }

    private void handleFeedCommand(Player player, String[] args) {
        Player target = args.length > 0 ? Bukkit.getPlayer(args[0]) : player;
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Player not found.");
            return;
        }

        target.setFoodLevel(20);
        target.setSaturation(20);
        target.sendMessage(ChatColor.GREEN + "You have been fed!");
        if (!player.equals(target)) {
            player.sendMessage(ChatColor.GREEN + "Fed " + target.getName() + "!");
        }
    }

    private void handleGameModeCommand(Player player, String[] args) {
        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Usage: /gamemode <mode> [player]");
            return;
        }

        GameMode gameMode;
        try {
            gameMode = GameMode.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            player.sendMessage(ChatColor.RED + "Invalid game mode. Use: SURVIVAL, CREATIVE, ADVENTURE, SPECTATOR");
            return;
        }

        Player target = args.length > 1 ? Bukkit.getPlayer(args[1]) : player;
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Player not found.");
            return;
        }

        target.setGameMode(gameMode);
        target.sendMessage(ChatColor.GREEN + "Your game mode has been changed to " + gameMode.name() + "!");
        if (!player.equals(target)) {
            player.sendMessage(ChatColor.GREEN + "Changed " + target.getName() + "'s game mode to " + gameMode.name() + "!");
        }
    }

    private void handleTeleportCommand(Player player, String[] args) {
        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Usage: /teleport <player> [target] or /teleport <x> <y> <z>");
            return;
        }

        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(ChatColor.RED + "Player not found.");
                return;
            }
            player.teleport(target.getLocation());
            player.sendMessage(ChatColor.GREEN + "Teleported to " + target.getName() + "!");
        } else if (args.length == 3) {
            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);
                double z = Double.parseDouble(args[2]);
                player.teleport(new org.bukkit.Location(player.getWorld(), x, y, z));
                player.sendMessage(ChatColor.GREEN + "Teleported to coordinates!");
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Invalid coordinates. Please use numbers.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Usage: /teleport <player> [target] or /teleport <x> <y> <z>");
        }
    }
}