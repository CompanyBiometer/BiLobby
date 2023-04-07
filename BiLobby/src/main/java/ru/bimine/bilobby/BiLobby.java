package ru.bimine.bilobby;

import org.bukkit.plugin.java.JavaPlugin;
import ru.bimine.bilobby.Files.Config;

public final class BiLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[BiLobby] Plugin enable");

        Config.setup();
        if (!Config.get().isSet("tpLogin")) {
            Config.get().set("tpLogin", true);
            Config.get().set("setInvulnerable", true);
            Config.get().createSection("location");
            Config.get().getConfigurationSection("location").set("world", "world");
            Config.get().getConfigurationSection("location").set("x", 0);
            Config.get().getConfigurationSection("location").set("y", 100);
            Config.get().getConfigurationSection("location").set("z", 50);
            Config.get().set("Message", "&eWelcome to best server");
            Config.get().set("JoinMessage", "&ePlayer connect");
            Config.get().set("Title", "&eWelcome");
            Config.get().set("Subtitle", "&eWelcome to BiMine");
        }
        Config.save();

        getServer().getPluginManager().registerEvents(new Lisnteners(), this);

    }
}
