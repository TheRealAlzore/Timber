package cc.timber.files;

import cc.timber.TimberPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile {
    private static FileConfiguration config;

    public static void load(TimberPlugin plugin) {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }
    public static FileConfiguration get() {
        return config;
    }
}