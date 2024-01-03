package portfolio.Controllers;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.Models.Product;
import java.util.List;


@RestController
@RequestMapping(path="/api/v1/")
public class restInfo {

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


    
}
