package model.ship.impl;

import model.coordinate.Coordinate;
import model.ship.GameShip;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Created by lucz on 18.07.16.
 */
public class Ship implements GameShip {

    private volatile int hashcode = 0;
    private List<Coordinate> coordinates;

    public Ship(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    @Override
    public Ship moveTo(List<Coordinate> newCoordinates) {
        return new Ship(newCoordinates);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Ship other = (Ship) object;
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
