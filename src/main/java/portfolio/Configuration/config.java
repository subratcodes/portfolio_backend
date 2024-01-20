package portfolio.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import portfolio.beans.Coach;

@Configuration
public class config {
    
    @Bean
    public Coach getCoach(){
        return new Coach("Wow", "Singh");
    }


}
