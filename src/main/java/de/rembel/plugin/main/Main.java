package de.rembel.plugin.main;

import de.rembel.plugin.commands.*;
import de.rembel.plugin.data.worldLoader;
import de.rembel.plugin.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new worldLoader();
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(),this);
        pluginManager.registerEvents(new gamesMenuListener(),this);
        pluginManager.registerEvents(new serversMenuListener(),this);
        pluginManager.registerEvents(new QuitListener(),this);
        pluginManager.registerEvents(new playerDeathListener(),this);
        pluginManager.registerEvents(new worldInitListener(),this);
        pluginManager.registerEvents(new PostalListener(),this);
        pluginManager.registerEvents(new entitieKillListener(),this);
        pluginManager.registerEvents(new serverListPingListener(),this);
        pluginManager.registerEvents(new updateMenuListener(),this);
        pluginManager.registerEvents(new settingsMenuListener(),this);

        getCommand("games").setExecutor(new gamesCommand());
        getCommand("lobby").setExecutor(new lobbyCommand());
        getCommand("timer").setExecutor(new timerCommand());
        getCommand("reset").setExecutor(new resetCommand());
        getCommand("update").setExecutor(new updatesCommand());
        getCommand("settings").setExecutor(new settingsCommand());
        for(Player player : Bukkit.getOnlinePlayers()){
            player.kickPlayer("Server is reloading.");
        }
    }

    @Override
    public void onDisable() {

    }
}
