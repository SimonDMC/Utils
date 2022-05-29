package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.StringUtil;
import org.bukkit.entity.Player;

public class SimulateCommand implements SuperCommand {
    public String getLabel() {
        return "simulate";
    }

    public String getUsage() {
        return "/simulate <command>";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 1;
    }

    public void runCommand(Player p, String[] args) {

        String message = DataType.joinStringArray(args, " ", 0);
        message = StringUtil.translateColorCode(message);

        p.sendMessage(message);
    }
}
