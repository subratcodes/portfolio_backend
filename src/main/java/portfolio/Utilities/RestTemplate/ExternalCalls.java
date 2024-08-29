package portfolio.Utilities.RestTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ExternalCalls {

    public SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
    
        SimpleClientHttpRequestFactory clientHttpRequestFactory  = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(10_000);
        clientHttpRequestFactory.setReadTimeout(10_000);


    return clientHttpRequestFactory;
}



    @Bean
    public RestTemplate getTemmplate(){
        return new RestTemplate(getClientHttpRequestFactory());
    }

    @Bean
    public WebClient getClient(){
        
        return WebClient.create();
    }
    
}
