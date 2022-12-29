package com.simondmc.utils.command;

import com.simondmc.utils.command.template.IToggleCommand;
import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import org.bukkit.entity.Player;

public class LockHungerCommand implements SuperCommand, IToggleCommand {

    public String getLabel() {
        return "lockhunger";
    }

    public String getUsage() {
        return "/lockhunger [player]";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public String getToggleDisplayName() {
        return "Lock hunger";
    }
}
