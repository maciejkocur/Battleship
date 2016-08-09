package controller.communication;


import components.ClientFactory;
import model.client.Client;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bartlomiej on 04.08.16.
 */
public class Receiver {

    private static final Logger receiverLog = Logger.getLogger(Receiver.class);

    private final static String INITIALIZATION_URI = "battleship/init";
    private final static String TURN_URI = "battleship/turn";
    private final static String SHOT_URI = "battleship/shot";
    private final static String WIN_URI = "battleship/win";

    public static Boolean isInitialized() {
        receiverLog.info("The information if the game is initialized has been received." +
                "\nFrom URI: " + INITIALIZATION_URI);
        return true;
    }

    public static Client whoseTurn() {
        receiverLog.info("The information in form of the player has been received." +
                "\nFrom URI: " + TURN_URI +
                "\nCurrent player turn is:" + ClientFactory.getClient());
        return ClientFactory.getClient();
    }

    public static Boolean isWon() {
        receiverLog.info("The information is the game has been won has been received." +
                "\nFrom URI: " +WIN_URI);
        return true;
    }

    public Boolean wasShot() {
        receiverLog.info("The information if the ship was hit has been received." +
                "\nFrom URI: " +SHOT_URI);
        return false;
    }
}
