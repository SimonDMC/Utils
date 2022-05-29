package com.simondmc.utils.command.template;

import com.simondmc.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GeneralCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (SuperCommand cmd : Utils.commands) {
            if (!label.equalsIgnoreCase(cmd.getLabel()) && !label.equalsIgnoreCase(Utils.plugin.getName() + ":" + cmd.getLabel()))
                continue;
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cNot a player!");
                continue;
            }
            if (args.length < cmd.getMinimumArgs()) {
                sender.sendMessage("§cUsage: " + cmd.getUsage());
                continue;
            }

            switch (cmd.getRequiredPermission()) {
                case ADMIN:
                    if (!sender.isOp()) continue;
                    break;
                case NONE:
                    break;
            }

            Player player = (Player) sender;
            cmd.runCommand(player, args);

            if (cmd instanceof IToggleCommand) {
                IToggleCommand toggleCommand = (IToggleCommand) cmd;
                new ToggleCommand(
                        player,
                        args,
                        cmd.getLabel(),
                        toggleCommand.getToggleDisplayName(),
                        toggleCommand.isInverted(),
                        toggleCommand.saysDefaultInsteadOfOff()
                );
            }
            return true;
        }
        return false;
    }
}
