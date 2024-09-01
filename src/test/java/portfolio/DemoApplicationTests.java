package portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {



	}

	@Test
	void runAddTest(){
		int res=6;
		int val=sum(2,4);

		Assertions.assertEquals(res,val,"result is wrong.");
	}

	@DisplayName("Checkes the null values")
	@Test
	void checkNullValues(){
		String val= null;
		String value="2";
		Assertions.assertNull(val,"Value should be null");
		Assertions.assertNotNull(value, " Value should not be null");
	}

	public int sum(int a, int b){
		return a+b;
	}

}
