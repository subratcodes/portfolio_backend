package portfolio.Repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import portfolio.Models.shipwrecks;

@Repository
public interface ShipwreckRepository extends MongoRepository<shipwrecks,String> {


}
