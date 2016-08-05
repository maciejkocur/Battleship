package model.ship;

import model.coordinate.Coordinate;

import java.util.List;

/**
 * Created by lucz on 01.08.16.
 */

public interface Ship {

    List<Coordinate> getCoordinates();
    Ship moveTo(List<Coordinate> newCoordinates);

}
