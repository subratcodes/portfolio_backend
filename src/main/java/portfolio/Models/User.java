package portfolio.Models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import com.mongodb.lang.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Document("User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @MongoId
    private String id;
    private String userName;
    private String password;
    @NonNull
    private String email;
    @NonNull
    String role="user";
    
}
