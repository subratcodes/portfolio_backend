package portfolio.mock.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import portfolio.Models.shipwrecks;
import portfolio.Repository.PaginatedShiprwreck;
import portfolio.Repository.ShipwreckRepository;
import portfolio.Service.Shipwreck.ShipwreckService;
import portfolio.Service.Shipwreck.ShipwreckServiceImpl;

import org.springframework.data.domain.PageRequest;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ShipWreckServiceTests {


@Mock
private ShipwreckRepository repository;


@Mock
private PaginatedShiprwreck paginatedData;


    @InjectMocks
    private ShipwreckServiceImpl shipwreckService;


    @Test
    @DisplayName("Conting Shipwrecks")
    public void countShipWrecks(){

        // what we are mocking over here is the repo layer. and we are returning repo repsonse .reather than not calling the repo.

            when(repository.count()).thenReturn(Long.valueOf(2006));

            Long count=shipwreckService.count();

        Assertions.assertEquals(count,2006,"Shipwreck count test failed");


    }


    @Test
    public void findShipwreckData(){

        Pageable pag= PageRequest.of(0,10);

        when(paginatedData.findAll(pag)).thenReturn(new PageImpl(Collections.EMPTY_LIST,pag,10));

        Page<shipwrecks> result=shipwreckService.findPaginatedData(0);

        Assertions.assertEquals(0,result.getTotalPages(), "Elements should be equal");


    }








}
