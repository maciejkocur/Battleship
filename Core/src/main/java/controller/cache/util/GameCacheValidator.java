package controller.cache.util;

import model.client.Client;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by lucz on 02.08.16.
 */
public class GameCacheValidator {

    public static boolean validateAndRegisterGameID(Map<UUID, Set<Client>> gamesCache, UUID gameID, Client client) {
        if (CollectionUtils.isEmpty(gamesCache.get(gameID)))
            gamesCache.put(gameID, new HashSet<>());
        return gamesCache.get(gameID).add(client);

    }

    public static boolean validateAndAddNewClientToGameID(Map<UUID, Set<Client>> gamesCache, UUID gameID, Client client){
        if (!CollectionUtils.isEmpty(gamesCache.get(gameID)) && gamesCache.get(gameID).size()<2)
            return gamesCache.get(gameID).add(client);
        return false;
    }

}
