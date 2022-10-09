package de.rembel.plugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

public class worldInitListener implements Listener {

    @EventHandler
    public void onInit(WorldInitEvent event) {
        event.getWorld().setKeepSpawnInMemory(false);
    }
}
