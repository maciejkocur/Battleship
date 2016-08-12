package model.ship.impl;

import model.coordinate.Coordinate;
import model.ship.Ship;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Representation of battleship. Implements {@link Ship} interface
 *
 * @author Ogre
 */
public class Battleship implements Ship {

    private volatile int hashcode = 0;
    private List<Coordinate> coordinates;

    public Battleship(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @see Ship
     */
    @Override
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    /**
     * @see Ship
     */
    @Override
    public Ship moveTo(List<Coordinate> newCoordinates) {
        return new Battleship(newCoordinates);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Battleship other = (Battleship) object;
        return ListUtils.isEqualList(coordinates, other.coordinates);
    }

    @Override
    public int hashCode() {
        if (hashcode == 0) {
            int result = 19;
            for (Coordinate coordinate : coordinates) {
                result = 41 * result + coordinate.hashCode();
            }
        }
        return hashcode;
    }

}
