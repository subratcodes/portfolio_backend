package portfolio;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import portfolio.Models.shipwrecks;
import portfolio.Repository.ShipwreckRepository;

import java.util.Optional;


@SpringBootTest
public class RepoTest {


    @Mock
    ShipwreckRepository shipwreckRepository;


    @DisplayName("Find Shipwreck ID")
    @Test
    public void testFindMethods(){

        String id="578f6fa3df35c7fbdbaeda06a";

        Optional<shipwrecks>  result= shipwreckRepository.findById(id);

       Assertions.assertEquals(true,result.isPresent(), "Result should be present");

    }






}
