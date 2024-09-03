package portfolio.Models.Externals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class accounts {

    private String id;
    private int account_id;
    private int limit;
    private String[] products;
    
}
