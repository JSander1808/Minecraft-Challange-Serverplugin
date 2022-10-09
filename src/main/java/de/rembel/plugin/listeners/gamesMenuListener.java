package de.rembel.plugin.listeners;

import de.rembel.plugin.menus.serversMenu;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class gamesMenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
            if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Games")){
                try{
                    switch(event.getCurrentItem().getType()){
                        default:
                            break;
                        case CHEST:
                            new serversMenu(player);
                            break;
                    }
                    event.setCancelled(true);
                }catch(NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
