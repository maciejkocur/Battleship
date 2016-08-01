package model.ship;

import model.coordinate.Coordinate;
import model.ship.impl.Ship;

import java.util.List;

/**
 * Created by lucz on 01.08.16.
 */
public interface GameShip {
    List<Coordinate> getCoordinates();

    Ship moveTo(List<Coordinate> newCoordinates);
}
