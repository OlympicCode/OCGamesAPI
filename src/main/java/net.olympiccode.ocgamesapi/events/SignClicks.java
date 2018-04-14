package net.olympiccode.ocgamesapi.events;

import net.olympiccode.ocgamesapi.arenas.Arena;
import net.olympiccode.ocgamesapi.arenas.ArenaManager;
import net.olympiccode.ocgamesapi.game.GameState;
import net.olympiccode.ocgamesapi.signs.ArenaSign;
import net.olympiccode.ocgamesapi.utils.ALocation;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignClicks implements Listener {

    @EventHandler
    public void click(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (isValid(e)) {
            ArenaSign sign;
            if ((sign = ArenaManager.instance.getSignAt((ALocation) e.getClickedBlock().getLocation())) != null) {
                Arena a = sign.getArena();
                if (a.getGame().getState().equals(GameState.READY) || a.getGame().getState().equals(GameState.PRE_GAME)) {

                }
            }
        }
    }

    boolean isValid(PlayerInteractEvent e) {
        return e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST);
    }
}
