package net.olympiccode.ocgamesapi.arenas;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.olympiccode.ocgamesapi.game.Game;
import net.olympiccode.ocgamesapi.signs.ArenaSign;
import net.olympiccode.ocgamesapi.teams.Team;
import net.olympiccode.ocgamesapi.utils.ALocation;

import java.util.HashMap;
import java.util.List;

public class Arena {
    private Game game;

    private List<ArenaSign> signs;

    private ALocation lobby;
    private HashMap<Team, ALocation> spawns;

    public Game getGame() {
        return game;
    }

    public List<ArenaSign> getSigns() {
        return signs;
    }

    public void loadFromJson(JsonObject object) {
        // Basic
        this.lobby = ALocation.fromString(object.get("lobby").getAsString());

        // Spawns
        JsonObject jspawns = object.getAsJsonObject("spawns");
        jspawns.entrySet().forEach(stringJsonElementEntry ->
                spawns.put(Team.fromString(stringJsonElementEntry.getKey()), ALocation.fromString(stringJsonElementEntry.getValue().getAsString())));

        // Signs
        object.getAsJsonArray("sgins").forEach(jsonElement -> signs.add(ArenaSign.fromString(jsonElement.getAsString())));
    }

    public void saveToJson() {
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
    }
}
