package controller.turn;

import model.player.Player;

/**
 * Created by lucz on 01.08.16.
 */
public interface TurnProvider {
    Player getCurrentPlayer();
    Player getNextPlayer();
}
