package engine.arbiter.util;

import model.client.Client;
import model.coordinate.Coordinate;
import model.ship.Ship;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Supportive class which main aim is to support 'making decisions' by {@link engine.arbiter.Arbiter}
 *
 * @author Ogre
 */
public class ArbiterDecisionEngine {

    private static final Logger logger = LogManager.getLogger(ArbiterDecisionEngine.class);
    private Map<Client, List<Coordinate>> clientsCoordinates = new HashMap<>();

    /**
     * Add coordinates from {@link Ship} per {@link Client}
     *
     * @param client representation of a client
     * @param ship   representation of a ship
     */
    public void addCoordinatesFromShip(Client client, Ship ship) {
        if (CollectionUtils.isEmpty(clientsCoordinates.get(client))) {
            logger.debug("There are no ships registered for the client: ".concat(client.showID().toString())
                                 .concat(". Creating new entry"));
            clientsCoordinates.put(client, new ArrayList<>());
        }
        logger.debug("Registering coordinates: ".concat(Arrays.toString(ship.getCoordinates().toArray()))
                             .concat(" , for client: ")
                             .concat(client.showID().toString()));
        clientsCoordinates.get(client).addAll(ship.getCoordinates());
    }

    /**
     * Check if {@link Coordinate} for {@link Client} are present in coordinates cache
     *
     * @param client     representation of a client
     * @param coordinate coordinate which is being searched for
     * @return true if coordinate is present, false if not
     */
    public boolean contains(Client client, Coordinate coordinate) {
        return clientsCoordinates.get(client).contains(coordinate);
    }

    /**
     * Check if {@link Client} lost all his ships and have lost the game
     *
     * @param client representation of a client
     * @return true if client lost all his ships, false if not
     */
    public boolean checkLoosingConditionForClient(Client client) {
        boolean result = CollectionUtils.isEmpty(clientsCoordinates.get(client));
        logger.debug("Checking loosing condition for the client: ".concat(client.showID().toString())
                             .concat(", is loosing ")
                             .concat(String.valueOf(result)));
        return result;
    }

    /**
     * Check if passed {@link Coordinate} (shot) is also one of {@link Client}'s ship coordinates
     *
     * @param client     representation of a client
     * @param coordinate coordinate of move/shot
     * @return true if ship is hit, false if not
     */
    public boolean isClientsShipIsHit(Client client, Coordinate coordinate) {
        boolean result = clientsCoordinates.get(client).remove(coordinate);
        logger.debug("Checking if the client: ".concat(client.showID().toString()).concat(" have ship under ")
                             .concat(coordinate.toString())
                             .concat(" - result: ")
                             .concat(String.valueOf(result)));
        return result;
    }

    /**
     * Clean cache data for {@link Client}
     *
     * @param client representation of a client
     */
    public void cleanUpDataForClient(Client client) {
        logger.debug("Cleaning all cache entries for the client: ".concat(client.showID().toString()));
        clientsCoordinates.get(client).clear();
    }
}
