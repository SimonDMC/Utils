package com.simondmc.utils.listener;

import com.simondmc.utils.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class NaturalRegenListener implements Listener {

    @EventHandler
    public void onDeath(EntityRegainHealthEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (!Config.containsString("naturalregen", e.getEntity().getUniqueId().toString())) return;
        if (e.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) {
            e.setCancelled(true);
        }
    }
}