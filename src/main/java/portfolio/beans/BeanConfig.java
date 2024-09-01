package portfolio.beans;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanConfig {

    @Bean
    public Coach getCoach(){
        return new Coach("Subrat","Singh");
    }

}
