package model.turnProvider;

import model.player.Player;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TurnProviderTest {

    @Test
    public void getCurrentPlayerTest() {
        // Given
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        TurnProvider turnProvider = TurnProvider.getTurnProvider(player1, player2);

        // When - Then
        assertEquals(turnProvider.getCurrentPlayer(), player1);
    }

    @Test
    public void sequenceOfTurnsTest() {
        // Given
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        TurnProvider turnProvider = TurnProvider.getTurnProvider(player1, player2);

        // When - Then
        assertEquals(player1, turnProvider.getCurrentPlayer());
        assertEquals(player2, turnProvider.getNextPlayer());
        assertEquals(player1, turnProvider.getNextPlayer());
    }

}

