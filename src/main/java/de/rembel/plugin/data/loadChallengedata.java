package de.rembel.plugin.data;

import de.rembel.plugin.menus.settingsMenu;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class loadChallengedata {

    public loadChallengedata(Player player){
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

        for(PotionEffect effect : player.getActivePotionEffects())
        {
            player.removePotionEffect(effect.getType());
        }
        player.setMaxHealth(serverconfig.getDouble(server+".challenge.maxhealth"));
        player.setHealth(serverconfig.getInt(server+".challenge.maxhealth"));
        if(serverconfig.getInt(server+".challenge.speed")!=0){
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999999, serverconfig.getInt(server+".challenge.speed"), true, false));
        }
    }
}
