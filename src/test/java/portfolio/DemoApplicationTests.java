package portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import portfolio.Service.ShipwreckService;
import portfolio.Service.ShipwreckServiceImpl;



@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {


	@Autowired
	MockMvc mvc;


	@Test
	@DisplayName("Context has been loaded")
	void contextLoads() {


	}

	@Test
	@DisplayName("Testing a simple controller")
	public void SimpleTest(){


		try {
			mvc.perform(MockMvcRequestBuilders.get("/api/v1/productsV2?page=0")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType("application/json"))
			.andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("latdec",isA(Integer.class)));
		
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());

		}
	}


	




}
