package cc.timber.commands;

import cc.timber.TimberPlugin;
import cc.timber.utilities.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (!sender.hasPermission("timber.timber")) {
                sender.sendMessage(ChatUtil.color("&cʏᴏᴜ ᴅᴏɴ'ᴛ ʜᴀᴠᴇ ᴘᴇʀᴍɪssɪᴏɴ ᴛᴏ ᴜsᴇ ᴛʜɪs ᴄᴏᴍᴍᴀɴᴅ"));
                return true;
            }
            sender.sendMessage(ChatUtil.color("&2&lᴛɪᴍʙᴇʀ &8| &2ᴛɪᴍʙᴇʀ &fᴠᴇʀsɪᴏɴ &a1&7.&a0 &fɪs ʀᴜɴɴɪɴɢ"));
            return true;
        }
        if (args[0].equalsIgnoreCase("enable")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatUtil.color("&cᴘʟᴇᴀsᴇ ᴇxᴇᴄᴜᴛᴇ ᴛʜɪs ᴄᴏᴍᴍᴀɴᴅ ɪɴ ɢᴀᴍᴇ."));
                return true;
            }
            Player player = (Player) sender;
            if (!player.hasPermission("timber.enable")) {
                player.sendMessage(ChatUtil.color("&cʏᴏᴜ ᴅᴏɴ'ᴛ ʜᴀᴠᴇ ᴘᴇʀᴍɪssɪᴏɴ ᴛᴏ ᴇɴᴀʙʟᴇ ᴛɪᴍʙᴇʀ"));
                return true;
            }
            TimberPlugin.getInstance().setTimberEnabled(player.getUniqueId(), true);
            player.sendMessage(ChatUtil.color("&2&lᴛɪᴍʙᴇʀ &8| &fᴛᴏɢɢʟᴇᴅ &a&lᴏɴ"));
            return true;
        }
        if (args[0].equalsIgnoreCase("disable")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatUtil.color("&cᴘʟᴇᴀsᴇ ᴇxᴇᴄᴜᴛᴇ ᴛʜɪs ᴄᴏᴍᴍᴀɴᴅ ɪɴ ɢᴀᴍᴇ."));
                return true;
            }
            Player player = (Player) sender;
            if (!player.hasPermission("timber.disable")) {
                player.sendMessage(ChatUtil.color("&cʏᴏᴜ ᴅᴏɴ'ᴛ ʜᴀᴠᴇ ᴘᴇʀᴍɪssɪᴏɴ ᴛᴏ ᴅɪsᴀʙʟᴇ ᴛɪᴍʙᴇʀ"));
                return true;
            }
            TimberPlugin.getInstance().setTimberEnabled(player.getUniqueId(), false);
            player.sendMessage(ChatUtil.color("&2&lᴛɪᴍʙᴇʀ &8| &fᴛᴏɢɢʟᴇᴅ &c&lᴏꜰꜰ"));
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("timber.reload")) {
                TimberPlugin.getInstance().reloadPluginConfig();
                sender.sendMessage(ChatUtil.color("&2&lᴛɪᴍʙᴇʀ &8| &aᴄᴏɴꜰɪɢᴜʀᴀᴛɪᴏɴ ꜰɪʟᴇs ʀᴇʟᴏᴀᴅᴇᴅ"));
            } else {
                sender.sendMessage(ChatUtil.color("&cʏᴏᴜ ᴅᴏɴ'ᴛ ʜᴀᴠᴇ ᴘᴇʀᴍɪssɪᴏɴ ᴛᴏ ᴅᴏ ᴛʜᴀᴛ"));
            }
            return true;
        }
        sender.sendMessage(ChatUtil.color("&cᴜɴᴋɴᴏᴡɴ sᴜʙᴄᴏᴍᴍᴀɴᴅ"));
        return true;
    }
}