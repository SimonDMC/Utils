package com.simondmc.utils.command.template;

import org.bukkit.entity.Player;

public interface SuperCommand {
    int getMinimumArgs();
    String getLabel();
    String getUsage();
    Permission getRequiredPermission();
    void runCommand(Player p, String[] args);
}
