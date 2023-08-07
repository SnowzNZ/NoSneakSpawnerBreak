package dev.snowz.nosneakspawnerbreak;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoSneakSpawnerBreak extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (event.getBlock().getType().equals(Material.MOB_SPAWNER)) {
            if (player.isSneaking()) {
                event.setCancelled(true);
                player.sendMessage("§cPlease do not sneak while breaking a spawner.");
            }
        }
    }
}
