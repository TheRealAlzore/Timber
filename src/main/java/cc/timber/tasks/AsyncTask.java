package cc.timber.tasks;

import cc.timber.utilities.TreeUtil;
import cc.timber.TimberPlugin;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import java.util.List;

public class AsyncTask {
    public void process(Block origin, Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(TimberPlugin.getInstance(), () -> {
            List<Block> logs = TreeUtil.getConnectedLogs(origin);
            Bukkit.getScheduler().runTask(TimberPlugin.getInstance(), () -> {
                new ClumpTask().displayClump(player, logs.size());
                new FallTask(TimberPlugin.getInstance()).startFalling(logs);
            });
        });
    }
}