package controller.cache.impl;

import controller.cache.GameShipCache;
import model.ship.GameShip;
import model.ship.wrapper.GameShipAreaWrapper;
import model.ship.wrapper.impl.ShipAreaWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucz on 18.07.16.
 */
public class ShipCache implements GameShipCache {

    private Map<GameShip, GameShipAreaWrapper> cachedShips = new HashMap<>();

    @Override
    public void registerOrUpdate(GameShip ship) {
        cachedShips.put(ship, new ShipAreaWrapper(ship));
    }

    @Override
    public void remove(GameShip ship) {
        cachedShips.remove(ship);
    }

    @Override
    public GameShipAreaWrapper getCachedAreaForShip(GameShip ship) {
        return cachedShips.get(ship);
    }

    @Override
    public Map<GameShip, GameShipAreaWrapper> getCachedShipsAreas() {
        return cachedShips;
    }


}
