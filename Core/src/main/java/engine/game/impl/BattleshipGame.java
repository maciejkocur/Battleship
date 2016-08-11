package engine.game.impl;

import engine.arbiter.Arbiter;
import engine.arbiter.impl.BattleshipArbiter;
import engine.cache.GameCache;
import engine.cache.impl.BattleshipGameCache;
import engine.game.Game;
import model.client.Client;
import model.ship.Ship;

import java.util.*;

/**
 * Specific implementation of {@link Game} dedicated to create and play battleship game
 *
 * @author Ogre
 */
public class BattleshipGame implements Game {

    GameCache gameCache = BattleshipGameCache.create();
    // how to remove unused arbiters?!
    Map<UUID, Arbiter> arbiters = new HashMap<>();

    /**
     * @see Game
     */
    @Override
    public boolean createGame(UUID gameID, Client client) {
        boolean registerState = gameCache.registerGameIDAndClient(gameID, client);
        if (registerState) {
            arbiters.put(gameID, new BattleshipArbiter());
        }
        return registerState;
    }

    /**
     * @see Game
     */
    @Override
    public Set<UUID> findAvailableGames() {
        return gameCache.getAvailableGames();
    }

    /**
     * @see Game
     */
    @Override
    public boolean joinGame(UUID gameID, Client client) {
        return gameCache.updateExistingGameIDAndAddClient(gameID, client);
    }

    /**
     * @see Game
     */
    @Override
    public boolean leaveGame(UUID gameID, Client client) {
        return gameCache.removeClientFromGame(gameID, client);
    }

    /**
     * @see Game
     */
    @Override
    public boolean abandonGame(UUID gameID, Client client) {
        arbiters.get(gameID).clientGaveUp(client);
        leaveGame(gameID, client);
        return arbiters.get(gameID).isClientLosing(client);
    }

    /**
     * @see Game
     */
    @Override
    public void initClientShips(UUID gameID, Client client, List<Ship> ships) {
        ships.stream().forEach(ship -> arbiters.get(gameID).registerShipForClient(client, ship));
        gameCache.updateClientsStatusToReadyForGameID(gameID, client);
    }
}
