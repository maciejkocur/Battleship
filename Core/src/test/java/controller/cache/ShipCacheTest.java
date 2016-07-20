package controller.cache;

import model.coordinate.Coordinate;
import model.ship.Ship;
import model.ship.wrapper.ShipAreaWrapper;
import org.apache.commons.collections4.SetUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static model.coordinate.Sign.*;
import static org.testng.Assert.*;

/**
 * Created by lucz on 18.07.16.
 */
public class ShipCacheTest {

    @Test
    public void testRegisterShipAndGet() {
        // given
        ShipCache shipCache = new ShipCache();
        Ship smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper smallShipAreaWrapper = new ShipAreaWrapper(smallShip);

        // when
        shipCache.registerOrUpdate(smallShip);

        // - then
        assertEquals(shipCache.getCacheForShip(smallShip), smallShipAreaWrapper);
    }

    @Test
    public void testRemoveShipFromCache() {
        // given
        ShipCache shipCache = new ShipCache();
        Ship smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));

        // when
        shipCache.registerOrUpdate(smallShip);
        shipCache.remove(smallShip);

        // - then
        assertNull(shipCache.getCacheForShip(smallShip));
    }

    @Test
    public void testGetCachedShips() {
        // given
        ShipCache shipCache = new ShipCache();
        Ship smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        Ship mediumShip = new Ship(Arrays.asList(new Coordinate(C, 1), new Coordinate(D, 1)));
        Ship bigShip = new Ship(Arrays.asList(new Coordinate(F, 10), new Coordinate(G, 10), new Coordinate(H, 10)));
        Set<ShipAreaWrapper> expectedShipsInCache = new HashSet(Arrays.asList(new ShipAreaWrapper(smallShip),
                new ShipAreaWrapper(mediumShip), new ShipAreaWrapper(bigShip)));

        // when
        shipCache.registerOrUpdate(smallShip);
        shipCache.registerOrUpdate(mediumShip);
        shipCache.registerOrUpdate(bigShip);

        // then
        assertTrue(SetUtils.isEqualSet(shipCache.getCachedShipAreas().values(), expectedShipsInCache));
    }


}
