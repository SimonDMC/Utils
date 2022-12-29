package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class CountCommand implements SuperCommand {
    public String getLabel() {
        return "count";
    }

    public String getUsage() {
        return "/count <amount> [player]";
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

        if (!PlayerUtil.isHoldingItem(p)) return;

        if (!DataType.isIntegerWithinBounds(args[0], 1, 127)) {
            p.sendMessage("§cEnter a number between 1 and 127.");
            return;
        }

        p.getInventory().getItemInMainHand().setAmount(Integer.parseInt(args[0]));
        String plural = (Integer.parseInt(args[0]) == 1 ? "." : "s.");
        p.sendMessage(ChatColor.GREEN + "You are now holding " + args[0] + " item" + plural);
        PlayerUtil.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
    }
}
