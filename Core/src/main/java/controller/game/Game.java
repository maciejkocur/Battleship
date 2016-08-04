package controller.game;

import model.client.Client;
import model.ship.Ship;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by lucz on 04.08.16.
 */
public interface Game {

    boolean createGame(UUID gameID, Client client);

    Set<UUID> findAvailableGames();

    boolean joinGame(UUID gameID, Client client);

    boolean abandonGame(UUID gameID, Client client);

    void initClientShips(UUID gameID, Client client, List<Ship> ships);
}
