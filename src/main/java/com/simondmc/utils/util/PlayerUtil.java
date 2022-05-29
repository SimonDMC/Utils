package com.simondmc.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlayerUtil {

    public static Player validateSecondPlayer(String name, Player p) {
        Player secondPlayer;
        try {
            secondPlayer = Bukkit.getServer().getPlayer(name);
        } catch (Exception e) {
            p.sendMessage("§cThat player doesn't exist!");
            secondPlayer = null;
        }
        return secondPlayer;
    }

    public static void playSound(Player p, Sound sound) {
        p.playSound(p.getLocation(), sound, 1, 1);
    }

    public static void playSound(Player p, Sound sound, float volume, float pitch) {
        p.playSound(p.getLocation(), sound, volume, pitch);
    }
}
