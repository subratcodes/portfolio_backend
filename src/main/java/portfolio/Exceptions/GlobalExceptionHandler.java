package portfolio.Exceptions;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import portfolio.Response.ResponseTemplate;

@ControllerAdvice
public class GlobalExceptionHandler {


   private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ShipWreckException.class}) //why do we use this ? why do we take this ?
    public ResponseEntity<ResponseTemplate> handleShipWreckError(ShipWreckException e){
        
     ResponseTemplate result=new ResponseTemplate(HttpStatus.BAD_REQUEST, e.getMessage(),new ArrayList<Integer>(), null);
        
     logger.error("Error Caused in the ship format");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);  

    }

    @ExceptionHandler({NoDataFound.class})
    public ResponseEntity<ResponseTemplate> handleNoDataFound(NoDataFound err){

        ResponseTemplate result=new ResponseTemplate(HttpStatus.BAD_REQUEST, err.getMessage(),new ArrayList<Integer>(), null);
         return ResponseEntity.status(result.getStatus()).body(result);

    }



    
}
