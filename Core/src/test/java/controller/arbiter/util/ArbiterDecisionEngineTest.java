package controller.arbiter.util;

import model.coordinate.Coordinate;
import model.client.Client;
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
    public void addCoordinatesTest() {
        // Given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
        Client player = new Client(UUID.randomUUID());

        // When
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);

        // Then
        assertTrue(arbiterDecisionEngine.contains(player, new Coordinate(A, 1)));
        assertFalse(arbiterDecisionEngine.contains(player, new Coordinate(D, 10)));
    }

    @Test
    public void winningConditionNotOccursTest() {
        // Given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
        Client player = new Client(UUID.randomUUID());
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);

        // When
        arbiterDecisionEngine.isHit(player, new Coordinate(D, 1));

        // Then
        assertFalse(arbiterDecisionEngine.checkWinningConditionForClient(player));
    }

    @DataProvider
    Object[][] playerHitsProvider() {
        return new Object[][]{{true, new Coordinate(A, 1)},
                {false, new Coordinate(D, 1)}};
    }

    @Test(dependsOnMethods = "addCoordinatesTest", dataProvider = "playerHitsProvider")
    public void ifPlayerHitShipTest(boolean decision, Coordinate playerHit) {
        // Given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
        Client player = new Client(UUID.randomUUID());
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);

        // When - Then
        assertEquals(decision, arbiterDecisionEngine.isHit(player, playerHit));
        assertFalse(arbiterDecisionEngine.contains(player, playerHit));
    }

    @Test(dependsOnMethods = "ifPlayerHitShipTest")
    public void winningConditionOccursTest() {
        // Given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();
        Client player = new Client(UUID.randomUUID());
        arbiterDecisionEngine.addCoordinatesFromShip(player, ship);
        arbiterDecisionEngine.isHit(player, new Coordinate(A, 1));

        // Then
        assertTrue(arbiterDecisionEngine.checkWinningConditionForClient(player));

    }


}
