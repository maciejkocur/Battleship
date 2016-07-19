package controller.arbiter;

import model.coordinate.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Arbiter {

    private List<Coordinate> coordinates = new ArrayList<>();

    public void addCoordinates(List<Coordinate> coordinates) {
        this.coordinates.addAll(coordinates);
    }

    boolean contains(Coordinate coordinates) {
        return this.coordinates.contains(coordinates);
    }

    public boolean checkWinningCondition() {
        return coordinates.size() == 0;
    }

    public boolean isHit(Coordinate coordinate) {
        return coordinates.remove(coordinate);
    }
}
