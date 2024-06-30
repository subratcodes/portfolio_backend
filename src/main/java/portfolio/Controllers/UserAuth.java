package portfolio.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.Models.User;
import portfolio.Response.ResponseTemplate;
import portfolio.Service.UserService.UserAccoutService;

import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path="/userAccounts/v1")
public class UserAuth {

    
    @Autowired
    UserAccoutService service;

    @PostMapping("/user")
    public ResponseTemplate createUser(@RequestBody User entity) {

        boolean newUserAdded=service.createUser(entity);

        if(newUserAdded) return new ResponseTemplate(HttpStatus.OK);
        else return new ResponseTemplate(HttpStatus.BAD_REQUEST);

        //TODO: process POST request
    
    }
    

}
