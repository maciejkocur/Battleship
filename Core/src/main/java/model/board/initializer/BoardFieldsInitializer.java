package model.board.initializer;

import model.coordinate.Coordinate;
import model.field.Field;
import model.coordinate.Sign;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Hawk on 2016-07-15.
 */
public class BoardFieldsInitializer {

    public static Map<Coordinate, Field> getInitialFields() {
        Map<Coordinate, Field> fields = new TreeMap<>();
            for(Sign sign : Sign.values()){
                for(int i=1; i<=10; i++) {
                    Coordinate coordinate = new Coordinate(sign, i);
                    fields.put(coordinate, new Field(coordinate));
                }
            }
        return fields;
    }
}
