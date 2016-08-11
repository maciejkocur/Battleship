package model.ship.wrapper.impl;

import model.coordinate.Coordinate;
import model.ship.Ship;
import model.ship.wrapper.ShipAreaWrapper;
import model.ship.wrapper.util.BattleshipAreaResolver;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Representation of fields (list of {@link Coordinate}) around ship. Specific implementation of {@link ShipAreaWrapper}
 *
 * @author Ogre
 */
public class BattleshipAreaWrapper implements ShipAreaWrapper {
    private volatile int hashCode = 0;
    private List<Coordinate> coordinatesAroundShip;

    public BattleshipAreaWrapper(Ship ship) {
        coordinatesAroundShip = BattleshipAreaResolver.findCoordinatesAroundShip(ship);
    }

    /**
     * @see ShipAreaWrapper
     */
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
