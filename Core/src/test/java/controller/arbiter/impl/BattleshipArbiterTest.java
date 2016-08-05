package controller.arbiter.impl;

import controller.arbiter.Arbiter;
import model.coordinate.Coordinate;
import model.client.Client;
import model.ship.impl.Battleship;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.UUID;

import static model.coordinate.Sign.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 22.07.16.
 */
public class BattleshipArbiterTest {

    private Arbiter arbiter;
    private Client firstClient = new Client(UUID.randomUUID());
    private Client secondClient = new Client(UUID.randomUUID());

    @BeforeTest
    public void registerShipsForClients() {
        this.arbiter = new BattleshipArbiter();
        arbiter.registerShipForClient(firstClient, new Battleship(Arrays.asList(new Coordinate(A, 1))));
        arbiter.registerShipForClient(secondClient, new Battleship(Arrays.asList(new Coordinate(A, 3), new Coordinate(B, 3))));
    }

    @AfterTest
    public void cleanUp() {
        arbiter = null;
    }


    @Test
    public void testIsFirstClientIsLosing(){
        // given
        Coordinate hitCoordinate = new Coordinate(A, 1);

        // when
        arbiter.isHit(firstClient, hitCoordinate);

        // then
        assertTrue(arbiter.isLosing(firstClient));
    }

    @Test
    public void testIsSecondClientHitShip() {
        // given
        Coordinate hitCoordinate = new Coordinate(A, 3);

        // when - then
        assertTrue(arbiter.isHit(secondClient, hitCoordinate));
    }

    @Test
    public void testIsSecondClientNotHitShip()  {
        // given
        Coordinate hitCoordinate = new Coordinate(B, 10);

        // when - then
        assertFalse(arbiter.isHit(secondClient, hitCoordinate));
    }

}


