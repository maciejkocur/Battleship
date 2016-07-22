package controller.arbiter;

import controller.cache.ShipCache;
import model.coordinate.Coordinate;
import model.player.Player;
import model.ship.Ship;

/**
 * Created by lucz on 22.07.16.
 */
public class Arbiter {
    private ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
    private ShipCache shipCache = new ShipCache();


    public void registerShipForPlayer(Player player, Ship ship) {
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);
        shipCache.registerOrUpdate(ship);
    }

    public boolean isHit(Player player, Coordinate hitCoordinate) {
        return arbiterDecisionEngine.isHit(player, hitCoordinate);
    }
}
