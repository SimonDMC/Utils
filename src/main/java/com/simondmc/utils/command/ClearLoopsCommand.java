package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.entity.Player;

public class ClearLoopsCommand implements SuperCommand {
    public String getLabel() {
        return "clearloops";
    }

    public String getUsage() {
        return "/clearloops";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public void runCommand(Player p, String[] args) {
        if (LoopCommand.loops.size() == 0) {
            p.sendMessage("§cThere are no loops to clear.");
            return;
        }
        LoopCommand.loops.forEach(BukkitTask::cancel);
        LoopCommand.loops.clear();
        p.sendMessage("§aCleared all loops.");
    }
}
