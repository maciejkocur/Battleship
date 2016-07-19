package controller.cache;

import model.coordinate.Coordinate;
import model.ship.Ship;
import org.testng.annotations.Test;

import java.util.Arrays;

import static model.coordinate.Sign.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 18.07.16.
 */
public class ShipCacheTest {

    @Test
    public void testRegisterShip(){
        // given
        ShipCache shipCache = new ShipCache();
        Ship smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        Ship mediumShip = new Ship(Arrays.asList(new Coordinate(C, 1), new Coordinate(D, 1)));
        Ship bigShip = new Ship(Arrays.asList(new Coordinate(F, 10), new Coordinate(G, 10), new Coordinate(H, 10)));

        // when - then
        assertTrue(shipCache.registerShip(smallShip));
        assertTrue(shipCache.registerShip(mediumShip));
        assertTrue(shipCache.registerShip(bigShip));
        assertFalse(shipCache.registerShip(bigShip));
    }


}
