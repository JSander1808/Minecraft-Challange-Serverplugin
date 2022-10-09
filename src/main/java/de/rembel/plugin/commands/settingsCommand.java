package de.rembel.plugin.commands;

import de.rembel.plugin.menus.settingsMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class settingsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            String server = null;
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
            if(!(server==null)){
                new settingsMenu(player, server);
            }else{
                player.sendMessage(ChatColor.RED+"You must run the command on a server. To do this, use /games.");
            }
        }
        return false;
    }
}
