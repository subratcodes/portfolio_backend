package portfolio.Health;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.data.mongo.MongoHealthIndicator;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;



@Component
public class DatabaseHealth implements HealthIndicator {

    private MongoTemplate template;

   public DatabaseHealth(MongoTemplate template){
    this.template=template;

   }


   public boolean checkHealth(){
    Document result = this.template.executeCommand("{ isMaster: 1 }");
    if(result.containsKey("maxWire")) return true;
    else return false;

   }

    @Override
    public Health health(){
       
        if(checkHealth()) return Health.up().build();
        else return Health.down().build();
  
        // if(){
        //     return Health.up().withDetail("Health is good", getClass()).build();
        // }else return health().down().withDetail("health Down", getClass()).build();
    }
    
}