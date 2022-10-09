package de.rembel.plugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

import java.util.Vector;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.setJoinMessage("");
        Player player = event.getPlayer();
        player.sendTitle(ChatColor.GREEN+"Welcome",ChatColor.GOLD+player.getName());
        player.sendMessage(ChatColor.GREEN+"Use "+ChatColor.GOLD+"/games "+ChatColor.GREEN+"to open the games menu.");
        Location loc = new Location(Bukkit.getWorld("world"),-179.5,41,843.5, -180, 0);
        player.teleport(loc);
        player.setGameMode(GameMode.ADVENTURE);
        player.setAllowFlight(true);
        player.setMaxHealth(20);
        for(PotionEffect effect : player.getActivePotionEffects())
        {
            player.removePotionEffect(effect.getType());
        }
        player.setHealth(20);
        player.setFoodLevel(20);
        player.sendMessage(ChatColor.GREEN+"Use "+ChatColor.GOLD+"/update "+ChatColor.GREEN+"for Update options.");
    }
}
