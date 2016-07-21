package controller;

import components.Ship;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Created by bartlomiej on 19.07.16.
 */
public class GuiController {

    private Point2D point;
    private Point2D startPoint;
    private Ship source;

    @FXML
    private void fireAway(ActionEvent event) {
        Node source = (Node) event.getSource();

        source.setOpacity(1.0);


        System.out.println("Hello " + "This is the row : " + GridPane.getRowIndex(source) + "\nAnd column: " + GridPane.getColumnIndex(source));


        source.setDisable(true);
    }


    public void grabbing(MouseEvent event) {
        Ship source = (Ship) event.getSource();
        point = new Point2D(source.getLayoutX() - event.getSceneX(), source.getLayoutY() - event.getSceneY());
        startPoint = new Point2D(source.getLayoutX(), source.getLayoutY());
    }

    public void dragging(MouseEvent event) {
        source = (Ship) event.getSource();
        source.setLayoutX(point.getX() + event.getSceneX());
        source.setLayoutY(point.getY() + event.getSceneY());
        source.toFront();
    }

    public void stopDragging(MouseEvent event) {
        if (source != null) {
            Node lookup = ((Node) event.getSource()).lookup("#shipBoard");
            if (!lookup.getBoundsInLocal().contains(source.getLayoutX() + event.getSceneX(), source.getLayoutY() + event.getSceneY())) {
                System.out.println("test1");
                source.setLayoutX(startPoint.getX());
                source.setLayoutY(startPoint.getY());
            }
            source = null;
        }
    }
}
