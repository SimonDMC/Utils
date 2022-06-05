package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.util.PlayerUtil;
import org.bukkit.entity.Player;

public class SaturateCommand implements SuperCommand {
    public String getLabel() {
        return "saturate";
    }

    public String getUsage() {
        return "/saturate [player]";
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 0;
    }

    public void runCommand(Player p, String[] args) {
        Player secondPlayer = null;
        if (args.length > 0) secondPlayer = PlayerUtil.validateSecondPlayer(args[0], p);
        Player target = (secondPlayer == null ? p : secondPlayer);

        target.setFoodLevel(20);
        target.setSaturation(20);
    }
}
