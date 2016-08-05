package controller;

import javafx.scene.layout.Pane;

/**
 * Created by bartlomiej on 05.08.16.
 */
public class TurnController {


    public void opponentsTurn(Pane pane) {
        pane.toFront();
    }


    public void yourTurn(Pane pane) {
        pane.toBack();
    }
}
