package portfolio.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import portfolio.Models.User;

import java.util.Optional;



@Repository
public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String email);
}



// Todo  ::: Why do we create our own query ovher here.
//Todo ::: Why do we use this as well.
