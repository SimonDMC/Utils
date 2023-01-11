package com.simondmc.utils.command;

import com.simondmc.utils.Utils;
import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.StringUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

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

    public static List<BukkitTask> loops = new ArrayList<>();

    public void runCommand(Player p, String[] args) {

        if (!DataType.isIntegerWithinBounds(args[0], 1, Integer.MAX_VALUE)) {
            p.sendMessage("§cUsage: " + getUsage());
            return;
        }

        if (!DataType.isIntegerWithinBounds(args[1], 1, Integer.MAX_VALUE)) {
            p.sendMessage("§cUsage: " + getUsage());
            return;
        }

        String command = StringUtil.formatCommand(args, 2);

        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            loops.add(new BukkitRunnable() {
                @Override
                public void run() {
                    p.chat(command);
                }
            }.runTaskLater(Utils.plugin, (long) i * Integer.parseInt(args[1])));
        }
    }
}
