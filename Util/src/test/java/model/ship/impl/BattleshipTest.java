package model.ship.impl;

import model.coordinate.Coordinate;
import model.ship.Ship;
import org.apache.commons.collections4.ListUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static model.coordinate.Sign.*;
import static org.testng.Assert.*;

public class BattleshipTest {

    @Test
    public void testEqualityOfShips() {
        // given
        Ship firstShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        Ship secondShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        Ship thirdShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));

        // when - then
        // reflexive
        assertEquals(firstShip, firstShip);
        // symmetric
        assertEquals(firstShip, secondShip);
        assertEquals(secondShip, firstShip);
        // transitive
        assertEquals(firstShip, thirdShip);
    }

    @Test
    public void testInequalityOfShips() {
        // given
        Ship firstShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        Ship secondShip = new Battleship(Arrays.asList(new Coordinate(B, 6)));

        // when - then
        assertNotEquals(firstShip, secondShip);
    }

    @Test
    public void testInequalityOfShipAndNull() {
        // given
        Ship firstShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        Ship secondShip = null;

        // when - then
        assertNotEquals(firstShip, secondShip);
    }

    @Test
    public void testInequalityOfShipAndObject() {
        // given
        Ship firstShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        Object object = new Object();

        // when - then
        assertNotEquals(firstShip, object);
    }

    @Test
    public void testEqualityOfHashCodesOfShips() {
        // given
        Ship firstShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        Ship secondShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));

        // when - then
        assertEquals(firstShip.hashCode(), firstShip.hashCode());
        assertEquals(firstShip.hashCode(), secondShip.hashCode());
    }

    @Test
    public void testGetShipCoordinates() {
        // given
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(A, 1), new Coordinate(B, 1));
        Ship ship = new Battleship(coordinates);

        // when - then
        assertTrue(ListUtils.isEqualList(ship.getCoordinates(), coordinates));
    }

    @Test
    public void testMoveShip() {
        // given
        List<Coordinate> startCoordinates = Arrays.asList(new Coordinate(A, 1), new Coordinate(B, 1));
        Ship ship = new Battleship(startCoordinates);
        List<Coordinate> endCoordinates = Arrays.asList(new Coordinate(C, 5), new Coordinate(C, 6));

        // when
        ship = ship.moveTo(endCoordinates);

        // then
        assertTrue(ListUtils.isEqualList(ship.getCoordinates(), endCoordinates));
    }


}
