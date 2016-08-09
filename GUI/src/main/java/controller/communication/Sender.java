package controller.communication;

import components.ClientFactory;
import model.Coordinates;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartlomiej on 04.08.16.
 */
public class Sender {

    private static final String COORD_URI = "battleship/coordinates";
    private static final String PLAYER_URI = "battleship/player";
    private static Logger senderLog = Logger.getLogger(Sender.class);

    private static void sendCoordinates() {
        Coordinates coord = Coordinates.getCoordinates();


        List coordinates = new ArrayList();
        coordinates.add(coord.getGameId());
        coordinates.add(coord.getPlayerId());
        coordinates.add(coord.getX());
        coordinates.add(coord.getY());

        senderLog.info("The coordinates for this game have been sent." +
                "\nThe coordinates are:" +
                "\nGameId: " + coord.getGameId() +
                "\nPlayerId: " + coord.getPlayerId() +
                "\nX: " + coord.getX() +
                "\nY: " + coord.getY() +
                "\non URI: " + COORD_URI);
    }


    public static void sendPlayer() {
        senderLog.info("The Player ID has been sent." +
                "\nID: " + ClientFactory.getClient() +
                "\non URI: " + PLAYER_URI);

    }
}
