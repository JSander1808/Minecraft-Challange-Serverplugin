package de.rembel.plugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class serverListPingListener implements Listener {

    private int value = 0;

    @EventHandler
    public void onPing(ServerListPingEvent event){
        if(value==0){
            event.setMotd(ChatColor.GREEN+"Challenge Server 1.19.1");
            value++;
        }else if(value==1){
            event.setMotd(ChatColor.BLUE+"Developt by RembelGHG");
            value++;
        }else if(value==2){
            event.setMotd(ChatColor.GOLD+"New Functions now available");
            value=0;
        }
    }
}
