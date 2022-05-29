package com.simondmc.utils.command.template;

import com.simondmc.utils.config.Config;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.entity.Player;

public class ToggleCommand {
    public ToggleCommand(Player player, String[] args, String label, String toggleDisplayName, Boolean isInverted, Boolean saysDefaultInsteadOfOff) {
        Player secondPlayer = null;
        if (args.length > 1) secondPlayer = PlayerUtil.validateSecondPlayer(args[1], player);
        Player target = (secondPlayer == null ? player : secondPlayer);

        if (Config.containsString(label, target.getUniqueId().toString(), "commands")) {
            Config.removeString(label, target.getUniqueId().toString(), "commands");

            String color = (isInverted ? "§a" : "§c");
            String toggleState = (isInverted ? "ON" : "OFF");

            toggleState = (saysDefaultInsteadOfOff ? "DEFAULT" : toggleState);

            player.sendMessage("§e" + toggleDisplayName + " is now " + color + "§l" + toggleState + " §efor " + target.getName());
        } else {
            Config.addString(label, target.getUniqueId().toString(), "commands");

            String color = (isInverted ? "§c" : "§a");
            String toggleState = (isInverted ? "OFF" : "ON");

            player.sendMessage("§e" + toggleDisplayName + " is now " + color + "§l" + toggleState + " §efor " + target.getName());
        }
    }
}
