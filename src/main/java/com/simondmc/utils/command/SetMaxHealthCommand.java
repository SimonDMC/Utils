package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SetMaxHealthCommand implements SuperCommand {
    public String getLabel() {
        return "setmaxhealth";
    }

    public String getUsage() {
        return "/setmaxhealth <health> [player]";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 1;
    }

    public void runCommand(Player p, String[] args) {
        if (args.length > 1) p = PlayerUtil.validateCommandTarget(args[1], p);
        if (p == null) return;

        if (!DataType.isIntegerWithinBounds(args[0], 1, Integer.MAX_VALUE)) {
            p.sendMessage("§cEnter a number");
            return;
        }

        p.setMaxHealth(Integer.parseInt(args[0]));
        PlayerUtil.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
    }
}
