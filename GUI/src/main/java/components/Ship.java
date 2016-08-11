package components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.coordinate.Coordinate;
import model.coordinate.Sign;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Ship extends AnchorPane implements Serializable, Cloneable {

    private static Logger log = LogManager.getLogger(Ship.class);
    private int size = 2;
    private List<Coordinate> coordinates = new ArrayList<>();
    private Orientation orientation = Orientation.Vertical;


    public Ship() {
        init();
    }

    protected Ship(Ship other) {
        init();
        this.size = other.size;
        this.coordinates = new ArrayList<>(other.coordinates);
        this.orientation = other.orientation;
        this.setRotate(other.getRotate());
    }

    private void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ships/ship.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Ship clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new Ship(this);
    }

    public void generateCoordinates(int x, int y) {
        coordinates.clear();
        for (int i = 0; i < size; i++) {
            coordinates.add( !isOrientationVertical() ? new Coordinate(Sign.valueOf(x++), y + 1) : new Coordinate(Sign.valueOf(x), ++y));
        }
    }

    public void rotateShip() {
        setRotate(isOrientationVertical() ? getRotate() + 270 : getRotate() + 90);
        setMaxHeight(getWidth());
        setMaxWidth(getHeight());
        orientation = orientation.next();
    }


    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public boolean isOrientationVertical(){
       return orientation.equals(Orientation.Vertical);
    }

    public int countToSpawn() {
        return size - 1;
    }
}