package portfolio.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import portfolio.Exceptions.NoDataFound;
import portfolio.Exceptions.ShipWreckException;
import portfolio.Models.shipwrecks;
import portfolio.Models.Externals.CatFacts;
import portfolio.Response.CatFactsResTemplate;
import portfolio.Response.ResponseTemplate;
import portfolio.Service.ShipwreckService;


@RestController
@RequestMapping(path="/api/v1/")
public class ShipWreckCtr {

    @Autowired 
    ShipwreckService shipWreckService;


    @Autowired
    RestTemplate external;


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


    @GetMapping("cats/{type}")
    public List<CatFacts> getCatFacts(@PathVariable String type){

     try {
        System.out.println(type);
         ArrayList<CatFacts> result=external.getForObject("https://cat-fact.herokuapp.com/"+type,ArrayList.class);

        return result;
  
     } catch (Exception e) {
        // TODO: handle exception

         System.out.println(e.getLocalizedMessage());
         return null; 
     }

       

    }

    @GetMapping("shipwrecks/{id}")
    @ResponseBody
    public shipwrecks findById(@PathVariable String id) throws Exception{

        Optional<shipwrecks> info=shipWreckService.findById(id);
        if(info.isPresent()) return info.get();

        throw new NoDataFound("Not found with id");
        
    }

    
}
