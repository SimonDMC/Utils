package com.simondmc.utils.command;

import com.simondmc.utils.config.Config;
import com.simondmc.utils.util.StringUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SavestateTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // main command
        if (args.length == 1) {
            List<String> list = Arrays.asList("new", "save", "load", "list", "delete");
            List<String> arguments = new ArrayList<>(list);
            for (String arg : list) {
                if (!arg.toLowerCase().startsWith(args[0].toLowerCase())) {
                    arguments.remove(arg);
                }
            }
            return arguments;
        }
        // load/delete
        else if (args.length >= 2 && (args[0].equalsIgnoreCase("load") || args[0].equalsIgnoreCase("delete"))) {
            List<String> list = new ArrayList<>(Config.listFileEntries("savestates"));
            List<String> arguments = new ArrayList<>(list);
            for (String arg : list) {
                if (!arg.toLowerCase().startsWith(StringUtil.joinStringArray(args, " ", 1).toLowerCase())) {
                    arguments.remove(arg);
                }
            }
            // for multi-word compatibility, only return the current word onwards
            return arguments.stream().map(s -> StringUtil.getWordsFromN(s, args.length - 2)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}