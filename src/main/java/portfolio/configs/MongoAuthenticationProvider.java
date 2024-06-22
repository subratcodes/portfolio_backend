package portfolio.configs;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import portfolio.Service.UserDetails.MongoUserDetails;

@Service
public class MongoAuthenticationProvider implements AuthenticationProvider {

    @Autowired
   private MongoUserDetails userDetails;


  private  PasswordEncoder encoder;

    @Autowired
    public MongoAuthenticationProvider( @Lazy BCryptPasswordEncoder encoder){
        this.encoder=encoder;
    }




    @Override
    public Authentication authenticate(Authentication authentication)
            throws org.springframework.security.core.AuthenticationException {

                // gets the password
                String email=authentication.getName();
                String password=authentication.getCredentials().toString();

              UserDetails user= userDetails.loadUserByUsername(email);

              return checkPassword(user,password);

        // TODO Auto-generated method stub
      
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return authentication.equals(UsernamePasswordAuthenticationToken.class);

    }

    private Authentication checkPassword(UserDetails storedUser, String rawPassword){

        
        if(encoder.matches(rawPassword, storedUser.getPassword())) return new UsernamePasswordAuthenticationToken(storedUser.getUsername(),storedUser.getPassword(),storedUser.getAuthorities());
        else  throw new BadCredentialsException("Bad credentials");


    }


    




    


    
}
