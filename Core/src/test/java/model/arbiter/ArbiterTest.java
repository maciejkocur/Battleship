package model.arbiter;


import model.field.Coordinate;
import model.field.Sign;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

public class ArbiterTest {

    private List<Coordinate> coordinates;

    @BeforeMethod
    public void listInit() {
        coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(Sign.A, "1"));
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
        assertTrue(arbiter.contains(new Coordinate(Sign.A, "1")));
        assertFalse(arbiter.contains(new Coordinate(Sign.D, "10")));
    }

    @Test(dependsOnMethods = "addCoordinatesTest")
    public void removeCoordinateFromArbiterTest() {
        // Given
        Arbiter arbiter = new Arbiter();
        arbiter.addCoordinates(coordinates);

        // When
        arbiter.updateCoordinatesForMove(new Coordinate(Sign.A, "1"));

        // Then
        assertFalse(arbiter.contains(new Coordinate(Sign.A, "1")));
    }

    @Test(dependsOnMethods = "addCoordinatesTest")
    public void removeNonexistentCoordinateTest(){
        // Given
        Arbiter  arbiter = new Arbiter();
        arbiter.addCoordinates(coordinates);

        // When
        try {
            arbiter.updateCoordinatesForMove(new Coordinate(Sign.D,"3"));
        } catch (Exception e){
            fail();
        }
    }

    @Test(dependsOnMethods = "removeCoordinateFromArbiterTest")
    public void winningConditionNotOccursTest() {
        // Given
        Arbiter arbiter = new Arbiter();
        arbiter.addCoordinates(coordinates);

        // Then
        assertFalse(arbiter.checkWinningCondition());
    }

    @Test(dependsOnMethods = "removeCoordinateFromArbiterTest")
    public void winningConditionOccursTest() {
        // Given
        Arbiter arbiter = new Arbiter();
        arbiter.addCoordinates(coordinates);
        arbiter.updateCoordinatesForMove(new Coordinate(Sign.A, "1"));

        // Then
        assertTrue(arbiter.checkWinningCondition());

    }


}
