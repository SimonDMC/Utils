package com.simondmc.utils.command;

import com.simondmc.utils.command.template.IToggleCommand;
import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import org.bukkit.entity.Player;

public class PreventDeathCommand implements SuperCommand, IToggleCommand {
    public String getLabel() {
        return "preventdeath";
    }

    public String getUsage() {
        return "/preventdeath [player]";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 0;
    }

    public String getToggleDisplayName() {
        return "Prevent death";
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
