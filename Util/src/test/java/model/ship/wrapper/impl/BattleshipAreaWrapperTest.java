package model.ship.wrapper.impl;

import model.coordinate.Coordinate;
import model.ship.Ship;
import model.ship.impl.Battleship;
import model.ship.wrapper.ShipAreaWrapper;
import org.apache.commons.collections4.ListUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.B;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class BattleshipAreaWrapperTest {

    @Test
    public void testEqualityOfWrappers() {
        // given
        Ship ship = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper firstShipAreaWrapper = new BattleshipAreaWrapper(ship);
        ShipAreaWrapper secondShipAreaWrapper = new BattleshipAreaWrapper(ship);
        ShipAreaWrapper thirdShipAreaWrapper =new BattleshipAreaWrapper(ship);

        // when - then
        // reflexive
        assertEquals(firstShipAreaWrapper, firstShipAreaWrapper);
        // symmetric
        assertEquals(firstShipAreaWrapper, secondShipAreaWrapper);
        assertEquals(secondShipAreaWrapper, firstShipAreaWrapper);
        // transitive
        assertEquals(firstShipAreaWrapper, thirdShipAreaWrapper);
    }

    @Test
    public void testInequalityOfWrapperAndNull() {
        // given
        Ship ship = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper firstShipAreaWrapper = new BattleshipAreaWrapper(ship);
        ShipAreaWrapper secondShipAreaWrapper = null;

        // when - then
        assertNotEquals(firstShipAreaWrapper, secondShipAreaWrapper);
    }

    @Test
    public void testInequalityOfWrapperAndObject() {
        // given
        Ship ship = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper firstShipAreaWrapper = new BattleshipAreaWrapper(ship);
        Object object = new Object();

        // when - then
        assertNotEquals(firstShipAreaWrapper, object);
    }

    @Test
    public void testEqualityOfHashCodesOfWrappers() {
        // given
        Ship ship = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper firstShipAreaWrapper = new BattleshipAreaWrapper(ship);
        ShipAreaWrapper secondShipAreaWrapper = new BattleshipAreaWrapper(ship);
        ShipAreaWrapper thirdShipAreaWrapper =new BattleshipAreaWrapper(ship);

        // when - then
        assertEquals(firstShipAreaWrapper.hashCode(), firstShipAreaWrapper.hashCode());
        assertEquals(firstShipAreaWrapper.hashCode(), secondShipAreaWrapper.hashCode());
        assertEquals(secondShipAreaWrapper.hashCode(), thirdShipAreaWrapper.hashCode());
        assertEquals(firstShipAreaWrapper.hashCode(), thirdShipAreaWrapper.hashCode());
    }

    @Test
    public void testGetCoordinatesAroundShip() {
        // given
        Battleship smallShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper smallShipAreaWrapper = new BattleshipAreaWrapper(smallShip);
        List<Coordinate> coordinatesAroundShip = Arrays.asList(new Coordinate(A, 2), new Coordinate(B, 1), new Coordinate(B, 2));

        // when - then
        assertTrue(ListUtils.isEqualList(smallShipAreaWrapper.getCoordinatesAroundShip(), coordinatesAroundShip));
    }
}
