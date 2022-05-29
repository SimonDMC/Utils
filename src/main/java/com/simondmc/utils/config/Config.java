package com.simondmc.utils.config;

import java.util.List;

public class Config {

    // add string to string list in config
    public static void addString(String path, String toAdd, String configName) {
        String configPath = configName + ".yml";
        List<String> list = ConfigFile.get(configPath).getStringList(path);
        list.add(toAdd);
        ConfigFile.get(configPath).set(path, list);
        ConfigFile.save(configPath);
    }

    // remove string from string list in config
    public static void removeString(String path, String toRemove, String configName) {
        String configPath = configName + ".yml";
        List<String> list = ConfigFile.get(configPath).getStringList(path);
        list.remove(toRemove);
        ConfigFile.get(configPath).set(path, list);
        ConfigFile.save(configPath);
    }

    // check if string is in string list in config
    public static boolean containsString(String path, String toCheck, String configName) {
        String configPath = configName + ".yml";
        List<String> list = ConfigFile.get(configPath).getStringList(path);
        return list.contains(toCheck);
    }
}
