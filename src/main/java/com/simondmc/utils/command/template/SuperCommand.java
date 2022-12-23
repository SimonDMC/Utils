package com.simondmc.utils.command.template;

import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public interface SuperCommand {
    int getMinimumArgs();
    String getLabel();
    default String[] getAliases() {
        return new String[]{};
    }
    String getUsage();
    Permission getRequiredPermission();
    default TabCompleter getTabCompleter() {
        return null;
    }
    void runCommand(Player p, String[] args);
}
