package controller;

import model.Coordinates;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartlomiej on 04.08.16.
 */
public class Sender {

    private static void sendCoordinates(){
        Coordinates coord = Coordinates.getCoordinates();
        final String uri = "this will be the url";

        List coordinates = new ArrayList();
        coordinates.add(coord.getGameId());
        coordinates.add(coord.getPlayerId());
        coordinates.add(coord.getX());
        coordinates.add(coord.getY());

        RestTemplate rest = new RestTemplate();

        rest.postForObject(uri,coordinates, ArrayList.class);
    }

    private static void sendShip(){
        final String uri = "url+ship";

        RestTemplate rest = new RestTemplate();

        //rest.postForObject(uri, ship, Ship.class);
    }

    
}
