package cc.timber.tasks;

import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.List;

public class FallTask {
    private final JavaPlugin plugin;

    public FallTask(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public void startFalling(List<Block> logBlocks) {
        logBlocks.sort((b1, b2) -> Integer.compare(b2.getY(), b1.getY()));
        new BukkitRunnable() {
            int index = 0;
            @Override
            public void run() {
                if (index >= logBlocks.size()) {
                    cancel();
                    return;
                }
                Block block = logBlocks.get(index);
                if (block.getType().name().contains("LOG")) {
                    block.breakNaturally();
                }
                index++;
            }
        }.runTaskTimer(plugin, 0L, 2L);
    }
}