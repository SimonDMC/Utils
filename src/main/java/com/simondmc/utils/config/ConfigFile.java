package com.simondmc.utils.config;

import com.simondmc.utils.Utils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

public class ConfigFile {
    private static HashMap<String, FileConfiguration> configs = new HashMap<>();
    private static final Utils plugin = Utils.plugin;

    public ConfigFile(String configName) {
        createCustomConfig(configName);
    }

    public static FileConfiguration get(String configName) {
        return configs.get(configName);
    }

    public static void save(String configName) {
        try {
            get(configName).save(new File(plugin.getDataFolder(), configName));
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configName, e);
        }
    }

    void createCustomConfig(String configName) {
        File customConfigFile = new File(plugin.getDataFolder(), configName);
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            plugin.saveResource(configName, false);
        }

        FileConfiguration customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        configs.put(configName, customConfig);
    }
}
