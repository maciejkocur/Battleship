package engine.cache;

import model.client.Client;

import java.util.Set;
import java.util.UUID;

/**
 * Data holder responsible for keeping the information shared between the game core and the GUI
 *
 * @author Ogre
 */
public interface GameCache {

    /**
     * Add new game id and one {@link Client} bound to it
     *
     * @param gameID new id of game
     * @param client new client
     * @return true if add is successful, false if not
     */
    boolean registerGameIDAndClient(UUID gameID, Client client);

    /**
     * Updates list of clients under existing game id by add {@link Client}.
     * Method not allows to register more than 2 clients under one game id
     *
     * @param gameID id of game which is present in cache
     * @param client client to add
     * @return true if update is successful, false if not
     */
    boolean updateExistingGameIDAndAddClient(UUID gameID, Client client);

    /**
     * Change status of specified {@link Client} to ready under game id
     *
     * @param gameID id of game which is present in cache
     * @param client client representation
     */
    void updateClientsStatusToReadyForGameID(UUID gameID, Client client);

    /**
     * Change status of specified {@link Client} to not ready under game id
     *
     * @param gameID id of game which is present in cache
     * @param client client representation
     */
    void updateClientsStatusToNotReadyForGameID(UUID gameID, Client client);

    /**
     * Remove {@link Client} from game
     *
     * @param gameID id of game which is present in cache
     * @param client client to remove
     * @return
     */
    boolean removeClientFromGame(UUID gameID, Client client);

    /**
     * Remove all data for specified game id, including game id itself.
     *
     * @param gameID id of game which is present in cache
     */
    void removeGameIDAndData(UUID gameID);

    /**
     * Returns Set of clients under specified game id
     *
     * @param gameID id of game which is present in cache
     * @return set of clients under game id
     */
    Set<Client> getCachedClients(UUID gameID);

    /**
     * Returns Set of all available games. Available game is a game with maximum one registered client
     *
     * @return ids of all available games
     */
    Set<UUID> getAvailableGames();
}
