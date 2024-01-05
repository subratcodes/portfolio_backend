package portfolio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portfolio.Models.shipwrecks;
import portfolio.Repository.ShipwreckRepository;

@Service
public class ShipwreckServiceImpl implements ShipwreckService {

    @Autowired
    ShipwreckRepository repo;

    @Override
    public long count(){
        return repo.count();

    }

    @Override
    public List<shipwrecks> findAll(){
        return repo.findAll();
    }


    @Override
    public Optional<shipwrecks> findById(String id){
        return repo.findById(id);
    }

    
}
