package controller.cache;

import model.ship.GameShip;
import model.ship.wrapper.GameShipAreaWrapper;

import java.util.Map;

/**
 * Created by lucz on 01.08.16.
 */
public interface GameShipCache {
    void registerOrUpdate(GameShip ship);

    void remove(GameShip ship);

    GameShipAreaWrapper getCachedAreaForShip(GameShip ship);

    Map<GameShip, GameShipAreaWrapper> getCachedShipsAreas();
}
