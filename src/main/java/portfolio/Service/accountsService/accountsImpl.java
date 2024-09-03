package portfolio.Service.accountsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



@Service
public class accountsImpl implements accounts {


    @Autowired
    RestTemplate template;

    private final String url="http://localhost:8081/api/v1";




    @Override
    public Page<accounts> findAll(int pageNo) {

        HttpEntity<Page> result=template.getForEntity(url+"/getAllAccounts?page="+pageNo, Page.class);
        return result.getBody();
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<accounts> findById(String id) {
        // TODO Auto-generated method stub
        HttpEntity<Page> result=template.getForEntity(url+"/account/"+id, Page.class);
        return Optional.empty();
    }

    @Override
    public Page<accounts> paginatedfind(int pageNo) {
        // TODO Auto-generated method stub
        return null;
    }


    
    
}
