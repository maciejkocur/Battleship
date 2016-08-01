package controller.arbiter.impl;

import controller.arbiter.ArbiterDecisionEngine;
import controller.arbiter.GameArbiter;
import model.coordinate.Coordinate;
import model.player.Player;
import model.ship.GameShip;

/**
 * Created by lucz on 22.07.16.
 */
public class Arbiter implements GameArbiter {
    private ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();

    @Override
    public void registerShipForPlayer(Player player, GameShip ship) {
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);
    }

    @Override
    public boolean isHit(Player player, Coordinate hitCoordinate) {
        return arbiterDecisionEngine.isHit(player, hitCoordinate);
    }
}
