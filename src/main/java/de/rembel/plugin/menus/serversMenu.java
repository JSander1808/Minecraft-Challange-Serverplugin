package de.rembel.plugin.menus;

import de.rembel.plugin.data.checkdata;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static de.rembel.plugin.data.config.serverconfig;

public class serversMenu {

    public serversMenu(Player player){
        Inventory inv = Bukkit.createInventory(null, 3*9, ChatColor.GOLD+"Server");

        ItemStack on = new ItemStack(Material.GREEN_WOOL);
        ItemMeta onmeta = on.getItemMeta();
        onmeta.setDisplayName(ChatColor.GREEN+"Server Online");
        ArrayList onlore = new ArrayList();
        onlore.add(ChatColor.GRAY+"Left-Click to join the Server");
        onlore.add(ChatColor.GRAY+"Right-Click to delete the Server");
        onmeta.setLore(onlore);
        on.setItemMeta(onmeta);

        ItemStack off = new ItemStack(Material.RED_WOOL);
        ItemMeta offmeta = off.getItemMeta();
        offmeta.setDisplayName(ChatColor.RED+"Server Offline");
        ArrayList offlore = new ArrayList();
        offlore.add(ChatColor.GRAY+"Left-Click to create a Server");
        offmeta.setLore(offlore);
        off.setItemMeta(offmeta);

        ItemStack back = new ItemStack(Material.BARRIER);
        ItemMeta backmeta = back.getItemMeta();
        backmeta.setDisplayName(ChatColor.RED+"BACK");
        back.setItemMeta(backmeta);

        new checkdata();

        if(serverconfig.getString("server1.status").equalsIgnoreCase("on")){
            inv.setItem(0,on);
        }else{
            inv.setItem(0,off);
        }
        if(serverconfig.getString("server2.status").equalsIgnoreCase("on")){
            inv.setItem(1,on);
        }else{
            inv.setItem(1,off);
        }
        if(serverconfig.getString("server3.status").equalsIgnoreCase("on")){
            inv.setItem(2,on);
        }else{
            inv.setItem(2,off);
        }
        if(serverconfig.getString("server4.status").equalsIgnoreCase("on")){
            inv.setItem(3,on);
        }else{
            inv.setItem(3,off);
        }
        if(serverconfig.getString("server5.status").equalsIgnoreCase("on")){
            inv.setItem(4,on);
        }else{
            inv.setItem(4,off);
        }

        player.openInventory(inv);
    }
}
