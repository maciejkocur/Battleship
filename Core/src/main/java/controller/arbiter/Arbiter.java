package controller.arbiter;

import model.coordinate.Coordinate;
import model.client.Client;
import model.ship.Ship;

/**
 * Created by lucz on 01.08.16.
 */
public interface Arbiter {
    void registerShipForClient(Client client, Ship ship);

    boolean isHit(Client client, Coordinate hitCoordinate);

    boolean isLosing(Client client);

    void clientGaveUp(Client client);
}
