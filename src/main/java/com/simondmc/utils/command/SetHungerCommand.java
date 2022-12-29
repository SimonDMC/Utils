package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SetHungerCommand implements SuperCommand {
    public String getLabel() {
        return "sethunger";
    }

    public String getUsage() {
        return "/sethunger <hunger> [player]";
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

        if (!DataType.isIntegerWithinBounds(args[0], 1, 20)) {
            p.sendMessage("§cEnter a number between 1 and 20");
            return;
        }

        p.setFoodLevel(Integer.parseInt(args[0]));
        PlayerUtil.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
    }
}
