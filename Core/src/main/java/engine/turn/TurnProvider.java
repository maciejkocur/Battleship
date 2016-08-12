package engine.turn;

import model.client.Client;


/**
 * Provide methods that support turn management
 *
 * @author Ogre
 */
public interface TurnProvider {

    /**
     * Returns current {@link Client} object
     *
     * @return current client object
     */
    Client getCurrentClient();


    /**
     * Returns next (in order) Client object
     *
     * @return next client object
     */
    Client getNextClient();

    /**
     * Change turn by changing order of clients.
     * After calling this method current {@link Client} will be on last position.
     */
    void changeTurn();
}
