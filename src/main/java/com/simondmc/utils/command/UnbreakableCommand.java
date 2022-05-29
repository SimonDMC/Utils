package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class UnbreakableCommand implements SuperCommand {
    public String getLabel() {
        return "unbreakable";
    }

    public String getUsage() {
        return "/unbreakable <player>";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 0;
    }

    public void runCommand(Player p, String[] args) {

        Player secondPlayer = null;
        if (args.length > 0) secondPlayer = PlayerUtil.validateSecondPlayer(args[0], p);
        Player target = (secondPlayer == null ? p : secondPlayer);

        if (target.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            p.sendMessage(ChatColor.RED + "You aren't holding an item!");
            return;
        }

        ItemMeta m = target.getInventory().getItemInMainHand().getItemMeta();
        if (m.isUnbreakable()) {
            m.setUnbreakable(false);
            target.sendMessage(ChatColor.GREEN + "Your item is now breakable!");
        } else {
            m.setUnbreakable(true);
            target.sendMessage(ChatColor.GREEN + "Your item is now unbreakable!");
        }
        PlayerUtil.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
        target.getInventory().getItemInMainHand().setItemMeta(m);
    }
}
