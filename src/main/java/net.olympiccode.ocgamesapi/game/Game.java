package net.olympiccode.ocgamesapi.game;

import org.bukkit.entity.Player;

import java.util.List;

public class Game {
    public List<Player> players;
    public List<Player> spectators;

    public boolean isInGame(Player p) {
        return players.contains(p);
    }

    public boolean isInArena(Player p) {
        return players.contains(p) || spectators.contains(p);
    }

}
