package portfolio.Service.accountsService;

import org.springframework.data.domain.Page;

import portfolio.Models.Externals.accounts;

import java.util.Optional;

import java.util.List;


public interface accountServiceContract {

    Page<accounts> findAll(int pageNo);

    Optional<accounts> findById(String id);

    Page<accounts> paginatedfind(int pageNo);
    

}
