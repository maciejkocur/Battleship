package controller.engine;

import components.ClientFactory;
import controller.TurnController;
import controller.communication.Receiver;
import controller.communication.Sender;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

/**
 * Created by bartlomiej on 04.08.16.
 */
public class GuiEngine {
    @FXML
    public Pane cover;

    private TurnController turnController = new TurnController();

    public void startGame() {
        Sender.sendPlayer();
        if (Receiver.isInitialized()) {
            while (!Receiver.isWon()) {
                if (Receiver.whoseTurn() == ClientFactory.getClient())
                    turnController.yourTurn(cover);
                else turnController.opponentsTurn(cover);
            }
        }
    }


}
