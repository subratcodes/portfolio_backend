package portfolio.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.mongodb.lang.NonNull;

@Document("User")
@Getter
@Setter
@AllArgsConstructor
public class User {
    @MongoId
    private String id;
    private String userName;
    private String password;
    @NonNull
    private String email;
}
