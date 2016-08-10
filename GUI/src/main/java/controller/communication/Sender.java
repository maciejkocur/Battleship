package controller.communication;

import components.ClientFactory;
import model.Coordinates;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by bartlomiej on 04.08.16.
 */
public class Sender {

    private static final String COORD_URI = "battleship/coordinates";
    private static final String PLAYER_URI = "battleship/player";
    private static Logger senderLog = LogManager.getLogger(Sender.class);
    private HttpClient httpClient = HttpClientBuilder.create().build();
    private HttpPost httpPost;
    private JSONObject jsonObject;
    private StringEntity stringEntity;
    private HttpResponse httpResponse;
    private Coordinates coord;

    private void sendCoordinates() {
        coord = Coordinates.getCoordinates();
        jsonObject = new JSONObject();
        jsonObject.put("gameID", coord.getGameId());
        jsonObject.put("playerID", coord.getPlayerId());
        jsonObject.put("x", coord.getX());
        jsonObject.put("y", coord.getY());
        httpPost = new HttpPost(COORD_URI);
        try {
            stringEntity = new StringEntity(jsonObject.toString());

            httpPost.setEntity(stringEntity);

            httpResponse = httpClient.execute(httpPost);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String line;
            while ((line = reader.readLine()) != null) {
                senderLog.info(line + "\n");
            }
        } catch (UnsupportedEncodingException uEE) {
            senderLog.error("UnsupportedEncodingException", uEE);

        } catch (IOException e) {
            senderLog.error("IOException", e);
        }

        senderLog.info("The coordinates for this game have been sent." +
                "\nThe coordinates are:" +
                "\nGameId: " + coord.getGameId() +
                "\nPlayerId: " + coord.getPlayerId() +
                "\nX: " + coord.getX() +
                "\nY: " + coord.getY() +
                "\non URI: " + COORD_URI);
    }


    public void sendPlayer() {
        coord = Coordinates.getCoordinates();
        jsonObject = new JSONObject();
        jsonObject.put("playerID", coord.getPlayerId());
        httpPost = new HttpPost(PLAYER_URI);
        try {
            stringEntity = new StringEntity(jsonObject.toString());

            httpPost.setEntity(stringEntity);

            httpResponse = httpClient.execute(httpPost);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String line;
            while ((line = reader.readLine()) != null) {
                senderLog.info(line + "\n");
            }
        } catch (UnsupportedEncodingException uEE) {
            senderLog.error("UnsupportedEncodingException", uEE);

        } catch (IOException e) {
            senderLog.error("IOException", e);
        }

        senderLog.info("The Player ID has been sent." +
                "\nID: " + ClientFactory.getClient() +
                "\non URI: " + PLAYER_URI);

    }


}

