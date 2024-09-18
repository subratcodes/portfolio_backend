package portfolio.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import static java.util.Collections.singletonList;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.internal.MongoClientImpl;

import lombok.extern.slf4j.Slf4j;
import portfolio.Models.Samplemflix.Theaters;
import portfolio.Repository.ShipwreckRepository;
import portfolio.Repository.Samplemflix.TheaterRepository;



@Configuration
@Slf4j
//@EnableMongoRepositories(basePackageClasses =TheaterRepository.class, mongoTemplateRef = "sample_mflix_mongoTemplate")
@EnableConfigurationProperties
public class SampleFlixConfig {


  // these beans are responsible for creating the mongo properties for the connection strin g.

  @Bean(name="sample_mflix_connection_properties")
  @ConfigurationProperties(prefix = "mongo.samplemflix")
  
  public MongoProperties properties(){
    return new MongoProperties();
  }



  // this creates a mongo client which is then used by the mongo facotry database.

@Bean("sample_mflix_client")
  public MongoClient mongoClient(@Qualifier("sample_mflix_connection_properties") MongoProperties mongoProperties){

    //         MongoCredential credential = MongoCredential.createCredential(mongoProperties.getUsername(), mongoProperties.getAuthenticationDatabase(), mongoProperties.getPassword());
    //         MongoClients.create()
    //  return MongoClients.create(MongoClientSettings.builder()
    //       .applyToClusterSettings(builder -> builder.hosts(singletonList(new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort()))))
    //       .credential(credential)
    //       .build());

    return MongoClients.create(properties().getUri());


  }


  // This creates a mongo database factor which is then used to crate a mongo template.\
  
  @Bean(name = "sample_mflix_databaseFactory")
  public MongoDatabaseFactory mongoDatabaseFactory(@Qualifier("sample_mflix_client") MongoClient mongoClient, @Qualifier("sample_mflix_connection_properties") MongoProperties mongoProperties) {
      return new SimpleMongoClientDatabaseFactory(mongoClient, mongoProperties.getDatabase());
  }


  @Bean(name="sample_mflix_mongoTemplate")
  public MongoTemplate createTemplate(@Qualifier("sample_mflix_databaseFactory") MongoDatabaseFactory factory ){
    return new MongoTemplate(factory);
  }



}
