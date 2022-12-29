package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class SetHealthCommand implements SuperCommand {
    public String getLabel() {
        return "sethealth";
    }

    public String getUsage() {
        return "/sethealth <health> [player]";
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

        int maxHealth = (int) p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        if (!DataType.isIntegerWithinBounds(args[0], 1, maxHealth)) {
            p.sendMessage("§cEnter a number between 1 and " + Math.round(maxHealth) + ".");
            return;
        }

        p.setHealth(Integer.parseInt(args[0]));
        PlayerUtil.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
    }
}
