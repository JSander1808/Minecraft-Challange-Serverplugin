package de.rembel.plugin.data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

public class config {
    public static File serverdic = new File("saves//server//");
    public static File serverfile = new File("saves//server//stats.txt");
    public static YamlConfiguration serverconfig = YamlConfiguration.loadConfiguration(serverfile);
}
