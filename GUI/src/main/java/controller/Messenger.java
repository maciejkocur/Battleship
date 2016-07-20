package controller;

import config.GuiConfiguration;
import healthcheckers.CoordinatesHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resources.MessageResource;

/**
 * Created by bartlomiej on 20.07.16.
 */
public class Messenger extends Application<GuiConfiguration>{

    protected int sendShootCoords(int a, int b){

        return a;
    }



    @Override
    public void run(GuiConfiguration guiConfiguration, Environment environment) throws Exception {
        final MessageResource resource = new MessageResource(guiConfiguration.getPlayerID(),guiConfiguration.getGameID(),
                guiConfiguration.getX(),guiConfiguration.getY());

        final CoordinatesHealthCheck healthCheck = new CoordinatesHealthCheck(guiConfiguration.getX(),guiConfiguration.getY());
        environment.healthChecks().register("x",healthCheck);
        environment.healthChecks().register("y",healthCheck);
        environment.jersey().register(resource);
    }
}
