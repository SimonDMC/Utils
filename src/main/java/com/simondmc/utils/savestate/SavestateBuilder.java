package com.simondmc.utils.savestate;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SavestateBuilder {
    private String label = "";
    private Location location = null;
    private Vector velocity = null;
    private ItemStack[] inventory = null;
    private double health = -1;
    private int food = -1;
    private float saturation = -1;
    private GameMode gamemode = null;

    public SavestateBuilder() {}

    public Savestate build() {
        return new Savestate(label, location, velocity, inventory, health, food, saturation, gamemode);
    }

    public SavestateBuilder label(String label) {
        this.label = label;
        return this;
    }

    public SavestateBuilder location(Location location) {
        this.location = location;
        return this;
    }

    public SavestateBuilder velocity(Vector velocity) {
        this.velocity = velocity;
        return this;
    }

    public SavestateBuilder inventory(ItemStack[] inventory) {
        this.inventory = inventory;
        return this;
    }

    public SavestateBuilder health(double health) {
        this.health = health;
        return this;
    }

    public SavestateBuilder food(int food) {
        this.food = food;
        return this;
    }

    public SavestateBuilder saturation(float saturation) {
        this.saturation = saturation;
        return this;
    }

    public SavestateBuilder gamemode(GameMode gamemode) {
        this.gamemode = gamemode;
        return this;
    }
}
