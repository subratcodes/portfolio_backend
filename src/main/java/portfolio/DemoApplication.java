package portfolio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;
import portfolio.Models.shipwrecks;
import portfolio.Models.Samplemflix.Theaters;
import portfolio.Repository.ShipwreckRepository;
import portfolio.Repository.Samplemflix.TheaterRepository;
import portfolio.configs.EnvionmentConfigs;



@EnableTransactionManagement
@SpringBootApplication
@EnableAsync
@Slf4j
@EnableWebSecurity
public class DemoApplication implements CommandLineRunner {


	@Autowired
	private EnvionmentConfigs config;

	@Autowired
	private TheaterRepository  theaterRepository;


	@Autowired
	 private ShipwreckRepository shipwreckRepository; 



	public static void main(String[] args) {
		 SpringApplication.run(DemoApplication.class, args);
	}



	@Override
	public void run(String...args) throws Exception{

		log.info("The theator repo works");

		List<shipwrecks> getTheators= shipwreckRepository.findAll();

		getTheators.stream().limit(10).forEach( a->System.out.println(a.get_id()));


	}

}
	