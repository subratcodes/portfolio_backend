package portfolio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import portfolio.Models.shipwrecks;

public interface ShipwreckService {

    long count();

    List<shipwrecks> findAll();

    Optional<shipwrecks> findById(String id);

    public shipwrecks performShipTransaction(String id);

    Page<shipwrecks> findPaginatedData(int pageNo);

    
}


