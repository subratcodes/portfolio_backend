package portfolio.Exceptions;


public class NoDataFound extends RuntimeException  {

    public NoDataFound(String message){
        super(message);
    }

    public NoDataFound(String message, Throwable cause){
        super(message,cause);

    }
    
}
