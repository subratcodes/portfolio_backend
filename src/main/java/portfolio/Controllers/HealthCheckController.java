package portfolio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import portfolio.Health.DatabaseHealth;

public class HealthCheckController {

    @Autowired
    DatabaseHealth health;


    
    public Health getMongoHealth(){
        return health.health();
    }


    
}
