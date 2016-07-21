package components;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class Ship extends AnchorPane {


    private Point2D mDragOffset = new Point2D(0.0, 0.0);


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

}