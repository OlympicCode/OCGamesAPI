package net.olympiccode.ocgamesapi.signs;

import net.olympiccode.ocgamesapi.utils.ALocation;

public class ArenaSign {
    String arena;
    ALocation location;

    public String toString() {
        return arena + ";" + location.toString();
    }

    public static ArenaSign fromString(String string) {
        String[] s = string.split(";");
        return new ArenaSign(s[0], ALocation.fromString(s[1]));
    }

    public ArenaSign(String arena, ALocation location) {
        this.arena = arena;
        this.location = location;
    }

    public String getArena() {
        return arena;
    }

    public ALocation getLocation() {
        return location;
    }
}
