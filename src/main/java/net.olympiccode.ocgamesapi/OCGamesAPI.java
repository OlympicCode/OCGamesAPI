package net.olympiccode.ocgamesapi;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class OCGamesAPI {
    OCGamesAPI instance;
    JavaPlugin plugin;
    String name;

    Logger LOG;

    public OCGamesAPI(JavaPlugin instance, String name) {
        this.instance = this;
        this.name = name != null ? name : "OCG-U" + Math.random();
        this.plugin = instance;
        LOG = Logger.getLogger(name);
        LOG.info("Loading OCGamesAPI for " + name);
    }

    public OCGamesAPI get() {
        return instance;
    }
}
