package net.olympiccode.ocgamesapi;

import lombok.Getter;
import net.olympiccode.ocgamesapi.config.ArenaStore;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
@Getter
public class OCGamesAPI {
    static OCGamesAPI instance;
    JavaPlugin plugin;
    String name;

    Logger LOG;

    public OCGamesAPI(JavaPlugin instance, String name) {
        OCGamesAPI.instance = this;
        this.name = name != null ? name : "OCG-U" + Math.random();
        this.plugin = instance;
        LOG = Logger.getLogger(name);
        LOG.info("Loading OCGamesAPI for " + name);
        start();
    }

    public void start() {
       new ArenaStore().loadArenas();
    }
    public static OCGamesAPI get() {
        return instance;
    }
}
