package portfolio.Service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import portfolio.Models.User;
import portfolio.Repository.UserRepository;


@Service
public class UserAccoutService {

    @Autowired
    UserRepository userRepo;


    @Autowired
    PasswordEncoder encoder;


    public boolean createUser(User newUser){

        // think about the validation that you would use.
        // what kind would it be. Note down your points.

        try {

            String email=newUser.getEmail();

            Optional<User> exist=userRepo.findByEmail(email);
            if(exist.isPresent()) return false;
            else{

                newUser.setPassword(encoder.encode(newUser.getPassword()));

                userRepo.insert(newUser);

                return true;

    
            }
 
            
        } catch (Exception e) {

           
            return false;

        }

        

    }


    public boolean doesUserExist(String email){

       Optional<User>user=userRepo.findByEmail(email);

        return user.isPresent();
    }

    public boolean deleteUser(User newUser){

        try {

            String email=newUser.getEmail();

            Optional<User> exist=userRepo.findByEmail(email);
            if(!exist.isPresent()) return false;
            else{

                userRepo.delete(newUser);

                return true;
    
            }
 
            
        } catch (Exception e) {

           
            return false;

        }


    }

    public List<User> getAllAccounts(){
       
        List<User> result=userRepo.findAll();
        return result;
    
    }

    
}
