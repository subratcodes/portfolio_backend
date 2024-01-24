package portfolio.Response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import portfolio.Models.Externals.CatFacts;

@Getter
@Setter
@AllArgsConstructor
public class CatFactsResTemplate {
    
    private List<CatFacts> facts;
    


}
