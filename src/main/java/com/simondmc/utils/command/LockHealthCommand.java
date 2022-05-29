package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.command.template.ToggleCommand;
import org.bukkit.entity.Player;

public class LockHealthCommand implements SuperCommand, ToggleCommand {
    public int getMinimumArgs() {
        return 0;
    }

    public String getLabel() {
        return "lockhealth";
    }

    public String getUsage() {
        return "/lockhealth [player]";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public String getToggleDisplayName() {
        return "Lock health";
    }

    public Boolean isInverted() {
        return false;
    }

    public Boolean saysDefaultInsteadOfOff() {
        return false;
    }

    public void runCommand(Player p, String[] args) {

    }
}
