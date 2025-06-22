package cc.timber.events.blockbreak;

import cc.timber.TimberPlugin;
import cc.timber.events.TimberEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakEvent implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!TimberPlugin.getInstance().isTimberEnabled(player.getUniqueId())) return;
        new TimberEvent().handle(event);
    }
}