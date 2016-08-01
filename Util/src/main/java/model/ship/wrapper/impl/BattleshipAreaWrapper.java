package model.ship.wrapper.impl;

import model.coordinate.Coordinate;
import model.ship.Ship;
import model.ship.wrapper.ShipAreaWrapper;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Created by lucz on 18.07.16.
 */
public class BattleshipAreaWrapper implements ShipAreaWrapper {
    private volatile int hashCode = 0;
    private List<Coordinate> coordinatesAroundShip;

    public BattleshipAreaWrapper(Ship ship) {
        coordinatesAroundShip = BattleshipAreaResolver.findCoordinatesAroundShip(ship);
    }

    @Override
    public List<Coordinate> getCoordinatesAroundShip() {
        return coordinatesAroundShip;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        BattleshipAreaWrapper other = (BattleshipAreaWrapper) object;
        return ListUtils.isEqualList(coordinatesAroundShip, other.coordinatesAroundShip);
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = 21;
            for (Coordinate coordinate : coordinatesAroundShip) {
                hashCode = 39 * hashCode + coordinate.hashCode();
            }
        }
        return hashCode;
    }
}
