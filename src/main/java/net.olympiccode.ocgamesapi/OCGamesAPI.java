package net.olympiccode.ocgamesapi;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
@Getter
public class OCGamesAPI {
    static OCGamesAPI instance;
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

    public static OCGamesAPI get() {
        return instance;
    }
}
