package com.simondmc.utils.listener;

import com.simondmc.utils.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class LockHungerListener implements Listener {

    @EventHandler
    public void onDeath(FoodLevelChangeEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (!Config.containsString("lockhunger", e.getEntity().getUniqueId().toString())) return;
        e.setCancelled(true);
    }
}
