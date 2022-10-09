package de.rembel.plugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import static de.rembel.plugin.data.config.serverconfig;

public class entitieKillListener implements Listener {

    @EventHandler
    public void onKill(EntityDeathEvent event){
        if(event.getEntity().getKiller() instanceof Player){
            Player player = event.getEntity().getKiller();
            if(event.getEntityType()==EntityType.ENDER_DRAGON){
                player.setGameMode(GameMode.SPECTATOR);
                String server = null;
                if(player.getWorld().getName().equalsIgnoreCase("server1_end")){
                    server = "server1";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server2_end")){
                    server = "server2";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server3_end")){
                    server = "server3";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server4_end")){
                    server = "server4";
                }
                if(player.getWorld().getName().equalsIgnoreCase("server5_end")){
                    server = "server5";
                }
                serverconfig.set(server+".timer.pause","true");
                StringBuilder time = new StringBuilder(ChatColor.GREEN+"You have kill the Enderdragon after "+ChatColor.GOLD);
                time.append(String.format("%02d",serverconfig.getInt(server+".timer.time")/3600)).append(":");
                time.append(String.format("%02d",serverconfig.getInt(server+".timer.time")/60 % 60)).append(":");
                time.append(String.format("%02d",serverconfig.getInt(server+".timer.time")%60));

                player.sendMessage(time.toString());
            }
        }
    }
}
