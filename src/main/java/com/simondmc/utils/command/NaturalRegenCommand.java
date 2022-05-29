package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.command.template.IToggleCommand;
import org.bukkit.entity.Player;

public class NaturalRegenCommand implements SuperCommand, IToggleCommand {
    public String getLabel() {
        return "naturalregen";
    }

    public String getUsage() {
        return "/naturalregen [player]";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 0;
    }

    public String getToggleDisplayName() {
        return "Natural regeneration";
    }

    public Boolean isInverted() {
        return true;
    }

    public Boolean saysDefaultInsteadOfOff() {
        return true;
    }

    public void runCommand(Player p, String[] args) {

    }
}
