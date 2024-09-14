package portfolio.Models.Samplemflix;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "theaters")
public class Theaters {

    @Id
    private String _id;
    private String theaterId;
    private Location location;
    
}
