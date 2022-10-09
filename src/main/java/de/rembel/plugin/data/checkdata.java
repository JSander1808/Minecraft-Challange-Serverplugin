package de.rembel.plugin.data;

import java.io.IOException;

import static de.rembel.plugin.data.config.*;

public class checkdata {

    public checkdata(){
        if(!serverfile.exists()){
            try {
                serverdic.mkdirs();
                serverfile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(serverconfig.getString("server1.status")==null){
            serverconfig.set("server1.status","off");
        }
        if(serverconfig.getString("server2.status")==null){
            serverconfig.set("server2.status","off");
        }
        if(serverconfig.getString("server3.status")==null){
            serverconfig.set("server3.status","off");
        }
        if(serverconfig.getString("server4.status")==null){
            serverconfig.set("server4.status","off");
        }
        if(serverconfig.getString("server5.status")==null){
            serverconfig.set("server5.status","off");
        }
        try {
            serverconfig.save(serverfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
