package controller.arbiter;

import model.coordinate.Coordinate;
import model.player.Player;
import model.ship.GameShip;

/**
 * Created by lucz on 01.08.16.
 */
public interface GameArbiter {
    void registerShipForPlayer(Player player, GameShip ship);

    boolean isHit(Player player, Coordinate hitCoordinate);
}
