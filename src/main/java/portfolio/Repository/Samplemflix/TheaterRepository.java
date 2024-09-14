package portfolio.Repository.Samplemflix;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import portfolio.Models.Samplemflix.Theaters;


@Repository
public interface TheaterRepository extends MongoRepository<Theaters,String>{

}


