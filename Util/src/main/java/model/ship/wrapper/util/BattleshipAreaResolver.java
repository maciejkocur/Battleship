package model.ship.wrapper.util;

import model.coordinate.Coordinate;
import model.coordinate.Sign;
import model.ship.Ship;
import org.apache.commons.collections4.ListUtils;

import java.util.*;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.J;

/**
 * Computes list of {@link Coordinate}s around {@link Ship}
 *
 * @author Ogre
 */
public class BattleshipAreaResolver {

    /**
     * Computes list of {@link Coordinate}s around {@link Ship}
     *
     * @param ship for which nearby coordinates will be computed
     * @return list of coordinates around the ship
     */
    public static List<Coordinate> findCoordinatesAroundShip(Ship ship) {
        Set<Coordinate> allCoordinates = new HashSet<>();
        for (Coordinate shipCoordinate : ship.getCoordinates()) {
            allCoordinates.addAll(findCoordinatesRow(shipCoordinate.showSign(), shipCoordinate.showDigit()));
            if (!shipCoordinate.showSign().equals(A)) {
                allCoordinates.addAll(findCoordinatesRow(shipCoordinate.showSign().previous(), shipCoordinate.showDigit()));
            }
            if (!shipCoordinate.showSign().equals(J)) {
                allCoordinates.addAll(findCoordinatesRow(shipCoordinate.showSign().next(), shipCoordinate.showDigit()));
            }
        }
        List<Coordinate> coordinatesAroundShip = ListUtils.subtract(new ArrayList(allCoordinates), ship.getCoordinates());
        Collections.sort(coordinatesAroundShip);
        return coordinatesAroundShip;
    }

    private static List<Coordinate> findCoordinatesRow(Sign sign, Integer digit) {
        List<Coordinate> coordinatesInRow = new ArrayList<>();
        // left
        if (digit - 1 > 0)
            coordinatesInRow.add(new Coordinate(sign, digit - 1));
        // current
        coordinatesInRow.add(new Coordinate(sign, digit));
        // right
        if (digit + 1 < 10)
            coordinatesInRow.add(new Coordinate(sign, digit + 1));
        return coordinatesInRow;
    }

}
