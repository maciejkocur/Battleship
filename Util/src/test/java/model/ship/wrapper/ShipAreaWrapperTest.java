package model.ship.wrapper;

import model.coordinate.Coordinate;
import model.ship.Ship;
import org.apache.commons.collections4.ListUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.B;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 18.07.16.
 */
public class ShipAreaWrapperTest {

    @Test
    public void testGetShip() {
        // given
        Ship smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper smallShipAreaWrapper = new ShipAreaWrapper(smallShip);

        // when - then
        assertEquals(smallShipAreaWrapper.getShip(), smallShip);
    }

    @Test
    public void testGetCoordinatesAroundShip() {
        // given
        Ship smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper smallShipAreaWrapper = new ShipAreaWrapper(smallShip);
        List<Coordinate> coordinatesAroundShip = Arrays.asList(new Coordinate(A, 2), new Coordinate(B, 1), new Coordinate(B, 2));

        // when - then
        assertTrue(ListUtils.isEqualList(smallShipAreaWrapper.getCoordinatesAroundShip(), coordinatesAroundShip));
    }
}
