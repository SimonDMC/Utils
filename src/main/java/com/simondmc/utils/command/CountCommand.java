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

        Player secondPlayer = null;
        if (args.length > 1) secondPlayer = PlayerUtil.validateSecondPlayer(args[1], p);
        Player target = (secondPlayer == null ? p : secondPlayer);

        if (target.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            p.sendMessage(ChatColor.RED + "You aren't holding an item!");
            return;
        }

        if (!DataType.isIntegerWithinBounds(args[0], 1, 127)) {
            p.sendMessage("§cEnter a number between 1 and 127.");
            return;
        }

        target.getInventory().getItemInMainHand().setAmount(Integer.parseInt(args[0]));
        String plural = (Integer.parseInt(args[0]) == 1 ? "." : "s.");
        target.sendMessage(ChatColor.GREEN + "You are now holding " + args[0] + " item" + plural);
        PlayerUtil.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
    }
}
