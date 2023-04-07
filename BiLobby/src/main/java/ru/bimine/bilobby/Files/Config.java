package ru.bimine.bilobby.Files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private static File file;
    private static FileConfiguration Translations;


    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("BiLobby").getDataFolder(), "config.yml");

        if (file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                System.out.println("[BiLobby] Error create file");
            }
        }
        Translations = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return Translations;
    }

    public static void save(){
        try {
            Translations.save(file);
        } catch (IOException e){
            System.out.println("[BiLobby] Coundn't save file");
        }

    }

    public static void reload(){
        Translations = YamlConfiguration.loadConfiguration(file);
    }

}
