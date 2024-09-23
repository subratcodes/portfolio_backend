package portfolio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
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


	// @Autowired
	//  private ShipwreckRepository shipwreckRepository;
	 
	 
	 @Autowired
	 @Qualifier("sample_mflix_mongoTemplate")
	 private MongoTemplate template;



	public static void main(String[] args) {
		 SpringApplication.run(DemoApplication.class, args);
	}



	@Override
	public void run(String...args) throws Exception{


		List<Theaters> getTheators= theaterRepository.findAll();

		// log.info("The theator repo works");

	

		 getTheators.stream().limit(10).forEach( a->System.out.println(a.get_id()));

	//  List<Theaters> result=template.findAll(Theaters.class);

	//  result.stream().limit(10).forEach(a->System.out.println(a));

	}

}
	