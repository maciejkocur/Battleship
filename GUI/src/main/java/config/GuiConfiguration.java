package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by bartlomiej on 20.07.16.
 */
public class GuiConfiguration extends Configuration {
    @NotEmpty
    private int x;

    @NotEmpty
    private int y;


    @NotEmpty
    private int playerID;

    @NotEmpty
    private int gameID;

    @JsonProperty
    public int getPlayerID() {
        return playerID;
    }
    @JsonProperty
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    @JsonProperty
    public int getGameID() {
        return gameID;
    }
    @JsonProperty
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }



    @JsonProperty
    public int getX(){
        return x;
    }

    @JsonProperty
    public void setX(int x){
        this.x=x;
    }

    @JsonProperty
    public int getY(){
        return y;
    }

    @JsonProperty
    public void setY(int y){
        this.y=y;
    }
}
