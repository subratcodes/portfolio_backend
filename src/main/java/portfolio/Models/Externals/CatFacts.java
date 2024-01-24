package portfolio.Models.Externals;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CatFacts {
    
    private String _id;
    private String user;
    private String text;
    private String source;
    private String updatedAt;
    private String type;
    private String createdAt;
    private boolean deleted;
    private boolean used;


}
