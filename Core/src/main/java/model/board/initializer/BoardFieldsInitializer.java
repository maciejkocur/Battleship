package model.board.initializer;

import model.field.Field;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Hawk on 2016-07-15.
 */
public class BoardFieldsInitializer {

    public Map<String, Field> initializeFields() {
        Map<String, Field> fields = new TreeMap<>();
            for(Letter letter : Letter.values()){
                for(int i=1; i<=10; i++)
                    fields.put(generateCoordinate(letter, i), createField(letter, i));
            }
        return fields;
    }

    private String generateCoordinate(Letter letter, Integer digit){
        return letter.toString().concat(digit.toString());
    }

    private Field createField(Letter letter, Integer digit){
        return new Field(letter.toString(), digit.toString());
    }
}
