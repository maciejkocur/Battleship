package engine.game;

import engine.arbiter.Arbiter;
import model.client.Client;
import model.ship.Ship;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Provides behaviour to create and play a game
 *
 * @author Ogre
 */
public interface Game {

    /**
     * Add new game id and one {@link Client} bound to it.
     * Also if true new {@link Arbiter} object will be created for game
     *
     * @param gameID new id of game
     * @param client new client
     * @return true if add is successful, false if not
     */
    boolean createGame(UUID gameID, Client client);

    /**
     * Returns Set of all available game ids. Available game is a game with maximum one registered {@link Client}
     *
     * @return ids of all available game ids
     */
    Set<UUID> findAvailableGames();

    /**
     * Add {@link Client} to existing game.
     * If game does not exists or have already two players returns false
     *
     * @param gameID existing game id
     * @param client representation of a client
     * @return true if game exist and have no more than one client already in game, else returns false
     */
    boolean joinGame(UUID gameID, Client client);

    /**
     * Allows {@link Client} to leave game before it starts
     *
     * @param gameID existing game id
     * @param client client who wants to leave the game
     * @return true if leaving game is successful else returns false
     */
    boolean leaveGame(UUID gameID, Client client);

    /**
     * Allows {@link Client} to leave game after game starts. It causes instant loss of client which left the game
     *
     * @param gameID existing game id
     * @param client client who wants to abandon the game
     * @return true if leaving game is successful else returns false
     */
    boolean abandonGame(UUID gameID, Client client);

    /**
     * Initialize internal mechanisms with {@link Client}'s ships data
     *
     * @param gameID existing game id
     * @param client client
     * @param ships list of clients ships
     */
    void initClientShips(UUID gameID, Client client, List<Ship> ships);

}
