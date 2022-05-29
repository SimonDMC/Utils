package com.simondmc.utils.command;

import com.simondmc.utils.Utils;
import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.StringUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DelayCommand implements SuperCommand {
    public String getLabel() {
        return "delay";
    }

    public String getUsage() {
        return "/delay <delay> <command>";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 2;
    }

    public void runCommand(Player p, String[] args) {

        if (!DataType.isIntegerWithinBounds(args[0], 1, Integer.MAX_VALUE)) {
            p.sendMessage("§cEnter amount");
            return;
        }

        String command = StringUtil.formatCommand(args, 1);

        new BukkitRunnable() {
            @Override
            public void run() {
                p.chat(command);
            }
        }.runTaskLater(Utils.plugin, Integer.parseInt(args[0]));
    }
}
