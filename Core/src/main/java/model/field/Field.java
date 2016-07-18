package model.field;

import model.coordinate.Coordinate;

/**
 * Created by Hawk on 2016-07-15.
 */
public class Field {
    private Coordinate coordinate;
    private Boolean isOccupied = Boolean.FALSE;

    public Field(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Field(Coordinate coordinate, Boolean isOccupied){
        this.coordinate = coordinate;
        this.isOccupied = isOccupied;
    }

    public Coordinate showCoordinates() {
        return coordinate;
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
        return this.coordinate.equals(other.coordinate) && this.isOccupied.equals(other.isOccupied);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + coordinate.hashCode();
        result = 31*result + (isOccupied ? 1 : 0);
        return result;
    }

    @Override
    public String toString(){
        return coordinate.toString().concat(", occupied=").concat(String.valueOf(isOccupied));
    }
}
