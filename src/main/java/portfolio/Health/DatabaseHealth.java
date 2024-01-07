package portfolio.Health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;


@Controller
public class DatabaseHealth implements HealthIndicator {


    private static final String DB_SERVICE="Mongo Service Up";


    private boolean isHealthGood(){
        return true;
    }

    @Override
    public Health health(){
        if(isHealthGood()){
            return Health.up().withDetail("Health is good", getClass()).build();
        }else return health().down().withDetail("health Down", getClass()).build();
    }
    
}