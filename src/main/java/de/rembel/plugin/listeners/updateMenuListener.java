package de.rembel.plugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class updateMenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
            if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Updates")){
                try{
                    switch(event.getCurrentItem().getType()){
                        default:
                            break;
                        case PAPER:
                            player.closeInventory();
                            player.sendMessage(ChatColor.GOLD+"Patchnotes Update V1.0.45");
                            player.sendMessage(ChatColor.GREEN+"-Wenn in eine Welt gegangen wird ist der Gamemode 'Adventure' bis der Timer gestartet wurde.");
                            player.sendMessage(ChatColor.GREEN+"-Weltengenerierung wurde verändert (bei Problemen bitte melden).");
                            player.sendMessage(ChatColor.GREEN+"-Updates Menu hinzugefügt.");
                            player.sendMessage(ChatColor.GREEN+"-kleine veränderungen in der Lobby.");
                            player.sendMessage(ChatColor.GREEN+"-Man wird nun gekickt wenn der Server neu geladen wird.");
                            player.sendMessage(ChatColor.GREEN+"-Neue Nachrichten wenn man Timer stoppt.");
                            break;

                        case BEACON:
                            Desktop.getDesktop().browse(new URL("https://www.mediafire.com/file/y6sn4axzmlfx8ut/Serverplugin.jar/file").toURI());
                            break;
                    }
                    event.setCancelled(true);
                }catch(NullPointerException e){
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
