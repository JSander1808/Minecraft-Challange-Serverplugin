package de.rembel.plugin.listeners;

import de.rembel.plugin.data.*;
import de.rembel.plugin.menus.serversMenu;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.IOException;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class serversMenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
            if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Server")){
                switch(event.getCurrentItem().getType()){
                    default:
                        break;

                    case RED_WOOL:
                        if(event.getSlot()==0){
                            new saveWorlddata(player);
                            player.closeInventory();
                            player.sendMessage(ChatColor.GRAY+"You will teleport when the world ist generated.");
                            serverconfig.set("server1.status","on");
                            try {
                                serverconfig.save(serverfile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            new createWorlddata("server1");
                            new loadWorlddata("server1",player);
                        }
                        if(event.getSlot()==1){
                            new saveWorlddata(player);
                            player.closeInventory();
                            player.sendMessage(ChatColor.GRAY+"You will teleport when the world ist generated.");
                            serverconfig.set("server2.status","on");
                            try {
                                serverconfig.save(serverfile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            new createWorlddata("server2");
                            new loadWorlddata("server2",player);
                        }
                        if(event.getSlot()==2){
                            new saveWorlddata(player);
                            player.closeInventory();
                            player.sendMessage(ChatColor.GRAY+"You will teleport when the world ist generated.");
                            serverconfig.set("server3.status","on");
                            try {
                                serverconfig.save(serverfile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            new createWorlddata("server3");
                            new loadWorlddata("server3",player);
                        }
                        if(event.getSlot()==3){
                            new saveWorlddata(player);
                            player.closeInventory();
                            player.sendMessage(ChatColor.GRAY+"You will teleport when the world ist generated.");
                            serverconfig.set("server4.status","on");
                            try {
                                serverconfig.save(serverfile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            new createWorlddata("server4");
                            new loadWorlddata("server4",player);
                        }
                        if(event.getSlot()==4){
                            new saveWorlddata(player);
                            player.closeInventory();
                            player.sendMessage(ChatColor.GRAY+"You will teleport when the world ist generated.");
                            serverconfig.set("server5.status","on");
                            try {
                                serverconfig.save(serverfile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            new createWorlddata("server5");
                            new loadWorlddata("server5",player);
                        }
                        break;

                    case GREEN_WOOL:
                        if(event.getClick().isLeftClick()){
                            if(event.getSlot()==0){
                                new saveWorlddata(player);
                                new loadWorlddata("server1",player);
                            }
                            if(event.getSlot()==1){
                                new saveWorlddata(player);
                                new loadWorlddata("server2",player);;
                            }
                            if(event.getSlot()==2){
                                new saveWorlddata(player);
                                new loadWorlddata("server3",player);
                            }
                            if(event.getSlot()==3){
                                new saveWorlddata(player);
                                new loadWorlddata("server4",player);
                            }
                            if(event.getSlot()==4){
                                new saveWorlddata(player);
                                new loadWorlddata("server5",player);
                            }
                        }
                        if(event.getClick().isRightClick()){
                            if(event.getSlot()==0){
                                new deleteWorlddata("server1",player);
                                player.sendMessage(ChatColor.RED+"Server 1 deleted");
                                new serversMenu(player);
                            }
                            if(event.getSlot()==1){
                                new deleteWorlddata("server2",player);
                                player.sendMessage(ChatColor.RED+"Server 2 deleted");
                                new serversMenu(player);
                            }
                            if(event.getSlot()==2){
                                new deleteWorlddata("server3",player);
                                player.sendMessage(ChatColor.RED+"Server 3 deleted");
                                new serversMenu(player);
                            }
                            if(event.getSlot()==3){
                                new deleteWorlddata("server4",player);
                                player.sendMessage(ChatColor.RED+"Server 4 deleted");
                                new serversMenu(player);
                            }
                            if(event.getSlot()==4){
                                new deleteWorlddata("server5",player);
                                player.sendMessage(ChatColor.RED+"Server 5 deleted");
                                new serversMenu(player);
                            }
                        }
                        break;
                }
                event.setCancelled(true);
            }
        }
    }
}
