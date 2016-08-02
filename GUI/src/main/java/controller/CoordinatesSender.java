package controller;

import config.CoordinatesConfiguration;
import healthcheckers.CoordinatesHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resources.CoordinatesResource;

/**
 * Created by bartlomiej on 20.07.16.
 */
public class CoordinatesSender extends Application<CoordinatesConfiguration>{
    
    @Override
    public void run(CoordinatesConfiguration coordinatesConfiguration, Environment environment) throws Exception {
        final CoordinatesResource resource = new CoordinatesResource(coordinatesConfiguration.getPlayerID(), coordinatesConfiguration.getGameID(),
                coordinatesConfiguration.getX(), coordinatesConfiguration.getY());

        final CoordinatesHealthCheck healthCheck = new CoordinatesHealthCheck(coordinatesConfiguration.getX(), coordinatesConfiguration.getY());
        environment.healthChecks().register("x",healthCheck);
        environment.healthChecks().register("y",healthCheck);
        environment.jersey().register(resource);
    }
}
