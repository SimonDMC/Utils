package com.simondmc.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlayerUtil {

    public static Player validateCommandTarget(String name, Player p) {
        Player secondPlayer;
        try {
            secondPlayer = Bukkit.getServer().getPlayer(name);
        } catch (Exception e) {
            secondPlayer = null;
        }
        if (secondPlayer == null) {
            p.sendMessage("§cThat player doesn't exist!");
        }
        return secondPlayer;
    }

    public static void playSound(Player p, Sound sound) {
        p.playSound(p.getLocation(), sound, 1, 1);
    }

    public static boolean isHoldingItem(Player p) {
        if (p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            p.sendMessage(ChatColor.RED + "You aren't holding an item!");
            return false;
        }
        return true;
    }
}
