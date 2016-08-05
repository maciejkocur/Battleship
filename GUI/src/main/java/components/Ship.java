package components;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.Serializable;


public class Ship extends AnchorPane implements Serializable, Cloneable {

    public Ship() {
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
        return new Ship();
    }
}