package portfolio.Controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import portfolio.Response.ResponseTemplate;

@RequestMapping("api/v1/mock/error")
public class ErrorMockController {

    
    @GetMapping("/serverError")
    public ResponseEntity<ResponseTemplate> mockServerError(){

        ResponseTemplate result=ResponseTemplate.builder().error("Server Error").build();

        return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(result);
        

    }
    
}
