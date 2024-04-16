package portfolio.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import portfolio.Models.shipwrecks;


@Repository
public interface PaginatedShiprwreck extends PagingAndSortingRepository<shipwrecks,String> {


}
