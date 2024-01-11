package portfolio.Exceptions;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import portfolio.Response.ResponseTemplate;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ShipWreckException.class})
    public ResponseEntity<ResponseTemplate> handleShipWreckError(ShipWreckException e){
        
     ResponseTemplate result=new ResponseTemplate(HttpStatus.BAD_REQUEST, e.getMessage(),new ArrayList<Integer>(), null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);

    }



    
}
