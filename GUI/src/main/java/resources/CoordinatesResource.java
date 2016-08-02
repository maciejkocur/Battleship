package resources;

import com.codahale.metrics.annotation.Timed;

import controller.Coordinates;
import model.Player;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * Created by bartlomiej on 20.07.16.
 */
@Path("/coordinates")
@Produces(MediaType.APPLICATION_JSON)
public class CoordinatesResource {

    private final int playerID;
    private final int gameID;
    private final int x;
    private final int y;

    public CoordinatesResource(int playerID, int gameID, int x, int y){
        this.playerID=playerID;
        this.gameID=gameID;
        this.x=x;
        this.y=y;
    }

    @POST
    @Timed
    public Coordinates sendMessage(int playerID, int gameID,
                                   int x, int y){
        return new Coordinates(playerID,gameID,x,y);
    }

}
