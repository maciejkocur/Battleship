package model.ship;

import model.coordinate.Coordinate;
import org.apache.commons.collections4.ListUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.B;
import static model.coordinate.Sign.C;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 18.07.16.
 */
public class ShipTest {

    @Test
    public void testGetShipCoordinates() {
        // given
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(A, 1), new Coordinate(B, 1));
        Ship ship = new Ship(coordinates);

        // when - then
        assertTrue(ListUtils.isEqualList(ship.getCoordinates(), coordinates));
    }

    @Test
    public void testMoveShip() {
        // given
        List<Coordinate> startCoordinates = Arrays.asList(new Coordinate(A, 1), new Coordinate(B, 1));
        Ship ship = new Ship(startCoordinates);
        List<Coordinate> endCoordinates = Arrays.asList(new Coordinate(C, 5), new Coordinate(C, 6));

        // when
        ship = ship.moveTo(endCoordinates);

        // then
        assertTrue(ListUtils.isEqualList(ship.getCoordinates(), endCoordinates));

    }

    @Test
    public void testEqualityOfShips() {
        // given
        Ship firstShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        Ship secondShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        Ship thirdShip = new Ship(Arrays.asList(new Coordinate(A, 1)));

        // when - then
        // reflexive
        assertEquals(firstShip, firstShip);
        // symmetric
        assertEquals(firstShip, secondShip);
        assertEquals(secondShip, firstShip);
        // transitive
        assertEquals(firstShip, thirdShip);

    }


}
