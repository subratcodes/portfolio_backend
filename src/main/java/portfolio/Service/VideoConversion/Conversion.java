package portfolio.Service.VideoConversion;

public interface Conversion {
    
    void upload() throws InterruptedException;
    void transform() throws InterruptedException;
    void distribute() throws InterruptedException;
    void notifyUser() throws InterruptedException;

}


