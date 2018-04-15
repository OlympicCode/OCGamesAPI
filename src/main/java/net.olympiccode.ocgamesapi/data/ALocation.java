package net.olympiccode.ocgamesapi.data;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class ALocation extends Location {
    public ALocation(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public ALocation(World world, double x, double y, double z, float yaw, float pitch) {
        super(world, x, y, z, yaw, pitch);
    }

    public static ALocation fromString(String location) {
        String[] locs = location.split(":");
        if (!(locs.length == 6)) throw new IllegalArgumentException();
        World lworld;
        if ((lworld = Bukkit.getWorld(locs[0])) == null) throw new IllegalArgumentException();
        return new ALocation(lworld, Double.parseDouble(locs[1]), Double.parseDouble(locs[2]), Double.parseDouble(locs[3]), Float.parseFloat(locs[4]), Float.parseFloat(locs[5]));
    }

    public String toString() {
        return getWorld().getName() + ":" + getX() + ":" + getY() + ":" + getZ() + ":" + getYaw() + ":" + getPitch();
    }
}
