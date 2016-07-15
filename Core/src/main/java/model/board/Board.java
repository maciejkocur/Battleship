package model.board;

import model.field.Field;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Hawk on 2016-07-15.
 */
public class Board {

    private Map<String, Field> fields = new TreeMap<>();

    public void placePlayerMove(Field field) {
        fields.put(field.showCoordinates(), field);
    }

    public Field getFieldForCoordinates(String letter, String digit) {
        return new Field(letter, digit);
    }
}
