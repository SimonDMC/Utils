package com.simondmc.utils.command;

import com.simondmc.utils.command.template.IToggleCommand;
import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import org.bukkit.entity.Player;

public class KeepInventoryCommand implements SuperCommand, IToggleCommand {
    public String getLabel() {
        return "keepinventory";
    }

    public String getUsage() {
        return "/keepinventory [player]";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 0;
    }

    public String getToggleDisplayName() {
        return "Keep inventory";
    }

    public Boolean isInverted() {
        return false;
    }

    public Boolean saysDefaultInsteadOfOff() {
        return true;
    }

    public void runCommand(Player p, String[] args) {

    }
}
