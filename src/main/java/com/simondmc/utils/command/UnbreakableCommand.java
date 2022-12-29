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

    public void runCommand(Player p, String[] args) {
        if (args.length > 0) p = PlayerUtil.validateCommandTarget(args[0], p);
        if (p == null) return;

        if (!PlayerUtil.isHoldingItem(p)) return;

        ItemMeta m = p.getInventory().getItemInMainHand().getItemMeta();
        if (m.isUnbreakable()) {
            m.setUnbreakable(false);
            p.sendMessage(ChatColor.GREEN + "Your item is now breakable!");
        } else {
            m.setUnbreakable(true);
            p.sendMessage(ChatColor.GREEN + "Your item is now unbreakable!");
        }
        PlayerUtil.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
        p.getInventory().getItemInMainHand().setItemMeta(m);
    }
}
