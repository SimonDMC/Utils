package com.simondmc.utils.savestate;

import com.simondmc.utils.config.Config;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Savestate {
    private final String label;
    private final Location location;
    private final Vector velocity;
    private final ItemStack[] inventory;
    private final double health;
    private final int food;
    private final float saturation;
    private final GameMode gamemode;

    public Savestate(String label, Location location, Vector velocity, ItemStack[] inventory, double health, int food, float saturation, GameMode gamemode) {
        this.label = label;
        this.location = location;
        this.velocity = velocity;
        this.inventory = inventory;
        this.health = health;
        this.food = food;
        this.saturation = saturation;
        this.gamemode = gamemode;
    }

    public void save() {
        saveValue("location", location);
        saveValue("velocity", velocity);
        saveValue("inventory", inventory);
        saveValue("health", health);
        saveValue("food", food);
        saveValue("saturation", saturation);
        saveValue("gamemode", gamemode);
        Config.save("savestates");
    }

    public void load(Player p) {
        p.teleport(location);
        p.setVelocity(velocity);
        p.getInventory().setContents(inventory);
        p.setHealth(health);
        p.setFoodLevel(food);
        p.setSaturation(saturation);
        p.setGameMode(gamemode);
    }

    public void delete() {
        Config.set(label, null, "savestates");
        Config.save("savestates");
    }

    private void saveValue(String path, Object value) {
        Config.set(label + "." + path, value, "savestates");
    }
}
