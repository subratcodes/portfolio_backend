package portfolio.Response;

import org.springframework.http.HttpStatusCode;
import java.util.List;


public class AccountsResponse<T> {
    
    HttpStatusCode code;
    String message;
    Boolean isError;
    List<T> data;

}
