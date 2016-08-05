package controller.turn;

import model.client.Client;

/**
 * Created by lucz on 01.08.16.
 */
public interface TurnProvider {
    Client getCurrentPlayer();

    Client getNextPlayer();

    void changeTurn();
}
