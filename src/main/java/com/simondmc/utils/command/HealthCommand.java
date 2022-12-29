package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.entity.Player;

public class HealthCommand implements SuperCommand {
    public String getLabel() {
        return "health";
    }

    public String getUsage() {
        return "/health <player>";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 1;
    }

    public void runCommand(Player p, String[] args) {
        p = PlayerUtil.validateCommandTarget(args[0], p);
        if (p == null) return;

        p.sendMessage("§a" + p.getName() + " §ehas §c" + Math.round(p.getHealth()) + " HP" + "§e.");
    }
}
