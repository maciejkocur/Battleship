package model.ship;

import model.coordinate.Coordinate;
import model.ship.impl.Battleship;

import java.util.List;

/**
 * Basic behaviour of ship on game board
 *
 * @author Ogre
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
    Ship moveTo(List<Coordinate> newCoordinates);
}
