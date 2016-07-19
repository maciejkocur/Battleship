package model;

/**
 * Created by bartlomiej on 19.07.16.
 */
public abstract class Ship {
    private int health;

    public boolean isAlive(){
        return health>0;
    }
}
