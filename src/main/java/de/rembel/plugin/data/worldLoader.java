package de.rembel.plugin.data;

import org.bukkit.WorldCreator;

import static de.rembel.plugin.data.config.serverconfig;

public class worldLoader {

    public worldLoader(){

        new checkdata();
        if(serverconfig.getString("server1.status").equalsIgnoreCase("on")){
            new WorldCreator("server1").createWorld();
            new WorldCreator("server1_nether").createWorld();
            new WorldCreator("server1_end").createWorld();
        }
        if(serverconfig.getString("server2.status").equalsIgnoreCase("on")){
            new WorldCreator("server2").createWorld();
            new WorldCreator("server2_nether").createWorld();
            new WorldCreator("server2_end").createWorld();
        }
        if(serverconfig.getString("server3.status").equalsIgnoreCase("on")){
            new WorldCreator("server3").createWorld();
            new WorldCreator("server3_nether").createWorld();
            new WorldCreator("server3_end").createWorld();
        }
        if(serverconfig.getString("server4.status").equalsIgnoreCase("on")){
            new WorldCreator("server4").createWorld();
            new WorldCreator("server4_nether").createWorld();
            new WorldCreator("server4_end").createWorld();
        }
        if(serverconfig.getString("server5.status").equalsIgnoreCase("on")){
            new WorldCreator("server5").createWorld();
            new WorldCreator("server5_nether").createWorld();
            new WorldCreator("server5_end").createWorld();
        }
    }
}
