package controller.arbiter.util;

import model.client.Client;
import model.coordinate.Coordinate;
import model.ship.Ship;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArbiterDecisionEngine {

    private Map<Client, List<Coordinate>> clientsCoordinates = new HashMap<>();

    public void addCoordinatesFromShip(Client client, Ship ship) {
        if (CollectionUtils.isEmpty(clientsCoordinates.get(client)))
            clientsCoordinates.put(client, new ArrayList<>());
        clientsCoordinates.get(client).addAll(ship.getCoordinates());
    }

    public boolean contains(Client client, Coordinate coordinate) {
        return clientsCoordinates.get(client).contains(coordinate);
    }

    public boolean checkWinningConditionForClient(Client client) {
        return CollectionUtils.isEmpty(clientsCoordinates.get(client));
    }

    public boolean isHit(Client client, Coordinate coordinate) {
        return clientsCoordinates.get(client).remove(coordinate);
    }

    public void cleanUpDataForClient(Client client) {
        clientsCoordinates.get(client).clear();
    }
}
