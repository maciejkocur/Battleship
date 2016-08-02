package resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import controller.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by bartlomiej on 20.07.16.
 */
@Path("/coordinate")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private final int playerID;
    private final int gameID;
    private final int x;
    private final int y;

    public MessageResource(int playerID,int gameID,int x,int y){
        this.playerID=playerID;
        this.gameID=gameID;
        this.x=x;
        this.y=y;
    }

    @POST
    @Timed
    public Message sendMessage(int playerID,int gameID,
                               int x,int y){
        return new Message(playerID,gameID,x,y);
    }

}
