package model.coordinate;

import org.testng.annotations.Test;

import static model.coordinate.Sign.*;
import static org.testng.Assert.*;

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
    public void testInequalityOfAllDifferentCoordinates() {
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Coordinate secondCoordinateA1 = new Coordinate(G, 5);

        // when - then
        assertNotEquals(firstCoordinateA1, secondCoordinateA1);
    }

    @Test
    public void testInequalityOfDigitDifferentCoordinates() {
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Coordinate secondCoordinateA1 = new Coordinate(A, 5);

        // when - then
        assertNotEquals(firstCoordinateA1, secondCoordinateA1);
    }

    @Test
    public void testInequalityOfSignDifferentCoordinates() {
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Coordinate secondCoordinateA1 = new Coordinate(G, 1);

        // when - then
        assertNotEquals(firstCoordinateA1, secondCoordinateA1);
    }

    @Test
    public void testInequalityOfCoordinateAndNull() {
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Coordinate secondNullCoordinate = null;

        // when - then
        assertNotEquals(firstCoordinateA1, secondNullCoordinate);
    }

    @Test
    public void testInequalityOfCoordinateAndObject() {
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Object object = new Object();

        // when - then
        assertNotEquals(firstCoordinateA1, object);
    }

    @Test
    public void testEqualityOfHashCodesOfCoordinates() {
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Coordinate secondCoordinateA1 = new Coordinate(A, 1);
        Coordinate thirdCoordinateA1 = new Coordinate(A, 1);

        // when - then
        assertEquals(firstCoordinateA1, firstCoordinateA1);
        assertEquals(firstCoordinateA1, secondCoordinateA1);
        assertEquals(firstCoordinateA1, thirdCoordinateA1);
    }

    @Test
    public void testCompareToThreeCoordinates() {
        Coordinate firstCoordinateA1 = new Coordinate(A, 1);
        Coordinate secondCoordinateB3 = new Coordinate(B, 3);
        Coordinate thirdCoordinateH10 = new Coordinate(H, 10);
        Coordinate fourthCoordinateH10 = new Coordinate(H, 10);

        // when - then
        assertTrue(firstCoordinateA1.compareTo(secondCoordinateB3) < 0);
        assertTrue(firstCoordinateA1.compareTo(thirdCoordinateH10) < 0);
        assertTrue(fourthCoordinateH10.compareTo(secondCoordinateB3) > 0);
        assertTrue(thirdCoordinateH10.compareTo(fourthCoordinateH10) == 0);
    }

}
