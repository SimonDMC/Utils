package com.simondmc.utils.command;

import com.simondmc.utils.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SavestateTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // main command
        if (args.length == 1) {
            List<String> list = Arrays.asList("new", "save", "load", "list", "delete");
            List<String> arguments = new ArrayList<>(list);
            for (String arg : list) {
                if (!arg.startsWith(args[0].toLowerCase())) {
                    arguments.remove(arg);
                }
            }
            return arguments;
        }
        // load/delete
        else if (args.length == 2 && (args[0].equalsIgnoreCase("load") || args[0].equalsIgnoreCase("delete"))) {
            List<String> list = new ArrayList<>(Config.listFileEntries("savestates"));
            List<String> arguments = new ArrayList<>(list);
            for (String arg : list) {
                if (!arg.startsWith(args[1].toLowerCase())) {
                    arguments.remove(arg);
                }
            }
            return arguments;
        }
        return Collections.emptyList();
    }
}