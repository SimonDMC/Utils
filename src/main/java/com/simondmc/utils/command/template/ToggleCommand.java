package com.simondmc.utils.command.template;

import com.simondmc.utils.config.Config;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.entity.Player;

public class ToggleCommand {
    public ToggleCommand(Player player, String[] args, String label, String toggleDisplayName, Boolean isInverted, Boolean saysDefaultInsteadOfOff) {
        if (args.length > 0) player = PlayerUtil.validateCommandTarget(args[0], player);
        if (player == null) return;

        if (Config.containsString(label, player.getUniqueId().toString(), "commands")) {
            Config.removeString(label, player.getUniqueId().toString(), "commands");

            String color = (isInverted ? "§a" : "§c");
            String toggleState = (isInverted ? "ON" : "OFF");

            toggleState = (saysDefaultInsteadOfOff ? "DEFAULT" : toggleState);

            player.sendMessage("§e" + toggleDisplayName + " is now " + color + "§l" + toggleState + " §efor " + player.getName());
        } else {
            Config.addString(label, player.getUniqueId().toString(), "commands");

            String color = (isInverted ? "§c" : "§a");
            String toggleState = (isInverted ? "OFF" : "ON");

            player.sendMessage("§e" + toggleDisplayName + " is now " + color + "§l" + toggleState + " §efor " + player.getName());
        }
    }
}
