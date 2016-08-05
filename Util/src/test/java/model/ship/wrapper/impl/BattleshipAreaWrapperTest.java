package model.ship.wrapper.impl;

import model.coordinate.Coordinate;
import model.ship.impl.Battleship;
import model.ship.wrapper.ShipAreaWrapper;
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
public class BattleshipAreaWrapperTest {

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
