package de.rembel.plugin.commands;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static de.rembel.plugin.data.config.serverconfig;
import static de.rembel.plugin.data.config.serverfile;

public class timerCommand implements CommandExecutor {

    public static String server = null;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
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
            if(args[0].equalsIgnoreCase("start")){
                if(serverconfig.getString(server+".timer.work").equalsIgnoreCase("false")){
                    serverconfig.set(server+".timer.work","true");
                    serverconfig.set(server+".gamesmode","survival");
                    player.setGameMode(GameMode.SURVIVAL);
                    try {
                        serverconfig.save(serverfile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                    Thread timer = new Thread(() -> {
                        while(serverconfig.getString(server+".timer.work").equalsIgnoreCase("true")){
                            int time = serverconfig.getInt(server+".timer.time");
                            if(serverconfig.getString(server +".timer.pause").equalsIgnoreCase("false")){
                                int hour = time / 3600;
                                int minute = time / 60 % 60;
                                int second = time % 60;
                                StringBuilder message = new StringBuilder(ChatColor.GOLD+"Timer: ");
                                message.append(String.format("%02d",hour)).append(":");
                                message.append(String.format("%02d",minute)).append(":");
                                message.append(String.format("%02d",second));
                                time++;
                                serverconfig.set(server+".timer.time",time);
                                try {
                                    serverconfig.save(serverfile);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                for(Player p : Bukkit.getWorld(server).getPlayers()){
                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.toString()));
                                }
                                for(Player p : Bukkit.getWorld(server+"_nether").getPlayers()){
                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.toString()));
                                }
                                for(Player p : Bukkit.getWorld(server+"_end").getPlayers()){
                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.toString()));
                                }
                            }else{
                                for(Player p : Bukkit.getWorld(server).getPlayers()){
                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GOLD+"Timer Paused"));
                                }
                                for(Player p : Bukkit.getWorld(server+"_nether").getPlayers()){
                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GOLD+"Timer Paused"));
                                }
                                for(Player p : Bukkit.getWorld(server+"_end").getPlayers()){
                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GOLD+"Timer Paused"));
                                }
                            }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });


                    timer.start();
                }
            }

            if(args[0].equalsIgnoreCase("stop")){
                serverconfig.set(server+".timer.pause","true");
                serverconfig.set(server+".gamesmode","adventure");
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ChatColor.GOLD+"Timer resume with: "+ChatColor.GREEN+"/timer resume");
            }
            if(args[0].equalsIgnoreCase("resume")){
                serverconfig.set(server+".timer.pause","false");
                serverconfig.set(server+".gamesmode","survival");
                player.setGameMode(GameMode.SURVIVAL);
            }
        }
        return false;
    }
}
