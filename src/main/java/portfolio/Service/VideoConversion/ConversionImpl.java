package portfolio.Service.VideoConversion;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class ConversionImpl implements Conversion {

    @Async("videoConversionExecutor")
    @Override
    public CompletableFuture<String> distribute() throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000L);
        System.out.println("distribution has been done"+Thread.currentThread().getName());
        return CompletableFuture.completedFuture("distribute");
    }

    @Override
    @Async("videoConversionExecutor")
    public CompletableFuture<String> notifyUser() throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000L);
        System.out.println("notify user has been done"+Thread.currentThread().getName());
         return CompletableFuture.completedFuture("noitify");
      
    }

    @Override
    @Async("videoConversionExecutor")
    public CompletableFuture<String> transform()throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000L);
        System.out.println("transform has been done"+Thread.currentThread().getName());
        return CompletableFuture.completedFuture("transfornm");
       
    }

    @Override
    @Async("videoConversionExecutor")
    public CompletableFuture<String> upload()throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000L);
        System.out.println("Uload has been done"+Thread.currentThread().getName());
      return  CompletableFuture.completedFuture("upload");
       
    }

    
    
}
