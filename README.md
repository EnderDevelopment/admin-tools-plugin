# Admin Tools Plugin

Essential admin commands for Minecraft servers

## Features

- Toggle fly mode for players
- Heal and feed players
- Change player gamemodes
- Teleport players or to coordinates

## Requirements

- Spigot/Paper server (1.19 or later)
- Java 8 or higher

## Installation

1. Download the latest release from the [Releases](https://github.com/EnderDevelopment/admin-tools-plugin/releases) page
2. Place the JAR file in your server's `plugins` folder
3. Restart your server

## Usage

### Commands

| Command | Description | Usage |
|---------|-------------|-------|
| /fly | Toggle fly mode | /fly [player] |
| /heal | Heal a player | /heal [player] |
| /feed | Feed a player | /feed [player] |
| /gamemode | Change player's game mode | /gamemode <mode> [player] |
| /teleport | Teleport to a player or coordinates | /teleport <player> [target] or /teleport <x> <y> <z> |

### Permissions

| Permission | Description |
|------------|-------------|
| admincommands.use | Allows use of all admin commands |

## Configuration

The plugin includes a configuration file (`config.yml`) where you can customize messages and settings. After making changes, use `/reload` to apply them.

---

## Generated with EnderDevelopment

This plugin was generated in minutes with [EnderDevelopment](https://enderdevelopment.com) — the AI platform that turns your ideas into working Minecraft plugins, Discord bots and FiveM scripts.

**Want your own?** [Generate this project on EnderDevelopment](https://dash.enderdevelopment.com?utm_source=github&utm_medium=readme&utm_campaign=admin-tools-plugin&utm_content=bottom) — describe it in one sentence and get the full source code.