package cc.timber;

import cc.timber.commands.Commands;
import cc.timber.commands.CommandsTabCompleter;
import cc.timber.events.blockbreak.PlayerBreakEvent;
import cc.timber.files.ConfigFile;
import cc.timber.tasks.LogTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TimberPlugin extends JavaPlugin {
    private static TimberPlugin instance;
    private final Set<UUID> enabledPlayers = new HashSet<>();
    private LogTask logTask;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig(); // ensures config.yml is saved on first run
        ConfigFile.load(this);
        logTask = new LogTask(this);

        getServer().getPluginManager().registerEvents(logTask, this);
        getServer().getPluginManager().registerEvents(new PlayerBreakEvent(), this);

        getCommand("timber").setExecutor(new Commands());
        getCommand("timber").setTabCompleter(new CommandsTabCompleter());

        getLogger().info("Timber Enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Timber Disabled");
    }

    public static TimberPlugin getInstance() {
        return instance;
    }

    public boolean isTimberEnabled(UUID uuid) {
        return enabledPlayers.contains(uuid);
    }

    public void setTimberEnabled(UUID uuid, boolean enabled) {
        if (enabled) enabledPlayers.add(uuid);
        else enabledPlayers.remove(uuid);
    }

    public LogTask getLogTask() {
        return logTask;
    }

    public void reloadPluginConfig() {
        reloadConfig();
        ConfigFile.load(this);
    }
}