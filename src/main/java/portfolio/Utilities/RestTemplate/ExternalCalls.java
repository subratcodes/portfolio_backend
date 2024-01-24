package portfolio.Utilities.RestTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExternalCalls {


    @Bean
    public RestTemplate getTemmplate(){
        return new RestTemplate();
    }
    
}
