package portfolio.Controllers;
import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import portfolio.Models.Product;
import portfolio.Models.shipwrecks;
import portfolio.Service.ShipwreckService;


@RestController
@RequestMapping(path="/api/v1/")
public class ShipWreckCtr {

    @Autowired 
    ShipwreckService shipWreckService;



    @GetMapping("/ping")
    @ResponseBody
    public HttpEntity<String> test(){

        return new HttpEntity<>("hello Wolrd");
    }

    @GetMapping("products")
    @ResponseBody
    public HttpEntity<List<Product>> productList(){

        return new HttpEntity<>(null);
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
