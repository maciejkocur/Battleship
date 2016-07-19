package model.ship;

import model.coordinate.Coordinate;
import org.apache.commons.collections.ListUtils;

import java.util.List;

/**
 * Created by lucz on 18.07.16.
 */
public class Ship {

    private volatile int hashcode = 0;
    private List<Coordinate> coordinates;

    public Ship(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

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
    public int hashCode(){
        if(hashcode==0) {
            hashcode = 19;
            for(Coordinate coordinate : coordinates){
                hashcode = 41*hashcode + coordinate.hashCode();
            }
        }
        return hashcode;
    }
}
