package model.ship.wrapper;

import model.coordinate.Coordinate;

import java.util.List;

/**
 * Created by lucz on 01.08.16.
 */
public interface GameShipAreaWrapper {
    List<Coordinate> getCoordinatesAroundShip();
}
