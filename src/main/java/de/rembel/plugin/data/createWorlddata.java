package de.rembel.plugin.data;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.IOException;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class createWorlddata {

    public createWorlddata(String server){
        WorldCreator creatornormal = new WorldCreator(server);
        Bukkit.createWorld(creatornormal);
        WorldCreator creatornether = new WorldCreator(server+"_nether");
        creatornether.environment(World.Environment.NETHER);
        Bukkit.createWorld(creatornether);
        WorldCreator creatorend = new WorldCreator(server+"_end");
        creatorend.environment(World.Environment.THE_END);
        Bukkit.createWorld(creatorend);
        serverconfig.set(server+".health",20);
        serverconfig.set(server+".food",20);
        serverconfig.set(server+".x", Bukkit.getWorld(server).getSpawnLocation().getX());
        serverconfig.set(server+".y", Bukkit.getWorld(server).getSpawnLocation().getY());
        serverconfig.set(server+".z", Bukkit.getWorld(server).getSpawnLocation().getZ());
        serverconfig.set(server+".gamemode","adventure");
        serverconfig.set(server+".inventory.content",null);
        serverconfig.set(server+".timer.time",0);
        serverconfig.set(server+".timer.work","false");
        serverconfig.set(server+".timer.pause","false");
        serverconfig.set(server+".dimension",server);
        serverconfig.set(server+".level.l",0);
        serverconfig.set(server+".level.xp","0.0");
        serverconfig.set(server+".challenge.maxhealth",20);
        serverconfig.set(server+".challenge.speed",0);
        try {
            serverconfig.save(serverfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
