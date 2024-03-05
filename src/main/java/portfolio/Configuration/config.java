package portfolio.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import portfolio.beans.Coach;

@Configuration
@EnableAsync
public class config {
    

    @Bean("videoConversionExecutor")
    public Executor taskExecutor(){

        ThreadPoolTaskExecutor executor= new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setQueueCapacity(120);
        executor.setMaxPoolSize(10);
        executor.setThreadNamePrefix("Custom task being performed");
        executor.initialize();
        return executor;


    }

    


}
