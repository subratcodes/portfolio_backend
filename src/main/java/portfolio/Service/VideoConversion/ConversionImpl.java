package portfolio.Service.VideoConversion;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



@Service
public class ConversionImpl implements Conversion {

    @Async("videoConversionExecutor")
    @Override
    public void distribute() throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000L);
        System.out.println("distribution has been done"+Thread.currentThread().getName());
       
    }

    @Override
    @Async("videoConversionExecutor")
    public void notifyUser() throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000L);
        System.out.println("notify user has been done"+Thread.currentThread().getName());
      
    }

    @Override
    @Async("videoConversionExecutor")
    public void transform()throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000L);
        System.out.println("transform has been done"+Thread.currentThread().getName());
       
    }

    @Override
    @Async("videoConversionExecutor")
    public void upload()throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000L);
        System.out.println("Uload has been done"+Thread.currentThread().getName());
       
    }

    
    
}
