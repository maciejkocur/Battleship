package model;

/**
 * Created by bartlomiej on 02.08.16.
 */
public class Player {

    private int id;

    private static final Player p = new Player();

    private Player(){
        generateID();
    }

    public static Player getPlayer(){return p;};
    public void generateID(){
        this.id = (int)Math.random()*100;
    }

    public int getID() {
        return id;
    }
}
