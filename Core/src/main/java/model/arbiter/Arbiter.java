package model.arbiter;

import model.field.Coordinate;

import java.util.List;

public class Arbiter {

    private List<Coordinate> coordinates;

    public void addCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    boolean contains(Coordinate coordinates) {
        return this.coordinates.contains(coordinates);
    }

    public void updateCoordinatesForMove(Coordinate coordinate) {
        coordinates.remove(coordinate);
    }

    public boolean checkWinningCondition() {
        return coordinates.size() == 0;
    }
}
