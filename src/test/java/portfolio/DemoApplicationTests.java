package portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import portfolio.Service.ShipwreckService;
import portfolio.Service.ShipwreckServiceImpl;


class DemoApplicationTests {



	ShipwreckService service=new ShipwreckServiceImpl();




	@Test
	@DisplayName("Context has been loaded")
	void contextLoads() {


	}

	@Test
	@DisplayName("shipwreck_service_count")
	public void testCount(){
		 long count=service.count();

		 assertEquals(244,count);
	
	
	
		}



}
