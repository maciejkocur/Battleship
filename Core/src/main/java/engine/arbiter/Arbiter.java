package engine.arbiter;

import model.client.Client;
import model.coordinate.Coordinate;
import model.ship.Ship;

/**
 * Responsible for internal game behaviour - in general 'decides' who wins
 *
 * @author Ogre
 */
public interface Arbiter {

    /**
     * Register coordinates from {@link Ship} for specified {@link Client}
     *
     * @param client representation of a client
     * @param ship   representation of ship which contains coordinates
     */
    void registerShipForClient(Client client, Ship ship);

    /**
     * Check if passed {@link Coordinate} (shot) is also one of {@link Client}'s ship coordinate.
     *
     * @param client        representation of a client
     * @param hitCoordinate coordinate of move/shot
     * @return true if ship is hit, false if not
     */
    boolean isClientsShipIsHit(Client client, Coordinate hitCoordinate);

    /**
     * Check if {@link Client} is loosing the game
     *
     * @param client representation of a client
     * @return true if client is loosing, false if not
     */
    boolean isClientLosing(Client client);

    /**
     * Allows {@link Client} to leave the game before game ends
     *
     * @param client representation of a client
     */
    void clientGaveUp(Client client);
}
