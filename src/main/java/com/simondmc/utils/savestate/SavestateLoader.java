package com.simondmc.utils.savestate;

import com.simondmc.utils.config.Config;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SavestateLoader {

    private String label;

    public SavestateLoader(String label) {
        this.label = label;
    }

    public Savestate toSavestate() {
        try {
            return new Savestate(
                    label,
                    (Location) getValue(label, "location"),
                    (Vector) getValue(label, "velocity"),
                    (ItemStack[]) getValue(label, "inventory"),
                    (double) getValue(label, "health"),
                    (int) getValue(label, "food"),
                    (float) getValue(label, "saturation")
            );
        } catch (Exception e) {
            return null;
        }
    }

    private Object getValue(String path, String key) {
        return Config.get(path + "." + key, "savestates");
    }
}
