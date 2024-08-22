package portfolio.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;


import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;


public class ClientError extends DefaultResponseErrorHandler {

     @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        try {

            HttpStatusCode statusCode=response.getStatusCode();

            return true;
   
            
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException   
 {
    HttpStatusCode statusCode = response.getStatusCode();

        if (statusCode.is4xxClientError()){

            
            // Handle client error
        } else if (statusCode.is5xxServerError()) {
            // Handle server error
        } else {
            super.handleError(response);
        }
    }



    
}
