package portfolio.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import portfolio.Models.User;

import java.util.Optional;

import javax.swing.text.html.Option;
import java.util.List;



@Repository
public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String email);
}
