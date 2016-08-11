package model.coordinate;

/**
 * Enum which represents horizontal coordinates on battleship game board
 *
 * @author Ogre
 */
public enum Sign {
    A, B, C, D, E, F, G, H, I, J;

    private static Sign[] values = values();

    /**
     * Returns next element from enum.
     * If method is called on last element returns first element
     *
     * @return next element of enum
     */
    public Sign next() {
        return values[(ordinal() + 1) % values.length];
    }

    /**
     * Returns previous element from enum.
     * If method is called on first element returns last element
     *
     * @return previous element of enum
     */
    public Sign previous() {
        return values[(ordinal() - 1 == -1 ? values.length - 1 : ordinal() - 1) % values.length];
    }
}
