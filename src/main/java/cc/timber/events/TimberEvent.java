package cc.timber.events;

import cc.timber.tasks.AsyncTask;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;

public class TimberEvent {
    public void handle(BlockBreakEvent event) {
        Block block = event.getBlock();
        Material type = block.getType();
        if (!type.name().endsWith("_LOG")) {
            return;
        }
        new AsyncTask().process(block, event.getPlayer());
    }
}