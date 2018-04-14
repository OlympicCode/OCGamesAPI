package net.olympiccode.ocgamesapi.signs;

import lombok.Getter;
import net.olympiccode.ocgamesapi.arenas.Arena;
import net.olympiccode.ocgamesapi.utils.ALocation;

@Getter
public class ArenaSign {
    Arena arena;
    ALocation location;

    public String toString() {
        return arena + ";" + location.toString();
    }

    public static ArenaSign fromString(Arena arena, String string) {
        String[] s = string.split(";");
        return new ArenaSign(arena, ALocation.fromString(s[1]));
    }

    public ArenaSign(Arena arena, ALocation location) {
        this.arena = arena;
        this.location = location;
    }
}
