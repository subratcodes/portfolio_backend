package portfolio.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanManager {

    @Bean
    public Coach getCoach(){
        return new Coach("Test","123");
    }
    
}
