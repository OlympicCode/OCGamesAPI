package net.olympiccode.ocgamesapi;

import org.bukkit.plugin.java.JavaPlugin;

public class OCGamesAPIBuilder {

    JavaPlugin instance;
    String name;
    public OCGamesAPIBuilder setInstance(JavaPlugin instance) {
        this.instance = instance;
        return this;
    }

    public OCGamesAPIBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public OCGamesAPI build() {
        return new OCGamesAPI(instance, name);
    }
}
