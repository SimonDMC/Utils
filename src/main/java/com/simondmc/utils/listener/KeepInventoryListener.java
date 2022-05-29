package com.simondmc.utils.listener;

import com.simondmc.utils.config.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KeepInventoryListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (!Config.containsString("keepinventory", e.getEntity().getUniqueId().toString())) return;
        e.getDrops().clear();
        e.setKeepInventory(true);
        e.setKeepLevel(true);
    }
}