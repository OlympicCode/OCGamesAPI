package net.olympiccode.ocgamesapi.game;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.List;

@Getter
public class Game {
    public List<Player> players;
    public List<Player> spectators;

    public GameState state;


    public boolean isInGame(Player p) {
        return players.contains(p);
    }

    public boolean isInArena(Player p) {
        return players.contains(p) || spectators.contains(p);
    }

}
