package portfolio;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import portfolio.Service.Shipwreck.ShipwreckService;
import portfolio.Service.Shipwreck.ShipwreckServiceImpl;


@SpringBootTest

public class BasicTest {

    @Mock
    private ShipwreckService service;


    @InjectMocks
    private ShipwreckServiceImpl shipService;


    @DisplayName("test the shipwreck service call")
    @Test
    public void test(){





    }




}
