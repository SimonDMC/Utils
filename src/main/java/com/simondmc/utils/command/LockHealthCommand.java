package com.simondmc.utils.command;

import com.simondmc.utils.command.template.IToggleCommand;
import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import org.bukkit.entity.Player;

public class LockHealthCommand implements SuperCommand, IToggleCommand {

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
}
