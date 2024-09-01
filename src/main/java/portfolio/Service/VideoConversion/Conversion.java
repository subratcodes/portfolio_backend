package portfolio.Service.VideoConversion;

import java.util.concurrent.CompletableFuture;

public interface Conversion {
    
    CompletableFuture<String> upload() throws InterruptedException;
    CompletableFuture<String> transform() throws InterruptedException;
    CompletableFuture<String> distribute() throws InterruptedException;
    CompletableFuture<String> notifyUser() throws InterruptedException;

}


