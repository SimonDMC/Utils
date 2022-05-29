package com.simondmc.utils;

import com.simondmc.utils.command.*;
import com.simondmc.utils.command.template.GeneralCommand;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.config.ConfigFile;
import com.simondmc.utils.listener.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Utils extends JavaPlugin {
    public static Utils plugin;
    public static List<SuperCommand> commands = new ArrayList<>();

    @Override
    public void onEnable() {
        // registers plugin for static use
        plugin = this;
        // registers all commands
        populateCommands();
        for (SuperCommand cmd : commands)
            getCommand(cmd.getLabel()).setExecutor(new GeneralCommand());
        // registers listeners
        for (Listener l : getAllListeners()) {
            getServer().getPluginManager().registerEvents(l, this);
        }
        // default config file
        this.saveDefaultConfig();
        // custom config file
        new ConfigFile("commands.yml");
    }

    @Override
    public void onDisable() {

    }

    void populateCommands() {
        /* ONE-TIME COMMANDS */
        commands.add(new UnbreakableCommand());
        commands.add(new CountCommand());
        commands.add(new HealthCommand());
        commands.add(new SetHealthCommand());
        commands.add(new SetHungerCommand());
        commands.add(new SetMaxHealthCommand());
        commands.add(new LoopCommand());
        commands.add(new DelayCommand());
        commands.add(new SimulateCommand());
        commands.add(new RenameCommand());

        /* TOGGLE COMMANDS */
        commands.add(new PreventDeathCommand());
        commands.add(new KeepInventoryCommand());
        commands.add(new NaturalRegenCommand());
        commands.add(new LockHungerCommand());
        commands.add(new LockHealthCommand());
    }

    Listener[] getAllListeners() {
        return new Listener[]{
                new PreventDeathListener(),
                new KeepInventoryListener(),
                new NaturalRegenListener(),
                new LockHungerListener(),
                new LockHealthListener()
        };
    }
}
