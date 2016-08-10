package controller.communication;


import components.ClientFactory;
import model.client.Client;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;


/**
 * Created by bartlomiej on 04.08.16.
 */
public class Receiver {

    public static final Logger receiverLog = LogManager.getLogger(Receiver.class);

    private final static String INITIALIZATION_URI = "battleship/init";
    private final static String TURN_URI = "battleship/turn";
    private final static String SHOT_URI = "battleship/shot";
    private final static String WIN_URI = "battleship/win";
    private HttpClient httpClient = HttpClientBuilder.create().build();
    private HttpGet httpGet;
    private HttpResponse httpResponse;
    private BufferedReader reader;
    private StringBuilder sb;
    private JSONObject jsonObject;
    private String responseLine;
    private HttpHelper httpHelper = new HttpHelper();


    public Boolean isInitialized() {
        receiverLog.info("The information if the game is initialized has been received." +
                "\nFrom URI: " + INITIALIZATION_URI +
                "\nThe value is:" + jsonObject.getString("init"));
        try {
            return httpHelper.httpHelper(INITIALIZATION_URI).getString("isInitialized").equals("true");
        } catch (IOException ioE) {
            receiverLog.error("IOException",ioE);
            return false;
        }
    }

    public Client whoseTurn() {
        receiverLog.info("The information in form of the player has been received." +
                "\nFrom URI: " + TURN_URI);
        try {
            return new Client(UUID.fromString(httpHelper.httpHelper(TURN_URI).getString("UUID")));
        } catch (IOException ioE) {
            receiverLog.error("IOException",ioE);
            return ClientFactory.getClient();
        }
    }

    public Boolean isWon() {
        receiverLog.info("The information is the game has been won has been received." +
                "\nFrom URI: " + WIN_URI);
        try {
            return httpHelper.httpHelper(WIN_URI).getString("isWon").equals("won");
        } catch (IOException ioE) {
            receiverLog.error("IOException",ioE);
            return false;
        }
    }

    public Boolean wasShot() {
        receiverLog.info("The information if the ship was hit has been received." +
                "\nFrom URI: " + SHOT_URI);
        try {
            return httpHelper.httpHelper(SHOT_URI).getString("isShot").equals("true");
        } catch (IOException ioE) {
            receiverLog.error("IOException",ioE);
            return false;
        }
    }

    private class HttpHelper {
        private JSONObject httpHelper(String uri) throws IOException {
            httpGet = new HttpGet(uri);
            httpResponse = httpClient.execute(httpGet);
            reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            sb = new StringBuilder();
            while ((responseLine = reader.readLine()) != null) {
                sb.append(responseLine);
            }
            jsonObject = new JSONObject(sb.toString());
            return jsonObject;
        }
    }
}
