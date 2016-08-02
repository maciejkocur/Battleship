package controller;

import config.CoordinatesConfiguration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import model.Player;

/**
 * Created by bartlomiej on 19.07.16.
 */
public class ShootController {

    private CoordinatesConfiguration coordinatesConfiguration = new CoordinatesConfiguration();
    private Player currentPlayer;

    @FXML
    private void fireAway(ActionEvent event){
        Node source = (Node)event.getSource();

        source.setOpacity(1.0);


        System.out.println("Hello " + "This is the row : "+GridPane.getRowIndex(source)+"\nAnd column: "+ GridPane.getColumnIndex(source));
        coordinatesConfiguration.setPlayerID(currentPlayer.getID());
        coordinatesConfiguration.setX(GridPane.getRowIndex(source));
        coordinatesConfiguration.setY(GridPane.getColumnIndex(source));
        source.setDisable(true);
        }




}
