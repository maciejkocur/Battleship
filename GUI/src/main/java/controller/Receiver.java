package controller;


import model.Player;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bartlomiej on 04.08.16.
 */
public class Receiver {

    public Boolean wasShot(){
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("tutaj bedzie url", Boolean.class);
    }

    public Player whoseTurn(){
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("tutaj bedzie url", Player.class);
    }

    public Boolean isInitialized(){
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("tutaj bedzie url", Boolean.class);
    }
}
