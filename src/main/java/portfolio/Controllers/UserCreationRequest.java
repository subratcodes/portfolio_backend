package portfolio.Controllers;


import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import portfolio.Models.User;

@Setter
@Getter
public class UserCreationRequest {

    @NotEmpty(message = "password cannot be empty")
    @NotNull(message="Password fields are missing")
    private String password;
    @NotEmpty(message = "password cannot be empty")
    @NotNull(message="Password fields are missing")
    private String email;
    private String role;

}
