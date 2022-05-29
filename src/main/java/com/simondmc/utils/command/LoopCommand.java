package com.simondmc.utils.command;

import com.simondmc.utils.Utils;
import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.Misc;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LoopCommand implements SuperCommand {
    public String getLabel() {
        return "loop";
    }

    public String getUsage() {
        return "/loop <amount> <delay> <command>";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 3;
    }

    public void runCommand(Player p, String[] args) {

        if (!DataType.isIntegerWithinBounds(args[0], 1, Integer.MAX_VALUE)) {
            p.sendMessage("§cEnter amount");
            return;
        }

        if (!DataType.isIntegerWithinBounds(args[1], 1, Integer.MAX_VALUE)) {
            p.sendMessage("§cEnter delay");
            return;
        }

        String command = Misc.formatCommand(args, 2);

        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.chat(command);
                }
            }.runTaskLater(Utils.plugin, i * Integer.parseInt(args[1]));
        }
    }
}
