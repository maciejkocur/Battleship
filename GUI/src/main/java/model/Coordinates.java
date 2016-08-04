package model;

import model.ship.Ship;

import java.util.ArrayList;
import java.util.List;

// This is a resource for coordinates
public class Coordinates {

    private int x,y,gameId,playerId;
    private Ship ship;

    private static Coordinates c= new Coordinates();

    public static Coordinates getCoordinates(){return c;}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List showCoordinates(){
        List coordinates = new ArrayList();
        coordinates.add(gameId);
        coordinates.add(playerId);
        coordinates.add(x);
        coordinates.add(y);


        return coordinates;
    }
}
