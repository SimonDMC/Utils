package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.savestate.Savestate;
import com.simondmc.utils.savestate.SavestateBuilder;
import com.simondmc.utils.savestate.SavestateLoader;
import org.bukkit.entity.Player;

public class SavestateCommand implements SuperCommand {
    public String getLabel() {
        return "savestate";
    }

    public String getUsage() {
        return "/savestate save/new/load/list";
    }

    public String[] getAliases() {
        return new String[] {"ss"};
    }

    public Permission getRequiredPermission() {
        return Permission.ADMIN;
    }

    public int getMinimumArgs() {
        return 1;
    }

    public void runCommand(Player p, String[] args) {

        if (args[0].equalsIgnoreCase("save") || args[0].equalsIgnoreCase("new")) {
            String label = "";
            if (args.length > 1) label = args[1];

            Savestate ss = new SavestateBuilder()
                    .label(label)
                    .location(p.getLocation())
                    .velocity(p.getVelocity())
                    .inventory(p.getInventory().getContents())
                    .health(p.getHealth())
                    .food(p.getFoodLevel())
                    .saturation(p.getSaturation())
                    .build();

            ss.save();
            p.sendMessage("§aSaved state §e" + label);
            return;
        }

        if (args[0].equalsIgnoreCase("load")) {
            String label = "";
            if (args.length > 1) label = args[1];

            Savestate ss = new SavestateLoader(label).toSavestate();

            if (ss == null) {
                p.sendMessage("§cNo savestate found with label §e" + label);
                return;
            }

            ss.load(p);
            return;
        }

        p.sendMessage("§cUsage: " + getUsage());
    }
}
