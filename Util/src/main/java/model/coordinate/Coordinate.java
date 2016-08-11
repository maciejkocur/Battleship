package model.coordinate;

/**
 * Representation of coordinates on battleship board.
 *
 * @author kuba
 */
public class Coordinate implements Comparable<Coordinate> {

    private Integer digit;
    private Sign sign;

    public Coordinate(Sign sign, Integer digit) {
        this.sign = sign;
        this.digit = digit;
    }

    /**
     * Returns {@link Sign} of coordinate object
     *
     * @return sign of coordinate
     */
    public Sign showSign() {
        return sign;
    }

    /**
     * Returns {@link Integer} of coordinate object
     *
     * @return digit of coordinate
     */
    public Integer showDigit() {
        return digit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Coordinate other = (Coordinate) object;
        return this.sign.equals(other.sign) && this.digit.equals(other.digit);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + sign.hashCode();
        result = 31 * result + digit.hashCode();
        return result;
    }

    @Override
    public int compareTo(Coordinate coordinate) {
        int signCompare = this.sign.compareTo(coordinate.sign);
        if (signCompare != 0) return signCompare;
        int digitCompare = this.digit.compareTo(coordinate.digit);
        if (digitCompare != 0) return digitCompare;
        return 0;
    }

    @Override
    public String toString() {
        return sign.toString().concat(digit.toString());
    }

}
