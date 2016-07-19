package model.coordinate;

/**
 * Created by Hawk on 2016-07-15.
 */
public enum Sign {
    A, B, C, D, E, F, G, H, I, J;

    private static Sign[] values = values();

    public Sign next()
    {
        return values[(ordinal()+1) % values.length];
    }

    public Sign previous()
    {
        return values[(ordinal()-1==-1 ? values.length-1 : ordinal()-1) % values.length];
    }
}
