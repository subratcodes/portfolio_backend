package portfolio.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import portfolio.Exceptions.NoDataFound;
import portfolio.Exceptions.ShipWreckException;
import portfolio.Models.shipwrecks;
import portfolio.Models.Externals.CatFacts;
import portfolio.Response.ResponseTemplate;
import portfolio.Service.CatService;
import portfolio.Service.ShipwreckService;
import portfolio.Service.CoachService.CoachServiceContract;
import portfolio.Service.VideoConversion.Conversion;
import portfolio.beans.Coach;



@RestController
@RequestMapping(path="/api/v1")
public class ShipWreckCtr {

    @Autowired 
    ShipwreckService shipWreckService;

    @Autowired
    CatService catService;

    @Autowired
    Conversion convert;

   @Autowired
   CoachServiceContract coachService;

    @GetMapping("/coach")
    public String getMethodName() {
        return coachService.getData();
    }


    @GetMapping("/ping")
    public ResponseEntity<ResponseTemplate> test(){

        throw new ShipWreckException("testting");
        
    }

    @GetMapping("/products")
    public HttpEntity<List<shipwrecks>> productList(@RequestParam("page") int pageNo){

        return new HttpEntity<>(shipWreckService.findAll());
    }

    @GetMapping("/productsV2")
    public Page<shipwrecks> findPaginated(@RequestParam("page") int pageNo){
        return shipWreckService.findPaginatedData(pageNo);
    }

    @GetMapping("/shipwrecks/count")
    public Long getCount(){

       return shipWreckService.count();
       
    }

    @PostMapping("/videoConverter")
    public ResponseEntity<String> performConversion(){

        try {
            convert.upload();
            convert.transform();
            convert.distribute();
            convert.notify();

            return  new ResponseEntity<>("Hello World!", HttpStatus.OK);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());

            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    
    }


    @GetMapping("cats/{type}")
    public List<CatFacts> getCatFacts(@PathVariable String type){

        return catService.getFacts(type);
    }

    @GetMapping("/shipwrecks/{id}")
    @ResponseBody
    public shipwrecks findById(@PathVariable String id) throws Exception{

        Optional<shipwrecks> info=shipWreckService.findById(id);
        if(info.isPresent()) return info.get();

        throw new NoDataFound("Not found with id");
        
    }

    
}
