package controller.arbiter.impl;

import controller.arbiter.Arbiter;
import model.coordinate.Coordinate;
import model.player.Player;
import model.ship.impl.Battleship;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

import static model.coordinate.Sign.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 22.07.16.
 */
public class BattleshipArbiterTest {

    Arbiter arbiter;

    @BeforeTest
    public void registerShipsForPlayers() {
        this.arbiter = new BattleshipArbiter();
        arbiter.registerShipForPlayer(new Player(1), new Battleship(Arrays.asList(new Coordinate(A, 1))));
        arbiter.registerShipForPlayer(new Player(1), new Battleship(Arrays.asList(new Coordinate(A, 3), new Coordinate(B, 3))));
        arbiter.registerShipForPlayer(new Player(2), new Battleship(Arrays.asList(new Coordinate(H, 7), new Coordinate(I, 7), new Coordinate(J, 7))));
    }

    @AfterTest
    public void cleanUp() {
        arbiter = null;
    }

    @Test
    public void testShipIsHit() {
        // given
        Coordinate hitCoordinate = new Coordinate(A, 3);
        Player firstPlayer = new Player(1);

        // when - then
        assertTrue(arbiter.isHit(firstPlayer, hitCoordinate));
    }

    @Test
    public void testShipIsNotHit() {
        // given
        Coordinate hitCoordinate = new Coordinate(B, 10);
        Player firstPlayer = new Player(1);

        // when - then
        assertFalse(arbiter.isHit(firstPlayer, hitCoordinate));
    }
}


