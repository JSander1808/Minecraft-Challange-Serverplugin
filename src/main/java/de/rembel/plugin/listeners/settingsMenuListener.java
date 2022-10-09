package de.rembel.plugin.listeners;

import de.rembel.plugin.data.loadChallengedata;
import de.rembel.plugin.menus.serversMenu;
import de.rembel.plugin.menus.settingsMenu;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.IOException;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class settingsMenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        String server = null;
        if(event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server1")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server1_nether")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server1_end")){
            server = "server1";
        }
        if(event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server2")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server2_nether")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server2_end")){
            server = "server2";
        }
        if(event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server3")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server3_nether")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server3_end")){
            server = "server3";
        }
        if(event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server4")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server4_nether")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server4_end")){
            server = "server4";
        }
        if(event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server5")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server5_nether")||event.getWhoClicked().getWorld().getName().equalsIgnoreCase("server5_end")){
            server = "server5";
        }
        if(event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
            if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Challenges")){
                try{
                    switch(event.getCurrentItem().getType()){
                        default:
                            break;
                        case LIME_DYE:
                            if(event.getSlot()==0){
                                if(serverconfig.getInt(server+".challenge.speed")<=255){
                                    int value = serverconfig.getInt(server+".challenge.speed");
                                    value++;
                                    serverconfig.set(server+".challenge.speed",value);
                                }
                            }
                            if(event.getSlot()==1){
                                if(serverconfig.getInt(server+".challenge.maxhealth")<=100){
                                    int value = serverconfig.getInt(server+".challenge.maxhealth");
                                    value++;
                                    serverconfig.set(server+".challenge.maxhealth",value);
                                }
                            }
                            break;

                        case RED_DYE:
                            if(event.getSlot()==18){
                                if(serverconfig.getInt(server+".challenge.speed")>0){
                                    int value = serverconfig.getInt(server+".challenge.speed");
                                    value--;
                                    serverconfig.set(server+".challenge.speed",value);
                                }
                            }
                            if(event.getSlot()==19){
                                if(serverconfig.getInt(server+".challenge.maxhealth")>1){
                                    int value = serverconfig.getInt(server+".challenge.maxhealth");
                                    value--;
                                    serverconfig.set(server+".challenge.maxhealth",value);
                                }
                            }
                            break;

                    }
                    serverconfig.save(serverfile);
                    new loadChallengedata(player);
                    new settingsMenu(player,server);
                    event.setCancelled(true);
                }catch(NullPointerException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
