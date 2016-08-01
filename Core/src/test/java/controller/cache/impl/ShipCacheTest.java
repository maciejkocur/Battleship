package controller.cache.impl;

import controller.cache.GameShipCache;
import model.coordinate.Coordinate;
import model.ship.GameShip;
import model.ship.impl.Ship;
import model.ship.wrapper.GameShipAreaWrapper;
import model.ship.wrapper.impl.ShipAreaWrapper;
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
        GameShipCache shipCache = new ShipCache();
        GameShip smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        GameShipAreaWrapper smallShipAreaWrapper = new ShipAreaWrapper(smallShip);

        // when
        shipCache.registerOrUpdate(smallShip);

        // - then
        assertEquals(shipCache.getCachedAreaForShip(smallShip), smallShipAreaWrapper);
    }

    @Test
    public void testRemoveShipFromCache() {
        // given
        GameShipCache shipCache = new ShipCache();
        GameShip smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));

        // when
        shipCache.registerOrUpdate(smallShip);
        shipCache.remove(smallShip);

        // - then
        assertNull(shipCache.getCachedAreaForShip(smallShip));
    }

    @Test
    public void testGetCachedShips() {
        // given
        GameShipCache shipCache = new ShipCache();
        GameShip smallShip = new Ship(Arrays.asList(new Coordinate(A, 1)));
        GameShip mediumShip = new Ship(Arrays.asList(new Coordinate(C, 1), new Coordinate(D, 1)));
        GameShip bigShip = new Ship(Arrays.asList(new Coordinate(F, 10), new Coordinate(G, 10), new Coordinate(H, 10)));
        Set<GameShipAreaWrapper> expectedShipsInCache = new HashSet(Arrays.asList(new ShipAreaWrapper(smallShip),
                new ShipAreaWrapper(mediumShip), new ShipAreaWrapper(bigShip)));

        // when
        shipCache.registerOrUpdate(smallShip);
        shipCache.registerOrUpdate(mediumShip);
        shipCache.registerOrUpdate(bigShip);

        // then
        assertTrue(SetUtils.isEqualSet(shipCache.getCachedShipsAreas().values(), expectedShipsInCache));
    }


}
