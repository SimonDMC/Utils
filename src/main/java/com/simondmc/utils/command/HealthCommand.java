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

        Player target = PlayerUtil.validateSecondPlayer(args[0], p);
        if (target == null) {
            p.sendMessage("§cThat player doesn't exist!");
            return;
        }

        p.sendMessage("§a" + target.getName() + " §ehas §c" + Math.round(target.getHealth()) + " HP");
    }
}
