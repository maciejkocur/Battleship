package controller.arbiter.impl;

import controller.arbiter.Arbiter;
import model.coordinate.Coordinate;
import model.player.Player;
import model.ship.Ship;

/**
 * Created by lucz on 22.07.16.
 */
public class BattleshipArbiter implements Arbiter {
    private ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();

    @Override
    public void registerShipForPlayer(Player player, Ship ship) {
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);
    }

    @Override
    public boolean isHit(Player player, Coordinate hitCoordinate) {
        return arbiterDecisionEngine.isHit(player, hitCoordinate);
    }
}
