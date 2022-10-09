package de.rembel.plugin.data;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.io.File;
import java.io.IOException;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class deleteWorlddata {

    public deleteWorlddata(String server, Player player){
        if(player.getWorld().getName().equalsIgnoreCase(server)||player.getWorld().getName().equalsIgnoreCase(server+"_nether")||player.getWorld().getName().equalsIgnoreCase(server+"_end")){
            Location loc = new Location(Bukkit.getWorld("world"),-179.5,41,843.5);
            player.teleport(loc);
            player.setMaxHealth(20);
            for(PotionEffect effect : player.getActivePotionEffects())
            {
                player.removePotionEffect(effect.getType());
            }
            player.setFoodLevel(20);
            player.setGameMode(GameMode.ADVENTURE);
            player.setAllowFlight(true);
            player.getInventory().clear();
        }
        serverconfig.set(server+".health",null);
        serverconfig.set(server+".food",null);
        serverconfig.set(server+".x", null);
        serverconfig.set(server+".y", null);
        serverconfig.set(server+".z", null);
        serverconfig.set(server+".gamemode",null);
        serverconfig.set(server+".status","off");
        serverconfig.set(server+".inventory.content",null);
        serverconfig.set(server+".timer.time",null);
        serverconfig.set(server+".timer.work",null);
        serverconfig.set(server+".timer.pause",null);
        serverconfig.set(server+".dimension",null);
        serverconfig.set(server+".level.l",null);
        serverconfig.set(server+".level.xp",null);
        serverconfig.set(server+".challenge.speed",null);
        serverconfig.set(server+".challenge.maxhealth",null);
        player.setLevel(0);
        player.setExp(0);
        player.setHealth(20);
        try {
            serverconfig.save(serverfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Bukkit.unloadWorld(server, false);

        File data = new File(server+"\\data");
        if (data.exists()) {
            for (File files1 : data.listFiles()) {
                files1.delete();
            }
            data.delete();
        }

        File playerdata = new File(server+"\\entities");
        if (playerdata.exists()) {
            for (File files2 : playerdata.listFiles()) {
                files2.delete();
            }
            playerdata.delete();
        }

        File poi = new File(server+"\\poi");
        if (poi.exists()) {
            for (File files3 : poi.listFiles()) {
                files3.delete();
            }
            poi.delete();
        }

        File region = new File(server+"\\region");
        if (region.exists()) {
            for (File files4 : region.listFiles()) {
                files4.delete();
            }
            region.delete();
        }
        File worldfile = new File(server);
        for (File files5 : worldfile.listFiles()) {
            files5.delete();
        }
        worldfile.delete();








        Bukkit.unloadWorld(server+"_nether", false);

        File data1 = new File(server+"_nether"+"\\DIM-1\\data");
        if (data1.exists()) {
            for (File files1 : data1.listFiles()) {
                files1.delete();
            }
            data1.delete();
        }

        File playerdata1 = new File(server+"_nether"+"\\DIM-1\\entities");
        if (playerdata1.exists()) {
            for (File files2 : playerdata1.listFiles()) {
                files2.delete();
            }
            playerdata1.delete();
        }

        File poi1 = new File(server+"_nether"+"\\DIM-1\\poi");
        if (poi.exists()) {
            for (File files3 : poi1.listFiles()) {
                files3.delete();
            }
            poi1.delete();
        }

        File region1 = new File(server+"_nether"+"\\DIM-1\\region");
        if (region1.exists()) {
            for (File files4 : region1.listFiles()) {
                files4.delete();
            }
            region1.delete();
        }

        File dimfile1 = new File(server+"_nether\\DIM-1");
        dimfile1.delete();

        File worldfile1 = new File(server+"_nether");
        for (File files5 : worldfile1.listFiles()) {
            files5.delete();
        }
        worldfile1.delete();








        Bukkit.unloadWorld(server+"_end", false);

        File data2 = new File(server+"_end"+"\\DIM1\\data");
        if (data2.exists()) {
            for (File files1 : data2.listFiles()) {
                files1.delete();
            }
            data2.delete();
        }

        File playerdata2 = new File(server+"_end"+"\\DIM1\\entities");
        if (playerdata2.exists()) {
            for (File files2 : playerdata2.listFiles()) {
                files2.delete();
            }
            playerdata2.delete();
        }

        File poi2 = new File(server+"_end"+"\\DIM1\\poi");
        if (poi2.exists()) {
            for (File files3 : poi2.listFiles()) {
                files3.delete();
            }
            poi2.delete();
        }

        File region2 = new File(server+"_end"+"\\DIM1\\region");
        if (region2.exists()) {
            for (File files4 : region2.listFiles()) {
                files4.delete();
            }
            region2.delete();
        }

        File dimfile2 = new File(server+"_end\\DIM1");
        dimfile2.delete();

        File worldfile2 = new File(server+"_end");
        for (File files5 : worldfile2.listFiles()) {
            files5.delete();
        }
        worldfile2.delete();

    }
}
