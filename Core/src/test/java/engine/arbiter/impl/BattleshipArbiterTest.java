package engine.arbiter.impl;

import engine.arbiter.Arbiter;
import model.client.Client;
import model.coordinate.Coordinate;
import model.ship.impl.Battleship;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.UUID;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.B;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BattleshipArbiterTest {

    private Arbiter arbiter;

    @BeforeTest
    public void registerShipsForClients() {
        this.arbiter = new BattleshipArbiter();
    }

    @AfterTest
    public void cleanUp() {
        arbiter = null;
    }

    @Test
    public void testClientIsLosing(){
        // given
        Client client = new Client(UUID.randomUUID());
        Coordinate hitCoordinate = new Coordinate(A, 1);

        // when
        arbiter.registerShipForClient(client, new Battleship(Arrays.asList(new Coordinate(A, 1))));
        arbiter.isClientsShipIsHit(client, hitCoordinate);

        // then
        assertTrue(arbiter.isClientLosing(client));
    }

    @Test
    public void testIsClientsShipIsHit() {
        // given
        Client client = new Client(UUID.randomUUID());
        Coordinate hitCoordinate = new Coordinate(A, 3);

        // when
        arbiter.registerShipForClient(client, new Battleship(Arrays.asList(new Coordinate(A, 3), new Coordinate(B, 3))));

        // then
        assertTrue(arbiter.isClientsShipIsHit(client, hitCoordinate));
    }

    @Test
    public void testIsClientsShipIsNotHit()  {
        // given
        Client client = new Client(UUID.randomUUID());
        Coordinate hitCoordinate = new Coordinate(B, 10);

        // when
        arbiter.registerShipForClient(client, new Battleship(Arrays.asList(new Coordinate(A, 3), new Coordinate(B, 3))));

        // when - then
        assertFalse(arbiter.isClientsShipIsHit(client, hitCoordinate));
    }

}


