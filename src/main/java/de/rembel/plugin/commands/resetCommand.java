package de.rembel.plugin.commands;

import de.rembel.plugin.data.createWorlddata;
import de.rembel.plugin.data.deleteWorlddata;
import de.rembel.plugin.data.loadChallengedata;
import de.rembel.plugin.data.loadWorlddata;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class resetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
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
            //int speedchallenge = serverconfig.getInt(server+".challenge.speed");
            //int maxhealthchallenge = serverconfig.getInt(server+".challenge.maxhealth");
            new deleteWorlddata(server, player);
            player.setMaxHealth(20);
            player.setHealth(20);
            serverconfig.set(server+".status","on");
            WorldCreator creatornormal = new WorldCreator(server);
            Bukkit.createWorld(creatornormal);
            WorldCreator creatornether = new WorldCreator(server+"_nether");
            creatornether.environment(World.Environment.NETHER);
            Bukkit.createWorld(creatornether);
            WorldCreator creatorend = new WorldCreator(server+"_end");
            creatorend.environment(World.Environment.THE_END);
            Bukkit.createWorld(creatorend);
            new createWorlddata(server);
            //serverconfig.set(server+".challenge.speed",speedchallenge);
           // serverconfig.set(server+".challenge.maxhealth",maxhealthchallenge);
            new loadWorlddata(server, player);
        }
        return false;
    }
}
