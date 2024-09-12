package portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import portfolio.configs.EnvionmentConfigs;



@EnableTransactionManagement
@SpringBootApplication
@EnableAsync
@EnableWebSecurity
public class DemoApplication implements CommandLineRunner {


	@Autowired
	private EnvionmentConfigs config;


	public static void main(String[] args) {
		 SpringApplication.run(DemoApplication.class, args);
	}



	@Override
	public void run(String...args) throws Exception{
		System.out.println("Command Line runs");
		System.out.println(config.toString());

	}

}
	