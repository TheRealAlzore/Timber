package cc.timber.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class LogTask implements Listener {

    private final JavaPlugin plugin;
    private final NamespacedKey logStackKey;

    public LogTask(JavaPlugin plugin) {
        this.plugin = plugin;
        this.logStackKey = new NamespacedKey(plugin, "stack_amount");

    }
    public void dropStackedLogs(Location location, Material logType, int amount) {
        if (amount <= 0) return;
        ItemStack stack = new ItemStack(logType, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.getPersistentDataContainer().set(logStackKey, PersistentDataType.INTEGER, amount);
        stack.setItemMeta(meta);
        Item dropped = location.getWorld().dropItem(location, stack);
        dropped.setVelocity(new Vector(0, 0.05, 0));
        Location holoLoc = location.clone().add(0, 1.0, 0);
        ArmorStand stand = (ArmorStand) location.getWorld().spawnEntity(holoLoc, EntityType.ARMOR_STAND);
        stand.setVisible(false);
        stand.setMarker(true);
        stand.setGravity(false);
        stand.setCustomNameVisible(true);
        stand.setCustomName(amount + "x Log");
        Bukkit.getScheduler().runTaskLater(plugin, stand::remove, 60L);
    }
}