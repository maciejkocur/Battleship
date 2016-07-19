package controller.cache;

import model.ship.Ship;
import model.ship.wrapper.ShipAreaWrapper;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucz on 18.07.16.
 */
public class ShipCache {

    Set<ShipAreaWrapper> ships = new HashSet<>();

    public boolean registerShip(Ship ship) {
        return ships.add(new ShipAreaWrapper(ship));
    }

}
