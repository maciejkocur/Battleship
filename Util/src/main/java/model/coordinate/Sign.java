package model.coordinate;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enum which represents horizontal coordinates on battleship game board
 *
 * @author Ogre
 */
public enum Sign {
    A(0) , B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8), J(9);

    private int ID;

    private static Sign[] values = values();

    Sign(int ID) {
        this.ID = ID;
    }

    public static Sign valueOf(int ID){
        return Arrays.stream(values()).filter(sign -> sign.ID==ID).findFirst().get();
    }

    /**
     * Returns next element from enum.
     * If method is called on last element returns first element
     *
     * @return next element of enum
     */
    public Sign next() {
        return values[(ordinal()+1) % values.length];
    }

    /**
     * Returns previous element from enum.
     * If method is called on first element returns last element
     *
     * @return previous element of enum
     */
    public Sign previous() {
        return values[(ordinal()-1==-1 ? values.length-1 : ordinal()-1) % values.length];
    }
}
