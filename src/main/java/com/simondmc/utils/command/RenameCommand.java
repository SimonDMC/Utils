package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.DataType;
import com.simondmc.utils.util.PlayerUtil;
import com.simondmc.utils.util.StringUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements SuperCommand {
    public int getMinimumArgs() {
        return 1;
    }

    public String getLabel() {
        return "rename";
    }

    public String getUsage() {
        return "/rename <name>";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public void runCommand(Player p, String[] args) {
        String itemName = "§f" + StringUtil.joinStringArray(args, " ", 0);
        itemName = StringUtil.translateColorCode(itemName);

        if (!PlayerUtil.isHoldingItem(p)) return;

        ItemMeta m = p.getInventory().getItemInMainHand().getItemMeta();
        m.setDisplayName(itemName);
        p.getInventory().getItemInMainHand().setItemMeta(m);
        PlayerUtil.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
        p.sendMessage("§aRenamed item to " + itemName);
    }
}
