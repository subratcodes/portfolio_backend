package portfolio.Service;

import portfolio.Models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> createUser(User user);
    Optional<User> getUserByUsername(String username);
}
