package net.olympiccode.ocgamesapi.config;

import com.google.gson.JsonParser;
import net.olympiccode.ocgamesapi.OCGamesAPI;
import net.olympiccode.ocgamesapi.data.Arena;
import net.olympiccode.ocgamesapi.managers.ArenaManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ArenaStore {

    public ArenaStore() {

    }

    public void loadArenas() {
        File arenaFolder = new File(OCGamesAPI.get().getPlugin().getDataFolder() + "/arenas");
        for (File file : arenaFolder.listFiles()) {
            if (file.getName().endsWith(".json")) {
                try {
                    String content = Files.readAllLines(Paths.get(file.getPath())).stream().collect(Collectors.joining());
                    ArenaManager manager = ArenaManager.getInstance();
                    Arena arena = new Arena().loadFromJson(file.getName().replace(".json", ""), new JsonParser().parse(content).getAsJsonObject());
                    manager.getArenas().add(arena);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveArenas() {
        File arenaFolder = new File(OCGamesAPI.get().getPlugin().getDataFolder() + "/arenas");
        ArenaManager manager = ArenaManager.getInstance();
        manager.getArenas().forEach(arena -> {
            File file = new File(arenaFolder.getPath() + "/" + arena.getName() + ".json");
            try {
                Files.write(Paths.get(file.getPath()), arena.saveToJson().toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
