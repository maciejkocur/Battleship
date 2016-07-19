package controller.arbiter;


import model.coordinate.Coordinate;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.D;
import static org.testng.AssertJUnit.*;

public class ArbiterTest {

    private List<Coordinate> coordinates;

    @BeforeMethod
    public void listInit() {
        coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(A, 1));
    }

    @AfterMethod
    public void cleaning() {
        coordinates = null;
    }

    @Test
    public void addCoordinatesTest() {
        // Given
        Arbiter arbiter = new Arbiter();

        // When
        arbiter.addCoordinates(coordinates);

        // Then
        assertTrue(arbiter.contains(new Coordinate(A, 1)));
        assertFalse(arbiter.contains(new Coordinate(D, 10)));
    }

    @Test
    public void winningConditionNotOccursTest() {
        // Given
        Arbiter arbiter = new Arbiter();
        arbiter.addCoordinates(coordinates);

        // When
        arbiter.isHit(new Coordinate(D, 1));

        // Then
        assertFalse(arbiter.checkWinningCondition());
    }

    @DataProvider
    Object[][] playerHitsProvider() {
        return new Object[][]{{true, new Coordinate(A, 1)},
                {false, new Coordinate(D, 1)}};
    }

    @Test(dependsOnMethods = "addCoordinatesTest", dataProvider = "playerHitsProvider")
    public void ifPlayerHitShipTest(boolean decision, Coordinate playerHit) {
        // Given
        Arbiter arbiter = new Arbiter();
        arbiter.addCoordinates(coordinates);

        // When - Then
        assertEquals(decision, arbiter.isHit(playerHit));
        assertFalse(arbiter.contains(playerHit));
    }

    @Test(dependsOnMethods = "ifPlayerHitShipTest")
    public void winningConditionOccursTest() {
        // Given
        Arbiter arbiter = new Arbiter();
        arbiter.addCoordinates(coordinates);
        arbiter.isHit(new Coordinate(A, 1));

        // Then
        assertTrue(arbiter.checkWinningCondition());

    }


}
