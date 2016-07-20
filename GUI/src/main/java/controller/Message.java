package controller;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bartlomiej on 20.07.16.
 */
public class Message {

    private int playerID;



    private int gameID;

    private int x;
    private int y;

    public Message(){}

    public Message(int playerID,int gameID,int x,int y){

    }

    @JsonProperty
    public int getPlayerID(){
        return playerID;
    }
    @JsonProperty
    public int getGameID() {
        return gameID;
    }
    @JsonProperty
    public int getX() {
        return x;
    }
    @JsonProperty
    public int getY() {
        return y;
    }
}
