package healthcheckers;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by bartlomiej on 20.07.16.
 */
public class CoordinatesHealthCheck extends HealthCheck{
    private final int x,y;

    public CoordinatesHealthCheck(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    protected Result check() throws Exception {
        if(x==0||y==0)return Result.unhealthy("The coordinates cannot be 0");
        return Result.healthy();
    }
}
