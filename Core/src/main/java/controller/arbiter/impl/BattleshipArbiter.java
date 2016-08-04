package controller.arbiter.impl;

import controller.arbiter.Arbiter;
import controller.arbiter.util.ArbiterDecisionEngine;
import model.coordinate.Coordinate;
import model.client.Client;
import model.ship.Ship;

/**
 * Created by lucz on 22.07.16.
 */
public class BattleshipArbiter implements Arbiter {
    private ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();

    @Override
    public void registerShipForClient(Client client, Ship ship) {
        arbiterDecisionEngine.addCoordinatesFromShip(client, ship);
    }

    @Override
    public boolean isHit(Client client, Coordinate hitCoordinate) {
        return arbiterDecisionEngine.isHit(client, hitCoordinate);
    }

    @Override
    public boolean isLosing(Client client) {
        return arbiterDecisionEngine.checkWinningConditionForClient(client);
    }

    @Override
    public void clientGaveUp(Client client) {
        arbiterDecisionEngine.cleanUpDataForClient(client);
    }
}
