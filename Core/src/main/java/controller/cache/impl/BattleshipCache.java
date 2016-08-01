package controller.cache.impl;

import controller.cache.ShipCache;
import model.ship.Ship;
import model.ship.wrapper.ShipAreaWrapper;
import model.ship.wrapper.impl.BattleshipAreaWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucz on 18.07.16.
 */
public class BattleshipCache implements ShipCache {

    private Map<Ship, ShipAreaWrapper> cachedShips = new HashMap<>();

    @Override
    public void registerOrUpdate(Ship ship) {
        cachedShips.put(ship, new BattleshipAreaWrapper(ship));
    }

    @Override
    public void remove(Ship ship) {
        cachedShips.remove(ship);
    }

    @Override
    public ShipAreaWrapper getCachedAreaForShip(Ship ship) {
        return cachedShips.get(ship);
    }

    @Override
    public Map<Ship, ShipAreaWrapper> getCachedShipsAreas() {
        return cachedShips;
    }


}
