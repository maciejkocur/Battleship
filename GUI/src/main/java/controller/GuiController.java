package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bartlomiej on 19.07.16.
 */
public class GuiController {

    @FXML private Button button ;


    @FXML
    private void fireAway(ActionEvent event){
        Node source = (Node)event.getSource();
        System.out.println("Hello " + "This is the row : "+GridPane.getRowIndex(source)+"\nAnd column: "+ GridPane.getColumnIndex(source));
        }



//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//        @Override
//        public void handle(ActionEvent event) {
//            lbl.setText("Hello, World.");
//        }
//    });
}
