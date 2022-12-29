package com.simondmc.utils.savestate;

import com.simondmc.utils.config.Config;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SavestateOverwrite {

    private static List<SavestateOverwrite> activeOverwrites = new ArrayList<>();

    private String name;
    private long timestamp;
    private Player player;

    public SavestateOverwrite(String name, Player player) {
        this.name = name;
        this.timestamp = System.currentTimeMillis();
        this.player = player;
    }

    private String getName() {
        return name;
    }

    private long getTimestamp() {
        return timestamp;
    }

    private Player getPlayer() {
        return player;
    }

    public boolean isActive() {
        int overwriteExpire = (int) Config.getOrDefault("overwrite-expire", 10000, "savestates");
        // keep in external list to prevent CurrentModificationException
        List<SavestateOverwrite> toRemove = new ArrayList<>();
        for (SavestateOverwrite overwrite : activeOverwrites) {
            if (overwrite.getName().equals(name) && overwrite.getPlayer().equals(player)) {
                if (overwrite.getTimestamp() + overwriteExpire > System.currentTimeMillis()) {
                    return true;
                } else {
                    toRemove.add(overwrite);
                }
            }
        }
        activeOverwrites.removeAll(toRemove);
        return false;
    }

    public void add() {
        activeOverwrites.add(this);
    }

    public void remove() {
        // remove all of player's overwrites (design choice)
        activeOverwrites.removeIf(overwrite -> overwrite.getPlayer().equals(player));
    }
}
