package controller.game.impl;

import controller.arbiter.Arbiter;
import controller.arbiter.impl.BattleshipArbiter;
import controller.cache.GameCache;
import controller.cache.impl.BattleshipGameCache;
import controller.game.Game;
import model.client.Client;
import model.ship.Ship;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by lucz on 01.08.16.
 */
public class BattleshipGame implements Game{

    GameCache gameCache = new BattleshipGameCache();
    Arbiter arbiter = new BattleshipArbiter();

    @Override
    public boolean createGame(UUID gameID, Client client) {
        return gameCache.registerGameIDAndClient(gameID, client);
    }

    @Override
    public Set<UUID> findAvailableGames() {
        return gameCache.getAvailableGames();
    }

    @Override
    public boolean joinGame(UUID gameID, Client client) {
        return gameCache.updateExistingGameID(gameID, client);
    }

    @Override
    public boolean abandonGame(UUID gameID, Client client) {
        arbiter.clientGaveUp(client);
        return arbiter.isLosing(client);
    }

    @Override
    public void initClientShips(UUID gameID, Client client, List<Ship> ships) {
        ships.stream().forEach(ship -> arbiter.registerShipForClient(client, ship));
        gameCache.updateClientsStatusToReadyForGameID(gameID, client);
    }
}
