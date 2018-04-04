package net.olympiccode.ocgamesapi.game;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static GameManager instance;

    public List<Game> activeGames = new ArrayList<>();
    public GameManager() {
        this.instance = this;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public boolean isInArena(Player p) {
        for (Game activeGame : activeGames) {
            if (activeGame.isInArena(p)) return true;
        }
        return false;
    }
}
