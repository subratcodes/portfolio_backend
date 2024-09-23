package portfolio.Service.accountsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import portfolio.Models.Externals.accounts;


@Service
@Slf4j
public class accountsImpl implements accountServiceContract {


    @Autowired
    RestTemplate template;

    private final String url="http://localhost:8081/api/v1";


    @Override
    public Page<accounts> findAll(int pageNo) {
        //blocking call for the template.
        accountsResponse result=template.getForObject(url+"/getAllAccounts?page="+pageNo, accountsResponse.class);
        Page<accounts> result2=new PageImpl<>(result.getContent(), PageRequest.of(pageNo,10),result.getTotalElements());
        
        return result2;   

        
    }

    @Override
    public Optional<accounts> findById(String id) {
        HttpEntity<Page> result=template.getForEntity(url+"/account/"+id, Page.class);
        return Optional.empty();
    }

    @Override
    public Page<accounts> paginatedfind(int pageNo) {
        return null;
    }


    
    
}
