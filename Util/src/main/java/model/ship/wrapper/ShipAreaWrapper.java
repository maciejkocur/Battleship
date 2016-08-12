package model.ship.wrapper;

import model.coordinate.Coordinate;

import java.util.List;

/**
 * Wrapper interface. Contains only one method that returns list of {@link Coordinate}s around {@link model.ship.Ship}
 *
 * @author Ogre
 */

public interface ShipAreaWrapper {
    /**
     *  Returns list of {@link Coordinate}s around {@link model.ship.Ship}
     *
     * @return list of coordinates around ship
     */
    List<Coordinate> getCoordinatesAroundShip();
}
