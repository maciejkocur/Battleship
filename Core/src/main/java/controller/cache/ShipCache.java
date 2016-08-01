package controller.cache;

import model.ship.Ship;
import model.ship.wrapper.ShipAreaWrapper;

import java.util.Map;

/**
 * Created by lucz on 01.08.16.
 */
public interface ShipCache {
    void registerOrUpdate(Ship ship);

    void remove(Ship ship);

    ShipAreaWrapper getCachedAreaForShip(Ship ship);

    Map<Ship, ShipAreaWrapper> getCachedShipsAreas();
}
