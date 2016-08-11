package engine.arbiter.impl;

import engine.arbiter.Arbiter;
import engine.arbiter.util.ArbiterDecisionEngine;
import model.client.Client;
import model.coordinate.Coordinate;
import model.ship.Ship;

/**
 * Specific implementation of {@link Arbiter} dedicated for battleships game
 *
 * @author Ogre
 */
public class BattleshipArbiter implements Arbiter {

    private ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();

    /**
     * @see Arbiter
     */
    @Override
    public void registerShipForClient(Client client, Ship ship) {
        arbiterDecisionEngine.addCoordinatesFromShip(client, ship);
    }

    /**
     * @see Arbiter
     */
    @Override
    public boolean isClientsShipIsHit(Client client, Coordinate hitCoordinate) {
        return arbiterDecisionEngine.isClientsShipIsHit(client, hitCoordinate);
    }

    /**
     * @see Arbiter
     */
    @Override
    public boolean isClientLosing(Client client) {
        return arbiterDecisionEngine.checkLoosingConditionForClient(client);
    }

    /**
     * @see Arbiter
     */
    @Override
    public void clientGaveUp(Client client) {
        arbiterDecisionEngine.cleanUpDataForClient(client);
    }
}
