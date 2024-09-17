package portfolio.Service.UserDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import portfolio.Models.User;
import portfolio.Repository.UserRepository;

@Service
public class MongoUserDetails implements UserDetailsService {

    
      @Autowired
      UserRepository userRepo;  



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> info=userRepo.findByEmail(email);

        List<GrantedAuthority> authority=new ArrayList<GrantedAuthority>();
        
        System.out.println(info.toString());

        if(!info.isPresent()) throw new UsernameNotFoundException("Not valid credentials");

        User userInfo=info.get();
        authority.add(new SimpleGrantedAuthority(userInfo.getRole()));

        return new org.springframework.security.core.userdetails.User(userInfo.getEmail(),userInfo.getPassword(), authority);
    }

    
}
