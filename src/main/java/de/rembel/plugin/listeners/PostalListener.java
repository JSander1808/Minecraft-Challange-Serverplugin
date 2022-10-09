package de.rembel.plugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PostalListener implements Listener {

    private String server;
    @EventHandler
    public void onPortal(PlayerPortalEvent event){
        if(event.getPlayer() instanceof Player){
            Player player = event.getPlayer();
            event.getCanCreatePortal();
            if(event.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL){
                if(player.getWorld().getName().equalsIgnoreCase("server1")){
                    Location loc = new Location(Bukkit.getWorld("server1_nether"),player.getLocation().getX()/8,player.getLocation().getY()/8,player.getLocation().getZ()/8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server1_nether")){
                    Location loc = new Location(Bukkit.getWorld("server1"),player.getLocation().getX()*8,player.getLocation().getY()*8,player.getLocation().getZ()*8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server2")){
                    Location loc = new Location(Bukkit.getWorld("server2_nether"),player.getLocation().getX()/8,player.getLocation().getY()/8,player.getLocation().getZ()/8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server2_nether")){
                    Location loc = new Location(Bukkit.getWorld("server2"),player.getLocation().getX()*8,player.getLocation().getY()*8,player.getLocation().getZ()*8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server3")){
                    Location loc = new Location(Bukkit.getWorld("server3_nether"),player.getLocation().getX()/8,player.getLocation().getY()/8,player.getLocation().getZ()/8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server3_nether")){
                    Location loc = new Location(Bukkit.getWorld("server3"),player.getLocation().getX()*8,player.getLocation().getY()*8,player.getLocation().getZ()*8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server4")){
                    Location loc = new Location(Bukkit.getWorld("server4_nether"),player.getLocation().getX()/8,player.getLocation().getY()/8,player.getLocation().getZ()/8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server4_nether")){
                    Location loc = new Location(Bukkit.getWorld("server4"),player.getLocation().getX()*8,player.getLocation().getY()*8,player.getLocation().getZ()*8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server5")){
                    Location loc = new Location(Bukkit.getWorld("server5_nether"),player.getLocation().getX()/8,player.getLocation().getY()/8,player.getLocation().getZ()/8);
                    event.setTo(loc);
                }
                if(player.getWorld().getName().equalsIgnoreCase("server5_nether")){
                    Location loc = new Location(Bukkit.getWorld("server5"),player.getLocation().getX()*8,player.getLocation().getY()*8,player.getLocation().getZ()*8);
                    event.setTo(loc);
                }
            }else{
                event.setCreationRadius(80);
                if(player.getWorld().getName().equalsIgnoreCase("server1")){
                    event.setTo(Bukkit.getWorld("server1_end").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server1_end")){
                    event.setTo(Bukkit.getWorld("server1").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server2")){
                    event.setTo(Bukkit.getWorld("server2_end").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server2_end")){
                    event.setTo(Bukkit.getWorld("server2").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server3")){
                    event.setTo(Bukkit.getWorld("server3_end").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server3_end")){
                    event.setTo(Bukkit.getWorld("server3").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server4")){
                    event.setTo(Bukkit.getWorld("server4_end").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server4_end")){
                    event.setTo(Bukkit.getWorld("server4").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server5")){
                    event.setTo(Bukkit.getWorld("server5_end").getSpawnLocation());
                }
                if(player.getWorld().getName().equalsIgnoreCase("server5_end")){
                    event.setTo(Bukkit.getWorld("server5").getSpawnLocation());
                }
            }
        }
    }
}
