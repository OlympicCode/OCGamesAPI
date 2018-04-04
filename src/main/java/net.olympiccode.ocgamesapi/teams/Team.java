package net.olympiccode.ocgamesapi.teams;

import lombok.Data;
import org.bukkit.ChatColor;

@Data
public class Team {

    ChatColor color;
    String prefix;

    public Team(ChatColor color) {
        this.color = color;
    }

    public Team(ChatColor color, String prefix) {
        this.color = color;
        this.prefix = prefix;
    }

    public String toString() {
        return color.toString() + ":" + prefix;
    }

    public static Team fromString(String s) {
        String[] split = s.split(":");
        return new Team(ChatColor.valueOf(split[0]), split[1]);
    }

}
