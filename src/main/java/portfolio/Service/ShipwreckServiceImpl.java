package portfolio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import portfolio.Models.shipwrecks;
import portfolio.Repository.PaginatedShiprwreck;
import portfolio.Repository.ShipwreckRepository;



@Service
public class ShipwreckServiceImpl implements ShipwreckService {

    @Autowired
    ShipwreckRepository repo;

    @Autowired
    PaginatedShiprwreck paginatedRepo;
    
    @Override
    public long count(){
        return repo.count();

    }

    @Override
    public List<shipwrecks> findAll(){

       return repo.findAll();
        
    }

    @Override
    public Page<shipwrecks> findPaginatedData(int pageNo){
     
        Pageable pageable = PageRequest.of(pageNo,10);

         return repo.findAll(pageable);

    }


    @Override
    public Optional<shipwrecks> findById(String id){
        
        return repo.findById(id);
    }

    @Override
    @Transactional
    public shipwrecks performShipTransaction(String id) {

        try {

           boolean result=repo.existsById(id);
           if(!result) throw new Error("Could not find out id");

           Optional<shipwrecks> shipData= findById(id);
           
           if(shipData.isPresent()){

             repo.insert(new shipwrecks());


           }else throw new Error("Ship Data is not present");


        } catch (Exception e) {
            // TODO: handle exception




        }

        // TODO Auto-generated method stub
        return null;
    }

    

    
}
