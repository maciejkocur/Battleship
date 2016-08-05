package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import model.Coordinates;
import model.Player;


/**
 * Created by bartlomiej on 19.07.16.
 */
public class ShootController {


    private Player currentPlayer;
    private Coordinates coordinates;

    @FXML
    private void fireAway(ActionEvent event) {
        Node source = (Node) event.getSource();
        currentPlayer = Player.getPlayer();
        source.setOpacity(1.0);
        coordinates = Coordinates.getCoordinates();

        System.out.println("Hello " + "This is the row : " + GridPane.getRowIndex(source) + "\nAnd column: " + GridPane.getColumnIndex(source));
        coordinates.setPlayerId(currentPlayer.getID());
        coordinates.setX(GridPane.getRowIndex(source));
        coordinates.setY(GridPane.getRowIndex(source));

        source.setDisable(true);
    }


}
