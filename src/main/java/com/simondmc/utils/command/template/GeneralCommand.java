package com.simondmc.utils.command.template;

import com.simondmc.utils.Utils;
import com.simondmc.utils.util.StringUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GeneralCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (SuperCommand cmd : Utils.commands) {
            // loop through label and all aliases of command
            for (String cmdLabel : StringUtil.addToArray(cmd.getAliases(), cmd.getLabel())) {
                // perform all necessary checks and run command if all checks are passed
                if (!label.equalsIgnoreCase(cmdLabel) && !label.equalsIgnoreCase(Utils.plugin.getName() + ":" + cmdLabel))
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
                        if (!sender.isOp()) {
                            sender.sendMessage("§cYou don't have permission to do that.");
                            continue;
                        }
                        break;
                    case NONE:
                        break;
                }

                Player player = (Player) sender;
                cmd.runCommand(player, args);

                // if the command is a toggle command, pass to ToggleCommand
                if (cmd instanceof IToggleCommand) {
                    IToggleCommand toggleCommand = (IToggleCommand) cmd;
                    new ToggleCommand(
                            player,
                            args,
                            cmdLabel,
                            toggleCommand.getToggleDisplayName(),
                            toggleCommand.isInverted(),
                            toggleCommand.saysDefaultInsteadOfOff()
                    );
                }
                return true;
            }
        }
        return false;
    }
}
