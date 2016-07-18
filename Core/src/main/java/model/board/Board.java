package model.board;

import model.board.initializer.BoardFieldsInitializer;
import model.coordinate.Coordinate;
import model.field.Field;

import java.util.Map;

/**
 * Created by Hawk on 2016-07-15.
 */
public class Board {

    private Map<Coordinate, Field> fields = BoardFieldsInitializer.getInitialFields();

    public void placePlayerMove(Field field) {
        fields.put(field.showCoordinates(), field);
    }

    public Field getFieldForCoordinate(Coordinate coordinate) {
        return fields.get(coordinate);
    }

    public String display() {
        return fields.toString();
    }
}
