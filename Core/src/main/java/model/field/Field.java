package model.field;

/**
 * Created by Hawk on 2016-07-15.
 */
public class Field {
    private String letter;
    private String digit;

    public Field(String letter, String digit) {
        this.letter = letter;
        this.digit = digit;
    }

    public String showCoordinates() {
        return "A1";
    }
}
