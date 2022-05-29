package com.simondmc.utils.config;

import com.simondmc.utils.Utils;

import java.util.List;

public class Config {
    // add string to string list in config
    public static void addString(String path, String toAdd) {
        List<String> list = Utils.plugin.getConfig().getStringList(path);
        list.add(toAdd);
        Utils.plugin.getConfig().set(path, list);
        Utils.plugin.saveConfig();
    }

    // remove string from string list in config
    public static void removeString(String path, String toRemove) {
        List<String> list = Utils.plugin.getConfig().getStringList(path);
        list.remove(toRemove);
        Utils.plugin.getConfig().set(path, list);
        Utils.plugin.saveConfig();
    }

    // check if string is in string list in config
    public static boolean containsString(String path, String toCheck) {
        List<String> list = Utils.plugin.getConfig().getStringList(path);
        return list.contains(toCheck);
    }
}
