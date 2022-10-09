package de.rembel.plugin.data;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


import java.util.ArrayList;

import static de.rembel.plugin.data.config.serverconfig;

public class loadWorlddata {

    public loadWorlddata(String server, Player player){
        Location loc = new Location(Bukkit.getWorld(serverconfig.getString(server+".dimension")),serverconfig.getDouble(server+".x"),serverconfig.getDouble(server+".y"),serverconfig.getDouble(server+".z"));
        player.teleport(loc);
        player.setHealth(serverconfig.getDouble(server+".health"));
        player.setFoodLevel(serverconfig.getInt(server+".food"));
        player.setExp(Float.parseFloat(serverconfig.getString(server+".level.xp")));
        player.setLevel(serverconfig.getInt(server+".level.l"));
        if(serverconfig.getString(server+".gamemode").equalsIgnoreCase("survival")){
            player.setGameMode(GameMode.ADVENTURE);
        }
        if(serverconfig.getString(server+".gamemode").equalsIgnoreCase("adventure")){
            player.setGameMode(GameMode.ADVENTURE);
        }
        if(serverconfig.getString(server+".gamemode").equalsIgnoreCase("creative")){
            player.setGameMode(GameMode.CREATIVE);
        }
        if(serverconfig.getString(server+".gamemode").equalsIgnoreCase("spectator")){
            player.setGameMode(GameMode.SPECTATOR);
        }
        new loadChallengedata(player);
        ArrayList<ItemStack> items = (ArrayList<ItemStack>) serverconfig.getList(server+".inventory.content");
        ItemStack[] content = new ItemStack[items.size()];
        for(int i = 0;i<items.size();i++){
            content[i] = items.get(i);
        }
        player.getInventory().setContents(content);
    }
}
