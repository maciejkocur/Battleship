package model.ship.wrapper.impl;

import model.coordinate.Coordinate;
import model.ship.impl.Ship;
import model.ship.wrapper.impl.ShipAreaResolver;
import org.apache.commons.collections4.ListUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.B;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 18.07.16.
 */
public class ShipAreaResolverTest {

    @Test
    public void testFindCoordinatesAroundShip(){
        // given
        Ship smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        List<Coordinate> expectedCoordinatesAroundShip = Arrays.asList(new Coordinate(A, 2), new Coordinate(B, 1), new Coordinate(B, 2));

        // when - then
        assertTrue(ListUtils.isEqualList(ShipAreaResolver.findCoordinatesAroundShip(smallShip), expectedCoordinatesAroundShip));
    }
}
