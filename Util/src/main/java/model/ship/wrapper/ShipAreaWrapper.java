package model.ship.wrapper;

import com.sun.org.apache.regexp.internal.RE;
import model.coordinate.Coordinate;
import model.ship.Ship;
import org.apache.commons.collections.ListUtils;

import java.util.List;


public class ShipAreaWrapper {
    private volatile int hashCode = 0;
    private Ship ship;
    private List<Coordinate> coordinatesAroundShip;

    public ShipAreaWrapper(Ship ship) {
        this.ship = ship;
        coordinatesAroundShip = ShipAreaResolver.findCoordinatesAroundShip(ship);
    }

    public Ship getShip() {
        return ship;
    }

    public List<Coordinate> getCoordinatesAroundShip() {
        return coordinatesAroundShip;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        ShipAreaWrapper other = (ShipAreaWrapper) object;
        return ship.equals(other.ship) && ListUtils.isEqualList(coordinatesAroundShip, other.coordinatesAroundShip);
    }

    @Override
    public int hashCode(){
        if(hashCode==0) {
            hashCode = 21;
            hashCode = 39*hashCode + ship.hashCode();
            for(Coordinate coordinate : coordinatesAroundShip){
                hashCode = 39*hashCode + coordinate.hashCode();
            }
        }
        return hashCode;
    }
}
