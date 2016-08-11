package engine.cache.util;

import model.client.Client;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Validates and updates game cache. Main aim is to prevent situation that more than two players are signed to one game
 *
 * @author Ogre
 */
public class GameCacheValidator {

    private static final Logger logger = LogManager.getLogger(GameCacheValidator.class);

    /**
     * Validate if game id is not present in cache and if not put new game id (key) and Set of one {@link Client} (value) into cache.
     * If game id is present return false.
     *
     * @param gamesCache cache of games ids and Sets of clients under them
     * @param gameID     game id to register
     * @param client     client to register under game id
     * @return true if game id is not present in cache and create new set of clients, if game id is present return false
     */
    public static boolean validateAndRegisterGameID(Map<UUID, Set<Client>> gamesCache, UUID gameID, Client client) {
        if (CollectionUtils.isEmpty(gamesCache.get(gameID))) {
            logger.debug("Creating new gameID entry and adding first client: ".concat(client.showID().toString()));
            gamesCache.put(gameID, new HashSet<>());
            return gamesCache.get(gameID).add(client);
        }
        logger.warn("Tried to register existing gameID second time!");
        return false;

    }

    /**
     * Validate if game id is present in cache and update Set of clients by adding new {@link Client}.
     * Method does not allow to put more than two clients under one game id
     *
     * @param gamesCache cache of game ids and Sets of clients under them
     * @param gameID     game id to update
     * @param client     client to add
     * @return true if game id is present in cache and update is successful, if game id is not present or update fails return false
     */
    public static boolean validateAndAddNewClientToGameID(Map<UUID, Set<Client>> gamesCache, UUID gameID, Client client) {
        if (!CollectionUtils.isEmpty(gamesCache.get(gameID)) && gamesCache.get(gameID).size() < 2) {
            logger.debug("Updating gameID. Adding client: ".concat(client.showID().toString()));
            return gamesCache.get(gameID).add(client);
        }
        logger.warn("GameID do not exist or tried to add more than two clients to one gameID");
        return false;
    }

}
