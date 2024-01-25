package portfolio.Service;

import java.util.List;

import portfolio.Models.Externals.CatFacts;

public interface CatService {

    List<CatFacts> getFacts(String type);

    
}
