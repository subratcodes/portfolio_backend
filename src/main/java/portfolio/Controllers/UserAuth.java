package portfolio.Controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.Models.User;
import portfolio.Service.UserService;
import java.util.Optional;

@RestController
@RequestMapping(path="/auth/v1")
public class UserAuth {

    UserService userService;

    public UserAuth(UserService service){
        this.userService=service;
    }


    @PostMapping("/createUser")
    public ResponseEntity<String> login(@RequestBody User user) {

       Optional<User> result=userService.createUser(user);

       if(result.isPresent()) {
          return new ResponseEntity<>(HttpStatus.ACCEPTED);
       }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


//    @GetMapping("/user")
//    public ResponseEntity<String> getUser(@RequestBody User user) {
//
//        Optional<User> result=userService.getUserByUsername(user.getUserName());
//
//        if(result.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//    }




}
