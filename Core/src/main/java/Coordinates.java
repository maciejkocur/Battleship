


public class Coordinates {

    private String digit;
    private String sign;

    public Coordinates(String digit, String sign) {
        this.digit = digit;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return digit + sign;

    }
}
