package engine.arbiter.util;

import model.client.Client;
import model.coordinate.Coordinate;
import model.ship.Ship;
import model.ship.impl.Battleship;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.UUID;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.D;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ArbiterDecisionEngineTest {

    private Ship ship;

    @BeforeMethod
    public void shipInit() {
        ship = new Battleship(Arrays.asList(new Coordinate(A, 1)));
    }

    @AfterMethod
    public void cleaning() {
        ship = null;
    }

    @Test
    public void testAddCoordinates() {
        // given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
        Client player = new Client(UUID.randomUUID());

        // when
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);

        // then
        assertTrue(arbiterDecisionEngine.contains(player, new Coordinate(A, 1)));
        assertFalse(arbiterDecisionEngine.contains(player, new Coordinate(D, 10)));
    }

    @Test
    public void testIfWinningConditionNotHappening() {
        // given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
        Client player = new Client(UUID.randomUUID());
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);

        // when
        arbiterDecisionEngine.isClientsShipIsHit(player, new Coordinate(D, 1));

        // then
        assertFalse(arbiterDecisionEngine.checkLoosingConditionForClient(player));
    }

    @DataProvider
    Object[][] hitsProvider() {
        return new Object[][]{{true, new Coordinate(A, 1)},
                {false, new Coordinate(D, 1)}};
    }

    @Test(dependsOnMethods = "testAddCoordinates", dataProvider = "hitsProvider")
    public void testIfClientsShipIsHit(boolean decision, Coordinate playerHit) {
        // given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
        Client player = new Client(UUID.randomUUID());
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);

        // when - then
        assertEquals(decision, arbiterDecisionEngine.isClientsShipIsHit(player, playerHit));
        assertFalse(arbiterDecisionEngine.contains(player, playerHit));
    }

    @Test(dependsOnMethods = "testIfClientsShipIsHit")
    public void testIfWinningConditionHappening() {
        // given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
        Client player = new Client(UUID.randomUUID());
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);
        arbiterDecisionEngine.isClientsShipIsHit(player, new Coordinate(A, 1));

        // when - then
        assertTrue(arbiterDecisionEngine.checkLoosingConditionForClient(player));
    }


}
