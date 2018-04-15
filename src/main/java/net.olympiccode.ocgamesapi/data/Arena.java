package net.olympiccode.ocgamesapi.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;
import net.olympiccode.ocgamesapi.game.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class Arena {
    private Game game;


    private List<ArenaSign> signs;

    private String name;
    private String prettyName;
    private ALocation lobby;
    private HashMap<Team, List<ALocation>> spawns;

    public Arena loadFromJson(String name, JsonObject object) {
        // Basic
        this.lobby = ALocation.fromString(object.get("lobby").getAsString());
        this.name = name;

        // Spawns
        JsonObject jspawns = object.getAsJsonObject("spawns");
        jspawns.entrySet().forEach(stringJsonElementEntry -> {
                    Team t = Team.fromString(stringJsonElementEntry.getKey());
                    ALocation loc = ALocation.fromString(stringJsonElementEntry.getValue().getAsString());
                    if (spawns.containsKey(t)) {
                        spawns.get(t).add(loc);
                    } else {
                        List<ALocation> l = new ArrayList<>();
                        l.add(loc);
                        spawns.put(t, l);
                    }
                }
        );

        // Signs
        object.getAsJsonArray("sgins").forEach(jsonElement -> signs.add(ArenaSign.fromString(this, jsonElement.getAsString())));
        return this;
    }

    public JsonObject saveToJson() {
        // Basic
        JsonObject object = new JsonObject();
        object.addProperty("lobby", lobby.toString());

        // Spawns
        JsonObject jspawns = new JsonObject();
        spawns.forEach((team, aLocation) -> jspawns.addProperty(team.toString(), aLocation.toString()));
        object.add("spawns", jspawns);

        // Signs
        JsonArray jsigns = new JsonArray();
        signs.forEach(arenaSign -> jsigns.add(arenaSign.toString()));

        return object;
    }
}
