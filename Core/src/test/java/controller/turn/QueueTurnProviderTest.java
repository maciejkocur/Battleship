package controller.turn;

import controller.turn.impl.QueueTurnProvider;
import model.client.Client;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.assertEquals;


public class QueueTurnProviderTest {

    @Test
    public void testGetCurrentPlayer() {
        // Given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());
        TurnProvider queueTurnProvider = QueueTurnProvider.of(firstClient, secondClient);

        // When - Then
        assertEquals(queueTurnProvider.getCurrentPlayer(), firstClient);
    }

    @Test
    public void testSequenceOfThreeTurns() {
        // Given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());
        TurnProvider queueTurnProvider = QueueTurnProvider.of(firstClient, secondClient);

        // When - Then
        assertEquals(firstClient, queueTurnProvider.getCurrentPlayer());
        assertEquals(secondClient, queueTurnProvider.getNextPlayer());
        queueTurnProvider.changeTurn();
        assertEquals(secondClient, queueTurnProvider.getCurrentPlayer());
        assertEquals(firstClient, queueTurnProvider.getNextPlayer());
        queueTurnProvider.changeTurn();
        assertEquals(firstClient, queueTurnProvider.getCurrentPlayer());
        assertEquals(secondClient, queueTurnProvider.getNextPlayer());
        queueTurnProvider.changeTurn();
    }

}

