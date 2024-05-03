package portfolio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portfolio.Models.User;
import portfolio.Repository.UserRepository;
import java.util.Optional;


@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> createUser(User user) {

        if(getUserByUsername(user.getUserName()).isEmpty()){

            user.setPassword(passwordEncoder.encode(user.getPassword()));
                User result=userRepository.save(user);
            return Optional.of(result);

        }

        return Optional.empty();

    }

    @Override
    public Optional<User> getUserByUsername(String username) {

            Optional<User> result=userRepository.findByUserName(username);
            if(result.isEmpty()) return Optional.empty();
            else return result;
    }
}
