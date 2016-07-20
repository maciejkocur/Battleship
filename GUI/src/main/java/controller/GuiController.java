package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bartlomiej on 19.07.16.
 */
public class GuiController {

    private Messenger messenger = new Messenger();

    @FXML
    private void fireAway(ActionEvent event){
        Node source = (Node)event.getSource();

        source.setOpacity(1.0);


        System.out.println("Hello " + "This is the row : "+GridPane.getRowIndex(source)+"\nAnd column: "+ GridPane.getColumnIndex(source));

        messenger.sendShootCoords(GridPane.getRowIndex(source),GridPane.getColumnIndex(source));
        source.setDisable(true);
        }




}
