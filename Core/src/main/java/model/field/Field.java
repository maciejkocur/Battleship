package model.field;

/**
 * Created by Hawk on 2016-07-15.
 */
public class Field {
    private String letter;
    private String digit;
    private Boolean isOccupied = Boolean.FALSE;

    public Field(String letter, String digit) {
        this.letter = letter;
        this.digit = digit;
    }

    public String showCoordinates() {
        return letter.concat(digit);
    }

    public void makeOccupied() {
        this.isOccupied = Boolean.TRUE;
    }

    public Boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Field other = (Field) object;
        return this.letter.equals(other.letter) && this.digit.equals(other.digit) && this.isOccupied.equals(other.isOccupied);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + letter.hashCode();
        result = 31*result + digit.hashCode();
        result = 31*result + (isOccupied ? 1 : 0);
        return result;
    }
}
