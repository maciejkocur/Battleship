package controller.arbiter;

import model.coordinate.Coordinate;
import model.player.Player;
import model.ship.Ship;

/**
 * Created by lucz on 01.08.16.
 */
public interface Arbiter {
    void registerShipForPlayer(Player player, Ship ship);

    boolean isHit(Player player, Coordinate hitCoordinate);
}
