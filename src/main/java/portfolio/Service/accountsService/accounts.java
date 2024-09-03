package portfolio.Service.accountsService;

import org.springframework.data.domain.Page;
import java.util.Optional;

import java.util.List;


public interface accounts {

    Page<accounts> findAll(int pageNo);

    Optional<accounts> findById(String id);

    Page<accounts> paginatedfind(int pageNo);
    

}
