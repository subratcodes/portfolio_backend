package portfolio.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import portfolio.Exceptions.ShipWreckException;
import portfolio.Models.Product;
import portfolio.Models.shipwrecks;
import portfolio.Service.ShipwreckService;
import portfolio.Response.ResponseTemplate;


@RestController
@RequestMapping(path="/api/v1/")
public class ShipWreckCtr {

    @Autowired 
    ShipwreckService shipWreckService;

    @GetMapping("/ping")
    public ResponseEntity<ResponseTemplate> test(){

        throw new ShipWreckException("testting");
        
    }

    @GetMapping("products")
    @ResponseBody
    public HttpEntity<List<shipwrecks>> productList(){

        return new HttpEntity<>(shipWreckService.findAll());
    }

    @GetMapping("/shipwrecks/count")
    public Long getCount(){
       return shipWreckService.count();
       
    }

    @GetMapping("shipwrecks/{id}")
    @ResponseBody
    public Optional<shipwrecks> findById(@PathVariable String id){
        return shipWreckService.findById(id); 
    }

    
}
