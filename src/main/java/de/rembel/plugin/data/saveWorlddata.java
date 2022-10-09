package de.rembel.plugin.data;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class saveWorlddata {

    private String server = null;

    public saveWorlddata(Player player){
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
        serverconfig.set(server+".health",player.getHealth());
        serverconfig.set(server+".food",player.getFoodLevel());
        serverconfig.set(server+".x",player.getLocation().getX());
        serverconfig.set(server+".y",player.getLocation().getY());
        serverconfig.set(server+".z",player.getLocation().getZ());
        serverconfig.set(server+".timer.work",false);
        serverconfig.set(server+".dimension",player.getWorld().getName());
        serverconfig.set(server+".level.l",player.getLevel());
        serverconfig.set(server+".level.xp",String.valueOf(player.getExp()));
        ArrayList<ItemStack> content = new ArrayList<ItemStack>();
        for(int i = 0;i<player.getInventory().getContents().length;i++){
            content.add(player.getInventory().getContents()[i]);
        }
        serverconfig.set(server+".inventory.content",content);
        if(player.getGameMode() == GameMode.SURVIVAL){
            serverconfig.set(server+".gamemode","survival");
        }
        if(player.getGameMode() == GameMode.CREATIVE){
            serverconfig.set(server+".gamemode","creative");
        }
        if(player.getGameMode() == GameMode.ADVENTURE){
            serverconfig.set(server+".gamemode","adventure");
        }
        if(player.getGameMode() == GameMode.SPECTATOR){
            serverconfig.set(server+".gamemode","spectator");
        }
        try {
            serverconfig.save(serverfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        player.getInventory().clear();
        player.setLevel(0);
        player.setExp(0);
    }
}
