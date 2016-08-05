package controller.cache.impl;

import controller.cache.GameCache;
import controller.cache.util.GameCacheValidator;
import model.client.Client;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by lucz on 02.08.16.
 */
public class BattleshipGameCache implements GameCache {

    Map<UUID, Set<Client>> gamesCache = new HashMap<>();

    @Override
    public boolean registerGameIDAndClient(UUID gameID, Client client) {
        return GameCacheValidator.validateAndRegisterGameID(gamesCache, gameID, client);
    }

    @Override
    public boolean updateExistingGameID(UUID gameID, Client client) {
        return GameCacheValidator.validateAndAddNewClientToGameID(gamesCache, gameID, client);
    }

    @Override
    public void updateClientsStatusToReadyForGameID(UUID gameID, Client client) {
        if (!CollectionUtils.isEmpty(gamesCache.get(gameID))){
            gamesCache.get(gameID).stream().filter(c -> c.equals(client)).findFirst().get().ready();
        }
    }

    @Override
    public void updateClientsStatusToNotReadyForGameID(UUID gameID, Client client) {
        if (!CollectionUtils.isEmpty(gamesCache.get(gameID))){
            gamesCache.get(gameID).stream().filter(c -> c.equals(client)).findFirst().get().notReady();
        }
    }

    @Override
    public Set<Client> getCachedClients(UUID gameID) {
        return gamesCache.get(gameID);
    }

    @Override
    public Set<UUID> getAvailableGames(){
        return gamesCache.keySet().stream().filter(key -> gamesCache.get(key).size()<2).collect(Collectors.toSet());
    }
}
