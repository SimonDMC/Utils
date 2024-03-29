package com.simondmc.utils.savestate;

import com.simondmc.utils.config.Config;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.List;

public class SavestateLoader {

    private String label;

    public SavestateLoader(String label) {
        this.label = label;
    }

    public Savestate toSavestate() {
        // non-existent savestate check
        if (Config.get(label, "savestates") == null) {
            return null;
        }

        Location location = (Location) getValue(label, "location");
        Vector velocity = (Vector) getValue(label, "velocity");
        ItemStack[] inventory;
        if (getValue(label, "inventory") instanceof List) {
            inventory = ((List<ItemStack>) getValue(label, "inventory")).toArray(new ItemStack[0]);
        } else {
            inventory = (ItemStack[]) getValue(label, "inventory");
        }
        double health = (double) getValue(label, "health");
        int food = (int) getValue(label, "food");
        float saturation;
        if (getValue(label, "saturation") instanceof Double) {
            saturation = ((Double) getValue(label, "saturation")).floatValue();
        } else {
            saturation = (float) getValue(label, "saturation");
        }
        GameMode gamemode = GameMode.valueOf((String) getValue(label, "gamemode"));

        return new Savestate(
                label,
                location,
                velocity,
                inventory,
                health,
                food,
                saturation,
                gamemode
        );
    }

    private Object getValue(String path, String key) {
        return Config.get(path + "." + key, "savestates");
    }
}
