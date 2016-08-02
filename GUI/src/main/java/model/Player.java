package model;

/**
 * Created by bartlomiej on 02.08.16.
 */
public class Player {

    private int id;

    public void generateID(){
        this.id = (int)Math.random()*100;
    }

    public int getID() {
        return id;
    }
}
