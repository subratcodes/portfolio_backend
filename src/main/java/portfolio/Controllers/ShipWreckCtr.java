package portfolio.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import portfolio.Exceptions.NoDataFound;
import portfolio.Exceptions.ShipWreckException;
import portfolio.Models.shipwrecks;
import portfolio.Response.ResponseTemplate;
import portfolio.Service.ShipwreckService;


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
    public shipwrecks findById(@PathVariable String id) throws Exception{

        Optional<shipwrecks> info=shipWreckService.findById(id);
        if(info.isPresent()) return info.get();

        throw new NoDataFound("Not found with id");
        
    }

    
}
