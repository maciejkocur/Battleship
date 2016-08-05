package model.coordinate;

import org.testng.annotations.Test;

import static model.coordinate.Sign.A;
import static org.testng.Assert.assertEquals;

public class CoordinateTest {

    @Test
    public void testEqualityOfCoordinates() {
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Coordinate secondCoordinateA1 = new Coordinate(A, 1);
        Coordinate thirdCoordinateA1 = new Coordinate(A, 1);


        // when - then
        // reflexive
        assertEquals(firstCoordinateA1, firstCoordinateA1);
        // symmetric
        assertEquals(firstCoordinateA1, secondCoordinateA1);
        assertEquals(secondCoordinateA1, firstCoordinateA1);
        // transitive
        assertEquals(firstCoordinateA1, thirdCoordinateA1);
    }

    @Test
    public void testEqualityOfHashCodes() {
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Coordinate secondCoordinateA1 = new Coordinate(A, 1);
        Coordinate thirdCoordinateA1 = new Coordinate(A, 1);


        // when - then
        assertEquals(firstCoordinateA1, firstCoordinateA1);
        assertEquals(firstCoordinateA1, secondCoordinateA1);
        assertEquals(firstCoordinateA1, thirdCoordinateA1);
    }

}
