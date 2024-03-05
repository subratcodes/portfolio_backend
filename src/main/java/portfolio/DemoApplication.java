package portfolio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


	public static void main(String[] args) {
			 SpringApplication.run(DemoApplication.class, args);
			 
	}

	@Override
	public void run(String...args) throws Exception{
		System.out.println("Command Line runs");


		

	}

}
	