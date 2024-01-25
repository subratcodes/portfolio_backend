package portfolio.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import portfolio.Models.Externals.CatFacts;


@Service
public class CatServiceImpl implements CatService {

 @Autowired
    RestTemplate external;


    @Override
    public List<CatFacts> getFacts(String type) throws Error{
        try {
        System.out.println(type);
         ArrayList<CatFacts> result=external.getForObject("https://cat-fact.herokuapp.com/"+type,ArrayList.class);

        return result;
  
     } catch (Exception e) {
        // TODO: handle exception
        throw new Error(" Error communication with the cat facts");
         
     }
    }

    
}
