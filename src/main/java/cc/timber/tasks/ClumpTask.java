package cc.timber.tasks;

import cc.timber.TimberPlugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ClumpTask {

    public void displayClump(Player player, int amount) {
        if (!TimberPlugin.getInstance().getConfig().getBoolean("action-bar.enabled", true)) {
            return;
        }
        String messageFormat = TimberPlugin.getInstance().getConfig().getString("action-bar.message", "%amount%x Log");
        String formattedMessage = messageFormat.replace("%amount%", String.valueOf(amount));

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(formattedMessage));
    }
}