package portfolio.Service;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import portfolio.Models.Externals.CatFacts;


@Service
public class CatServiceImpl implements CatService {

    @Autowired
    RestTemplate external;


    String url="https://cat-fact.herokuapp.com/";



    @Override
      public List<CatFacts> getFactsviaWebClient(String type) {
         // TODO Auto-generated method stub
         return null;
      }



   @Override
    public List<CatFacts> getFacts(String type) throws Error{
        try {

         
        System.out.println(type);
        Map<String,String> map=getBody();

        org.springframework.http.HttpHeaders header=new org.springframework.http.HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> entity= new HttpEntity<>(null,header);

         ResponseEntity<ArrayList> result=external.exchange(url,HttpMethod.GET,entity,ArrayList.class);
        return result.getBody();
  
     } catch (Exception e) {
        // TODO: handle exception
        throw new Error(" Error communication with the cat facts");
         
     }
    }



    public Map<String,String> getBody(){
         
      Map<String,String> map=new HashMap<String,String>();
    return map;

    }

    
}
