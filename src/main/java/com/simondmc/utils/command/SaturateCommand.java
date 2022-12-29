package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.entity.Player;

public class SaturateCommand implements SuperCommand {
    public String getLabel() {
        return "saturate";
    }

    public String getUsage() {
        return "/saturate [player]";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public void runCommand(Player p, String[] args) {
        if (args.length > 0) p = PlayerUtil.validateCommandTarget(args[0], p);
        if (p == null) return;

        p.setFoodLevel(20);
        p.setSaturation(20);
    }
}
