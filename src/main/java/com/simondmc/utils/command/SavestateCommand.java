package com.simondmc.utils.command;

import com.simondmc.utils.command.template.Permission;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.config.Config;
import com.simondmc.utils.savestate.Savestate;
import com.simondmc.utils.savestate.SavestateBuilder;
import com.simondmc.utils.savestate.SavestateLoader;
import com.simondmc.utils.savestate.SavestateOverwrite;
import com.simondmc.utils.util.StringUtil;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class SavestateCommand implements SuperCommand {
    public String getLabel() {
        return "savestate";
    }

    public String getUsage() {
        return "/savestate save/new/load/list/delete";
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

    public TabCompleter getTabCompleter() {
        return new SavestateTabCompleter();
    }

    public void runCommand(Player p, String[] args) {

        if (args[0].equalsIgnoreCase("save") || args[0].equalsIgnoreCase("new")) {
            String label;
            if (args.length > 1) {
                label = StringUtil.joinStringArray(args, " ", 1);
            } else {
                // generate random name if none is specified
                label  = "Savestate" + (int)(Math.random() * 10000);
            }

            boolean isOverwrite = false;

            // check if another savestate with the same name already exists
            if (Config.listFileEntries("savestates").contains(label)) {
                SavestateOverwrite overwrite = new SavestateOverwrite(label, p);
                if (overwrite.isActive()) {
                    overwrite.remove();
                    isOverwrite = true;
                } else {
                    p.sendMessage("§cA savestate with the name §e" + label + "§c already exists. Run this command again to overwrite it.");
                    overwrite.add();
                    return;
                }
            }

            Savestate ss = new SavestateBuilder()
                    .label(label)
                    .location(p.getLocation())
                    .velocity(p.getVelocity())
                    .inventory(p.getInventory().getContents())
                    .health(p.getHealth())
                    .food(p.getFoodLevel())
                    .saturation(p.getSaturation())
                    .gamemode(p.getGameMode())
                    .build();

            ss.save();
            p.sendMessage(String.format("§a%s state §e%s§a.", isOverwrite ? "Overwrote" : "Saved", label));
            return;
        }

        if (args[0].equalsIgnoreCase("load")) {
            String label;
            if (args.length > 1) {
                label = StringUtil.joinStringArray(args, " ", 1);
            } else {
                p.sendMessage("§cPlease specify a savestate name.");
                return;
            }

            Savestate ss = new SavestateLoader(label).toSavestate();

            if (ss == null) {
                p.sendMessage("§cNo savestate found with label §e" + label + "§c.");
                return;
            }

            ss.load(p);
            return;
        }

        if (args[0].equalsIgnoreCase("list")) {
            if (Config.listFileEntries("savestates").size() == 0) {
                p.sendMessage("§cNo savestates found.");
                return;
            }
            p.sendMessage("§aSavestates: §e" + Config.listFileEntries("savestates").toString().replace("[", "").replace("]", ""));
            return;
        }

        if (args[0].equalsIgnoreCase("delete")) {
            String label;
            if (args.length > 1) {
                label = StringUtil.joinStringArray(args, " ", 1);
            } else {
                p.sendMessage("§cPlease specify a savestate name.");
                return;
            }

            Savestate ss = new SavestateLoader(label).toSavestate();

            if (ss == null) {
                p.sendMessage("§cNo savestate found with label §e" + label + "§c.");
                return;
            }

            ss.delete();
            p.sendMessage("§aDeleted savestate §e" + label + "§a.");
            return;
        }

        p.sendMessage("§cUsage: " + getUsage());
    }
}
