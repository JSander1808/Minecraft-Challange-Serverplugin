package de.rembel.plugin.commands;

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

public class updatesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory inv = Bukkit.createInventory(null, 1*9,ChatColor.GOLD+"Updates");
            ItemStack patchnots = new ItemStack(Material.PAPER);
            ItemMeta patchnotsmeta = patchnots.getItemMeta();
            patchnotsmeta.setDisplayName(ChatColor.GREEN+"Request Patchnotes");
            patchnots.setItemMeta(patchnotsmeta);

            ItemStack download = new ItemStack(Material.BEACON);
            ItemMeta downloadmeta = download.getItemMeta();
            downloadmeta.setDisplayName(ChatColor.GREEN+"Download Update");
            download.setItemMeta(downloadmeta);

            inv.setItem(2,patchnots);
            inv.setItem(6,download);

            player.openInventory(inv);
        }
        return false;
    }
}
