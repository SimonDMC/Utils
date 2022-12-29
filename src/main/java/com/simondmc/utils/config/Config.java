package com.simondmc.utils.config;

import java.util.List;
import java.util.Set;

public class Config {

    /**
     * Add a string to a string list in a config file.
     * @param path The path to the string list.
     * @param toAdd The string to add.
     * @param configName The name of the config file.
     */
    public static void addString(String path, String toAdd, String configName) {
        String configPath = configName + ".yml";
        List<String> list = ConfigFile.get(configPath).getStringList(path);
        list.add(toAdd);
        ConfigFile.get(configPath).set(path, list);
        ConfigFile.save(configPath);
    }

    /**
     * Remove a string from a string list in a config file.
     * @param path The path to the string list.
     * @param toRemove The string to remove.
     * @param configName The name of the config file.
     */
    public static void removeString(String path, String toRemove, String configName) {
        String configPath = configName + ".yml";
        List<String> list = ConfigFile.get(configPath).getStringList(path);
        list.remove(toRemove);
        ConfigFile.get(configPath).set(path, list);
        ConfigFile.save(configPath);
    }

    /**
     * Check if a string is in a string list in a config file.
     * @param path The path to the string list.
     * @param toCheck The string to check.
     * @param configName The name of the config file.
     * @return Whether the string is in the list.
     */
    public static boolean containsString(String path, String toCheck, String configName) {
        String configPath = configName + ".yml";
        List<String> list = ConfigFile.get(configPath).getStringList(path);
        return list.contains(toCheck);
    }

    /**
     * Set a value in a config file.
     * @param path The path to the value.
     * @param toSet The value to set.
     * @param configName The name of the config file.
     */
    public static void set(String path, Object toSet, String configName) {
        String configPath = configName + ".yml";
        ConfigFile.get(configPath).set(path, toSet);
    }

    /**
     * Get a value from a config file.
     * @param path The path to the value.
     * @param configName The name of the config file.
     * @return The value.
     */
    public static Object get(String path, String configName) {
        String configPath = configName + ".yml";
        try {
            return ConfigFile.get(configPath).get(path);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Get a value from a config file, or return a default value if the value is null / doesn't exist.
     * @param path The path to the value.
     * @param defaultValue The default value to return if the value is null / doesn't exist.
     * @param configName The name of the config file.
     * @return The value, or the default value if the value is null / doesn't exist.
     */
    public static Object getOrDefault(String path, Object defaultValue, String configName) {
        String configPath = configName + ".yml";
        try {
            Object value = ConfigFile.get(configPath).get(path);
            return value == null ? defaultValue : value;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * List all values in the root of a config file.
     * @param configName The name of the config file.
     * @return A set of all values in the root.
     */
    public static Set<String> listFileEntries(String configName) {
        String configPath = configName + ".yml";
        return ConfigFile.get(configPath).getKeys(false);
    }

    /**
     * Save a config file.
     * @param configName The name of the config file.
     */
    public static void save(String configName) {
        String configPath = configName + ".yml";
        ConfigFile.save(configPath);
    }
}
