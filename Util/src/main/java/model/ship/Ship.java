package model.ship;

import model.coordinate.Coordinate;
import model.ship.impl.Battleship;

import java.util.List;

/**
 * @author Ogre
 *
 * Basic behaviour of ship on game board
 */

public interface Ship {
    /**
     * Returns list of ship coordinates
     *
     * @return list of ship coordinates
     */
    List<Coordinate> getCoordinates();

    /**
     * Changes ship coordinates and returns new object
     *
     * @param newCoordinates list of new coordinates
     * @return new instance of ship with new coordinates
     */
    Battleship moveTo(List<Coordinate> newCoordinates);
}
