package controller.turn;

import model.player.Player;

/**
 * Created by lucz on 01.08.16.
 */
public interface GameTurnProvider {
    Player getCurrentPlayer();
    Player getNextPlayer();
}
