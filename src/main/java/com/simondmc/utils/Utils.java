package com.simondmc.utils;

import com.simondmc.utils.command.*;
import com.simondmc.utils.command.template.GeneralCommand;
import com.simondmc.utils.command.template.SuperCommand;
import com.simondmc.utils.config.ConfigFile;
import com.simondmc.utils.listener.*;
import com.simondmc.utils.util.StringUtil;
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
        // loop through label and all aliases of all commands
        for (SuperCommand cmd : commands)
            for (String cmdLabel : StringUtil.addToArray(cmd.getAliases(), cmd.getLabel()))
                getCommand(cmdLabel).setExecutor(new GeneralCommand());
        // registers listeners
        for (Listener l : getAllListeners()) {
            getServer().getPluginManager().registerEvents(l, this);
        }
        // register tab completers
        for (SuperCommand cmd : commands)
            if (cmd.getTabCompleter() != null)
                for (String cmdLabel : StringUtil.addToArray(cmd.getAliases(), cmd.getLabel()))
                    getCommand(cmdLabel).setTabCompleter(cmd.getTabCompleter());
        // saves config
        new ConfigFile("config.yml");
        // saves information about toggle commands
        new ConfigFile("commands.yml");
        // saves savestates
        new ConfigFile("savestates.yml");
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
        commands.add(new SaturateCommand());
        commands.add(new ClearLoopsCommand());

        /* SAVESTATE COMMAND */
        commands.add(new SavestateCommand());

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
