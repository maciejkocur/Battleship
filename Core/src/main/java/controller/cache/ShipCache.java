package controller.cache;

import model.ship.Ship;
import model.ship.wrapper.ShipAreaWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucz on 18.07.16.
 */
public class ShipCache {

    private Map<Ship, ShipAreaWrapper> cachedShips = new HashMap<>();

    public void registerOrUpdate(Ship ship) {
        cachedShips.put(ship, new ShipAreaWrapper(ship));
    }

    public void remove(Ship ship) {
        cachedShips.remove(ship);
    }

    public ShipAreaWrapper getCacheForShip(Ship ship) {
        return cachedShips.get(ship);
    }

    public Map<Ship, ShipAreaWrapper> getCachedShipAreas() {
        return cachedShips;
    }


}
