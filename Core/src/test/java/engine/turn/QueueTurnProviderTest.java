package engine.turn;

import engine.turn.impl.QueueTurnProvider;
import model.client.Client;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class QueueTurnProviderTest {

    @Test
    public void testInitializeWithNullArray() {
        // Given
        TurnProvider queueTurnProvider = QueueTurnProvider.of(null);

        // When - Then
        assertNull(queueTurnProvider.getCurrentClient());
    }

    @Test
    public void testInitialWithOneClientAndNull() {
        // Given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = null;
        TurnProvider queueTurnProvider = QueueTurnProvider.of(firstClient, secondClient);

        // When - Then
        assertEquals(queueTurnProvider.getCurrentClient(), firstClient);
        assertEquals(queueTurnProvider.getNextClient(), firstClient);
    }

    @Test
    public void testGetCurrentPlayer() {
        // Given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());
        TurnProvider queueTurnProvider = QueueTurnProvider.of(firstClient, secondClient);

        // When - Then
        assertEquals(queueTurnProvider.getCurrentClient(), firstClient);
    }

    @Test
    public void testSequenceOfThreeTurns() {
        // Given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());
        TurnProvider queueTurnProvider = QueueTurnProvider.of(firstClient, secondClient);

        // When - Then
        assertEquals(firstClient, queueTurnProvider.getCurrentClient());
        assertEquals(secondClient, queueTurnProvider.getNextClient());
        queueTurnProvider.changeTurn();
        assertEquals(secondClient, queueTurnProvider.getCurrentClient());
        assertEquals(firstClient, queueTurnProvider.getNextClient());
        queueTurnProvider.changeTurn();
        assertEquals(firstClient, queueTurnProvider.getCurrentClient());
        assertEquals(secondClient, queueTurnProvider.getNextClient());
        queueTurnProvider.changeTurn();
    }

}

