package net.olympiccode.ocgamesapi.managers;

import lombok.Getter;
import net.olympiccode.ocgamesapi.data.Arena;
import net.olympiccode.ocgamesapi.data.ArenaSign;
import net.olympiccode.ocgamesapi.data.ALocation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
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

    public Arena getByName(String s) {
        return Optional.ofNullable(arenas.stream().filter(arena -> arena.getName().equalsIgnoreCase(s)).collect(Collectors.toList()).get(0)).orElse(null);
    }

    public static ArenaManager getInstance() {
        if (instance == null) {
            instance = new ArenaManager();
        }
        return instance;
    }
}
