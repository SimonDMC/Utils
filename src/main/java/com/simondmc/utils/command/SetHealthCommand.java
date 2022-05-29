package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.Sound;
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

        Player secondPlayer = null;
        if (args.length > 1) secondPlayer = PlayerUtil.validateSecondPlayer(args[1], p);
        Player target = (secondPlayer == null ? p : secondPlayer);

        if (!DataType.isIntegerWithinBounds(args[0], 1, (int) target.getMaxHealth())) {
            p.sendMessage("§cEnter a number between 1 and " + Math.round(target.getMaxHealth()));
            return;
        }

        target.setHealth(Integer.parseInt(args[0]));
        PlayerUtil.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
    }
}
