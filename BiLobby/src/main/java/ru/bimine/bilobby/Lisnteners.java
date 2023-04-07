package ru.bimine.bilobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.bimine.bilobby.Files.Config;

public class Lisnteners implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Config.get().getBoolean("tpLogin")) {
            player.teleport(new Location(Bukkit.getWorld(Config.get().getConfigurationSection("location").getString("world")), Config.get().getConfigurationSection("location").getDouble("x"), Config.get().getConfigurationSection("location").getDouble("y"), Config.get().getConfigurationSection("location").getDouble("z")));
        }
        player.setInvulnerable(Config.get().getBoolean("setInvulnerable"));
        player.sendTitle(Config.get().getString("Title").replace("&", "§"), Config.get().getString("Subtitle").replace("&", "§"));
        player.sendMessage(Config.get().getString("Message").replace("&", "§"));
        event.setJoinMessage(Config.get().getString("JoinMessage").replace("&", "§"));
    }
}
