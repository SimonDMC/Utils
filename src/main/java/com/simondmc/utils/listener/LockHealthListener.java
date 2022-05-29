package com.simondmc.utils.listener;

import com.simondmc.utils.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class LockHealthListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (!Config.containsString("lockhealth", e.getEntity().getUniqueId().toString())) return;
        e.setDamage(0);
    }

    @EventHandler
    public void onHeal(EntityRegainHealthEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (!Config.containsString("lockhealth", e.getEntity().getUniqueId().toString())) return;
        e.setCancelled(true);
    }
}
