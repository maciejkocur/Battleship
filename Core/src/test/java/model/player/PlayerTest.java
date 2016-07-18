package model.player;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by kuba on 18.07.16.
 */
public class PlayerTest {

    @Test
    public void equalityOfPlayerTest() {
        // Given
        Player player1 = new Player(1);
        Player player2 = new Player(1);
        Player player3 = new Player(1);

        // when - then
        // reflexive
        assertEquals(player1, player1);
        // symmetric
        assertEquals(player1, player1);
        assertEquals(player2, player3);
        // transitive
        assertEquals(player1, player3);

    }
}