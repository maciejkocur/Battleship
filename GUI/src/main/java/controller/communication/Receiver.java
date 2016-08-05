package controller.communication;


import model.Player;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bartlomiej on 04.08.16.
 */
public class Receiver {

    private final static String initializationUri = "";
    private final static String turnUri = "";
    private final static String shotUri = "";
    private final static String winUri = "";

    public static Boolean isInitialized() {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject(initializationUri, Boolean.class);
    }

    public static Player whoseTurn() {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject(turnUri, Player.class);
    }

    public Boolean wasShot() {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject(shotUri, Boolean.class);
    }

    public static Boolean isWon() {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject(winUri, Boolean.class);
    }
}
