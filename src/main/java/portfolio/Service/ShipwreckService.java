package portfolio.Service;

import java.util.List;
import java.util.Optional;

import portfolio.Models.shipwrecks;

public interface ShipwreckService {

    long count();

    List<shipwrecks> findAll();

    Optional<shipwrecks> findById(String id);

    
}
