package com.simondmc.utils.command.template;

import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public interface SuperCommand {
    default int getMinimumArgs() { return 0; }
    String getLabel();
    default String[] getAliases() {
        return new String[]{};
    }
    String getUsage();
    Permission getRequiredPermission();
    default TabCompleter getTabCompleter() {
        return null;
    }
    default void runCommand(Player p, String[] args) {}
}
