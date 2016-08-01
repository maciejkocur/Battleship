package controller.turn;

import controller.turn.impl.QueueTurnProvider;
import model.player.Player;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class QueueTurnProviderTest {

    @Test
    public void getCurrentPlayerTest() {
        // Given
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        TurnProvider queueTurnProvider = QueueTurnProvider.getTurnProvider(player1, player2);

        // When - Then
        assertEquals(queueTurnProvider.getCurrentPlayer(), player1);
    }

    @Test
    public void sequenceOfTurnsTest() {
        // Given
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        TurnProvider queueTurnProvider = QueueTurnProvider.getTurnProvider(player1, player2);

        // When - Then
        assertEquals(player1, queueTurnProvider.getCurrentPlayer());
        assertEquals(player2, queueTurnProvider.getNextPlayer());
        assertEquals(player1, queueTurnProvider.getNextPlayer());
    }

}

