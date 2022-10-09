package de.rembel.plugin.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class gamesMenu {

    public gamesMenu(Player player){
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD+"Games");

        ItemStack servers = new ItemStack(Material.CHEST);
        ItemMeta serversmeta = servers.getItemMeta();
        serversmeta.setDisplayName(ChatColor.GOLD+"Server");
        ArrayList serverslore = new ArrayList();
        serverslore.add(ChatColor.GRAY+"A list of your Servers");
        serversmeta.setLore(serverslore);
        servers.setItemMeta(serversmeta);

        ItemStack lobbysettings = new ItemStack(Material.IRON_SWORD);
        ItemMeta lobbysettingsmeta = lobbysettings.getItemMeta();
        lobbysettingsmeta.setDisplayName(ChatColor.GOLD+"Lobbysettings");
        ArrayList lobbysettingslore = new ArrayList();
        lobbysettingslore.add(ChatColor.GRAY+"Settings abount the Lobby");
        lobbysettingsmeta.setLore(lobbysettingslore);
        lobbysettings.setItemMeta(lobbysettingsmeta);

        inv.setItem(2, servers);
        inv.setItem(4,lobbysettings);
        player.openInventory(inv);
    }
}
