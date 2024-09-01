package portfolio.Controllers;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import portfolio.Models.User;
import portfolio.Response.ResponseTemplate;
import portfolio.Service.UserService.UserAccoutService;

import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping(path="/userAccounts/v1")
public class UserAuth {


    @Autowired
    UserAccoutService service;

    @PostMapping("/user")
    public ResponseTemplate createUser(@Valid @RequestBody UserCreationRequest entity) {

        try{
            // if the user does not exists.
            if(!service.doesUserExist(entity.getEmail())) throw new Exception("User exists already");

            SimpleGrantedAuthority authority=new SimpleGrantedAuthority("USER");

            User newUser=new User(entity.getEmail(),entity.getPassword());
            newUser.setAuthority(authority);

            boolean newUserAdded=service.createUser(newUser);

            if(newUserAdded) return new ResponseTemplate(HttpStatus.OK);
            else return new ResponseTemplate(HttpStatus.BAD_REQUEST);

        }catch (Exception e){
                log.error("Error in creating user"+e.getMessage());
                return new ResponseTemplate(HttpStatus.BAD_REQUEST);
        }

    }
    

}
