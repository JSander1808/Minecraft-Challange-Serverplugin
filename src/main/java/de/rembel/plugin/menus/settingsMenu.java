package de.rembel.plugin.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static de.rembel.plugin.data.config.serverconfig;

public class settingsMenu {

    public settingsMenu(Player player, String server){
        Inventory inv = Bukkit.createInventory(null,5*9, ChatColor.GOLD+"Challenges");

        ItemStack speedup = new ItemStack(Material.LIME_DYE);
        ItemMeta speedupmeta = speedup.getItemMeta();
        speedupmeta.setDisplayName(ChatColor.GREEN+"Speed +1");
        speedup.setItemMeta(speedupmeta);

        ItemStack speed = new ItemStack(Material.ARROW);
        ItemMeta speedmeta = speed.getItemMeta();
        speedmeta.setDisplayName(ChatColor.GOLD+"Speed Challenge");
        ArrayList speedlore = new ArrayList();
        speedlore.add(ChatColor.GREEN+"Currently Speed: "+serverconfig.getInt(server+".challenge.speed"));
        speedmeta.setLore(speedlore);
        speed.setItemMeta(speedmeta);

        ItemStack speeddown = new ItemStack(Material.RED_DYE);
        ItemMeta speeddownmeta = speeddown.getItemMeta();
        speeddownmeta.setDisplayName(ChatColor.RED+"Speed -1");
        speeddown.setItemMeta(speeddownmeta);

        ItemStack healthup = new ItemStack(Material.LIME_DYE);
        ItemMeta healthupmeta = healthup.getItemMeta();
        healthupmeta.setDisplayName(ChatColor.GREEN+"Maxhealth +1");
        healthup.setItemMeta(healthupmeta);

        ItemStack health = new ItemStack(Material.SHIELD);
        ItemMeta healthmeta = health.getItemMeta();
        healthmeta.setDisplayName(ChatColor.GOLD+"Health Challenge");
        ArrayList healthlore = new ArrayList();
        healthlore.add(ChatColor.GREEN+"1 heart = 2 Healthpoint");
        healthlore.add(ChatColor.GREEN+"Currently Health: "+serverconfig.getInt(server+".challenge.maxhealth"));
        healthmeta.setLore(healthlore);
        health.setItemMeta(healthmeta);

        ItemStack healthdown = new ItemStack(Material.RED_DYE);
        ItemMeta healthdownmeta = healthdown.getItemMeta();
        healthdownmeta.setDisplayName(ChatColor.RED+"Maxhealth -1");
        healthdown.setItemMeta(healthdownmeta);


        inv.setItem(0,speedup);
        inv.setItem(9,speed);
        inv.setItem(18,speeddown);
        inv.setItem(1,healthup);
        inv.setItem(10,health);
        inv.setItem(19,healthdown);

        player.openInventory(inv);
    }
}
