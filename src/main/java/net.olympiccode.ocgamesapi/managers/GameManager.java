package net.olympiccode.ocgamesapi.managers;

import net.olympiccode.ocgamesapi.game.Game;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static GameManager instance;

    public List<Game> activeGames = new ArrayList<>();
    public GameManager() {
        instance = this;
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
