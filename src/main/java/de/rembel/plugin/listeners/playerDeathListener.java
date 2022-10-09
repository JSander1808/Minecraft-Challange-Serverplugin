package de.rembel.plugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

import static de.rembel.plugin.data.config.serverconfig;

public class playerDeathListener implements Listener {

    private String server = null;

    @EventHandler
    public void onDeath(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if((player.getHealth()- event.getDamage())<=0){
                event.setCancelled(true);
                player.setGameMode(GameMode.SPECTATOR);
                if(player.getWorld().getName().equalsIgnoreCase("server1")||player.getWorld().getName().equalsIgnoreCase("server1_nether")||player.getWorld().getName().equalsIgnoreCase("server1_end")){
                    server = "server1";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server2")||player.getWorld().getName().equalsIgnoreCase("server2_nether")||player.getWorld().getName().equalsIgnoreCase("server2_end")){
                    server = "server2";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server3")||player.getWorld().getName().equalsIgnoreCase("server3_nether")||player.getWorld().getName().equalsIgnoreCase("server3_end")){
                    server = "server3";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server4")||player.getWorld().getName().equalsIgnoreCase("server4_nether")||player.getWorld().getName().equalsIgnoreCase("server4_end")){
                    server = "server4";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server5")||player.getWorld().getName().equalsIgnoreCase("server5_nether")||player.getWorld().getName().equalsIgnoreCase("server5_end")){
                    server = "server5";
                }
                serverconfig.set(server+".timer.pause","true");
                player.sendMessage(ChatColor.GREEN+"Nice Try.");
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByBlockEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if((player.getHealth()- event.getDamage())<=0){
                event.setCancelled(true);
                player.setGameMode(GameMode.SPECTATOR);
                if(player.getWorld().getName().equalsIgnoreCase("server1")||player.getWorld().getName().equalsIgnoreCase("server1_nether")||player.getWorld().getName().equalsIgnoreCase("server1_end")){
                    server = "server1";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server2")||player.getWorld().getName().equalsIgnoreCase("server2_nether")||player.getWorld().getName().equalsIgnoreCase("server2_end")){
                    server = "server2";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server3")||player.getWorld().getName().equalsIgnoreCase("server3_nether")||player.getWorld().getName().equalsIgnoreCase("server3_end")){
                    server = "server3";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server4")||player.getWorld().getName().equalsIgnoreCase("server4_nether")||player.getWorld().getName().equalsIgnoreCase("server4_end")){
                    server = "server4";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server5")||player.getWorld().getName().equalsIgnoreCase("server5_nether")||player.getWorld().getName().equalsIgnoreCase("server5_end")){
                    server = "server5";
                }
                serverconfig.set(server+".timer.pause","true");
                player.sendMessage(ChatColor.GREEN+"Nice Try.");
            }
        }
    }

    @EventHandler
    public void onfall(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if((player.getHealth()- event.getDamage())<=0){
                event.setCancelled(true);
                player.setGameMode(GameMode.SPECTATOR);
                if(player.getWorld().getName().equalsIgnoreCase("server1")||player.getWorld().getName().equalsIgnoreCase("server1_nether")||player.getWorld().getName().equalsIgnoreCase("server1_end")){
                    server = "server1";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server2")||player.getWorld().getName().equalsIgnoreCase("server2_nether")||player.getWorld().getName().equalsIgnoreCase("server2_end")){
                    server = "server2";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server3")||player.getWorld().getName().equalsIgnoreCase("server3_nether")||player.getWorld().getName().equalsIgnoreCase("server3_end")){
                    server = "server3";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server4")||player.getWorld().getName().equalsIgnoreCase("server4_nether")||player.getWorld().getName().equalsIgnoreCase("server4_end")){
                    server = "server4";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server5")||player.getWorld().getName().equalsIgnoreCase("server5_nether")||player.getWorld().getName().equalsIgnoreCase("server5_end")){
                    server = "server5";
                }
                serverconfig.set(server+".timer.pause","true");
                player.sendMessage(ChatColor.GREEN+"Nice Try.");
                player.setMaxHealth(20);
                player.setHealth(20);
            }
        }
    }
}
