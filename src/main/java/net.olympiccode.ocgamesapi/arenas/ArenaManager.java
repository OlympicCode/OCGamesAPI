package net.olympiccode.ocgamesapi.arenas;

import net.olympiccode.ocgamesapi.signs.ArenaSign;
import net.olympiccode.ocgamesapi.utils.ALocation;

import java.util.List;

public class ArenaManager {
    public List<Arena> arenas;

    public static ArenaManager instance;
    public ArenaSign getSignAt(ALocation loc) {
        for (Arena arena : arenas) {
            for (ArenaSign arenaSign : arena.getSigns()) {
                if (arenaSign.getLocation().equals(loc)) return arenaSign;
            }
        }
        return null;
    }

    public ArenaManager getInstance() {
        if (instance == null) {
            instance = new ArenaManager();
        }
        return instance;
    }
}
