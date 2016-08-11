package components;

/**
 * Created by kuba on 08.08.16.
 */

enum Orientation {
    Horizontal, Vertical;

    private static Orientation[] values = values();

    public Orientation next() {
        return values[(ordinal() + 1) % values.length];
    }
}
