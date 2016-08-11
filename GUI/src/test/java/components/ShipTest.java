package components;

import model.coordinate.Coordinate;
import org.apache.commons.collections.ListUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.coordinate.Sign.D;
import static model.coordinate.Sign.E;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class ShipTest {

    @Test
    public void testShipRotation() {

        // given
        Ship ship = new Ship();

        // when - then
        ship.rotateShip();
        assertFalse(ship.isOrientationVertical());
        ship.rotateShip();
        assertTrue(ship.isOrientationVertical());
    }

    @Test
    public void testShipCoordinateGeneratorForVerticalOrientation() {

        // given
        Ship ship = new Ship();
        ship.generateCoordinates(3, 3);

        // when
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.addAll(Arrays.asList(new Coordinate(D, 4), new Coordinate(D, 5)));

        // then
        assertTrue(ListUtils.isEqualList(ship.getCoordinates(), coordinates));
    }


    @Test
    public void testShipCoordinateGeneratorForHorizontalOrientation() {

        // given
        Ship ship = new Ship();
        ship.rotateShip();
        ship.generateCoordinates(3, 3);

        // when
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.addAll(Arrays.asList(new Coordinate(D, 4), new Coordinate(E, 4)));

        // then
        assertTrue(ListUtils.isEqualList(ship.getCoordinates(), coordinates));
    }
}