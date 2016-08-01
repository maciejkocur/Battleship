package controller.cache.impl;

import controller.cache.ShipCache;
import model.coordinate.Coordinate;
import model.ship.Ship;
import model.ship.impl.Battleship;
import model.ship.wrapper.ShipAreaWrapper;
import model.ship.wrapper.impl.BattleshipAreaWrapper;
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
public class BattleshipCacheTest {

    @Test
    public void testRegisterShipAndGet() {
        // given
        ShipCache shipCache = new BattleshipCache();
        Ship smallShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        ShipAreaWrapper smallShipAreaWrapper = new BattleshipAreaWrapper(smallShip);

        // when
        shipCache.registerOrUpdate(smallShip);

        // - then
        assertEquals(shipCache.getCachedAreaForShip(smallShip), smallShipAreaWrapper);
    }

    @Test
    public void testRemoveShipFromCache() {
        // given
        ShipCache shipCache = new BattleshipCache();
        Ship smallShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));

        // when
        shipCache.registerOrUpdate(smallShip);
        shipCache.remove(smallShip);

        // - then
        assertNull(shipCache.getCachedAreaForShip(smallShip));
    }

    @Test
    public void testGetCachedShips() {
        // given
        ShipCache shipCache = new BattleshipCache();
        Ship smallShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        Ship mediumShip = new Battleship(Arrays.asList(new Coordinate(C, 1), new Coordinate(D, 1)));
        Ship bigShip = new Battleship(Arrays.asList(new Coordinate(F, 10), new Coordinate(G, 10), new Coordinate(H, 10)));
        Set<ShipAreaWrapper> expectedShipsInCache = new HashSet(Arrays.asList(new BattleshipAreaWrapper(smallShip),
                new BattleshipAreaWrapper(mediumShip), new BattleshipAreaWrapper(bigShip)));

        // when
        shipCache.registerOrUpdate(smallShip);
        shipCache.registerOrUpdate(mediumShip);
        shipCache.registerOrUpdate(bigShip);

        // then
        assertTrue(SetUtils.isEqualSet(shipCache.getCachedShipsAreas().values(), expectedShipsInCache));
    }


}
