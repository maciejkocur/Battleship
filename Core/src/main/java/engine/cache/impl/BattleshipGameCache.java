package engine.cache.impl;

import engine.cache.GameCache;
import engine.cache.util.GameCacheValidator;
import model.client.Client;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Specific implementation of {@link GameCache} dedicated to cache gameIDs and clients bound to particular gameID
 *
 * @author Ogre
 */
public class BattleshipGameCache implements GameCache {

    private static final Logger logger = LogManager.getLogger(BattleshipGameCache.class);
    Map<UUID, Set<Client>> gamesCache = new HashMap<>();

    private BattleshipGameCache() {}

    /**
     * Factory method to create object of class
     *
     * @return new {@link BattleshipGameCache} object
     */
    public static BattleshipGameCache create() {
        return new BattleshipGameCache();
    }

    /**
     * @see GameCache
     */
    @Override
    public boolean registerGameIDAndClient(UUID gameID, Client client) {
        logger.debug("Checking if gameID: ".concat(gameID.toString()).concat(" exists in cache"));
        return GameCacheValidator.validateAndRegisterGameID(gamesCache, gameID, client);
    }

    /**
     * @see GameCache
     */
    @Override
    public boolean updateExistingGameIDAndAddClient(UUID gameID, Client client) {
        logger.debug("Checking if gameID: ".concat(gameID.toString()).concat(" exists in cache"));
        return GameCacheValidator.validateAndAddNewClientToGameID(gamesCache, gameID, client);
    }

    /**
     * @see GameCache
     */
    @Override
    public void updateClientsStatusToReadyForGameID(UUID gameID, Client client) {
        logger.debug("Checking if gameID: ".concat(gameID.toString()).concat(" exists in cache"));
        if (!CollectionUtils.isEmpty(gamesCache.get(gameID))) {
            gamesCache.get(gameID).stream().filter(c -> c.equals(client)).findFirst().ifPresent(found -> {
                found.ready();
                logger.debug("Changing status of client: ".concat(found.showID().toString()).concat(" to ready"));
            });
            return;
        }
        logger.warn("GameID or client not found");
    }

    /**
     * @see GameCache
     */
    @Override
    public void updateClientsStatusToNotReadyForGameID(UUID gameID, Client client) {
        logger.debug("Checking if gameID: ".concat(gameID.toString()).concat(" exists in cache"));
        if (!CollectionUtils.isEmpty(gamesCache.get(gameID))) {
            gamesCache.get(gameID).stream().filter(c -> c.equals(client)).findFirst().ifPresent(found -> {
                found.notReady();
                logger.debug("Changing status of client: ".concat(found.showID().toString()).concat(" to not ready"));
            });
            return;
        }
        logger.warn("GameID or client not found");
    }

    /**
     * @see GameCache
     */
    @Override
    public boolean removeClientFromGame(UUID gameID, Client client) {
        logger.debug("Checking if gameID: ".concat(gameID.toString()).concat(" exists in cache"));
        if (!CollectionUtils.isEmpty(gamesCache.get(gameID))) {
            logger.debug("Removing client: ".concat(client.showID().toString()).concat(" from game"));
            return gamesCache.get(gameID).removeIf(c -> c.equals(client));
        }
        logger.warn("GameID not found");
        return false;
    }

    /**
     * @see GameCache
     */
    @Override
    public void removeGameIDAndData(UUID gameID) {
        logger.debug("Removing all data for gameID: ".concat(gameID.toString()));
        gamesCache.remove(gameID);
    }

    /**
     * @see GameCache
     */
    @Override
    public Set<Client> getCachedClients(UUID gameID) {
        return gamesCache.get(gameID);
    }

    /**
     * @see GameCache
     */
    @Override
    public Set<UUID> getAvailableGames() {
        logger.debug("Cleaning cache from unused gameIDs and retrieving all available games");
        gamesCache.entrySet().removeIf(entry -> CollectionUtils.isEmpty(entry.getValue()));
        return gamesCache.keySet().stream().filter(key -> gamesCache.get(key).size() < 2).collect(Collectors.toSet());
    }

}
