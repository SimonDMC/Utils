package com.simondmc.utils.listener;

import com.simondmc.utils.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PreventDeathListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (!Config.containsString("preventdeath", e.getEntity().getUniqueId().toString(), "commands")) return;
        Player p = (Player) e.getEntity();
        if (p.getHealth() - e.getDamage() > 0) return;
        e.setDamage(p.getHealth() - .1);
    }
}
